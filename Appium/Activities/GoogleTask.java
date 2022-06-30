import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class GoogleTask {

    AndroidDriver<MobileElement> driver;
    String note_title= null;
    String new_note =  null;
    MobileElement element;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","TestEmulator");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("appPackage","com.google.android.keep");
        desiredCapabilities.setCapability("appActivity",".activities.BrowseActivity");
        desiredCapabilities.setCapability("noReset",true);

        //Initiate the appium driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer,desiredCapabilities);
    }

    @Test
    public void addTask() {

        note_title="This is new title by Appium";
        new_note = "This is the new notes that i am adding for appium.";

        //click new notes on the app
        driver.findElementByAccessibilityId("New text note").click();
        //Setting the title and note body
        driver.findElementById("editable_title").sendKeys(note_title);
        driver.findElementById("edit_note_text").sendKeys(new_note);
        driver.findElementByAccessibilityId("Navigate up").click();
        element= driver.findElementByXPath("//*[contains(@text,'"+note_title+"')]");
        System.out.println("Note title: "+element.getText()+".");
        Assert.assertTrue(element.isDisplayed());
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
