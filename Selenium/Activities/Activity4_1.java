import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        String pageTitle1=driver.getTitle();
        System.out.println("Title of the first page: "+  pageTitle1);
        driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
               System.out.println("New page title: "+driver.getTitle());
        System.out.println("Current Url is " +driver.getCurrentUrl());
    }
}