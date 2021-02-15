package ru.appline.framework.managers;

import org.apache.commons.exec.OS;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static ru.appline.framework.utils.PropConst.*;

public class DriverManager {


    /**
     * Переменная для хранения объекта веб-драйвера
     */
    public static WebDriver driver;

    /**
     * Переменная для хранения объекта DriverManager
     */
    private static DriverManager INSTANCE = null;

    /**
     * Manager properties
     */
    // private final TestPropManager props = TestPropManager.getTestPropManager();

    TestPropManager props = TestPropManager.getTestPropManager();

    private DriverManager() {
        initDriver();
    }
    public static  WebDriver getDriver(){
        if(INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return driver;
    }
    public static void quitDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
            INSTANCE = null;
        }
    }

    private void initDriver() {
        if(OS.isFamilyWindows()) {
            initDriverAnyOsFamily(PATH_GECKO_DRIVER_WINDOWS, PATH_CHROME_DRIVER_WINDOWS);
        } else if (OS.isFamilyMac()) {
            initDriverAnyOsFamily(PATH_GECKO_DRIVER_MAC, PATH_CHROME_DRIVER_MAC);
        } else if (OS.isFamilyUnix()) {
            initDriverAnyOsFamily(PATH_GECKO_DRIVER_UNIX, PATH_CHROME_DRIVER_UNIX);
        }
    }


    private void initDriverAnyOsFamily(String gecko, String chrome) {
        switch (props.getProperty(TYPE_BROWSER)) {
            case "firefox" :
                System.setProperty("webdriver.gecko.driver", props.getProperty(gecko));
                driver = new FirefoxDriver();
                break;
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", props.getProperty(chrome));
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Типа браузера '" + props.getProperty(TYPE_BROWSER) + "' не существует во фреймворке");
        }
    }

}
