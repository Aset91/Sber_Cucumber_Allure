package ru.appline.base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.managers.InitManager;
import ru.appline.framework.managers.TestPropManager;

import static java.util.concurrent.TimeUnit.SECONDS;
import static ru.appline.framework.managers.DriverManager.getDriver;
import static ru.appline.framework.managers.DriverManager.quitDriver;
import static ru.appline.framework.utils.PropConst.APP_URL;

public class BaseTests {

    protected WebDriverWait wait;


    @Before
    public void beforeEach() {
        getDriver().get(TestPropManager.getTestPropManager().getProperty(APP_URL));
      //  InitManager.initFrameWork();
    }

    @BeforeClass
    public static void before() {
       // ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--disable-notifications");
        InitManager.initFrameWork();
      //  String baseUrl = "https://www.sberbank.ru/ru/person";
    }

    @AfterClass
    public static void after() {
        addScreenShot();
        InitManager.quitFramework();
    }

}
