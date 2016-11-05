package com.wiley.selenium.common.components;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpToReceiveWileyUpdates {
    final WebDriver driver;

    @FindBy(id = "EmailAddress")
    WebElement inputField;

    @FindBy(xpath = ".//*[contains(@class,'homepage-sign-up-form-wrap')]//button")
    WebElement arrowButton;

    public SignUpToReceiveWileyUpdates(WebDriver driver) {
        this.driver = driver;
    }

    // <editor-fold defaultstate="collapsed" desc="inputField">
    public void assertThatInputFieldIsDisplayed() {
        Assert.assertTrue(inputField.isDisplayed());
    }

    public void sendTextIntoInputField(String text) {
        inputField.sendKeys(text);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="arrowButton">
    public void clickOnArrowButton() {
        arrowButton.click();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="alert">
    public void assertThatAlertIsDisplayed() {
        ExpectedConditions.alertIsPresent();
    }

    public void assertThatAlertHasSelectedMessage(String selectedMessage) {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), selectedMessage);
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    // </editor-fold>
}
