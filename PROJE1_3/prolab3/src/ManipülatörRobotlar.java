
import java.util.Scanner;

public class ManipülatörRobotlar extends Robot implements GezmeyenRobotlar{
    //yük taşıma kapasitesi, kol uzunluğu, taşıma hızı 
    private int yük_tasıma_kapsitesi;
    private static int kol_uzunluğu;
    private int yük_tasıma_hızı;
    static int x1,y1,ilkx,ilky;
    static double birim,uzunluk;

    public ManipülatörRobotlar(int motor_sayisi, int yük_miktari, String robot_tipi, int yük_taşıma_kapsitesi,int kol_uzunluğuu,int yük_tasıma_hızı) {
        super(motor_sayisi, yük_miktari, robot_tipi);
        this.yük_tasıma_kapsitesi=yük_taşıma_kapsitesi;
        kol_uzunluğu=kol_uzunluğuu;
        this.yük_tasıma_hızı=yük_tasıma_hızı;
    }

    @Override
    public int getYük_tasıma_kapsitesi() {
        return yük_tasıma_kapsitesi;
    }

    @Override
    public void setYük_tasıma_kapsitesi(int yük_tasıma_kapsitesi) {
        this.yük_tasıma_kapsitesi = yük_tasıma_kapsitesi;
    }

    public static int  getKol_uzunluğu() {
        return kol_uzunluğu;
    }

    @Override
    public void  setKol_uzunluğu(int kol_uzunluğuu) {
        kol_uzunluğu = kol_uzunluğuu;
    }

    @Override
    public  int getYük_tasıma_hızı() {
        return yük_tasıma_hızı;
    }

    @Override
    public void setYük_tasıma_hızı(int yük_taşıma_hızı) {
        this.yük_tasıma_hızı = yük_taşıma_hızı;
    }
    
    
    //******************************************************************************************************************************************************
    public static void uzaklıkKontrol(){
       
            Scanner scanner=new Scanner(System.in);
       
            System.out.print("Robotun baslangic kordinatını giriniz:(x / y)");
            x1=scanner.nextInt();
            y1=scanner.nextInt();
            ilkx=x1;
            ilky=y1;
            
               
                
                    while(true){
                System.out.print("Koymak istediğiniz uzaklığı girin:(Çıkış için 0 a basınız)");
                int temp=scanner.nextInt();
                scanner.nextLine();
                if(temp>RobotOlustur.kol_uzunluk){
                    System.out.print("Kol uzunluğu yetersiz!!!!!!!!!!!");
                }
                else{
                 
                if(temp==0){
                    break;
                }
                System.out.print("Yönü giriniz:(sağ/sol/ileri/geri)");
                String yön = scanner.nextLine();             
                if(yön.equals("sag")){
                   
                      if(x1<=getKol_uzunluğu()){
                        x1+=temp;
                    }
                      else{
                          System.out.println("Kol uzunlugunun dışına çıktınız");
                      }
                }
                else if(yön.equals("sol")){
                     if(x1<=getKol_uzunluğu()){
                        x1-=temp;
                    }
                      else{
                          System.out.println("Kol uzunlugunun dışına çıktınız");
                      }    
                }
                else if(yön.equals("ileri")){
                    if(y1<=getKol_uzunluğu()){
                        y1+=temp;
                    }
                      else{
                          System.out.println("Kol uzunlugunun dışına çıktınız");
                      }    
                }
                else if(yön.equals("geri")){
                    if(y1<=getKol_uzunluğu()){
                        y1-=temp;
                    }
                      else{
                          System.out.println("Kol uzunlugunun dışına çıktınız");
                      }
                }  
            }
                }
      
          double x2=(ilkx-x1);
          double y2=(ilky-y1);
          x2=Math.abs(x2);
          y2=Math.abs(y2);
          double c=Math.pow(x2,2);
          double d=Math.pow(y2,2);
         birim=Math.sqrt(c+d);
         
         if(birim>RobotOlustur.kol_uzunluk){
             System.out.println("Kol uzunluğunu aştınızzzz!!!!!!!!");
             x1=ilkx;
             y1=ilky;
         }
    }
}



