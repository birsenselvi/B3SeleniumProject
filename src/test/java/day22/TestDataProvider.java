package day22;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    @Test(dataProvider = "data1")
    public void test2(int i) {
        System.out.println(i);

    }

    /**
     * DataProvider in onject [][] return kabul etmeli
     */


    @DataProvider
    public Object[][] data1() {

        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }
}
