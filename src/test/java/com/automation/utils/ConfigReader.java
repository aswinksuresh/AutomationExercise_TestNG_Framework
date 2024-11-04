package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties props;
    public static void initConfig(){
        props = new Properties();
        try{
            props.load(new FileInputStream("src/test/resources/config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getConfig(String key){
        return props.getProperty(key);
    }
    public static void setProperty(String key, String value){
        props.setProperty(key,value);
    }
}
