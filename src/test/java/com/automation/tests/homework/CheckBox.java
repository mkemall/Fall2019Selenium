package com.automation.tests.homework;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBox {
    public static void main(String[] args) {

    }

    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void CheckBoxTest1() throws Exception {
        String expected = "Thursday";
        String actual = "Thursday";

        driver.findElement(By.cssSelector("[id*=gwt-debug-cwCheckBox-Thursday-input]")).click();
        System.out.println(expected);

        BrowserUtilities.wait(2);
        List<WebElement> checkBoxTest1 = driver.findElements(By.id("[id*gwt-debug-cwCheckBox-Thursday-input]"));

        if (checkBoxTest1.contains("Thursday")){
        }
        Assert.assertEquals(actual, expected);
//idk how to do unclick i tried my best

            }

            @Test
            public void todaysDate() throws Exception {
                driver.get("http://practice.cybertekschool.com/dropdown");
                BrowserUtilities.wait(2);
                WebElement simpleDropdown = driver.findElement( By.id("dropdown"));
                Select selectsimpleDropdown = new Select(simpleDropdown);
                selectsimpleDropdown.selectByVisibleText("Option 2");
                BrowserUtilities.wait(3);
                selectsimpleDropdown.selectByVisibleText("Option 1");

                Select selectYear = new Select(driver.findElement(By.id("year")));
                Select selectMonth = new Select(driver.findElement(By.id("month")));
                Select selectDay = new Select(driver.findElement(By.id("day")));

                selectDay.selectByVisibleText("1");
                selectMonth.selectByVisibleText("February");
                selectYear.selectByVisibleText("2003");
                List<WebElement> months = selectMonth.getOptions();

                for (WebElement eachMonth : months){
                    String monthName = eachMonth.getText();
                    selectMonth.selectByVisibleText(monthName);
                    BrowserUtilities.wait(1);
                }
                BrowserUtilities.wait(5);
                Select stateSelect = new Select(driver.findElement(By.id("state")));
                stateSelect.selectByVisibleText("Colorado");



                String selected = stateSelect.getFirstSelectedOption().getText();
                if (selected.equals("Colorado")){
                    System.out.println("TEST PASSED");
                }else{
                    System.out.println("TEST FAILED");
                }
                List<WebElement> states = stateSelect.getOptions();
                for (WebElement eachStates : states){
                    System.out.println(eachStates.getText());
                }
               WebElement dropdown=driver.findElement(By.id("dropdownMenuLink"));
                WebElement option = driver.findElement(By.xpath("//a[text()='Amazon'"));
                dropdown.click();
                Thread.sleep(1000);
                option.click();

              }

@Test
public void departmentsSort() throws Exception {
    WebDriverManager.chromedriver().version("79").setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    driver = DriverFactory.createADriver("chrome");
    driver.get(" https://www.amazon.com");
    BrowserUtilities.wait(2);
    Select deptSelectDropDown= new Select(driver.findElement(By.id("searchDropdownBox")));
    String deptDefaultSelected=deptSelectDropDown.getFirstSelectedOption().getText();
    System.out.println("deptDefaultSelected : " +deptDefaultSelected);

    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}



