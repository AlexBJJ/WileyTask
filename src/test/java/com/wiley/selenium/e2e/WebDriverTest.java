package com.wiley.selenium.e2e;

import com.wiley.selenium.common.pages.Students;
import com.wiley.selenium.common.pages.WileyCDAPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverTest {
    static WebDriver driver;

    WileyCDAPage wileyCDAPage;
    Students students;

    private int expectedCountOfAllTheItemsUnderResourcesSubHeader = 9;
    private List<String> expectedTitlesOfAllTheItemsUnderResourcesSubHeader = Arrays.asList("Students",
            "Authors", "Instructors", "Librarians", "Societies", "Conferences", "Booksellers", "Corporations", "Institutions");

    private int expectedCountOfAllTheItemsInTheResourcesForMenu = 8;
    private List<String> expectedTitlesOfAllTheItemsInTheResourcesForMenu= Arrays.asList("Authors",
     "Librarians", "Booksellers", "Instructors", "Students", "Government Employees", "Societies", "Corporate Partners");

    private String emptyEmailAlertMessage = "Please enter email address";
    private String invalidEmailAlertMessage = "Invalid email address.";
    private String invalidEmail = "putinmail.ru";

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        wileyCDAPage = PageFactory.initElements(driver, WileyCDAPage.class);
        students = PageFactory.initElements(driver, Students.class);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void verifySearch() {
        wileyCDAPage.openPage();
        wileyCDAPage.topNavigationMenu.assertThatHomeIsDisplayed();
        wileyCDAPage.topNavigationMenu.assertThatSubjectsIsDisplayed();
        wileyCDAPage.topNavigationMenu.assertThatAboutWileyIsDisplayed();
        wileyCDAPage.topNavigationMenu.assertThatContactUsIsDisplayed();
        wileyCDAPage.topNavigationMenu.assertThatHelpIsDisplayed();
        wileyCDAPage.resources.assertThatCountOfAllTheItemsUnderResourcesSubHeaderEqualsToSelectedNumber(expectedCountOfAllTheItemsUnderResourcesSubHeader);
        wileyCDAPage.resources.assertThatTitlesOfAllTheItemsUnderResourcesSubHeaderEqualToSelectedList(expectedTitlesOfAllTheItemsUnderResourcesSubHeader);
        wileyCDAPage.resources.clickOnStudentsItem();
        students.assertThatURLIsOpened();
        students.assertThatPageTitleIsDisplayed();
        students.resourcesForMenu.assertThatCountOfAllTheItemsEqualsToSelectedNumber(expectedCountOfAllTheItemsInTheResourcesForMenu);
        students.resourcesForMenu.assertThatTitlesOfAllTheItemsEqualToSelectedList(expectedTitlesOfAllTheItemsInTheResourcesForMenu);
        students.resourcesForMenu.assertThatStudentsItemIsSelected();
        students.topNavigationMenu.clickOnHome();
        wileyCDAPage.signUpToReceiveWileyUpdates.assertThatInputFieldIsDisplayed();
        wileyCDAPage.signUpToReceiveWileyUpdates.clickOnArrowButton();
        wileyCDAPage.signUpToReceiveWileyUpdates.assertThatAlertIsDisplayed();
        wileyCDAPage.signUpToReceiveWileyUpdates.assertThatAlertHasSelectedMessage(emptyEmailAlertMessage);
        wileyCDAPage.signUpToReceiveWileyUpdates.acceptAlert();
        wileyCDAPage.signUpToReceiveWileyUpdates.sendTextIntoInputField(invalidEmail);
        wileyCDAPage.signUpToReceiveWileyUpdates.clickOnArrowButton();
        wileyCDAPage.signUpToReceiveWileyUpdates.assertThatAlertIsDisplayed();
        wileyCDAPage.signUpToReceiveWileyUpdates.assertThatAlertHasSelectedMessage(invalidEmailAlertMessage);
        wileyCDAPage.signUpToReceiveWileyUpdates.acceptAlert();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}