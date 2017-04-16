/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lib.koneksi;
import model.m_fauna;

/**
 * FXML Controller class
 *
 * @author F
 */
public class itemffDetailController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private String nama,makanan,ringkasan,habitat,lama_hidup,penyebaran,photo,jumlah,tinggi;
    private int jenis,tipe;
    
    koneksi kon;
    private ObservableList<m_fauna> data;
    
    @FXML private Label v_nama,v_makanan,v_habitat;
    @FXML private JFXButton b_back; 
    @FXML private ImageView foto;

    //untuk menampilkan flora
    public itemffDetailController(String nama, String ringkasan, String photo, String tinggi, int jenis, int tipe) {
        this.nama = nama;
        this.ringkasan = ringkasan;
        this.photo = photo;
        this.tinggi = tinggi;
        this.jenis = jenis;
        this.tipe = tipe;
    }
    
    //untuk menampilkan fauna
    public itemffDetailController(String nama, String ringkasan, String makanan, String habitat, String lama_hidup, String penyebaran, String photo, String jumlah, int jenis, int tipe) {
        this.nama = nama;
        this.ringkasan = ringkasan;
        this.makanan = makanan;
        this.habitat = habitat;
        this.lama_hidup = lama_hidup;
        this.penyebaran = penyebaran;
        this.photo = photo;
        this.jumlah = jumlah;
        this.jenis = jenis;
        this.tipe = tipe;
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        kon = new koneksi();
        v_nama.setText(nama.toUpperCase());
        v_makanan.setText(makanan);
        v_habitat.setText(habitat);
        String imgSrc = "http://localhost/java/image/"+photo;
        File file = new File("d:/c.jpg");
        Image image = new Image(imgSrc);
        final Circle clip = new Circle(147,105,105);
        foto.setClip(clip);
        foto.setImage(image);
        System.out.println("jenis : "+jenis+" tipe : "+tipe);
    }    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage = null;
        Parent root = null;
        if(event.getSource() == b_back){
            System.out.println("kembali");
            FXMLLoader ff = new FXMLLoader(getClass().getResource("/view/v_itemff.fxml"));
            stage = (Stage)b_back.getScene().getWindow();
            if(tipe == 0){
                ff.setController(new itemffController(jenis,tipe));
            }else{
                ff.setController(new itemffController(0,1));
            }
            root = ff.load();
        }else{
            System.out.println("lala");
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
        
    }
    
}
