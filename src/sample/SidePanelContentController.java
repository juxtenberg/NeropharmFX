package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Justin on 1/29/2017.
 */
public class SidePanelContentController implements Initializable {

    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton exit;
    @FXML
    private VBox vbox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void changeColor(ActionEvent event) {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        switch(btn.getText())
        {
            case "Color 1":home.rootP.setStyle("-fx-background-color:#000000");
                break;
            case "Color 2":home.rootP.setStyle("-fx-background-color:#fff");
                break;
            case "Color 3":home.rootP.setStyle("-fx-background-color:#FF0000");
                break;
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void signout(ActionEvent event) throws IOException {
        AnchorPane all = FXMLLoader.load(getClass().getResource("sample.fxml"));
        vbox.getChildren().setAll(all);

    }

}
