package com.kayak.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



    public class Test {//*[contains(@id,'origin-airport-display-multi-container'
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "/Users/dawud/Downloads/chromedriver");
            WebDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 60);
            driver.get("https://www.kayak.com/");


            driver.findElement(By.xpath("(//div[@class='_iac _irF _Hk _h-8'])[1]")).click();
            WebElement origin = driver.findElement(By.xpath("(//input[contains(@id,'-origin-airport')])[1]"));
            Thread.sleep(3000);
            origin.sendKeys("Oakland");
            Thread.sleep(3000);
            origin.sendKeys(Keys.RETURN);




            WebElement desti =driver.findElement(By.xpath(" //div[contains(@id,'-destination-airport-display')][1]"));
            desti.click();
            WebElement desti1 = driver.findElement(By.xpath("(//input[contains(@id,'-destination-airport')])[1]"));
            desti1.click();
            Thread.sleep(3000);
            desti1.sendKeys("Los Angeles");
            Thread.sleep(3000);
            desti1.sendKeys(Keys.RETURN);

            WebElement da = driver.findElement(By.xpath("(//div[contains(@id,'-dateRangeInput-display-start-inner')])[1]"));
            da.click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@aria-label='April 10']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@aria-label='April 20']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//button[contains(@id,'-submit')])[1]")).click();
            Thread.sleep(5000);


            for (String windo:driver.getWindowHandles())
            {
                driver.switchTo().window(windo);
                Thread.sleep(5000);
                driver.findElement(By.xpath("(//*[contains(@id,'-dialog-close')])[10]")).click();
            }

            String city = driver.findElement(By.xpath("(//div[contains(@class,'Base-Results-HorizonResult')])[1]")).getText();
            System.out.println(city);
            System.out.println(city.contains("OAK"));
            System.out.println(city.contains("LAX"));
        }







    }






