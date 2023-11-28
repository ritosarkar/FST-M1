import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class Activity8_1 {

    public static void main(String[] args) {
    /*Sample table
    <table>
     <thead>
      <tr>
       <th>First Name</th>
       <th>Last Name</th>
       <th>Age</th>
      </tr>
     <thead>
     
   <tbody>
   <tr>
    <td>Jill</td>
    <td>Ann</td>
    <td>24</td>
   </tr>
   <tr>
    <td>Eve</td>
    <td>Anderson</td>
    <td>34</td>
   </tr>
    <tr>
    <td>Ana</td>
    <td>Gen</td>
    <td>54</td>
   </tr>
  </tbody>
  </table>
  */
      WebDriver driver = new FirefoxDriver();
      //open browser
      driver.get("https://training-support.net/selenium/tables");
      //get columns using table head
      List<WebElement> columnsTh = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
      //get columns using tbody
      List<WebElement> columns= driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
      //get rows tbody
      List<WebElement> rows= driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
      System.out.println("Number of columns by tbody: "+ columns.size()+", also by thead: "+columnsTh.size()+". Number of rows: "+rows.size());

        /*for (WebElement element : rows) {
          if(i==3)
          {
           System.out.println(element.getText());
           break;
          }
          else
            i++;
        }
      System.out.println("Second row second column: "+driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText());*/
        //get details from third row
        List<WebElement> thirdRow=driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[3]/td"));
        for (WebElement cellValue : thirdRow)
        {System.out.println("Cell value: "+cellValue.getText());}
        //get the details from second row
        WebElement secondRowCol=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row and second column: "+secondRowCol.getText());
      driver.quit();
    }

}
