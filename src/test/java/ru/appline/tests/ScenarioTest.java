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
                .closeCookiesWindow()
                .openMortgageWindow()
                .chooseReadyEstateSubmenu()
                .checkOpenPage()
                .switchWindows()
                .scrollToForm()
                .fillField("Стоимость недвижимости", "5 180 000")
                .fillField("Первоначальный взнос", "3 058 000")
                .fillField("Срок кредита", "30")
                .removeCheckboxes()
                .checkCalculations();
    }
}
