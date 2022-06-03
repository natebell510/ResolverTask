package com.ProjectName.standaloneTests;

import com.ProjectName.utilities.ConfigurationReader;
import com.ProjectName.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class divTest1 {

    /*
    steps to repeat:
       - set up Chrome driver
       - add implicit wait
       - maximize browser window
       - close WebDriver instance
     */

    @Test
    public void test1_001() {
        //verify valid title of the page
        //set up Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //add implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser window
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        String expectedTitle = "Home";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //close WebDriver instance
        driver.close();
    }

    @Test
    public void test1_002() {
        //verify elements are displayed
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement emailAddressInputBox = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@id='inputPassword']"));
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        Assert.assertTrue(emailAddressInputBox.isDisplayed());
        Assert.assertTrue(passwordInputBox.isDisplayed());
        Assert.assertTrue(signInButton.isDisplayed());
        driver.close();
    }

    @Test
    public void test1_003() {
        //verify valid email and valid password, email input box autofocused
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement emailAddressInputBox = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@id='inputPassword']"));
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        String email = "*@*.*";
        String password = "*";
        emailAddressInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        signInButton.click();
        String isAutofocused = emailAddressInputBox.getAttribute("autofocus");
        Assert.assertTrue(Boolean.valueOf(isAutofocused));
        driver.close();
    }

    @Test
    public void test1_004() {
        //verify valid email and invalid password
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement emailAddressInputBox = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@id='inputPassword']"));
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        String email = "*@*.*";
        String password = "";
        emailAddressInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        signInButton.click();
        String isRequired = passwordInputBox.getAttribute("required");
        Assert.assertTrue(Boolean.valueOf(isRequired));
        driver.close();
    }

    @Test
    public void test1_005() {
        //verify invalid email and invalid password
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement emailAddressInputBox = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@id='inputPassword']"));
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        String email = "";
        String password = "";
        emailAddressInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        signInButton.click();
        String isRequiredEmail = emailAddressInputBox.getAttribute("required");
        Assert.assertTrue(Boolean.valueOf(isRequiredEmail));
        String isRequiredPassword = passwordInputBox.getAttribute("required");
        Assert.assertTrue(Boolean.valueOf(isRequiredPassword));
        driver.close();
    }


}
