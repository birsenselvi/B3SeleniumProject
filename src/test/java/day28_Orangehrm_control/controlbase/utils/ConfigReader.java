package day28_Orangehrm_control.controlbase.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {
    private String configFile = "src/main/java/gun28_files_scenario/controlbase/config.yml";
    private ObjectMapper mapper;
    private FileReader file;
    static private Config instance;

    private ConfigReader(){

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

    public static Config getInstance(){
        return instance==null ? new ConfigReader().get() : instance;
    }



}
