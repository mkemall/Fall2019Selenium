package com.automation.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        // every window has some id , this id calls window handle
        // based on window handle , we can switch between windows
        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        System.out.println("BEFORE SWTITCH : " + driver.getCurrentUrl());
// since we have all windows
        // and we know id of original windows
        // we can say switch something that is not equals to old know id
        for (String windowId: windowHandles){
           if (!windowId.equals(windowHandle)){
               driver.switchTo().window(windowHandle);

            }
        }
        System.out.println("AFTER SWITCH : " + driver.getCurrentUrl());

        //driver.close();

   driver.quit();


        /**
         *
         *
         * @param pagaTitle
         * @param driver
         *
         */

    }
    public static void switchToWindowBasedOnTitle(String pageTitle , WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }

}
