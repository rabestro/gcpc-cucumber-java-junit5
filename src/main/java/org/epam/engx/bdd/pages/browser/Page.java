package org.epam.engx.bdd.pages.browser;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class Page extends PageFactory {
    protected final WebDriver driver;
    protected SearchContext searchContext;

    protected Page(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public Page to() {
        return this;
    }

    protected void setSearchContext(SearchContext context) {
        searchContext = context;
    }
}
