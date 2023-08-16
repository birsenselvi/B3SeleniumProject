package gun13;

public class SystemProperties {

    public static void main(String[] args) {
        //System.getProperties().forEach((k,v) -> System.out.println(k + " : " + v));

        System.setProperty("win", "winName");
        System.out.println(System.getProperty("win"));
    }

}
/*
    "key" : "value"
    "key" : "value"
    "key" : "value"
 */