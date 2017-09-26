package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class splashController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane subPane;

    @FXML
    void initialize() {
        new Splashscreen().start();

    }



    class Splashscreen extends Thread{
        public void run(){


            try {
                Thread.sleep(5000);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Parent root = null;
                       try {
                            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage primaryStage = new Stage();
                        primaryStage.initStyle(StageStyle.UNDECORATED);
                        primaryStage.setScene(new Scene(root));
                        primaryStage.show();
                        primaryStage.setTitle("NeroPharm");
                        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("img/icon.png")));
                        subPane.getScene().getWindow().hide();

                    }
                });



            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
