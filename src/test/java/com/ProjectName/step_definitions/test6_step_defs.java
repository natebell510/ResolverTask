package com.ProjectName.step_definitions;

import com.ProjectName.pages.TestPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class test6_step_defs {
    String actualCellValue;
    @When("user checks value at cell at row {int} column {int}")
    public void user_checks_value_at_cell_at_row_column(int row, int column) {
        actualCellValue = TestPage.returnTableBodyCellValue(row,column);
    }
    @Then("cell value is {string}")
    public void cell_value_is(String expectedCellValue) {
        Assert.assertEquals(expectedCellValue,actualCellValue);
    }
}
