package ua.com.lubomir;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.concurrent.TimeUnit;

public class GoogleLogin {
    WebDriver driver = new ChromeDriver();

    @Before
        public void prepare() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://google.com.ua");
    }

    @Test
    public void google(){
        driver.findElement(By.cssSelector("a[id=gb_70]")).click();
        driver.findElement(By.cssSelector("input#identifierId")).sendKeys("lubomir.peretyatko");
        driver.findElement(By.cssSelector("content.CwaK9")).click();
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("0710lubTaste");
        driver.findElement(By.cssSelector("div#passwordNext")).click();

        driver.findElement(
                new ByChained(
                        By.id("registration-form"),
                        By.xpath("//label[contains(.,'Email')]"),
                        By.tagName("input")
                )
        );
    }

    @After
    public void end(){
        driver.close();
    }

}
