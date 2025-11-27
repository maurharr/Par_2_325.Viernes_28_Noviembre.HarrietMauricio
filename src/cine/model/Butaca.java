package cine.model;

import java.io.Serializable;

public class Butaca implements Serializable{
    private int columna, fila;
    private boolean estado;


    public Butaca(int fila, int columna, boolean estado) {
        this.columna = columna;
        this.fila = fila;
        this.estado = estado;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public boolean isEstado() {
        return estado;
    }
    
    public void setOcupado() {
        estado = false;
    }
    
    @Override
    public String toString(){
        return "Butaca: " + getFila() + "-" + getColumna();
    }
}
