#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
char giris[10];
char cikis;
int temp,z,k;
int s=0,islem_i=0,Yk=0,Ik=0,kapi_s=0;
struct islem{
    int ns;
    char giriscikis;
    char degisim[10];
    }islem[40];
struct kapi{
         char ad[10];
         int giris_sayisi;
         int giren_deger[10];
         char giren_adi[10];
         char cikan_adi;
         int cikan_deger;
         int gecikme;
            }kapi[20];
void log(char komut[20],char cikti[200]){
            time_t Simdikizaman;
            time(&Simdikizaman);
            struct tm *zaman=localtime(&Simdikizaman);
            FILE *log_dosyasi=fopen("log.txt","a");
            fprintf(log_dosyasi,"\n%d/%d/%d %d:%d:%d    %s      %s",zaman->tm_mday,zaman->tm_mon +1,zaman->tm_year +1900,zaman->tm_hour,zaman->tm_min,zaman->tm_sec,komut,cikti);
            fclose(log_dosyasi);
                                        }
int AND(int kapi_i){
        int say=0;
        for(int i=0;i<kapi[kapi_i].giris_sayisi;i++){
            if(kapi[kapi_i].giren_deger[i]==1)
                    say++;
        }
        if(say==kapi[kapi_i].giris_sayisi)
            return 1;
        return 0;
                    }
int NOR(int kapi_i){
        int say=0;
        for(int i=0;i<kapi[kapi_i].giris_sayisi;i++){
            if(kapi[kapi_i].giren_deger[i]==0)
                    say++;
            }
        if(say==kapi[kapi_i].giris_sayisi)
            return 1;
        return 0;
                    }
int OR(int kapi_i){
        int say=0;
        for(int i=0;i<kapi[kapi_i].giris_sayisi;i++){
            if(kapi[kapi_i].giren_deger[i]==0)
                    say++;
            }
        if(say==kapi[kapi_i].giris_sayisi)
            return 0;
        return 1;
                    }
int NAND(int kapi_i){
        int say=0;
        for(int i=0;i<kapi[kapi_i].giris_sayisi;i++){
            if(kapi[kapi_i].giren_deger[i]==1)
                    say++;
        }
        if(say==kapi[kapi_i].giris_sayisi)
            return 0;
        return 1;
                    }
int NOT(int kapi_i){
        if(kapi[kapi_i].giren_deger[0]==0)
            return 1;

        return 0;
                    }
int XOR(int kapi_i){
        int sifir_say=0,bir_say=0;
        for(int i=0;i<kapi[kapi_i].giris_sayisi;i++){
            if(kapi[kapi_i].giren_deger[i]==0)
                    sifir_say++;

            if(kapi[kapi_i].giren_deger[i]==1)
                    bir_say++;
            }
        if(sifir_say==kapi[kapi_i].giris_sayisi || bir_say==kapi[kapi_i].giris_sayisi)
           return 0;

        return 1;
                    }
int kapi_sonuc(int kapi_i){
        int sonuc;
        if(strcmp(kapi[kapi_i].ad,"AND")==0){
        sonuc=AND(kapi_i);
        }else
        if(strcmp(kapi[kapi_i].ad,"OR")==0){
        sonuc=OR(kapi_i);
        }else
        if(strcmp(kapi[kapi_i].ad,"NOR")==0){
        sonuc=NOR(kapi_i);
        }else
        if(strcmp(kapi[kapi_i].ad,"NAND")==0){
        sonuc=NAND(kapi_i);
        }else
        if(strcmp(kapi[kapi_i].ad,"NOT")==0){
        sonuc=NOT(kapi_i);
        }else
        if(strcmp(kapi[kapi_i].ad,"XOR")==0){
        sonuc=XOR(kapi_i);
        }
        return sonuc;
                }
