package edu.yang.persistence;

import edu.yang.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * projectDao object
 * @author Lee Yang
 */
public class ProjectDao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory;

    /**
     * projectDao arg constructor
     * @param type
     */
    public ProjectDao(Class<T> type) {
        this.type = type;
    }

    /**
     * gets sessionFactory
     * @return sessionFactory
     */
    public Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * gets an entity by its id
     * @param id
     * @return a entity
     */

    public <T>T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }


    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        session.close();
    }

    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    public T getByProperty(String property) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(property);
        query.where(builder.like(propertyPath, property));
        T entity = session.createQuery( query ).getSingleResult();
        session.close();
        return entity;
    }

    /**
     * gets a list of cards with similar names
     * @param property
     * @return cards list of cards with similar names
     */
    public List<T> getAllByProperty(String property) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(property);
        query.where(builder.like(propertyPath, "%" + property + "%"));
        List<T> list = session.createQuery( query ).getResultList();
        session.close();
        return list;
    }
}