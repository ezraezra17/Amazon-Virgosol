package com.virgosol.pages;

import com.virgosol.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateListPage extends BasePage {



    @FindBy(id="list-name")
    public WebElement listNameInputBox;

    @FindBy(xpath = "(//span[@class='nav-icon nav-arrow'])[1]")
    public WebElement accountAndListTab;


    @FindBy(xpath="//span[.='Liste Oluşturun']")
    public WebElement createList;

    @FindBy(xpath="(//span[.='Liste Oluştur'])[1]")
    public WebElement createListSubmitButton;

    @FindBy(xpath="//span[@id='profile-list-name']")
    public WebElement listNameCheck;







}
