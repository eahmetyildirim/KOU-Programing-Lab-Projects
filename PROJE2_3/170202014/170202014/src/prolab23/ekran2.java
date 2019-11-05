/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab23;

import java.util.ArrayList;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AHMET YILDIRIM
 */
public class ekran2 extends javax.swing.JDialog {

     DefaultTableModel KimyasalMaddeAdi_model;
      DefaultTableModel HamMaddeAdi_model;       
      DefaultTableModel KimyasalMadde_Listele_model;
      DefaultTableModel KimyasalListele_ham_model;
      DefaultTableModel Kimyasal_Uret_model;
    veritabani_islemleri islemler=new veritabani_islemleri();
    public ekran2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Jpanel_kapat();
       
        KimyasalMaddeAdi_model=(DefaultTableModel) KimyasalMadde_tablo.getModel();
        HamMaddeAdi_model=(DefaultTableModel) HamMadde_tablo.getModel();
        KimyasalMadde_Listele_model=(DefaultTableModel) KimyasalMadde_Listele_Tablo.getModel();
        KimyasalListele_ham_model=(DefaultTableModel) KimyasalListele_Ham.getModel();
        Kimyasal_Uret_model =(DefaultTableModel) KimyasalMadde_Uret_Tablo.getModel();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KimyasalUret_Jpanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        KimyasalMadde_Uret_Tablo = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        uretilicekMiktar = new javax.swing.JTextField();
        KimysalUret_UretimTarihi = new javax.swing.JTextField();
        KimysalUret_RafOmru = new javax.swing.JTextField();
        KimysalUret_Button = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Kimyasal_ID = new javax.swing.JLabel();
        KimyasalUret_mesaj = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        KimyasalUret_karOrani = new javax.swing.JTextField();
        KimyasalUrunListele = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        KimyasalMadde_Listele_Tablo = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        KimyasalListele_Ham = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        KimyasalUrunEKLE = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        KimyasakAdı_ekleButon = new javax.swing.JButton();
        KimyasalAdi_ekle = new javax.swing.JTextField();
        kimyasalEkle_mesaj = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        KimyasalMadde_tablo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        HamMadde_tablo = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        Kimyasal_Ham_EkleButon = new javax.swing.JButton();
        KimyasalEkle_mesaj = new javax.swing.JLabel();
        KarOrani_Jpanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        harcana_para = new javax.swing.JLabel();
        kazanilan_para = new javax.swing.JLabel();
        kar_miktari = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        KimyasalEkle = new javax.swing.JMenu();
        KimyasalListele = new javax.swing.JMenu();
        KimyasalUrett = new javax.swing.JMenu();
        Kar_Orani = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        KimyasalMadde_Uret_Tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kimyasal Adı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        KimyasalMadde_Uret_Tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KimyasalMadde_Uret_TabloMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(KimyasalMadde_Uret_Tablo);
        if (KimyasalMadde_Uret_Tablo.getColumnModel().getColumnCount() > 0) {
            KimyasalMadde_Uret_Tablo.getColumnModel().getColumn(0).setResizable(false);
            KimyasalMadde_Uret_Tablo.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Üretilicek kimyasal maddeyi seçiniz:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Üretim Tarihi:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Raf Ömrü:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Üretilicek Miktar:");

        KimysalUret_Button.setText("ÜRET");
        KimysalUret_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KimysalUret_ButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Kimyasal ID:");

        Kimyasal_ID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        KimyasalUret_mesaj.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Kar oranı giriniz(%):");

        javax.swing.GroupLayout KimyasalUret_JpanelLayout = new javax.swing.GroupLayout(KimyasalUret_Jpanel);
        KimyasalUret_Jpanel.setLayout(KimyasalUret_JpanelLayout);
        KimyasalUret_JpanelLayout.setHorizontalGroup(
            KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KimyasalUret_JpanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(155, 155, 155)
                .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(KimyasalUret_JpanelLayout.createSequentialGroup()
                            .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGap(30, 30, 30)
                            .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(uretilicekMiktar)
                                .addComponent(KimysalUret_UretimTarihi)
                                .addComponent(KimysalUret_RafOmru)
                                .addComponent(Kimyasal_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(KimyasalUret_JpanelLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(KimyasalUret_karOrani, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(KimyasalUret_JpanelLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(KimysalUret_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(221, Short.MAX_VALUE))
            .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(KimyasalUret_JpanelLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(KimyasalUret_mesaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(707, 707, 707)))
        );
        KimyasalUret_JpanelLayout.setVerticalGroup(
            KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KimyasalUret_JpanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KimyasalUret_JpanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(330, 330, 330))
                    .addGroup(KimyasalUret_JpanelLayout.createSequentialGroup()
                        .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Kimyasal_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(KimysalUret_UretimTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(KimysalUret_RafOmru, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uretilicekMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(KimyasalUret_karOrani, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(KimysalUret_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(311, 311, 311))))
            .addGroup(KimyasalUret_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KimyasalUret_JpanelLayout.createSequentialGroup()
                    .addContainerGap(407, Short.MAX_VALUE)
                    .addComponent(KimyasalUret_mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(190, 190, 190)))
        );

        KimyasalMadde_Listele_Tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kimyasal Adı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        KimyasalMadde_Listele_Tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KimyasalMadde_Listele_TabloMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(KimyasalMadde_Listele_Tablo);
        if (KimyasalMadde_Listele_Tablo.getColumnModel().getColumnCount() > 0) {
            KimyasalMadde_Listele_Tablo.getColumnModel().getColumn(0).setResizable(false);
            KimyasalMadde_Listele_Tablo.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Kimyasal maddeyi seçiniz:");

        KimyasalListele_Ham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ham_ID", "Adı", "Adedi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(KimyasalListele_Ham);
        if (KimyasalListele_Ham.getColumnModel().getColumnCount() > 0) {
            KimyasalListele_Ham.getColumnModel().getColumn(0).setResizable(false);
            KimyasalListele_Ham.getColumnModel().getColumn(1).setResizable(false);
            KimyasalListele_Ham.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton1.setText("Kimyasal Sil");

        javax.swing.GroupLayout KimyasalUrunListeleLayout = new javax.swing.GroupLayout(KimyasalUrunListele);
        KimyasalUrunListele.setLayout(KimyasalUrunListeleLayout);
        KimyasalUrunListeleLayout.setHorizontalGroup(
            KimyasalUrunListeleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KimyasalUrunListeleLayout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addGroup(KimyasalUrunListeleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KimyasalUrunListeleLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(670, 670, 670))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KimyasalUrunListeleLayout.createSequentialGroup()
                        .addGroup(KimyasalUrunListeleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(KimyasalUrunListeleLayout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(KimyasalUrunListeleLayout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(237, 237, 237))))
        );
        KimyasalUrunListeleLayout.setVerticalGroup(
            KimyasalUrunListeleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KimyasalUrunListeleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(KimyasalUrunListeleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Kimyasal Adı:");

        KimyasakAdı_ekleButon.setText("EKLE");
        KimyasakAdı_ekleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KimyasakAdı_ekleButonActionPerformed(evt);
            }
        });

        kimyasalEkle_mesaj.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        kimyasalEkle_mesaj.setForeground(new java.awt.Color(204, 0, 0));

        KimyasalMadde_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
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
        KimyasalMadde_tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KimyasalMadde_tabloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(KimyasalMadde_tablo);
        if (KimyasalMadde_tablo.getColumnModel().getColumnCount() > 0) {
            KimyasalMadde_tablo.getColumnModel().getColumn(0).setResizable(false);
            KimyasalMadde_tablo.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Kimyasal Maddeyi Seçiniz");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Ham Maddeyi Seçiniz");

        HamMadde_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "ADI", "ADETİ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(HamMadde_tablo);
        if (HamMadde_tablo.getColumnModel().getColumnCount() > 0) {
            HamMadde_tablo.getColumnModel().getColumn(0).setResizable(false);
            HamMadde_tablo.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel4.setBackground(new java.awt.Color(255, 0, 51));
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Seçeceğiniz ham maddenin önce adet bilgisini üzerine çift tıklayarak giriniz");

        Kimyasal_Ham_EkleButon.setText("EKLE");
        Kimyasal_Ham_EkleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kimyasal_Ham_EkleButonActionPerformed(evt);
            }
        });

        KimyasalEkle_mesaj.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        KimyasalEkle_mesaj.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout KimyasalUrunEKLELayout = new javax.swing.GroupLayout(KimyasalUrunEKLE);
        KimyasalUrunEKLE.setLayout(KimyasalUrunEKLELayout);
        KimyasalUrunEKLELayout.setHorizontalGroup(
            KimyasalUrunEKLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KimyasalUrunEKLELayout.createSequentialGroup()
                .addGroup(KimyasalUrunEKLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KimyasalUrunEKLELayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(KimyasalUrunEKLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kimyasalEkle_mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(KimyasalUrunEKLELayout.createSequentialGroup()
                                .addComponent(KimyasalAdi_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(KimyasakAdı_ekleButon, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(KimyasalUrunEKLELayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(KimyasalUrunEKLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(KimyasalUrunEKLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(KimyasalUrunEKLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(KimyasalUrunEKLELayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(KimyasalUrunEKLELayout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(Kimyasal_Ham_EkleButon, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(KimyasalUrunEKLELayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(KimyasalEkle_mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        KimyasalUrunEKLELayout.setVerticalGroup(
            KimyasalUrunEKLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KimyasalUrunEKLELayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(KimyasalUrunEKLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(KimyasakAdı_ekleButon, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KimyasalAdi_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kimyasalEkle_mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(KimyasalUrunEKLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(KimyasalUrunEKLELayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(KimyasalUrunEKLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(KimyasalUrunEKLELayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(KimyasalUrunEKLELayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(KimyasalUrunEKLELayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(KimyasalEkle_mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Kimyasal_Ham_EkleButon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(245, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel18.setText("Harcanan Para:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel19.setText("Kazanılan Para:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel20.setText("Kar Miktarı     :");

        harcana_para.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        kazanilan_para.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        kar_miktari.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        javax.swing.GroupLayout KarOrani_JpanelLayout = new javax.swing.GroupLayout(KarOrani_Jpanel);
        KarOrani_Jpanel.setLayout(KarOrani_JpanelLayout);
        KarOrani_JpanelLayout.setHorizontalGroup(
            KarOrani_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KarOrani_JpanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(KarOrani_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addGroup(KarOrani_JpanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KarOrani_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(harcana_para, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(KarOrani_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(kar_miktari, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, KarOrani_JpanelLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(kazanilan_para, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        KarOrani_JpanelLayout.setVerticalGroup(
            KarOrani_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KarOrani_JpanelLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(KarOrani_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KarOrani_JpanelLayout.createSequentialGroup()
                        .addComponent(harcana_para, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(kazanilan_para, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KarOrani_JpanelLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel19)
                        .addGap(70, 70, 70)
                        .addGroup(KarOrani_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(kar_miktari, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(297, Short.MAX_VALUE))
        );

        jMenu1.setText("Kimyasal");

        KimyasalEkle.setText("Kimyasal Ekle");
        KimyasalEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KimyasalEkleMouseClicked(evt);
            }
        });
        jMenu1.add(KimyasalEkle);

        KimyasalListele.setText("Kimyasal Listele");
        KimyasalListele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KimyasalListeleMouseClicked(evt);
            }
        });
        jMenu1.add(KimyasalListele);

        jMenuBar1.add(jMenu1);

        KimyasalUrett.setText("Kimyasal Üret");
        KimyasalUrett.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KimyasalUrettMouseClicked(evt);
            }
        });
        jMenuBar1.add(KimyasalUrett);

        Kar_Orani.setText("Kar Oranı");
        Kar_Orani.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Kar_OraniMouseClicked(evt);
            }
        });
        jMenuBar1.add(Kar_Orani);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(KimyasalUrunEKLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(KimyasalUrunListele, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(24, 24, 24)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(KimyasalUret_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(KarOrani_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(KimyasalUrunEKLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(KimyasalUrunListele, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(26, 26, 26)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(KimyasalUret_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(KarOrani_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Jpanel_kapat(){
     KimyasalUrunEKLE.setVisible(false);
     KimyasalUrunListele.setVisible(false);
     KimyasalUret_Jpanel.setVisible(false);
     KarOrani_Jpanel.setVisible(false);
    }
    
    public void HammaddeAdi_listele(){
       HamMaddeAdi_model.setRowCount(0);
              ArrayList<hammadde> listele=new ArrayList<>();
           listele=islemler.hammadde_listele();
                if(listele!=null){
                    for(hammadde x:listele){
                    Object[] eklenecek ={x.getId(),x.getSembol()};
                    HamMaddeAdi_model.addRow(eklenecek);
                    }
                }
    }
    public void KimyasalEkle_listele(){
       Kimyasal_Uret_model.setRowCount(0);
       KimyasalMaddeAdi_model.setRowCount(0);
       KimyasalMadde_Listele_model.setRowCount(0);
              ArrayList<KimyasalMadde> listele=new ArrayList<>();
           listele=islemler.KimyasalAdi_Listele();
                if(listele!=null){
                    for(KimyasalMadde x:listele){
                    Object[] eklenecek ={x.getId(),x.getAd()};
                    KimyasalMaddeAdi_model.addRow(eklenecek);
                    KimyasalMadde_Listele_model.addRow(eklenecek);
                    Kimyasal_Uret_model.addRow(eklenecek);
                    }
                }
    
    }
    public void KimyasalListeleAtomListele(int kimyasal_id){
        ArrayList<KimyasalMadde> listele =new ArrayList<>();
       KimyasalListele_ham_model.setRowCount(0);
            listele=islemler.KimyasalHamID_Listele(kimyasal_id);
                    System.out.println("İslem boyutu:"+listele.size());
            if(listele!=null){
                    for(KimyasalMadde x:listele){
                    String adi=islemler.Hammadde_idCevir(x.getHam_id());
                        System.out.println("Adı: "+adi);
                    Object[] eklenecek ={x.getHam_id(),adi,x.getAded()};
                    KimyasalListele_ham_model.addRow(eklenecek);
                     }
                }
    
    
    
    
    }
    private void KimyasakAdı_ekleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KimyasakAdı_ekleButonActionPerformed
        String kimyasal_adi=KimyasalAdi_ekle.getText();
        boolean ekle=islemler.kimyasalAdi_ekle(kimyasal_adi);
        if(ekle==false){
            kimyasalEkle_mesaj.setText("Ekleme başarısız!!");
        }else{
            kimyasalEkle_mesaj.setText(kimyasal_adi+" kimyasalı eklendi.");
            }
         KimyasalEkle_listele();
         HammaddeAdi_listele();
    }//GEN-LAST:event_KimyasakAdı_ekleButonActionPerformed

    private void KimyasalMadde_tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KimyasalMadde_tabloMouseClicked
      
    }//GEN-LAST:event_KimyasalMadde_tabloMouseClicked

    private void KimyasalEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KimyasalEkleMouseClicked
        Jpanel_kapat();
        KimyasalUrunEKLE.setVisible(true);
        HammaddeAdi_listele();
        KimyasalEkle_listele();
    }//GEN-LAST:event_KimyasalEkleMouseClicked

    private void Kimyasal_Ham_EkleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Kimyasal_Ham_EkleButonActionPerformed
         int Kimyasal_secili_row=KimyasalMadde_tablo.getSelectedRow();
         int[] HamMadde_secili_row=HamMadde_tablo.getSelectedRows();
           int kimyasal_id=Integer.valueOf(KimyasalMaddeAdi_model.getValueAt(Kimyasal_secili_row,0).toString());
          
         for(int x:HamMadde_secili_row){
             System.out.println("X:"+x);
             int adet=Integer.valueOf(HamMaddeAdi_model.getValueAt(x,2).toString());
             int ham_id=Integer.valueOf(HamMaddeAdi_model.getValueAt(x,0).toString());
             String ham_adi=HamMaddeAdi_model.getValueAt(x,1).toString();
             boolean islem=islemler.KimyasalHam_Ekle(kimyasal_id,ham_id,adet);
             if(islem==true){
                 System.out.println(ham_adi+"eklendi.");
                 KimyasalEkle_mesaj.setText("Kimyasal ürün bilgileri eklendi.");
                 HammaddeAdi_listele();
             }else{
                 KimyasalEkle_mesaj.setText("Kimyasal ürün bilgileri eklenemedi!");
             }
         }
        
    }//GEN-LAST:event_Kimyasal_Ham_EkleButonActionPerformed

    private void KimyasalListeleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KimyasalListeleMouseClicked
        Jpanel_kapat();
        KimyasalUrunListele.setVisible(true);
        KimyasalEkle_listele();
        
    }//GEN-LAST:event_KimyasalListeleMouseClicked

    private void KimyasalMadde_Listele_TabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KimyasalMadde_Listele_TabloMouseClicked
                    int secili_row=KimyasalMadde_Listele_Tablo.getSelectedRow();
                
                  if(secili_row!=-1){
                 int kimyasal_id=Integer.valueOf(KimyasalMadde_Listele_model.getValueAt(secili_row,0).toString());
                 
                  ArrayList<KimyasalMadde> liste=new ArrayList<>();
               
                    KimyasalListeleAtomListele(kimyasal_id);
                   }
             
                   
               
    }//GEN-LAST:event_KimyasalMadde_Listele_TabloMouseClicked

    private void KimyasalUrettMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KimyasalUrettMouseClicked
        Jpanel_kapat();
        KimyasalUret_Jpanel.setVisible(true);
        KimyasalEkle_listele();
    }//GEN-LAST:event_KimyasalUrettMouseClicked

    private void KimyasalMadde_Uret_TabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KimyasalMadde_Uret_TabloMouseClicked
        int secili_row =KimyasalMadde_Uret_Tablo.getSelectedRow();
        int kimyasal_id=Integer.valueOf(Kimyasal_Uret_model.getValueAt(secili_row,0).toString());
            ArrayList<KimyasalMadde> KimyasalIcerik=islemler.KimyasalHamID_Listele(kimyasal_id);    
            int adet=0;
            for(KimyasalMadde x:KimyasalIcerik){
                adet=adet + x.getAded();
            }     
            int ham_adet=KimyasalIcerik.size();
            System.out.println("Adet"+adet+ "Ham Adet:"+ham_adet);
           islemler.uretici_tarih_gecti_mi();
           Kimyasal_ID.setText(String.valueOf(kimyasal_id));
           
           
    }//GEN-LAST:event_KimyasalMadde_Uret_TabloMouseClicked

    private void KimysalUret_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KimysalUret_ButtonActionPerformed
        String uretim_tarihi =KimysalUret_UretimTarihi.getText();
        int  raf_omru =Integer.valueOf(KimysalUret_RafOmru.getText());
        int  miktar =Integer.valueOf(uretilicekMiktar.getText());
        int kimyasal_id =Integer.valueOf(Kimyasal_ID.getText());
         int kar_payi =Integer.valueOf(KimyasalUret_karOrani.getText());
            ArrayList<KimyasalMadde> KimyasalIcerik=islemler.KimyasalHamID_Listele(kimyasal_id);    
            int adet=0;
            for(KimyasalMadde x:KimyasalIcerik){
                adet=adet + x.getAded();
            }     
            int ham_sayisi=KimyasalIcerik.size();
            int say=0;
            for(KimyasalMadde x:KimyasalIcerik){
                    int ham_adet=x.getAded();
                    int ham_id=x.getHam_id();
                    boolean islem=islemler.ham_var_mi(ham_id,ham_adet,miktar,adet);
                    if(islem==true){
                    say++;
                    }
            }
            if(say!=ham_sayisi){
                KimyasalUret_mesaj.setText("Yeterli ham madde yok");
            }else{
                int iscilik_maliyeti=miktar,hammadde_maliyeti=0,toplam_maliyet=0,fiyat=0;
              for(KimyasalMadde x:KimyasalIcerik){
                    int ham_adet=x.getAded();
                    int ham_miktar=(ham_adet*miktar)/adet;
                    int ham_id=x.getHam_id();
                    ArrayList<KimyasalMadde> listele=islemler.Uretici_HamStokAzalt(ham_id,ham_miktar);
                    int say2=0,fark=ham_miktar;
                    for(int i=0;i<listele.size();i++){
                        fark-=listele.get(i).getMiktar();
                        if(fark>=0){
                            hammadde_maliyeti+=listele.get(i).getAlis_maliyeti();
                            islemler.KimyasalUret_HamSil(listele.get(i).getId());
                        }else{
                            int toplam=listele.get(i).getAlis_maliyeti();
                            toplam=(toplam*(-1)*fark)/listele.get(i).getMiktar();
                            hammadde_maliyeti+=toplam;
                            islemler.KimsayalUret_HamMiktarGuncelle(listele.get(i).getId(),(-1)*fark);
                        
                        }
                    
                    
                    }
                    
                    
                    
            } 
            toplam_maliyet=iscilik_maliyeti+hammadde_maliyeti;
            fiyat=toplam_maliyet*(100+kar_payi)/100;
            boolean islem= islemler.kimyasal_ekle(kimyasal_id,uretim_tarihi,raf_omru,iscilik_maliyeti,toplam_maliyet,fiyat);
                if(islem==true){
                KimyasalUret_mesaj.setText("Kimyasal Eklendi");
                }else{
                KimyasalUret_mesaj.setText("Kimyasal Eklenemedi");
                }
            }
            
            
    }//GEN-LAST:event_KimysalUret_ButtonActionPerformed

    private void Kar_OraniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kar_OraniMouseClicked
        Jpanel_kapat();
        KarOrani_Jpanel.setVisible(true);
        ArrayList<Integer> muhasebe=islemler.muhasebe();
        int gelir=0,gider=0;
        for(Integer x:muhasebe){
        
           int tutar =x;
           if(tutar<0){
               tutar=tutar*(-1);
               gider+=tutar;
           }else{
               gelir+=tutar;
           }
        
        }
        harcana_para.setText(String.valueOf(gider));
        kazanilan_para.setText(String.valueOf(gelir));
        kar_miktari.setText(String.valueOf(gelir-gider));
    }//GEN-LAST:event_Kar_OraniMouseClicked

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ekran2 dialog = new ekran2(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable HamMadde_tablo;
    private javax.swing.JPanel KarOrani_Jpanel;
    private javax.swing.JMenu Kar_Orani;
    private javax.swing.JButton KimyasakAdı_ekleButon;
    private javax.swing.JTextField KimyasalAdi_ekle;
    private javax.swing.JMenu KimyasalEkle;
    private javax.swing.JLabel KimyasalEkle_mesaj;
    private javax.swing.JMenu KimyasalListele;
    private javax.swing.JTable KimyasalListele_Ham;
    private javax.swing.JTable KimyasalMadde_Listele_Tablo;
    private javax.swing.JTable KimyasalMadde_Uret_Tablo;
    private javax.swing.JTable KimyasalMadde_tablo;
    private javax.swing.JPanel KimyasalUret_Jpanel;
    private javax.swing.JTextField KimyasalUret_karOrani;
    private javax.swing.JLabel KimyasalUret_mesaj;
    private javax.swing.JMenu KimyasalUrett;
    private javax.swing.JPanel KimyasalUrunEKLE;
    private javax.swing.JPanel KimyasalUrunListele;
    private javax.swing.JButton Kimyasal_Ham_EkleButon;
    private javax.swing.JLabel Kimyasal_ID;
    private javax.swing.JButton KimysalUret_Button;
    private javax.swing.JTextField KimysalUret_RafOmru;
    private javax.swing.JTextField KimysalUret_UretimTarihi;
    private javax.swing.JLabel harcana_para;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel kar_miktari;
    private javax.swing.JLabel kazanilan_para;
    private javax.swing.JLabel kimyasalEkle_mesaj;
    private javax.swing.JTextField uretilicekMiktar;
    // End of variables declaration//GEN-END:variables
}
