package com.ProjectName.standaloneTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void test5_001() {
        // Verify Test 5 div button functionality
        //set up Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //add implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser window
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement div5 = driver.findElement(By.xpath("//div[@id='test-5-div']"));
        //scroll to div 5
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", div5);
        //message before button
        String expectedMessageBeforeButton = "A button will eventually show up here...";
        String actualMessageBeforeButton = driver.
                findElement(By.xpath("//p[@id='test5-placeholder']")).getText();
        Assert.assertEquals(expectedMessageBeforeButton,actualMessageBeforeButton);
        //explicit wait, until condition is met and button is clickable
        WebDriverWait wait  = new WebDriverWait(driver,100);
        WebElement buttonDiv5 = driver.findElement(By.xpath("//button[@id='test5-button']"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonDiv5));
        buttonDiv5.click();
        //message after click
        String expectedMessageAfterClick = "You clicked a button!";
        String actualMessageAfterClick = driver.findElement(By.xpath("//div[@id='test5-alert']")).getText();
        Assert.assertEquals(expectedMessageAfterClick,actualMessageAfterClick);
        //button is disabled, enabled only after page is refreshed
        Assert.assertFalse(buttonDiv5.isEnabled());
        driver.close();
    }
}
