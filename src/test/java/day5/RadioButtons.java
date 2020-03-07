package day5;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        BrowserUtilities.wait(2);
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));
        // <input type ="radio">
        for (WebElement radioButton : radioButtons) {
            String id = radioButton.getAttribute("id");
            boolean isSelected = radioButton.isSelected();
            System.out.println(id + "is selected ? " + isSelected);
            // returns true , if button can be clicked
            // returns true , if button already clicked
            if (radioButton.isEnabled()){
                radioButton.click();
            System.out.println("clicked on : " + radioButton.getAttribute("id"));
        BrowserUtilities.wait(1);
            }else {
                System.out.println("Button is disabled , not clicked : ");
            }
        }
    driver.quit();


    }
}
