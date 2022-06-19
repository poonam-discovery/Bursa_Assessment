package common.chromedriver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public final class ChromeDriver {

    private static WebDriver instance;
    private static String driverLocation = System.getProperty("user.dir") + "/chromeDriver/chromedriver.exe";
    private static String chromeDriverProperty = "webdriver.chrome.driver";
    public static String baseAddress = "";
    public static Label statusLabel;

    public static String getBaseAddress() {
        return ChromeDriver.baseAddress;
    }

    public static WebDriver getDriver() {
        return instance;
    }

    public static String getDriverLocation() {
        return driverLocation;
    }

    public static WebDriver initialize() {
        System.out.println("***************************************   ChromeDriver Initializing   ******************************************");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        ChromeOptions options;

        options = DriverOptions.windowsDriverOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        instance = new org.openqa.selenium.chrome.ChromeDriver(capabilities);
        Capabilities cap = ((RemoteWebDriver) instance).getCapabilities();
        String browsername = cap.getBrowserName();
        String browserVersion = cap.getVersion();
        System.out.println("****************************************************\nUsing " + browsername + ": Version " + browserVersion);
        instance.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        instance.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        instance.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        instance.manage().window().maximize();
        return instance;
    }

    public static class DriverOptions {
        public static ChromeOptions windowsDriverOptions() {
            System.setProperty(chromeDriverProperty, driverLocation);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("window-size=1400,800");
            return options;
        }
    }
}




