#include "allegro.h"
#include <stdio.h>

BITMAP *Resim,*Yol1,*Yol2;
int bilinmeyen_sayisi=0,secim=0;
struct anaYol{
    char adi;
    int giriscikis;
    int arabasayisi;
}Anayol[4];// 0 x 1 y 2 z 3 t
struct araYol{
    char adi;
    char girisYonu;
    char cikisYonu;
    int arabasayisi;
}Arayol[5];// 0 A 1 B 2 C 3 D 4 E
void yol1ciz(){
      int  renk = makecol(250, 250,250);
acquire_screen();
 arc(screen, 250, 250, itofix(7), itofix(57), 100, makecol(250, 250, 250));
 arc(screen, 250, 250, itofix(71), itofix(121), 100, makecol(250, 250, 250));
 arc(screen, 250, 250, itofix(135), itofix(185), 100, makecol(250, 250, 250));
 arc(screen, 250, 250, itofix(199), itofix(249), 100, makecol(250, 250, 250));
 arc(screen, 250, 250, itofix(0), itofix(255), 70, makecol(250, 250, 250));

 line(screen, 50, 234, 152,234, renk);//t
 line(screen, 50, 267, 152,267, renk);//t
 line(screen, 350, 234, 452,234, renk);
 line(screen, 350, 267, 452,267, renk);

 line(screen, 234, 50, 234,152, renk);
 line(screen, 267, 50, 267,152, renk);
 line(screen, 234, 350, 234,452, renk);
 line(screen, 267, 350, 267,452, renk);
 textprintf(screen, font, 230, 500, 10, "YOL 1",
               SCREEN_W, SCREEN_H);
release_screen();

 }
void yol2ciz(int deger){
      int  renk = makecol(250, 250,250);
acquire_screen();
  arc(screen, deger+250, 250, itofix(7), itofix(57), 100, makecol(250, 250, 250));
  arc(screen, deger+250, 250, itofix(71), itofix(121), 100, makecol(250, 250, 250));
  arc(screen, deger+250, 250, itofix(135), itofix(185), 100, makecol(250, 250, 250));
  arc(screen, deger+250, 250, itofix(199), itofix(249), 100, makecol(250, 250, 250));
  arc(screen, deger+250, 250, itofix(10), itofix(118), 70, makecol(250, 250, 250));
  arc(screen, deger+250, 250, itofix(139), itofix(244), 70, makecol(250, 250, 250));

  line(screen, deger+50, 234, deger+152,234, renk);
  line(screen, deger+50, 267, deger+152,267, renk);
  line(screen, deger+350, 234, deger+452,234, renk);
  line(screen, deger+350, 267, deger+452,267, renk);
  line(screen, deger+182, 235, deger+318,235, renk);
  line(screen, deger+182, 267, deger+318,267, renk);

  line(screen, deger+234, 50, deger+234,152, renk);
  line(screen, deger+267, 50,  deger+267,152, renk);
  line(screen, deger+234, 350, deger+234,452, renk);
  line(screen, deger+267, 350,  deger+267,452, renk);
  textprintf(screen, font, deger+234, 500, 10, "YOL 2",SCREEN_W, SCREEN_H);
release_screen();
  }
