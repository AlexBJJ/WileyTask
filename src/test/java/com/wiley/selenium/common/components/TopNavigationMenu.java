package com.wiley.selenium.common.components;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigationMenu {
    final WebDriver driver;

    @FindBy(xpath = ".//*[@id='links-site']//a[text()='Home']")
    WebElement home;

    @FindBy(xpath = ".//*[@id='links-site']//a[text()='Subjects']")
    WebElement subjects;

    @FindBy(xpath = ".//*[@id='links-site']//a[text()='About Wiley']")
    WebElement aboutWiley;

    @FindBy(xpath = ".//*[@id='links-site']//a[text()='Contact Us']")
    WebElement contactUs;

    @FindBy(xpath = ".//*[@id='links-site']//a[text()='Help']")
    WebElement help;

    @FindBy(id = "query")
    WebElement searchInputField;

    @FindBy(className = "icon__search")
    WebElement searchIcon;

    public TopNavigationMenu(WebDriver driver) {
        this.driver = driver;
    }

    // <editor-fold defaultstate="collapsed" desc="home">
    public void assertThatHomeIsDisplayed() {
        Assert.assertTrue(home.isDisplayed());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="subjects">
    public void assertThatSubjectsIsDisplayed() {
        Assert.assertTrue(subjects.isDisplayed());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="aboutWiley">
    public void assertThatAboutWileyIsDisplayed() {
        Assert.assertTrue(aboutWiley.isDisplayed());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="contactUs">
    public void assertThatContactUsIsDisplayed() {
        Assert.assertTrue(contactUs.isDisplayed());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="help">
    public void assertThatHelpIsDisplayed() {
        Assert.assertTrue(help.isDisplayed());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="home">
    public void clickOnHome() {
        home.click();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="searchInputField">
    public void sendTextIntoSerchInputField(String text) {
        searchInputField.sendKeys(text);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="searchIcon">
    public void clickOnSearchIcon() {
        searchIcon.click();
    }
    // </editor-fold>
}
