/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.persistencia;

/**
 *
 * @author saitbc
 */
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import mx.desarrollo.persistencia.InterfaceDAO;
import java.util.List;
//import mx.avanti.siract.dao.InterfaceDAO;
import org.hibernate.SQLQuery;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.transform.Transformers;

/**
 * Generic abstract class avoid to extends another DAO for make generic methods
 * with the other DAO
 *
 * @param <PK>
 * @param <T>
 */
public abstract class AbstractDAO<PK extends Serializable, T> implements InterfaceDAO<T> {

    //private Session session;
    //private Transaction tx;
    private Class<T> entityClass;

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstractDAO() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        //HibernateFactory.buildIfNeeded();
    }

    @Override
    public void saveOrUpdate(T obj) {
        System.out.println("SaveOrUpdate ----------");
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            HibernateUtil.getSession().saveOrUpdate(obj);

        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public void save(T obj) {
        System.out.println("Save ----------");
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            HibernateUtil.getSession().save(obj);

        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

     @Override
    public void update(T obj) {
        System.out.println("update ----------");
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            HibernateUtil.getSession().update(obj);

        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }
    
    @Override
    public void delete(T obj) {
        System.out.println("Delete ----------");
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            HibernateUtil.getSession().delete(obj);

        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.commitTransaction();
            HibernateUtil.closeSession();
        }
    }

    @Override
    public T find(Integer id) {
        System.out.println("Find ----------");
        Object obj = null;
        ClassMetadata catMeta = HibernateUtil.getSessionFactory().getClassMetadata(entityClass);
        String identificador = catMeta.getIdentifierPropertyName();

        String nombre = entityClass.getSimpleName();
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            obj = HibernateUtil.getSession().createQuery("from " + nombre
                    + " as " + nombre.toLowerCase() + " where " + nombre.toLowerCase() + "." + identificador + " = :id").setString("id", String.valueOf(id)).uniqueResult();
        } catch (Exception x) {
            HibernateUtil.rollbackTransaction();
        } finally {

            HibernateUtil.closeSession();
        }
        return (T) obj;

    }

    @Override
    public List<T> findAll() {
        System.out.println("FindAll ----------");
        List<T> objects = null;
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            Query query = HibernateUtil.getSession().createQuery("from " + entityClass.getName());
            objects = query.list();

        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return objects;
    }

    @Override
    public List<T> executeQuery(String query) {
        System.out.println("ExecuteQuery ----------");
        List<T> result = null;
            
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            //System.out.println("ABSTRACTDAO linea 161:"+entityClass.getCanonicalName());
            result = (List<T>)HibernateUtil.getSession().createSQLQuery(query).addEntity(entityClass.getCanonicalName()).list();
            
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        System.out.println("RESULTADO DE LA VARIABLE result EN ABSTRACTDAO 166:"+result);
        return result;
    }
    
    @Override
    public List<Object[]> executeQueryObjects(String query) {
        System.out.println("ExecuteQueryObjects ----------");
        List<Object[]> result = null;

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            result = HibernateUtil.getSession().createSQLQuery(query).list();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    @Override
    public void executeUpdate(String query) {
        System.out.println("ExecuteUpdate ----------");
        // ClassMetadata catMeta = HibernateUtil.getSessionFactory().getClassMetadata(getTipo());
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            HibernateUtil.getSession().createSQLQuery(query).executeUpdate();
        } catch (HibernateException x) {
            System.out.println("" + x);
        } finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public T executeQueryUnique(String query) {
        System.out.println("ExecuteQueryUnique ----------");
        T result = null;

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            result = (T) HibernateUtil.getSession().createSQLQuery(query).addEntity(entityClass.getCanonicalName()).uniqueResult();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    @Override
    public T executeQueryNoEntityUnique(String query) {
        System.out.println("ExecuteQueryNoENtityUnique ----------");
        T result = null;

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            result = (T) HibernateUtil.getSession().createSQLQuery(query).uniqueResult();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    @Override
    public List<T> executeQueryNoEntity(String query) {
        System.out.println("ExecuteQueryNoEntity ----------");
        List<T> result = null;

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            result = HibernateUtil.getSession().createSQLQuery(query).list();
        } catch (HibernateException x) {

            System.out.println("" + x);
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    @Override
    public List<Object[]> executeNoEntity(String query) {
        System.out.println("ExecuteNoEntity ----------");
        List<Object[]> result = null;

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            result = HibernateUtil.getSession().createSQLQuery(query).list();
        } catch (HibernateException x) {
            System.out.println("" + x);
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    @Override
    public T findByOneParameterUnique(String value, String identificador) {
        System.out.println("FindByOneParameterUnique ----------");
        T result = null;

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            String nombre = entityClass.getSimpleName();
            result = (T) HibernateUtil.getSession().createQuery("from " + nombre
                    + " as " + nombre.toLowerCase() + " where " + nombre.toLowerCase() + "." + identificador + " = :id").setString("id", String.valueOf(value)).uniqueResult();

        } catch (HibernateException x) {
            System.out.println("" + x);
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    @Override
    public List<T> findByOneParameter(String value, String identificador) {
        System.out.println("FindByOneParameter ----------");
        List<T> result = null;
        String nombre = entityClass.getSimpleName();

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            result = HibernateUtil.getSession().createQuery("from " + nombre
                    + " as " + nombre.toLowerCase() + " where " + nombre.toLowerCase() + "." + identificador + " = :id").setString("id", String.valueOf(value)).list();
            System.err.println("Listo");
        } catch (HibernateException x) {
            System.out.println("" + x);
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    @Override
    public List<T> findByOneNotParameter(String value, String identificador) {
        System.out.println("FindByOneNotParameter ----------");
        List<T> result = null;
        String nombre = entityClass.getSimpleName();

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            result = HibernateUtil.getSession().createQuery("from " + nombre
                    + " as " + nombre.toLowerCase() + " where " + nombre.toLowerCase() + "." + identificador + " <> :id").setString("id", String.valueOf(value)).list();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    @Override
    public List<T> findByOneParameterOrder(String value, String identificador, Boolean asc) {
        System.out.println("FindByOneParameterOrder ----------");
        List<T> result = null;
        String nombre = entityClass.getSimpleName();

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            ClassMetadata catMeta = HibernateUtil.getSession().getSessionFactory().getClassMetadata(entityClass);
            if (asc) {
                result = HibernateUtil.getSession().createQuery("from " + nombre
                        + " as " + nombre.toLowerCase() + " where " + nombre.toLowerCase() + "." + identificador + " = :id order by " + catMeta.getIdentifierPropertyName() + " asc").setString("id", String.valueOf(value)).list();
            } else {
                result = HibernateUtil.getSession().createQuery("from " + nombre
                        + " as " + nombre.toLowerCase() + " where " + nombre.toLowerCase() + "." + identificador + " = :id order by " + catMeta.getIdentifierPropertyName() + " desc").setString("id", String.valueOf(value)).list();

            }
            System.err.println("Listo");
        } catch (HibernateException x) {
            System.out.println("" + x);
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    //Procedures
    @Override
    public List<T> executeProcedure(String procedure, String[] names, String... param) {
        System.out.println("ExecuteProcedure ----------");
        List<T> result;
        HibernateUtil.getSession();
        HibernateUtil.beingTransaccion();
        SQLQuery lQuery = HibernateUtil.getSession().createSQLQuery(procedure).addEntity(entityClass);
        for (int i = 0; i < param.length; i++) {
            lQuery.setParameter(names[i], param[i]);
        }
        result = lQuery.list();
        return result;
    }

//    public void executeProcedureCall() {
//        HibernateUtil.getSession();
//        HibernateUtil.beingTransaccion();
//
//        ProcedureCall call = HibernateUtil.getSession().createStoredProcedureCall("testing", Arts.class);
//        
//
//    }
    @Override
    public T executeProcedureOne(String procedure, String[] names, String... param) {
        System.out.println("ExecuteProcedureOne ----------");
        T result;
        HibernateUtil.getSession();
        HibernateUtil.beingTransaccion();
        SQLQuery lQuery = HibernateUtil.getSession().createSQLQuery(procedure).addEntity(entityClass);

        for (int i = 0; i < param.length; i++) {
            lQuery.setParameter(names[i], param[i]);
        }
        result = (T) lQuery.uniqueResult();
        return result;
    }

    @Override
    public int executeProcedureInt(String procedure, String[] names, String... param) {
        System.out.println("ExecuteProcedureInt ----------");
        BigInteger result = null;
        HibernateUtil.getSession();
        HibernateUtil.beingTransaccion();
        SQLQuery lQuery = HibernateUtil.getSession().createSQLQuery(procedure);
        for (int i = 0; i < param.length; i++) {
            lQuery.setParameter(names[i], param[i]);
        }
        result = (BigInteger) lQuery.uniqueResult();
        return result.intValue();
    }

    @Override
    public int executeCountQuery(String query) {
        System.out.println("ExecuteCountQuery ----------");
        BigInteger result = null;

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            result = (BigInteger) HibernateUtil.getSession().createSQLQuery(query).uniqueResult();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return result.intValue();
    }

    @Override
    public int executeCountQueryDouble(String query) {
        System.out.println("ExecuteCountQueryDouble ----------");
        int result = 0;

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            Double aux = (Double) HibernateUtil.getSession().createSQLQuery(query).uniqueResult();
            if (aux != null) {
                result = aux.intValue();
            }
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    @Override
    public int executeCountQueryFloat(String query) {
        System.out.println("ExecuteCOuntQueryFloat ----------");
        int result = 0;

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            Float aux = (Float) HibernateUtil.getSession().createSQLQuery(query).uniqueResult();
            if (aux != null) {
                result = aux.intValue();
            }
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    @Override
    public T executeTransformationUniqueQuery(String query, String... param) {
        System.out.println("transformation query ----------");
        T result = null;

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            SQLQuery lQuery = HibernateUtil.getSession().createSQLQuery(query);

            for (int i = 0; i < param.length; i++) {
                lQuery.addScalar(param[i]);
            }

            result = (T) lQuery.setResultTransformer(Transformers.aliasToBean(entityClass)).uniqueResult();

        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    @Override
    public List<T> executeTransformationQuery(String query, String... param) {
        System.out.println("transformation query ----------");
        List<T> result = null;

        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();

            SQLQuery lQuery = HibernateUtil.getSession().createSQLQuery(query);

            for (int i = 0; i < param.length; i++) {
                lQuery.addScalar(param[i]);
            }

            result = lQuery.setResultTransformer(Transformers.aliasToBean(entityClass)).list();

        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return result;
    }
    
  
}
