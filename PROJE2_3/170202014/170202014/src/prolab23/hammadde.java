/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab23;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author AHMET YILDIRIM
 */
public class hammadde {
    private int id;
    private String sembol;
    private String adi;
    private int firma_id;
    private int ham_id;
    private int miktar;
    private String uretim_tarihi;
    private int raf_omru;
    private int fiyat;
    private String firma_adi;
    private int masraf;
    private int birim_masraf;
    public hammadde(int id, String sembol, String adi) {
        this.id = id;
        this.sembol = sembol;
        this.adi = adi;
    }

    public hammadde() {
    }
    
    public int getId() {
        return id;
    }

    public hammadde(int id, int ham_id, int miktar, String uretim_tarihi, int raf_omru, int masraf) {
         veritabani_islemleri islemler=new veritabani_islemleri();
        this.id = id;
        this.ham_id = ham_id;
        this.miktar = miktar;
        this.uretim_tarihi = uretim_tarihi;
        this.raf_omru = raf_omru;
        this.masraf = masraf;
     //   this.sembol=islemler.Hammadde_idCevir(ham_id);
    }

    public hammadde(int id,int firma_id, int ham_id, int miktar, String uretim_tarihi, int raf_omru, int fiyat) {
        veritabani_islemleri islemler=new veritabani_islemleri();
        this.id=id;
        this.firma_id = firma_id;
        this.ham_id = ham_id;
        this.miktar = miktar;
        this.uretim_tarihi = uretim_tarihi;
        this.raf_omru = raf_omru;
        this.fiyat = fiyat;
        this.firma_adi=islemler.Tedarikci_idCevir(firma_id);
        this.sembol=islemler.Hammadde_idCevir(ham_id);
        this.masraf=(miktar*fiyat)+kargo_ucreti(firma_adi);
        this.birim_masraf=masraf/miktar;
    }
    public int kargo_ucreti(String firma_adi){
        veritabani_islemleri islemler=new veritabani_islemleri();
        int kargo_masrafi= islemler.kargo_masrafi(firma_adi);  
        return kargo_masrafi;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getBirim_masraf() {
        return birim_masraf;
    }

    public void setBirim_masraf(int birim_masraf) {
        this.birim_masraf = birim_masraf;
    }

    public int getFirma_id() {
        return firma_id;
    }

    public int getMasraf() {
        return masraf;
    }

    public void setMasraf(int masraf) {
        this.masraf = masraf;
    }
    
    public void setFirma_id(int firma_id) {
        this.firma_id = firma_id;
    }

    public int getHam_id() {
        return ham_id;
    }

    public void setHam_id(int ham_id) {
        this.ham_id = ham_id;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getUretim_tarihi() {
        return uretim_tarihi;
    }

    public void setUretim_tarihi(String uretim_tarihi) {
        this.uretim_tarihi = uretim_tarihi;
    }

    public int getRaf_omru() {
        return raf_omru;
    }

    public void setRaf_omru(int raf_omru) {
        this.raf_omru = raf_omru;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getFirma_adi() {
        return firma_adi;
    }

    public void setFirma_adi(String firma_adi) {
        this.firma_adi = firma_adi;
    }

    public String getSembol() {
        return sembol;
    }

    public void setSembol(String sembol) {
        this.sembol = sembol;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }
    public hammadde clon(hammadde x){
        return x;
    }
    public boolean  son_kullanma_kontrol(){
        int tarih=Integer.valueOf(getUretim_tarihi());
        int omur=getRaf_omru();
        int yil=tarih%10000;
        tarih=tarih/10000;
        int ay=tarih%100;
        tarih=tarih/100;
        int gun=tarih;
        
        
          Date simdikiZaman = new Date();
        int simdiki_gun=simdikiZaman.getDate();
        int simdiki_ay=simdikiZaman.getMonth()+1;
        int simdiki_yil=simdikiZaman.getYear()+1900;
        
        int yil_fark=simdiki_yil-yil;
        int ay_fark=simdiki_ay-ay;
        int gun_fark=simdiki_gun-gun;
        
        int fark=0;
        fark+=yil_fark*365;
        fark+=ay_fark*30;
        fark+=gun_fark;
        omur =omur*365;
        
        if(fark>omur){
            return true;
        }else{
           return false;
        }
        
        
    
    }
}
