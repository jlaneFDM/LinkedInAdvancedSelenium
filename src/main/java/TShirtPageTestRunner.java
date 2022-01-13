import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TShirtPageTestRunner {
    static WebDriver driver;
    public static void main(String[] args){

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        dropDownTest(driver);
    }

    public static void dropDownTest(WebDriver driver){
        var tShirtPage =  new TShirtPage();
        tShirtPage.selectProductsAZFromDropdown(driver);

    }
}
