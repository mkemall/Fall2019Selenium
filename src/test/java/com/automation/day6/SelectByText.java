package com.automation.day6;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) throws Exception {
        WebDriver driver= DriverFactory.createADriver("chrome");
        BrowserUtilities.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(3);
        //create a web element object for drop-down first
        WebElement simpleDropdown = driver.findElement( By.id("dropdown"));
        // provide webelement object into constructor
        Select selectsimpleDropdown = new Select(simpleDropdown);
        // select by visible text
        selectsimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtilities.wait(3);
        selectsimpleDropdown.selectByVisibleText("Option 1");



        ///**** ONE SELECT OBJECT FOR PER DROP DOWN ///////
        //////////////////////////////////
        // SELECT YEAR DAY MONTH or DATE OF BIRTH

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("1");
        selectMonth.selectByVisibleText("February");
        selectYear.selectByVisibleText("2003");

        // select all months one by one
        // getOptions(); -- returns all options from dropdown as List<WebElement>

        List<WebElement> months = selectMonth.getOptions();
        //get the month name and select based on that
        for (WebElement eachMonth : months){
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtilities.wait(1);
        }
        BrowserUtilities.wait(5);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("District Of Columbia");
        // option that is currently selected
        // getFirstSelectedOption() -- returns a webelement , thats why we need to call getText()
        // getText() retrieves visible text from the webelement


        String selected = stateSelect.getFirstSelectedOption().getText();
        if (selected.equals("District Of Columbia")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
        List<WebElement> states = stateSelect.getOptions();
        for (WebElement eachStates : states){
            System.out.println(eachStates.getText());
        }









        BrowserUtilities.wait(3);
        driver.quit();

    }
}
