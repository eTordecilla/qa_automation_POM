import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

    public WebDriver driver;

    @BeforeEach
    public void preconditions() throws InterruptedException{
        driver = new ChromeDriver();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.setup();
        searchPage.url("https://opencart.abstracta.us/");
        Thread.sleep(1000);
    }

    @Test
    public void BusquedaExitosa_iphone() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.escribirBusqueda("iPhone");

        searchPage.clickBuscar();

        //validamos de que la busqueda se hizo exitosa
        WebElement searchOk = driver.findElement(By.xpath("//a[contains(text(),'iPhone')]"));
        String busquedaCorrecta = searchOk.getText();
        //ahora mostramos la variable busquedaCorrecta
        System.out.println(busquedaCorrecta);
    }


    @Test
    public void BusquedaExitosa_macbook() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.escribirBusqueda("macbook");

        searchPage.clickBuscar();

        searchPage.resultadoBusqueda();


    }

    @AfterEach
    public void close() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.close();
    }
}
