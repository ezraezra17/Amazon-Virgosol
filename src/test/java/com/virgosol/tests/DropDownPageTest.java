package com.virgosol.tests;

import com.virgosol.pages.CreateListPage;
import com.virgosol.pages.DropdownPage;
import com.virgosol.utilities.ConfigurationReader;
import com.virgosol.utilities.Driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropDownPageTest {

    DropdownPage dropDown = new DropdownPage();
    CreateListPage list = new CreateListPage();
    Actions action = new Actions(Driver.getDriver());


    @DisplayName("user selects Bilgisayarlar from Dropdown Menu ")
    @Test
    public void test1() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        dropDown.cookies();
        dropDown.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));

        Select select = new Select(dropDown.selectDropdown);
        select.selectByVisibleText("Bilgisayarlar");
        assertEquals("Bilgisayarlar", select.getFirstSelectedOption().getText(), "Bilgisayarlar was not selected as a category");

        dropDown.searchBox.click();
        dropDown.searchBox.sendKeys("msi" + Keys.ENTER);

        assertEquals("\"msi\"", dropDown.searchResult.getText());
        dropDown.waitSeconds(3);
        dropDown.openPage(2).click();

        assertTrue(Driver.getDriver().getCurrentUrl().contains("pg_2"));
        dropDown.secondProduct.click();
        dropDown.listAddButton.click();
        dropDown.waitSeconds(3);
        dropDown.listItem.click();
        dropDown.waitSeconds(3);
        dropDown.inspectYourLinkButton.click();
        assertEquals("Soğutma Fanı, CPU Soğutma Fanı MSI GS63VR için Mükemmel İşçilik MSI GS73VR için MSI 16K4",


                dropDown.listItemCheck.getText());

    }

    @Test
    @DisplayName("Deleting Product from Virgosol List")
    public void test2() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        dropDown.cookies();
        dropDown.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        action.moveToElement(list.accountAndListTab).build().perform();
        dropDown.showMoreInfoLink.click();
        dropDown.waitSeconds(3);
        dropDown.deleteListButton.click();

        try {
            assertFalse(dropDown.secondProduct.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.err.println("Product was deleted from the page");
        }

        action.moveToElement(list.accountAndListTab).build().perform();
        dropDown.signOutButton.click();
        assertEquals("Amazon Giriş Yap", Driver.getDriver().getTitle());



    }
}



