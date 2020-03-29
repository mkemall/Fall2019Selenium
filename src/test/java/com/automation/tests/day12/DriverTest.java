package com.automation.tests.day12;

import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverTest {
    @Test
    public void GoogleTest(){
        //Driver.getDriver()--->>returns driver
        Driver.getDriver().get("http://google.com");
        Assert.assertEquals(Driver.getDriver().getTitle() , "Google");
        Driver.closeDriver();


    }
}
