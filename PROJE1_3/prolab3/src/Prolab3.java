import java.awt.HeadlessException;
import javax.swing.JFrame;



public class Prolab3 {
    
    
    public static void main(String[] args) {
      grafikekrani grafik = new grafikekrani();
    //  Prolab3 ekran = new Prolab3("Grafik Kullanımı");
      RobotOlustur a = new  RobotOlustur();
        JFrame ekran=new JFrame();
     //************************************************************************************************************************************************************************
    if("Gezgin".equals(RobotOlustur.robot_tip)){
        if(RobotOlustur.robot_tür.equals("Tekerlekli")){
            TekerlekliRobot tekerli =new TekerlekliRobot(RobotOlustur.motor_sayi,RobotOlustur.yük_miktar,RobotOlustur.robot_tür,RobotOlustur.gezinme_hız,RobotOlustur.haraket_parca);
            double engelsuresi=tekerli.EngeldenGecmeSüresiniBul();
            TekerlekliRobot.IzgaraHaraketleri();
            double zaman=(double)(TekerlekliRobot.birim*10)/(double)RobotOlustur.gezinme_hız;
            zaman=(double)(engelsuresi*TekerlekliRobot.engel)+zaman;
            System.out.println("Geçen zaman:"+zaman);
            System.out.println("İlk konum x:"+GezginRobotlar.ilkx+" y:"+GezginRobotlar.ilky);
            System.out.println("Son konum x:"+GezginRobotlar.x2+" y:"+GezginRobotlar.y2);
        }
        else if(RobotOlustur.robot_tür.equals("Paletli")){
            PaletliRobot tekerli =new PaletliRobot(RobotOlustur.motor_sayi,RobotOlustur.yük_miktar,RobotOlustur.robot_tür,RobotOlustur.gezinme_hız,RobotOlustur.haraket_parca);
            double engel= tekerli.EngeldenGecmeSüresiniBul();
            PaletliRobot.IzgaraHaraketleri();
            double zaman=(double)(PaletliRobot.birim*10)/(double)RobotOlustur.gezinme_hız;
            zaman=(double)(engel*PaletliRobot.engel)+zaman;
            System.out.println("Geçen zaman:"+zaman);
            System.out.println("İlk konum x:"+GezginRobotlar.ilkx+" y:"+GezginRobotlar.ilky);
            System.out.println("Son konum x:"+GezginRobotlar.x2+" y:"+GezginRobotlar.y2);
        }
        else if(RobotOlustur.robot_tür.equals("Spider")){
            SpiderRobot spider =new SpiderRobot(RobotOlustur.motor_sayi,RobotOlustur.yük_miktar,RobotOlustur.robot_tür,RobotOlustur.gezinme_hız,RobotOlustur.haraket_parca);
            SpiderRobot.IzgaraHaraketleri();
            double zaman=(double)(SpiderRobot.birim*10)/(double)RobotOlustur.gezinme_hız;
            System.out.println("Geçen zaman:"+zaman);
            System.out.println("İlk konum x:"+GezginRobotlar.ilkx+" y:"+GezginRobotlar.ilky);
            System.out.println("Son konum x:"+GezginRobotlar.x2+" y:"+GezginRobotlar.y2);
            
            
        }
        System.out.println(
                "Robot tipi: "+RobotOlustur.robot_tip+
                "\nMotor sayisi: "+RobotOlustur.motor_sayi+
                "\nYük Miktari: "+RobotOlustur.yük_miktar+
                "\nGezinme Hızı: "+RobotOlustur.gezinme_hız+
                "\nHareket parcasi: "+RobotOlustur.haraket_parca);
        grafik.ilk_konum(GezginRobotlar.ilkx,GezginRobotlar.ilky);
        grafik.son_konum(GezginRobotlar.x2,GezginRobotlar.y2);
        grafik.engel_ekle(GezginRobotlar.x1,GezginRobotlar.y1,GezginRobotlar.engel_sayisi);
          
        
    }
    //************************************************************************************************************************************************************************
    else if("Gezmeyen".equals(RobotOlustur.robot_tip)){
        //(int motor_sayisi, int yük_miktari, String robot_tipi, int yük_taşıma_kapsitesi,int kol_uzunluğu,int yük_taşıma_hızı)
          if(RobotOlustur.robot_tür.equals("Seri")){
            SeriRobot seri =new SeriRobot(RobotOlustur.motor_sayi,RobotOlustur.yük_miktar,RobotOlustur.robot_tip,RobotOlustur.yük_tasıma_kapiste,RobotOlustur.kol_uzunluk,RobotOlustur.tasıma_hız);
            SeriRobot.uzaklıkKontrol();
            double zaman=(SeriRobot.birim*10)/RobotOlustur.tasıma_hız;
            System.out.println("Geçen zaman:"+zaman);
            System.out.println("İlk konum x:"+ManipülatörRobotlar.ilkx+" y:"+ManipülatörRobotlar.ilky);
            System.out.println("Son konum x:"+ManipülatörRobotlar.x1+" y:"+ManipülatörRobotlar.y1);
        }
         else if(RobotOlustur.robot_tür.equals("Paralel")){
            ParalelRobot paralel =new ParalelRobot(RobotOlustur.motor_sayi,RobotOlustur.yük_miktar,RobotOlustur.robot_tip,RobotOlustur.yük_tasıma_kapiste,RobotOlustur.kol_uzunluk,RobotOlustur.tasıma_hız);
            ParalelRobot.uzaklıkKontrol();
            double zaman=(ParalelRobot.birim*10)/RobotOlustur.tasıma_hız;
            System.out.println("Geçen zaman:"+zaman);
            System.out.println("İlk konum x:"+ManipülatörRobotlar.ilkx+" y:"+ManipülatörRobotlar.ilky);
            System.out.println("Son konum x:"+ManipülatörRobotlar.x1+" y:"+ManipülatörRobotlar.y1);
        }
          System.out.println(
                "Robot tipi: "+RobotOlustur.robot_tip+
                "\nMotor sayisi: "+RobotOlustur.motor_sayi+
                "\n Yük Kapasitesi:"+RobotOlustur.yük_tasıma_kapiste+
                "\nYük Miktari: "+RobotOlustur.yük_miktar+
                "\nTaşıma Hızı: "+RobotOlustur.tasıma_hız+
                "\nKol uzunluğu: "+RobotOlustur.kol_uzunluk);
        grafik.ilk_konum(ManipülatörRobotlar.ilkx,ManipülatörRobotlar.ilky);
        grafik.yuk_ekle(ManipülatörRobotlar.x1,ManipülatörRobotlar.y1);
    }
    //************************************************************************************************************************************************************************
    if("Hibrit".equals(RobotOlustur.robot_tip)){
        
        HibritRobot hibrit = new HibritRobot(RobotOlustur.motor_sayi,RobotOlustur.yük_miktar,RobotOlustur.robot_tür,RobotOlustur.gezinme_hız,RobotOlustur.haraket_parca,RobotOlustur.yük_tasıma_kapiste,RobotOlustur.kol_uzunluk,RobotOlustur.tasıma_hız,RobotOlustur.sabitlenme_suresi,RobotOlustur.gecis_suresi);
        System.out.println(
                "Robot tipi: "+RobotOlustur.robot_tip+
                "\nMotor sayisi: "+RobotOlustur.motor_sayi+
                "\n Yük Kapasitesi:"+RobotOlustur.yük_tasıma_kapiste+
                "\nYük Miktari: "+RobotOlustur.yük_miktar+
                "\nTaşıma Hızı: "+RobotOlustur.tasıma_hız+
                "\nKol uzunluğu: "+RobotOlustur.kol_uzunluk+
                "\nGezinme Hızı: "+RobotOlustur.gezinme_hız+
                "\nHareket parcasi: "+RobotOlustur.haraket_parca);
        double engelsure=hibrit.EngeldenGecmeSüresiniBul();
        HibritRobot.IzgaraHaraketleri();
        HibritRobot.uzaklıkKontrol();
        double zaman=(HibritRobot.birim*10)/RobotOlustur.gezinme_hız;
        zaman=(engelsure*HibritRobot.engel)+zaman+hibrit.getSabitlenme_suresi()+hibrit.getGecis_suresi();
        zaman=(HibritRobot.birimi*10)/RobotOlustur.tasıma_hız+zaman;
        System.out.println("Sabitlenme Süresi:"+hibrit.getSabitlenme_suresi());
        System.out.println("Geçiş Süresi:"+hibrit.getGecis_suresi());
        System.out.println("Geçen zaman:"+zaman);
        System.out.println("İlk konum x:"+HibritRobot.ilkx+" y:"+HibritRobot.ilky);
        System.out.println("Haraketsiz durumdaki konum x:"+HibritRobot.x2+" y:"+HibritRobot.y2);
        System.out.println("Son konum x:"+HibritRobot.a1+ " y:"+HibritRobot.a2);
        grafik.ilk_konum(HibritRobot.ilkx,HibritRobot.ilky);
        grafik.son_konum(HibritRobot.x2,HibritRobot.y2);
        grafik.yuk_ekle(HibritRobot.a1,HibritRobot.a2);
        grafik.engel_ekle(HibritRobot.x1,HibritRobot.y1,GezginRobotlar.engel_sayisi);
      
    }
      
       /* grafik.ilk_konum(3,4);
        grafik.son_konum(5,3);*/
       
        ekran.setVisible(true);
        ekran.setResizable(false);
        ekran.setSize(1000,700);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ekran.add(grafik); 
}
    
}
