package cine.view;

import cine.controller.Controlador;
import cine.model.Butaca;
import cine.model.Cliente;
import cine.model.Sala;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ButacaView extends Controlador{
    private VBox root;
    private Sala sala;
    private Butaca[][] butacas;
    private Butaca butacaSeleccionada;
    
    public ButacaView(Stage stage, Sala salaEncontrada, Cliente clienteID){
        this.sala = salaEncontrada;
        root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lightblue;");
        
        Label pelicula = new Label("Pelicula: " + sala.getNombre());
        pelicula.setFont(Font.font("System", FontWeight.BOLD, 24));
        
        Label salaSeleccionada = new Label("Sala: " + sala.getTipo());
        salaSeleccionada.setFont(Font.font("System", FontWeight.BOLD, 24));
        
        Label titulo = new Label("Seleccione una butaca");
        titulo.setFont(Font.font("System", FontWeight.BOLD, 24));
        
        
        Image img1 = new Image("/cine/images/libre.png");
        Image img2 = new Image("/cine/images/ocupado.png");

        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(5);
        
        butacas = sala.getMatrizButacas();
        Button btnButaca;
        
        for(int fila = 0; fila < sala.getFilas(); fila++){
            for(int columna = 0; columna < sala.getColumnas(); columna++){
                
                Butaca b = butacas[fila][columna];
                
                ImageView view = new ImageView(b.isEstado() ? img1 : img2);
                view.setFitHeight(40);
                view.setFitWidth(40); 
                
                if(b.isEstado()){
                    btnButaca = new Button("", view);
                }else{
                    btnButaca = new Button("", view);   
                }
                btnButaca.setOnAction(e -> butacaSeleccionada = b);
                grid.add(btnButaca, columna, fila);
            }
        }
        
        Button btnAceptar = new Button("Aceptar");
        Button btnRetroceder = new Button("Retroceder");
        HBox btnForm = new HBox(25, btnAceptar, btnRetroceder);
        btnForm.setAlignment(Pos.CENTER);
        
        
        btnAceptar.setOnAction(e -> abrirVentana(stage, new CompraView(stage, sala, butacaSeleccionada, clienteID).getRoot(), "Cine: Realizar compra", 420, 550));
        btnRetroceder.setOnAction(e -> abrirVentana(stage, new PeliculaView(stage, clienteID).getRoot(), "Cine: Seleccionar pelicula", 800, 550));
        root.getChildren().addAll(pelicula, salaSeleccionada, titulo, grid, btnForm);
       
    }

    public VBox getRoot() {
        return root;
    }
}
