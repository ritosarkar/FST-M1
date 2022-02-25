import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

    public static void main(String[] args){
        WebDriver driver= new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form"); //Launch browser
        System.out.println("Title of the page: "+driver.getTitle());//get the title
        WebElement firstname= driver.findElement(By.id("firstName"));
        WebElement lastname=  driver.findElement(By.id("lastName"));
        firstname.sendKeys("RITO"); // Enter first name
        lastname.sendKeys("SARKAR"); //Enter last name
        driver.findElement(By.id("email")).sendKeys("rsarkar@xyz.com");//Enter email id
        driver.findElement(By.id("number")).sendKeys("9010910191");//Enter password
        driver.findElement(By.xpath("//input[contains(@class,'ui green button')]")).submit();//Click submit
       driver.close();

    }
}
