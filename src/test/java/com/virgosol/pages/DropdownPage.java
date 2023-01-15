package com.virgosol.pages;

import com.virgosol.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DropdownPage extends BasePage {

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

    @FindBy(xpath = "(//a[@title='Soğutma Fanı, CPU Soğutma Fanı MSI GS63VR için Mükemmel İşçilik MSI GS73VR için MSI 16K4'])[2]")
    public WebElement listItemCheck;


    @FindBy(id = "searchDropdownBox")
    public WebElement selectDropdown;

    @FindBy(xpath = "(//span[@class='nav-icon nav-arrow'])[1]")
    public WebElement accountAndListTab;

    @FindBy(xpath = "//span[.='Daha fazla bilgi göster']")
    public WebElement showMoreInfoLink;

    @FindBy(xpath = "//input[@name='submit.deleteItem']")
    public WebElement deleteListButton;

    @FindBy(xpath = "//span[.='Çıkış Yap']")
    public WebElement signOutButton;





    public WebElement openPage(Integer pageNumber) {

        return Driver.getDriver().findElement(By.xpath("//a[@aria-label='" + pageNumber + " sayfasına git']"));

    }

}