void baskadosya_ekle(char baskadosya[10]){
     FILE *dosya=fopen(baskadosya,"r");
        if(dosya==NULL){
            printf("\n baskadosya'ya erisilemiyor..");
            return;
                    }
        char c,oku[100][20];
        int i=0,t,j=0;
    while (!feof(dosya)){
            fscanf(dosya,"%s",&oku[i]);
            i++;
                        }
        fclose(dosya);
                i=0;
                if(strcmp(oku[i],".giris")==0){
                    i++;
                    j=strlen(giris);
                    while(oku[i][0]!='.'){
                    if(oku[i][0]=='#')
                        break;
                   int sayac=0;
                    for(int k=0;k<j;k++)
                        if(giris[k]==oku[i][0]){
                            sayac++;
                            continue;
                            }
                    if(sayac==0){
                            giris[j]=oku[i][0];
                            j++;
                            }
                   i++;
                                        }
                                    }
                 if(oku[i][0]=='#'){
                    while(oku[i][0]!='.')
                        i++;
                                    }
                 if(strcmp(oku[i],".cikis")==0){
                    i++;
                    while(oku[i][0]!='.'){
                    if(oku[i][0]=='#')
                        break;
                    i++;
                                        }
                                    }

                   if(oku[i][0]=='#'){
                    while(oku[i][0]!='.')
                        i++;
                                    }
                    j=kapi_s;
                  if(strcmp(oku[i],".kapi")==0){
                    i++;
                    while(strcmp(oku[i],".son")!=0){
                    if(strcmp(oku[i],".kapi")==0)
                    i++;
                    strcpy(kapi[j].ad,oku[i]);i++;
                    kapi[j].giris_sayisi = atoi(oku[i]);i++;
                    kapi[j].cikan_adi=oku[i][0];i++;
                    for(int k=0;k<kapi[j].giris_sayisi;k++){
                    kapi[j].giren_adi[k]=oku[i][0];i++;                               }
                    kapi[j].gecikme = atoi(oku[i]);i++;
                     j++; kapi_s++;
                    if(oku[i][0]=='#'){
                    while(oku[i][0]!='.')
                        i++;
                                    }

                                        }
                                    }

    }
void Y(char x[20]){

        char girilen_karakterler[20];
        k=0;
        girilen_karakterler[0]='\0';
        for(z=1;z<strlen(x);z++){    //Girilen karakterler arasindaki bosluklari siliyoruz.
                    if(x[z]==' ')
                        continue;
                    girilen_karakterler[k]=x[z];    //Girilen karakterleri konsoldan okunan string dizisi icerisinden cekiyoruz.
                    k++;
                }
                girilen_karakterler[k]='\0';

        FILE *dosya=fopen(girilen_karakterler,"r");

        if(dosya==NULL){
            printf("\n Dosya'ya erisilemiyor..\n");
            char cikti[100];
            strcat(cikti,girilen_karakterler);
            strcat(cikti," bulunamadi!");
             log(x,cikti);
                return;
                    }else{
            char cikti[100];
            strcat(cikti,girilen_karakterler);
            strcat(cikti," yuklendi..");
             log(x,cikti);
                            }

        char oku[100][20]; // Tüm dosyayi okur. 100 kelimeye kadar.
        int i=0,t,j=0;
    while (!feof(dosya)){    // Dosyanin sonuna gelene kadar tum icerigi oku ve degerlere ata
            fscanf(dosya,"%s",&oku[i]);
            if(strcmp(oku[i],".kapi")==0) //Kapilari Say
            kapi_s++;
            i++;
                        }
        fclose(dosya); //Okuma bitince dosyayi kapatiyoruz
                char baska_dosya[10];
                i=0;
                if(strcmp(oku[i],".include")==0){
                i++;
                strcpy(baska_dosya,oku[i]);
                i++;
                }
                    if(oku[i][0]=='#'){
                    while(oku[i][0]!='.')   //Yorum satirina denk gelirsek yorum satiri bitene kadarki olan hersey gormezden gelinir.
                        i++;
                                    }
                if(strcmp(oku[i],".giris")==0){ //.giris'i gordugu anda giris bitene kadar giris degerlerini alir.
                    i++;
                    while(oku[i][0]!='.'){  //Bir sonraki satira gecip farkli komut alana kadar alttaki islemleri yapar
                    if(oku[i][0]=='#')      //Yorum satirini gordugu anda, satir sonuna gelinmis gibi davranip alt satira gecer.
                        break;
                    giris[j]=oku[i][0];
                    i++; j++;

                                        }

                                    }// Girislerin alimi tamamlandi.

                 if(oku[i][0]=='#'){
                    while(oku[i][0]!='.')
                        i++;
                                    }
                 if(strcmp(oku[i],".cikis")==0){
                    i++;
                    while(oku[i][0]!='.'){
                    if(oku[i][0]=='#')
                        break;
                    cikis=oku[i][0];
                    i++;
                                        }
                                    }

                  // cikisi da aldik.
                   if(oku[i][0]=='#'){
                    while(oku[i][0]!='.')
                        i++;
                                    }
                //Kapilari almaya basliyoruz.
                    j=0;
                  if(strcmp(oku[i],".kapi")==0){
                    i++;
                    while(strcmp(oku[i],".son")!=0){
                    if(strcmp(oku[i],".kapi")==0)
                    i++;
                    strcpy(kapi[j].ad,oku[i]);i++;
                    kapi[j].giris_sayisi = atoi(oku[i]);i++;
                    kapi[j].cikan_adi=oku[i][0];i++;
                    for(int k=0;k<kapi[j].giris_sayisi;k++){
                    kapi[j].giren_adi[k]=oku[i][0];i++;
                                                    }
                    kapi[j].gecikme = atoi(oku[i]);i++;
                     j++;
                    if(oku[i][0]=='#'){
                    while(oku[i][0]!='.')
                        i++;
                                    }

                                        }
                                    }

            //BASKA DOSYA EKLEME BASI....
            if(baska_dosya[0]!='\0')
                baskadosya_ekle(baska_dosya);
            printf("islem tamamlandi...");
}
int intyap(char x){
        if(x=='0')
            return 0;
        if(x=='1')
            return 1;
                    }
