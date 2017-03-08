/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author F
 */
public class homeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button b_fauna,b_flora;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        
        Stage stage = null;
        Parent root = null;
        
        if(event.getSource() == b_fauna){
            System.out.println("Fauna");
            stage = (Stage)b_fauna.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/view/v_fauna.fxml"));
        }else if(event.getSource() == b_flora){
            FXMLLoader ff = new FXMLLoader(getClass().getResource("/view/v_itemff.fxml"));
            stage = (Stage)b_flora.getScene().getWindow();
            ff.setController(new itemffController(0,1));
            root = ff.load();
        }
        else{
            System.out.println("lala");
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
