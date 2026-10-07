package vasavicom.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();

            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            Student student = new Student(
                    1,
                    "Vasavi",
                    "vasavi@gmail.com",
                    "Artificial Intelligence and Data Science"
            );

            session.persist(student);

            transaction.commit();

            System.out.println("=================================");
            System.out.println("Student inserted successfully!");
            System.out.println("=================================");
            System.out.println(student);

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();

        } finally {

            if (session != null) {
                session.close();
            }

            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}