void I(char x[20]){
        char girilen_karakterler[20],cikti[100];;
        k=0;
        for(z=2;z<strlen(x);z++){
                    if(x[z]==' ')
                        continue;
                    girilen_karakterler[k]=x[z];
                    k++;
                }
                girilen_karakterler[k]='\0';

        FILE *dosya=fopen(girilen_karakterler,"r");
        if(dosya==NULL){
            printf("Dosya'ya erisilemiyor..");
            strcat(cikti,girilen_karakterler);
            strcat(cikti," bulunamadi!");
             log(x,cikti);
                    }else{
             log(x,"Ilk degerler yuklendi.");
             printf("Degerler atandi.");
                            }
                        //Ustteki komutlar standart dosya acma islemlerimiz.
        char c,oku[100];
        int i=0,t,j;
        while((c=fgetc(dosya))!=EOF){
            if(c=='\n' || c=='\t')// Tab bosluklari (\t) ve alt satirlar(\n) gormezden gelindi.
            continue;
            oku[i]=c;
            printf("\n %c",c);
            i++;
                }
            t=i;
                for(i=0;i<t;i++){
                    for( j=0;j<kapi_s;j++){
                         if(kapi[j].cikan_adi==oku[i]){
                            kapi[j].cikan_deger=intyap(oku[i+1]);
                         }
                         for(int k=0;k<kapi[j].giris_sayisi;k++){
                         if(kapi[j].giren_adi[k]==oku[i]){
                            kapi[j].giren_deger[k]=intyap(oku[i+1]);
                            }
                         }
                    }
                i++;
                }
        fclose(dosya);
}
void islem_tekar(int indis){
        s=s+kapi[indis].gecikme;
                int eski_deger=kapi[indis].cikan_deger;
                kapi[indis].cikan_deger=kapi_sonuc(indis);
                if(eski_deger!=kapi[indis].cikan_deger){
            islem[islem_i].giriscikis=kapi[indis].cikan_adi;
                if(kapi[indis].cikan_deger==1){
                strcpy(islem[islem_i].degisim,"0->1");
                }else{
                strcpy(islem[islem_i].degisim,"1->0");
                }
            islem[islem_i].ns=s;
            islem_i++;
            }
                    }
