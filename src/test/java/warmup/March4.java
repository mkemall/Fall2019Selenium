package warmup;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class March4 {
        static WebDriver driver;
        public static void main(String[] args) throws Exception {
            ebayTest();
            amazonTest();
            wikiTest();
        }
        public static void ebayTest() throws InterruptedException {
            driver = DriverFactory.createADriver("chrome");
            driver.get("http://ebay.com");
            driver.findElement(By.id("gh-ac")).sendKeys("java book");
            driver.findElement(By.id("gh-btn")).click();
            WebElement searchResults = driver.findElement(By.tagName("h1"));
            String[] searchSentence = searchResults.getText().split(" ");
            System.out.println(Arrays.toString(searchSentence));
            System.out.println(searchSentence[0]);

            Thread.sleep(3000);
            driver.quit();
        }
        public static void amazonTest() throws Exception {
            driver = DriverFactory.createADriver("chrome");
            driver.get("http://amazon.com");
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
            String title = driver.getTitle();
            if (title.contains("java book")){
                System.out.println("TEST PASSED");
            }else {
                System.out.println("TEST FAILED");
            }
                Thread.sleep(4000);

            driver.quit();
        }
        public static void wikiTest() throws Exception {
           driver = DriverFactory.createADriver("chrome");
           driver.get("http://en.wikipedia.org/wiki/Main_Page");
           driver.findElement(By.id("searchInput")).sendKeys("Selenium (software)",Keys.ENTER);
           String link = driver.getCurrentUrl();
           if (link.contains("Selenium_(software)")){
               System.out.println("TEST PASSED");
           }else {
               System.out.println("TEST FAILED");
           }
           Thread.sleep(5000);
          driver.quit();
        }
   }

