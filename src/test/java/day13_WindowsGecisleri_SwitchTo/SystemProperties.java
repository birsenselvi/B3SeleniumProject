package day13_WindowsGecisleri_SwitchTo;

public class SystemProperties {
    public static void main(String[] args) {

        // Sistemin özelliklerini getirir
        System.getProperties().forEach((k,v)-> System.out.println(k+" : " + v));

    }
}
