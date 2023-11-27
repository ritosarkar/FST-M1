import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {


    public static void main(String[] args)
    {   WebDriver driver;
        WebElement element;
        driver= new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Page title is: "+driver.getTitle());
        element=driver.findElement(By.xpath("//input[@type='checkbox']"));

        if(!element.isSelected())
        {
            element.click();
            System.out.println("Is the checkbox is now selected? "+element.isSelected());
        }
        driver.quit();
    }
}
