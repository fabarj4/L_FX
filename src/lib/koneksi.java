/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class koneksi {
    
    public Connection Connect(){
        try {
            String url="jdbc:mysql://localhost:3306/ragunan"; //url database
            String user="root"; //user database
            String pass=""; //password database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pass);
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //mysqlconfig=DriverManager.getConnection(url, user, pass);           
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("koneksi gagal "+e.getMessage()); //perintah menampilkan error pada koneksi
        }
        return null;
    }    
}
