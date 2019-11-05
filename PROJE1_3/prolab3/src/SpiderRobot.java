    public class SpiderRobot extends GezginRobotlar{
        private int bacak_sayisi;
        public SpiderRobot(int motor_sayisi, int yük_miktari, String robot_tipi, int gezinme_hızı,int bacak_sayisi) {
            super(motor_sayisi, yük_miktari, robot_tipi, gezinme_hızı);
            this.bacak_sayisi=bacak_sayisi;
        }

        public int getBacak_sayisi() {
            return bacak_sayisi;
        }

        public void setBacak_sayisi(int bacak_sayisi) {
            this.bacak_sayisi = bacak_sayisi;
        }
    }