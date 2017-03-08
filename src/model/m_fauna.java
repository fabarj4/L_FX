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
   private final StringProperty makanan;
   private final StringProperty habitat;

    public m_fauna(String nama, String makanan, String habitat) {
        this.nama = new SimpleStringProperty(nama);
        this.makanan = new SimpleStringProperty(makanan);
        this.habitat = new SimpleStringProperty(habitat);
    }
    
    public String getNama() {
        return nama.get();
    }
    
    public String getMakanan() {
        return makanan.get();
    }
    
    public String getHabitat() {
        return habitat.get();
    }
    
    public void setNama(String value){
        nama.set(value);
    }
    
    public void setMakanan(String value){
        makanan.set(value);
    }
    
    public void setHabitat(String value){
        habitat.set(value);
    }
    
    public StringProperty namaProperty() {return nama;}
    public StringProperty makananProperty() {return makanan;}
    public StringProperty habitatProperty() {return habitat;}
}
