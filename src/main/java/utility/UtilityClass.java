package utility;

import constant.Constant;

import java.io.FileInputStream;
import java.util.Properties;

public class UtilityClass {

    //Fetch value from the property file
    public static String fetchPropertyValue(String key) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(Constant.CONFIG_FILE);
            Properties property = new Properties();
            property.load(file);
            return property.getProperty(key);

        } catch (Exception e) {
            e.printStackTrace();
            return "Null Value from property";
        }

    }
}
