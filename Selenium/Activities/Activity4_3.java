import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

    public static void main(String[] args)
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");

        System.out.println("Page title is: "+driver.getTitle());
        System.out.println("Page title is Target Practice:"+driver.getTitle().contains("Target Practice"));

        WebElement thirdHeader, fifthHeader,violetButton,greyButton;

        thirdHeader = driver.findElement(By.xpath("//*[contains(text(),'Third header')]"));
        String textOfThirdHeader=thirdHeader.getText();
        System.out.println("Text of third header is: "+textOfThirdHeader);

        fifthHeader= driver.findElement(By.xpath("//*[contains(text(),'Fifth header')]"));
        String colourOfFifthHeader=fifthHeader.getCssValue("color");
        System.out.println("CSS value of the fifth header is: "+colourOfFifthHeader);

        violetButton= driver.findElement(By.xpath("//button[contains(text(),'Violet')]"));
        String classOfVioletButton=violetButton.getAttribute("class");
        System.out.println("Class of violet button is: "+classOfVioletButton);

        greyButton=
                driver.
                findElement
                (By.xpath("/html/body/div/div[@class='activity content']/div[contains(@class,'ui sizer vertical segment')]/div[@class='spaced']/div[@class='ui segment activity content']/div[contains(@class,'relaxed divided stackable')]/div[@class='row']/div[@class='column']/div[3]/button[2]"));

        System.out.println("Text of grey button is:"+greyButton.getText());

        driver.quit();
    }
}
