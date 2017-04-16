/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author F
 */
public class m_flora {
    
   private final StringProperty nama;
   private final StringProperty tinggi;
   private final StringProperty ringkasan;
   private final StringProperty foto;

    public m_flora(String nama, String tinggi, String ringkasan,String foto) {
        this.nama = new SimpleStringProperty(nama);
        this.tinggi = new SimpleStringProperty(tinggi);
        this.ringkasan = new SimpleStringProperty(ringkasan);
        this.foto = new SimpleStringProperty(foto);
    }
    
    public StringProperty namaProperty() {return nama;}
    public StringProperty tinggiProperty() {return tinggi;}
    public StringProperty ringkasanProperty() {return ringkasan;}
    public StringProperty fotoProperty(){return foto;}
    
    public String getNama() {
        return nama.get();
    }

    public String getTinggi() {
        return tinggi.get();
    }

    public String getRingkasan() {
        return ringkasan.get();
    }
    
    public String getFoto(){
        return foto.get();
    }
    
    public void setNama(String value){
        nama.set(value);
    }
    
    public void setTinggi(String value){
        tinggi.set(value);
    }
    
    public void setRingkasan(String value){
        ringkasan.set(value);
    }
    
    public void setFoto(String value){
        foto.set(value);
    }
}
