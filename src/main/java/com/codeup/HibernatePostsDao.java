package com.codeup;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Patrick on 1/6/17.
 */
public class HibernatePostsDao implements Posts {

    private Session session;

    public HibernatePostsDao(Session session) {
        this.session = session;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Post> findAll() {
        return session.createQuery("from Post").list();
    }

    @Override
    public void save(Post post) {
        Transaction tx = session.beginTransaction();
        session.save(post);
        tx.commit();
    }

    @Override
    public Post findMessage(long id) {
        return (Post) session.createQuery("from Post where id = :id")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public void update(Post existingPost) {
        Transaction tx = session.beginTransaction();
        session.save(existingPost);
        tx.commit();
    }

    @Override
    public void deleteMessage(long id) {
        Transaction tx = session.beginTransaction();
        session.delete(findMessage(id));
        tx.commit();
    }
}
