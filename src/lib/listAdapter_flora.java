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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.m_flora;

/**
 *
 * @author F
 */
public class listAdapter_flora extends ListCell<m_flora> {
    
    @FXML private Label nama;
    @FXML private ImageView foto;
    @FXML private GridPane gridPane;
    @FXML private BorderPane borderPane;
    
    private FXMLLoader mLLoader;
    
    @Override
    protected void updateItem(m_flora flora,boolean empty){
        super.updateItem(flora, empty);
        if(empty || flora == null){
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
            
            nama.setText(flora.getNama());
            String imgSrc = "http://localhost/java/image/"+flora.getFoto();
            File file = new File("d:/c.jpg");
            Image image = new Image(imgSrc);
            final Circle clip = new Circle(130,80,80);
            foto.setClip(clip);
            foto.setImage(image);
            borderPane.setCenter(foto);
            setText(null);
            setGraphic(gridPane);
        }
    }
}
