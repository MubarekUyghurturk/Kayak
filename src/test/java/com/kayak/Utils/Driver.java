package com.kayak.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    // make constructor private for create singleton class
    private Driver() {
    }

    @Parameters({"browser"})
    public static WebDriver getDriver(String browser) {


        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/mubarekuyghurturk/Downloads/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/mubarekuyghurturk/Downloads/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;

    }


    public static WebDriver getDriver() {

        return getDriver();
    }





    public  static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
