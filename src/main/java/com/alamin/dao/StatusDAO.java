package com.alamin.dao;

import com.alamin.model.Status;
import com.alamin.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatusDAO {
    @Autowired
    private SessionFactory sessionFactory;


    public Long insert(Status status) {

        Session session = sessionFactory.getCurrentSession();

        try {
            return  (Long) session.save(status);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();

        return null;
    }
    public Status getById(Long id) {
        Status status = new Status();
        Session session = sessionFactory.getCurrentSession();

        try {
            Query query = session.createQuery("SELECT s FROM Status s WHERE s.id = :id").setParameter("id", id);
            status = (Status) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
        return status;
    }

    public Long delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Status status = session.load(Status.class, id.toString());

        session.delete(status);
        session.flush();

        return id;
    }

    public List<Status> getAll(){
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT s FROM Status s", Status.class);
        List<Status> statusList = query.list();

        return statusList;
    }


}
