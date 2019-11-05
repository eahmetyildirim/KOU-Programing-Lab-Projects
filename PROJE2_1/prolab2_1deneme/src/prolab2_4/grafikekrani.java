
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JPanel;


public class grafikekrani extends JPanel {
    private int x1,y1,x2,y2,engel_s,yuk_x,yuk_y;
    private int engelx[]=new int[20];
    private int engely[]=new int[20];
    public void ilk_konum (int x1,int y1){
       this.x1=x1;
       this.y1=y1;
    }
    public void son_konum (int x2,int y2){
       this.x2=x2;
       this.y2=y2;
    }
    public void engel_ekle(int ex[],int ey[],int engel_s){
        this.engel_s=engel_s;
        for(int i=0;i<engel_s;i++){
            this.engelx[i]=ex[i];
            this.engely[i]=ey[i];
            }
        }
    public void yuk_ekle(int x,int y){
        this.yuk_x=x;
        this.yuk_y=y;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        g.setColor(Color.white);
        for(int i=0;i<21;i++){
            for(int j=0;j<21;j++){
            g.drawRect((i*30),(j*30), 30, 30);
            }
        }
       
        g.setColor(Color.red);
        for(int i=0;i<this.engel_s;i++){
        g.fillRect(30*this.engelx[i],30*this.engely[i], 30,30);
        }
         g.setColor(Color.blue);
        g.fillRect(30*this.x1,30*this.y1, 30,30);
        g.setColor(Color.GREEN);
        g.fillRect(30*this.x2,30*this.y2, 30,30);
        g.setColor(Color.orange);
        g.fillRect(30*yuk_x,30*yuk_y, 30,30);
        // BİLGİLENDİRME 
        g.setColor(Color.white);
        g.drawString("ŞEKİL RENKLERİNİN ANLAMLARI",690,20);
        g.drawString("Robot ilk konum(Manipülatör robotların konumu sabittir.)",690,60);
        g.drawString("Robot son konum",690,100);
        g.drawString("Engel konumları",690,140);
        g.drawString("Yük son konum",690,180);
        g.setColor(Color.blue);
        g.fillRect(650,40, 30,30);
        g.setColor(Color.GREEN);
        g.fillRect(650,80, 30,30);
        g.setColor(Color.red);
        g.fillRect(650,120, 30,30);
        g.setColor(Color.orange);
        g.fillRect(650,160, 30,30);
        //BİLGİLENDİRME
        
    }

    public grafikekrani() {   
        setBackground(Color.black);
        x1=-5;
        y1=-5;
        x2=-5;
        y2=-5;
        yuk_x=-5;
        yuk_y=-5;
    }  
    
}
