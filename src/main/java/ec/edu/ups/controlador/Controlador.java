/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;


import ec.edu.ups.modelo.Persona;
import java.util.*;


/**
 *
 * @author NANCY
 * @param <T>
 */
public abstract class Controlador<T> {
    
   private List<T> listaGenerica;

    public Controlador() {
        listaGenerica = new ArrayList<>();
    }

    public boolean create(T objeto) {
        if(validar(objeto)==true){  
            return listaGenerica.add(objeto);
        }
        
        return false;
    }
    
    public T read(T comp){
        try{
            for (T t : listaGenerica) {
                if(comp.equals(t)){
                  return t;
                }
            }
            //return listaGenerica.stream().filter(objeto->objeto.equals(comp)).findFirst().get();    
        }catch(NullPointerException ex){
           System.out.println("--------------------");
           System.out.println("Execption:"+ex);
           System.out.println("--------------------");
           System.out.println("Error: nose a encontrado el elemento.");
           System.out.println(""); 
        }
       return null;
        
    }
    
    public void update(T obj, T Eliminar) {
        int index = (listaGenerica.indexOf(Eliminar));
        listaGenerica.remove(index);
        listaGenerica.add(index, obj);
    }
    
    
    public void delete(T objeto) {
        listaGenerica.remove(objeto);
        System.out.println(listaGenerica);
    }
    
    public boolean eliminar(T objeto){
        T objetoEliminar= read(objeto);
        return(objetoEliminar!=null)? listaGenerica.remove(objetoEliminar): false;
    }

    public List<T> findAll() {
        return listaGenerica;
    }
    
    
    public abstract boolean validar(T obj);
    
    public int cargarCodigo(){
        if (findAll().size() > 0) {
            return findAll().size() + 1;
        } else {
            return 1;
        }
    }

   
   
}
