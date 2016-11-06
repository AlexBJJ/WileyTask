package com.wiley.selenium.common.pages;

import com.wiley.selenium.common.components.TopNavigationMenu;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WileyedSolutions {
    final WebDriver driver;

    @FindBy(className = "productDetail-title")
    WebElement header;

    public WileyedSolutions(WebDriver driver) {
        this.driver = driver;
    }

//    private static final String URL = "http://wileyedsolutions.com";
    private static final String URL = "https://edservices.wiley.com/"; //redirected from http://wileyedsolutions.com

    // <editor-fold defaultstate="collapsed" desc="URL">
    public void assertThatURLIsOpened() {
        Assert.assertEquals(URL, driver.getCurrentUrl());
    }
    // </editor-fold>
}
