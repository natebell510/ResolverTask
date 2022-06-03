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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class divTest6 {
    /*
    steps to repeat:
       - set up Chrome driver
       - add implicit wait
       - maximize browser window
       - close WebDriver instance
     */
    @Test
    public void test6_001() {
        // find the value of the cell at coordinates 1, 1
        //set up Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //add implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser window
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement div6 = driver.findElement(By.xpath("//div[@id='test-6-div']"));
        //scroll to div 6
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", div6);
        //wait for table to be displayed
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(div6));
        //  user checks value at cell at row 1 column 1
        int expectedRow = 1;
        int expectedColumn = 1;
        String expectedCellValue = "Carswell";
        String actualCellValue = returnTableBodyCellValue(1, 1, driver);
        Assert.assertEquals(expectedCellValue, actualCellValue);
        driver.close();
    }

    @Test
    public void test6_002() {
        // Assert that the value of the cell is "Ventosanzap"
        //set up Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //add implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser window
        driver.manage().window().maximize();
        driver.get("C:\\Users\\nateb\\IdeaProjects\\ResolverTask\\TaskDocumentation\\QE-index.html");
        WebElement div6 = driver.findElement(By.xpath("//div[@id='test-6-div']"));
        //scroll to div 6
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", div6);
        //  user checks value at cell at row 2 column 2
        int expectedRow = 2;
        int expectedColumn = 2;
        String expectedCellValue = "Ventosanzap";
        String actualCellValue = returnTableBodyCellValue(2, 2, driver);
        Assert.assertEquals(expectedCellValue, actualCellValue);
        driver.close();
    }


    //locate table

    /**
     * method that allows you to find the ANY value of ANY cell on the grid
     *
     * @return any cell value
     * @params int column and  int row, WebDriver driver
     */
    public static String returnAnyTableCellValue(int row, int column, WebDriver driver) {
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
            WebElement cell = driver.findElement(By.xpath(locator));
            return cell.getText();
        } else {
            return "Incorrect row or column value given!\nColumn values are 0,1,2\nRow values are 0,1,2,3";
        }
    }

    /**
     * method that allows you to find the ANY value of ANY cell from table body without tables headers
     *
     * @return table body cell value
     * @params int column and  int row, WebDriver driver
     */
    public static String returnTableBodyCellValue(int row, int column, WebDriver driver) {
        String locator = "";
        if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {
            column = column + 1;

            row = row + 1;
            locator = "//table/tbody/tr[" + row + "]/td[" + column + "]";

            WebElement cell = driver.findElement(By.xpath(locator));
            return cell.getText();
        } else {
            return "Incorrect row or column value given!\nColumn values are 0,1,2\nRow values are 0,1,2";
        }
    }


}
