package com.virgosol.tests;

import com.virgosol.pages.BasePage;
import com.virgosol.pages.CreateListPage;
import com.virgosol.pages.AddProductToWishList;
import com.virgosol.utilities.ConfigurationReader;
import com.virgosol.utilities.Driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class AmazonTest extends BasePage {
    CreateListPage list = new CreateListPage();
    Actions action = new Actions(Driver.getDriver());
    AddProductToWishList add = new AddProductToWishList();


    @DisplayName("LandingPage Test")
    @Test
    @Order(1)
    public void homePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        assertEquals("https://www.amazon.com.tr/",Driver.getDriver().getCurrentUrl(), "title is not displayed");
        cookies();

    }

    @DisplayName("user Signs In")
    @Test
    @Order(2)
    public void signIn() {

        login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        assertTrue(signInCheck.getText().contains("esra"));

    }


    @DisplayName("user creates a new List")
    @Test
    @Order(3)
    public void createList() {
         waitSeconds(3);
        action.moveToElement(list.accountAndListTab).build().perform();
        list.createList.click();
        list.listNameInputBox.clear();
        list.listNameInputBox.sendKeys("Virgosol Liste");
        list.createListSubmitButton.click();
        System.out.println("list.listNameCheck.getText() = " + list.listNameCheck.getText());
        assertEquals("Virgosol Liste", list.listNameCheck.getText());


    }

    @DisplayName("User selects Bilgisayarlar from Dropdown Menu and then deletes the product")
    @Test
    @Order(4)
    public void AddProductToWishList() {
        Driver.getDriver().navigate().refresh();
        Select select = new Select(add.selectDropdown);
        select.selectByVisibleText("Bilgisayarlar");
        assertEquals("Bilgisayarlar", select.getFirstSelectedOption().getText(), "Bilgisayarlar was not selected as a category");
        add.searchBox.click();
        add.searchBox.sendKeys("msi" + Keys.ENTER);
        assertEquals("\"msi\"", add.searchResult.getText());
        waitSeconds(3);
        add.openPage(2).click();
        assertTrue(Driver.getDriver().getCurrentUrl().contains("pg_2"));
        add.secondProduct.click();
        add.listAddButton.click();
        waitSeconds(3);
        add.listItem.click();
        waitSeconds(3);
        add.inspectYourLinkButton.click();
        assertTrue(add.listItemCheck.isDisplayed());
        add.deleteListButton.click();

        try {
            assertFalse(add.secondProduct.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.err.println("Product was deleted from the page");
        }
    }


    @DisplayName("User signs out ")
    @Test
    @Order(5)
    public void SignOut() {
        waitSeconds(20);
        action.moveToElement(list.accountAndListTab).build().perform();
        add.signOutButton.click();
        assertEquals("Amazon Giriş Yap", Driver.getDriver().getTitle());

    }


}
