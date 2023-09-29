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

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class divTest3 {
    /*
    steps to repeat:
       - set up Chrome driver
       - add implicit wait
       - maximize browser window
       - close WebDriver instance
     */
    @Test
    public void test3_001() {
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
        WebElement div3 = driver.findElement(By.xpath("//div[@id='test-3-div']"));
        //scroll to div 3
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", div3);
        WebElement selectedOption = driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
        String actualOptionValue = selectedOption.getText();
        Assert.assertEquals(expectedOptionValue,actualOptionValue);
        driver.close();
    }

    @Test
    public void test3_002() {
        //  Select "Option 3" from the select list
        String expectedOptionValue = "Option 3";
        //set up Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //add implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser window
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement div3 = driver.findElement(By.xpath("//div[@id='test-3-div']"));
        //scroll to div 3
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", div3);
        WebElement selectedOption = driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
        selectedOption.click();
        WebElement dropDownMenuOptions = driver.findElement(By.xpath("//div[@class='dropdown-menu show']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ZERO);
        wait.until(ExpectedConditions.visibilityOf(dropDownMenuOptions));
        WebElement option3 = driver.findElement(By.xpath("//a[contains(text(),'Option 3')]"));
        option3.click();
        String actualOptionValue = selectedOption.getText();
        Assert.assertEquals(expectedOptionValue,actualOptionValue);
        driver.close();
    }
}
