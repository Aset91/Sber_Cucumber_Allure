package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.managers.TestPropManager;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static ru.appline.framework.managers.DriverManager.getDriver;
import static ru.appline.framework.utils.PropConst.IMPLICITLY_WAIT;

public class BasePage {


    public BasePage(){

    PageFactory.initElements(getDriver(), this);
    }
    protected PageManager app = PageManager.getPageManager();
    private final TestPropManager props = TestPropManager.getTestPropManager();

    protected WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1000);

    public void scrollToElementJs(WebElement element) {
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) getDriver();
        javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void fillInputField(WebElement element, String value) {
        scrollToElementJs(element);
        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(value);
        Assert.assertEquals("Поле было заполнено некорректно",
                value, element.getAttribute("value"));
    }
    public boolean isElementExists(By by) {
        boolean flag = false;
        try{
            getDriver().manage().timeouts().implicitlyWait(1, SECONDS);
            getDriver().findElement(by);
            flag = true;
        } catch (NoSuchElementException ignore) {
        } finally {
            getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        }
        return flag;
    }

    /**
     * Метод для смещения до середины экрана
     * @param x - параметр координат по горизонтали
     * @param  y - параметр координатр по вертикали
     */
     public void scrollWithOffset(WebElement element, int x, int y) {
         String code = "window.scroll(" + (element.getLocation().x + x) + ","
                 + (element.getLocation().y + y) + ");";
         ((JavascriptExecutor) getDriver()).executeScript(code, element, x, y);
     }
}
