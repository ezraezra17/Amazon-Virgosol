package com.virgosol.tests;
import com.virgosol.pages.CreateListPage;
import com.virgosol.utilities.ConfigurationReader;
import com.virgosol.utilities.Driver;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;



public class CreateListTest {

    CreateListPage list = new CreateListPage();
    Actions action = new Actions(Driver.getDriver());

    @DisplayName("user creates a new List")
    @Test
    public void test1() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        list.waitSeconds(3);
        list.cookies();
        list.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        action.moveToElement(list.accountAndListTab).build().perform();
        list.createList.click();
        list.listNameInputBox.clear();
        list.listNameInputBox.sendKeys("Virgosol Liste");
        list.createListSubmitButton.click();
        System.out.println("list.listNameCheck.getText() = " + list.listNameCheck.getText());
        assertEquals("Virgosol Liste",list.listNameCheck.getText());


    }



}
