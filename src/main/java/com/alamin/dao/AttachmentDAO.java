package com.alamin.dao;

import com.alamin.model.Attachment;
import com.alamin.model.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AttachmentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Long insert(Attachment attachment) {

        Session session = sessionFactory.getCurrentSession();

        try {
            return (Long) session.save(attachment);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();

        return null;
    }

    public void insertList(List<Attachment> attachments) {
        Session session = sessionFactory.getCurrentSession();
        try {
            attachments.forEach(session::save);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }

    public Attachment getById(Long id) {
        Attachment attachment = null;
        Session session = sessionFactory.getCurrentSession();

        try {
            attachment = session.get(Attachment.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();

        return attachment;
    }


}
