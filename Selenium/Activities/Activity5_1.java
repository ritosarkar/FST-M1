import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.get(" https://training-support.net/selenium/dynamic-controls");
        System.out.println("Page title is: "+driver.getTitle());
        WebElement element= driver.findElement(By.className("willDisappear"));
        System.out.println("Check box is visible? "+element.isDisplayed());
        if(element.isDisplayed())
            driver.findElement(By.xpath("//button[@id='toggleCheckbox']")).click();
        System.out.println("Check box is visible? "+element.isDisplayed());
        driver.close();
    }
}
