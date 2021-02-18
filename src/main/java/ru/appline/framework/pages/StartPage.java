package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Thread.sleep;
import static ru.appline.framework.managers.DriverManager.getDriver;


/**
 * Start page - Стартовая страница "https://www.sberbank.ru/ru/person"
 */

public class StartPage extends  BasePage {

    @FindBy(xpath = "//button[@class='kitt-cookie-warning__close']")
    WebElement cookies;
  //  @FindBy(xpath = "//a[contains(@class, 'kitt-top-menu__link') and @role='button']")
//    List<WebElement> menuBaseList;
//    @FindBy(xpath = "//a[contains(@class, 'kitt-top-menu__link_second')]")
//    List<WebElement> menuSubList;
    @FindBy(xpath = "//a[@aria-label='Ипотека']")
    WebElement mortgage;
    @FindBy(xpath = "//a[@data-cga_click_top_menu='Ипотека_Ипотека на готовое жильё_type_important']")
    WebElement readyEstate;

//    /**
//     * Закрыть окно Cookies
//     */
//    @Step("Закрыть окно Cookies")
//    public StartPage() {
//        cookies.click();
//        return this;
//    }

    /**
     * В верхнем меню "нажать" на Ипотека - дождаться открытия выпадающего меню
     */
    @Step("В верхнем меню нажать на Ипотека - дождаться открытия выпадающего меню")
    public StartPage openMortgageWindow() {
        cookies.click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mortgage.click();
        return this;
    }

    /**
     * выбрать "Ипотека на готовое жилье"
     * @return
     */
    @Step("выбрать Ипотека на готовое жилье")
    public MortgagePage chooseReadyEstateSubmenu(){
     //   action.moveToElement(readyEstate).click().build().perform();
        readyEstate.click();
        return app.getMortgagePage();
    }

}
