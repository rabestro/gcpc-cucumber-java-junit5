package com.epam.engx.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.epam.engx.bdd.pages.browser.Browser;
import org.epam.engx.bdd.pages.google.GoogleCloudPage;
import org.epam.engx.bdd.pages.google.SearchResultPage;

import static org.assertj.core.api.BDDAssertions.then;

public class GoogleSearchSteps {
    private Browser browser;
    private GoogleCloudPage googleCloud;
    private String term;
    private SearchResultPage searchResultPage;

    @Before
    public void initialization() {
        browser = Browser.create();
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Given("I have already opened the Google Cloud page")
    public void iHaveAlreadyOpenedTheGoogleCloudPage() {
        googleCloud = browser.go(GoogleCloudPage::new);
    }

    @Given("I type a {string} in the search field")
    public void termInTheSearchField(String term) {
        this.term = term;
    }

    @When("I press the button to search")
    public void wePressTheButtonToSearch() {
        searchResultPage = browser.go(googleCloud.search(term));
    }

    @Then("I find a link {string} in the search results")
    public void theSearchResultsHave(String linkName) {
        then(searchResultPage.links())
                .as("Search results for %s", term)
                .isNotEmpty()
                .extracting("text")
                .contains(linkName);
    }

}