void hesapla(char girilen){
        int etki=0,indis[5];

        for(int i=0;i<kapi_s;i++){
            for(int j=0;j<kapi[i].giris_sayisi;j++){
                if(kapi[i].giren_adi[j]==girilen){
                        indis[etki]=i; etki++;
                        break;
                        }
                }
                                }
            // Yukarida degisen girisin kac kapiyi etkiledine baktık.
        bas:
        if(etki==1){
            int i=0;
            char sonraki;
            while(1){
            islem_tekar(indis[i]);
            sonraki=kapi[indis[i]].cikan_adi;
            i++;
            if(i==etki)
                break;

            }
            if(sonraki==cikis)
                return;
            etki=0;
            for(int i=0;i<kapi_s;i++){
                for(int j=0;j<kapi[i].giris_sayisi;j++){
                if(kapi[i].giren_adi[j]==sonraki){
                        indis[etki]=i; etki++;
                        break;
                        }
                    }
                }
            goto bas;
            }else
        if(etki==2){
                char sonraki;
                int oncelikli,ikinci,i=0,sonraki_i;
          if(kapi[indis[i]].gecikme!=kapi[indis[i+1]].gecikme){
                if(kapi[indis[i]].gecikme>kapi[indis[i+1]].gecikme){
                    oncelikli=indis[i+1];
                    ikinci=indis[i];
                }else{
                    oncelikli=indis[i];
                    ikinci=indis[i+1];
                }
            islem_tekar(oncelikli);
            sonraki=kapi[oncelikli].cikan_adi;
            for(int i=0;i<kapi_s;i++){
                for(int j=0;j<kapi[i].giris_sayisi;j++){
                if(kapi[i].giren_adi[j]==sonraki){
                        sonraki_i=i;
                        break;
                        }
                    }
                }
             if(kapi[ikinci].gecikme>s+kapi[sonraki_i].gecikme){
                islem_tekar(sonraki_i);
                islem_tekar(ikinci);
                sonraki=kapi[ikinci].cikan_adi;
                for(int i=0;i<kapi_s;i++){
                for(int j=0;j<kapi[i].giris_sayisi;j++){
                if(kapi[i].giren_adi[j]==sonraki){
                        sonraki_i=i;
                        break;
                        }
                    }
                }
                islem_tekar(sonraki_i);
             }else{
                islem_tekar(ikinci);
                islem_tekar(sonraki_i);
                sonraki=kapi[sonraki_i].cikan_adi;
                for(int i=0;i<kapi_s;i++){
                for(int j=0;j<kapi[i].giris_sayisi;j++){
                if(kapi[i].giren_adi[j]==sonraki){
                        ikinci=i;
                        break;
                        }
                }
                }
                }
            }else{
            islem_tekar(indis[i]);
            s=s-kapi[i].gecikme;
            islem_tekar(indis[i+1]);
            sonraki=kapi[indis[i]].cikan_adi;
            for(int i=0;i<kapi_s;i++){
                for(int j=0;j<kapi[i].giris_sayisi;j++){
                if(kapi[i].giren_adi[j]==sonraki){
                        sonraki_i=i;
                        break;
                        }
                    }
                }
            islem_tekar(sonraki_i);

            }
        }
}
void H(char x[20]){
    char girilen =x[2];
    char girilenfix[2];
    int baskakontrol = 0;
    girilenfix[0]=girilen;
    girilenfix[1]='\0';
    int kontrol=0;
    char cikti[100];
    cikti[0] = '\0';
            for(k=0;k<strlen(giris);k++){
              if(girilen==giris[k])
               kontrol++;
            }
            if(kontrol==0){
                 printf("%c ana giris degil!! Sadece ana giris yazabilirsiniz..\n",girilen);
            strcat(cikti,girilenfix);
            strcat(cikti," ana giris degil!");
            log(x,cikti);
                return;
                }
             for(k=0;k<kapi_s;k++){

        for(int i=0;i<kapi[k].giris_sayisi;i++){
            if(kapi[k].giren_adi[i]==girilen){
                if(kapi[k].giren_deger[i]==1){
                printf("%c girisinin degeri zaten 1. degistirilmedi!\n",kapi[k].giren_adi[i]);
                strcat(cikti,girilenfix);
                strcat(cikti," ayni kaldi.");
                baskakontrol = 1;
                log(x,cikti);
                    break;
                }else
                    if(kapi[k].giren_deger[i]==0 && baskakontrol !=1){
                    kapi[k].giren_deger[i]=1;
                    islem[islem_i].giriscikis=kapi[k].giren_adi[i];
                    strcpy(islem[islem_i].degisim,"0->1");
                    islem[islem_i].ns=s;
                     islem_i++;
                    strcat(cikti,girilenfix);
                    strcat(cikti," girisi birlendi");
                    log(x,cikti);
                    hesapla(girilen);
                    return;
                        }
                }
            }
    }
}
void L(char x[20]){
    char girilen =x[2];
    char girilenfix[2];
    int baskakontrol = 0;
    girilenfix[0]=girilen;
    girilenfix[1]='\0';
    int kontrol=0;
    char cikti[100];
    cikti[0] = '\0';
            for(k=0;k<strlen(giris);k++){
              if(girilen==giris[k])
               kontrol++;
            }
            if(kontrol==0){
                 printf("%c ana giris degil!! Sadece ana giris yazabilirsiniz..\n",girilen);
            strcat(cikti,girilenfix);
            strcat(cikti," ana giris degil!");
            log(x,cikti);
                return;
                }
             for(k=0;k<kapi_s;k++){

        for(int i=0;i<kapi[k].giris_sayisi;i++){
            if(kapi[k].giren_adi[i]==girilen){
                if(kapi[k].giren_deger[i]==0){
                    printf("%c girisinin degeri zaten 0. degistirilmedi!\n",kapi[k].giren_adi[i]);
                strcat(cikti,girilenfix);
                strcat(cikti," ayni kaldi.");
                log(x,cikti);
                baskakontrol=1;
                    break;
                }else
                    if(kapi[k].giren_deger[i]==1 && baskakontrol !=1){
                    kapi[k].giren_deger[i]=0;
                    islem[islem_i].giriscikis=kapi[k].giren_adi[i];
                    strcpy(islem[islem_i].degisim,"1->0");
                    islem[islem_i].ns=s;
                     islem_i++;
                    strcat(cikti,girilenfix);
                    strcat(cikti," girisi sifirlandi");
                    log(x,cikti);
                    hesapla(girilen);
                    return;
                        }
                }
            }

    }
}
void G(char girilen[20]){
            time_t Simdikizaman;
            time(&Simdikizaman);
            struct tm *zaman=localtime(&Simdikizaman);
    if(girilen[1]=='*'){
        char yazilan[20];
        int j,say,z=0;

            FILE *log_dosyasi=fopen("log.txt","a");
        fprintf(log_dosyasi,"\n%d/%d/%d %d:%d:%d    G*",zaman->tm_mday,zaman->tm_mon +1,zaman->tm_year +1900,zaman->tm_hour,zaman->tm_min,zaman->tm_sec);
            fclose(log_dosyasi);
        for(k=0;k<kapi_s;k++){
            for(int i=0;i<kapi[k].giris_sayisi;i++){
                j=0,say=0;
                while(j<z){
                if(kapi[k].giren_adi[i]==yazilan[j])
                say++;
                  j++;
                }
                if(say==0){
                printf("%c = %d \n",kapi[k].giren_adi[i],kapi[k].giren_deger[i]);
                FILE *log_dosyasi=fopen("log.txt","a");
                fprintf(log_dosyasi," %c=%d ",kapi[k].giren_adi[i],kapi[k].giren_deger[i]);
                fclose(log_dosyasi);
                yazilan[z]=kapi[k].giren_adi[i];
                z++;
                }
            }//Kapilara giren degerleri yazdırdık.
             j=0;say=0;
                while(j<z){
                if(kapi[k].cikan_adi==yazilan[j])
                    say++;
                    j++;
                }
                if(say==0){
                printf("%c = %d \n",kapi[k].cikan_adi,kapi[k].cikan_deger);
                FILE *log_dosyasi=fopen("log.txt","a");
                fprintf(log_dosyasi," %c=%d ",kapi[k].cikan_adi,kapi[k].cikan_deger);
                fclose(log_dosyasi);
                yazilan[z]=kapi[k].cikan_adi;
                z++;
                }


        }

    }else{
        int m=0;
        FILE *log_dosyasi=fopen("log.txt","a");
        fprintf(log_dosyasi,"\n%d/%d/%d %d:%d:%d    G",zaman->tm_mday,zaman->tm_mon +1,zaman->tm_year +1900,zaman->tm_hour,zaman->tm_min,zaman->tm_sec);
        fclose(log_dosyasi);
        for(k=0;k<kapi_s;k++){
                if(m>0)
                break;
                for(int i=0;i<kapi[k].giris_sayisi;i++){
                if(girilen[2]==kapi[k].giren_adi[i]){
                    FILE *log_dosyasi=fopen("log.txt","a");
                    fprintf(log_dosyasi," %c=%d ",kapi[k].giren_adi[i],kapi[k].giren_deger[i]);
                    fclose(log_dosyasi);
                    printf("%c. degeri: %d\n",kapi[k].giren_adi[i],kapi[k].giren_deger[i]);
                    m++;
                    break;
                    }
                }
                if(girilen[2]==kapi[k].cikan_adi){
                    printf("%c. degeri: %d\n",kapi[k].cikan_adi,kapi[k].cikan_deger);
                    FILE *log_dosyasi=fopen("log.txt","a");
                    fprintf(log_dosyasi," %c=%d ",kapi[k].cikan_adi,kapi[k].cikan_deger);
                    fclose(log_dosyasi);
                    break;
        }


    }
}
}
void S(char x[20]){
            time_t Simdikizaman;
            time(&Simdikizaman);
            struct tm *zaman=localtime(&Simdikizaman);
            FILE *log_dosyasi=fopen("log.txt","a");
        fprintf(log_dosyasi,"\n%d/%d/%d %d:%d:%d    %c",zaman->tm_mday,zaman->tm_mon +1,zaman->tm_year +1900,zaman->tm_hour,zaman->tm_min,zaman->tm_sec,x[0]);
    for(int i=0;i<islem_i;i++){
        printf("%c %s  %d \n",islem[i].giriscikis,islem[i].degisim,islem[i].ns);
        fprintf(log_dosyasi,"\n                            %d.ns:%c %s",islem[i].ns,islem[i].giriscikis,islem[i].degisim);
        }
        fclose(log_dosyasi);
       }
