package com.virgosol.pages;

import com.virgosol.log.TestResultLogger;
import com.virgosol.utilities.Driver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)
public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(id = "ap_email")
    public WebElement addEmail;

    @FindBy(id = "continue")
    public WebElement emailsubmitButton;


    @FindBy(id = "ap_password")
    public WebElement passwordInputBox;

    @FindBy(id = "signInSubmit")
    public WebElement passwordSubmitButton;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement signInButton2;


    @FindBy(id = "sp-cc-accept")
    public WebElement cookies;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement signInCheck;


    public void login(String username, String password) {
        this.signInButton2.click();
        this.addEmail.sendKeys(username);
        this.emailsubmitButton.click();
        this.passwordInputBox.sendKeys(password);
        this.passwordSubmitButton.click();
    }



    public void waitSeconds(Integer seconds){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),seconds);
    }

    public void cookies(){
        if(cookies.isDisplayed()){
            cookies.click();

        }

    }

@AfterAll
    public void tearDown(){
        Driver.closeDriver();
}




}
