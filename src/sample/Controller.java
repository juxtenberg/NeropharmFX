package sample;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.sqlite.SQLiteConnection;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton maximize;

    @FXML
    private JFXButton minimize;

    @FXML
    private JFXButton close;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private AnchorPane rootPane;

    @FXML
    public AnchorPane regPane;

    @FXML
    private ImageView imageView;

    @FXML
    private Label status;


    @FXML
    void loadSecond() throws IOException {
        AnchorPane body = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        rootPane.getChildren().setAll(body);

    }

    @FXML
    void handleDragOver(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }


    @FXML
    void handleDrop(DragEvent event) throws FileNotFoundException {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        imageView.setImage(img);
        status.setText("Image added successfully");
    }

    @FXML
    void goback(ActionEvent event) throws IOException {
        AnchorPane body = FXMLLoader.load(getClass().getResource("sample.fxml"));
        regPane.getChildren().setAll(body);

    }



    /*    public static AnchorPane rootp;

    */

  /*  public void initialize() {

        if (!Main.isSplashLoaded) {
            loadSplashscreen();
        }
        rootp = root;
   }
   */
 /*   @FXML
    private void handleButtonAction(ActionEvent event) {
        Notifications notificationBuilder = Notifications.create()
                .title("Successfully Login In")
                .text("Please wait for a moment")
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println();
                    }
                });
        notificationBuilder.showInformation();

    }
*/

    @FXML
    private void Login(ActionEvent event) {
        if (username.getText().equals("justin") && password.getText().equals("12345"))
        {


        try {
            Image image = new Image("sample/notifi/success.png");
            TrayNotification tray = new TrayNotification();
            tray.setTitle("Successfully Logged In");
            tray.setMessage("Please wait for a moment");
            tray.setImage(image);
            tray.setRectangleFill(Paint.valueOf("#000"));
            tray.setAnimationType(AnimationType.POPUP);
            tray.showAndDismiss(Duration.seconds(3));


            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            primaryStage.setTitle("NeroPharm");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("img/icon.png")));
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else

    {
            /*Notification Advance*/
        Image image = new Image("sample/notifi/error.png");
        TrayNotification tray = new TrayNotification();
        tray.setTitle("Invalid Credentials");
        tray.setMessage("Wrong Username Or Password");
        tray.setImage(image);
        tray.setRectangleFill(Paint.valueOf("#000000"));
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(3));

    }

}




    @FXML
    private void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) close.getScene().getWindow();
        // do what you have to do
        stage.close();
    }


    @FXML
    private void minimizeButtonAction() {
        Stage stage = (Stage) minimize.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void maximizeButtonAction() {
        Stage stage = (Stage) maximize.getScene().getWindow();
        //Maximized
        stage.setMaximized(true);

        //Restore down
        //stage.setMaximized(false);


    }

/*
private void loadSplashscreen(){
        try {
            Main.isSplashLoaded = true;
            StackPane pane = FXMLLoader.load(getClass().getResource("Splash.fxml"));
            root.getChildren().setAll(pane);

            FadeTransition fadein = new FadeTransition(Duration.seconds(3), pane);
            fadein.setFromValue(0);
            fadein.setToValue(1);
            fadein.setCycleCount(1);

            FadeTransition fadeout = new FadeTransition(Duration.seconds(5), pane);
            fadeout.setFromValue(1);
            fadeout.setToValue(0);
            fadeout.setCycleCount(1);

            fadein.play();

            fadein.setOnFinished((event) -> {
                fadeout.play();
            });

            fadeout.setOnFinished((event) -> {
                try {
                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource("sample.fxml"));
                    root.getChildren().setAll(parentContent);
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        catch (IOException ex){
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

         */

}










