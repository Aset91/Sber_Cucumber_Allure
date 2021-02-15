package ru.appline.framework.utils;

import com.sun.xml.internal.ws.developer.StreamingAttachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.framework.managers.DriverManager;

public class MyAllureListener extends AllureJunit4 {

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page screenShot", type = "image/png")
    public byte[] saveScreenShot(byte[] screenShot) {
        return screenShot;
    }


}
