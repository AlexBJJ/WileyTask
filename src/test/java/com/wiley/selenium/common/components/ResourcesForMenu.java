package com.wiley.selenium.common.components;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResourcesForMenu {
    final WebDriver driver;

    @FindAll(@FindBy(xpath = ".//*[text()='Resources For']" +
            "/following::ul[@class='autonavLevel1']/li[contains(@class,'active autonavItem')]/span" +
            "|.//*[text()='Resources For']/following::ul[@class='autonavLevel1']/li[@class='autonavItem']"))
    List<WebElement> allTheItems;

    @FindBy(xpath = ".//*[text()='Resources For']" +
            "/following::ul[@class='autonavLevel1']/li[contains(@class,'autonavItem')]/*[text()='Students']")
    WebElement studentsItem;

    public ResourcesForMenu(WebDriver driver) {
        this.driver = driver;
    }

    // <editor-fold defaultstate="collapsed" desc="allTheItems">
    public void assertThatCountOfAllTheItemsEqualsToSelectedNumber(int selectedNumber) {
        Assert.assertEquals(selectedNumber, allTheItems.size());
    }

    public void assertThatTitlesOfAllTheItemsEqualToSelectedList(List<String> selectedList) {
        for (int i = 0; i < selectedList.size(); i++) {
            Assert.assertEquals(selectedList.get(i), allTheItems.get(i).getText());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="studentsItem">
    public void assertThatStudentsItemIsSelected() {
        Assert.assertTrue(studentsItem.getAttribute("tagName").equals("SPAN")); //selected item has SPAN tagName instead of A as unselected have
//        Assert.assertFalse(studentsItem.isEnabled());
//             Each element which is displayed and which we can click by mouse is clickable
//             and because of that requirement:
//             "5.	Check “Students” item is selected
//                    -	“Students” item is not clickable" is invalid
    }
    // </editor-fold>
}
