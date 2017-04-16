/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Set;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author F
 */
public class m_fauna {

    private final StringProperty nama;
    private final StringProperty ringkasan;
    private final StringProperty makanan;
    private final StringProperty habitat;
    private final StringProperty lama_hidup;
    private final StringProperty penyebaran;
    private final StringProperty foto;
    private final StringProperty jumlah;
   
    public StringProperty namaProperty() {return nama;}
    public StringProperty ringkasanProperty() {return ringkasan;}
    public StringProperty makananProperty() {return makanan;}
    public StringProperty habitatProperty() {return habitat;}
    public StringProperty lama_hidupProperty() {return lama_hidup;}
    public StringProperty penyebaranProperty() {return penyebaran;}
    public StringProperty fotoProperty(){return foto;}
    public StringProperty jumlahProperty(){return jumlah;}

    public m_fauna(String nama, String makanan, String habitat, String ringkasan,String lama_hidup,String penyebaran,String foto,String jumlah) {
        this.nama = new SimpleStringProperty(nama);
        this.ringkasan = new SimpleStringProperty(ringkasan);
        this.makanan = new SimpleStringProperty(makanan);
        this.habitat = new SimpleStringProperty(habitat);
        this.lama_hidup = new SimpleStringProperty(lama_hidup);
        this.penyebaran = new SimpleStringProperty(penyebaran);
        this.foto = new SimpleStringProperty(foto);
        this.jumlah = new SimpleStringProperty(jumlah);
    }
    
    public String getNama() {
        return nama.get();
    }
    
    public String getRingkasan(){
        return ringkasan.get();
    }
    
    public String getMakanan() {
        return makanan.get();
    }
    
    public String getHabitat() {
        return habitat.get();
    }
    
    public String getLamaHidup(){
        return lama_hidup.get();
    }
    
    public String getPenyebaran(){
        return penyebaran.get();
    }
    
    public String getFoto(){
        return foto.get();
    }
    
    public String getJumlah(){
        return jumlah.get();
    }
    
    public void setNama(String value){
        nama.set(value);
    }
    
    public void setRingkasan(String value){
        ringkasan.set(value);
    }
    
    public void setMakanan(String value){
        makanan.set(value);
    }
    
    public void setHabitat(String value){
        habitat.set(value);
    }
    
    public void setLamaHidup(String value){
        lama_hidup.set(value);
    }
    
    public void setPenyebaran(String value){
        penyebaran.set(value);
    }
    
    public void setFoto(String value){
        foto.set(value);
    }
    
    public void setJumlah(String value){
        jumlah.set(value);
    }
}
