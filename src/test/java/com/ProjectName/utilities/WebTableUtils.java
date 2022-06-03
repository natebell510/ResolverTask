package com.ProjectName.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTableUtils {
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
            if (row > 0) {
                row=row+1;
                locator = "//table/tbody/tr[" + row + "]/td[" + column + "]";
            }
            WebElement cell = Driver.getDriver().findElement(By.xpath(locator));
            return cell.getText();
        } else{
            return "Incorrect row or column value given!\nColumn values are 0,1,2\nRow values are 0,1,2";
        }
    }
}
