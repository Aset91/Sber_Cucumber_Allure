package ru.appline.tests;

import ru.appline.framework.managers.PageManager;
import ru.appline.framework.pages.BasePage.*;
import org.junit.Test;
import ru.appline.base.BaseTests;
import ru.appline.framework.pages.StartPage;
import ru.appline.framework.pages.MortgagePage;

import static ru.appline.framework.managers.DriverManager.getDriver;
import ru.appline.framework.managers.PageManager.*;

public class ScenarioTest extends BaseTests {

    @Test
    public void scenarioTest() {

        pageManager.getStartPage()
                .openMortgageWindow()
                .chooseReadyEstateSubmenu()
                .fillField("Стоимость недвижимости", "5 180 000")
                .fillField("Первоначальный взнос", "3 058 000")
                .fillField("Срок кредита", "30")
                .removeCheckboxes("Страхование жизни и здоровья", "Опция не выбрана")
                .removeCheckboxes("Скидка 0,3% при покупке квартиры на ДомКлик", "Опция не выбрана")
                .removeCheckboxes("Электронная регистрация сделки", "Опция не выбрана")
                .checkCalculations("Сумма кредита", "2 122 000")
                .checkCalculations("Ежемесячный платеж", "16 922")
                .checkCalculations("Необходимый доход", "21 784")
                .checkCalculations("Процентная ставка", "11");

    }
}
