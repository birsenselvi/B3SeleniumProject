package day32.dataTable;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataTablesSteps {
  

    @Given("write the following numbers")
    public void writeTheFollowingNumbers(DataTable table) {
        List<Integer> list = table.asList(Integer.class);
        list.forEach(n -> System.out.println(n));
    }

    @Given("write the following string")
    public void writeTheFollowingString(DataTable table) {
        List<String> list = table.asList();
        list.forEach(s -> System.out.print(s + "\t"));
    }

    @Given("write the following listOfLists")
    public void writeTheFollowingListOfLists(DataTable table) {

        List<List<String>> lists = table.asLists();
        lists.forEach(list->{
            list.forEach(s -> System.out.print(s + "\t"));
            System.out.println();
        });

    }


    @Given("write the following listOfLists as int")
    public void writeTheFollowingListOfListsAsInt(DataTable table) {
        AtomicInteger sum = new AtomicInteger();
        List<List<Integer>> lists = table.asLists(Integer.class);
        lists.forEach(list->{
            list.forEach(s -> {
                System.out.print(s + "\t");
                sum.addAndGet(s);
            });
            System.out.println();
        });
        System.out.println(sum);

    }

    @Given("write the following numbers {int} {int} {int} {int} {int}")
    public void writeTheFollowingNumbers(int arg0, int arg1, int arg2, int arg3, int arg4) {
    }

    @Given("write the following map")
    public void writeTheFollowingMap(DataTable table) {
        Map<String,Integer> map = table.asMap(String.class, Integer.class);
        System.out.println(map.get("Username"));
        System.out.println(map.get("Password"));
        map.forEach((k,v)-> System.out.println(k + " : " + v));

    }

    @Given("write the following maps")
    public void writeTheFollowingMaps(DataTable table) {

        List<Map<String, String>> list = table.asMaps();
        list.forEach(m->{
            m.forEach((k,v)-> System.out.println(k + " : " + v));
        });

    }
}

