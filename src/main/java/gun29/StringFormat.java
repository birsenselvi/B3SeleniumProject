package gun29;

import org.testng.annotations.Test;

import java.text.MessageFormat;

public class StringFormat {

    @Test
    public void stringFormat1(){
        System.out.printf("My name is %s - %d", "Ahmet", 1);
        for (int i = 0; i < 10; i++) {
            System.out.printf("a%10d\n", i);
        }

    }

    @Test
    public void stringFormat2(){
        String myFormat = "My name is %s, %d, %.5f";
        String s = String.format(myFormat, "ahmet", 1, 1.);
        System.out.println(s);
    }

    @Test
    public void stringFormat3(){
        String myFormat = "//div[@id='%s' or @class='%s']";
        String var = "id1";
        String s = String.format(myFormat, var, var);
        System.out.println(s);
    }


    @Test
    public void stringFormat4(){
        // MessageFormat   '   kullanilmaz   \"   kullanilir
        String myFormat = "//div[@id=\"{0}\" or @class=\"{0}\"]";
        String var1 = "id1";
        String var2 = "id2";
        String s = MessageFormat.format(myFormat, var1);
        System.out.println(s);

        String myFormat1 = "//div[@id=\"{1}\" or @class=\"{0}\"]";
        String s1 = MessageFormat.format(myFormat1, var1, var2);
        System.out.println(s1);
    }
}
