package org.epam.engx.bdd.pages.google;

import org.epam.engx.bdd.pages.browser.Page;
import org.epam.engx.bdd.pages.model.Link;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public final class SearchResultPage extends Page {
    @FindBy(css = "div.gs-webResult div.gsc-thumbnail-inside a.gs-title")
    private List<WebElement> results;

    @FindBy(css = "a:first-child > b")
    private WebElement firstResultLink;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<Link> links() {
        return results.stream().map(Link::new).toList();
    }

    public void clickFirstLink() {
        firstResultLink.click();
    }
}
