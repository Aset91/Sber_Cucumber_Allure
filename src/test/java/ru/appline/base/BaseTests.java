package ru.appline.base;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.managers.TestPropManager;

import static ru.appline.framework.managers.DriverManager.getDriver;
import static ru.appline.framework.managers.InitManager.initFrameWork;
import static ru.appline.framework.managers.InitManager.quitFramework;
import static ru.appline.framework.utils.PropConst.APP_URL;

public class BaseTests {

    protected PageManager pageManager = PageManager.getPageManager();

    @BeforeClass
    public static void before() {
        initFrameWork();
    }

    @Before
    public void beforeEach() {
        getDriver().get(TestPropManager.getTestPropManager().getProperty(APP_URL));
    }

    @AfterClass
    public static void after() {
        quitFramework();
    }

}
