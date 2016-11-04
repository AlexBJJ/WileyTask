package com.wiley.selenium.common.pages;

import com.wiley.selenium.common.components.ResourcesForMenu;
import com.wiley.selenium.common.components.TopNavigationMenu;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Students {
    final WebDriver driver;
    public TopNavigationMenu topNavigationMenu;
    public ResourcesForMenu resourcesForMenu;

    @FindBy(xpath = ".//*[@id='page-title'][h1[text()='Students']]")
    WebElement pageTitle;

    public Students(WebDriver driver) {
        topNavigationMenu = PageFactory.initElements(driver, TopNavigationMenu.class);
        resourcesForMenu = PageFactory.initElements(driver, ResourcesForMenu.class);
        this.driver = driver;
    }

    private static final String URL = "http://www.wiley.com/WileyCDA/Section/id-404702.html";

    // <editor-fold defaultstate="collapsed" desc="URL">
    public void assertThatURLIsOpened() {
        Assert.assertEquals(URL, driver.getCurrentUrl());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="pageTitle">
    public void assertThatPageTitleIsDisplayed() {
        Assert.assertTrue(pageTitle.isDisplayed());
    }
    // </editor-fold>
}
