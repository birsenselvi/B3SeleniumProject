package gun32_cucumber.datatables;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataTablesSteps {
    @Given("write the following numbers {int}, {int}, {int}, {int}, {int}")
    public void writeTheFollowingNumbers(int arg0, int arg1, int arg2, int arg3, int arg4) {

    }

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
        lists.forEach(list -> {
            list.forEach(s -> System.out.print(s + "\t"));
            System.out.println();
        });

    }


    @Given("write the following listOfLists as int")
    public void writeTheFollowingListOfListsAsInt(DataTable table) {
        AtomicInteger sum = new AtomicInteger();
        List<List<Integer>> lists = table.asLists(Integer.class);
        lists.forEach(list -> {
            list.forEach(s -> {
                System.out.print(s + "\t");
                sum.addAndGet(s);
            });
            System.out.println();
        });
        System.out.println(sum);

    }


    @Given("write the following as map")
    public void writeTheFollowingMap(DataTable table) {
        Map<String, String> map = table.asMap();

        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        System.out.println(map.get("firstname"));
        System.out.println(map.get("lastname"));
        System.out.println();

        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }


    @Given("write the following numbers as map")
    public void writeTheFollowingNumbersAsMap(DataTable table) {
        Map<Integer, Double> map = table.asMap(Integer.class, Double.class);
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    @Given("write the following maps")
    public void writeTheFollowingMaps(DataTable table) {
        List<Map<String, String>> list = table.asMaps();

        list.forEach(m -> {
                    m.forEach((k, v) -> System.out.println(k + " : " + v));
                    System.out.println();
                }
        );
    }
}
