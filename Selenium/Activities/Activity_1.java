import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_1 {

    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://www.training-support.net");
        System.out.println("Title of the page is: "+driver.getTitle());
        System.out.println("This is by id: "+driver.findElement(By.id("about-link")).getText());
        System.out.println("This is by class name: "+driver.findElement(By.className("inverted")).getText());
        System.out.println("This is by link text: "+driver.findElement(By.linkText("About Us")).getText());
        System.out.println("Thi is by css selector: "+driver.findElement(By.cssSelector("#about-link")).getText());
        // Close the browser
        driver.close();
    }

}
