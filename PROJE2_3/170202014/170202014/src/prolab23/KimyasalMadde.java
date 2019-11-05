
package prolab23;

import java.util.ArrayList;


public class KimyasalMadde {
    private int id;
    private String ad;
    private String ham_adi;
    private ArrayList<hammadde> atom;
    private int aded;
    private int ham_id;
    private int miktar;
    private int alis_maliyeti;
  
    private String uretim_tarihi;
    private int raf_omru;
    public KimyasalMadde() {
    }

    public KimyasalMadde(int id, int ham_id, int miktar, int alis_maliyeti, String uretim_tarihi, int raf_omru) {
        this.id = id;
        this.ham_id = ham_id;
        this.miktar = miktar;
        this.alis_maliyeti = alis_maliyeti;
        this.uretim_tarihi = uretim_tarihi;
        this.raf_omru = raf_omru;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public int getAlis_maliyeti() {
        return alis_maliyeti;
    }

    public void setAlis_maliyeti(int alis_maliyeti) {
        this.alis_maliyeti = alis_maliyeti;
    }

    public String getUretim_tarihi() {
        return uretim_tarihi;
    }

    public void setUretim_tarihi(String uretim_tarihi) {
        this.uretim_tarihi = uretim_tarihi;
    }

    public int getRaf_omru() {
        return raf_omru;
    }

    public void setRaf_omru(int raf_omru) {
        this.raf_omru = raf_omru;
    }

    public KimyasalMadde(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public String getHam_adi() {
        return ham_adi;
    }

    public KimyasalMadde(int id,   int aded, int ham_id) {
        this.id = id;
        this.aded = aded;
        this.ham_id = ham_id;
    }

    public void setHam_adi(String ham_adi) {
        this.ham_adi = ham_adi;
    }

    public int getAded() {
        return aded;
    }

    public void setAded(int aded) {
        this.aded = aded;
    }

    public int getHam_id() {
        return ham_id;
    }

    public void setHam_id(int ham_id) {
        this.ham_id = ham_id;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
    public void AtomEkle(hammadde ham){
        atom.add(ham);
    }
    public ArrayList<hammadde> getAtom() {
        return atom;
    }

    public void setAtom(ArrayList<hammadde> atom) {
        this.atom = atom;
    }
    
}
