import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TShirtPage {

    public void selectProductsAZFromDropdown(WebDriver driver){
        driver.get("http://automationpractice.com/index.php?id_category=5&controller=category");

        var dropDownField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .withMessage("Couldn't find the dropdown").pollingEvery(Duration.ofMillis(100))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-selectProductSort")));

        dropDownField.click();

        Select select = new Select(driver.findElement(By.id("selectProductSort")));
        select.selectByIndex(3);

        select.selectByIndex(3);

        /*content won't load after select due to slowness issue.
         would test to see if correct content loaded otherwise*/
    }
}
