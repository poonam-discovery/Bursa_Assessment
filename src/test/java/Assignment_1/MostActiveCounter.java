package Assignment_1;

import automation.testbase.BaseClass;
import common.Action;
import constant.Constant;
import locators.GenericLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class MostActiveCounter extends BaseClass {
    GenericLocators genericLocators;
    Action action;
    ArrayList<String> sortedList;

    @BeforeTest(groups = {"enquiresFlow"})
    public void setUp() {
        try {
            genericLocators = new GenericLocators();
            action = new Action();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tc_001_get_most_active_top_10_counter() throws Exception {
        try {
            action.scrolltoText(genericLocators.most_active_tab);
            sortedList = new ArrayList<>();

            // action.onClick(driver, 20, genericLocators.most_active_tab);

            for (int row = 1; row <= 10; row++) {
                for (int col = 3; col <= 3; col++) {
                    String xpath = Constant.BEFORE_XPATH + row + Constant.AFTER_XPATH + col + "]";
                    WebElement element = driver.findElement(By.xpath(xpath));
                    sortedList.add(element.getText());
                }
            }
            Collections.sort(sortedList);
            System.out.println(sortedList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
