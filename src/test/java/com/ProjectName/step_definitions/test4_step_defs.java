package com.ProjectName.step_definitions;

import com.ProjectName.pages.TestPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class test4_step_defs {
    TestPage testPage = new TestPage();

    @Then("verify button is enabled")
    public void verify_button_is_enabled() {
        Assert.assertTrue(testPage.leftButtonDiv4.isEnabled());
    }

    @Then("rgb color value is {string} Blue")
    public void rgb_color_value_is_blue(String expectedRgbValue) {
        String actualRgbValue = testPage.leftButtonDiv4.getCssValue("background-color");
        Assert.assertEquals(expectedRgbValue, actualRgbValue);
    }

    @Then("verify button is disabled")
    public void verify_button_is_disabled() {
        Assert.assertFalse(testPage.rightButtonDiv4.isEnabled());
    }

    @And("rgb color value is {string} Grey")
    public void rgbColorValueIsGrey(String expectedRgbValue) {
        String actualRgbValue = testPage.rightButtonDiv4.getCssValue("background-color");
        Assert.assertEquals(expectedRgbValue, actualRgbValue);
    }
}
