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
public class fasilitasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button b_back, b_primata,b_refleksi,b_satwa,b_sarana;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        
        Stage stage = null;
        Parent root = null;
        FXMLLoader ff = new FXMLLoader(getClass().getResource("/view/v_fasilitas_detail.fxml"));
        
        if(event.getSource() == b_back){
            System.out.println("kembali");
            stage = (Stage)b_back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/view/v_home.fxml"));  
        }else if(event.getSource() == b_primata){
            System.out.println("pusat primata");
            stage = (Stage)b_primata.getScene().getWindow();
            ff.setController(new fasilitas_detailController(0,"Pusat Primata Schmutzer"));
            root = ff.load();
        }else if(event.getSource() == b_refleksi){
            System.out.println("taman refleksi");
            stage = (Stage)b_refleksi.getScene().getWindow();
            ff.setController(new fasilitas_detailController(1,"Taman Refleksi"));
            root = ff.load();
        }else if(event.getSource() == b_satwa){
            System.out.println("taman satwa anak");
            stage = (Stage)b_satwa.getScene().getWindow();
            ff.setController(new fasilitas_detailController(2,"Taman Satwa Anak"));
            root = ff.load();
        }else if(event.getSource() == b_sarana){
            System.out.println("pusat sarana");
            stage = (Stage)b_sarana.getScene().getWindow();
            ff.setController(new fasilitas_detailController(3,"Sarana Rekreasi"));
            root = ff.load();
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
