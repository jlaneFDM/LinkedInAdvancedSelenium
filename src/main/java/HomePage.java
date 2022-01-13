import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public void canSelectSummerDressFromSearchField(WebDriver driver){
        driver.get("http://automationpractice.com/index.php");

        var waitForSearchField = new WebDriverWait(driver, Duration.ofSeconds(10));

        var searchField = waitForSearchField.
                                     until(ExpectedConditions
                                            .visibilityOfElementLocated(By.id("search_query_top")));
        searchField.sendKeys("dress");

        var waitForOptions = new WebDriverWait(driver, Duration.ofSeconds(10));

        var summerDressOption = waitForOptions.
                                            until(ExpectedConditions
                                                .visibilityOfElementLocated
                                                        (By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")));
        summerDressOption.click();

        var printedSummerDressesPage = "http://automationpractice.com/index.php?id_product=5&controller=product";

        /*Can't get Junit assertions to work. Page Object is in the wrong file.
          Junit Tests have to be in test folder*/

        if (printedSummerDressesPage.equals(driver.getCurrentUrl())){
            System.out.println("ON SUMMER DRESSES PAGE");
        }
    }

    public void canSelectTShirtsFromTheWomenTab(WebDriver driver){
        driver.get("http://automationpractice.com/index.php");

        driver.manage().window().fullscreen();

        var waitForWomenTab = new WebDriverWait(driver, Duration.ofSeconds(10));
        var women = waitForWomenTab
                                .until(ExpectedConditions
                                        .visibilityOfElementLocated(By
                                                .xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")));
        var hoverOver = new Actions(driver);
        hoverOver.moveToElement(women).perform();

        var waitForTShirtOption = new WebDriverWait(driver, Duration.ofSeconds(10));
        var tShirt = waitForTShirtOption
                .until(ExpectedConditions
                        .visibilityOfElementLocated
                                (By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")));
        tShirt.click();
        //check if T-Shirts tab is open
        var tShirtTab = driver
                .findElement
                        (By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a"));
        System.out.println("TShirt tab displayed: " + tShirtTab.isDisplayed() + "\n"
                           + "TShirt tab text: " + tShirtTab.getText());
        driver.quit();
    }
}
