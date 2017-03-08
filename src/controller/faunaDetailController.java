/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import lib.koneksi;
import model.m_fauna;

/**
 * FXML Controller class
 *
 * @author F
 */
public class faunaDetailController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Connection conn;
    private String query;
    private Statement stat;
    private ResultSet sql;
    private ObservableList<m_fauna> data;
    private koneksi kon;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
