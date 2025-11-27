package cine.model;

import java.io.Serializable;

public class Cliente implements Serializable{
    private String nombre, email, contraseña;

    public Cliente(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + " | Email: " + email + " | Contraseña: " + contraseña;
    }
    
    
    @Override
    public boolean equals(Object otroCliente){
        if (this == otroCliente) return true; 
        if(otroCliente == null) return false;
        
        Cliente cliente = (Cliente) otroCliente;
        return getNombre().equals(cliente.getNombre());
    }
    
}
