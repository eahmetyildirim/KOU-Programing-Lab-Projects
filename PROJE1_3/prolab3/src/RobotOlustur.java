import java.util.Scanner;

public class RobotOlustur {
    static int i,g_hız;
    static String robot_tip,robot_tür;
    static int motor_sayi,secilen_robot,tasıma_hız,kol_uzunluk,yük_tasıma_kapiste,haraket_parca,gezinme_hız,yük_miktar;
    static String hareketli[]= new String[20];
    static String hareketsiz[]= new String[20];
    static int sabitlenme_suresi;
    static int gecis_suresi;
    static int gezgin=0,gezmeyen=0,t=0,p=0,s=0,pl=0,se=0;;
    public RobotOlustur(){
       
        int hız_kontrolT=0,hız_kontrolP=0,hız_kontrolS=0,yük_kontrolS=0,yük_kontrolP=0;
        String robot_tipi[]= new String[10];
        String robot_türü[]= new String[10];
        int motor_sayisi[]= new int[10];
        int yuk_miktari[]= new int[10];
        int gezinme_hizi[]= new int[10];
        int hareket_parcasi[]= new int[10];
        int yük_tasıma_kapasitesi[]= new int[10];
        int kol_uzunlugu[]= new int[10];
        int tasıma_hizi[]= new int[10];
       
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Kaç tane robot girmek istiyorsunuz:");
        int robot_sayisi=scanner.nextInt();
        scanner.nextLine();
        System.out.println("********************************************************************");
        System.out.println("Robot Tipi:Gezgin");
        System.out.println("-Tekerlekli");
        System.out.println("-Paletli");
        System.out.println("-Spider");
        System.out.println("********************************************************************");
        System.out.println("Robot Tipi:Gezmeyen(Manipülatör)");
        System.out.println("-Seri");
        System.out.println("-Paralel");
        System.out.println("********************************************************************");
        for(i=0;i<robot_sayisi;i++){
            System.out.print("Tanımlacak Robot tipini giriniz:(Gezgin/Gezmeyen/Hibrit)");
            robot_tipi[i]=scanner.nextLine();

            if(robot_tipi[i].equals("Gezgin")){
                 gezgin++;
                System.out.print("Robot Türünü giriniz:(Tekerlekli/Paletli/Spider)");
                robot_türü[i]=scanner.nextLine();
                System.out.print("Motor sayısını giriniz:");
            motor_sayisi[i]=scanner.nextInt();
                
                System.out.print("Yük miktarını giriniz:");
                yuk_miktari[i]=scanner.nextInt();
                System.out.println(
                                "\n Tekerlekli Robotun  Hız Sınırı:21-30 arası"+
                                "\n Paletli Robotun  Hız Sınırı:10-20 arası"+
                                "\n Spider Robotun  Hız Sınırı:0-9 arası\n"
                        );
                System.out.print("Gezinme hızını giriniz:");
                gezinme_hizi[i]=scanner.nextInt();
                scanner.nextLine();
                if(robot_türü[i].equals("Tekerlekli")){
                    t=i;
                    if(gezinme_hizi[i]<20||gezinme_hizi[i]>30){
                         while(true){
                             if(gezinme_hizi[i]>20&&gezinme_hizi[i]<=30)break;  
                        System.out.println("Geçerli gezinme hızını giriniz");
                        gezinme_hizi[i]=scanner.nextInt();
                        scanner.nextLine();
                        } 
                    }
                }
                else if(robot_türü[i].equals("Paletli")){
                    p=i;
                    if(gezinme_hizi[i]<10||gezinme_hizi[i]>20){
                        while(true){
                        if(gezinme_hizi[i]>10&&gezinme_hizi[i]<=20) break;
                        System.out.println("Geçerli gezinme hızını giriniz");
                        gezinme_hizi[i]=scanner.nextInt();
                        scanner.nextLine();
                        }
                    }
                }        
                else if(robot_türü[i].equals("Spider")){
                    s=i;
                    if(gezinme_hizi[i]<0||gezinme_hizi[i]>=10){
                         while(true){
                             if(gezinme_hizi[i]>0&&gezinme_hizi[i]<10) break;
                            System.out.println("Geçerli gezinme hızını giriniz");
                            gezinme_hizi[i]=scanner.nextInt();
                            scanner.nextLine();
                          }
                    }
                }
                  if(robot_türü[i].equals("Tekerlekli")){
                    System.out.print("Teker sayisini giriniz:");
                    hareket_parcasi[i]=scanner.nextInt();
                    scanner.nextLine();}
                    else if(robot_türü[i].equals("Paletli")){
                    System.out.print("Palet sayisini giriniz:");
                    hareket_parcasi[i]=scanner.nextInt();
                    scanner.nextLine();}
                 else if(robot_türü[i].equals("Spider")){
                    System.out.print("Bacak sayisini giriniz:");
                    hareket_parcasi[i]=scanner.nextInt();
                    scanner.nextLine();
                }   
            }
            else if(robot_tipi[i].equals("Gezmeyen")){
                gezmeyen++;
                 System.out.print("Robot Türünü giriniz:(Seri/Paralel)");
                  robot_türü[i]=scanner.nextLine();
                   System.out.print("Motor sayısını giriniz:");
            motor_sayisi[i]=scanner.nextInt();
                 System.out.print("Yük taşıma kapasitesini giriniz:");
                 yük_tasıma_kapasitesi[i]=scanner.nextInt();
                 if("Seri".equals(robot_türü[i])){
                     se=i;
                     yük_kontrolS=yük_tasıma_kapasitesi[i];
                            if(yük_kontrolP!=0&&yük_kontrolS!=0){
                    if(yük_kontrolP<=yük_kontrolS){
                        yük_kontrolS=yukKontrol2(yük_kontrolP,yük_kontrolS);
                        yük_tasıma_kapasitesi[i]=yük_kontrolS;
                    } 
                }
                     
                 }
                 else if("Paralel".equals(robot_türü[i])){
                     pl=i;
                     yük_kontrolP=yük_tasıma_kapasitesi[i];
                            if(yük_kontrolP!=0&&yük_kontrolS!=0){
                    if(yük_kontrolP<=yük_kontrolS){
                        yük_kontrolP=yukKontrol(yük_kontrolP,yük_kontrolS);
                        yük_tasıma_kapasitesi[i]=yük_kontrolP;
                    } 
                            }   
                 }
                 System.out.print("Yük miktarını giriniz:");
                 yuk_miktari[i]=scanner.nextInt();

                    if(yuk_miktari[i]>yük_tasıma_kapasitesi[i]){
                        while(true){
                        System.out.println("Geçerli yük miktarını giriniz kapasiteyi aştınız");
                        yuk_miktari[i]=scanner.nextInt();
                        if(yuk_miktari[i]<=yük_tasıma_kapasitesi[i]){
                            break;
                        }
                            
                        }
                        }
                 System.out.print("Kol uzunluğunu giriniz:");
                 kol_uzunlugu[i]=scanner.nextInt();
                 System.out.print("Taşıma hızını giriniz giriniz:");
                 tasıma_hizi[i]=scanner.nextInt();
                 scanner.nextLine();
                   if(robot_türü[i].equals("Paralel")){
                    hız_kontrolP=tasıma_hizi[i];
                       if(hız_kontrolP!=0&&hız_kontrolS!=0){
                    if(hız_kontrolP<=hız_kontrolS){
                       hız_kontrolP=hızKotnrol(hız_kontrolP,hız_kontrolS);
                        tasıma_hizi[i]=hız_kontrolP;
                    } 
                }
                     }
                else if(robot_türü[i].equals("Seri")){
                    hız_kontrolS=tasıma_hizi[i];
                       if(hız_kontrolP!=0&&hız_kontrolS!=0){
                    if(hız_kontrolP<=hız_kontrolS){
                        hız_kontrolS=hızKotnrol2(hız_kontrolP,hız_kontrolS);
                        tasıma_hizi[i]=hız_kontrolS;
                    } 
                }
                 
                
                }
                      
                     }
            if(robot_tipi[i].equals("Hibrit")){
                System.out.print("Hibrit robot için hareketli kısmı:");
                hareketli[i]=scanner.nextLine();
                System.out.print("Hibrit robot için haraketsiz kısmı:");
                hareketsiz[i]=scanner.nextLine();
                
                
                if(gezmeyen==0&&gezgin==0){
                    System.out.print("Motor sayısını giriniz:");
                    motor_sayisi[i]=scanner.nextInt();
                    System.out.print("Yük taşıma kapasitesini giriniz:");
                    yük_tasıma_kapasitesi[i]=scanner.nextInt();
                    System.out.print("Yük miktarını giriniz:");
                    yuk_miktari[i]=scanner.nextInt();
                       if(yuk_miktari[i]>yük_tasıma_kapasitesi[i]){
                        while(true){
                            System.out.println("Geçerli yük miktarını giriniz kapasiteyi aştınız");
                            yuk_miktari[i]=scanner.nextInt();
                            if(yuk_miktari[i]<=yük_tasıma_kapasitesi[i]){
                                break;
                            }      
                        }
                   }
                    
                    
                    System.out.print("Kol uzunluğunu giriniz:");
                    kol_uzunlugu[i]=scanner.nextInt();
                    System.out.print("Sabitlenme süresini giriniz:");
                    sabitlenme_suresi=scanner.nextInt();
                    System.out.print("Yükü kola geçirme süresini giriniz:");
                    gecis_suresi=scanner.nextInt();
                    System.out.print("Taşıma hızını giriniz giriniz:");
                    tasıma_hizi[i]=scanner.nextInt();
                    scanner.nextLine();
                       if(hareketli[i].equals("Paralel")){
                        hız_kontrolP=tasıma_hizi[i];
                        if(hız_kontrolP!=0&&hız_kontrolS!=0){
                           if(hız_kontrolP<=hız_kontrolS){
                               hız_kontrolP=hızKotnrol(hız_kontrolP,hız_kontrolS);
                               tasıma_hizi[i]=hız_kontrolP;
                            } 
                         }
                        }
                    else if(hareketli[i].equals("Seri")){
                        hız_kontrolS=tasıma_hizi[i];
                           if(hız_kontrolP!=0&&hız_kontrolS!=0){
                                if(hız_kontrolP<=hız_kontrolS){
                                    hız_kontrolS=hızKotnrol2(hız_kontrolP,hız_kontrolS);
                                    tasıma_hizi[i]=hız_kontrolS;
                                } 
                            }
                     }

                 
                    System.out.print("Gezinme hızını giriniz:");
                    gezinme_hizi[i]=scanner.nextInt();
                    scanner.nextLine();
                    if(hareketli[i].equals("Tekerlekli")){
                             if(gezinme_hizi[i]<20||gezinme_hizi[i]>30){{
                             while(true){
                                 if(gezinme_hizi[i]>20&&gezinme_hizi[i]<=30)break;  
                            System.out.println("Geçerli gezinme hızını giriniz(Hız sınırı=30)");
                            gezinme_hizi[i]=scanner.nextInt();
                            scanner.nextLine();
                        } 

                        }

                         }

                    else if(hareketli[i].equals("Paletli")){
                                            if(gezinme_hizi[i]<10||gezinme_hizi[i]>20){
                            while(true){
                            if(gezinme_hizi[i]>10&&gezinme_hizi[i]<=20) break;
                            System.out.println("Geçerli gezinme hızını giriniz(Hız sınırı=20)");
                            gezinme_hizi[i]=scanner.nextInt();
                            scanner.nextLine();
                        }
                        }
                    }

                    }
                    else if(hareketli[i].equals("Spider")){
                                            if(gezinme_hizi[i]<0||gezinme_hizi[i]>10){
                             while(true){
                                 if(gezinme_hizi[i]>0&&gezinme_hizi[i]<=10) break;
                                System.out.println("Geçerli gezinme hızını giriniz(Hız sınırı=10)");
                                gezinme_hizi[i]=scanner.nextInt();
                                scanner.nextLine();
                              }
                        }

                    }
                    if(hareketli[i].equals("Tekerlekli")){
                        System.out.print("Teker sayisini giriniz:");
                        hareket_parcasi[i]=scanner.nextInt();
                        scanner.nextLine();}
                    else if(hareketli[i].equals("Paletli")){
                        System.out.print("Palet sayisini giriniz:");
                        hareket_parcasi[i]=scanner.nextInt();
                        scanner.nextLine();}
                    else if(hareketli[i].equals("Spider")){
                        System.out.print("Bacak sayisini giriniz:");
                        hareket_parcasi[i]=scanner.nextInt();
                        scanner.nextLine();
                    } 

                    }

                
                    else if(gezmeyen==0&&gezgin>0){
                        
                    System.out.print("Sabitlenme süresini giriniz:");
                    sabitlenme_suresi=scanner.nextInt();
                    System.out.print("Yükü kola geçirme süresini giriniz:");
                    gecis_suresi=scanner.nextInt();
                    System.out.print("Kol uzunluğunu giriniz:");
                    kol_uzunlugu[i]=scanner.nextInt();
                    System.out.print("Taşıma hızını giriniz giriniz:");
                    tasıma_hizi[i]=scanner.nextInt();
                    System.out.print("Yük taşıma kapasitesini giriniz:");
                    yük_tasıma_kapasitesi[i]=scanner.nextInt();
                    scanner.nextLine();
                  
                       if(yuk_miktari[i]>yük_tasıma_kapasitesi[i]){
                        while(true){
                           System.out.print("YETERSİZ KAPASİTE!!!!!!!!\n"
                                   + "Yük taşıma kapasitesini giriniz:");
                            yük_tasıma_kapasitesi[i]=scanner.nextInt();
                            scanner.nextLine();
                            if(yuk_miktari[i]<=yük_tasıma_kapasitesi[i]){
                                break;
                            }      
                        }
                         
                    
                   }   
                    }
                     else if(gezmeyen>0&&gezgin==0){
                         
                        System.out.print("Sabitlenme süresini giriniz:");
                        sabitlenme_suresi=scanner.nextInt();
                        System.out.print("Yükü kola geçirme süresini giriniz:");
                        gecis_suresi=scanner.nextInt();
                        System.out.print("Gezinme hızını giriniz:");
                        gezinme_hizi[i]=scanner.nextInt();
                        scanner.nextLine();
                        if(hareketli[i].equals("Tekerlekli")){
                                 if(gezinme_hizi[i]<20||gezinme_hizi[i]>30){{
                                 while(true){
                                     if(gezinme_hizi[i]>20&&gezinme_hizi[i]<=30)break;  
                                System.out.println("Geçerli gezinme hızını giriniz(Hız sınırı=30)");
                                gezinme_hizi[i]=scanner.nextInt();
                                scanner.nextLine();
                            } 

                            }

                             }

                        else if(hareketli[i].equals("Paletli")){
                                                if(gezinme_hizi[i]<10||gezinme_hizi[i]>20){
                                while(true){
                                if(gezinme_hizi[i]>10&&gezinme_hizi[i]<=20) break;
                                System.out.println("Geçerli gezinme hızını giriniz(Hız sınırı=20)");
                                gezinme_hizi[i]=scanner.nextInt();
                                scanner.nextLine();
                            }
                            }
                        }

                        }
                        else if(hareketli[i].equals("Spider")){
                            if(gezinme_hizi[i]<0||gezinme_hizi[i]>10){
                                while(true){
                                    if(gezinme_hizi[i]>0&&gezinme_hizi[i]<=10) break;
                                    System.out.println("Geçerli gezinme hızını giriniz(Hız sınırı=10)");
                                    gezinme_hizi[i]=scanner.nextInt();
                                    scanner.nextLine();
                                  }
                            }

                        }
                   if(hareketli[i].equals("Tekerlekli")){
                        System.out.print("Teker sayisini giriniz:");
                        hareket_parcasi[i]=scanner.nextInt();
                        scanner.nextLine();}
                    else if(hareketli[i].equals("Paletli")){
                        System.out.print("Palet sayisini giriniz:");
                        hareket_parcasi[i]=scanner.nextInt();
                        scanner.nextLine();}
                    else if(hareketli[i].equals("Spider")){
                        System.out.print("Bacak sayisini giriniz:");
                        hareket_parcasi[i]=scanner.nextInt();
                        scanner.nextLine();
                    }
                
                    } 
                
                
                
            }
            System.out.println("********************************************************************");
    }
        
             
        System.out.println("Kacıncı robotla islem yapcaksanız:");
        secilen_robot=scanner.nextInt();
        if(!robot_tipi[secilen_robot-1].equals("Hibrit")){
        robot_tip=robot_tipi[secilen_robot-1];
        motor_sayi=motor_sayisi[secilen_robot-1];
        yük_miktar=yuk_miktari[secilen_robot-1];
        gezinme_hız=gezinme_hizi[secilen_robot-1];
        haraket_parca=hareket_parcasi[secilen_robot-1];
        robot_tür=robot_türü[secilen_robot-1];
        tasıma_hız=tasıma_hizi[secilen_robot-1];
        kol_uzunluk=kol_uzunlugu[secilen_robot-1];
        yük_tasıma_kapiste=yük_tasıma_kapasitesi[secilen_robot-1];
            
        }
        else{
            System.out.println("t:"+t+"p"+p+"s:"+s);
            robot_tip=robot_tipi[secilen_robot-1];
               robot_tür=hareketli[secilen_robot-1];
                tasıma_hız=tasıma_hizi[secilen_robot-1];
                kol_uzunluk=kol_uzunlugu[secilen_robot-1];
                yük_tasıma_kapiste=yük_tasıma_kapasitesi[secilen_robot-1];
            if(gezgin>0){
                if(hareketli[secilen_robot-1].equals("Tekerlekli")) secilen_robot=t; 
                else if(hareketli[secilen_robot-1].equals("Paletli")) secilen_robot=p;
                else if(hareketli[secilen_robot-1].equals("Spider")) secilen_robot=s;
                
                motor_sayi=motor_sayisi[secilen_robot];
                yük_miktar=yuk_miktari[secilen_robot];
                gezinme_hız=gezinme_hizi[secilen_robot];
                haraket_parca=hareket_parcasi[secilen_robot];


            }
            else if(gezmeyen>0){
                if(hareketsiz[secilen_robot-1].equals("Paralel")&&t!=0) secilen_robot=pl; 
                if(hareketsiz[secilen_robot-1].equals("Seri")&&p!=0) secilen_robot=se;

                              
            }
            else{
                robot_tür=hareketli[secilen_robot-1];
                motor_sayi=motor_sayisi[secilen_robot-1];
                yük_miktar=yuk_miktari[secilen_robot-1];
                gezinme_hız=gezinme_hizi[secilen_robot-1];
                haraket_parca=hareket_parcasi[secilen_robot-1];
                tasıma_hız=tasıma_hizi[secilen_robot-1];
                kol_uzunluk=kol_uzunlugu[secilen_robot-1];
                yük_tasıma_kapiste=yük_tasıma_kapasitesi[secilen_robot-1];
            }
           
              
        
            
            
            
            
        }
      
             }   
    
