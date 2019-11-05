public class Robot {
    private int motor_sayisi;
    private int yük_miktari;
    private static String robot_tipi;

    public Robot(int motor_sayisi, int yük_miktari, String robot_tipi) {
        this.motor_sayisi = motor_sayisi;
        this.yük_miktari = yük_miktari;
        this.robot_tipi = robot_tipi;
    }

    
    public int getMotor_sayisi() {
        return motor_sayisi;
    }

    public void setMotor_sayisi(int motor_sayisi) {
        this.motor_sayisi = motor_sayisi;
    }

    public int getYük_miktari() {
        return yük_miktari;
    }

    public void setYük_miktari(int yük_miktari) {
        this.yük_miktari = yük_miktari;
    }

    public static String getRobot_tipi() {
        return robot_tipi;
    }

    public void setRobot_tipi(String robot_tipi) {
        this.robot_tipi = robot_tipi;
    }
    
}
