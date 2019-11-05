    public class PaletliRobot extends GezginRobotlar{
        private int palet_sayisi;
        public PaletliRobot(int motor_sayisi, int yük_miktari, String robot_tipi, int gezinme_hızı,int palet_sayisi) {
            super(motor_sayisi, yük_miktari, robot_tipi, gezinme_hızı);
            this.palet_sayisi=palet_sayisi;
        }

        public int getPalet_sayisi() {
            return palet_sayisi;
        }

        public void setPalet_sayisi(int palet_sayisi) {
            this.palet_sayisi = palet_sayisi;
        }
    }