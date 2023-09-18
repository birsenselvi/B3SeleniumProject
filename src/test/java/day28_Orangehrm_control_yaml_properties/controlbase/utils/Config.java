package day28_Orangehrm_control_yaml_properties.controlbase.utils;

import lombok.Data;

@Data
public class Config {
    private String url;
    private String username;
    private String password;
    private String browser;
}
