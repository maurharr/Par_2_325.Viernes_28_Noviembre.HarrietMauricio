package cine;

import cine.view.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import cine.model.CineData;
import javafx.scene.image.Image;

public class main extends Application {
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        CineData.cargarDatos();
        
        MainMenu menu = new MainMenu(stage);
        Scene scene = new Scene(menu.getRoot(), 400, 400);
        stage.setTitle("Cine");
        stage.getIcons().add(new Image("/cine/images/logo.png"));
        stage.setScene(scene);
        stage.show();
    }
}
