package com.ProjectName.standaloneTests;

import com.ProjectName.pages.TestPage;
import com.ProjectName.utilities.BrowserUtils;
import com.ProjectName.utilities.ConfigurationReader;
import com.ProjectName.utilities.Driver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class checkEnv {

    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    TestPage testPage = new TestPage();

    @Test
    public void test1() {
        //ConfigurationReader.getProperty("env")

        //
        testPage.emailAddressInputBox.sendKeys(TestPage.generateRandomEmailAddress());
        String requiredEmailField = testPage.emailAddressInputBox.getAttribute("required");
        System.out.println("requiredField = " + requiredEmailField);
        // text can not be located but attribute "required" is true
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        boolean emailRequired = (Boolean) js.executeScript("return arguments[0].required;", testPage.emailAddressInputBox);
        System.out.println("emailRequired = " + emailRequired);
        boolean passRequired = Boolean.parseBoolean(testPage.passwordInputBox.getAttribute("required"));
        System.out.println("passRequired = " + passRequired);
        Assert.assertTrue(testPage.emailAddressInputBox.isDisplayed());
        Assert.assertTrue(testPage.passwordInputBox.isDisplayed());
        Assert.assertTrue(testPage.signInButton.isDisplayed());
        Driver.getDriver().close();

    }

    @Test
    public void test2() {

        BrowserUtils.waitFor(3);
        BrowserUtils.scrollToElement(testPage.test2div);
        BrowserUtils.waitFor(3);
        System.out.println("testPage.listItem2span.getText() = " + testPage.listItem2span.getText());
        Driver.getDriver().close();


    }

    @Test
    public void test4() {


        String leftButtonColor = Driver.getDriver().
                findElement(By.xpath("//button[@class='btn btn-lg btn-primary']")).
                getCssValue("background-color");
        System.out.println("leftButtonColor = " + leftButtonColor);

        String rightButtonColor = Driver.getDriver().
                findElement(By.xpath("//button[@class='btn btn-lg btn-secondary']")).
                getCssValue("background-color");
        System.out.println("rightButtonColor = " + rightButtonColor);
    }
}
