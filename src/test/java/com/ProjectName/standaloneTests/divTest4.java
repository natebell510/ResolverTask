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
        //  Assert that "Option 1" is the default selected value
        String expectedOptionValue = "Option 1";
        //set up Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //add implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser window
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement div4 = driver.findElement(By.xpath("//div[@id='test-4-div']"));
        //scroll to div 3
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", div4);
        WebElement selectedOption = driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
        String actualOptionValue = selectedOption.getText();
        Assert.assertEquals(expectedOptionValue,actualOptionValue);
        driver.close();
    }
}
