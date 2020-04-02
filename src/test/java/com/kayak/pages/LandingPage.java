package com.kayak.pages;

import com.kayak.Utils.Configuration_Reader;
import com.kayak.Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class LandingPage {




        public LandingPage(){

            PageFactory.initElements(Driver.getDriver(),this);
        }

        @FindBy(xpath= "(//div[@class='item-info'])[1]")
        public WebElement visibility;

        @FindBy(xpath="(//div[@class='_iac _irF _Hk _h-8'])[1]")
        public WebElement deletButtonElement;

        @FindBy(xpath="(//input[contains(@id,'-origin-airport')])[1]")
        public WebElement originCityElement;


        @FindBy(xpath="(//input[contains(@id,'-destination-airport')])[1]")
        public WebElement destinationCityElement;

        @FindBy(xpath="(//div[contains(@id,'-destination-airport-display')])[1]")
        public WebElement disInitilize;

        @FindBy(xpath = "(//div[contains(@id,'-dateRangeInput-display-start-inner')])[1]")
        public WebElement dateInitilize;


        @FindBy(xpath="//div[contains(@aria-label , 'April 10')]")
        public WebElement departureDayElement;


        @FindBy(xpath="//div[contains(@aria-label , 'April 30')]")
        public WebElement returnDayElement;


        @FindBy(xpath="(//button[contains(@id,'submit')])[1]")
        public WebElement searchButtonElement;

        @FindBy(xpath="//*[contains(@id,'-dialog-close')])[10]")
        public WebElement clsPopUp;

        @FindBy(xpath="(//div[contains(@class,'Base-Results-HorizonResult')])[3]")
        public WebElement results;




        public void delectDrfaultCity(){
            deletButtonElement.click();
        }








        @Parameters({"originCity","destinationCity"})
        public void choseDate(String departDay, String returnDay){
            deletButtonElement.click();


            departureDayElement.sendKeys(departDay);
            returnDayElement.sendKeys(returnDay);
            searchButtonElement.click();

        }



    public void bookFlight(String originCity, String destinationCity){

       // String originCity = Configuration_Reader.getProperty("origin1");
      //  String destinationCity = Configuration_Reader.getProperty("destination1");
        String departDay = Configuration_Reader.getProperty("departDay");
        String returnDay = Configuration_Reader.getProperty("returnDay");

        originCityElement.sendKeys(originCity);
        destinationCityElement.sendKeys(destinationCity);

        departureDayElement.sendKeys(departDay);
        returnDayElement.sendKeys(returnDay);
        searchButtonElement.click();

    }







    public void enterDeparture_ReturnDates(){

        }

    }
