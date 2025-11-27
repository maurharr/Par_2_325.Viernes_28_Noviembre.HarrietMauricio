package cine.model;

import java.io.Serializable;

public class Sala implements Serializable{
    private Pelicula pelicula;
    private String tipo;
    private int filas;
    private int columnas;
    private Butaca[][] matrizButacas;

    
    
    public Sala(Pelicula pelicula, String tipo, int filas, int columnas) {
        this.tipo = tipo;
        this.pelicula = pelicula;
        this.filas = filas;
        this.columnas = columnas;
        
        
        matrizButacas = new Butaca[columnas][columnas];
        for(int fil = 0; fil < filas; fil++){
            for(int col = 0; col < columnas; col++)
            {
                matrizButacas[fil][col] = new Butaca(fil, col, true);
            }
        }
    }

    public String getNombre() {
        return pelicula.getNombre();
    }

    public String getTipo() {
        return tipo;
    }

    public int getPrecio() {
        return pelicula.getPrecio();
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public Butaca[][] getMatrizButacas() {
        return matrizButacas;
    }
    
    @Override
    public boolean equals(Object otraSala){
        if (this == otraSala) return true; 
        if(otraSala == null) return false;
        
        Sala sala = (Sala) otraSala;
        return getNombre().equals(sala.getNombre());
    }
    
    @Override
    public String toString(){
        return "Sala: " + getTipo() + " | Pelicula: " + pelicula.getNombre();
    }
   
}