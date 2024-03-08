package ru.scooter.PageObject;

import org.openqa.selenium.WebDriver;

public class BaseCostract {
    protected WebDriver driver;

    public BaseCostract(WebDriver driver) {
        this.driver = driver;
    }
}
