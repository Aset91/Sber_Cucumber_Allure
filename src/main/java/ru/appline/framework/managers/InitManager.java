package ru.appline.framework.managers;

import java.util.concurrent.TimeUnit;

import static ru.appline.framework.managers.DriverManager.getDriver;
import static ru.appline.framework.managers.DriverManager.quitDriver;
import static ru.appline.framework.utils.PropConst.IMPLICITLY_WAIT;
import static ru.appline.framework.utils.PropConst.PAGE_LOAD_TIMEOUT;

public class InitManager {

    /**
     * Менеджер properties
     */
    private static final TestPropManager props = TestPropManager.getTestPropManager();


    public static void initFrameWork() {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
    }
    public static void quitFramework(){
        quitDriver();
    }
}
