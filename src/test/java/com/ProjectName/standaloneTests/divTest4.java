package com.ProjectName.standaloneTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class divTest4 {
    /*
    steps to repeat:
       - set up Chrome driver
       - add implicit wait
       - maximize browser window
       - close WebDriver instance
     */
    @Test
    public void test4_001() {
        // Verify left button is enabled and colored Blue with RGB value
        String expectedRgbValue = "rgba(0, 123, 255, 1)";
        //set up Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //add implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser window
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement div4 = driver.findElement(By.xpath("//div[@id='test-4-div']"));
        //scroll to div 4
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", div4);
        WebElement leftButton = driver.
                findElement(By.xpath("//div[@id='test-4-div']/button[@class='btn btn-lg btn-primary']"));
        Assert.assertTrue(leftButton.isEnabled());
        String actualRgbValue = leftButton.getCssValue("background-color");
        Assert.assertEquals(expectedRgbValue,actualRgbValue);
        driver.close();
    }
    @Test
    public void test4_002() {
        //  Verify right button is disabled and colored Grey with RGB value
        String expectedRgbValue = "rgba(134, 142, 150, 1)";
        //set up Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //add implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser window
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement div4 = driver.findElement(By.xpath("//div[@id='test-4-div']"));
        //scroll to div 4
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", div4);
        WebElement rightButton = driver.
                findElement(By.xpath("//div[@id='test-4-div']/button[@class='btn btn-lg btn-secondary']"));
        Assert.assertFalse(rightButton.isEnabled());
        String actualRgbValue = rightButton.getCssValue("background-color");
        Assert.assertEquals(expectedRgbValue,actualRgbValue);

        driver.close();
    }
}
