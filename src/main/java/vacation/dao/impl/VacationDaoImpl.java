package vacation.dao.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import vacation.dao.AbstractDao;
import vacation.dao.VacationDao;
import vacation.exception.DataProcessingException;
import vacation.model.Vacation;

@Repository
public class VacationDaoImpl extends AbstractDao<Vacation> implements VacationDao {
    public VacationDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    public Vacation get(Long id) {
        try (Session session = factory.openSession()) {
            return session.get(Vacation.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Could not get Vacation by id: " + id, e);
        }
    }

    @Override
    public List<Vacation> getAll() {
        try (Session session = factory.openSession()) {
            CriteriaQuery<Vacation> query = session.getCriteriaBuilder()
                    .createQuery(Vacation.class);
            query.from(Vacation.class);
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Could not get all Vacation", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.delete(session.get(Vacation.class, id));
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Could not delete Vacation by id: "
                    + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Vacation> getByEmployee(String name, String lastName) {
        try (Session session = factory.openSession()) {
            Query<Vacation> query = session.createQuery("from Vacation v "
                    + "where v.employee.name = :name"
                    + " and v.employee.lastName = :lastName", Vacation.class);
            query.setParameter("name", name);
            query.setParameter("lastName", lastName);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Could not get Vacation by Employee name: "
                    + name + " and last name: " + lastName, e);
        }
    }
}
