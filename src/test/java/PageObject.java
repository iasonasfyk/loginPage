import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObject extends Commands {
    public enum Locators {

        USERNAME_INPUT("input[placeholder='UserName']"),
        PASSWORD_INPUT("input[placeholder='Password']"),
        BUTTON_LOGIN("button#login"),

        LOADER("button#loading-label"),

        BUTTON_LOGOUT("button#submit"),

        USER_LOGGED_IN("label#userName-value");

        private String myLocator;

        Locators(String locator) {
            myLocator = locator;
        }

        public String get(){
            return myLocator;
        }
    }


    public PageObject(WebDriver driver) {
        super(driver);
    }


    public void enterUsername(String username){
        scrollElementToView(Locators.USERNAME_INPUT.get());
        driver.findElement(By.cssSelector(Locators.USERNAME_INPUT.get())).sendKeys(username);
    }

    public void enterPassword(String password){
        scrollElementToView(Locators.PASSWORD_INPUT.get());
        driver.findElement(By.cssSelector(Locators.PASSWORD_INPUT.get())).sendKeys(password);
    }

    public void pressLoginButton(){
        scrollElementToView(Locators.BUTTON_LOGIN.get());
        driver.findElement(By.cssSelector(Locators.BUTTON_LOGIN.get())).click();
    }

    public void pressLogoutButton(){
        scrollElementToView(Locators.BUTTON_LOGOUT.get());
        driver.findElement(By.cssSelector(Locators.BUTTON_LOGOUT.get())).click();
    }

    public void waitForLoginPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Locators.BUTTON_LOGIN.get())));
    }

    public void waitForConfigToLoad() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Locators.LOADER.get())));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Locators.BUTTON_LOGOUT.get())));
    }

    public String getNameOfLoggedUser() {
        return driver.findElement(By.cssSelector(Locators.USER_LOGGED_IN.get())).getText();
    }

    public boolean isLoginButtonDisplayed() {
        return isElementVisible(Locators.BUTTON_LOGIN.get());
    }


}
