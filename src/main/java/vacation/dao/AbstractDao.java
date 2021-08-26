package vacation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vacation.exception.DataProcessingException;

public abstract class AbstractDao<T> implements GenericDao<T> {
    protected final SessionFactory factory;

    protected AbstractDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public T add(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Could not save " + entity.getClass().getSimpleName()
                    + "entity " + entity, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public T update(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Could not update "
                    + entity.getClass().getSimpleName() + "entity " + entity, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
