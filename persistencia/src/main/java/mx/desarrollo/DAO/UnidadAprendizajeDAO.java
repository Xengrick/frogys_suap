/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.DAO;
import java.util.HashSet;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.persistencia.AbstractDAO;
import java.util.List;
import java.util.Set;
import mx.desarrollo.persistencia.HibernateUtil;
import org.hibernate.Query;
/**
 *
 * @author FabianOMX
 */
public class UnidadAprendizajeDAO extends AbstractDAO<Integer, UnidadAprendizaje>{
    public UnidadAprendizajeDAO(){
        super();
        setEntityClass(UnidadAprendizaje.class);
        
    }
    
    
    /**
     * Buscar Unidad de aprendizaje por su nombre
     * @param nombre -> Nombre de la Unidad de Aprendizaje
     * @return Unidad por nombre
     */
    public List<UnidadAprendizaje> buscarNombre(String nombre){
        System.out.println(" *** Buscar pr Nombre ***");
        List<UnidadAprendizaje> unidadAprendizaje = null;
        
        try{
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            
            String hql = "FROM UnidadAprendizaje u WHERE u.nombre = :nombre";
            Query query = HibernateUtil.getSession().createQuery(hql);
            query.setParameter("nombre", nombre);
            unidadAprendizaje = query.list();
            
        }catch (Exception e){
            HibernateUtil.rollbackTransaction();
            System.out.println("Error al encotrar la Unidad de Aprendizaje\n: " + e);
        }finally{
            HibernateUtil.closeSession();
        }
        return unidadAprendizaje;
    }
    
    /**
     * Actualizar las horas de clase, taller o lab
     * @param idUnidadAprendizaje 
     * @param horasClase
     * @param horasTaller
     * @param horasLaboratorio
     */
    public void actualizarHoras(int idUnidadAprendizaje, Integer horasClase, Integer horasTaller, Integer horasLaboratorio) {
    System.out.println("*** Actualizar Horas de UnidadAprendizaje ***");

    StringBuilder hql = new StringBuilder("UPDATE Unidadaprendizaje u SET ");
    boolean setClauseAdded = false;

    // consulta dependiendo de qué campos no sean nulos
    if (horasClase != null) {
        hql.append("u.horasClase = :horasClase");
        setClauseAdded = true;
    }
    if (horasTaller != null) {
        if (setClauseAdded) hql.append(", ");
        hql.append("u.horasTaller = :horasTaller");
        setClauseAdded = true;
    }
    if (horasLaboratorio != null) {
        if (setClauseAdded) hql.append(", ");
        hql.append("u.horasLaboratorio = :horasLaboratorio");
    }

    hql.append(" WHERE u.idUnidadAprendizaje = :idUnidadAprendizaje");

    try {
        HibernateUtil.getSession();
        HibernateUtil.beingTransaccion();

        Query query = HibernateUtil.getSession().createQuery(hql.toString());
        if (horasClase != null) {
            query.setParameter("horasClase", horasClase);
        }
        if (horasTaller != null) {
            query.setParameter("horasTaller", horasTaller);
        }
        if (horasLaboratorio != null) {
            query.setParameter("horasLaboratorio", horasLaboratorio);
        }
        query.setParameter("idUnidadAprendizaje", idUnidadAprendizaje);
        query.executeUpdate();

        HibernateUtil.commitTransaction();
    } catch (Exception e) {
        HibernateUtil.rollbackTransaction();
        System.out.println("Error al actualizar las horas de la UnidadAprendizaje: " + e);
    } finally {
        HibernateUtil.closeSession();
    }
}
    
    /**
     * Eliminar UnidadAprendizaje por ID
     * @param idUnidadAprendizaje
     */
    public void eliminarUnidadAprendizajeID(int idUnidadAprendizaje){
        System.out.println("*** Eliminar Unidad Aprendizaje ***");
        
        try{
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            
            UnidadAprendizaje unidad = find(idUnidadAprendizaje);
            if(unidad != null){
                delete(unidad);
                HibernateUtil.commitTransaction();
            }
        }catch (Exception e){
            HibernateUtil.rollbackTransaction();
            System.out.println("Error al eliminar la unidad de Aprendizaje\n"+ e);
        }finally{
            HibernateUtil.closeSession();
        }
    }
    /**
     * Obtener todas las Unidades de Aprendizaje.
     * @return Lista de todas las Unidades de Aprendizaje.
     */
    public List<UnidadAprendizaje> obtenerTodasLasUnidades() {
        System.out.println("*** Obtener Todas las UnidadesAprendizaje ***");
        List<UnidadAprendizaje> unidades = null;
        
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            
            Query query = HibernateUtil.getSession().createQuery("FROM Unidadaprendizaje");
            unidades = query.list();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            System.out.println("Error al obtener todas las UnidadesAprendizaje: " + e);
        } finally {
            HibernateUtil.closeSession();
        }
        return unidades;
    }
    
  
    
    
    
     
    /*Otra consulta public void actualizarHoras(int idUnidadAprendizaje, int horasClase, int horasTaller, int horasLaboratorio) {
    System.out.println("*** Actualizar Horas de UnidadAprendizaje ***");

    try {
        HibernateUtil.getSession();
        HibernateUtil.beingTransaccion();

        String hql = "UPDATE Unidadaprendizaje u SET u.horasClase = :horasClase, u.horasTaller = :horasTaller, u.horasLaboratorio = :horasLaboratorio WHERE u.idUnidadAprendizaje = :idUnidadAprendizaje";
        Query query = HibernateUtil.getSession().createQuery(hql);
        query.setParameter("horasClase", horasClase);
        query.setParameter("horasTaller", horasTaller);
        query.setParameter("horasLaboratorio", horasLaboratorio);
        query.setParameter("idUnidadAprendizaje", idUnidadAprendizaje);
        query.executeUpdate();

        HibernateUtil.commitTransaction();
    } catch (Exception e) {
        HibernateUtil.rollbackTransaction();
        System.out.println("Error al actualizar las horas de la UnidadAprendizaje: " + e);
    } finally {
        HibernateUtil.closeSession();
    }
}
*/
    
}