void A(){
        for(int i=0;i<kapi_s;i++){
               printf("Kapi adi: %s \n",kapi[i].ad);
               printf("Giris sayisi: %d \n",kapi[i].giris_sayisi);
               for(int j=0;j<kapi[i].giris_sayisi;j++)
                printf("Giris %d : %c \n",j+1,kapi[i].giren_adi[j]);
               printf("Cikis: %c \n",kapi[i].cikan_adi);
               printf("---------------------- \n");
        }
        }
void HELP(){
            printf("komut                                    icrasi                                   \n");
            printf("..................................................................................\n");
            printf("Y <devre.txt>          | \"devre.txt\" dosyasindan devreyi yukler.                \n");
            printf("I <deger.txt>          | \"deger.txt\" icindeki degerlerlerle devre ilklendirilir.\n");
            printf("H <giris ucundan biri> |            ilgili uc u lojik-1 yapar                     \n");
            printf("L <giris ucundan biri> |            ilgili uc n lojik-0 yapar                     \n");
            printf("G <giris ucundan biri> | ilgili uc un seviyesini (0 veya 1) konsolda gosterir     \n");
            printf("G*                     | tum uclarin seviyesini (0 veya 1) konsolda gosterir      \n");
            printf("A                      |            tum kapilari gosterir                         \n");
            printf("C                      |            benzetimden cikis yapar                       \n");


            }
