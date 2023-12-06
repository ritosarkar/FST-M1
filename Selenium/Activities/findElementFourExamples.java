import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

    public static void main(String[] args){
        WebDriver driver= new FirefoxDriver();
        //Launch browser
        driver.get("https://www.training-support.net");

        String pageTitle=driver.getTitle();
        System.out.println("Page title: "+pageTitle);

        WebElement elementId = driver.findElement(By.id("about-link"));
        System.out.println("text using elementId: "+elementId.getText());

        WebElement elementClassName=driver.findElement(By.className("inverted"));
        System.out.println("text using elementClassName: "+elementClassName.getText());

        WebElement elementLinkText=driver.findElement(By.linkText("About Us"));
        System.out.println("text using elementLinkText: "+elementLinkText.getText());

        WebElement elementCssSelector=driver.findElement(By.cssSelector(".inverted"));
        System.out.println("text using elementCssSelector: "+elementCssSelector.getText());

        driver.quit();

    }
}
