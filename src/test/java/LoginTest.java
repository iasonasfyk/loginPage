import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest {

    private static final WebDriver driver = new ChromeDriver();
    private static final BusinessObject businessObject = new BusinessObject();

    private static final String USERNAME = "upstream";
    private static final String PASSWORD = "Asd123!.";


    @BeforeSuite(description = "Navigate to Login Page and log in with given credentials")
    public static void submitForm(){
        businessObject.navigateToLoginPage();
        businessObject.submitForm(USERNAME, PASSWORD);
    }

    @Test(description = "Verify user is logged in")
    public static void step1_verifyUserLoggedIn(){
        businessObject.verifyUserLoggedIn(USERNAME);
    }

    @Test(description = "Log out and verify user is logged out", dependsOnMethods = "step1_verifyUserLoggedIn")
    public static void step2_verifyUserLoggedOut(){
        businessObject.logoutAndVerifyUserIsLoggedOut();
    }

    @AfterSuite(description = "Close browser")
    public static void closeBrowser(){
        driver.close();
    }

}
