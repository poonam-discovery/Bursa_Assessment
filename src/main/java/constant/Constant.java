package constant;

public class Constant {

    public static final String CONFIG_FILE = "src/main/config/config.properties";

    public static final String REPORT_LOCATION = System.getProperty("user.dir") + "/Result/Reports";

    public static final String CHROME_DRIVER = System.getProperty("user.dir") + "/ChromeDriver/chromedriver.exe";

    public static final String BEFORE_XPATH = "//*[@id=\"pills-active\"]/table/tbody/tr[";

    public static final String AFTER_XPATH = "]/td[";

    public static final String STOCK_NAME_BEFORE_STRING_XPATH = "//*[@id=\"pills-active\"]/table/tbody/tr[";

    public static final String STOCK_NAME_AFTER_STRING_XPATH = "]/th/div/a";


}
