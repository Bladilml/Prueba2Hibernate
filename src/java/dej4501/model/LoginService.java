/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dej4501.model;

import dej4501.srvs.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author durib
 */
public class LoginService {
    Session session = null;

    public LoginService() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Usuarios getUserByName(String name){
        Usuarios usuario = null;
        
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("from Usuarios where username=:param1");
            q.setString("param1", name);
            usuario = (Usuarios) q.uniqueResult();
            tx.commit();            
        } catch (Exception ex){
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, "no se puede consultar la BD:{0}", ex.toString());
        }
        
        return usuario;
    }
    
    public boolean existsUser(String user) {
        return (getUserByName(user)!=null);
    }

    /**
     * Una vez validado que existe el usuario
     *
     * @param user
     * @param password
     * @return
     */
    public boolean validateUser(String user, String password) {
        try {
            Usuarios usuario = getUserByName(user);
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean resultado = passwordEncoder.matches(password, usuario.getPassword());
            return (resultado);
        } catch (HibernateException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, "no se puede consultar la BD:{0}", ex.toString());
            return false;
        }
    }
    
    public void close(){
        session.close();
    }
}
