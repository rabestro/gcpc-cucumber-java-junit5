package org.epam.engx.bdd.pages.browser;

import org.openqa.selenium.WebDriver;

import java.util.function.Function;

@FunctionalInterface
public interface PageConstructor<T extends Page> extends Function<WebDriver, T> {
}
