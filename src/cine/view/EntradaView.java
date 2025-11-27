package cine.view;

import cine.controller.Controlador;
import cine.model.Butaca;
import cine.model.Sala;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class EntradaView extends Controlador{
    private VBox root;
    private Sala sala; 
    private Butaca butaca;
    
    public EntradaView(Stage stage, Sala salaSeleccionada, Butaca butacaSeleccionada){
        root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lightblue;");
        
        sala = salaSeleccionada;
        butaca = butacaSeleccionada;
        
        Label titulo = new Label("Compra realizada con Exito");
        titulo.setFont(Font.font("System", FontWeight.BOLD, 24));
        
        Image img = new Image("/cine/images/ticket.png");
        ImageView view = new ImageView(img);
        view.setFitWidth(300);        
        view.setFitHeight(200);
        
        Label entrada = new Label("Pelicula: " + sala.getNombre() + "\nSala: " + 
                sala.getTipo() + "\nButaca: " + butaca);
        entrada.setFont(Font.font("System", FontWeight.BOLD, 20));
        
        Button btnSalir = new Button("Salir");
        
        btnSalir.setOnAction(e -> abrirVentana(stage, new MainMenu(stage).getRoot(), "Cine", 400, 400));
        root.getChildren().addAll(titulo, view, entrada, btnSalir);
    }
        
    public VBox getRoot() {
        return root;
    }
}
