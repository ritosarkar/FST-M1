import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element;

        driver.get("https://www.training-support.net/selenium/ajax");
        driver.findElement(By.xpath("//button[contains(text(),'Change Content')]")).click();
        element=driver.findElement(By.id("ajax-content"));
        By by=By.id("ajax-content");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by,"HELLO!"));
        System.out.println(element.getText());

        wait.until(ExpectedConditions.textToBePresentInElementLocated(by,"I'm late!"));
        System.out.println(element.getText());
        //Close browser
        driver.quit();
    }
}
