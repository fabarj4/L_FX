/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.m_fauna;

/**
 * FXML Controller class
 *
 * @author F
 */
public class ItemListController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private GridPane gridPane;
    @FXML private Label label1;
    @FXML private Label label2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    public void setData(m_fauna fauna){
        label1.setText(fauna.getNama());
        label2.setText(fauna.getMakanan());
    }
    
    public GridPane getPane(){
        return gridPane;
    }
}
