import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class BusinessObject {

    private static final WebDriver driver = new ChromeDriver();
    private static final PageObject pageObject = new PageObject(driver);

    public void navigateToLoginPage() {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.get(Utils.BASE_URL);
    }

    public void submitForm(String username, String password){
        pageObject.pressLoginButton();
        pageObject.waitForLoginPageToLoad();
        pageObject.enterUsername(username);
        pageObject.enterPassword(password);
        pageObject.pressLoginButton();
        pageObject.waitForConfigToLoad();
    }

    public void verifyUserLoggedIn(String expectedUserName){
        String actualUserName = pageObject.getNameOfLoggedUser();
        Assert.assertEquals(actualUserName, expectedUserName);
    }

    public void logoutAndVerifyUserIsLoggedOut(){
        pageObject.pressLogoutButton();
        Assert.assertTrue(pageObject.isLoginButtonDisplayed());
    }



}
