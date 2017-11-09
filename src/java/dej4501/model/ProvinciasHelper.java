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
public class ProvinciasHelper {
        Session session=null;
    
    public ProvinciasHelper(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Provincias> getAllByRegionId(int regionId){
        List<Provincias> lista = null;

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("from Provincias where region_id=:param1");
            q.setParameter("param1", regionId);
            lista = (ArrayList<Provincias>) q.list();
            tx.commit();
            //session.close();
        } catch (HibernateException ex) {
            Logger.getLogger(RegionesHelper.class.getName()).log(Level.SEVERE, "Error al obtener todas las regiones:{0}", ex.toString());
        }

        return lista;
    }
    
       public List<Provincias> getAll() {
        List<Provincias> lista = null;

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("from Provincias");
            lista = (ArrayList<Provincias>) q.list();
            tx.commit();
            //session.close();
        } catch (HibernateException ex) {
            Logger.getLogger(ProvinciasHelper.class.getName()).log(Level.SEVERE, "Error al obtener todas las Provincias:{0}", ex.toString());
        }

        return lista;
    } 
    public Provincias getProvinciasById(int id){
        Provincias provincias = null;
        
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("From Provincias where provincia_id=;param1");
        } catch(Exception e){
            
        }
        return provincias;
    }
    public Provincias getProvinciasByRegion(int id){
        Provincias provincias = null;
        
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("From Provincias where id_Regiones=;param1");
        } catch(Exception e){
            
        }
        return provincias;
    }
}