     public final int hızKotnrol(int h1,int h2){
          Scanner scanner = new Scanner(System.in);
                    while(h1<=h2){
                        System.out.print("Geçerli gezinme hızı giriniz:");
                        g_hız=scanner.nextInt();
                        scanner.nextLine();
                        if(g_hız>h2){
                            break;
                        }
                    }        
                     return g_hız;
    }
           
       public static int hızKotnrol2(int h1,int h2){
          Scanner scanner = new Scanner(System.in);
                    while(h1<=h2){
                        System.out.print("Geçerli gezinme hızı giriniz:");
                        g_hız=scanner.nextInt();
                        scanner.nextLine();
                        if(g_hız<h1){
                            break;
                        }
                    }              
                    return g_hız;
    }
       public static int yukKontrol(int a1,int a2){
            Scanner scanner = new Scanner(System.in);
             while(a1<=a2){
                        System.out.print("Geçerli kapasiteyi giriniz:");
                        g_hız=scanner.nextInt();
                        scanner.nextLine();
                        if(g_hız>a2){
                            break;
                        }
                    }              
                    return g_hız;

           
       }
          public static int yukKontrol2(int a1,int a2){
            Scanner scanner = new Scanner(System.in);
             while(a1<=a2){
                        System.out.print("Geçerli kapasiteyi giriniz:");
                        g_hız=scanner.nextInt();
                        scanner.nextLine();
                        if(g_hız<a1){
                            break;
                        }
                    }              
                    return g_hız;

           
       }
}



