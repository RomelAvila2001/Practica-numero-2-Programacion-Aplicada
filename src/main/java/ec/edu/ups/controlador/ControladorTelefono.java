/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Telefono;

/**
 *
 * @author NANCY
 */
public class ControladorTelefono extends Controlador<Telefono> {

    @Override
    public boolean validar(Telefono obj) {
        return true;
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
