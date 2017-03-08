/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lib.koneksi;
import model.m_fauna;

/**
 * FXML Controller class
 *
 * @author F
 */
public class faunaExpandController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Connection conn;
    private String query;
    private Statement stat;
    private ResultSet sql;
    private ObservableList<m_fauna> data;
    
    @FXML private TableView tableFauna;
    @FXML private TableColumn<m_fauna,String> colNama;
    @FXML private TableColumn<m_fauna,String> colMakanan;
    @FXML private TableColumn<m_fauna,String> colHabitat;
    
    private koneksi kon;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        kon = new koneksi();
        getData();
    }    
    
    @FXML 
    private void loadDataFromDatabase(ActionEvent event){
        System.out.println("klik load");
        try {
            Connection con = kon.Connect();
            data = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery("select * from fauna");
            
            while(rs.next()){
                data.add(new m_fauna(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(faunaExpandController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colNama.setCellValueFactory(new PropertyValueFactory<m_fauna,String>("nama"));
        colMakanan.setCellValueFactory(new PropertyValueFactory<m_fauna,String>("makanan"));
        colHabitat.setCellValueFactory(new PropertyValueFactory<m_fauna,String>("habitat"));
        
        tableFauna.setItems(null);
        tableFauna.setItems(data);
    }    
    
    private void getData(){
        try {
            Connection con = kon.Connect();
            data = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery("select * from fauna");
            while(rs.next()){
                data.add(new m_fauna(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(faunaExpandController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colNama.setCellValueFactory(new PropertyValueFactory<m_fauna,String>("nama"));
        colMakanan.setCellValueFactory(new PropertyValueFactory<m_fauna,String>("makanan"));
        colHabitat.setCellValueFactory(new PropertyValueFactory<m_fauna,String>("habitat"));
        
        tableFauna.setItems(null);
        tableFauna.setItems(data);
    }
}
