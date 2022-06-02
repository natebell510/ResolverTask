package com.ProjectName.pages;

import com.ProjectName.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage {
    public TestPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //store locators starting from top of the page
    @FindBy(xpath = "//a[@class='m_navbar-brand']")
    public WebElement testPageHeaderLink;

    @FindBy(xpath = "//button[@class='m_navbar-toggler']")
    public WebElement navBarToggler;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    public WebElement homeLink;

    @FindBy(xpath = "//a[contains(text(),'Guide')]")
    public WebElement guideLink;

    @FindBy(xpath = "//input[@id='m_inputEmail']")
    public WebElement emailAddressInputBox;

    @FindBy(xpath = "//input[@id='m_inputPassword']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    public WebElement signInButton;










}
