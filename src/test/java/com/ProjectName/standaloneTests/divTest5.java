package com.ProjectName.standaloneTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class divTest5 {
    /*
    steps to repeat:
       - set up Chrome driver
       - add implicit wait
       - maximize browser window
       - close WebDriver instance
     */
    @Test
    public void test2_001() {
        //verify valid title of the page
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        String expectedTitle = "Home";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        driver.close();
    }
}
