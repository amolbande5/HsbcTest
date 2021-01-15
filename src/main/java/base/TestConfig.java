package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {
    public Properties config = new Properties();
    private FileInputStream fis;

    public TestConfig() {
        try {
            fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
            config.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}