void harfleriyazdir(int secim) {
  acquire_screen();
 textprintf(screen, font,100, 250, 15,"T",SCREEN_W, SCREEN_H);
 textprintf(screen, font,380, 250, 15,"Y",SCREEN_W, SCREEN_H);
 textprintf(screen, font,250, 100, 15,"X",SCREEN_W, SCREEN_H);
 textprintf(screen, font,250, 380, 15,"Z",SCREEN_W, SCREEN_H);
 textprintf(screen, font,300, 185, 15,"A",SCREEN_W, SCREEN_H);
 textprintf(screen, font,310, 300, 15,"B",SCREEN_W, SCREEN_H);
 textprintf(screen, font,185, 300, 15,"C",SCREEN_W, SCREEN_H);
 textprintf(screen, font,185, 185, 15,"D",SCREEN_W, SCREEN_H);

 if(secim==2) textprintf(screen, font,250, 250, 15,"E",SCREEN_W, SCREEN_H);
  release_screen();


}
void anayollariogren(int secim){
    int kontrol,i,say=0;
    for(i=0;i<4;i++){
    printf("\n %c yolu giris mi cikis mi? Giris ise 0 cikis ise 1 yaziniz.",Anayol[i].adi);
    scanf ("%d",&kontrol);
    Anayol[i].giriscikis=kontrol;
    if(kontrol==0)
         say++;
                }

 if(say!=2){
    printf("2 yolu giris 2 yolu cikis olarak secmelisiniz. lutfen tekrar secim yapiniz");
  anayollariogren(secim);
 }
}
void arayollariogren(int secim){
    char giris;
    //A başı
    ayadon:
    printf("\n A yolunun girisi hangisi (X-Y):");
    scanf ("%s",&giris);
    if(giris=='X' || giris=='x'){
        Arayol[0].girisYonu='x';
        Arayol[0].cikisYonu='y';
    }else if(giris=='y' || giris=='Y'){Arayol[0].girisYonu='y';
        Arayol[0].cikisYonu='x'; }else{
            printf("Yanlis giris yaptiniz tekrar deneyiniz");
            goto ayadon;
        }
    //B başı
    byedon:
   printf("\n B yolunun girisi hangisi (Z-Y) :");
    scanf ("%s",&giris);
    if(giris=='y' || giris=='Y'){
        Arayol[1].girisYonu='y';
        Arayol[1].cikisYonu='z';
    }else if(giris=='z' || giris=='Z'){Arayol[1].girisYonu='z';
        Arayol[1].cikisYonu='y'; }else{
            printf("Yanlis giris yaptiniz tekrar deneyiniz");
            goto byedon;
        }
    //C başı
    cyedon:
    printf("\n C yolunun girisi hangisi (Z-T) :");
    scanf ("%s",&giris);
    if(giris=='z' || giris=='Z'){
        Arayol[2].girisYonu='z';
        Arayol[2].cikisYonu='t';
    }else if(giris=='t' || giris=='T'){Arayol[2].girisYonu='t';
        Arayol[2].cikisYonu='z'; }else{
            printf("Yanlis giris yaptiniz tekrar deneyiniz");
            goto cyedon;
        }
    //D başı
    dyedon:
    printf("\n D yolunun girisi hangisi (T-X) :");
    scanf ("%s",&giris);
    if(giris=='t' || giris=='T'){
        Arayol[3].girisYonu='t';
        Arayol[3].cikisYonu='x';
    }else if(giris=='x' || giris=='X'){Arayol[3].girisYonu='x';
        Arayol[3].cikisYonu='t'; }else{
            printf("Yanlis giris yaptiniz tekrar deneyiniz");
            goto dyedon;
        }
    //E başı
   if ( secim==2){
     eyedon:
    printf("\n E yolunun girisi hangisi (T-Y) :" );
    scanf ("%s",&giris);
    if(giris=='t' || giris=='T'){
        Arayol[4].girisYonu='t';
        Arayol[4].cikisYonu='y';
    }else if(giris=='y' || giris=='Y'){Arayol[4].girisYonu='y';
        Arayol[4].cikisYonu='t'; }else{
            printf("Yanlis giris yaptiniz tekrar deneyiniz");
            goto eyedon;
        }

   }




}
void sayilariogren(int secim){
    int i;
    for(i=0;i<4;i++){
printf("%c yolundan gecen araba sayisini yaziniz. Bilmiyorsaniz -1 yaziniz: ",Anayol[i].adi);
scanf("%d",&Anayol[i].arabasayisi);
if(Anayol[i].arabasayisi==-1){
        bilinmeyen_sayisi++;
        }
            }
    for(i=0;i<5;i++){
if (secim!=2){
    if(i==4)
        break;
            }
printf("%c yolundan gecen araba sayisini yaziniz. Bilmiyorsaniz -1 yaziniz: ",Arayol[i].adi);
scanf("%d",&Arayol[i].arabasayisi);
if(Arayol[i].arabasayisi==-1){
        bilinmeyen_sayisi++;
            }
            }



}
void denk(int denklem[][10]){
    int toplam=0,i,j=0,k;
    for(k=0;k<4;k++){
            printf("\n %d. denklem: \n",k+1);
            if(Anayol[j].giriscikis==0){
            if(Anayol[j].arabasayisi==-1){
                printf("\n %c",Anayol[j].adi);
                denklem[k][j]=1;
                                        }else{
                                        toplam=toplam-Anayol[j].arabasayisi;
                                            }
                       }else{
                  if(Anayol[j].arabasayisi==-1){

                printf("\n-%c",Anayol[j].adi);
                denklem[k][j]=-1;


                                        }else{
                                        toplam=toplam+Anayol[j].arabasayisi;

                                            }


                            }
            // x yolu bilinmiyorsa kat sayısını matrise attım biliniyorsa toplam değerine atadım.
            for(i=0;i<5;i++){
                    if(secim==1 & i==4)
                    continue;
                    if(Arayol[i].girisYonu==Anayol[j].adi){
                        if(Arayol[i].arabasayisi==-1){

                denklem[k][4+i]=-1;
                printf("-%c",Arayol[i].adi);
                        }else{
                                        if(Arayol[i].girisYonu)
                                        toplam=toplam+Arayol[i].arabasayisi;
                                            }
                         }
                        }

              // ara yol D
         for(i=0;i<5;i++){
            if(secim==1 & i==4)
                    continue;
         if(Arayol[i].cikisYonu==Anayol[j].adi){
           if(Arayol[i].arabasayisi==-1){
                denklem[k][4+i]=1;
                printf("+%c",Arayol[i].adi);
                                    }else{
                                        toplam=toplam-Arayol[i].arabasayisi;
                                            }
                            }
         }
              // ARA YOL A

                    printf("=%d \n",toplam);

                denklem[k][9]=toplam;
                if(toplam<0){
                    for(i=0;i<10;i++){
                        denklem[k][i]=(-1)*denklem[k][i];
                                        }
                            }
                j++;
                toplam=0;



                    }//birinci for

                            }
