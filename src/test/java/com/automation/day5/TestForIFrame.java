package com.automation.day5;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForIFrame {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtilities.wait(4);
        //before looking for that element , we need to jump to that frame
        // you can spicfy = name , id , index or webelement of the frame
        // its like we are jumping to index layer
        driver.switchTo().frame("mce_0_ifr");
        // now this content will be visible
        WebElement textInput = driver.findElement(By.id("tinymce"));
        System.out.println(textInput.getText());
        // exit from the frame
        driver.switchTo().defaultContent();
        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());





    driver.quit();
    }
}
