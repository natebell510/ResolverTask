package com.ProjectName.step_definitions;

import com.ProjectName.pages.TestPage;
import com.ProjectName.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class test5_step_defs {
    TestPage testPage = new TestPage();

    @When("user should see a message {string}")
    public void user_should_see_a_message(String expectedMessage) {
        String actualMessage = testPage.textBeforeButtonDiv5.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("user waits for a button to be displayed and click on a button")
    public void user_waits_for_a_button_to_be_displayed_and_click_on_a_button() {
        BrowserUtils.waitForVisibility(testPage.buttonDiv5);
        testPage.buttonDiv5.click();
    }

    @When("user should see a message {string} after click")
    public void user_should_see_a_message_after_click(String expectedMessage) {
        String actualMessage = testPage.messageAfterClickDiv5.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("verify button div is disabled")
    public void verify_button_div_is_disabled() {
        Assert.assertFalse(testPage.buttonDiv5.isEnabled());
    }
}
