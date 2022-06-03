package com.ProjectName.step_definitions;

import com.ProjectName.pages.TestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class test2_step_defs {
    TestPage testPage = new TestPage();

    @Given("user scrolls into view of Test {int} div")
    public void user_scrolls_into_view_of_test_div(Integer divNum) {
        TestPage.scrollToTestDiv(divNum);
    }

    @Then("verify List Item {int} {int} {int} are displayed")
    public void verify_list_item_are_displayed(Integer listItem1, Integer listItem2, Integer listItem3) {
        Assert.assertTrue(TestPage.listItemIsDisplayed(listItem1));
        Assert.assertTrue(TestPage.listItemIsDisplayed(listItem2));
        Assert.assertTrue(TestPage.listItemIsDisplayed(listItem3));
    }

    @Then("verify {string} list item value is {string}")
    public void verifyListItemValueIs(String listItemNumber, String expectedValue) {
        String actualValue = TestPage.returnListItemValue(listItemNumber);
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Then("verify {string} list item badge is {int}")
    public void verify_list_item_badge_is(String listItemNumber, Integer expectedBadgeNum) {
        Integer actualBadgeNum = TestPage.returnListItemBadgeNum(listItemNumber);
        Assert.assertEquals(expectedBadgeNum, actualBadgeNum);
    }
}
