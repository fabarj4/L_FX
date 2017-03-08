/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    
    private String nama,makanan,ringkasan,habitat,lama_hidup,penyebaran,foto,jumlah;
    
    koneksi kon;
    private ObservableList<m_fauna> data;
    
    @FXML private Label v_nama,v_makanan,v_habitat;

    public itemffDetailController(String nama, String makanan, String habitat) {
        this.nama = nama;
        this.makanan = makanan;
        this.habitat = habitat;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        kon = new koneksi();
        v_nama.setText(nama.toUpperCase());
        v_makanan.setText(makanan);
        v_habitat.setText(habitat);
    }    
}
