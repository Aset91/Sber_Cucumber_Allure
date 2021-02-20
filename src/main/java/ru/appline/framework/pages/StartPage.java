package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
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
    @FindBy(xpath = "//ul[contains(@class,'kitt-top-menu__list')]//a[@aria-label and @role='button']")
    private List<WebElement> menuBaseList;
    @FindBy(xpath = "//a[contains(@class,'kitt-top-menu__link_second')]")
    private List<WebElement> menuSubList;

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
    @Step("Выбрать меню {nameBaseMenu}")
    public StartPage selectBaseMenu(String nameBaseMenu) {
        for (WebElement menuItem : menuBaseList) {
            if (menuItem.getText().trim().equalsIgnoreCase(nameBaseMenu)) {
                elementToBeClickable(menuItem).click();
                return this;
            }
        }
        Assert.fail("Меню '" + nameBaseMenu + "' не было найдено на стартовой странице!");
        return this;
    }

    /**
     * выбрать "Ипотека на готовое жилье"
     * @return
     */
    @Step("выбрать подменю {nameSubMenu}")
    public MortgagePage selectSubMenu(String nameSubMenu) {
        for (WebElement menuItem : menuSubList) {
            if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
                elementToBeClickable(menuItem).click();
                return app.getMortgagePage().scrollToForm().switchWindows();
            }
        }
        Assert.fail("Подменю '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return app.getMortgagePage();
    }

}
