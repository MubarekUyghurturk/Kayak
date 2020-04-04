package com.kayak.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    // make constructor private for create singleton class
    private Driver() {
    }

    //@Parameters({"browser"})
    /*public static WebDriver getDriver(String browser) {


        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/mubarekuyghurturk/Downloads/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/mubarekuyghurturk/Downloads/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;

    }*/

    public synchronized static WebDriver getDriver(String browser) {
        // String browser ==>  it originally comes from xml file to test base class, from test base it comes here
        if (driver == null) {
            // first we check if the value from xml file is null or not
            // if the value from xml file NOT null we use
            // the value from xml file IS null, we get the browser from properties file

            browser = browser == null ? Configuration_Reader.getProperty("browser") : browser;

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;


                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();

                default:
                    throw new RuntimeException("Illegal browser type!");
            }
        }
        return driver;
    }


    public static WebDriver getDriver() {

        return getDriver(null);
    }





    public  static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
