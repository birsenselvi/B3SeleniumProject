package day26_Report_RaporYazma;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*class MyListener implements ITestListener{
    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

}*/
@Listeners()
public class TEstNGReport {
    /**
     *  Menü --> Run -->Edit Configuration
     *  sol taraftn ilgili test classi secilir.
     *  sag tarafta Listener Tabi secilir
     *  Acilan kutuda "reporter" yazilir  Listelenen eklentilerden "eMAilable reporter " secilir. Apply ok
     */
    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test3(){
        Assert.assertEquals(2,2);
    }
}
