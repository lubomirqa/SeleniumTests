package ua.com.lubomir;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SendText {

    WebDriver driver = new ChromeDriver();

    @Before
    public void start(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com.ua/services/?subid=ww-ww-et-g-awa-a-g_hpbfoot1_1!o2&utm_source=google.com&utm_medium=referral&utm_campaign=google_hpbfooter&fg=1#?modal_active=none");
    }

    @Test
    public void action(){
        new Select(driver.findElement(By.id("analyze")))
                .selectByVisibleText("Аналізуйте й навчайтеся");


//        WebElement search = driver.findElement(By.name("q"));
//
////        new Actions( driver)
////                .doubleClick(driver.findElement(By.name("login")))
////                .perform();
//
//
//        search.sendKeys("Hello World!");
//        search.sendKeys(Keys.TAB);
//        driver
//                .switchTo().activeElement()
//                .click();
//
//        driver
//                .switchTo().activeElement()
//                .sendKeys(Keys.RETURN);
    }

    @After
    public void end(){
        driver.close();
    }

}
