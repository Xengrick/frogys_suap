package mx.desarrollo.persistencia;

import org.hibernate.HibernateException;
import org.hibernate.ResourceClosedException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleStateException;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 *
 * @author emmanuelle
 * @version ThreadSafe checked September 29-2015
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final ThreadLocal<Session> threadSession = new ThreadLocal<>();
    private static final ThreadLocal<Transaction> threadTransaccion = new ThreadLocal<>();

    private static SessionFactory buildSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            StandardServiceRegistryBuilder.destroy(registry);

            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        Session s = (Session) threadSession.get();
        try {
            if (s == null) {
                s = sessionFactory.openSession();
                
                threadSession.set(s);
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return s;
    }

    public static void closeSession() {
        // TODO Buscar solucion a error de Hikari al cerrar sesión.
        try {
            Session s = (Session) threadSession.get();
            threadSession.set(null);
            if (s != null && s.isOpen()) {
                s.flush();
                s.close();
            }
        } catch (StaleStateException ex) { //TEMPORAL_FIX:Se agrego este catch para evitar error producido por le manejo del Hikari

            System.err.println("MSG:" + ex.getMessage());
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }

    public static void beingTransaccion() {
        Transaction tx = (Transaction) threadTransaccion.get();
        try {
            if (tx == null) {
                tx = getSession().beginTransaction();
                threadTransaccion.set(tx);
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }

    public static void commitTransaction() {
        Transaction tx = (Transaction) threadTransaccion.get();
        try {
            if (tx != null && !tx.getStatus().isOneOf(TransactionStatus.COMMITTED) && !tx.getStatus().isOneOf(TransactionStatus.ROLLED_BACK)) {

                tx.commit();

                threadTransaccion.set(null);
            }
        } catch (ResourceClosedException exception) {
            System.err.println("MSG:" + exception.getMessage());
        } catch (HibernateException ex) {
            rollbackTransaction();
            ex.printStackTrace();
        }
    }

    public static void rollbackTransaction() {
        Transaction tx = (Transaction) threadTransaccion.get();
        try {
            threadTransaccion.set(null);
            if (tx != null && !tx.getStatus().isOneOf(TransactionStatus.COMMITTED) && !tx.getStatus().isOneOf(TransactionStatus.ROLLED_BACK)) {
                tx.rollback();
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

    }
}
