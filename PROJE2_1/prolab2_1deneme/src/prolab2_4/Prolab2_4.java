package prolab2_4;

import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Prolab2_4 extends JFrame{
    

    public Prolab2_4(String title) throws HeadlessException {
        super(title);
    }
    
    public static void main(String[] args) {
        
        int secim=-1;
        Scanner scan =new Scanner(System.in);
       /* while(secim!=1 && secim!=2){
        System.out.println("Oynucayağınız karakteri seçiniz");
        System.out.println("1-Master Yoda");
        System.out.println("2-Luke Skywalker");
            
         secim=scan.nextInt();
         if(secim!=1 && secim!=2){
             System.out.println("Lütfen 1 veya 2  giriniz!!");
         }
        }*/
         Prolab2_4 ekran=new Prolab2_4("StarWars");
        ekran.setResizable(false);
        ekran.setFocusable(false);
        ekran.setSize(900,600);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oyun Game=new oyun();
        Game.requestFocus();
        Game.addKeyListener(Game);
        Game.setFocusable(true);
        Game.setFocusTraversalKeysEnabled(false);
        ekran.setVisible(false);    
        
        ekran.add(Game);
        ekran.setVisible(true);
        
        
    }
    
    
    
    
    
}
