package com.ProjectName.step_definitions;

import com.ProjectName.pages.TestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class test3_step_defs {
    TestPage testPage = new TestPage();
    @Then("verify that {string} is selected by default")
    public void verify_that_is_selected_by_default(String expectedOption) {
       String actualOption = testPage.dropDownMenuButton.getText();
        Assert.assertEquals(expectedOption,actualOption);
    }
    @Given("user clicks on {string} to get options")
    public void user_clicks_on_to_get_options(String optionToChoose) {
        testPage.dropDownMenuButton.click();
    }
    @Given("from dropdown menu user clicks on {string}")
    public void from_dropdown_menu_user_clicks_on(String option3) {
        TestPage.chooseDropDownOptionAndClick(option3);
    }
    @Then("verify that {string} is selected")
    public void verify_that_is_selected(String expectedOption) {
       String actualOption = testPage.dropDownMenuButton.getText();
       Assert.assertEquals(expectedOption,actualOption);
    }
}
