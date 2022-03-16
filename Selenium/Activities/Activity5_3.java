import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

    public static void main(String[] args)
    {
        WebDriver driver;
        WebElement element1, element2;

        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        System.out.println("Page title is: "+driver.getTitle());
        element1=driver.findElement(By.xpath("//input[@id='input-text']"));
        element2=driver.findElement(By.xpath("//button[@id='toggleInput']"));

        if(!element1.isEnabled())
        {
            element2.click();
            System.out.println("Text box is enable now? "+element2.isEnabled());
        }
    driver.quit();
    }
}
