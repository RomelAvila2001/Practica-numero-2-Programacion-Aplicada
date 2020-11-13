/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Persona;
import java.util.List;

/**
 *
 * @author NANCY
 */
public class ControladorPersona extends Controlador<Persona> {

    @Override
    public boolean validar(Persona obj) {
        if(obj.getCedula().length()== 10){
            return true;
        }
        return false;
    }
    
   public Persona iniciarSesion(String correo, String contrase) {
        for (var usuario : (List<Persona>) findAll()) {
            if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contrase)) {
                return usuario;
            }
        }
        return null; 
   }

    @Override
    public int cargarCodigo() {
        if (findAll().size() > 0) {
            return findAll().size() + 1;
        } else {
            return 1;
        }
    }
   
}
