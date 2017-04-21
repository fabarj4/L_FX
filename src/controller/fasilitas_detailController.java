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
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author F
 */
public class fasilitas_detailController implements Initializable {

    private int tipe;
    private String title;
    
    public fasilitas_detailController(int tipe, String title) {
        this.tipe = tipe;
        this.title = title;
    }
    
    @FXML
    private Button b_back, b_primata;
    
    @FXML
    private WebView webView;
    
    @FXML
    private Label v_title;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        
        Stage stage = null;
        Parent root = null;
        
        if(event.getSource() == b_back){
            System.out.println("kembali");
            stage = (Stage)b_back.getScene().getWindow();
            if(tipe == 4){
                root = FXMLLoader.load(getClass().getResource("/view/v_home.fxml"));  
            }else{
                root = FXMLLoader.load(getClass().getResource("/view/v_fasilitas.fxml"));  
            }
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        v_title.setText(title);
        WebEngine engine = webView.getEngine();
        if(tipe == 0){
            engine.load(fasilitas_detailController.class.getResource("/html/pusat_primata.html").toExternalForm());
        }else if(tipe == 1){
            engine.load(fasilitas_detailController.class.getResource("/html/taman_rekreasi.html").toExternalForm());
        }else if(tipe == 2){
            engine.load(fasilitas_detailController.class.getResource("/html/taman_satwa_anak.html").toExternalForm());
        }else if(tipe == 3){
            engine.load(fasilitas_detailController.class.getResource("/html/sarana_rekreasi.html").toExternalForm());
        }else if(tipe == 4){
            engine.load(fasilitas_detailController.class.getResource("/html/sejarah.html").toExternalForm());
        }
    }    
    
}
