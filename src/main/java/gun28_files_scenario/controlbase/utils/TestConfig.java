package gun28_files_scenario.controlbase.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.FileReader;
import java.io.IOException;

public class TestConfig {
    private String configFile = "src/main/java/gun28_files_scenario/controlbase/config.yml";
    private ObjectMapper mapper;
    private FileReader file;
    private Config instance;
    private TestConfig(){

    }

    private Config get(){
        mapper = new ObjectMapper(new YAMLFactory());
        try {
            file = new FileReader(configFile);
            instance = mapper.readValue(file, Config.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }

    private Config getInstance(){
        return instance==null ? new TestConfig().get() : instance;
    }

    public static Config getConfig(){
        return new TestConfig().getInstance();
    }


}
