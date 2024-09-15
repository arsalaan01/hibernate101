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
    public Student authenticateStudent(String username, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Student student = null;
        try {
            student = (Student) session.createQuery("FROM Student WHERE username = :username AND password = :password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return student;
    }
}
