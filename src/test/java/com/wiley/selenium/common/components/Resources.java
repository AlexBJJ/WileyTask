package com.wiley.selenium.common.components;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Resources {
    final WebDriver driver;

    @FindBy(xpath = ".//*[@id='homepage-resources']//h2")
    WebElement resourcesSubHeader;

    @FindAll(@FindBy(xpath = ".//*[@id='homepage-resources']//h2" +
            "/following::li[contains(@class,'resource')]"))
    List<WebElement> allTheItemsUnderResourcesSubHeader;

    @FindBy(xpath = ".//*[@id='homepage-resources']//h2" +
            "/following::li[@class='resource-students']")
    WebElement studentsItem;

    public Resources(WebDriver driver) {
        this.driver = driver;
    }

    // <editor-fold defaultstate="collapsed" desc="allTheItemsUnderResourcesSubHeader">
    public void assertThatCountOfAllTheItemsUnderResourcesSubHeaderEqualsToSelectedNumber(int selectedNumber) {
        Assert.assertEquals(selectedNumber, allTheItemsUnderResourcesSubHeader.size());
    }

    public void assertThatTitlesOfAllTheItemsUnderResourcesSubHeaderEqualToSelectedList(List<String> selectedList) {
        for (int i = 0; i < selectedList.size(); i++) {
            Assert.assertEquals(selectedList.get(i), allTheItemsUnderResourcesSubHeader.get(i).getText());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="studentsItem">
    public void clickOnStudentsItem() {
        studentsItem.click();
    }
    // </editor-fold>
}
