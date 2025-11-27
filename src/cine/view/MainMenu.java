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

public class MainMenu extends Controlador{
    private VBox root;
    private String nombre;
    private String mail;
    private String password;
    
    public MainMenu(Stage stage){
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lightblue;");
        
        Label titulo = new Label("BIENVENIDOS");
        titulo.setFont(Font.font("System", FontWeight.BOLD, 30));
        
        Label registro = new Label("Registrate");
        registro.setFont(Font.font("System", FontWeight.BOLD, 24));
        
        TextField txtNombreUsuario = new TextField();
        txtNombreUsuario.setPromptText("Nombre de Usuario");
        txtNombreUsuario.setMaxWidth(200);
        
        TextField txtCorreoElectronico = new TextField();
        txtCorreoElectronico.setPromptText("Correo Electronico");
        txtCorreoElectronico.setMaxWidth(200);
        
        PasswordField txtContraseña = new PasswordField();
        txtContraseña.setPromptText("Contraseña");
        txtContraseña.setMaxWidth(200);
        
        Button btnAceptar = new Button("Registrarte");
        Button btnIniciarSesion = new Button("Ya tengo una cuenta");
        btnIniciarSesion.setStyle("-fx-background-color: green;");
        
        btnAceptar.setOnAction(e -> {

            nombre = txtNombreUsuario.getText();
            mail = txtCorreoElectronico.getText();
            password = txtContraseña.getText();
            
            boolean nombreExiste = false;
            boolean emailExiste = false;
            boolean contraseñaIngresada = false;
            
            if(nombre.isEmpty() || mail.isEmpty() || password.isEmpty()){
                abrirAviso("Advertencia", "Tenes que llenar todos los campos.");
            }
            if(!nombre.isEmpty()){
                for (Cliente c : CineData.clientesArray){
                    if(c.getNombre().equals(nombre)){
                        abrirAviso("Advertencia", "El nombre de usuario ya está en uso.");
                        nombreExiste = true;
                    }
                }
            }
            if(!mail.isEmpty()){
                for (Cliente c : CineData.clientesArray){
                    if(c.getEmail().equals(mail)){
                        abrirAviso("Advertencia", "El email ya está en uso.");
                        emailExiste = true;
                    }
                }
            }
            if(!password.isEmpty()){
                contraseñaIngresada = true;
            }
            Cliente ID;
            if(!nombreExiste && !emailExiste && contraseñaIngresada){
                CineData.clientesArray.add(ID = new Cliente(nombre, mail, password));
                CineData.guardarClientes();
                abrirVentana(stage, new PeliculaView(stage, ID).getRoot(), "Cine: Seleccionar pelicula", 800, 500);
            }
        });

        btnIniciarSesion.setOnAction(e -> abrirVentana(stage, new InicioSesionView(stage).getRoot(), "Cine: Iniciar sesion", 400, 400));
        VBox form = new VBox(25, txtNombreUsuario, txtCorreoElectronico, txtContraseña, btnAceptar);
        
        form.setAlignment(Pos.CENTER);
        
        root.getChildren().addAll(titulo, registro, form, btnAceptar, btnIniciarSesion);
    }

    public VBox getRoot() {
        return root;
    }
}
