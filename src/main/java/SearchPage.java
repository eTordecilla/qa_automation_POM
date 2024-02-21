import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage{

    private By searchBox = By.name("search");
    private By searchButton = By.xpath("//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]");
    private By searchOk = By.xpath("//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[1]/div[1]");


    public SearchPage(WebDriver driver, WebDriverWait wait){
        super(driver, null);
    }
     //estos son metodos para interactuar con la busqueda
    public void escribirBusqueda(String elemento) throws InterruptedException {
        this.sendText(elemento, searchBox);
        this.sendKey(Keys.ENTER, searchBox);
    }

    public void clickBuscar() throws InterruptedException {
        this.click(searchButton);
    }

    public String resultadoBusqueda() throws InterruptedException {
        //String respuesta = this.getText(searchOk);
        System.out.println("Resultado de la busqueda: "+this.getText(searchOk));
        return this.getText(searchOk);
    }

}
