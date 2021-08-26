package vacation.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import vacation.dao.AbstractDao;
import vacation.dao.EmployeeDao;
import vacation.exception.DataProcessingException;
import vacation.model.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee> implements EmployeeDao {
    protected EmployeeDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    public Employee get(Long id) {
        try (Session session = factory.openSession()) {
            return session.get(Employee.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Could not get Employee by id: " + id, e);
        }
    }

    @Override
    public List<Employee> getAll() {
        try (Session session = factory.openSession()) {
            Query<Employee> query = session.createQuery("from Employee", Employee.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Could not get all Employees", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.delete(session.get(Employee.class, id));
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Could not delete Employee by id: "
                    + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Employee getByNames(String name, String lastName) {
        try (Session session = factory.openSession()) {
            Query<Employee> query = session.createQuery("from Employee e where e.name = :name and"
                    + " e.lastName = :lastName", Employee.class);
            query.setParameter("name", name);
            query.setParameter("lastName", lastName);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Could not get Employee by name: " + name
                    + " and last name: " + lastName, e);
        }
    }
}
