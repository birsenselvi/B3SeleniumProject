package utils;

public class Utils {

    /**
     * java ile bekleme methodu
     * Otomasyonda tercih edilen bekleme degildir.
     * @param milis bekleme süresi milisaniye olarak
     */
    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
