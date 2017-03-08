/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import controller.ItemListController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.m_fauna;

/**
 *
 * @author F
 */
public class listAdapter extends ListCell<m_fauna> {
    
    @FXML private Label nama;
    @FXML private ImageView foto;
    @FXML 
    private GridPane gridPane;
    
    private FXMLLoader mLLoader;
    
    @Override
    protected void updateItem(m_fauna fauna,boolean empty){
        super.updateItem(fauna, empty);
        if(empty || fauna == null){
            setText(null);
            setGraphic(null);
        }else{
            if(mLLoader == null){
                mLLoader = new FXMLLoader(getClass().getResource("/view/itemList.fxml"));
                mLLoader.setController(this);
                try{
                    mLLoader.load();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
            
            nama.setText(fauna.getNama());
            /*
            try{
                foto = new ImageView();
                Image img = new Image(new FileInputStream("D:\\tiger.png"));
                foto.setImage(img);
            }catch(FileNotFoundException ex){
                
            }*/
            
            setText(null);
            setGraphic(gridPane);
        }
    }
}
