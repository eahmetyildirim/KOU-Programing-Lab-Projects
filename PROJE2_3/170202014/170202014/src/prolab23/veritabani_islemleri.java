/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab23;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AHMET YILDIRIM
 */
public class veritabani_islemleri {
    private String kullanici_adi = "root";
    private String parola = "";
    private String db_ismi = "prolab23";
    private String host =  "localhost:8080";
    private int port = 3306;
    private Connection con = null;
    
    private Statement sorgum = null;
    private PreparedStatement preparedStatement = null;
    
        
    public veritabani_islemleri(){
           String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
      
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }
        try {
            con =  (Connection) DriverManager.getConnection(url, kullanici_adi, parola);
              
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
            //ex.printStackTrace();
        }
       
     }    
     public boolean ham_ekle(String sembol,String adi){
        String sorgu = "Insert Into ham_adi (sembol,adi) VALUES(?,?)";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1, sembol);
            preparedStatement.setString(2, adi);
            preparedStatement.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return false;
     
     }
     public ArrayList<hammadde> hammadde_listele() {
        
        ArrayList<hammadde> cikti = new ArrayList<hammadde>();
        
        try {
            sorgum =  (Statement) con.createStatement();
            String sorgu =  "Select * From ham_adi";
            
            ResultSet rs =  sorgum.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String sembol = rs.getString("sembol");
                String adi = rs.getString("adi");
               
                cikti.add(new hammadde(id,sembol,adi));
                
                
            }
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
         
    }
      public int hamId_Bul(int id){
       try {
             String sorgu =  "Select * From ham_madde where id=?";
          
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs= preparedStatement.executeQuery();
          int ham_id=0;
            while(rs.next()) {
                 ham_id=rs.getInt("ham_id");
                
              
            }
            return ham_id;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
            
    }
    
    }
    public void hammadde_guncelle(int id,String yeni_sembol,String yeni_adi) {
        String sorgu =  "Update ham_adi set sembol = ? , adi = ? where id = ?";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1,yeni_sembol);
            preparedStatement.setString(2,yeni_adi);  
            preparedStatement.setInt(3, id);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public void hammadde_sil(int id) {
        
        String sorgu = "Delete from ham_adi where id = ?";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }// HAM MADDE EKLEME SONU
    public boolean hamMadde_uret(int firma_id,int ham_id,int miktar,int rafomru,int fiyat,String uretim_tarihi){
             String sorgu = "Insert Into ham_madde (tfirma_id ,ham_id,miktar,uretim_tarihi,rafomru,fiyat) VALUES(?,?,?,?,?,?)";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            
            
            preparedStatement.setInt(1, firma_id);
            preparedStatement.setInt(2, ham_id);
            preparedStatement.setInt(3, miktar);
            preparedStatement.setString(4, uretim_tarihi);
            preparedStatement.setInt(5, rafomru);
            preparedStatement.setInt(6, fiyat);
                    
            preparedStatement.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return false;
    }
    public String Hammadde_idCevir(int id){
       try {
           
            sorgum =  (Statement) con.createStatement();
            String sorgu =  "Select * From ham_adi where id="+id+"";
            
            ResultSet rs =  sorgum.executeQuery(sorgu);
            String ad = null;
            while(rs.next()) {
                 ad = rs.getString("sembol");
                   
            }
            return ad;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }

    }
    public String Tedarikci_idCevir(int id){
       try {
           
            sorgum =  (Statement) con.createStatement();
            String sorgu =  "Select * From tedarikci_firma where id="+id+"";
            
            ResultSet rs =  sorgum.executeQuery(sorgu);
            String ad = null;
            while(rs.next()) {
                 ad = rs.getString("firma_adi");
                   
            }
            return ad;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }

    }
    public ArrayList<hammadde> hamUret_listele() {
        
        ArrayList<hammadde> cikti = new ArrayList<hammadde>();
        
        try {
            sorgum =  (Statement) con.createStatement();
            String sorgu =  "Select * From ham_madde";
            
            ResultSet rs =  sorgum.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int firma_id=rs.getInt("tfirma_id");
                int ham_id=rs.getInt("ham_id");
                int miktar=rs.getInt("miktar");
                String uretimTarihi = rs.getString("uretim_tarihi");
                int raf_omru =rs.getInt("rafomru");
                int fiyat =rs.getInt("fiyat");
               
                cikti.add(new hammadde(id, firma_id, ham_id, miktar, uretimTarihi, raf_omru, fiyat));
                
                
            }
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
         
    }
    public boolean tedarikcifirma_ekle(String adi,String ulke,String sehir){
        String sorgu = "Insert Into tedarikci_firma (firma_adi,ulke,sehir) VALUES(?,?,?)";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1, adi);
            preparedStatement.setString(2, ulke);
            preparedStatement.setString(3, sehir);
            preparedStatement.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return false;
     
     }
    
     public ArrayList<tedarikcifirma> tedarikcifirma_listele() {
        
        ArrayList<tedarikcifirma> cikti = new ArrayList<tedarikcifirma>();
        
        try {
            sorgum =  (Statement) con.createStatement();
            String sorgu =  "Select * From tedarikci_firma";
            
            ResultSet rs =  sorgum.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String adi = rs.getString("firma_adi");
                String ulke = rs.getString("ulke");
                String sehir = rs.getString("sehir");
               
                cikti.add(new tedarikcifirma(id,adi,ulke,sehir));
                
                
            }
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
         
    }
     
    public void tedarikcifirma_guncelle(int id,String yeni_adi,String yeni_ulke,String yeni_sehir) {
        String sorgu =  "Update tedarikci_firma set firma_adi = ? , ulke = ? , sehir=? where id = ?";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1,yeni_adi);
            preparedStatement.setString(2,yeni_ulke);  
            preparedStatement.setString(3, yeni_sehir);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public void tedarikcifirma_sil(int id){
        
        String sorgu = "Delete from tedarikci_firma where id = ?";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        // TEDARİKÇİ FİRMA İŞLEMLERİ SONU
       public boolean musteri_ekle(String isim,String adres){
        String sorgu = "Insert Into musteri (isim,adres) VALUES(?,?)";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1, isim);
            preparedStatement.setString(2, adres);
            preparedStatement.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return false;
     
     }
    
     public ArrayList<musteri> musteri_listele() {
        
        ArrayList<musteri> cikti = new ArrayList<musteri>();
        
        try {
            sorgum =  (Statement) con.createStatement();
            String sorgu =  "Select * From musteri";
            
            ResultSet rs =  sorgum.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String isim = rs.getString("isim");
                String adres = rs.getString("adres");
                
                cikti.add(new musteri(id,isim,adres));
                
                
            }
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
         
    }
     
    public void musteri_guncelle(int id,String yeni_isim,String yeni_adres) {
        String sorgu =  "Update musteri set isim = ? , adres = ?  where id = ?";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1,yeni_isim);
            preparedStatement.setString(2,yeni_adres);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public void musteri_sil(int id) {
        
        String sorgu = "Delete from musteri where id = ?";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public ArrayList<hammadde> tedarikci_urun_listele(int ham_id){
       ArrayList<hammadde> cikti = new ArrayList<hammadde>();
        
        try {
            
            String sorgu =  "Select * From ham_madde where ham_id=?";
          
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setInt(1, ham_id);
            ResultSet rs= preparedStatement.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int firma_id=rs.getInt("tfirma_id");
                int miktar=rs.getInt("miktar");
                String uretim_tarihi=rs.getString("uretim_tarihi");
                int raf_omru=rs.getInt("rafomru");
                int fiyat=rs.getInt("fiyat");
                 cikti.add(new hammadde(id, firma_id,  ham_id,  miktar,  uretim_tarihi,  raf_omru,  fiyat));
               
                
            }
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
    }
   public int kargo_mesafesi(String sehir){
           try {
             String sorgu =  "Select * From mesafe where sehir1=?";
          
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setString(1, sehir);
            ResultSet rs= preparedStatement.executeQuery();
          int uzaklik=0;
            while(rs.next()) {
                 uzaklik=rs.getInt("uzaklik");
                
              
            }
            return uzaklik;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
            
    }
    }
    
    public int kargo_masrafi(String firma_adi){
    
        try {
             String sorgu =  "Select * From tedarikci_firma where firma_adi=?";
          
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setString(1, firma_adi);
            ResultSet rs= preparedStatement.executeQuery();
            String ulke = null;
            String sehir = null;
             while(rs.next()) {
                 ulke= rs.getString("ulke");
                 sehir= rs.getString("sehir");
                
                
                
            }
            
            if(ulke.equals("TÜRKİYE")){
                
                    return (int) ((0.5)*kargo_mesafesi(sehir));
                
                }else{
                     return kargo_mesafesi(sehir);
                }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
            
    }
}
    public void tutar_ekle(int tutar){
          String sorgu = "Insert Into muhasebe (tutar) VALUES(?)";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);          
            preparedStatement.setInt(1,tutar);   
              preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void HamMaddeAl(int id,int ham_id,int veri_miktar, int miktar, int toplam_maliyet) {
         ArrayList<hammadde>  liste =tedarikci_urun_listele(ham_id);
         
         String uretim_tarihi=null;
         int raf_omru=0;
   
         for(int i=0;i<liste.size();i++){
             if(liste.get(i).getId()==id){
                 uretim_tarihi=liste.get(i).getUretim_tarihi();
                 raf_omru=liste.get(i).getRaf_omru();
                 break;
             }
         }
 
         
         int alis_maliyeti=toplam_maliyet/miktar;
        String sorgu1 = "Insert Into uretici_hammadde (ham_id,alis_maliyeti,stok,uretim_tarihi,rafomru) VALUES(?,?,?,?,?)";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu1);
            
            
            preparedStatement.setInt(1,ham_id);
            preparedStatement.setInt(2, alis_maliyeti);
            preparedStatement.setInt(3, miktar);
            preparedStatement.setString(4,uretim_tarihi);
            preparedStatement.setInt(5,raf_omru);    
            preparedStatement.executeUpdate();
            int tutar =-1*alis_maliyeti;
            tutar_ekle(tutar);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
           if(veri_miktar==miktar){
               String sorgu = "Delete from ham_madde where id = ?";
        
                try {
                preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            
                } catch (SQLException ex) {
                Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }else{
                 String sorgu =  "Update ham_madde set miktar = ?   where id = ?";
        
                try {
                 preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            
            
                    int yeni_miktar=veri_miktar-miktar;
                    preparedStatement.setInt(1,yeni_miktar);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
            
                } catch (SQLException ex) {
                Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
    }
    
    
     public boolean kimyasalAdi_ekle(String  ad){
          String sorgu = "Insert Into kimyasal_madde_adi (adi) VALUES(?)";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);          
            preparedStatement.setString(1,ad); 
              preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public ArrayList<KimyasalMadde> KimyasalAdi_Listele(){
    
       ArrayList<KimyasalMadde> cikti = new ArrayList<KimyasalMadde>();
        
        try {
            sorgum =  (Statement) con.createStatement();
            String sorgu =  "Select * From kimyasal_madde_adi";
            
            ResultSet rs =  sorgum.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String kimyasal_adi=rs.getString("adi");
              
               
                cikti.add(new KimyasalMadde(id, kimyasal_adi));
                
                
            }
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
    }
    public boolean KimyasalHam_Ekle(int kimyasal_id,int ham_id,int adet){
    
     String sorgu = "Insert Into kimyasalmadde_atomlari (kimyasal_id,ham_id,adeti) VALUES(?,?,?)";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);          
            preparedStatement.setInt(1,kimyasal_id); 
            preparedStatement.setInt(2,ham_id); 
            preparedStatement.setInt(3,adet); 
              preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    public ArrayList<KimyasalMadde> KimyasalHamID_Listele(int kimyasal_id){
        
           ArrayList<KimyasalMadde> cikti = new ArrayList<KimyasalMadde>();
        
        try {
            sorgum =  (Statement) con.createStatement();
            String sorgu =  "Select * From kimyasalmadde_atomlari where kimyasal_id=?";
              preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);          
            preparedStatement.setInt(1,kimyasal_id); 
             
            ResultSet rs=  preparedStatement.executeQuery();
          
            //ResultSet rs =  sorgum.executeQuery(sorgu);
            
            while(rs.next()) {
                int ham_id = rs.getInt("ham_id");
                int adedi = rs.getInt("adeti");
                cikti.add(new KimyasalMadde(kimyasal_id,adedi,ham_id));
              
            }
            
                
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
    
    
    }
    
    public ArrayList<hammadde> uretici_hammadde_listele() {
        
        ArrayList<hammadde> cikti = new ArrayList<hammadde>();
        
        try {
            sorgum =  (Statement) con.createStatement();
            String sorgu =  "Select * From uretici_hammadde";
            
            ResultSet rs =  sorgum.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int ham_id=rs.getInt("ham_id");
                int alis_maliyeti=rs.getInt("alis_maliyeti");
                  String uretim_tarihi = rs.getString("uretim_tarihi");
                int raf_omru =rs.getInt("rafomru");
                int miktar =rs.getInt("stok");
                     
               
                cikti.add(new hammadde(id,  ham_id,  miktar,  uretim_tarihi,  raf_omru,  alis_maliyeti));
                
                
            }
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
         
    }
    public boolean ureticiHammadde_Sil(int id){
    
         String sorgu = "Delete from uretici_hammadde where id =?";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return  true;
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    
    }
    public void uretici_tarih_gecti_mi(){
    
              ArrayList<hammadde> cikti = new ArrayList<hammadde>();
        
        try {
            sorgum =  (Statement) con.createStatement();
            String sorgu =  "Select * From uretici_hammadde";
            
            ResultSet rs =  sorgum.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int ham_id=rs.getInt("ham_id");
                int alis_maliyeti=rs.getInt("alis_maliyeti");
                  String uretim_tarihi = rs.getString("uretim_tarihi");
                int raf_omru =rs.getInt("rafomru");
                int miktar =rs.getInt("stok");
                     
               
                cikti.add(new hammadde(id,  ham_id,  miktar,  uretim_tarihi,  raf_omru,  alis_maliyeti));
                
                
            }
      
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
          
            
        }
    
            for(int i=0;i<cikti.size();i++){
               boolean kontrol=cikti.get(i).son_kullanma_kontrol();
               if(kontrol==true){
                   ureticiHammadde_Sil(cikti.get(i).getId());
                   System.out.println("Bu kimyasalı siliyorum dostum");
               }
            
            }
    }
  
    public boolean  ham_var_mi(int ham_id,int ham_adet,int miktar,int adet){
      String sorgu =  "Select * From uretici_hammadde where ham_id=?";
     try {
          
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setInt(1, ham_id);
            ResultSet  rs = preparedStatement.executeQuery();
            int stok = 0;
            while(rs.next()){
                stok+=rs.getInt("stok");
            }
            int lazim_miktar=(miktar*ham_adet)/adet;
            System.out.println("Stok"+stok);
            if(stok>=lazim_miktar){
            return true;
            }else{
            return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
    
    }
    
    public ArrayList<KimyasalMadde> Uretici_HamStokAzalt(int ham_id,int ham_miktar){
    
        ArrayList<KimyasalMadde> cikti = new ArrayList<KimyasalMadde>();
         String sorgu =  "Select * From uretici_hammadde where ham_id=?";
        try {
           
           
              preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setInt(1, ham_id);
            ResultSet  rs = preparedStatement.executeQuery();
           
            int say=0;
            while(rs.next()) {
                int id = rs.getInt("id");
                int alis_maliyeti=rs.getInt("alis_maliyeti");
                  String uretim_tarihi = rs.getString("uretim_tarihi");
                int raf_omru =rs.getInt("rafomru");
                int miktar =rs.getInt("stok");
                say+=miktar;    
                cikti.add(new KimyasalMadde(id,  ham_id,  miktar,  alis_maliyeti,uretim_tarihi,  raf_omru));
               
                if(say>=ham_miktar){
                break;
                }
                
                
            }
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
    
    
    }
    public void KimyasalUret_HamSil(int id){
        
         String sorgu = "Delete from uretici_hammadde where id =?";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
           System.out.println("Yeni bilgiler silindi.");
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
    }
    
    public void KimsayalUret_HamMiktarGuncelle(int id,int miktar) {
        String sorgu =  "Update uretici_hammadde set stok = ?   where id = ?";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            
            
            preparedStatement.setInt(1,miktar);
            preparedStatement.setInt(2,id);
            
            preparedStatement.executeUpdate();
            
               System.out.println("Yeni bilgiler güncellendi.");
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public boolean kimyasal_ekle(int kimyasal_id,String uretim_tarihi,int raf_omru,int iscilik_maliyeti,int toplam_maliyet,int fiyat){
    
        String sorgu = "Insert Into uretilen_kimyasal (kimyasal_id,uretim_tarihi,raf_omru,iscilik_maliyeti,toplam_maliyet,satis_fiyati) VALUES(?,?,?,?,?,?)";
        
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);          
            preparedStatement.setInt(1,kimyasal_id); 
            preparedStatement.setString(2, uretim_tarihi);
            preparedStatement.setInt(3,raf_omru); 
            preparedStatement.setInt(4,iscilik_maliyeti);
            preparedStatement.setInt(5,toplam_maliyet);
            preparedStatement.setInt(6,fiyat);
              preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    
    
    
    }
    public ArrayList<Integer> muhasebe(){
    
      ArrayList<Integer> cikti = new ArrayList<Integer>();
         String sorgu =  "Select * From muhasebe";
        try {
           
           
              preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            
            ResultSet  rs = preparedStatement.executeQuery();
           
            int say=0;
            while(rs.next()) {
               
                int tutar=rs.getInt("tutar");
                cikti.add(new Integer(tutar));
            }
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
    
    
    }
}