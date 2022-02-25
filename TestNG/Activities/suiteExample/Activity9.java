package suiteExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity9 {
    WebDriver driver;
    String alertTxt;
    @BeforeTest
    public void beforeTest()
    {
      driver = new FirefoxDriver();
      driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("Driver had been initiated and website had been launched.");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        driver.switchTo().defaultContent();
    }

    @Test
    public void simpleAlertTestCase()
    {
        Reporter.log("Starting simple alert activity");
        driver.findElement(By.id("simple")).click();
        Alert simpleAlert= driver.switchTo().alert();
        alertTxt= simpleAlert.getText();
        Assert.assertEquals(alertTxt,"This is a JavaScript Alert!");
        Reporter.log("The window text "+alertTxt+" had been verified.");
        simpleAlert.accept();
        Reporter.log("Simple alert accepted.");

    }

    @Test
    public void confirmAlertTestCase()
    {
        Reporter.log("Starting confirmation alert activity");
        driver.findElement(By.id("confirm")).click();
        Alert confirmAlert= driver.switchTo().alert();
        alertTxt=confirmAlert.getText();
        Assert.assertEquals(alertTxt,"This is a JavaScript Confirmation!");
        Reporter.log("The window text "+alertTxt+" had been verified.");
        confirmAlert.accept();
        Reporter.log("Confirmation alert accepted.");
    }

    @Test
    public void promptAlertTestCase()
    {
        Reporter.log("Starting prompt alert activity");
        driver.findElement(By.id("prompt")).click();
        Alert promptAlert= driver.switchTo().alert();
        alertTxt=promptAlert.getText();
        Assert.assertEquals(alertTxt,"This is a JavaScript Prompt!");
        Reporter.log("The window text "+alertTxt+" had been verified.");
        promptAlert.sendKeys("Success!!");
        Reporter.log("Text had been sent to the alert message box.");
        promptAlert.dismiss();
        Reporter.log("Had dismissed the prompt alert.");
    }

    @AfterTest
    public void afterMethod()
    {
     Reporter.log("Browser had been closed.");
        driver.quit();
    }
}
