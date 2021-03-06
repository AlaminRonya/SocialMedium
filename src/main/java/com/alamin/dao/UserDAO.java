package com.alamin.dao;

import com.alamin.model.Location;
import com.alamin.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    LocationDAO locationDAO;



    public Long insert(User user) {
        Long id = -1L;
        Session session = sessionFactory.getCurrentSession();

        try {
            id = (Long) session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();

        return id;
    }

    public User getById(Long id) {
//        User user = sessionFactory.getCurrentSession().get(User.class, id.toString());
        User user = new User();
        Session session = sessionFactory.getCurrentSession();

        try {
            Query query = session.createQuery("SELECT u FROM User u WHERE u.id = :id").setParameter("id", id);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
        return user;
    }

    public Long update(User user) {
        Long id = -1L;
        Session session = sessionFactory.getCurrentSession();

        try {
            session.saveOrUpdate(user);
            id = user.getId();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();

        return id;
    }

    public Long delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id.toString());

        session.delete(user);
        session.flush();

        return id;
    }

//    public List<User> getAll(){
//        Query query = sessionFactory.getCurrentSession().createQuery("FROM User", User.class);
//        List<User> userList = query.list();
//
//        return userList;
//    }

//    public List<User> getAllByLocationId(Long locationId) {
//        List<User> userList = sessionFactory.getCurrentSession().createQuery("FROM User WHERE locationId = :locationId", User.class).setParameter("locationId", locationId).list();
//        return userList;
//    }



}
