package gun33_cucumber;

import gun31_testNG_cucumber.cucumber._01Definition.Runner1;
import gun32_cucumber.variables.Runner;
import org.testng.annotations.Test;

import java.util.*;

public class ListVsMap {
    int num = 3;

    @Test
    public void listMap(){
        List<String> list = new ArrayList<>(Arrays.asList("Ali", "Deniz", "Ankara"));

        Map<String, String> map = new HashMap<String, String>(){{
            put("name", "Ali");
            put("lastname", "Deniz");
            put("city", "Ankara");
        }};

        System.out.println(list.get(0));
        System.out.println(map.get("name"));

    }


    @Test
    public void testObject(){
        int[] arrInt = {1, 2, 3};
        double[] arrDouble = {1.2, 1.3};
        Class[] arrClass = {ListVsMap.class, Runner.class, Runner1.class};
        String[] arrString = {"a", "b"};

        Object[] arr = {1, "2", new ListVsMap(), Runner.class};

        System.out.println(((ListVsMap)arr[2]).num);

    }

    @Override
    public String toString() {
        return "ListVsMap{" +
                "num=" + num +
                '}';
    }
}
