package com.virgosol.pages;

import com.virgosol.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddProductToWishList extends BasePage  {

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']/span[3]")
    public WebElement searchResult;

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]")
    public WebElement secondProduct;

    @FindBy(xpath = "//input[@id='add-to-wishlist-button']")
    public WebElement listAddButton;

    @FindBy(xpath = "//li[@class='a-dropdown-item'][1]")
    public WebElement listItem;


    @FindBy(xpath = "//a[.='Listenizi Görüntüleyin']")
    public WebElement inspectYourLinkButton;

    @FindBy(xpath = "//h2[@class='a-size-base']")
    public WebElement listItemCheck;


    @FindBy(id = "searchDropdownBox")
    public WebElement selectDropdown;

    @FindBy(xpath = "(//span[@class='nav-icon nav-arrow'])[1]")
    public WebElement accountAndListTab;

    @FindBy(xpath = "//span[.='Daha fazla bilgi göster']")
    public WebElement showMoreInfoLink;

    @FindBy(xpath = "(//input[@class='a-button-input a-declarative'])[2]")
    public WebElement deleteListButton;

    @FindBy(xpath = "//span[.='Çıkış Yap']")
    public WebElement signOutButton;

    @FindBy(xpath = "(//div[.='Silindi'])[2]")
    public WebElement deleted;





    public WebElement openPage(Integer pageNumber) {

        return Driver.getDriver().findElement(By.xpath("//a[@aria-label='" + pageNumber + " sayfasına git']"));

    }

}
