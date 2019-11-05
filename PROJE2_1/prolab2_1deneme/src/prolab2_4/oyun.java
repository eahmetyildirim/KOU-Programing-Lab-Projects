/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2_4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



public class oyun extends JPanel implements KeyListener,ActionListener{
    Timer timer =new Timer(300,this);
    private int can=6;
    private BufferedImage MasterYoda,LukeSkywalker;
    private BufferedImage DarthVader,KyloRen,Stromtrooper; 
    private BufferedImage Kalp_Sol,Kalp_Sag,resim,kupa,kazandiniz,kaybettiniz,hak,background,secimekrani;
    private  int[][] harita =new int[11][14];
    private int secim=-1;
    int sag_b=40;
    int ust_b=40;
    private karakter iyi =new karakter();
    private ArrayList<karakter> kotu=new ArrayList<>();
    int x=6;
    int y=5;
    int xDir=1;
    int yDir=1;
    ArrayList<lokasyon> kotu_lok=new ArrayList<>();
    public oyun() {  
        timer.start();
        setBackground(Color.darkGray);
          ArrayList<String> info=new ArrayList<>();
        try{
            Scanner scanner =new Scanner(new FileReader("Harita.txt"));
             while(scanner.hasNextLine()){
             String satirlar =scanner.nextLine();
             info.add(satirlar);
             } 
               
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Prolab2_4.class.getName()).log(Level.SEVERE, null, ex);
        }
        int say=0;
        for(String i:info){
            for(int j=0;j<i.length();j++){
                if(i.charAt(j)==',')
                    say++;
                    }
            }
        
        // Kaç karakter olduğunu saydırma
        
        String[] karakter=new String[say];//Kötü karakterlerin isimlerinin tutulduğu dizi
        char[] kapi=new char[say];//Kötü karakterlerin giriş kapılarını tutulduğu dizi
        for(int i=0;i<say;i++){
            String[] parca=info.get(i).split(",");// İlk büyük cümleyi virgülle 2 ye parçaladım.
            String[] parca2=parca[0].split(":");// İkiye parçaladığım alanın karakter:isim kısmını ikiye böldüm
            String[] parca3=parca[1].split(":");//İkiye parçaladığım alanın Kapı:A şeklinde ki kısmını ikiye böldüm
            karakter[i]=parca2[1];
            kapi[i]=parca3[1].charAt(0);
        }
        
