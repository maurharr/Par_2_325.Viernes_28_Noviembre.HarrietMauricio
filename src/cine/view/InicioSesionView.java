package cine.view;

import cine.controller.Controlador;
import cine.model.CineData;
import cine.model.Cliente;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class InicioSesionView extends Controlador{
    private VBox root;
    private String correo;
    private String contraseña;
    private Cliente clienteID;

    
    public InicioSesionView(Stage stage){
        root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lightblue;");
        
        Label titulo = new Label("Iniciar Sesión");
        titulo.setFont(Font.font("System", FontWeight.BOLD, 24));
        
        TextField txtCorreo = new TextField();
        txtCorreo.setPromptText("Correo electronico");
        txtCorreo.setMaxWidth(200);
        
        PasswordField txtContraseña = new PasswordField();
        txtContraseña.setPromptText("Contraseña");
        txtContraseña.setMaxWidth(200);
        
        Button btnIniciarSesion = new Button("Iniciar Sesion");
        Button btnRetroceder = new Button("Retroceder");
        
        btnIniciarSesion.setOnAction(e -> {
            correo = txtCorreo.getText();
            contraseña = txtContraseña.getText();

            if(correo.isEmpty() || contraseña.isEmpty()){
                abrirAviso("Advertencia", "Tenes que llenar todos los campos.");
            }
            
            boolean correoCheck = false;
            boolean contraseñaCheck = false;
            

            
            for (int i = 0; i < CineData.clientesArray.size(); i++){
                if(CineData.clientesArray.get(i).getEmail().equals(correo)){
                    clienteID = CineData.clientesArray.get(i);
                    correoCheck = true;
                    break;
                }    
            }
            
            if(!correoCheck){
                abrirAviso("Advertencia", "El correo ingresado no existe.");
                return;
            }

            if(!contraseña.isEmpty()){
                if(clienteID.getContraseña().equals(contraseña)){
                    contraseñaCheck = true;
                }else{
                    abrirAviso("Advertencia", "Contraseña incorrecta.");
                }
            }
            if(correoCheck && contraseñaCheck) abrirVentana(stage, new PeliculaView(stage, clienteID).getRoot(), "Cine: Seleccionar pelicula", 800, 550);
        });
        
        
        
        btnRetroceder.setOnAction(e -> abrirVentana(stage, new MainMenu(stage).getRoot(), "Cine", 400, 400));
        
        VBox form = new VBox(25, txtCorreo, txtContraseña, btnIniciarSesion);
        form.setAlignment(Pos.CENTER);
        
        root.getChildren().addAll(titulo, form, btnIniciarSesion, btnRetroceder);
    }

    public VBox getRoot() {
        return root;
    }
}
