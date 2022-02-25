import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void testMethod() {

        WebElement username=driver.findElement(By.id("username"));
        WebElement password= driver.findElement(By.id("password"));
        WebElement loginButton= driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));

        //validating user visibility and sending text
      if (username.isDisplayed() && password.isDisplayed()) {
          username.sendKeys("admin");
          password.sendKeys("password");

          //If login button is enabled click on it
          if(loginButton.isEnabled()) {
              loginButton.click();
              //read login message and validate
              String confirmation = driver.findElement(By.id("action-confirmation")).getText();
              Assert.assertEquals(confirmation, "Welcome Back, admin");
          }
        }
    }

    @AfterClass
    public void afterClass(){
        //close the browser
        driver.quit();
    }
}
