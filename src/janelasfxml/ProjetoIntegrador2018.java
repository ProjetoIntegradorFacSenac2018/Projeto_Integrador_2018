package janelasfxml;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sun.applet.Main;

/**
 *
 * @author Rafael Carvalho e Lima
 */
public class ProjetoIntegrador2018 extends Application {

    private double x, y;
@FXML
    private ScrollPane janela;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLjanelaMain.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Projeto Integrador 2018");
        stage.getIcons().add(new Image("file:/Logo2.png"));
        //Borderless
        stage.initStyle(StageStyle.UNDECORATED);

        //Arrastar a tela
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
        stage.show();
    }
    
    
    
   

    public static void main(String[] args) {
        launch(args);
    }

}
