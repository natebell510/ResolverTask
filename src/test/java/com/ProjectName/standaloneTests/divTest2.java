package com.ProjectName.standaloneTests;

import com.ProjectName.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class divTest2 {
    /*
    steps to repeat:
       - set up Chrome driver
       - add implicit wait
       - maximize browser window
       - close WebDriver instance
     */
    @Test
    public void test2_001() {
        //verify div Test 2 has three values in list group
        int expectedListSize = 3;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement div2 = driver.findElement(By.xpath("//div[@id='test-2-div']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", div2);
        List<WebElement>listItems = driver.findElements(By.xpath("//ul[@class='list-group']/li"));
        int actualListSize = listItems.size();
        Assert.assertEquals(expectedListSize,actualListSize);
        driver.close();
    }

    @Test
    public void test2_002() {
        // Verify second list item's value is set to "List Item 2"
        String expectedListItemValue = "List Item 2";
        //set up Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //add implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser window
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement div2 = driver.findElement(By.xpath("//div[@id='test-2-div']"));
        //scroll to div 2
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", div2);
        WebElement secondListItem = driver.findElement(By.xpath("//ul[@class='list-group']/li[2]"));
        String actualListItemValue = secondListItem.getText();
        //getText() method picks up all text between tags <li>text</li>
        //substring badge number value
        actualListItemValue=actualListItemValue.substring(0,actualListItemValue.length()-2);
        Assert.assertEquals(expectedListItemValue,actualListItemValue);
        driver.close();
    }
    @Test
    public void test2_003() {
        // Verify second list item's badge is set to "6"
        int expectedListItemBadgeNum = 6;
        //set up Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //add implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser window
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement div2 = driver.findElement(By.xpath("//div[@id='test-2-div']"));
        //scroll to div 2
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", div2);
        WebElement secondListItemBadge = driver.findElement(By.xpath("//ul[@class='list-group']/li[2]/span"));
        int actualListItemBadgeNum = Integer.parseInt(secondListItemBadge.getText());
        Assert.assertEquals(expectedListItemBadgeNum,actualListItemBadgeNum);
        driver.close();
    }
}
