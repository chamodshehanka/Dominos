/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.view.controller;
import edu.ijse.gdse41.dominos.main.StartProject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author SHEHANKA
 */
public class DashBoardController implements Initializable {

    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!StartProject.isSplashLoaded) {
            loadSplashScreen();
        }
    } 
    
    private void loadSplashScreen() {
        try {
            StartProject.isSplashLoaded = true;

            AnchorPane pane = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/SplashScreen.fxml")));
            root.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);

            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

            fadeOut.setOnFinished((e) -> {
                try {
                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("/edu/ijse/gdse41/dominos/view/fxml/LoginForm.fxml")));
                    root.getChildren().setAll(parentContent);

                } catch (IOException ex) {
                    // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } catch (IOException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean setAnchorPaneTo(AnchorPane ap) {
        System.out.println("Method Called");
        if (ap != null) {
            try {
                System.out.println("Anchor Pane setting..");
                root.getChildren().setAll(ap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } else {
            System.out.println("there is no anchor pane");
            return false;
        }
    }
    
}
