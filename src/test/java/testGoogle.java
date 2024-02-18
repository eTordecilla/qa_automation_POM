import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testGoogle {
    public WebDriver driver; //instanciamos el driver

    @Test
    public  void test_1(){
        driver = new ChromeDriver(); //abrir el navegador
        driver.get("https://www.google.com/?client=safari");

        driver.getTitle(); // "Google"

        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");
        searchBox.sendKeys(Keys.ENTER);
        //searchButton.click();

        searchBox = driver.findElement(By.name("q"));
        searchBox.getAttribute("value"); //aquí queremos obtener la palabra "Selenium"

        driver.quit();
    }
}
