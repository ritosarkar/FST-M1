import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");
        driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).sendKeys("Rito");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sarkar");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@xyz.com");
        driver.findElement(By.xpath("//input[@id='number']")).sendKeys("9001001910");
        driver.findElement(By.xpath("//input[@value='submit']")).submit();
        driver.close();

    }
}
