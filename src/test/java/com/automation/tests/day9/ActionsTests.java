package com.automation.tests.day9;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {
    private WebDriver driver;
    private Actions actions;



    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createADriver("chrome");
        actions=new Actions(driver);
    }
    @Test
    public void hoverOnImage() throws Exception {
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtilities.wait(3);
        WebElement img1=driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2=driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3=driver.findElement(By.xpath("(//img)[3]"));
        // build is needed when you have couple of actions
        // always end with perform()
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();
        BrowserUtilities.wait(3);
//hover on the image is verify that
        // "name: user1" is displayed
        // hover over image to make it visible
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        //verify that web element that contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());
        BrowserUtilities.wait(2);
        actions.moveToElement(img2).perform();
        WebElement imgText2=driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());
        BrowserUtilities.wait(2);
        actions.moveToElement(img3).perform();
        WebElement imgText3=driver.findElement(By.xpath("//h5[text()='name: user3']"));
        Assert.assertTrue(imgText3.isDisplayed());



    }
    @Test
    public void jqueryMenuTest() throws Exception {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        //hover on "enabled"
        // hover on "downloads"
        //click on PDF
        BrowserUtilities.wait(3);
        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads=driver.findElement(By.id("ui-id-4"));
        WebElement PDF = driver.findElement(By.id("ui-id-5"));
        actions.moveToElement(enabled).
                pause(1000).
                moveToElement(downloads).
                pause(1000).
                click(PDF).
                build().perform();
        BrowserUtilities.wait(3);




    }
    @Test
    public void dragAndDropTest() throws Exception {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtilities.wait(3);
        //click on accept cookies
        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();

        WebElement earth=driver.findElement(By.id("droptarget"));
        WebElement moon=driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon, earth).perform();
        String expected="You did great!";
        String actual=earth.getText();

        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void teardown() throws Exception {
        BrowserUtilities.wait(3);
        driver.quit();

    }
}
