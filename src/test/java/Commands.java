import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commands {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Commands(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    public void scrollElementToView(String locator) {
        WebElement element = driver.findElement(By.cssSelector(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public boolean isElementVisible(String locator) {
        WebElement element = driver.findElement(By.cssSelector(locator));
        element.isDisplayed();
        return true;
    }
}