        for(int i=say;i<say+11;i++){
            String[] bol=info.get(i).split("\t");
            for(int j=0;j<14;j++){
                this.harita[i-(say)][j]=Integer.valueOf(bol[j]);
            }
        }
        for(int i=0;i<say;i++){
           lokasyon lokasyon=new lokasyon();
            if(karakter[i].equals("Stormtrooper")){
                lokasyon=harfcevir(kapi[i]);
                Stormtrooper Stormtrooper=new Stormtrooper();
                Stormtrooper.setLokasyon(lokasyon);
                kotu_lok.add(lokasyon);
                this.kotu.add(Stormtrooper);
           }
            else if(karakter[i].equals("KyloRen")){
                lokasyon=harfcevir(kapi[i]);
                KyloRen KyloRen=new KyloRen();
                KyloRen.setLokasyon(lokasyon);
                kotu_lok.add(lokasyon);
                this.kotu.add(KyloRen);
           }  
            else if(karakter[i].equals("DarthVader")){
                lokasyon=harfcevir(kapi[i]);
                DarthVader DarthVader =new DarthVader();
                DarthVader.setLokasyon(lokasyon);
                kotu_lok.add(lokasyon);
                this.kotu.add(DarthVader);
           } 
        
        }
        
            
        try {
            MasterYoda = ImageIO.read(new FileImageInputStream(new File("masteryoda.png")));
            LukeSkywalker = ImageIO.read(new FileImageInputStream(new File("lukeskywalker.png")));
            DarthVader = ImageIO.read(new FileImageInputStream(new File("darthvader.png")));
            KyloRen = ImageIO.read(new FileImageInputStream(new File("kyloren.png")));
            Stromtrooper = ImageIO.read(new FileImageInputStream(new File("stromtrooper.png")));
            Kalp_Sol = ImageIO.read(new FileImageInputStream(new File("kalp_sol.png")));
            Kalp_Sag = ImageIO.read(new FileImageInputStream(new File("kalp_sag.png")));
             kupa = ImageIO.read(new FileImageInputStream(new File("kupa.png")));
             kazandiniz = ImageIO.read(new FileImageInputStream(new File("kazandiniz2.png")));
             kaybettiniz = ImageIO.read(new FileImageInputStream(new File("kaybettiniz2.png")));
             hak = ImageIO.read(new FileImageInputStream(new File("saklidir.png")));
             background=ImageIO.read(new FileImageInputStream(new File("background.jpg")));
             secimekrani=ImageIO.read(new FileImageInputStream(new File("ilkekran.png")));
  
             
             
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void setKarakter(karakter x){
     this.iyi=x;
    }
    public int[][] getHarita() {
        return harita;
    }

    public void setHarita(int[][] harita) {
        this.harita = harita;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }
    public void canAzalt(){
      if(iyi.getName().equals("Master Yoda")){ 
          can= can-1;
          }
          else if(iyi.getName().equals("Luke Skywalker")){ 
          can= can-2;
          } 
    }

    public ArrayList<karakter> getKotu() {
        return kotu;
    }

    public void setKotu(ArrayList<karakter> kotu) {
        this.kotu = kotu;
    }
    public boolean karsilasti_mi(int i){
        
   if(new Rectangle(80+x*40,80+y*40,40,40).intersects(new Rectangle(80+kotu.get(i).getLokasyon().getX()*40,80+kotu.get(i).getLokasyon().getY()*40,40,40)))
        {
        return true;
        }
        
    return false;
    }
    public boolean kazandi_mi=false;
    private int reset=0;
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        if(secim==-1){
        g.drawImage(secimekrani, 0, 0,900,565, this);
       
        }else{
        g.drawImage(background, 0, 0,900,565, this);
       
        g.setColor(Color.lightGray);
        for(int i=0;i<16;i++){
            g.fillRect(40*i,0, 40, 40);
            g.fillRect(40*i,480,40, 40);
        }
        for(int i=0;i<12;i++){
            g.fillRect(0,40*i,40, 40);
            g.fillRect(600,40*i,40, 40);
        }
        
        g.drawImage(kupa, 600, 400, 40,40, this);
        g.drawImage(hak,150,525, 600,40, this);
           for(int i=0;i<11;i++){
            for(int j=0;j<14;j++){
                if(harita[i][j]==1){
                g.setColor(Color.white);
                }
                else if(harita[i][j]==0){
                g.setColor(Color.black);
                }
               g.fillRect((40+j*40),(40+i*40), 40, 40);
                g.setColor(Color.black);
                g.drawRect((40+j*40),(40+i*40), 40, 40);
               
            }
        }
          g.setColor(Color.PINK);
         // g.fillRect((80+13*40),(80+9*40), 40, 40);
        for(int z=0;z<kotu.size();z++){
          for(int i=0;i<11;i++){
              for(int j=0;j<14;j++){
                  if(kotu.get(z).enKisa[i][j]==1){
              g.setColor(Color.red);  
              g.fillRect((55+j*40),(55+i*40), 10, 10);
              g.setColor(Color.black);
              g.drawRect((40+j*40),(40+i*40), 40, 40);
                        }
               }
          }
       }
          for(int i=0;i<kotu.size();i++){
             if(kotu.get(i).getMin()!=0){
           g.setColor(Color.white);
           String mesage=kotu.get(i).getName()+" karakteri "+(kotu.get(i).getMin()-1)+" adımda gider.";            
           g.drawString(mesage,650,120+i*40);
           }
        }
        
          if(iyi.getName().equals("Master Yoda")){ 
          g.drawImage(MasterYoda, 40+x*40, 40+y*40, 40,40,this);
          }
          else if(iyi.getName().equals("Luke Skywalker")){ 
          g.drawImage(LukeSkywalker, 40+x*40, 40+y*40, 40,40,this);
          }
            
          
           
          //iyi karakter sonu
          for(int i=0;i<kotu.size();i++){
              if(kotu.get(i).getName().equals("Darth Vader")){
                 
            g.drawImage(DarthVader, 40+kotu.get(i).getLokasyon().getX()*40, 40+kotu.get(i).getLokasyon().getY()*40, 40,40,this);
            }
            else if(kotu.get(i).getName().equals("Kylo Ren")){ 
            g.drawImage(KyloRen, 40+kotu.get(i).getLokasyon().getX()*40, 40+kotu.get(i).getLokasyon().getY()*40, 40,40,this);
            }
            else if(kotu.get(i).getName().equals("Stormtrooper")){
                
            g.drawImage(Stromtrooper, 40+kotu.get(i).getLokasyon().getX()*40, 40+kotu.get(i).getLokasyon().getY()*40, 40,40,this);
            
            }  
            kotu.get(i).setHarita(harita);
            
          }// kötü karakter sonu   
          for(int i=1;i<=getCan();i++){
          if(i%2==1)    
          g.drawImage(Kalp_Sol, 660+i*25,40 , 20,40,this);
          if(i%2==0)
          g.drawImage(Kalp_Sag, 680+(i-1)*25, 40, 20,40,this);
          }
          
        
         
      
           if(can==0){
           timer.stop();
           g.drawImage(kaybettiniz, 0, 0, 900,570, this);              
          
          }
       
           if(x==14 && y==9){
          timer.stop();
          g.drawImage(kazandiniz, 0, 0, 900,570, this);              
           }
           }
         
                      
          
          
         
    }
    public boolean var_mi(int x,int y){
        for(int i=0;i<kotu.size();i++){
            if(kotu.get(i).getLokasyon().getX()==x && kotu.get(i).getLokasyon().getY()==y ){
            return false;
            }
        }
        
        return true;
    }
    
