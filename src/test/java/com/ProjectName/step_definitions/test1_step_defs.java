package com.ProjectName.step_definitions;

import com.ProjectName.pages.TestPage;
import com.ProjectName.utilities.ConfigurationReader;
import com.ProjectName.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.math3.stat.interval.ConfidenceInterval;
import org.junit.Assert;

public class test1_step_defs {
    TestPage testPage = new TestPage();

    @Given("user is on a home page")
    public void user_is_on_a_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @Then("verify title of the page is {string}")
    public void verify_title_of_the_page_is(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("verify input box Email address is Displayed")
    public void verify_input_box_email_address_is_displayed() {
        Assert.assertTrue(testPage.emailAddressInputBox.isDisplayed());
    }

    @Then("verify input box Password is Displayed")
    public void verify_input_box_password_is_displayed() {
        Assert.assertTrue(testPage.passwordInputBox.isDisplayed());
    }

    @Then("verify Sign in button is Displayed")
    public void verify_sign_in_button_is_displayed() {
        Assert.assertTrue(testPage.signInButton.isDisplayed());
    }

    @When("user enters valid email in format: {string}")
    public void user_enters_valid_email_in_format(String emailAddress) {
        emailAddress = TestPage.generateRandomEmailAddress();
        testPage.emailAddressInputBox.sendKeys(emailAddress);
    }

    @When("user enter valid {string} as any combination of letters and digits")
    public void user_enter_valid_as_any_combination_of_letters_and_digits(String password) {
        password = TestPage.generateRandomPassword();
        testPage.passwordInputBox.sendKeys(password);
    }
    @Then("No error message is displayed")
    public void no_error_message_is_displayed() {
        //after successful login - email input box is autofocused and highlighted
        String isAutofocused = testPage.emailAddressInputBox.getAttribute("autofocus");
        Assert.assertTrue(Boolean.valueOf(isAutofocused));
    }
    @When("user leaves password box empty")
    public void user_leaves_password_box_empty() {
        testPage.passwordInputBox.sendKeys("");
    }
    @Then("input boxes can not be empty")
    public void input_boxes_can_not_be_empty() {
        //password input box has attribute "required" -  shows a message "Please fill out this field."
        String isRequired = testPage.passwordInputBox.getAttribute("required");
        Assert.assertTrue(Boolean.valueOf(isRequired));
    }
    @When("user leaves email box empty")
    public void user_leaves_email_box_empty() {
        testPage.emailAddressInputBox.sendKeys("");
    }
    @When("user clicks Sign in button")
    public void user_clicks_sign_in_button() {
        testPage.signInButton.click();
    }

}
