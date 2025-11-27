package cine.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CineData {
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

        // CARGADO DE CLIENTES 
        try {
            FileInputStream fis = new FileInputStream("Clientes.dat"); // Intentamos cargar el archivo al programa
            ObjectInputStream ois = new ObjectInputStream(fis); // Intentamos poner un adapatador de objetos para poder cargar objetos
            clientesArray = ((List<Cliente>) ois.readObject()); // Intentamos guardar el objeto del archivo en un objeto nuevo casteandolo
            ois.close(); // Cerramos el adaptador
        } catch (FileNotFoundException ex) {
            System.out.println("Error FileNotFound" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error IOException" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        }      
        
        // CARGADO DE SALAS 
        try {
            FileInputStream fis = new FileInputStream("Salas.dat"); 
            ObjectInputStream ois = new ObjectInputStream(fis);
            salasArray = ((List<Sala>) ois.readObject()); 
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error FileNotFound" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error IOException" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        }      
        
        
        // CARGADO DE ENTRADAS 
        try {
            FileInputStream fis = new FileInputStream("Entradas.dat");
            ObjectInputStream ois = new ObjectInputStream(fis); 
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
    
    public static void guardarSalas(){
         try {
             FileOutputStream fos = new FileOutputStream("Salas.dat"); 
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             oos.writeObject(salasArray); 
             oos.close(); 
         } catch (FileNotFoundException ex) {
             System.out.println("Error de archivo.");
         } catch (IOException ex) {
             System.out.println("Error input output.");
         }
    }
    
    public static void guardarClientes(){
         try {
             FileOutputStream fos = new FileOutputStream("Clientes.dat"); 
             ObjectOutputStream oos = new ObjectOutputStream(fos); 
             oos.writeObject(clientesArray); 
             oos.close(); 
         } catch (FileNotFoundException ex) {
             System.out.println("Error de archivo.");
         } catch (IOException ex) {
             System.out.println("Error input output.");
         }
    }
    
    public static void guardarEntradas(){
         try {
             FileOutputStream fos = new FileOutputStream("Entradas.dat"); 
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             oos.writeObject(entradasArray); 
             oos.close();
         } catch (FileNotFoundException ex) {
             System.out.println("Error de archivo.");
         } catch (IOException ex) {
             System.out.println("Error input output.");
         }
         
    }

}
