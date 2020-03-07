package day5;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtilities.wait(5);
        //enter first name
        driver.findElement(By.name("firstname")).sendKeys("Mustafa");
        BrowserUtilities.wait(2);
        driver.findElement(By.name("lastname")).sendKeys("Kemal");
        BrowserUtilities.wait(2);
        driver.findElement(By.name("username")).sendKeys("mkemal");
        BrowserUtilities.wait(2);
        driver.findElement(By.name("email")).sendKeys("mustafa-kemalll@hotmail.com");
        BrowserUtilities.wait(2);
        driver.findElement(By.name("password")).sendKeys("supersecretpassword2020");
        BrowserUtilities.wait(2);
        driver.findElement(By.name("phone")).sendKeys("843-290-9499");
        BrowserUtilities.wait(2);

        List<WebElement>genders = driver.findElements(By.name("gender"));
        //select gender
        genders.get(0).click(); // select male for example
        driver.findElement(By.name("birthday")).sendKeys("10/20/1991");
        driver.findElement(By.id("inlineCheckbox2")).click();
        BrowserUtilities.wait(2);
        driver.findElement(By.id("wooden_spoon")).submit();
        BrowserUtilities.wait(2);






        driver.quit();

    }
}
