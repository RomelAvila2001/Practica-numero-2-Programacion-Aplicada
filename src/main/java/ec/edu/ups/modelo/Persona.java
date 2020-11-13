/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author NANCY
 */
public class Persona {
    private String cedula;
    private int codigo;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private List<Telefono> listaTelefonos;

    public Persona(String cedula) {
        this.cedula = cedula;
    }

    public Persona(String cedula, int codigo, String nombre, String apellido, String correo, String contraseña) {
        this.cedula = cedula;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        
        listaTelefonos = new ArrayList<>();
    }

    public Persona(String cedula, int codigo, String nombre, String apellido, String correo, String contraseña, List<Telefono> listaTelefonos) {
        this.cedula = cedula;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.listaTelefonos = listaTelefonos;
    }

    public Persona(List<Telefono> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }

    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }

    public void setListaTelefonos(List<Telefono> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }
    
    public void agregarTelefono(Telefono telefono){
        this.listaTelefonos.add(telefono);
    }
    
    public Telefono buscarTelefono(String numero){
        return this.listaTelefonos.stream().filter(t -> t.getNumero().equals(numero)).findFirst().get();
    }
    
    public void actualizarTelefono(Telefono telefono){
        var telefonoCambiar = listaTelefonos.stream().filter(t -> t.getCodigo() == telefono.getCodigo()).findFirst().get();
        int index = listaTelefonos.indexOf(telefonoCambiar);
        listaTelefonos.remove(telefonoCambiar);
        listaTelefonos.add(index, telefono);
        
    }
    
    public void eliminarTelefono(int codigo){
        var telefonoEliminar = listaTelefonos.stream().filter(telefono -> telefono.getCodigo() == codigo).findFirst().get();
        listaTelefonos.remove(telefonoEliminar);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "cedula=" + cedula + ", codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + ", listaTelefonos=" + listaTelefonos + '}';
    }
}
