/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab23;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.table.DefaultTableModel;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author AHMET YILDIRIM
 */
public class ekran extends javax.swing.JDialog {
            DefaultTableModel ham_model;
            DefaultTableModel hamUret_ham_model;
            DefaultTableModel tedarikci_model;
            DefaultTableModel hamUret_tedarikci_model;
            DefaultTableModel musteriEkle_model;
            DefaultTableModel hamUretListele_model;
            DefaultTableModel hamMadde_listele_model;
            DefaultTableModel HamMaddeAl_Listele_model;
            
             veritabani_islemleri islemler=new veritabani_islemleri();
       
            /**
     * Creates new form ekran
     */
    public ekran(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ham_model=(DefaultTableModel) ham_tablo.getModel();
        hamUret_ham_model=(DefaultTableModel) hamUret_hammadde_tablo.getModel();
        tedarikci_model=(DefaultTableModel) tedarikci_tablo.getModel();
        hamUret_tedarikci_model=(DefaultTableModel) hamUret_firma_tablo.getModel();
        musteriEkle_model=(DefaultTableModel) musteriEkle_tablo.getModel();
        hamUretListele_model=(DefaultTableModel) hamUret_Listele_tablo.getModel();
        hamMadde_listele_model=(DefaultTableModel) hammadde_listele_tablo.getModel();
        HamMaddeAl_Listele_model=(DefaultTableModel) tedarikci_urunsat_tablo.getModel();
        
        
        jpanel_kapat();
        hammadde_listele();
        tedarikci_listele();
        musteri_listele();
        hamUret_tedarikci_listele();
        hamUret_hammadde_listele();
        hamUret_ham_Listele();
       
    }
    public void jpanel_kapat(){
    hammadde.setVisible(false);
    tedarikciFirma.setVisible(false);
    musteriEkle.setVisible(false);
    musteriSiparis.setVisible(false);
    hamuret.setVisible(false);
    hammadde_al.setVisible(false);
    hammadde_al_1.setVisible(false);
    }
 
    public void hammadde_listele(){
        ham_model.setRowCount(0);
              ArrayList<hammadde> listele=new ArrayList<>();
           listele=islemler.hammadde_listele();
                if(listele!=null){
                    for(hammadde x:listele){
                    Object[] eklenecek ={x.getId(),x.getSembol(),x.getAdi()};
                    ham_model.addRow(eklenecek);
                    }
                }
    }
    public void hamUret_hammadde_listele(){
        hamUret_ham_model.setRowCount(0);
        hamMadde_listele_model.setRowCount(0);
              ArrayList<hammadde> listele=new ArrayList<>();
           listele=islemler.hammadde_listele();
                if(listele!=null){
                    for(hammadde x:listele){
                    Object[] eklenecek ={x.getId(),x.getSembol()};
                    hamUret_ham_model.addRow(eklenecek);
                    hamMadde_listele_model.addRow(eklenecek);
                    }
                }
    }
    public void tedarikci_listele(){
        tedarikci_model.setRowCount(0);
              ArrayList<tedarikcifirma> listele=new ArrayList<>();
           listele=islemler.tedarikcifirma_listele();
                if(listele!=null){
                    for(tedarikcifirma x:listele){
                    Object[] eklenecek ={x.getId(),x.getAdi(),x.getÜlke(),x.getSehir()};
                    tedarikci_model.addRow(eklenecek);
                    }
                }
    }
    public void hamUret_tedarikci_listele(){
        hamUret_tedarikci_model.setRowCount(0);
              ArrayList<tedarikcifirma> listele=new ArrayList<>();
           listele=islemler.tedarikcifirma_listele();
                if(listele!=null){
                    for(tedarikcifirma x:listele){
                    Object[] eklenecek ={x.getId(),x.getAdi()};
                    hamUret_tedarikci_model.addRow(eklenecek);
                    }
                }
    }
    
