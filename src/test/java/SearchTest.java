import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportes.ExtentFactory;

import java.time.Duration;

public class SearchTest {

    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reporte.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void preconditions() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.setup();
        searchPage.url("https://opencart.abstracta.us/");
    }

    @Test
    @Tag("BUSQUEDA")
    @Tag("SMOKE")
    public void BusquedaExitosa_iphone() throws InterruptedException {
        ExtentTest test = extent.createTest("Busqueda Exitosa iPhone");
        test.log(Status.INFO, "Comienza nuestro test de busqueda");

        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.escribirBusqueda("iPhone");

        searchPage.clickBuscar();
        test.log(Status.PASS, "Se realiza la busqueda dde iPhone exitosa");

        //validamos de que la busqueda se hizo exitosa
        WebElement searchOk = driver.findElement(By.xpath("//a[contains(text(),'iPhone')]"));
        String busquedaCorrecta = searchOk.getText();
        //ahora mostramos la variable busquedaCorrecta
        System.out.println(busquedaCorrecta);
        test.log(Status.PASS, "Se valida que la busqueda fue exitosa");
    }


    @Test
    @Tag("BUSQUEDA")
    @Tag("REGRESION")
    public void BusquedaExitosa_macbook() throws InterruptedException {
        ExtentTest test = extent.createTest("Busqueda Exitosa iPhone");
        test.log(Status.INFO, "Comienza nuestro test de busqueda");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.escribirBusqueda("macbook");

        searchPage.clickBuscar();
        test.log(Status.PASS, "Se realiza la busqueda de macbook exitosa");

        searchPage.resultadoBusqueda();
        test.log(Status.PASS, "Se valida que la busqueda fue exitosa");


    }

    @AfterEach
    public void close() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.close();
    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
    }
}
