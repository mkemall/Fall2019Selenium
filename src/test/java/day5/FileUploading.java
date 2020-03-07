package day5;
import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class FileUploading {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtilities.wait(5);
        WebElement upload = driver.findElement(By.id("file-upload"));
        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir")+"/pom.xml";

        upload.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtilities.wait(5);
        //driver.quit();
}

    }



