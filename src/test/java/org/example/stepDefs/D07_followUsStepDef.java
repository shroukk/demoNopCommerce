package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {

    P03_homePage followus = new P03_homePage();
    @When("user opens facebook link")
    public void userOpensFacebookLink(){
        followus.socialMediaLink().get(0).click();

    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String arg0) throws InterruptedException {

        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        Hooks.driver.switchTo().window(tabs.get(1));

        System.out.println(Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());

        Assert.assertEquals(Hooks.driver.getCurrentUrl(),arg0);

    }

    @When("user opens twitter link")
    public void userOpensTwitterLink() {
        followus.socialMediaLink().get(1).click();

    }

    @When("user opens rss link")
    public void userOpensRssLink() {
        followus.socialMediaLink().get(2).click();

    }

    @When("user opens youtube link")
    public void userOpensYoutubeLink() {
        followus.socialMediaLink().get(3).click();

    }
}
