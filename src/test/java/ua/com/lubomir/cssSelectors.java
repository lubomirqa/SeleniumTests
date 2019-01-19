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

public class cssSelectors {

    WebDriver driver = new ChromeDriver();

    @Before
    public void prepare(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://w3c.github.io/webdriver/#element-displayedness");
    }

    @Test
    public void action(){
        WebElement first = driver.findElement(By.cssSelector("section#privacy"));
        WebElement second = driver.findElement(By.cssSelector("section.appendix[id=privacy]"));
        WebElement third = driver.findElement(By.cssSelector("section.appendix[id='privacy']"));
        WebElement fourth = driver.findElement(By.cssSelector("section.appendix[id^=priv]"));   // ^= priv - начинается на priv
        WebElement fifth = driver.findElement(By.cssSelector("section.appendix[id$=acy"));  // $= acy - заканчивается на acy
        WebElement sixth = driver.findElement(By.cssSelector("section.appendix[id*=ivac"));  // $* ivac - вмещает ivac

    }

    @After
    public void end(){
        driver.close();
    }
}
