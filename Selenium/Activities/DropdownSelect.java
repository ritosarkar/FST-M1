import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class DropdownSelect {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");
        Select dropdown = new Select(driver.findElement(By.id("single-select")));

        //Select by visible text
        dropdown.selectByVisibleText("Option 2");

        //Select by index
        dropdown.selectByIndex(3);

        //Select by value
        dropdown.selectByValue("4");

        //Get all options
        List<WebElement> options = dropdown.getOptions();

        for(WebElement option : options)
            System.out.println("Option: " + option.getText());

        driver.close();
    }
}
