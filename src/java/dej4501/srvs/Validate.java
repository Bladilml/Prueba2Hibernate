/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dej4501.srvs;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author hmoraga
 */
public class Validate {
    public static boolean validarNotEmpty(String texto){
        if (texto==null)
            return false;
        return (texto.trim().length() != 0);
    }
    
    public static Integer validarInt(String texto){
        Integer resultado = null;
        try{
            resultado = Integer.parseInt(texto);
        } catch (NumberFormatException ex){
            Logger.getLogger(Validate.class.getName()).log(Level.WARNING, "texto no es un entero:{0}", texto);
        }
        return resultado;
    }
    
    public static boolean validarIguales(String texto1, String texto2){
        return (texto1.equals(texto2));
    }
}
