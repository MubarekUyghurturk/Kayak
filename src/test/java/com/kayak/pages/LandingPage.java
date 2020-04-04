package com.kayak.pages;

import com.kayak.Utils.BrowserUtils;
import com.kayak.Utils.Configuration_Reader;
import com.kayak.Utils.Driver;
import com.kayak.Utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import java.util.List;


public class LandingPage extends TestBase {




        public LandingPage(){

            PageFactory.initElements(Driver.getDriver(),this);
        }

        @FindBy(xpath= "(//div[@class='item-info'])[1]")
        public WebElement visibility;

        @FindBy(xpath="(//div[@class='_iac _irF _Hk _h-8'])[1]")
        public WebElement deletButtonElement;

        @FindBy(xpath="(//input[contains(@id,'-origin-airport')])[1]")
        public WebElement originCityElement;

        @FindBy(xpath="(//div[contains(@id,'-destination-airport-display')])[1]")
        public WebElement destInitilizeElement;


        @FindBy(xpath="(//input[contains(@id,'-destination-airport')])[1]")
        public WebElement destinationCityElement;



        @FindBy(xpath = "(//div[contains(@id,'-dateRangeInput-display-start-inner')])[1]")
        public WebElement dateInitilize;


        @FindBy(xpath="//div[contains(@aria-label , 'April 10')]")
        public WebElement departureDayElement;


        @FindBy(xpath="//div[contains(@aria-label , 'April 30')]")
        public WebElement returnDayElement;


        @FindBy(xpath="(//button[contains(@id,'submit')])[1]")
        public WebElement searchButtonElement;

        @FindBy(xpath="(//*[contains(@id,'-dialog-close')])[10]")
        public WebElement clsPopUp;

        @FindBy(xpath="(//*[contains(@id,'-dialog-close')])[11]")
        public WebElement clsPopUp1;


        @FindBy(xpath="//nav[@class='aria-controls']/p")
        public List<WebElement> results;

        }





