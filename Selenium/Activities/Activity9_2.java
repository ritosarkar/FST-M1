import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_2 {
    public static void main(String[] args){
        int i=4;
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/selects");

        WebElement selected = driver.findElement(By.id("multi-value"));
        WebElement multiSelect=driver.findElement(By.id("multi-select"));

        Select select=new Select(multiSelect);

        if(select.isMultiple())
        {
            select.selectByVisibleText("Javascript");
            System.out.println("Selected option(s): "+selected.getText());
            select.selectByValue("node");
            System.out.println("Selected option(s): "+selected.getText());
            while(i!=7)
            {
                select.selectByIndex(i);
                System.out.println("Selected option(s): "+selected.getText());
                i++;
            }
            select.deselectByValue("node");
            System.out.println("Selected option(s): "+selected.getText());
            select.deselectByIndex(7);
            System.out.println("Selected option(s): "+selected.getText());

            System.out.println("First selected option is: "+select.getFirstSelectedOption().getText());

            List<WebElement> elementList=select.getAllSelectedOptions();
            for(WebElement selectedEle : elementList)
            {
                System.out.println("Selected option(s): "+selectedEle.getText());
            }

            select.deselectAll();
            System.out.println(selected.getText());
        }


        driver.quit();


    }
}
