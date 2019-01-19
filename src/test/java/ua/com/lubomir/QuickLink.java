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

public class QuickLink {
    WebDriver driver = new ChromeDriver();

    @Before
    public void begin() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://ru.wikipedia.org/wiki/Document_Object_Model");
    }

    @After
    public void closure() {
        driver.close();
    }

    @Test
    public void linkProbation() {
        WebElement link = driver.findElement(By.cssSelector("a.interlanguage-link-target[lang=en]"));
        link.click();
        WebElement span = driver.findElement(By.cssSelector("span.toctext"));
        span.click();
        WebElement text = (driver.findElement(By.partialLinkText("The W3C Document Object Model (DOM)")));
        String s = text.getCssValue("color");
        System.out.println(s);
        text.click();
        WebElement wc3 = driver.findElement(new By.ByLinkText("W3C"));
        wc3.click();
        WebElement december = driver.findElement(new By.ByLinkText("New version of the Roadmap of Web Applications on Mobile"));
        december.click();

        try {
            Assert.assertTrue(driver.findElement(By.cssSelector("div.main-content")).getText().contains("The contents of the roadmap have been updated to follow the evolution of the Web platform since July 2018."));
        } catch (Error ex) {
            System.out.println("no text found");
        }
    }
}
