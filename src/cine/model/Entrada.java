package cine.model;

import java.io.Serializable;

public class Entrada implements Serializable{
    private Cliente cliente;
    private Butaca butaca;
    private Sala sala;

    public Entrada(Cliente cliente, Butaca butaca, Sala sala) {
        this.cliente = cliente;
        this.butaca = butaca;
        this.sala = sala;
        
        butaca.setOcupado();
    }
    
    
}
