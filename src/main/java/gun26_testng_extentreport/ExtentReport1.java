package gun26_testng_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReport1 {

    @Test
    public void test1(){

        // bu satir web sayfasi olusturmak icin kullanilir
        ExtentSparkReporter html;

        // Extent report
        ExtentReports report;

        // test olusturulur
        ExtentTest test;

        // html olusturulur
        html = new ExtentSparkReporter("report.html");

        // bir report nesnesi olusturuldu
        report = new ExtentReports();

        // ExtentReport'u html'ye ekleik
        report.attachReporter(html);

        // report icin test create edildi. Name ve description tanimlandi
        test = report.createTest("Test1", "My First Test Report");

        // test icindeki gelismelere gore istenilen log kaydi tutulur
        test.info("My first info comment");
        test.log(Status.WARNING, "My log as Warning with Status");
        test.warning("My log as Warning, without Status");
        test.pass("Test is passed");

        // rapor sonuna eklenecek bilgiler
        report.setSystemInfo("Team", "QA Team");
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Directory", System.getProperty("user.dir"));
        report.setSystemInfo("Date Time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm.ss")));

        // report yazilir ve kapatilir, flush edilir
        report.flush();
    }


    public static void main(String[] args) {

        System.getProperties().forEach(
                (k,v)->{
                    System.out.println(k + " : " + v);
                }
        );
    }
}
