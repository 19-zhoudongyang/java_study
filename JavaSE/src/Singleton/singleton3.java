package Singleton;


import java.io.IOException;
import java.util.Properties;

public class singleton3 {
    public static final singleton3 INSTANCE;
    private String info;

    static {
        try {
            Properties properties = new Properties();
            properties.load(singleton3.class.getResourceAsStream("Singleton3.properties"));
            INSTANCE = new singleton3(properties.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private singleton3(String info) {
        this.info = info;
    }
    private singleton3(){}
}
