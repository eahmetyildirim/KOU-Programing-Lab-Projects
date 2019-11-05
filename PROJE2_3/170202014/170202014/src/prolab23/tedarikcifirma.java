/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab23;

/**
 *
 * @author AHMET YILDIRIM
 */
public class tedarikcifirma {
    private int id;
    private String adi;
    private String ülke;
    private String sehir;

    public tedarikcifirma(int id, String adi, String ülke, String sehir) {
        this.id = id;
        this.adi = adi;
        this.ülke = ülke;
        this.sehir = sehir;
    }

    public tedarikcifirma() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getÜlke() {
        return ülke;
    }

    public void setÜlke(String ülke) {
        this.ülke = ülke;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
    
}
