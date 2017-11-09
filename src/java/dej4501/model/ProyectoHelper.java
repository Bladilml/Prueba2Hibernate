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
public class ProyectoHelper {
    
    Session session = null;
    
    public ProyectoHelper(){
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Proyecto> getAll(){
        
        List<Proyecto>lista=null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("from Proyecto");
            lista=(ArrayList<Proyecto>)q.list();
            tx.commit();
        } catch (Exception e) {
            Logger.getLogger(ProyectoHelper.class.getName()).log(Level.SEVERE,"Accion no pudo realizarse: (0) ",e.toString());
        }
        return lista;
    }
    
    
}
