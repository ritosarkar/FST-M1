import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);

        //Launch URL and get the title
        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("Page title: "+driver.getTitle());

    }
}


