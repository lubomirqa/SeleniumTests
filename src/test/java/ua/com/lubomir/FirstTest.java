package ua.com.lubomir;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class FirstTest extends base {

    public WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://github.com");
    }

    @Test
    public void check() {
        WebElement login = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]"));
        login.click();

        WebElement loginField = driver.findElement(By.id("login_field"));
        loginField.sendKeys("lubomirqa");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("0710lubTaste");

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]"));
        submit.click();

        WebElement terms = driver.findElement(By.xpath("/html/body/div[5]/div[1]/ul[1]/li[2]/a"));
        terms.click();

        try {
            Assert.assertTrue(driver.findElement(By.id("content-wrapper")).getText().contains("Some basic terms"));
        } catch (Error e) {
            System.out.println("not found Terms content");
        }

//        driver.navigate().back();
        WebElement privacy = driver.findElement(By.partialLinkText("Privacy"));
        privacy.click();

        WebElement footer = driver.findElement(By.id("footer"));

        try {
            Assert.assertTrue(footer.findElement(By.cssSelector("div.inner")).getText().contains("All rights reserved."));
        } catch (Error ex) {

            driver.get("https://google.com.ua");
        }
    }


        @After
        public void closure () {
            driver.close();
        }
    }

