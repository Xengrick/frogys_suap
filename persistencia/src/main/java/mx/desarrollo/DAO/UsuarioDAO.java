/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.DAO;
import mx.desarrollo.entidad.Usuario;
import mx.desarrollo.persistencia.AbstractDAO;
import mx.desarrollo.entidad.Usuario;
import mx.desarrollo.persistencia.AbstractDAO;
import java.util.List;
import mx.desarrollo.persistencia.HibernateUtil;
import org.hibernate.Query;
/**
 *
 * @author FabianOMX
 */
public class UsuarioDAO extends AbstractDAO<Integer, Usuario> {

    public UsuarioDAO() {
        super();
        setEntityClass(Usuario.class);
    }

    /**
     * Buscar un Usuario por su nombre .
     * @param nombreUsuario Nombre del usuario.
     * @return Usuario encontrado.
     */
    public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        System.out.println("*** Buscar Usuario por Nombre de Usuario ***");
        Usuario usuario = null;
        
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            
            String hql = "FROM Usuario u WHERE u.usuario = :nombreUsuario";
            Query query = HibernateUtil.getSession().createQuery(hql);
            query.setParameter("nombreUsuario", nombreUsuario);
            usuario = (Usuario) query.uniqueResult();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            System.out.println("Error al buscar Usuario por nombre\n: " + e);
        } finally {
            HibernateUtil.closeSession();
        }
        return usuario;
    }

    /**
     * Buscar Usuarios por su rol.
     * @param rol Rol de los usuarios (ej. "ADMIN", "PROFESOR").
     * @return Lista de usuarios con el rol especificado.
     */
    public List<Usuario> buscarPorRol(String rol) {
        System.out.println("*** Buscar Usuarios por Rol ***");
        List<Usuario> usuarios = null;
        
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            
            String hql = "FROM Usuario u WHERE u.rol = :rol";
            Query query = HibernateUtil.getSession().createQuery(hql);
            query.setParameter("rol", rol);
            usuarios = query.list();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            System.out.println("Error al buscar Usuarios por rol: " + e);
        } finally {
            HibernateUtil.closeSession();
        }
        return usuarios;
    }

    /**
     * Actualizar la contraseña de un Usuario.
     * @param idUsuario ID de Usuario.
     * @param nuevaContrasena nueva contraseña de usuario.
     */
    public void actualizarContrasena(int idUsuario, String nuevaContrasena) {
        System.out.println("*** Actualizar Contraseña de Usuario ***");
        
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            
            String hql = "UPDATE Usuario u SET u.contrasena = :nuevaContrasena WHERE u.idUsuario = :idUsuario";
            Query query = HibernateUtil.getSession().createQuery(hql);
            query.setParameter("nuevaContrasena", nuevaContrasena);
            query.setParameter("idUsuario", idUsuario);
            query.executeUpdate();
            
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            System.out.println("Error al actualizar la contraseña del Usuario: " + e);
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /**
     * Eliminar un Usuario por su ID.
     * @param idUsuario ID del Usuario.
     */
    public void eliminarUsuarioPorId(int idUsuario) {
        System.out.println("*** Eliminar Usuario ***");
        
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            
            Usuario usuario = find(idUsuario);
            if (usuario != null) {
                delete(usuario);
                HibernateUtil.commitTransaction();
            }
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            System.out.println("Error al eliminar el Usuario: " + e);
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
