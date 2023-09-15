package gun33_cucumber_tags.polimorphism;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        ClassBase cls1 = new Class1();

        ClassBase cls2 = new Class2();

        ((Class1)cls1).methodClass1();
        ((Class2)cls2).methodClass1();


    }

    public static void method(ClassBase b){

    }

    public static void method2(ArrayList<Integer> l){

    }

    public static void method2(List<Integer> l){

    }
}
