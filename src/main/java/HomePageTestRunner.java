import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePageTestRunner {
    private static WebDriver driver;
    public static void main(String[]args){

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        summerDressTest(driver);
        tShirtTest(driver);

    }

    public static void summerDressTest(WebDriver driver){
        var homePage = new HomePage();
        homePage.canSelectSummerDressFromSearchField(driver);
    }

    public static void tShirtTest(WebDriver driver){
        var homePage = new HomePage();
        homePage.canSelectTShirtsFromTheWomenTab(driver);

    }
}
