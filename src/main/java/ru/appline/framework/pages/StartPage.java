package ru.appline.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ru.appline.framework.managers.DriverManager.getDriver;


/**
 * Start page - Стартовая страница "https://www.sberbank.ru/ru/person"
 */

public class StartPage extends  BasePage {
//
//  public StartPage() {
//       PageFactory.initElements(getDriver(), this);
//  }

    @FindBy(xpath = "//button[@class='kitt-cookie-warning__close']")
    WebElement cookies;
    @FindBy(xpath = "//a[@aria-label='Ипотека']")
    WebElement mortgage;
    @FindBy(xpath = "//a[@data-cga_click_top_menu='Ипотека_Ипотека на готовое жильё_type_important']")
    WebElement readyEstate;

    /**
     * Закрыть окно Cookies
     */
    @Step("Закрыть окно Cookies")
    public StartPage closeCookiesWindow() {
        cookies.click();
        return this;
    }

    /**
     * В верхнем меню "нажать" на Ипотека - дождаться открытия выпадающего меню
     */
    @Step("В верхнем меню нажать на Ипотека - дождаться открытия выпадающего меню")
    public StartPage openMortgageWindow() {
        mortgage.click();
        return this;
    }

    /**
     * выбрать "Ипотека на готовое жилье"
     * @return
     */
    @Step("выбрать Ипотека на готовое жилье")
    public MortgagePage chooseReadyEstateSubmenu(){
        readyEstate.click();
        return app.getMortgagePage();
    }

}
