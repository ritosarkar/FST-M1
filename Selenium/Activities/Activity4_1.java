import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        //Launch browser
        driver.get("https://www.training-support.net");
        String pageTitle1=driver.getTitle();//get page title
        System.out.println("Title of the first page: "+  pageTitle1);//Print current page title
        //Find element by xpath
        driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
        System.out.println("New page title: "+driver.getTitle());//print current page title
    }
}