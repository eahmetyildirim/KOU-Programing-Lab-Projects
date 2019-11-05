package prolab2_4;

import java.util.ArrayList;

public class DarthVader extends karakter{

    public DarthVader() {
        super("Darth Vader","kötü");
    }
    
   
    @Override
    public void EnKisaYol(lokasyon iyi_karakter) {
        int x1=    getLokasyon().getX();
        int y1=    getLokasyon().getY();
        int x2=iyi_karakter.getX();
        int y2=iyi_karakter.getY();
        lokasyon yeni_lokasyon=new lokasyon();
        ArrayList<ArrayList> yollar=new ArrayList<>();
        ArrayList<lokasyon> yol=new ArrayList<>();
     while(true){
        int yatay_fark=x2-x1;
        int dusey_fark=y2-y1;
        int y_f=yatay_fark;
        int d_f=dusey_fark;        
        if(y_f<0){
        y_f=-1*y_f;
        }
        if(d_f<0){
        d_f=-1*d_f;
        }
       if(x1==x2 && y1==y2){
          //  System.out.println("Beraberler");
        }else{
        if(y_f>d_f || y_f==d_f ){
           
           if(x2>x1){
            //   System.out.println("Sağa gidilicek");
               x1++;
           }else{
               //System.out.println("Sola gidilicek");
               x1--;
           }
        }else if(d_f>y_f){
            if(y2>y1){
                y1++;
               // System.out.println("Aşağı gidilicek");
            }else{
                y1--;
               // System.out.println("yukarı gidilicek");
            
            }
            
         }
        }
        
        yol.add(new lokasyon(x1,y1));
        if(x1==x2 && y1==y2){
        break;
        }
     }
       for(int i=0;i<11;i++){
           for(int j=0;j<14;j++){
           enKisa[i][j]=0;
           }
       }
       for(lokasyon i:yol){
           enKisa[i.getY()][i.getX()]=1;
       } 
        setMin(yol.size());
        setLokasyon(yol.get(0));
      
        
    }
    
}

