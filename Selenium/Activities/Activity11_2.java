import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11_2 {
    public static void main(String[] args)
    {
        WebDriver driver;
        Alert alert;
        WebDriverWait wait;
        WebElement simpleAlert;

        driver=new FirefoxDriver();
        wait =new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        simpleAlert=driver.findElement(By.id("confirm"));

        simpleAlert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert=driver.switchTo().alert();
        System.out.println("Alert message on screen: "+alert.getText()+" and accept it.");
        alert.accept();

        simpleAlert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert=driver.switchTo().alert();
        System.out.println("Alert message on screen: "+alert.getText()+" and dismiss it.");
        alert.dismiss();

        driver.quit();
    }
}
