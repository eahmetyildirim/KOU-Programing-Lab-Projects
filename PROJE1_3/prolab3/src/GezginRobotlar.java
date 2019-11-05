
import java.util.Scanner;

public class GezginRobotlar extends Robot{
    static int engel=0;
    static int  x2=0,y2=0,ilkx,ilky,c=0;
    static int birim=0;
    static int[] x1= new int[20];// engellerin kordinatları
    static int[] y1= new int[20];
    static int engel_sayisi=0;
    private int gezinme_hizi;
    static int[][] izgara = new int[30][30];

    public GezginRobotlar(int motor_sayisi, int yük_miktari, String robot_tipi,int gezinme_hızı) {
        super(motor_sayisi, yük_miktari, robot_tipi);
        this.gezinme_hizi=gezinme_hızı;
    }

    public int getGezinme_hızı() {
        return gezinme_hizi;
    }

    public void setGezinme_hizi(int gezinme_hizi) {
        this.gezinme_hizi = gezinme_hizi;
    }
    //*******************************************************************************************************************************************************************
        public double EngeldenGecmeSüresiniBul(){
        double sure;
        if(getRobot_tipi().equals("Tekerlekli")){
            sure=RobotOlustur.motor_sayi*(0.5);
            System.out.println("Engeli aşma süresi:"+sure);
            return sure;
            
        }
        else if(getRobot_tipi().equals("Paletli")){
            sure=RobotOlustur.motor_sayi*3;
            System.out.println("Engeli aşma süresi:"+sure);
            return sure;
        }
        else return 0;
        }
    //*******************************************************************************************************************************************************************
      
        public static void IzgaraHaraketleri(){
           //30 olmasının sebebi eğer kullanıcı izgara dışına çıkarsa ve kontroller sırasında olmayan yere erişim sağlanırsa java hata vermesin diye
          
           
            
            Scanner scanner=new Scanner(System.in);
            System.out.print("Kaç engel gireceksiniz");
            int engel_s=scanner.nextInt();
            for(int i=0;i<engel_s;i++){
                engel_sayisi=engel_s;
                System.out.print("x koridinatını giriniz:");
                x1[i]= scanner.nextInt();
                System.out.print("y kordinatını giriniz:");
                y1[i]= scanner.nextInt();
                izgara[x1[i]][y1[i]]=1;
                System.out.println("izgara:"+izgara[x1[i]][y1[i]]);
            }
            System.out.print("Robotun baslangic kordinatını giriniz:(x / y)");
            x2=scanner.nextInt();
            y2=scanner.nextInt();
            
            ilkx=x2;
            ilky=y2;
            
            while(true){
                System.out.print("Birimi giriniz:(Çıkış için 0 a basınız)");
                int temp=scanner.nextInt();
                scanner.nextLine();
                birim+=temp;
                if(temp==0){
                    break;
                }
                System.out.print("Yönü giriniz:(sag/sol/ileri/geri)");
                String yön = scanner.nextLine();               
                if(yön.equals("sag")){
                    for(;temp>0;temp--){
                        if(izgara[x2][y2]==1){
                             if(getRobot_tipi().equals("Spider")){
                                System.out.println("Spider robot engel geçemez engele takıldınız");
                                c++;
                                break;
                                
                            }
                            engel++;
                            
                         }
                        x2+=1;
                        if(x2>20){
                        System.out.println("Dışarı çıktınız!!!!!!!!!!!!!!!!!!!");
                        break;
                }
                    }
                }
                else if(yön.equals("sol")){
                    for(;temp>0;temp--){
                        if(izgara[x2][y2]==1){
                             if(getRobot_tipi().equals("Spider")){
                                System.out.println("Spider robot engel geçemez engele takıldınız");
                                c++;
                                break;
                                
                            }
                            engel++;
                        }
                     
                        x2-=1;
                           if(x2<0){
                    System.out.println("Dışarı çıktınız!!!!!!!!!!!!!!!!!!!");
                    break;
                    }
                    }    
                }
                
                else if(yön.equals("ileri")){
                    for(;temp>0;temp--){
                        if(izgara[x2][y2]==1){
                            if(getRobot_tipi().equals("Spider")){
                                System.out.println("Spider robot engel geçemez engele takıldınız");
                                c++;
                                break;
                            }
                            engel++;
                        }
                        y2+=1;
                     if(y2>20){
                    System.out.println("Dışarı çıktınız!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                    }    
                }
                else if(yön.equals("geri")){
                    for(;temp>0;temp--){
                        if(izgara[x2][y2]==1){
                            if(getRobot_tipi().equals("Spider")){
                                System.out.println("Spider robot engel geçemez engele takıldınız");
                                c++;
                                break;
                            }
                           engel++;
                        }
                        y2-=1;
                          if(y2<0){
                    System.out.println("Dışarı çıktınız!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                     }
                }
                if(c>0){
                    break;
                }
                
            }
            
            System.out.println("Engel sayisi:"+engel);
        }
        //*******************************************************************************************************************************************************************
       
        
    
}