void ara(char x[20]){
        if(strcmp(x,"help")==0 ||strcmp(x,"HELP")==0){
            HELP();
                    }
        if(x[0]=='Y' || x[0]=='y'){
                Yk++;  Y(x);
                        }

        if(x[0]=='I' || x[0]=='i'){
            if(Yk!=0){
                Ik++;   I(x);
                }else{
                printf("Once Y komutunu kullanmalisiniz..\n");
                }

                        }

        if(x[0]=='H' || x[0]=='h'){
            if(Ik!=0){

                k=0;
                if(x[1]!=' '){
                    printf("H dan sonra bosluk birakmak zorundasiniz..\n");
                    return;
                    }
                if(strlen(x)>3){
                    printf("Sadece bir degeri degistirebilirsiniz!!\n");
                    return;
                    }
                    H(x);

                }else{
                    printf("Once Y ve I komutlarini kullanmalisiniz!!\n");
                    return;
                    }
            }
        if(x[0]=='L' || x[0]=='l'){
                 if(Ik!=0){
                k=0;
                if(x[1]!=' '){
                    printf("L dan sonra bosluk birakmak zorundasiniz..\n");
                    return;
                    }
                if(strlen(x)>3){
                    printf("Sadece bir degeri degistirebilirsiniz!!\n");
                    return;
                    }
                  L(x);
                    }else{
                    printf("Once Y ve I komutlarini kullanmalisiniz!!\n");
                    }
                }
        if(x[0]=='G' || x[0]=='g'){
                if(strlen(x)>3){
                    printf("Yanlis giris yaptınız tekrar deneyiniz.");
                    return;
                        }else
                        G(x);
        }
        if(x[0]=='A' || x[0]=='a'){
        A();
        }
        if(x[0]=='S' || x[0]=='s'){
        S(x);
        }
        if(x[0]=='C' || x[0]=='c'){
        log(x   ,"Cikis yapildi.");

        }

                printf("\n");
        }
