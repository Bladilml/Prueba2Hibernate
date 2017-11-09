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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Victor
 */
public class ComunasHelper {
            Session session=null;
    
    public ComunasHelper(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
      public List<Comunas> getAllByProvinciaId(int provinciaId) {
        List<Comunas> lista = null;

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("from Comunas where provincia_id=:param1");
            q.setParameter("param1", provinciaId);
            lista = (ArrayList<Comunas>) q.list();
            tx.commit();
            //session.close();
        } catch (HibernateException ex) {
            Logger.getLogger(RegionesHelper.class.getName()).log(Level.SEVERE, "Error al obtener todas las regiones:{0}", ex.toString());
        }

        return lista;
    }
    
    
    public Comunas getEspecialidadById(int id){
        Comunas Comunas = null;
        
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("From Comunas where Comuna_id=;param1");
        } catch(Exception e){
            
        }
        return Comunas;
    }
    public Comunas getEspecialidadByRegion(int id){
        Comunas Comunas = null;
        
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("From Comunas where region_id=;param1");
        } catch(Exception e){
            
        }
        return Comunas;
    }
}
