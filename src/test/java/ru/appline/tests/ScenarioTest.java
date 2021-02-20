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
                .selectBaseMenu("Ипотека")
                .selectSubMenu("Ипотека на готовое жильё")
                .fillField("Стоимость недвижимости", "5 180 000")
                .fillField("Первоначальный взнос", "3 058 000")
                .fillField("Срок кредита", "30")
                .removeCheckboxes("Страхование жизни и здоровья")
                .removeCheckboxes("Скидка 0,3% при покупке квартиры на ДомКлик")
                .removeCheckboxes("Электронная регистрация сделки")
                .checkCalculations("Сумма кредита", "2122000")
                .checkCalculations("Ежемесячный платеж", "16922")
                .checkCalculations("Необходимый доход", "21784")
                .checkCalculations("Процентная ставка", "11");
    }
}
