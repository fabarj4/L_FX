/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXListView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import lib.koneksi;
import lib.listAdapter_fauna;
import lib.listAdapter_flora;
import model.m_fauna;
import model.m_flora;

/**
 * FXML Controller class
 *
 * @author F
 */
public class itemffController implements Initializable {

    @FXML private JFXListView listView;
    
    @FXML private Label title;
    
    @FXML private Button b_back;
    
    private Stage stage = null;
    private Parent root = null;
    
    ObservableList observableList = FXCollections.observableArrayList();
    
    private ObservableList<m_fauna> data_fauna;
    private ObservableList<m_flora> data_flora;
    private koneksi kon;
    
    private int jenis,tipe;
    private String jenis_txt;
    
    

    public itemffController(int tipe) {
        this.tipe = tipe;
    }
    public itemffController(int jenis,int tipe) {
        this.jenis = jenis;
        this.tipe = tipe;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert listView != null;
        kon = new koneksi();
        try {
            getData();
            //listView.setExpanded(true);
            listView.setOrientation(Orientation.HORIZONTAL);
            if(tipe == 0){
                listView.setItems(data_fauna);
                switch(jenis){
                    case 0:
                        jenis_txt = "Mamalia";
                        break;
                    case 1:
                        jenis_txt = "Aves";
                        break;
                    case 2:
                        jenis_txt = "Reptile";
                        break;
                    case 3:
                        jenis_txt = "Pieces";
                        break;
                }
                listView.setCellFactory(itemListView -> new listAdapter_fauna());
                listView.getSelectionModel().selectedItemProperty().addListener(
                    new ChangeListener<m_fauna>(){
                        @Override
                        public void changed(ObservableValue<? extends m_fauna> observable, m_fauna oldValue, m_fauna newValue) {
                            try {  
                                FXMLLoader ffDetail = new FXMLLoader(getClass().getResource("/view/v_itemffDetail.fxml"));
                                stage = (Stage)b_back.getScene().getWindow(); //nama,ringkasan,makanan,habitat,lama_hidup,penyebaran,foto,jumlah
                                ffDetail.setController(new itemffDetailController(newValue.getNama(),newValue.getRingkasan(),newValue.getMakanan(),newValue.getHabitat(),newValue.getLamaHidup(),newValue.getPenyebaran(),newValue.getFoto(),newValue.getJumlah(),jenis,tipe));
                                root = ffDetail.load();
                            } catch (IOException ex) {
                                Logger.getLogger(itemffController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.setFullScreen(true);
                            stage.show();
                        }
                    }
                );
            }else{
                listView.setItems(data_flora);
                jenis_txt = "Flora";
                listView.setCellFactory(itemListView -> new listAdapter_flora());
                listView.getSelectionModel().selectedItemProperty().addListener(
                    new ChangeListener<m_flora>(){
                        @Override
                        public void changed(ObservableValue<? extends m_flora> observable, m_flora oldValue, m_flora newValue) {
                            try {  
                                FXMLLoader ffDetail = new FXMLLoader(getClass().getResource("/view/v_itemffDetail.fxml"));
                                stage = (Stage)b_back.getScene().getWindow();
                                ffDetail.setController(new itemffDetailController(newValue.getNama(),newValue.getTinggi(),newValue.getRingkasan(),newValue.getFoto(),jenis,tipe));
                                root = ffDetail.load();
                            } catch (IOException ex) {
                                Logger.getLogger(itemffController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.setFullScreen(true);
                            stage.show();
                        }
                    }
                );
            }
            title.setText(jenis_txt);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(itemffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        
        if(event.getSource() == b_back){
            System.out.println("kembali");
            stage = (Stage)b_back.getScene().getWindow();
            if(tipe == 0){
                root = FXMLLoader.load(getClass().getResource("/view/v_fauna.fxml"));  
            }else{
                root = FXMLLoader.load(getClass().getResource("/view/v_home.fxml"));  
            }
        }else{
            System.out.println("lala");
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
        
    }
    
    private void getData() throws FileNotFoundException{
        try {
            Connection con = kon.Connect();
            data_fauna = FXCollections.observableArrayList();
            data_flora = FXCollections.observableArrayList();
            ResultSet rs = null;
            switch(tipe){
                case 0:
                    rs = con.createStatement().executeQuery("select nama,ringkasan,makanan,habitat,lama_hidup,penyebaran,foto,jumlah from fauna where id_tipefauna = '"+jenis+"'");
                    while(rs.next()){
                        data_fauna.add(new m_fauna(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
                    }
                    break;
                case 1:
                    rs = con.createStatement().executeQuery("select nama,tinggi,ringkasan,foto from flora");
                    while(rs.next()){
                        data_flora.add(new m_flora(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                    }
                    break;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(faunaExpandController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
