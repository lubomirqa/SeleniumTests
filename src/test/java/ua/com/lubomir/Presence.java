package ua.com.lubomir;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Presence {
    WebDriver driver = new ChromeDriver();

    @Before
    public void prepare(){
        driver.get("https://ru.wikipedia.org/wiki/Document_Object_Model");
    }

    @Test
    public void textPresence(){
        if(driver.getPageSource().contains("был выпущен фирмой")){
        System.out.println("text is present");}
        else
        System.out.println("text not present");
    }



    @After
    public void closure(){
        driver.close();
    }
}
