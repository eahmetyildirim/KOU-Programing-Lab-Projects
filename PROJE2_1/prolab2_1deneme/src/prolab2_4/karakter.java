package prolab2_4;

import java.util.ArrayList;

public class karakter{
    private String name,turu;
    private lokasyon lokasyon=new lokasyon();
    private  int[][] harita=new int[11][14];
    int[][] enKisa=new int[11][14];
    private int can=6;

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }
    
    
    public karakter(String name, String turu) {
   
        this.name = name;
        this.turu = turu;
    }
    


    public karakter() {
    }

    public int[][] getEnKisa() {
        return enKisa;
    }

    public void setEnKisa(int[][] enKisa) {
        this.enKisa = enKisa;
    }
    
    
    public int[][] getHarita() {
        return harita;
    }

    public void setHarita(int[][] harita) {
        this.harita = harita;
    }
    
    
    public lokasyon getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(lokasyon lokasyon) {
        this.lokasyon = lokasyon;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }
    private int min=0;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
    
    private  final int M = 11;
	private  final int N = 14;
        private  final ArrayList<lokasyon> info =new ArrayList<>();
        private  boolean kontrol(int harita[][], int bakilan[][], int x, int y){
		return !(harita[x][y] == 0 || bakilan[x][y] != 0);
	}

	private  boolean haritada_mi(int x, int y){
		return (x < M && y < N && x >= 0 && y >= 0);
	}
	
	public  int enKisaYolBul(int harita[][], int bakilan[][],int i, int j, int x, int y, int min_uzaklik, int uzaklik){

		if (i == x && j == y){
                        return Integer.min(uzaklik, min_uzaklik);           
                }

		bakilan[i][j] = 1;

                
		if (haritada_mi(i - 1, j) && kontrol(harita, bakilan, i - 1, j)) {
			min_uzaklik = enKisaYolBul(harita, bakilan, i - 1, j, x, y,min_uzaklik, uzaklik + 1);
                }
                if (haritada_mi(i, j + 1) && kontrol(harita, bakilan, i, j + 1)) {
			min_uzaklik = enKisaYolBul(harita, bakilan, i, j + 1, x, y,min_uzaklik, uzaklik + 1);
                }
                if (haritada_mi(i, j - 1) && kontrol(harita, bakilan, i, j - 1)) {
			min_uzaklik = enKisaYolBul(harita, bakilan, i, j - 1, x, y,min_uzaklik, uzaklik + 1);
                }
                if (haritada_mi(i + 1, j) && kontrol(harita, bakilan, i + 1, j)) {
			min_uzaklik = enKisaYolBul(harita, bakilan, i + 1, j, x, y,min_uzaklik, uzaklik + 1);
                }
                bakilan[i][j] = 0;
		return min_uzaklik;
                
	}


        

	private  int kacYolvar(int matris[][],int x, int y, int kotu_x,int kotu_y ,boolean bakilan_yol[][], int yol_sayisi){
		if (x == kotu_x && y == kotu_y)
		{
                    int say=0;
                        for(int i=0;i<11;i++){
                            for(int j=0;j<14;j++){
                            if(bakilan_yol[i][j]==true)
                                say++;
                            }
                        }
                        if(min==say){
                           for(int i=0;i<11;i++){
                            for(int j=0;j<14;j++){
                            if(bakilan_yol[i][j]==true){
                                    info.add(new lokasyon(i,j));
                            }else{
                                    }
                            }
                        }
                             yol_sayisi++;
			}
                       
			return yol_sayisi;
		}

		bakilan_yol[x][y] = true;

		if (haritada_mi(x, y) && matris[x][y] == 1)
		{
			
			
			if (y + 1 < 14 && !bakilan_yol[x][y + 1])
				yol_sayisi = kacYolvar(matris, x, y + 1,kotu_x,kotu_y, bakilan_yol, yol_sayisi);

                        if (x + 1 < 11 && !bakilan_yol[x + 1][y])
				yol_sayisi = kacYolvar(matris, x + 1, y,kotu_x,kotu_y, bakilan_yol, yol_sayisi);
        
                        
			if (y - 1 >= 0 && !bakilan_yol[x][y - 1])
				yol_sayisi = kacYolvar(matris, x, y - 1,kotu_x,kotu_y, bakilan_yol, yol_sayisi);
                        
                        if (x - 1 >= 0 && !bakilan_yol[x - 1][y])
				yol_sayisi = kacYolvar(matris, x - 1, y,kotu_x,kotu_y, bakilan_yol, yol_sayisi);

                        
		}

		bakilan_yol[x][y] = false;

		return yol_sayisi;
	}

    
    
    public void  EnKisaYol(lokasyon iyi_karakter){
        
        int yol_sayisi = 0;
   	    min=enKisaYolBul(harita,new  int[11][14], iyi_karakter.getY(),iyi_karakter.getX(),getLokasyon().getY(),getLokasyon().getX(), Integer.MAX_VALUE,0);
			
		yol_sayisi = kacYolvar(harita,getLokasyon().getY(),getLokasyon().getX(),iyi_karakter.getY(),iyi_karakter.getX(), new boolean[11][14], yol_sayisi);
                
                int say=0; 
                int[][] matrix=new int[11][14];
                for(int i=0;i<11;i++){
                    for(int j=0;j<14;j++){
                    matrix[i][j]=0;
                    }
                }
                 
               
                for(int i=info.size()-min;i<info.size();i++){
                   
                    matrix[info.get(i).getX()][info.get(i).getY()]=1;
                    if(harita[info.get(i).getX()][info.get(i).getY()]==1){
                    
                    } 
                    say++;
                    if(say==min){
                        
                    break;
           
                    }
                    
                }
                      
                      matrix[iyi_karakter.getY()][iyi_karakter.getX()]=1;  
                   
                      setEnKisa(matrix);
                      hareket(matrix,iyi_karakter);
    }
    
    
 public void hareket(int matrix[][],lokasyon iyi){
 
              //      System.out.println("Min"+(min));
                     int say=0;
                     int bak;
                      if(getName().equals("Kylo Ren")){
                      bak=2;  
                      }else{
                      bak=1;
                      }
                      if(min==1){
                        bak=1;
                      }
                      
                          while(say!=bak){
                       if(min==0){
                      break;
                      }
                              
                            if(getName().equals("Kylo Ren")&& say>2){
                              break;
                              }else if(getName().equals("Stormtrooper")&& say>1){
                              break;
                              }
                              if(matrix[getLokasyon().getY()][getLokasyon().getX()]==1){
                                matrix[getLokasyon().getY()][getLokasyon().getX()]=0;
                                }
                          for(int z=0;z<11;z++){
                        for(int j=0;j<14;j++){
                            if(getName().equals("Kylo Ren")&& say==2){
                              break;
                              }else if(getName().equals("Stormtrooper")&& say==1){
                              break;
                              }
                             if(getLokasyon().getY()+1==z && getLokasyon().getX()==j && matrix[z][j]==1){
                           //System.out.println("Aşağı");
                             
                           setLokasyon(new lokasyon(j,z));
                                 say++;
                                 break;
                             }
                             else if(getLokasyon().getY()-1==z && getLokasyon().getX()==j && matrix[z][j]==1){
                              //System.out.println("Yukarı");
                                 setLokasyon(new lokasyon(j,z));
                                 say++;
                                 break;
                             }
                             else if(getLokasyon().getY()==z && getLokasyon().getX()+1==j && matrix[z][j]==1){
                                //System.out.println("sağa");
                                 setLokasyon(new lokasyon(j,z));
                                 say++;
                                 break;
                             }
                             else if(getLokasyon().getY()==z && getLokasyon().getX()-1==j && matrix[z][j]==1){
                               //  System.out.println("sola");
                                 setLokasyon(new lokasyon(j,z));
                                 say++;
                                 break;
                             }
                       
                      
                            }
                         }
                      }        
                     
 
 
 }   
    
}
