package cine.persistence;

import cine.model.Cliente;
import cine.model.Entrada;
import cine.model.Pelicula;
import cine.model.Sala;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaJava {
    public static List<Sala> salasArray = new ArrayList<>();
    public static List<Entrada> entradasArray = new ArrayList<>();
    public static List <Cliente> clientesArray = new ArrayList<>();
    
    public static void agregarSala(String nombre, int precio, String tipo, int filas, int columnas){
        salasArray.add(new Sala(new Pelicula(nombre, precio), tipo, filas, columnas));
    }
    public static void cargarDatos(){      
        /*
        agregarSala("Depredador", 5000, "2D", 5, 8);
        agregarSala("Harry Potter", 5000, "2D", 5, 8);
        agregarSala("Sobreviviente", 5000, "2D", 5, 8);
        
        agregarSala("Depredador", 7000, "3D", 8, 12);
        agregarSala("Harry Potter", 7000, "3D", 8, 12);
        agregarSala("Sobreviviente", 7000, "3D", 8, 12);
        */
        try {
            FileInputStream fis = new FileInputStream("src/cine/persistence/cine.ser");
            ObjectInputStream ois = new ObjectInputStream(fis); 
            clientesArray = ((List<Cliente>) ois.readObject());
            salasArray = ((List<Sala>) ois.readObject()); 
            entradasArray = ((List<Entrada>) ois.readObject());
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error FileNotFound" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error IOException" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        }  
        
    }
    
    
    public static void guardarDatos(){
         try {
             FileOutputStream fos = new FileOutputStream("src/cine/persistence/cine.ser"); 
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             oos.writeObject(clientesArray); 
             oos.writeObject(salasArray); 
             oos.writeObject(entradasArray); 
             oos.close();
         } catch (FileNotFoundException ex) {
             System.out.println("Error de archivo.");
         } catch (IOException ex) {
             System.out.println("Error input output.");
         }
         
    }

}


