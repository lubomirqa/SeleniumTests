package ua.com.lubomir;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class QuickLink2 {
    WebDriver driver = new ChromeDriver();

    @Before
    public void prepare() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.w3.org/");
    }

    @Test
    public void linkCheck() {
        try {
            WebElement nav = driver.findElement(By.cssSelector("div#w3c_nav"));
        }
        catch(Error e){
            System.out.println("not found");
        }

        WebElement mast = driver.findElement(By.cssSelector("div#w3c_mast"));
        mast.click();



    }



    @After
    public void close(){
        driver.close();
    }
}
