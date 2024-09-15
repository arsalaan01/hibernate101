package org.geekmozo.dao;

import org.geekmozo.entities.Book;
import org.geekmozo.hibernateconfig.HibernateUtilJConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDao {

    public void saveBook(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateUtilJConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Book> getBooks() {
        try (Session session = HibernateUtilJConfig.getSessionFactory().openSession()) {
            return session.createQuery("FROM Book", Book.class).list();
        }
    }

    public void updateBook(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateUtilJConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteBook(Long bookId) {
        Transaction transaction = null;
        try (Session session = HibernateUtilJConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Book book = session.get(Book.class, bookId);
            if (book != null) {
                session.delete(book);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Book getBook(Long bookId) {
        try (Session session = HibernateUtilJConfig.getSessionFactory().openSession()) {
            return session.get(Book.class, bookId);
        }
    }
}
