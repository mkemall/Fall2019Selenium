package com.automation.day8;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {
    private WebDriver driver;
    @Test
    public void googleSearchTest() throws Exception {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);
        BrowserUtilities.wait(2);

        //since every search item has a tag name <h3>
        // it's the easiest way to collect all of them
        List<WebElement> searchItems= driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems){
            System.out.println("Title:  " + searchItem.getText());
            String var = searchItem.getText();
            // if there is a text - print it
            if (!var.isEmpty()){
                System.out.println(var);
                // verify that every search result contatins java
                //if some of the search results doesn't contain java word , it will fail the test
                Assert.assertTrue(var.toLowerCase().contains("java"));
                System.out.println(var.toLowerCase());
                System.out.println();
            }

        }

    }
    /*
    given user is on the amazon.com page
    when user enters java as a search item
    then user clicks on the search button
    and user clicks on the first search item
    and user verifies that tittle of search item contains "Java"
     */
    @Test(description = "Search for Java book on amazon")
    public void amazonSearchTest() throws Exception {
        driver.get("http://amazon.com");
        // there is a chance item is not visible
        // so we need to maximize window before clicking
        driver.manage().wait();
        BrowserUtilities.wait(5);
        driver.findElement(By.id("twoabsearchtextbox")).sendKeys("Java",Keys.ENTER);
        BrowserUtilities.wait(5);
        // find all links inside h2 elements , because h2 element is no clickable itself
        //hyperlinks must be clickable

        List<WebElement>searchItems=driver.findElements(By.tagName("//h2//a"));

        //click on the first item
        searchItems.get(0).click();
        BrowserUtilities.wait(5);

        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        //close browser and destroy webdriver object
        driver.quit();
    }

}
