/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author F
 */
public class L_FX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/v_home.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/view/v_fauna.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("v_faunaExpand.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/view/v_faunaExpand.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/view/v_itemff.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/view/v_itemffDetail.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/v_home.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("tes");
        stage.setFullScreen(true);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
