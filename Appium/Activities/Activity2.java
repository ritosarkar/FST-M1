import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class Activity2 {

    //Declare android driver
    AndroidDriver<MobileElement> driver=null;
    WebDriverWait webDriverWait;

    @BeforeClass
    public void  setUp() throws MalformedURLException {
        //Set the desired capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "TestEmulator");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.android.chrome");
        desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        desiredCapabilities.setCapability("noReset", true);

        //Initiate appium driver
        URL appUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appUrl, desiredCapabilities);

        webDriverWait=new WebDriverWait(driver,10);
    }

    @Test
    public void getPageTitle()
    {
        String pageTitle, newPageTitle = null;
        MobileElement aboutUsLabel;
     //open the browser
     driver.get("https://www.training-support.net/");
     //About us mobile element
     By aboutUs= MobileBy.AccessibilityId("About Us");
     //Wait for about us to be loaded
     webDriverWait.until(ExpectedConditions.elementToBeClickable(aboutUs));
     //Get the page title
     MobileElement pageTitleElement=driver.findElementByClassName("android.widget.TextView");
     pageTitle=pageTitleElement.getText();
     System.out.println("Page tile is: "+pageTitle);
     //Click the about us link
     driver.findElement(aboutUs).click();
        // Wait for new page to load
     webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                   MobileBy.xpath("//android.widget.TextView[@text='About Us']")
                   ));
     //Locate about us label element
     aboutUsLabel=driver.findElementByXPath("//android.widget.TextView[@text='About Us']");
     //Get the page title
     if(aboutUsLabel.isDisplayed()) {
         newPageTitle=aboutUsLabel.getText();
         System.out.println("New page title: "+newPageTitle);
     }

     //Assertion
     Assert.assertEquals(pageTitle, "Training Support");
     Assert.assertEquals(newPageTitle, "About Us");


    }


    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}

