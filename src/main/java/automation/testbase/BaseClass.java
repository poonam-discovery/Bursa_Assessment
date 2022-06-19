package automation.testbase;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import common.Action;
import common.chromedriver.ChromeDriver;
import constant.Constant;
import listener.SeleniumListener;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import utility.UtilityClass;


import java.util.concurrent.TimeUnit;


public class BaseClass {

    public static WebDriver webDriver;
    public static EventFiringWebDriver driver;
    public String baseAddress;
    private static String REPORT_SHARE;
    String reportLoc;
    public static ExtentReports extent;
    static DateTime dt = new DateTime();
    static DateTimeFormatter fmt = DateTimeFormat.forPattern("dd_MMM_yyyy_hh_mm_ss");
    public static String dateGenerated = fmt.print(dt);
    public static SeleniumListener listener = new SeleniumListener();


    @BeforeSuite(alwaysRun = true)
    public void InitializeTests(ITestContext testContext) {
        try {
            baseAddress = UtilityClass.fetchPropertyValue("url");

            reportLoc = Constant.REPORT_LOCATION;

            if (!reportLoc.endsWith("/"))
                reportLoc = reportLoc + "/";

            extent = new ExtentReports();
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportLoc + "_AutoRun_"
                    + dateGenerated + "/MainReport" + ".html").viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[]{
                            ViewName.DASHBOARD,
                            ViewName.TEST,
                            ViewName.AUTHOR,
                            ViewName.DEVICE,
                            ViewName.EXCEPTION,
                            ViewName.LOG,
                            ViewName.AUTHOR
                    })
                    .apply();
            reporter.config().setTheme(Theme.DARK);
            extent.attachReporter(reporter);

            System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER);

            extent.setReportUsesManualConfiguration(true);

            ChromeDriver.baseAddress = this.baseAddress;
            webDriver = ChromeDriver.initialize();
            driver = new EventFiringWebDriver(webDriver);
            driver.register(listener);

         /*   listener.addTestSuite(testContext.getCurrentXmlTest().getSuite()
                    .getName(), CommonMethods.fetchPropertyValue("environment"));
*/
            driver.get(UtilityClass.fetchPropertyValue("url"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