    public void hamUret_ham_Listele(){
                hamUretListele_model.setRowCount(0);
              ArrayList<hammadde> listele=new ArrayList<>();
                listele=islemler.hamUret_listele();
                if(listele!=null){
                    for(hammadde x:listele){
                    Object[] eklenecek ={x.getId(),x.getFirma_adi(),x.getSembol(),x.getMiktar(),x.getFiyat()};
                       hamUretListele_model.addRow(eklenecek);
                    }
                }
    }
    
    
    public void musteri_listele(){
        musteriEkle_model.setRowCount(0);
              ArrayList<musteri> listele=new ArrayList<>();
           listele=islemler.musteri_listele();
                if(listele!=null){
                    for(musteri x:listele){
                    Object[] eklenecek ={x.getId(),x.getAd(),x.getAdres()};
                    musteriEkle_model.addRow(eklenecek);
                    }
                }
    }
     public ArrayList<hammadde> sirala(ArrayList<hammadde> liste){
                   int i,j;
        hammadde tmp;
        int n =liste.size()-1;
        for(i=0;i<n;i++){
            for(j=0;j<n-i;j++){
                if(liste.get(j).getMasraf()>liste.get(j+1).getMasraf()){
                    tmp=liste.get(j);
                    liste.set(j,liste.get(j+1));
                    liste.set(j+1, tmp);
                }
            }
        
        }
    return liste;
     
     }
     public void HamMaddeAl_Listele(int ham_id){
                HamMaddeAl_Listele_model.setRowCount(0);
              ArrayList<hammadde> listele=new ArrayList<>();
                listele=islemler.tedarikci_urun_listele(ham_id);
                listele=sirala(listele);
   
                
                if(listele!=null){
                    for(hammadde x:listele){
                    Object[] eklenecek ={x.getId(),x.getFirma_id(),x.getFirma_adi(),x.getSembol(),x.getMiktar(),x.getMasraf(),x.getBirim_masraf()};
                       HamMaddeAl_Listele_model.addRow(eklenecek);
                    }
                }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hamuret = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        hamUret_firma_tablo = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        hamUret_secilen_id = new javax.swing.JLabel();
        hamUret_secilen_firmadi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        hamUret_hammadde_tablo = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        hamUret_secilen_hamid = new javax.swing.JLabel();
        hamUret_secilen_hammadde = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        hamUret_uretimtarihi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        hamUret_miktar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        hamUret_rafomru = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        hamUret_fiyat = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        hamUret_ekle = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        hamUret_Listele_tablo = new javax.swing.JTable();
        hamUret_sil = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        musteriSiparis = new javax.swing.JPanel();
        musteriEkle = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        musteriEkle_id = new javax.swing.JLabel();
        musteriEkle_adi = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        musteriEkle_adres = new javax.swing.JTextArea();
        musteriEkle_sil = new javax.swing.JButton();
        musteriEkle_ekle = new javax.swing.JButton();
        musteriEkle_guncelle = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        musteriEkle_tablo = new javax.swing.JTable();
        tedarikciFirma = new javax.swing.JPanel();
        tedarikcifirma_id = new javax.swing.JLabel();
        tedarikci_ulkelabel = new javax.swing.JLabel();
        tedarikci_adilabel = new javax.swing.JLabel();
        tedarikci_sehirlabel = new javax.swing.JLabel();
        tedarikci_adi = new javax.swing.JTextField();
        tedarikci_sehir = new javax.swing.JTextField();
        tedarikci_ulke = new javax.swing.JTextField();
        tedarikci_guncelle = new javax.swing.JButton();
        tedarikci_sil = new javax.swing.JButton();
        tedarikci_ekle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tedarikci_tablo = new javax.swing.JTable();
        hammadde = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ham_sembolu = new javax.swing.JTextField();
        ham_adi = new javax.swing.JTextField();
        ham_ekle = new javax.swing.JButton();
        ham_guncelle = new javax.swing.JButton();
        ham_sil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ham_tablo = new javax.swing.JTable();
        ham_mesaj = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ham_id = new javax.swing.JLabel();
        Jpanel1 = new javax.swing.JPanel();
        hammadde_al = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        hammadde_listele_tablo = new javax.swing.JTable();
        hammaddeAl_hamsecbtn = new javax.swing.JButton();
        hammadde_al_1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tedarikci_urunsat_tablo = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        hammaddeAl_alincakMiktar = new javax.swing.JTextField();
        hamMadde_al_buton = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        hamMaddeAl_mesaj = new javax.swing.JLabel();
        KimyasalMadde_uret = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        KimyasalUret_hammadde_tablo = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        Kimyasal_adi_ekle = new javax.swing.JTextField();
        kimyasalAdi_ekle = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        HammaddeAl = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        ham = new javax.swing.JMenu();
        hammadde_uret = new javax.swing.JMenu();
        tedarikci_firma = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        musteri_ekle = new javax.swing.JMenu();
        HamMaddeAl = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        kimyasal_ekle = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Üretecek firmayı seçiniz");

        hamUret_firma_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Firma Adı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hamUret_firma_tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hamUret_firma_tabloMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(hamUret_firma_tablo);
        if (hamUret_firma_tablo.getColumnModel().getColumnCount() > 0) {
            hamUret_firma_tablo.getColumnModel().getColumn(0).setResizable(false);
            hamUret_firma_tablo.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Seçilen Firma:");

        hamUret_secilen_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        hamUret_secilen_firmadi.setEditable(false);
        hamUret_secilen_firmadi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hamUret_secilen_firmadi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Üretecek hammadde seçiniz");

        hamUret_hammadde_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Hammade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hamUret_hammadde_tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hamUret_hammadde_tabloMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(hamUret_hammadde_tablo);
        if (hamUret_hammadde_tablo.getColumnModel().getColumnCount() > 0) {
            hamUret_hammadde_tablo.getColumnModel().getColumn(0).setResizable(false);
            hamUret_hammadde_tablo.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Seçilen Hammadde:");

        hamUret_secilen_hamid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        hamUret_secilen_hammadde.setEditable(false);
        hamUret_secilen_hammadde.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hamUret_secilen_hammadde.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Miktar:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Üretim Tarihi:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Kg");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Örn: 20032019");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Raf Ömrü:");

      

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Yıl");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Fiyat:");

   

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("TL");

        hamUret_ekle.setText("Ekle");
      

        hamUret_Listele_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Firma Adı", "Ham Madde", "Miktarı", "Fiyatı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(hamUret_Listele_tablo);
        if (hamUret_Listele_tablo.getColumnModel().getColumnCount() > 0) {
            hamUret_Listele_tablo.getColumnModel().getColumn(0).setResizable(false);
            hamUret_Listele_tablo.getColumnModel().getColumn(1).setResizable(false);
            hamUret_Listele_tablo.getColumnModel().getColumn(2).setResizable(false);
            hamUret_Listele_tablo.getColumnModel().getColumn(3).setResizable(false);
            hamUret_Listele_tablo.getColumnModel().getColumn(4).setResizable(false);
        }

        hamUret_sil.setBackground(new java.awt.Color(0, 204, 255));
        hamUret_sil.setText("Sil");
       

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Hammaddeler:");

        javax.swing.GroupLayout hamuretLayout = new javax.swing.GroupLayout(hamuret);
        hamuret.setLayout(hamuretLayout);
        hamuretLayout.setHorizontalGroup(
            hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hamuretLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hamuretLayout.createSequentialGroup()
                        .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(hamuretLayout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hamuretLayout.createSequentialGroup()
                                        .addComponent(hamUret_secilen_id, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hamUret_secilen_firmadi, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(hamuretLayout.createSequentialGroup()
                                        .addComponent(hamUret_secilen_hamid, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(hamuretLayout.createSequentialGroup()
                                                .addComponent(hamUret_rafomru, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(hamuretLayout.createSequentialGroup()
                                                .addComponent(hamUret_fiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(hamuretLayout.createSequentialGroup()
                                                .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(hamUret_secilen_hammadde)
                                                    .addGroup(hamuretLayout.createSequentialGroup()
                                                        .addComponent(hamUret_miktar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(hamUret_uretimtarihi))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel14))
                                            .addGroup(hamuretLayout.createSequentialGroup()
                                                .addComponent(hamUret_ekle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(hamUret_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(39, 39, 39))
                    .addGroup(hamuretLayout.createSequentialGroup()
                        .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hamuretLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9))
                        .addContainerGap(94, Short.MAX_VALUE))))
        );
        hamuretLayout.setVerticalGroup(
            hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hamuretLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(hamuretLayout.createSequentialGroup()
                        .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(hamuretLayout.createSequentialGroup()
                                .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hamuretLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(hamuretLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hamUret_secilen_firmadi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hamUret_secilen_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8)
                                        .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hamUret_secilen_hamid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hamUret_secilen_hammadde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(hamuretLayout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(hamUret_miktar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(hamuretLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(hamuretLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(hamuretLayout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel12))
                                            .addGroup(hamuretLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(hamUret_uretimtarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel14))))
                                        .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(hamuretLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel15)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hamuretLayout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(hamUret_rafomru, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(hamuretLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17))
                                    .addGroup(hamuretLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(hamuretLayout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(hamUret_fiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9))
                    .addGroup(hamuretLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hamUret_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hamUret_ekle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hamuretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout musteriSiparisLayout = new javax.swing.GroupLayout(musteriSiparis);
        musteriSiparis.setLayout(musteriSiparisLayout);
        musteriSiparisLayout.setHorizontalGroup(
            musteriSiparisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
        );
        musteriSiparisLayout.setVerticalGroup(
            musteriSiparisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("ID");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Adres");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Müşteri Adı");

        musteriEkle_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

 

        musteriEkle_adres.setColumns(20);
        musteriEkle_adres.setRows(5);
        jScrollPane3.setViewportView(musteriEkle_adres);

        musteriEkle_sil.setText("Sil");
        musteriEkle_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musteriEkle_silActionPerformed(evt);
            }
        });

        musteriEkle_ekle.setText("Ekle");
        musteriEkle_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musteriEkle_ekleActionPerformed(evt);
            }
        });

        musteriEkle_guncelle.setText("Güncelle");
        musteriEkle_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musteriEkle_guncelleActionPerformed(evt);
            }
        });

        musteriEkle_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "İSİM", "ADRES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        musteriEkle_tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                musteriEkle_tabloMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(musteriEkle_tablo);
        if (musteriEkle_tablo.getColumnModel().getColumnCount() > 0) {
            musteriEkle_tablo.getColumnModel().getColumn(0).setResizable(false);
            musteriEkle_tablo.getColumnModel().getColumn(1).setResizable(false);
            musteriEkle_tablo.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout musteriEkleLayout = new javax.swing.GroupLayout(musteriEkle);
        musteriEkle.setLayout(musteriEkleLayout);
        musteriEkleLayout.setHorizontalGroup(
            musteriEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musteriEkleLayout.createSequentialGroup()
                .addGroup(musteriEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(musteriEkleLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(musteriEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(musteriEkleLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(musteriEkle_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(musteriEkleLayout.createSequentialGroup()
                                .addGroup(musteriEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(musteriEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(musteriEkleLayout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(musteriEkle_id))
                                    .addGroup(musteriEkleLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, musteriEkleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(musteriEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(musteriEkle_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(musteriEkle_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(musteriEkle_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        musteriEkleLayout.setVerticalGroup(
            musteriEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musteriEkleLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(musteriEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(musteriEkleLayout.createSequentialGroup()
                        .addGroup(musteriEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(musteriEkle_id))
                        .addGap(10, 10, 10)
                        .addGroup(musteriEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(musteriEkle_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(musteriEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(musteriEkle_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(musteriEkle_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(musteriEkle_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(266, Short.MAX_VALUE))
        );

        tedarikcifirma_id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tedarikcifirma_id.setText("Firma ID");

        tedarikci_ulkelabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tedarikci_ulkelabel.setText("Ülke");

        tedarikci_adilabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tedarikci_adilabel.setText("Firma Adı");

        tedarikci_sehirlabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tedarikci_sehirlabel.setText("Şehir");

        tedarikci_adi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      

        tedarikci_sehir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        

        tedarikci_ulke.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
   

        tedarikci_guncelle.setText("Güncelle");
        tedarikci_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tedarikci_guncelleActionPerformed(evt);
            }
        });

        tedarikci_sil.setText("Sil");
        tedarikci_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tedarikci_silActionPerformed(evt);
            }
        });

        tedarikci_ekle.setText("Ekle");
        tedarikci_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tedarikci_ekleActionPerformed(evt);
            }
        });

        tedarikci_tablo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tedarikci_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Firma ID", "Firma Adı", "Ülke", "Şehir"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tedarikci_tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tedarikci_tabloMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tedarikci_tablo);
        if (tedarikci_tablo.getColumnModel().getColumnCount() > 0) {
            tedarikci_tablo.getColumnModel().getColumn(0).setResizable(false);
            tedarikci_tablo.getColumnModel().getColumn(1).setResizable(false);
            tedarikci_tablo.getColumnModel().getColumn(2).setResizable(false);
            tedarikci_tablo.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout tedarikciFirmaLayout = new javax.swing.GroupLayout(tedarikciFirma);
        tedarikciFirma.setLayout(tedarikciFirmaLayout);
        tedarikciFirmaLayout.setHorizontalGroup(
            tedarikciFirmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tedarikciFirmaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(tedarikciFirmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tedarikciFirmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(tedarikciFirmaLayout.createSequentialGroup()
                            .addComponent(tedarikci_adilabel)
                            .addGap(18, 18, 18)
                            .addComponent(tedarikci_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tedarikcifirma_id)
                        .addGroup(tedarikciFirmaLayout.createSequentialGroup()
                            .addGroup(tedarikciFirmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tedarikci_sehirlabel)
                                .addComponent(tedarikci_ulkelabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(tedarikciFirmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tedarikci_ulke, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tedarikci_sehir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tedarikciFirmaLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(tedarikci_ekle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tedarikci_guncelle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tedarikci_sil)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        tedarikciFirmaLayout.setVerticalGroup(
            tedarikciFirmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tedarikciFirmaLayout.createSequentialGroup()
                .addGroup(tedarikciFirmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tedarikciFirmaLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(tedarikcifirma_id)
                        .addGap(18, 18, 18)
                        .addGroup(tedarikciFirmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tedarikci_adilabel)
                            .addComponent(tedarikci_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(tedarikciFirmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tedarikci_ulkelabel)
                            .addComponent(tedarikci_ulke, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(tedarikciFirmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tedarikciFirmaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(tedarikciFirmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tedarikci_sehirlabel)
                                    .addComponent(tedarikci_sehir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(tedarikciFirmaLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(tedarikciFirmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tedarikci_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tedarikci_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tedarikci_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(tedarikciFirmaLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Adı");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Sembolü");

      

        ham_ekle.setText("Ekle");
        ham_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ham_ekleActionPerformed(evt);
            }
        });

        ham_guncelle.setText("Güncelle");
        ham_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ham_guncelleActionPerformed(evt);
            }
        });

        ham_sil.setText("Sil");
        ham_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ham_silActionPerformed(evt);
            }
        });

        ham_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "sembol", "adi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ham_tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ham_tabloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ham_tablo);
        if (ham_tablo.getColumnModel().getColumnCount() > 0) {
            ham_tablo.getColumnModel().getColumn(0).setResizable(false);
            ham_tablo.getColumnModel().getColumn(1).setResizable(false);
            ham_tablo.getColumnModel().getColumn(2).setResizable(false);
        }

        ham_mesaj.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ham_mesaj.setForeground(new java.awt.Color(255, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("ID");

        ham_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout hammaddeLayout = new javax.swing.GroupLayout(hammadde);
        hammadde.setLayout(hammaddeLayout);
        hammaddeLayout.setHorizontalGroup(
            hammaddeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hammaddeLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(hammaddeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hammaddeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ham_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ham_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ham_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(584, 584, 584))
                    .addGroup(hammaddeLayout.createSequentialGroup()
                        .addGroup(hammaddeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ham_mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(hammaddeLayout.createSequentialGroup()
                                .addGroup(hammaddeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGroup(hammaddeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hammaddeLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(hammaddeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ham_sembolu)
                                            .addComponent(ham_adi, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
                                    .addGroup(hammaddeLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(ham_id, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(hammaddeLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 701, Short.MAX_VALUE))
        );
        hammaddeLayout.setVerticalGroup(
            hammaddeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hammaddeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(hammaddeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(ham_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hammaddeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ham_sembolu, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hammaddeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ham_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ham_mesaj)
                .addGap(4, 4, 4)
                .addGroup(hammaddeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ham_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ham_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ham_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout Jpanel1Layout = new javax.swing.GroupLayout(Jpanel1);
        Jpanel1.setLayout(Jpanel1Layout);
        Jpanel1Layout.setHorizontalGroup(
            Jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 881, Short.MAX_VALUE)
        );
        Jpanel1Layout.setVerticalGroup(
            Jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setText("Alacağınız ham maddeyi seçiniz:");

        hammadde_listele_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ADI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(hammadde_listele_tablo);
        if (hammadde_listele_tablo.getColumnModel().getColumnCount() > 0) {
            hammadde_listele_tablo.getColumnModel().getColumn(0).setResizable(false);
            hammadde_listele_tablo.getColumnModel().getColumn(1).setResizable(false);
        }

        hammaddeAl_hamsecbtn.setText("Firmaları Getir");
        hammaddeAl_hamsecbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hammaddeAl_hamsecbtnActionPerformed(evt);
            }
        });

        tedarikci_urunsat_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Firma ID", "Firma Adı", "Ham Madde", "Miktarı", "Toplam Maliyet", "Birim Maliyet"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
     
        jScrollPane8.setViewportView(tedarikci_urunsat_tablo);
        if (tedarikci_urunsat_tablo.getColumnModel().getColumnCount() > 0) {
            tedarikci_urunsat_tablo.getColumnModel().getColumn(0).setResizable(false);
            tedarikci_urunsat_tablo.getColumnModel().getColumn(1).setResizable(false);
            tedarikci_urunsat_tablo.getColumnModel().getColumn(2).setResizable(false);
            tedarikci_urunsat_tablo.getColumnModel().getColumn(3).setResizable(false);
            tedarikci_urunsat_tablo.getColumnModel().getColumn(4).setResizable(false);
            tedarikci_urunsat_tablo.getColumnModel().getColumn(5).setResizable(false);
            tedarikci_urunsat_tablo.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel21.setText("Firmayı seçiniz");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel22.setText("Alacağınız Miktar:");

       

        hamMadde_al_buton.setText("AL");
        hamMadde_al_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hamMadde_al_butonActionPerformed(evt);
            }
        });

        hamMaddeAl_mesaj.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout hammadde_al_1Layout = new javax.swing.GroupLayout(hammadde_al_1);
        hammadde_al_1.setLayout(hammadde_al_1Layout);
        hammadde_al_1Layout.setHorizontalGroup(
            hammadde_al_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hammadde_al_1Layout.createSequentialGroup()
                .addGroup(hammadde_al_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hammadde_al_1Layout.createSequentialGroup()
                        .addGroup(hammadde_al_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hammadde_al_1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel21))
                            .addGroup(hammadde_al_1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(hammadde_al_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addGroup(hammadde_al_1Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hammaddeAl_alincakMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(93, 93, 93)
                                        .addComponent(hamMadde_al_buton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hammadde_al_1Layout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(hammadde_al_1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(hamMaddeAl_mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hammadde_al_1Layout.setVerticalGroup(
            hammadde_al_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hammadde_al_1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hammadde_al_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(hammaddeAl_alincakMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hamMadde_al_buton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(hamMaddeAl_mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout hammadde_alLayout = new javax.swing.GroupLayout(hammadde_al);
        hammadde_al.setLayout(hammadde_alLayout);
        hammadde_alLayout.setHorizontalGroup(
            hammadde_alLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hammadde_alLayout.createSequentialGroup()
                .addGroup(hammadde_alLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hammadde_alLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hammadde_alLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(hammadde_alLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hammaddeAl_hamsecbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(hammadde_al_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        hammadde_alLayout.setVerticalGroup(
            hammadde_alLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hammadde_alLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(hammadde_alLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hammadde_al_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(hammadde_alLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hammaddeAl_hamsecbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 391, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel26.setText("İçeren hammadde seçiniz");

        KimyasalUret_hammadde_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Hammade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
     
        jScrollPane11.setViewportView(KimyasalUret_hammadde_tablo);
        if (KimyasalUret_hammadde_tablo.getColumnModel().getColumnCount() > 0) {
            KimyasalUret_hammadde_tablo.getColumnModel().getColumn(0).setResizable(false);
            KimyasalUret_hammadde_tablo.getColumnModel().getColumn(1).setResizable(false);
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ADI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel24.setText("Kimyasal Madde Adı:");

     

        kimyasalAdi_ekle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kimyasalAdi_ekle.setText("EKLE");
    

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel25.setText("Kimyasal maddeyi seçiniz");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel27.setText("Adedi:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("EKLE");

        javax.swing.GroupLayout KimyasalMadde_uretLayout = new javax.swing.GroupLayout(KimyasalMadde_uret);
        KimyasalMadde_uret.setLayout(KimyasalMadde_uretLayout);
        KimyasalMadde_uretLayout.setHorizontalGroup(
            KimyasalMadde_uretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KimyasalMadde_uretLayout.createSequentialGroup()
                .addGroup(KimyasalMadde_uretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KimyasalMadde_uretLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Kimyasal_adi_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(kimyasalAdi_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KimyasalMadde_uretLayout.createSequentialGroup()
                        .addGroup(KimyasalMadde_uretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(KimyasalMadde_uretLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(KimyasalMadde_uretLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel25)))
                        .addGroup(KimyasalMadde_uretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(KimyasalMadde_uretLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addGroup(KimyasalMadde_uretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
                            .addGroup(KimyasalMadde_uretLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel26)))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        KimyasalMadde_uretLayout.setVerticalGroup(
            KimyasalMadde_uretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KimyasalMadde_uretLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(KimyasalMadde_uretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(Kimyasal_adi_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kimyasalAdi_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addGroup(KimyasalMadde_uretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(KimyasalMadde_uretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KimyasalMadde_uretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KimyasalMadde_uretLayout.createSequentialGroup()
                        .addGroup(KimyasalMadde_uretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(150, 150, 150))
        );

        HammaddeAl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenu2.setText("Ham Madde");

        ham.setText("Ham Madde Ekle");
        ham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hamMouseClicked(evt);
            }
        });
        jMenu2.add(ham);

        hammadde_uret.setText("Ham Madde Üret");
        hammadde_uret.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hammadde_uretMouseClicked(evt);
            }
        });
        jMenu2.add(hammadde_uret);

        HammaddeAl.add(jMenu2);

        tedarikci_firma.setText("Tedarikçi Firma");
        tedarikci_firma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tedarikci_firmaMouseClicked(evt);
            }
        });
        HammaddeAl.add(tedarikci_firma);

        jMenu1.setText("Müşteri");

        musteri_ekle.setText("Müşteri Ekle");
        musteri_ekle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                musteri_ekleMouseClicked(evt);
            }
        });
        jMenu1.add(musteri_ekle);

        HammaddeAl.add(jMenu1);

        HamMaddeAl.setText("Ham Madde Al");
        HamMaddeAl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HamMaddeAlMouseClicked(evt);
            }
        });
        HammaddeAl.add(HamMaddeAl);

        jMenu3.setText("Kimyasal Ürün");

        kimyasal_ekle.setText("Ekle");
        jMenu3.add(kimyasal_ekle);

        HammaddeAl.add(jMenu3);

        setJMenuBar(HammaddeAl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hammadde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(tedarikciFirma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(musteriEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(musteriSiparis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(200, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(hamuret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 174, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(Jpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(211, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(hammadde_al, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addComponent(KimyasalMadde_uret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(99, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hammadde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(tedarikciFirma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(musteriEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(musteriSiparis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(hamuret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(Jpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(57, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(hammadde_al, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(KimyasalMadde_uret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hamMouseClicked
        jpanel_kapat();
        hammadde.setVisible(true);
        hammadde_listele();
    }//GEN-LAST:event_hamMouseClicked


    private void ham_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ham_ekleActionPerformed
           ham_model.setRowCount(0);
           String sembol= ham_sembolu.getText();
           String adi=ham_adi.getText();
           if(sembol!=""){
           boolean ekle= islemler.ham_ekle(sembol,adi);
           if(ekle==true){
               System.out.println("Eklendi.");
                hammadde_listele();
           }else{
               System.out.println("Eklenemedi");
           }
         
         }else{
               ham_mesaj.setText("Sembol alanı boş!");
           }
    }//GEN-LAST:event_ham_ekleActionPerformed

    private void ham_tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ham_tabloMouseClicked
            int secili_row =ham_tablo.getSelectedRow();
            ham_sembolu.setText(ham_model.getValueAt(secili_row, 1).toString());
            ham_adi.setText(ham_model.getValueAt(secili_row, 2).toString());
            ham_id.setText(ham_model.getValueAt(secili_row, 0).toString());
    }//GEN-LAST:event_ham_tabloMouseClicked

    private void ham_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ham_guncelleActionPerformed
        int id=Integer.valueOf(ham_id.getText());
            islemler.hammadde_guncelle(id,ham_sembolu.getText(),ham_adi.getText());
             hammadde_listele();
    }//GEN-LAST:event_ham_guncelleActionPerformed

    private void ham_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ham_silActionPerformed
          int id=Integer.valueOf(ham_id.getText());
          islemler.hammadde_sil(id);
           hammadde_listele();
    }//GEN-LAST:event_ham_silActionPerformed

    private void tedarikci_firmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tedarikci_firmaMouseClicked
       jpanel_kapat();
       tedarikciFirma.setVisible(true);
    }//GEN-LAST:event_tedarikci_firmaMouseClicked

    
    private void tedarikci_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tedarikci_ekleActionPerformed
        
         tedarikci_model.setRowCount(0);
           String firma_adi= tedarikci_adi.getText();
           String ulke=tedarikci_ulke.getText();
           String sehir=tedarikci_sehir.getText();
           
       
           boolean ekle= islemler.tedarikcifirma_ekle(firma_adi, ulke, sehir);
           if(ekle==true){
               System.out.println("Eklendi.");
                tedarikci_listele();
           }else{
               System.out.println("Eklenemedi");
           }
         
    
        
        
    }//GEN-LAST:event_tedarikci_ekleActionPerformed


    private void musteriEkle_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musteriEkle_ekleActionPerformed
            musteriEkle_model.setRowCount(0);
           String isim= musteriEkle_adi.getText();
           String adres=musteriEkle_adres.getText();
           
           boolean ekle= islemler.musteri_ekle(isim,adres);
           if(ekle==true){
               System.out.println("Eklendi.");
                musteri_listele();
           }else{
               System.out.println("Eklenemedi");
           }
         
    }//GEN-LAST:event_musteriEkle_ekleActionPerformed

    private void musteriEkle_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musteriEkle_guncelleActionPerformed
          int id=Integer.valueOf(musteriEkle_id.getText());
            islemler.musteri_guncelle(id,musteriEkle_adi.getText(),musteriEkle_adres.getText());
             musteri_listele();
    }//GEN-LAST:event_musteriEkle_guncelleActionPerformed

    private void musteriEkle_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musteriEkle_silActionPerformed
         int id=Integer.valueOf(musteriEkle_id.getText());
          islemler.musteri_sil(id);
           musteri_listele();
    }//GEN-LAST:event_musteriEkle_silActionPerformed

    private void tedarikci_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tedarikci_guncelleActionPerformed
            int id=Integer.valueOf(tedarikcifirma_id.getText());
            islemler.tedarikcifirma_guncelle(id,tedarikci_adi.getText(),tedarikci_ulke.getText(),tedarikci_sehir.getText());
             tedarikci_listele();
    }//GEN-LAST:event_tedarikci_guncelleActionPerformed

    private void tedarikci_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tedarikci_silActionPerformed
         int id=Integer.valueOf(tedarikcifirma_id.getText());
          islemler.tedarikcifirma_sil(id);
           tedarikci_listele();
    }//GEN-LAST:event_tedarikci_silActionPerformed

    private void tedarikci_tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tedarikci_tabloMouseClicked
            int secili_row =tedarikci_tablo.getSelectedRow();
            tedarikci_adi.setText(tedarikci_model.getValueAt(secili_row, 1).toString());
            tedarikci_ulke.setText(tedarikci_model.getValueAt(secili_row, 2).toString());
            tedarikci_sehir.setText(tedarikci_model.getValueAt(secili_row, 3).toString());
            tedarikcifirma_id.setText(tedarikci_model.getValueAt(secili_row, 0).toString());
    }//GEN-LAST:event_tedarikci_tabloMouseClicked

    private void musteri_ekleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musteri_ekleMouseClicked
        jpanel_kapat();
        musteriEkle.setVisible(true);
    }//GEN-LAST:event_musteri_ekleMouseClicked

    private void musteriEkle_tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musteriEkle_tabloMouseClicked
           int secili_row =musteriEkle_tablo.getSelectedRow();
            musteriEkle_adi.setText(musteriEkle_model.getValueAt(secili_row, 1).toString());
            musteriEkle_adres.setText(musteriEkle_model.getValueAt(secili_row, 2).toString());
            musteriEkle_id.setText(musteriEkle_model.getValueAt(secili_row, 0).toString());
    }//GEN-LAST:event_musteriEkle_tabloMouseClicked

    private void hammadde_uretMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hammadde_uretMouseClicked
    jpanel_kapat();
    hamuret.setVisible(true);
    hamUret_tedarikci_listele();
    hamUret_hammadde_listele();
    hamUret_ham_Listele();
    }//GEN-LAST:event_hammadde_uretMouseClicked


    private void hamUret_firma_tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hamUret_firma_tabloMouseClicked
                int secili_row =hamUret_firma_tablo.getSelectedRow();
            hamUret_secilen_firmadi.setText(hamUret_tedarikci_model.getValueAt(secili_row, 1).toString());
            hamUret_secilen_id.setText(hamUret_tedarikci_model.getValueAt(secili_row, 0).toString());
 
    }//GEN-LAST:event_hamUret_firma_tabloMouseClicked

    private void hamUret_hammadde_tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hamUret_hammadde_tabloMouseClicked
                int secili_row =hamUret_hammadde_tablo.getSelectedRow();
            hamUret_secilen_hammadde.setText(hamUret_ham_model.getValueAt(secili_row, 1).toString());
            hamUret_secilen_hamid.setText(hamUret_ham_model.getValueAt(secili_row, 0).toString());
    }//GEN-LAST:event_hamUret_hammadde_tabloMouseClicked

    private void hamUret_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hamUret_ekleActionPerformed
        int tedarikci_id=Integer.valueOf(hamUret_secilen_id.getText());
        int hammadde_id=Integer.valueOf(hamUret_secilen_hamid.getText());
        int miktar=Integer.valueOf(hamUret_miktar.getText());
        int rafomru=Integer.valueOf(hamUret_rafomru.getText());
        int fiyat=Integer.valueOf(hamUret_fiyat.getText());
        String uretim_tarihi=hamUret_uretimtarihi.getText();
       
          
           boolean ekle=  islemler.hamMadde_uret(tedarikci_id,hammadde_id,miktar,rafomru,fiyat,uretim_tarihi);
        
           if(ekle==true){
               System.out.println("Eklendi.");
                musteri_listele();
                hamUret_tedarikci_listele();
                hamUret_hammadde_listele();
                hamUret_ham_Listele();
           }else{
               System.out.println("Eklenemedi");
           }
    }//GEN-LAST:event_hamUret_ekleActionPerformed


    private void HamMaddeAlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HamMaddeAlMouseClicked
      jpanel_kapat();
      hammadde_al.setVisible(true);
      hammadde_listele();
    }//GEN-LAST:event_HamMaddeAlMouseClicked

    private void hammaddeAl_hamsecbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hammaddeAl_hamsecbtnActionPerformed
           int secili_row =hammadde_listele_tablo.getSelectedRow();
            int ham_id=(int) hamMadde_listele_model.getValueAt(secili_row, 0);
            String ham_adi=(String) hamMadde_listele_model.getValueAt(secili_row, 1);
            hammadde_al_1.setVisible(true);
            HamMaddeAl_Listele(ham_id);
    }//GEN-LAST:event_hammaddeAl_hamsecbtnActionPerformed


    private void hamMadde_al_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hamMadde_al_butonActionPerformed
           int secili_row =tedarikci_urunsat_tablo.getSelectedRow();
        if(secili_row==-1){
            hamMaddeAl_mesaj.setText("Lütfen ürün alacağınız firmayı seçiniz");
            }else{
            int id=(int)HamMaddeAl_Listele_model.getValueAt(secili_row, 0);
             int ham_id=islemler.hamId_Bul(id);
            int toplam_maliyet=(int)HamMaddeAl_Listele_model.getValueAt(secili_row,5);
            int veri_miktar=(int)HamMaddeAl_Listele_model.getValueAt(secili_row,4);
            int miktar=Integer.valueOf(hammaddeAl_alincakMiktar.getText());
            if(miktar>veri_miktar){
             hamMaddeAl_mesaj.setText("Seçtiğiniz firmada istediğin miktarda ürün bulunmamakta.");
            
            }else{
            hamMaddeAl_mesaj.setText(" ");
               
           islemler.HamMaddeAl(id,ham_id,veri_miktar,miktar,toplam_maliyet);
            }
            
        }
           
           
          
    }//GEN-LAST:event_hamMadde_al_butonActionPerformed


   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ekran dialog = new ekran(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu HamMaddeAl;
    private javax.swing.JMenuBar HammaddeAl;
    private javax.swing.JPanel Jpanel1;
    private javax.swing.JPanel KimyasalMadde_uret;
    private javax.swing.JTable KimyasalUret_hammadde_tablo;
    private javax.swing.JTextField Kimyasal_adi_ekle;
    private javax.swing.JMenu ham;
    private javax.swing.JLabel hamMaddeAl_mesaj;
    private javax.swing.JButton hamMadde_al_buton;
    private javax.swing.JTable hamUret_Listele_tablo;
    private javax.swing.JButton hamUret_ekle;
    private javax.swing.JTable hamUret_firma_tablo;
    private javax.swing.JTextField hamUret_fiyat;
    private javax.swing.JTable hamUret_hammadde_tablo;
    private javax.swing.JTextField hamUret_miktar;
    private javax.swing.JTextField hamUret_rafomru;
    private javax.swing.JTextField hamUret_secilen_firmadi;
    private javax.swing.JLabel hamUret_secilen_hamid;
    private javax.swing.JTextField hamUret_secilen_hammadde;
    private javax.swing.JLabel hamUret_secilen_id;
    private javax.swing.JButton hamUret_sil;
    private javax.swing.JTextField hamUret_uretimtarihi;
    private javax.swing.JTextField ham_adi;
    private javax.swing.JButton ham_ekle;
    private javax.swing.JButton ham_guncelle;
    private javax.swing.JLabel ham_id;
    private javax.swing.JLabel ham_mesaj;
    private javax.swing.JTextField ham_sembolu;
    private javax.swing.JButton ham_sil;
    private javax.swing.JTable ham_tablo;
    private javax.swing.JPanel hammadde;
    private javax.swing.JTextField hammaddeAl_alincakMiktar;
    private javax.swing.JButton hammaddeAl_hamsecbtn;
    private javax.swing.JPanel hammadde_al;
    private javax.swing.JPanel hammadde_al_1;
    private javax.swing.JTable hammadde_listele_tablo;
    private javax.swing.JMenu hammadde_uret;
    private javax.swing.JPanel hamuret;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton kimyasalAdi_ekle;
    private javax.swing.JMenu kimyasal_ekle;
    private javax.swing.JPanel musteriEkle;
    private javax.swing.JTextField musteriEkle_adi;
    private javax.swing.JTextArea musteriEkle_adres;
    private javax.swing.JButton musteriEkle_ekle;
    private javax.swing.JButton musteriEkle_guncelle;
    private javax.swing.JLabel musteriEkle_id;
    private javax.swing.JButton musteriEkle_sil;
    private javax.swing.JTable musteriEkle_tablo;
    private javax.swing.JPanel musteriSiparis;
    private javax.swing.JMenu musteri_ekle;
    private javax.swing.JPanel tedarikciFirma;
    private javax.swing.JTextField tedarikci_adi;
    private javax.swing.JLabel tedarikci_adilabel;
    private javax.swing.JButton tedarikci_ekle;
    private javax.swing.JMenu tedarikci_firma;
    private javax.swing.JButton tedarikci_guncelle;
    private javax.swing.JTextField tedarikci_sehir;
    private javax.swing.JLabel tedarikci_sehirlabel;
    private javax.swing.JButton tedarikci_sil;
    private javax.swing.JTable tedarikci_tablo;
    private javax.swing.JTextField tedarikci_ulke;
    private javax.swing.JLabel tedarikci_ulkelabel;
    private javax.swing.JTable tedarikci_urunsat_tablo;
    private javax.swing.JLabel tedarikcifirma_id;
    // End of variables declaration//GEN-END:variables
}
