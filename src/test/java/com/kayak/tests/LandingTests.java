package com.kayak.tests;

import com.kayak.Utils.BrowserUtils;
import com.kayak.Utils.Configuration_Reader;
import com.kayak.Utils.Driver;
import com.kayak.Utils.TestBase;
import com.kayak.pages.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;




public class LandingTests extends TestBase {


    public static Logger log = LogManager.getLogger(LandingTests.class.getName());


    @Test(priority = 1)
    public void bookedFlight() throws IOException, InterruptedException {

        extentLogger = report.createTest("Booked Flight ");

        Driver.getDriver().get(Configuration_Reader.getProperty("url"));


        LandingPage landing = new LandingPage();

        BrowserUtils.waitForVisibility((WebElement) driver, 10);

        landing.deletButtonElement.click();
    }


    @Test(priority = 2)
    public void enterDep_desCity() {

        String originCity = Configuration_Reader.getProperty("origin1");
        String destinationCity = Configuration_Reader.getProperty("destination1");

        BrowserUtils.waitPlease(1000);
        LandingPage landingPage = new LandingPage();
        landingPage.bookFlight(originCity, destinationCity);

    }


    @Test(priority = 3)
    public void selectDate() {

        String departDay = Configuration_Reader.getProperty("departDay");
        String returnDay = Configuration_Reader.getProperty("returnDay");
        BrowserUtils.waitPlease(1000);

        LandingPage landingPage = new LandingPage();
        landingPage.choseDate(departDay, returnDay);
        landingPage.searchButtonElement.click();


    }




    @Test(priority = 4)
    public void resultConferm() {


        LandingPage landingPage = new LandingPage();
        for (String window : driver.getWindowHandles()) {

            driver.switchTo().window(window);
            BrowserUtils.waitPlease(1000);
            landingPage.clsPopUp.click();

        }


        String city = landingPage.results.getText();
        Assert.assertTrue(city.contains("origin1"));
        log.info("departure mathed to the search");
        Assert.assertTrue(city.contains("destination1"));
        log.info("arrival mathed to the search");

    }



    @DataProvider(name ="data_info")
    public static Object[][] datas(){
        return new Object[][]{
                {"oakland","los angeles"},
                {"san francisco","los angeles"},
                {"oakland","new york"},
                {"san francisco","new york"}};

    }


    @Test (dataProvider = "data_info")
    public void bookedWithDataProvider(String originCity, String destinationCity, String departDay, String returnDay){
        extentLogger = report.createTest("DDT test" + originCity);



    }




}



