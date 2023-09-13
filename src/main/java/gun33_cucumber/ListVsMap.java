package gun33_cucumber;

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
        Object[] arr = {1, "2", new ListVsMap()};
        System.out.println(((ListVsMap)arr[2]).num);
    }

    @Override
    public String toString() {
        return "ListVsMap{" +
                "num=" + num +
                '}';
    }
}
