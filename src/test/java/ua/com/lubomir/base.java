package ua.com.lubomir;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
    public WebDriver driver;

    public boolean isElementPresent(By locator){
       try {
           driver.findElement(locator);
           return true;
       }
       catch (NoSuchElementException ex) {
           return false;
       }
   }


    }

