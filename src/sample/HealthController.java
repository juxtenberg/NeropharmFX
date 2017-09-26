package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Justin on 1/29/2017.
 */
public class HealthController {
    @FXML
    private AnchorPane RootPane;

    @FXML
    void getback(ActionEvent event) throws IOException {
        AnchorPane all = FXMLLoader.load(getClass().getResource("home.fxml"));
        RootPane.getChildren().setAll(all);
    }
}