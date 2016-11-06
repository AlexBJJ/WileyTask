package com.wiley.selenium.common.pages;

import com.wiley.selenium.common.components.TopNavigationMenu;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class BookDetails {
    final WebDriver driver;
    public TopNavigationMenu topNavigationMenu;

    @FindBy(className = "productDetail-title")
    WebElement header;

    public BookDetails(WebDriver driver) {
        topNavigationMenu = PageFactory.initElements(driver, TopNavigationMenu.class);
        this.driver = driver;
    }

    // <editor-fold defaultstate="collapsed" desc="header">
    public void assertThatHeaderEqualsToSelectedHeader(String selectedHeader) {
        Assert.assertEquals(header.getText(), selectedHeader);
    }
    // </editor-fold>
}
