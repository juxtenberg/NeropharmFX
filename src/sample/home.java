package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class home {

    @FXML
    private AnchorPane healthPane;

    @FXML
    private JFXButton signout;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private StackPane subPane;

    @FXML
    private JFXButton button;

    @FXML
    private JFXButton button1;

    @FXML
    private JFXButton button2;

    public static AnchorPane rootP;



    @FXML
    public void initialize() {
        rootP = healthPane;

        try {
            VBox box = FXMLLoader.load(getClass().getResource("SidePanelContent.fxml"));
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }


        HamburgerSlideCloseTransition transition = new HamburgerSlideCloseTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isShown()) {
                drawer.close();
                System.out.close();
            } else
                drawer.open();
        });


        ScaleTransition transition1 = new ScaleTransition(Duration.seconds(3), button);
        transition1.setToX(0.9);
        transition1.setToY(0.9);
        transition1.setCycleCount(ScaleTransition.INDEFINITE);
        transition1.play();

        Circle circle = new Circle(100);
        PathTransition transition2 = new PathTransition();
        transition2.setNode(button1);
        transition2.setDuration(Duration.seconds(3));
        transition2.setPath(circle);
        transition2.setCycleCount(PathTransition.INDEFINITE);
        transition2.play();

        FadeTransition fadeout = new FadeTransition();
        fadeout.setNode(button2);
        fadeout.setDuration(Duration.seconds(2));
        fadeout.setFromValue(1.0);
        fadeout.setToValue(0.0);
        fadeout.setCycleCount(FadeTransition.INDEFINITE);
        fadeout.play();


    }



    @FXML
    void eczema(ActionEvent event) throws IOException {
        AnchorPane all = FXMLLoader.load(getClass().getResource("healthpage.fxml"));
        healthPane.getChildren().setAll(all);

    }

}