        @Override
    public void repaint() {
        super.repaint(); 
    }
    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c =e.getKeyCode();
        int s=0;
       
        if(c== KeyEvent.VK_LEFT){
            if(harita[y][x-xDir]==1){
                x-=xDir;
                    
            }
          s++;
        }
        else if(c == KeyEvent.VK_RIGHT){
            if(x==13 && y==9){
            x+=xDir;
            }
            else if(harita[y][x+xDir]==1)
            x+=xDir;
            s++;
        }
        else if(c == KeyEvent.VK_UP){
            if(harita[y-yDir][x]==1)
            y-=yDir;
           
            s++;
        }
        else if(c == KeyEvent.VK_DOWN){
            if(harita[y+yDir][x]==1)
            y+=yDir;
           
            s++;
        }
       
        lokasyon iyilokasyon =new lokasyon(x,y);
        iyi.setLokasyon(iyilokasyon);
      if(s!=0){
      for(int i=0;i<kotu.size();i++){
        kotu.get(i).EnKisaYol(new lokasyon(x,y));
               }
      }
         if(c == KeyEvent.VK_R){
             System.out.println("Oyun resetlendi");
             can=6;
             for(int i=0;i<kotu.size();i++){
                 kotu.get(i).setLokasyon(kotu_lok.get(i));
             }
             x=6;
             y=5;
             secim=-1;
             for(int k=0;k<kotu.size();k++){
                 for(int i=0;i<11;i++){
                     for(int j=0;j<14;j++){
                     kotu.get(k).getEnKisa()[i][j]=0;
                     }
                 }
              kotu.get(k).setMin(0);
             }
             
             timer.start();
            }
         if(c == KeyEvent.VK_M){
             secim=1;
             setKarakter(new MasterYoda());
             iyi =new MasterYoda();
             timer.start();
            }
         else if(c ==KeyEvent.VK_L){
             secim=2;
                iyi =new LukeSkywalker();
               setKarakter(new LukeSkywalker());
      
             timer.start();
            }
        if(c==KeyEvent.VK_E){
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<kotu.size();i++){

        if(karsilasti_mi(i)){
             timer.stop();
             canAzalt();
              
               x=6;
               y=5;
               
             for(int j=0;j<kotu.size();j++){
               for(int z=0;z<11;z++){
                     for(int k=0;k<14;k++){
                     kotu.get(j).getEnKisa()[z][k]=0;
                     }
                 }
                 System.out.println("X:"+kotu_lok.get(i).getX()+ " Y:"+kotu_lok.get(j).getY());
               kotu.get(j).setLokasyon(kotu_lok.get(j));
               
               }
                
                
            }
            timer.start();
          }
        repaint();
        
    }
    

    public static lokasyon harfcevir(char harf){
        lokasyon kord =new lokasyon();
        if(harf=='A'){
            kord.setX(0);
            kord.setY(5);
        }else if(harf=='B'){
            kord.setX(4);
            kord.setY(0);
        }else if(harf=='C'){
            kord.setX(12);
            kord.setY(0);
        }else if(harf=='D'){
            kord.setX(13);
            kord.setY(5);
        }else if(harf=='E'){
            kord.setX(4);
            kord.setY(10);
        } 
    
    return kord;


    }   
}
