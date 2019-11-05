    public class TekerlekliRobot extends GezginRobotlar{
    
    private int teker_sayisi;

    public TekerlekliRobot(int motor_sayisi, int yük_miktari, String robot_tipi, int gezinme_hizi,int teker_sayisi) {
        super(motor_sayisi, yük_miktari, robot_tipi, gezinme_hizi);
        this.teker_sayisi=teker_sayisi;
    }

        public int getTeker_sayisi() {
            return teker_sayisi;
        }

        public void setTeker_sayisi(int teker_sayisi) {
            this.teker_sayisi = teker_sayisi;
        }
    }