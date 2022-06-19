package locators;

import automation.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class GenericLocators extends BaseClass {
    @FindBy(xpath = "(//span[text()='Most Active'])[1]")
    public WebElement most_active_tab;

    @FindBy(xpath = "//*[@id=\"pills-active\"]/table/tbody/tr[")
    public WebElement before_xpath;

    @FindBy(xpath = "]/td[")
    public WebElement after_xpath;

    public GenericLocators() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver.getWrappedDriver(), 20);
        PageFactory.initElements(factory, this);
    }


}

