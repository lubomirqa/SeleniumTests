package ua.com.lubomir;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

public class Verify {
    WebDriver driver = new ChromeDriver();

    @Before
    public void start() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://google.com.ua");
    }

    @Test
    public void action() {
        Assert.assertThat(driver.getTitle(), containsString("Google"));

        Assert.assertTrue(driver.findElement(By.id("title")).isDisplayed());

        Assert.assertThat(driver.findElement(By.id("home")).getText(), containsString("Element is present"));

        Assert.assertThat(driver.getPageSource(), containsString("Somewhere in the text"));

        WebElement element = driver.findElement(By.id("redbox"));
        Assert.assertEquals("rgba(255, 0, 0, 0)", element.getCssValue("color"));

    }


        @After
        public void end () {
            driver.close();
        }

    }

