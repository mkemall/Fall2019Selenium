package com.automation.day6;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) throws Exception{
        WebDriver driver= DriverFactory.createADriver("chrome");
        BrowserUtilities.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(3);
        Select languagesSelect = new Select(driver.findElement(By.name("languages")));
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple); // if its true u can select more than one option

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        // lets gel all selected options
        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();
        for (WebElement selectedLanguage : selectedLanguages){
            System.out.println(selectedLanguage.getText());
        }
        languagesSelect.deselectByVisibleText("Java");
        BrowserUtilities.wait(3);
        languagesSelect.deselectAll();









        BrowserUtilities.wait(3);
        driver.quit();


    }
}
