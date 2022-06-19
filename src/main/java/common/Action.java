package common;

import automation.testbase.BaseClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Action extends BaseClass {
    JavascriptExecutor js = ((JavascriptExecutor) driver);


    public void doubleClick(WebElement we) {
/*
        listener.addTestStep("Clear the text in the " + we.getText() + " object.");
*/
        try {
            Actions builder = new Actions(driver);
            builder.doubleClick(we).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(WebDriver driver, long timeOut, WebElement element) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void pageLoadTimeOut(WebDriver driver, long timeOut) {
        driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
    }

    public void scrolltoText(WebElement Element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }


}
