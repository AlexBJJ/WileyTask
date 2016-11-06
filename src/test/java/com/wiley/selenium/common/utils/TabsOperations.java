package com.wiley.selenium.common.utils;

import com.wiley.selenium.common.components.TopNavigationMenu;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabsOperations {
    final WebDriver driver;

    public TabsOperations(WebDriver driver) {
        this.driver = driver;
    }

    // <editor-fold defaultstate="collapsed" desc="switchBetweenTabs">
    public void switchToLastTab() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
    // </editor-fold>
}
