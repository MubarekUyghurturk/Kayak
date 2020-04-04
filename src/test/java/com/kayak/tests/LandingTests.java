package com.kayak.tests;



import com.kayak.Utils.BrowserUtils;
import com.kayak.Utils.Configuration_Reader;
import com.kayak.Utils.Driver;
import com.kayak.Utils.TestBase;
import com.kayak.pages.LandingPage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import java.util.Iterator;



public class LandingTests extends TestBase {

    @Test(dataProvider = "data_info")
    public void bookedFlight(String originCity, String destinationCity,String departDay,String returnDay) throws IOException, InterruptedException {
        extentLogger = report.createTest("Book flight");
        LandingPage landing = new LandingPage();
        BrowserUtils.waitPlease(4);
        landing.deletButtonElement.click();
        extentLogger.info("default airport deleted");

        BrowserUtils.waitPlease(2);

        landing.originCityElement.sendKeys(originCity);
        BrowserUtils.waitPlease(3);
        landing.originCityElement.sendKeys(Keys.RETURN);
        extentLogger.info("origin city entered");
        landing.destInitilizeElement.click();
        BrowserUtils.waitPlease(2);
        landing.destinationCityElement.sendKeys(destinationCity);
        BrowserUtils.waitPlease(3);
        landing.destinationCityElement.sendKeys(Keys.RETURN);
        extentLogger.info("destination entered");

        landing.dateInitilize.click();
        landing.departureDayElement.sendKeys(departDay);
        extentLogger.info("departure date selected");
        landing.returnDayElement.sendKeys(returnDay);
        extentLogger.info("return date selected");
        landing.searchButtonElement.click();
        extentLogger.info("Successfully submitted!");
        BrowserUtils.waitPlease(3);

            for (String window : driver.getWindowHandles()) {

                driver.switchTo().window(window);

                try {

                    landing.clsPopUp.click();

                } catch (Exception e) {
                    e.printStackTrace();

                    landing.clsPopUp1.click();
                }
            }

        int N = Integer.parseInt(Configuration_Reader.getProperty("N"));
        extentLogger.info("will check"+N+"results");
        Iterator<WebElement> itr = landing.results.iterator();
        int i = 0;
        while(itr.hasNext() & i < N) {
        String city = itr.next().getAttribute("textContent");
        Assert.assertTrue(city.toLowerCase().contains(originCity.toLowerCase()));
        extentLogger.pass("Result:"+i+" --departure matched to the search");
        Assert.assertTrue(city.toLowerCase().contains(destinationCity.toLowerCase()));
        extentLogger.pass("Result:"+i+" --arrival matched to the search");
        i++;
        }

    }






   @DataProvider(name ="data_info")
    public static Object[][] datas(){
        return new Object[][]{
                {"oakland","los angeles","May 10","May 20"},
                {"san francisco","los angeles","May 1","May 15"},
                {"oakland","new york","June 12","june 25"},
                {"san francisco","new york","August 2","September 22"}};

    }

}



