package gun22_testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {

    @Test
    public void test1(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    /*
        test methoduna data nasil aktarilir
        1 tanesi DataPovider'dir
     */

    @Test(dataProvider = "data2")
    void test2(int i){
        System.out.println(i);
    }

    /*
        DataProvider'in Onject[][] return etmeli
     */
    @DataProvider
    public Object[][] data2(){
        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }

    @Test(dataProvider = "myData3")
    void test3(String name, int i){
        System.out.println(name + " : " + i);
    }

    @DataProvider(name = "myData3")
    public Object[][] data3(){
        return new Object[][]{
                {"Ali", 1},
                {"Veli", 2},
                {"Deniz", 5}

        };
    }

    @Test(dataProvider = "myData4")
    void test4(Object[] arr){
        System.out.println(arr[0] + " : " + arr[1]);
    }

    @DataProvider(name = "myData4")
    public Object[][] data4(){
        return new Object[][]{
                {"Ali", 1},
                {"Veli", 2},
                {"Deniz", 5}

        };
    }

}
