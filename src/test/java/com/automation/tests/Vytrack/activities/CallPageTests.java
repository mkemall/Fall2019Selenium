package com.automation.tests.Vytrack.activities;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class CallPageTests {
    private By usernameBy= By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private WebDriver driver;
    private Actions actions;

    private String storeManagerUserName = "storemanager85";

    private String storeManagerPassword="UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");
    @BeforeMethod
    public void setup () throws Exception {
        driver= DriverFactory.createADriver("chrome");
        driver.get("http://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions=new Actions(driver);


        BrowserUtilities.wait(3);
        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        BrowserUtilities.wait(3);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtilities.wait(3);

        //hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtilities.wait(3);
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtilities.wait(3);


    }
    @Test
    public void verifyLogCallButton(){
        WebElement logCallBtnElement = driver.findElement(logCallBtnBy);
        Assert.assertTrue(logCallBtnElement.isDisplayed());

    }



    @AfterMethod
    public void teardown(){
        driver.quit();

    }
    /**
     * TASK
     *
     * Scenario: Verify for store manager
     *
     * Login as story manager
     * Go to Activities --> Calendar Events
     * Verify that Create Calendar Event button is displayed
     */
    public class CalendarEventsPageTests {
        private By usernameBy = By.id("prependedInput");
        private By passwordBy = By.id("prependedInput2");
        private WebDriver driver;
        private Actions actions;
        private String storeManagerUserName="storemanager85";
        private String storeManagerPassword="UserUser123";
        private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
        private By createCalendarEventBtnBy = By.cssSelector("a[title='Create Calendar event']");
        private By currentUserBy=By.cssSelector("#user-menu > a");
        private By ownerBy =By.className("select2-chosen");
        private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
        //for some reason , end-part of id is always different, That's why , we use contains[*] to partially
        //match id. We selected static part of id and provided into locator
        private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid]");
        private By startTimeBy=By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid]");





        @BeforeMethod

        public void setup() throws Exception {
            driver = DriverFactory.createADriver("chrome");
            driver.get("https://qa2.vytrack.com/user/login");
            driver.manage().window().maximize();
            actions = new Actions(driver);
            BrowserUtilities.wait(3);
            driver.findElement(usernameBy).sendKeys(storeManagerUserName);
            BrowserUtilities.wait(3);
            driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
            BrowserUtilities.wait(5);
            //hover over Activities
            actions.moveToElement(driver.findElement(activitiesBy)).perform();
            BrowserUtilities.wait(2);
            driver.findElement(By.linkText("Calendar Events")).click();
            BrowserUtilities.wait(5);
        }
        @Test
        public void verifyCreateButton(){
            WebElement createCalendarEventBtn = driver.findElement(createCalendarEventBtnBy);
            Assert.assertTrue(createCalendarEventBtn.isDisplayed());
        }
        @AfterMethod
        public void teardown(){
            driver.quit();
        }

        /**
         * Test case ; default options
         * login as sales manager
         * go to activities ---> calendar events
         * click on create calendar event
         * default owner name should be current user
         * default title should be blank
         * defualt start date should be current date
         * default start time should be current time
         */
        @Test(description = "Default options")
        public void verifyDefaultValues() throws Exception {
            //click on create calendar event
            driver.findElement(createCalendarEventBtnBy).click();
            BrowserUtilities.wait(3);
            //default owner name should be current user
            String currentUserName=driver.findElement(currentUserBy).getText();
            BrowserUtilities.wait(2);
            String defaultOwnerName=driver.findElement(ownerBy).getText().trim();
            BrowserUtilities.wait(2);
            Assert.assertEquals(currentUserName, defaultOwnerName);

            //default title should be blank
            WebElement titleElement=driver.findElement(titleBy);
            Assert.assertTrue(titleElement.getAttribute("value").isEmpty());
            BrowserUtilities.wait(2);
            //default start date should be current date
            String expectedDate= LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            BrowserUtilities.wait(2);
            String actualDate=driver.findElement(startDateBy).getAttribute("value");
            BrowserUtilities.wait(2);

            Assert.assertEquals(actualDate, expectedDate);

            String expectedTime= LocalTime.now(ZoneId.of("MT")).format(DateTimeFormatter.ofPattern("h:m a"));
            BrowserUtilities.wait(2);
            String actualTime=driver.findElement(startTimeBy).getAttribute("value");

            Assert.assertEquals(actualTime,expectedTime );



        }


    }
}
