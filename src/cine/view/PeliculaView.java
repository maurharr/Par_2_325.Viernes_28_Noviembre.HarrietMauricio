package cine.view;

import cine.controller.Controlador;
import cine.model.Cliente;
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



public class PeliculaView extends Controlador{
    private VBox root;
    private String peliculaSeleccionada;
    
    public PeliculaView(Stage stage, Cliente clienteID){
        root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lightblue;");

        Label titulo = new Label("Seleccione una pelicula");
        titulo.setFont(Font.font("System", FontWeight.BOLD, 24));
       
        
        Image imgUno = new Image("/cine/images/1.jpg");
        ImageView viewUno = new ImageView(imgUno);
        viewUno.setFitWidth(225);        
        viewUno.setFitHeight(325);
        
        
        Image imgDos = new Image("/cine/images/2.jpg");
        ImageView viewDos = new ImageView(imgDos);
        viewDos.setFitWidth(225);
        viewDos.setFitHeight(325);
        
        
        Image imgTres = new Image("/cine/images/3.jpg");
        ImageView viewTres = new ImageView(imgTres);
        viewTres.setFitWidth(225);
        viewTres.setFitHeight(325);
        
        
        Button btnPeliUno = new Button("", viewUno);
        Button btnPeliDos = new Button("", viewDos);
        Button btnPeliTres = new Button("", viewTres);
        HBox contenedor = new HBox(25,btnPeliUno, btnPeliDos, btnPeliTres);
        contenedor.setAlignment(Pos.CENTER);
        
        Button btnAceptar = new Button("Aceptar");
        Button btnCancelar = new Button("Cancelar");
        HBox btnForm = new HBox(25, btnAceptar, btnCancelar);
        btnForm.setAlignment(Pos.CENTER);
        
        
        btnPeliUno.setOnAction(e -> peliculaSeleccionada = "Depredador");
        btnPeliDos.setOnAction(e -> peliculaSeleccionada = "Harry Potter");
        btnPeliTres.setOnAction(e -> peliculaSeleccionada = "Sobreviviente");
        
        btnAceptar.setOnAction(e -> abrirVentana(stage, new SalaView(stage, peliculaSeleccionada, clienteID).getRoot(), "Cine: Seleccionar sala", 500, 400));
        btnCancelar.setOnAction(e -> abrirVentana(stage, new MainMenu(stage).getRoot(), "Cine", 400, 400));
        
        root.getChildren().addAll(titulo, contenedor, btnForm);
    }
    
    public VBox getRoot() {
        return root;
    }
}
