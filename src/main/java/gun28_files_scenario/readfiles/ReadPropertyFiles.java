package gun28_files_scenario.readfiles;

import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFiles extends BaseTest {

    @Test
    public void propertyFile1(){
        //System.getProperties().forEach((k,v)-> System.out.println(k + ": " + v));
        Properties properties = new Properties();
        properties.setProperty("url", "https://google.com");
        properties.setProperty("a", "b");

        System.out.println("properties.getProperty(\"url\") = " + properties.getProperty("url"));
        System.out.println("properties.getProperty(\"a\") = " + properties.getProperty("a"));

        properties.forEach((k,v)-> System.out.println(k + ": " + v));
    }



    @Test
    public void testReadPropertyFromFile() throws IOException {
        // ramde bir properties nesnesi olusturulur
        Properties prop = new Properties();

        // FileReader ile kayitli olan ___.properties dosya okunur
        String filePath = "src/main/java/gun28_files_scenario/readfiles/myProp1.properties";
        FileReader file = new FileReader(filePath);

        // okunan dosya prop nesnesine yüklenir
        prop.load(file);


        String url = prop.getProperty("orangehrm.url");
        //System.out.println(url);

        prop.forEach((k,v) -> System.out.println(k + " : " + v));

        driver = Driver.getDriver();
        driver.get(prop.getProperty("orangehrm.url"));
        sleep(3000);
        driver.get(prop.getProperty("demoblaze.url"));
        sleep(3000);
    }

    @Test
    public void testReadWriterPropertyFile() throws IOException {

        Properties prop = new Properties();

        String filePath = "src/main/java/gun28_files_scenario/readfiles/myProp1.properties";
        FileReader file = new FileReader(filePath);

        prop.load(file);

        System.out.println("Property File content");
        prop.forEach((k,v) -> System.out.println(k + " : " + v));

        prop.setProperty("orangehrm.username", "Admin");
        prop.remove("newKey");

        System.out.println("Property File content");
        prop.forEach((k,v) -> System.out.println(k + " : " + v));

        FileWriter writer = new FileWriter(filePath);
        prop.store(writer, "");

    }
}
