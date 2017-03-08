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
public class faunaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button b_back,b_mamalia,b_aves,b_pieces,b_reptile;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        
        Stage stage = null;
        Parent root = null;
        FXMLLoader ff = new FXMLLoader(getClass().getResource("/view/v_itemff.fxml"));
        
        if(event.getSource() == b_back){
            System.out.println("kembali");
            stage = (Stage)b_back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/view/v_home.fxml"));  
        }else if(event.getSource() == b_mamalia){
            System.out.println("mamalia");
            stage = (Stage)b_mamalia.getScene().getWindow();
            ff.setController(new itemffController(0,0));
            root = ff.load();
        }else if(event.getSource() == b_aves){
            System.out.println("aves");
            stage = (Stage)b_aves.getScene().getWindow();
            ff.setController(new itemffController(1,0));
            root = ff.load();
        }else if(event.getSource() == b_reptile){
            System.out.println("reptile");
            stage = (Stage)b_pieces.getScene().getWindow();
            ff.setController(new itemffController(2,0));
            root = ff.load();
        }else if(event.getSource() == b_pieces){
            System.out.println("pieces");
            stage = (Stage)b_pieces.getScene().getWindow();
            ff.setController(new itemffController(3,0));
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
