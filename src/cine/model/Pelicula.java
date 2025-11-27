package cine.model;

import java.io.Serializable;

public class Pelicula implements Serializable{
    private String nombre;
    private int precio;

    public Pelicula(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }
    
    @Override
    public String toString(){
        return "Pelicula: " + nombre + " | Precio: $" + precio;
    }
    
}
