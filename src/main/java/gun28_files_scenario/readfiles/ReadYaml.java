package gun28_files_scenario.readfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadYaml {

    @Test
    public void readJson1() throws IOException {
        String yamlPath = "src/main/java/gun28_files_scenario/readfiles/myYaml.yml";
        FileReader file = new FileReader(yamlPath);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        MyPojo myPojo = mapper.readValue(file, MyPojo.class);

        System.out.println("myPojo.getUrl() = " + myPojo.getUrl());
        System.out.println("myPojo.getUsername() = " + myPojo.getUsername());
        System.out.println("myPojo.getPassword() = " + myPojo.getPassword());

    }

    @Test
    public void writeJson1() throws IOException {
        String yamlPath = "src/main/java/gun28_files_scenario/readfiles/myYaml.yml";
        FileReader file = new FileReader(yamlPath);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        MyPojo myPojo = mapper.readValue(file, MyPojo.class);

        System.out.println("myPojo.getUrl() = " + myPojo.getUrl());
        System.out.println("myPojo.getUsername() = " + myPojo.getUsername());
        System.out.println("myPojo.getPassword() = " + myPojo.getPassword());

        myPojo.setPassword("admin123");

        FileWriter writer = new FileWriter(yamlPath);
        mapper.writeValue(writer, myPojo);

    }
}
