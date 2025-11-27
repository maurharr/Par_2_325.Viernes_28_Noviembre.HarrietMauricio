package cine.view;

import cine.controller.Controlador;
import cine.model.Butaca;
import cine.model.CineData;
import cine.model.Cliente;
import cine.model.Entrada;
import cine.model.Sala;
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

public class CompraView extends Controlador{
    private VBox root;
    private Sala sala;
    private Butaca butaca;
    
    public CompraView(Stage stage, Sala salaSeleccionada, Butaca butacaSeleccionada, Cliente clienteID){
        sala = salaSeleccionada;
        butaca = butacaSeleccionada;
        
        root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lightblue;");
        
        Label titulo = new Label("Realice la operación");
        titulo.setFont(Font.font("System", FontWeight.BOLD, 24));
        
        Image img = new Image("/cine/images/ticket.png");
        ImageView view = new ImageView(img);
        view.setFitWidth(300);        
        view.setFitHeight(200);

        Label precio = new Label("Pelicula: " + sala.getNombre() + "\nSala: " + 
                sala.getTipo() + "\nButaca: " + butaca + "\n\nPrecio: $" + sala.getPrecio());
        precio.setFont(Font.font("System", FontWeight.BOLD, 20));
        
        HBox form = new HBox(25, view, precio);
        form.setAlignment(Pos.CENTER);
        
        
        Button btnComprar = new Button("Comprar");
        Button btnCancelar = new Button("Cancelar");
        HBox btnForm = new HBox(25, btnComprar, btnCancelar);
        btnForm.setAlignment(Pos.CENTER);
      
        btnComprar.setOnAction(e -> {
            CineData.entradasArray.add(new Entrada(clienteID, butaca, sala));
            CineData.guardarEntradas();
            CineData.guardarSalas();
            abrirVentana(stage, new EntradaView(stage, sala, butaca).getRoot(), "Cine: Compra finalizada", 420, 550);
        });
        btnCancelar.setOnAction(e -> abrirVentana(stage, new PeliculaView(stage, clienteID).getRoot(), "Cine: Seleccionar pelicula", 800, 550));
        root.getChildren().addAll(titulo, view, precio, btnForm);
    }
    
    public VBox getRoot() {
        return root;
    }
}