void K(char x[20]){
         char girilen_karakterler[20];
        k=0;
        for(z=1;z<strlen(x);z++){    //Girilen karakterler arasindaki bosluklari siliyoruz.
                    if(x[z]==' ')
                        continue;
                    girilen_karakterler[k]=x[z];    //Girilen karakterleri konsoldan okunan string dizisi icerisinden cekiyoruz.
                    k++;
                }
                girilen_karakterler[k]='\0';

        FILE *dosya=fopen(girilen_karakterler,"r");

        if(dosya==NULL){
            printf("\n Dosya'ya erisilemiyor..\n");
            char cikti[100];
            strcat(cikti,girilen_karakterler);
            strcat(cikti," bulunamadi!");
             log(x,cikti);
                return;
                    }else{
            char cikti[100];
            strcat(cikti,girilen_karakterler);
            strcat(cikti," yuklendi..");
             log(x,cikti);
                            }

        char oku[100][20];
        int i=0,t,j=0;
    while (!feof(dosya)){
            fscanf(dosya,"%s",&oku[i]);
            i++;
                    }
            oku[i][0]='\0';
        fclose(dosya);
        i=0;
        char xx[20];
    while(oku[i][0]!='\0'){
        if(oku[i][0]=='Y' || oku[i][0]=='y'){
            strcpy(xx,oku[i]);
            strcat(xx," ");
            strcat(xx,oku[i+1]);
            printf("%s \n",xx);
            ara(xx);
            i+=2;
        }
        if(oku[i][0]=='I' || oku[i][0]=='i'){
            strcpy(xx,oku[i]);
            strcat(xx," ");
            strcat(xx,oku[i+1]);
            printf("%s \n",xx);
            ara(xx);
            i+=2;
        }
        if(oku[i][0]=='H' || oku[i][0]=='h'){
            strcpy(xx,oku[i]);
            strcat(xx," ");
            strcat(xx,oku[i+1]);
            printf("%s \n",xx);
            ara(xx);
            i+=2;
        }
        if(oku[i][0]=='L' || oku[i][0]=='l'){
            strcpy(xx,oku[i]);
            strcat(xx," ");
            strcat(xx,oku[i+1]);
            printf("%s \n",xx);
            ara(xx);
            i+=2;
        }
        if(oku[i][0]=='S' || oku[i][0]=='s'){
            strcpy(xx,oku[i]);
            printf("%s \n",xx);
            ara(xx);
            i++;
        }
        if(oku[i][0]=='G' || oku[i][0]=='g'){
            if(oku[i][1]=='*'){
            strcpy(xx,oku[i]);
            ara(xx);
            i++;
            }else{
            strcpy(xx,oku[i]);
            strcat(xx," ");
            strcat(xx,oku[i+1]);
            printf("%s \n",xx);
            ara(xx);
            i+=2;
            }
        }

        if(oku[i][0]=='C' || oku[i][0]=='c'){
            strcpy(xx,oku[i]);
            printf("%s\n",xx);
            ara(xx);
            i++;
        }else{
       i++;
        }
      }
        }
int main(){

    char x[20];
    while(x[0]!='C' && x[0]!='c'){
    printf(">");
    gets(x);
    if(x[0]=='K' || x[0]=='k'){
                 K(x);

        }else{
    ara(x);
            }
    }

    return 0;
}