void denk5(int denklem[][10]){

        int i,toplam=0;
        printf("5.denklem \n");
        for(i=0;i<4;i++){
                if(Anayol[i].giriscikis==0){
                    if(Anayol[i].arabasayisi==-1){
                        printf("+%c",Anayol[i].adi);
                        denklem[4][i]=1;
                                }else{
                        toplam=toplam+Anayol[i].arabasayisi;
                                    }
                                            }else{

                    if(Anayol[i].arabasayisi==-1){
                        printf("-%c",Anayol[i].adi);
                        denklem[4][i]=-1;
                                }else{
                        toplam=toplam-Anayol[i].arabasayisi;
                                    }

                                                    }



                        }
                        printf("=%d",toplam);
                        if(toplam<0){
                            toplam=(-1)*toplam;
                            for(i=0;i<4;i++)
                            denklem[4][i]=(-1)*denklem[4][i];
                                    }
                          denklem[4][9]=toplam;
}
void matris_yazdir (int matrix[][10],int N){
  for (int i=0;i<5;i++){
    for (int j=0;j<N;j++){
        printf ("%d  ", matrix[i][j] );
    }
    printf("\n");
  }
printf("\n\n\n");
}
void gauss(int matrix[][10],int N){
    printf("\n");
	int i, j, k;
	for(i=0;i<5;i++){

		if(matrix[i][i] == 0){
			j=i+1;
			while(j<5 && matrix[j][i]==0){j++;}
			if(j<5){
				int aux;
				for(k=0;k<N;k++){
					aux = matrix[i][k];
					matrix[i][k] = matrix[j][k];
					matrix[j][k] = aux;

				}
				printf ("%d . satir ile %d . sattir yer degisti...\n",i,j);
                matris_yazdir(matrix,N);
			}
		}
		if(matrix[i][i] != 0){
			for(j=0;j<5;j++){
				if(j!=i){
					int mult = -matrix[j][i]/matrix[i][i];

					for(k=0;k<N;k++){
						matrix[j][k] += mult*matrix[i][k];
					}

				}
			}
			printf("%d.sutundaki degerler 0 landi\n",i);
			matris_yazdir(matrix,N);
		}
	}
}
void denklem_coz(int matrix[][10],int N,char tut[]){
            int i,j;
            for (i=0;i<5; i++ ){
        int sifirsay=0;
    for (j=0;j<N-1;j++){
        if(matrix[i][j]==0){sifirsay++;}
        if(matrix[i][j]==1){printf("+%c",tut[j]);}
        if(matrix[i][j]==-1){printf("-%c",tut[j]);}
    } if(sifirsay!=N-1){printf("= %d \n",matrix[i][N-1]);}
    sifirsay=0;
                    }

                                }

