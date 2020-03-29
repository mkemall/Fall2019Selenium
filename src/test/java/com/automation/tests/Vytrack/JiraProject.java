package com.automation.tests.Vytrack;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.security.Key;

public class JiraProject {
  private WebDriver driver;
  private String URL = "https://qa2.vytrack.com/user/login";
  private String username = "storemanager78";
  private String password = "UserUser123";
  private By usernameBy = By.id("prependedInput");
  private By passwordBy = By.id("prependedInput2");
  private By activities=By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
  private By calendar=By.xpath("//span[text()='Vehicles Model']");
  private By allVehic=By.xpath("//h1[@class='oro-subtitle']");
  @Test
  public void Scenarios() throws InterruptedException {
    driver.get(URL);
    driver.findElement(usernameBy).sendKeys(username);
    driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
    Thread.sleep(2000);
    Actions actions= new Actions(driver);
    actions.moveToElement(driver.findElement(activities)).perform();
    Thread.sleep(2000);
    driver.findElement(calendar).click();
    Thread.sleep(4000);
    String expected="All Vehicles Model";
    String actual=driver.findElement(allVehic).getText().trim();
    System.out.println(actual);
    Assert.assertEquals(actual,expected,"not equals");
  }
  @BeforeMethod
  public void setup() {
    WebDriverManager.chromedriver().version("79").setup();
    driver = new ChromeDriver();
    driver.get(URL);
    driver.manage().window().maximize();
  }
  @AfterMethod
  public void teardown() {
    //if webdriver object alive
    if (driver != null) {
      //close browser, close session
      driver.quit();
      //destroy webdriver object for sure
      driver = null;
    }
  }

}
