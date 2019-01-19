package ua.com.lubomir;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Bitcoin {
    WebDriver driver = new ChromeDriver();

    @Before
    public void begin(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://coinmarketcap.com/");
    }

    @Test
    public void btc(){
        WebElement btc = driver.findElement(By.linkText("Bitcoin"));
        String bitcoin = btc.getAttribute("isConnected");
        System.out.println(bitcoin);
    }

    @After
    public void end(){
        driver.close();
    }
}
