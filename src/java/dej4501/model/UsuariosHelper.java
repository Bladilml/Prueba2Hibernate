/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dej4501.model;
import dej4501.srvs.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Victor
 */
public class UsuariosHelper {
    Session session = null;
    
    public UsuariosHelper(){
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Usuarios> getAll(){
        
        List<Usuarios>lista=null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("from Usuarios");
            lista=(ArrayList<Usuarios>)q.list();
            tx.commit();
        } catch (Exception e) {
            Logger.getLogger(ProyectoHelper.class.getName()).log(Level.SEVERE,"Accion no pudo realizarse: (0) ",e.toString());
        }
        return lista;
    }

    public Usuarios getUsuariosById(int id){
        Usuarios usuarios = null;
        
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("From Usuarios where id=;param1");
        } catch (Exception e) {
        Logger.getLogger(UsuariosHelper.class.getName()).log(Level.SEVERE,"Transaccion no pudo realizarse: (0) ",e.toString());
        }
        return usuarios;
    }

    public boolean crearUsuario(Usuarios newUser) {
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Integer id = (Integer)session.save(newUser);
            tx.commit();
            return (id!=0);
        } catch (Exception ex){
            Logger.getLogger(UsuariosHelper.class.getName()).log(Level.SEVERE, "No se pudo agregar usuario a la BD:{0}", ex.toString());
            return false;
        }
    }
    
}