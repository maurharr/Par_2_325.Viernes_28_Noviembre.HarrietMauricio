package cine.view;

import cine.controller.Controlador;
import cine.model.Cliente;
import cine.model.Sala;
import cine.persistence.PersistenciaJava;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SalaView extends Controlador{
    private VBox root;
    private String tipo;
    private Sala salaEncontrada = null;
    
    public SalaView(Stage stage, String peliculaSeleccionada, Cliente clienteID){
        root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lightblue;");
        
        
        Label pelicula = new Label("Pelicula: " + peliculaSeleccionada);
        pelicula.setFont(Font.font("System", FontWeight.BOLD, 24));
        
        Label titulo = new Label("Seleccione una sala");
        titulo.setFont(Font.font("System", FontWeight.BOLD, 24));

        Image img1 = new Image("/cine/images/2d.png");
        ImageView view1 = new ImageView(img1);
        view1.setFitWidth(150);        
        view1.setFitHeight(150);
        
        Image img2 = new Image("/cine/images/3d.png");
        ImageView view2 = new ImageView(img2);
        view2.setFitWidth(150);        
        view2.setFitHeight(150);

        Button btn2D = new Button("", view1);
        Button btn3D = new Button("", view2);
        HBox contenedor = new HBox(50, btn2D, btn3D);
        contenedor.setAlignment(Pos.CENTER);
        
        Button btnAceptar = new Button("Aceptar");
        Button btnRetroceder = new Button("Retroceder");
        HBox btnForm = new HBox(25, btnAceptar, btnRetroceder);
        btnForm.setAlignment(Pos.CENTER);
 
        
        btn2D.setOnAction(e -> {
            tipo = "2D";
            for(int i = 0; i < PersistenciaJava.salasArray.size(); i++){
                if(PersistenciaJava.salasArray.get(i).getNombre().equals(peliculaSeleccionada) && tipo.equals(PersistenciaJava.salasArray.get(i).getTipo())){
                    salaEncontrada = PersistenciaJava.salasArray.get(i);
                    break;
                }
            }
        });
        btn3D.setOnAction(e -> {
            tipo = "3D";
            for(int i = 0; i < PersistenciaJava.salasArray.size(); i++){
                if(PersistenciaJava.salasArray.get(i).getNombre().equals(peliculaSeleccionada) && tipo.equals(PersistenciaJava.salasArray.get(i).getTipo())){
                    salaEncontrada = PersistenciaJava.salasArray.get(i);
                    break;
                }
            }
        });

        btnAceptar.setOnAction(e -> {
            if(tipo != null){
                abrirVentana(stage, new ButacaView(stage, salaEncontrada, clienteID).getRoot(), "Cine: Seleccionar butaca", 800, 600);
            }else{
                abrirAviso("Advertencia", "Tenes que seleccionar una sala.");
            }
        });        
         
        btnRetroceder.setOnAction(e -> abrirVentana(stage, new PeliculaView(stage, clienteID).getRoot(), "Cine: Seleccionar pelicula", 800, 550));
        
        root.getChildren().addAll(pelicula, titulo, contenedor, btnForm);
    }
    
    
    public VBox getRoot() {
        return root;
    }
}
