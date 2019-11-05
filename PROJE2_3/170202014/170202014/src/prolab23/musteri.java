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
public class musteri {
    private int id;
    private String ad;
    private String adres;

    public musteri() {
    }

    public musteri(int id, String ad, String adres) {
        this.id = id;
        this.ad = ad;
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    
}
