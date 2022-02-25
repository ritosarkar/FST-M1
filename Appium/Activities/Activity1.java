package Activity;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    //Declare Android Diver
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //set the Desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("deviceName","TestEmulator");
        capabilities.setCapability("deviceid","1b0c75ee");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("appPackage","com.oneplus.calculator");
        capabilities.setCapability("appActivity",".Calculator");
        capabilities.setCapability("noReset",true);

        //Instantiate appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer,capabilities);
    }

    @Test
    public void add()
    {
        //had simulated my onePlus 8pro so identifiers might not match with the emulator locators
        //using resource-id
        driver.findElementById("digit_5").click();
        //using accessibility id
        driver.findElementByAccessibilityId("×").click();
        //using xpath
        driver.findElementByXPath("//android.widget.Button[3]").click();

        //get and display result
        String result = driver.findElementById("result").getText();
        /* String result = driver.findElementByClassName("android.widget.TextView").getText();
         String result = driver.findElement(MobileBy.id("result")).getText();*/

        System.out.println(result);
        Assert.assertEquals(result,"45");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}