int main()
{
 int secim;
char tut[10], tut_y[bilinmeyen_sayisi+1];
tut[0]='x';
tut[1]='y';
tut[2]='z';
tut[3]='t';
tut[4]='a';
tut[5]='b';
tut[6]='c';
tut[7]='d';
tut[8]='e';
Anayol[0].adi='x';
Anayol[1].adi='y';
Anayol[2].adi='z';
Anayol[3].adi='t';
Arayol[0].adi='a';
Arayol[1].adi='b';
Arayol[2].adi='c';
Arayol[3].adi='d';
Arayol[4].adi='e';
// Allegroyu ilklendir
    allegro_init();
    install_keyboard();
    install_timer();
    srand(time(NULL));
    // ekran çözünürlüğünü olarak ayarla
    set_gfx_mode(GFX_AUTODETECT_WINDOWED, 1080, 720, 0, 0);

 yol1ciz();
 yol2ciz(550);
set_color_depth(8);
Resim = load_bitmap( "resim.bmp", NULL);
acquire_screen();
draw_sprite(screen,Resim,-40,550);
release_screen();
readkey();
 //secim = secimogren();
 while (!key[KEY_ESC]){
clear_keybuf();
acquire_screen();
 if (key[KEY_1]){

    clear(screen);
    secim=1;
    yol1ciz();
    Yol1 = load_bitmap( "yol1.bmp", NULL);
    acquire_screen();
    draw_sprite(screen,Yol1,-20,550);
    release_screen();
}
else if(key[KEY_2]) {

      clear(screen);
        secim=2;
      yol2ciz(0);
      Yol2 = load_bitmap( "yol2.bmp", NULL);

    acquire_screen();
    draw_sprite(screen,Yol2,-20,550);

    release_screen();
}
release_screen();
rest(50);
 }
 harfleriyazdir(secim);
 anayollariogren(secim);
 arayollariogren(secim);
 sayilariogren(secim);

int denklem[5][10];

int i,j;
//denklem matrisinin değerlerini sıfırladım
for(i=0;i<5;i++){
    for(j=0;j<10;j++)
       denklem[i][j]=0;
    }

denk(denklem);
denk5(denklem);
int matris[5][10];
printf("\n");
int k=0,sifir_say=0;
// SIFIRLARI SİLDİRDİĞİMİZ FONKSİYON BAŞI
for(j=0;j<10;j++){

        sifir_say=0;
        for(i=0;i<5;i++){
            if(denklem[i][j]==0)
                    sifir_say++;

                        }


            if(sifir_say<5){
                 for(i=0;i<5;i++){
            if(j!=9)
            tut_y[k]=tut[j];
            matris[i][k]=denklem[i][j];
                      }
                        k++;
                        }
                        }
// SIFIRLARI SİLDİRDİĞİMİZ FONKSİYON SONU
int N=bilinmeyen_sayisi+1;
printf("\n");
for(i=0;i<5;i++){

    for(j=0;j<k;j++)
       printf(" [%d] ",matris[i][j]);
    printf("\n \n");
    }
printf("Denklemler matrise donusturuldu.\n ");

gauss(matris,N);

printf("Matris son hali: \n");
for(i=0;i<k-1;i++)
    printf(" [%c] ",tut_y[i]);
printf("\n");
for(i=0;i<5;i++){

    for(j=0;j<k;j++)
       printf(" [%d] ",matris[i][j]);
    printf("\n \n");
    }
denklem_coz(matris,k,tut_y);
return 0;
}END_OF_MAIN();
