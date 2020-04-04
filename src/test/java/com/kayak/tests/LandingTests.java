package com.kayak.tests;



import com.kayak.Utils.BrowserUtils;
import com.kayak.Utils.Configuration_Reader;
import com.kayak.Utils.Driver;
import com.kayak.Utils.TestBase;
import com.kayak.pages.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import java.util.Iterator;



public class LandingTests extends TestBase {


    public static Logger log = LogManager.getLogger(LandingTests.class.getName());


    @Test(priority = 1)
    public void bookedFlight() throws IOException, InterruptedException {

        LandingPage landing = new LandingPage();
        BrowserUtils.waitPlease(2);
        landing.deletButtonElement.click();
        log.info("default airport deleted");


        String originCity = Configuration_Reader.getProperty("origin1");
        String destinationCity = Configuration_Reader.getProperty("destination1");

        BrowserUtils.waitPlease(2);



        landing.originCityElement.sendKeys(originCity);
        BrowserUtils.waitPlease(3);
        landing.originCityElement.sendKeys(Keys.RETURN);
        log.info("origin city entered");
        landing.destInitilizeElement.click();
        BrowserUtils.waitPlease(2);
        landing.destinationCityElement.sendKeys(destinationCity);
        BrowserUtils.waitPlease(3);
        landing.destinationCityElement.sendKeys(Keys.RETURN);
        log.info("destination entered");

        String departDay = Configuration_Reader.getProperty("departDay");
        String returnDay = Configuration_Reader.getProperty("returnDay");

        landing.dateInitilize.click();
        landing.departureDayElement.sendKeys(departDay);
        log.info("departure date selected");
        landing.returnDayElement.sendKeys(returnDay);
        log.info("return date selected");
        landing.searchButtonElement.click();
        log.info("Successfully submitted!");
        BrowserUtils.waitPlease(3);

        /*

        for (String window : driver.getWindowHandles()) {

            driver.switchTo().window(window);
            if (landing.clsPopUp.isEnabled()){
                landing.clsPopUp.click();
            }

            else if (landing.clsPopUp1.isEnabled()){
                landing.clsPopUp1.click();
            }
        }
         */




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
        log.info("will check"+N+"results");
        Iterator<WebElement> itr = landing.results.iterator();
        int i = 0;
        while(itr.hasNext() & i < N) {
        String city = itr.next().getAttribute("textContent");
        Assert.assertTrue(city.toLowerCase().contains(originCity.toLowerCase()));
        log.info("Result:"+i+" --departure matched to the search");
        Assert.assertTrue(city.toLowerCase().contains(destinationCity.toLowerCase()));
        log.info("Result:"+i+" --arrival matched to the search");
        i++;
        }
    }



    /*@DataProvider(name ="data_info")
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



    }*/




}



