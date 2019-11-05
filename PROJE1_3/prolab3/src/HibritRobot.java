
import java.util.Scanner;

public class HibritRobot extends GezginRobotlar implements GezmeyenRobotlar {
    private int haraket_parcasi;
    private int yük_tasıma_kapsitesi;
    private static int kol_uzunluğu;
    private int sabitlenme_suresi;
    private int gecis_suresi;
    private int yük_tasıma_hızı;
    static int a1 ,a2,brm=0;
    static double birimi;
  //******************************************************************************************************************************************************  
    public HibritRobot(int motor_sayisi, int yük_miktari, String robot_tipi, int gezinme_hızı,int haraket_parcasi,int yük_tasıma_kapsitesi,int kol_uzunluguu,int yük_tasıma_hızı,int sabitlenme_suresi,int gecis_suresi) {
        super(motor_sayisi, yük_miktari, robot_tipi, gezinme_hızı);
        this.haraket_parcasi=haraket_parcasi;
        this.yük_tasıma_kapsitesi=yük_tasıma_kapsitesi;
        kol_uzunluğu=kol_uzunluguu;
        this.yük_tasıma_hızı=yük_tasıma_hızı;
        this.gecis_suresi=gecis_suresi;
        this.sabitlenme_suresi=sabitlenme_suresi;
    }
//******************************************************************************************************************************************************
    @Override
    public int getYük_tasıma_kapsitesi() {
        return yük_tasıma_kapsitesi;
    }

    @Override
    public void setYük_tasıma_kapsitesi(int yük_taşıma_kapsitesi) {
        this.yük_tasıma_kapsitesi = yük_taşıma_kapsitesi;
    }

    public static int getKol_uzunluğu() {
        return kol_uzunluğu;
    }

    @Override
    public void setKol_uzunluğu(int kol_uzunluğu) {
        HibritRobot.kol_uzunluğu = kol_uzunluğu;
    }

    @Override
    public int getYük_tasıma_hızı() {
        return yük_tasıma_hızı;
    }

    @Override
    public void setYük_tasıma_hızı(int yük_tasıma_hızı) {
        this.yük_tasıma_hızı = yük_tasıma_hızı;
    }
    
    public int getHaraket_parcasi() {
        return haraket_parcasi;
    }

    public void setHaraket_parcasi(int haraket_parcasi) {
        this.haraket_parcasi = haraket_parcasi;
    }

    public int getSabitlenme_suresi() {
        return sabitlenme_suresi;
    }

    public void setSabitlenme_suresi(int sabitlenme_suresi) {
        this.sabitlenme_suresi = sabitlenme_suresi;
    }

    public int getGecis_suresi() {
        return gecis_suresi;
    }

    public void setGecis_suresi(int gecis_suresi) {
        this.gecis_suresi = gecis_suresi;
    }
    //******************************************************************************************************************************************************
        public static void uzaklıkKontrol(){
       
            Scanner scanner=new Scanner(System.in);
                
            a1=x2;
            a2=y2;
      
         
            
              
                    while(true){
                System.out.print("Koymak istediğiniz uzaklığı girin:(Çıkış için 0 a basınız)");
                int temp=scanner.nextInt();
                scanner.nextLine();
                brm+=temp;
                 
                if(temp==0){
                    break;
                }
                System.out.print("Yönü giriniz(sağ/sol/ileri/geri");
                String yön = scanner.nextLine();             
                if(yön.equals("sag")){
                    if(temp<=getKol_uzunluğu()){
                        a1+=temp;
                    }
                        
                }
                else if(yön.equals("sol")){
                    if(temp<=getKol_uzunluğu()){
                        a1-=temp;
                    }
                    else{
                        System.out.println("Kol uzunlugunuz yetersiz");
                    }
                    
                   
                }
                else if(yön.equals("ileri")){
                      if(temp<=getKol_uzunluğu()){
                        a2+=temp;
                    }
                    else{
                        System.out.println("Kol uzunlugunuz yetersiz");
                    }
                  
                }
                else if(yön.equals("geri")){
                       if(temp<=getKol_uzunluğu()){
                        a2-=temp;
                    }
                    else{
                        System.out.println("Kol uzunlugunuz yetersiz");
                    }
              
                }
                
              
                
            }
                    
                 double x2=(ilkx-a1);
          double y2=(ilky-a2);
          x2=Math.abs(x2);
          y2=Math.abs(y2);
          double c=Math.pow(x2,2);
          double d=Math.pow(y2,2);
         birimi=Math.sqrt(c+d);
         
         if(birimi>RobotOlustur.kol_uzunluk){
             System.out.println("Kol uzunluğunu aştınızzzz!!!!!!!!");
             a1=ilkx;
             a2=ilky;
         }
     
    }
}
    
    
    
    

