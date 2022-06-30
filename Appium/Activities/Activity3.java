import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {

    AndroidDriver<MobileElement> androidDriver=null;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","TestEmulator");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("appActivity",".Calculator");
        desiredCapabilities.setCapability("appPackage","com.android.calculator2");
        desiredCapabilities.setCapability("noReset",true);

        //Set up appium and android driver
        URL appServer=new URL("http://127.0.0.1:4723/wd/hub");
        androidDriver=new AndroidDriver<>(appServer,desiredCapabilities);
    }
    @Test
    public void addition(){
        String result;
        //Click the number 5
        androidDriver.findElementById("digit_5").click();
        //click the add sign
        androidDriver.findElementByAccessibilityId("plus").click();
        //click the number 9
        androidDriver.findElementById("digit_9").click();
        //get the result
        result=androidDriver.findElementById("result").getText();
        System.out.println("Result of addition is: "+result);

        //Assertion
        Assert.assertEquals(result,"14");
    }

    @Test
    public void subtraction()
    {
        String result;
        //Click the number 10
        androidDriver.findElementById("digit_1").click();
        androidDriver.findElementById("digit_0").click();
        //click the minus sign
        androidDriver.findElementByAccessibilityId("minus").click();
        //click the number 5
        androidDriver.findElementById("digit_5").click();
        //get the result
        result=androidDriver.findElementById("result").getText();
        System.out.println("Result of subtraction is: "+result);

        //Assertion
        Assert.assertEquals(result,"5");
    }
    @Test
    public void multiplication(){
        String result;
        //Click the number 100
        androidDriver.findElementById("digit_1").click();
        androidDriver.findElementById("digit_0").click();
        androidDriver.findElementById("digit_0").click();
        //Click multiplication sign
        androidDriver.findElementByAccessibilityId("multiply").click();
        //click the number 5
        androidDriver.findElementById("digit_5").click();
        //get the result
        result=androidDriver.findElementById("result").getText();
        System.out.println("Result of multiplication is: "+result);

        //Assertion
        Assert.assertEquals(result,"500");
    }

    @Test
    public void division()
    {
        String result;
        //click the number 50
        androidDriver.findElementById("digit_5").click();
        androidDriver.findElementById("digit_0").click();
        //select the division sign
        androidDriver.findElementByAccessibilityId("divide").click();
        //click the number 2
        androidDriver.findElementById("digit_2").click();
        //get the result
        result=androidDriver.findElementById("result").getText();
        System.out.println("Result of division is: "+result);

        //Assertion
        Assert.assertEquals(result,"25");
    }

    @AfterMethod
    public void tearDown()
    {
        androidDriver.quit();
    }
}
