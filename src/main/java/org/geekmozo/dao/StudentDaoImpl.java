package org.geekmozo.dao;

import org.geekmozo.entities.Student;
import org.geekmozo.hibernateconfig.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDaoImpl implements StudentDao{

    @Override
    public void registerStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Student authenticateStudent(Student student) {
        return null;
    }
}
