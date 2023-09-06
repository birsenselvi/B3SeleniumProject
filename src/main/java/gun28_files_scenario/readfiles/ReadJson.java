package gun28_files_scenario.readfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJson {

    @Test
    public void readJson1() throws IOException {
        String jsonPath = "src/main/java/gun28_files_scenario/readfiles/myJson.json";
        FileReader file = new FileReader(jsonPath);
        ObjectMapper mapper = new ObjectMapper();

        MyPojo myPojo = mapper.readValue(file, MyPojo.class);

        System.out.println("myPojo.getUrl() = " + myPojo.getUrl());
        System.out.println("myPojo.getUsername() = " + myPojo.getUsername());
        System.out.println("myPojo.getPassword() = " + myPojo.getPassword());

    }
}
