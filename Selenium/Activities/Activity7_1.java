import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_1 {

    public static void main(String[] args)
    {
        WebDriver driver;
        WebElement username;
        WebElement password;
        WebElement welcomeMessage;
        WebDriverWait wait;

        driver=new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        System.out.println("Page title is: "+driver.getTitle());

        username=driver.findElement(By.xpath("//input[starts-with(@class,'username-')]"));
        password=driver.findElement(By.xpath("//input[starts-with(@class,'password-')]"));

        username.sendKeys("admin");
        password.sendKeys("password");

        driver.findElement(By.xpath("//button[@class='ui button']")).click();

        welcomeMessage=driver.findElement(By.id("action-confirmation"));
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        System.out.println("Welcome message is: "+welcomeMessage.getText());
        driver.quit();

    }
}
