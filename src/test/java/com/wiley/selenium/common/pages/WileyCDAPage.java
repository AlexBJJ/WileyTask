package com.wiley.selenium.common.pages;

import com.wiley.selenium.common.components.Resources;
import com.wiley.selenium.common.components.SignUpToReceiveWileyUpdates;
import com.wiley.selenium.common.components.TopNavigationMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WileyCDAPage {
    final WebDriver driver;
    public TopNavigationMenu topNavigationMenu;
    public Resources resources;
    public SignUpToReceiveWileyUpdates signUpToReceiveWileyUpdates;

    public WileyCDAPage(WebDriver driver) {
        topNavigationMenu = PageFactory.initElements(driver, TopNavigationMenu.class);
        resources = PageFactory.initElements(driver, Resources.class);
        signUpToReceiveWileyUpdates = PageFactory.initElements(driver, SignUpToReceiveWileyUpdates.class);
        this.driver = driver;
    }

    private static final String URL = "http://www.wiley.com/WileyCDA/";

    // <editor-fold defaultstate="collapsed" desc="URL">
    public void openPage() {
        driver.get(URL);
    }
    // </editor-fold>
}
