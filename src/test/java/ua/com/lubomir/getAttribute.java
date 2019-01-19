package ua.com.lubomir;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class getAttribute extends base{
    WebDriver driver = new ChromeDriver();

    @Before
    public void prepare(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://google.com.ua/");
    }

    @Test
    public void check(){
       WebElement window = driver.findElement(By.cssSelector("[name=q]"));
       window.sendKeys("Selenium");
       String s = window.getAttribute("value");
       System.out.println(s);

       WebElement logo = driver.findElement(By.cssSelector("#lga img"));
       String l = logo.getAttribute("id");
       System.out.println(l);
    }

    @After
    public void closure(){
        driver.close();
    }
}