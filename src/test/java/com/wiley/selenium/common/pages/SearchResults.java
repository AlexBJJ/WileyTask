package com.wiley.selenium.common.pages;

import com.wiley.selenium.common.components.TopNavigationMenu;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SearchResults {
    final WebDriver driver;
    public TopNavigationMenu topNavigationMenu;

    @FindBy(id = "search-results")
    WebElement searchResultsContainer;

    @FindAll(@FindBy(xpath = ".//*[@class='product-title']/a"))
    List<WebElement> allTheSearchResultsTitles;

    public SearchResults(WebDriver driver) {
        topNavigationMenu = PageFactory.initElements(driver, TopNavigationMenu.class);
        this.driver = driver;
    }

    // <editor-fold defaultstate="collapsed" desc="searchResultsContainer">
    public void assertThatSearchResultsContainerIsDisplayed() {
        Assert.assertTrue(searchResultsContainer.isDisplayed());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="allTheSearchResultsTitles">
    public Integer getNumberOfRandomSearchResult() {
        return new Random().nextInt(allTheSearchResultsTitles.size());
    }

    public String getTitleTextOfSearchResultWithSelectedNumber(Integer selectedNumber) {
        return allTheSearchResultsTitles.get(selectedNumber).getText();
    }

    public void clickOnSearchResultWithSelectedNumber(Integer selectedNumber) {
        WebElement searchResult = allTheSearchResultsTitles.get(selectedNumber);
        searchResult.click();
    }
    // </editor-fold>
}
