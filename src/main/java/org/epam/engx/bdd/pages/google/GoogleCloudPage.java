package org.epam.engx.bdd.pages.google;

import org.epam.engx.bdd.pages.browser.Page;
import org.epam.engx.bdd.pages.browser.PageConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class GoogleCloudPage extends Page {
    private static final String URL = "https://cloud.google.com/";

    @FindBy(name = "q")
    private WebElement searchInput;

    public GoogleCloudPage(WebDriver driver) {
        super(driver);
    }

    public PageConstructor<SearchResultPage> search(CharSequence term) {
        searchInput.click();
        searchInput.sendKeys(term);
        searchInput.submit();
        return SearchResultPage::new;
    }

    @Override
    public GoogleCloudPage to() {
        driver.get(URL);
        return this;
    }
}
