package com.ProjectName.pages;

import com.ProjectName.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class TestPage {
    public TestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //store locators starting from top of the page
    //Test 1
    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement testPageHeaderLink;

    @FindBy(xpath = "//button[@class='m_navbar-toggler']")
    public WebElement navBarToggler;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    public WebElement homeLink;

    @FindBy(xpath = "//a[contains(text(),'Guide')]")
    public WebElement guideLink;

    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement emailAddressInputBox;

    @FindBy(xpath = "//input[@id='inputPassword']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    public WebElement signInButton;

    public static String generateRandomEmailAddress() {
        return new Faker().internet().emailAddress();
    }

    public static String generateRandomPassword() {
        return new Faker().internet().password();
    }

    /**
     * method scrollToTestDiv will scroll to given div
     * pass number of Test Div to int divNum
     */
    public static void scrollToTestDiv(int divNum) {
        String divLocator = "//div[@id='test-" + divNum + "-div']";
        WebElement div = Driver.getDriver().findElement(By.xpath(divLocator));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", div);
    }

    //Test 2

    @FindBy(xpath = "//div[@id='test-2-div']")
    public WebElement test2div;
    // locator for List Item 1,2,3 - reruns List<WebElement> and actual size
    @FindBy(xpath = "//ul[@class='list-group']/li")
    public List<WebElement> listOfItems;
    //locator for List Item 2 and getText() of list item
    @FindBy(xpath = "//ul[@class='list-group']/li[2]")
    public WebElement listItem2;
    //locator for List Item 2 and getText() between span tags
    @FindBy(xpath = "//ul[@class='list-group']/li[2]/span")
    public WebElement listItem2span;

    /**
     * @param listItemNum
     * @return boolean isDisplayed = WebElement.isDisplayed();
     */
    public static boolean listItemIsDisplayed(int listItemNum) {
        String listItemLocator = "//ul[@class='list-group']/li[" + listItemNum + "]";
        WebElement listItem = Driver.getDriver().findElement(By.xpath(listItemLocator));
        return listItem.isDisplayed();
    }

    /**
     * @param listItemNum - text for List Item
     * @return String textValueOfItem = WebElement.getText();
     */
    public static String returnListItemValue(String listItemNum) {
        int num = 0;
        if (listItemNum.equalsIgnoreCase("first")) {
            num = 1;
        } else if (listItemNum.equalsIgnoreCase("second")) {
            num = 2;
        } else if (listItemNum.equalsIgnoreCase("third")) {
            num = 3;
        }
        String listItemLocator = "//ul[@class='list-group']/li[" + num + "]";
        WebElement listItem = Driver.getDriver().findElement(By.xpath(listItemLocator));
        return listItem.getText().substring(0,listItem.getText().length()-2);
    }

    /**
     * @param listItemNum - text for List Item
     * @return int valueOfBadge = Integer.parseInt(WebElement.getText());
     */

    public static int returnListItemBadgeNum(String listItemNum) {
        int num = 0;
        if (listItemNum.equalsIgnoreCase("first")) {
            num = 1;
        } else if (listItemNum.equalsIgnoreCase("second")) {
            num = 2;
        } else if (listItemNum.equalsIgnoreCase("third")) {
            num = 3;
        }
        String listItemBadgeLocator = "//ul[@class='list-group']/li[" + num + "]/span";
        WebElement listItemBadge = Driver.getDriver().findElement(By.xpath(listItemBadgeLocator));
        return Integer.parseInt(listItemBadge.getText());
    }

    // Test 3
    // getText() to see currently selected Option
    @FindBy(xpath = "//button[@id='dropdownMenuButton']")
    public WebElement dropDownMenuButton;
    // locator to get Options
    @FindBy(xpath = "//div[@class='dropdown-menu show']")
    public WebElement dropDownMenuOptions;

    @FindBy(xpath = "//a[contains(text(),'Option 1')]")
    public WebElement dropDownOption1;
    /**
     * @param optionValue
     * @return clicks on chosen option
     */
    public static void chooseDropDownOptionAndClick(String optionValue) {
        String locator = "//a[contains(text(),'" + optionValue + "')]";
        WebElement optionItem = Driver.getDriver().findElement(By.xpath(locator));
        optionItem.click();
    }

    // Test 4
    // enabled button, getCssValue() for color
    @FindBy(xpath = "//div[@id='test-4-div']/button[@class='btn btn-lg btn-primary']")
    public WebElement leftButtonDiv4;
    //disabled button, use getAttribute("disabled"); and getCssValue() color
    @FindBy(xpath = "//div[@id='test-4-div']/button[@class='btn btn-lg btn-secondary']")
    public WebElement rightButtonDiv4;

    // Test 5
    //use getText() to extract message
    @FindBy(xpath = "//p[@id='test5-placeholder']")
    public WebElement textBeforeButtonDiv5;

    //use Explicit Wait for button to be Visible or Clickable
    @FindBy(xpath = "//button[@id='test5-button']")
    public WebElement buttonDiv5;

    //use getText() to extract message
    @FindBy(xpath = "//div[@id='test5-alert']")
    public WebElement messageAfterClickDiv5;

    //Test 6
    //locate table
    /**
     * method that allows you to find the ANY value of ANY cell on the grid
     *
     * @return cell value
     * @params column and  row
     */
    public static String returnAnyTableCellValue(int row, int column) {
        String locator = "";
        if (row >= 0 && row <= 3 && column >= 0 && column <= 2) {
            column = column + 1;
            // restricted add incorrect row or incorrect column
            if (row == 0) {
                locator = "//table/thead/tr/th[" + column + "]";
            } else if (row > 0) {
                //column=column+1;
                locator = "//table/tbody/tr[" + row + "]/td[" + column + "]";
            }
            WebElement cell = Driver.getDriver().findElement(By.xpath(locator));
            return cell.getText();
        } else{
            return "Incorrect row or column value given!\nColumn values are 0,1,2\nRow values are 0,1,2,3";
        }
    }

    /**
     * method that allows you to find the ANY value of ANY cell from table body without tables headers
     * @return table body cell value
     * @params column and row
     */
    public static String returnTableBodyCellValue(int row, int column) {
        String locator = "";
        if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {
            column = column + 1;

                row=row+1;
                locator = "//table/tbody/tr[" + row + "]/td[" + column + "]";

            WebElement cell = Driver.getDriver().findElement(By.xpath(locator));
            return cell.getText();
        } else{
            return "Incorrect row or column value given!\nColumn values are 0,1,2\nRow values are 0,1,2";
        }
    }


}
