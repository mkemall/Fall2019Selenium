package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        // By.name("q") -->> name="q"
        WebElement search = driver.findElement(By.name("q"));
        // once we found an element , how to enter text ??
        search.sendKeys("Java", Keys.ENTER);
        // if see <a> element , it calls link
        // visible text of this link , can be used by selenium to find this element
       WebElement news = driver.findElement(By.linkText("News"));
       news.click();

        Thread.sleep(8000);
        driver.quit();




    }
}
