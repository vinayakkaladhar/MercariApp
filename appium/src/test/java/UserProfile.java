import POM.EditProfilePage;
import POM.LoginPage;
import Utilities.DriverUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.net.MalformedURLException;

@Listeners(Utilities.ListenerTest.class)
/**
 * The Main test file thats mapped in testng.xml
 */
public class UserProfile extends EditProfilePage {

    public AppiumDriver driver;
    public EditProfilePage editProfilePage;
    public LoginPage loginPage;
    public boolean result;

    public UserProfile() throws MalformedURLException {
        driver = DriverUtilities.driver;
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        editProfilePage = new EditProfilePage();
        loginPage = new LoginPage();
    }

    @BeforeMethod
    public void startApp() throws InterruptedException {
        Activity activity = new Activity("com.android2.Mercari","com.android2.Mercari.HomePage");
        ((AndroidDriver) driver).startActivity(activity);
        loginPage.userLogin("vinayak","password@123");
    }

    @Test(priority = 0, description = "Verify new address can be registered")
    public void verifyNewAddressRegistration() throws InterruptedException {
        result = editProfilePage.selectUserProfile("vinayak");
        Assert.assertTrue(result,"user profile selected");
        Reporter.log("userProfile selected");
        editProfilePage.editUserProfile();
        result = editProfilePage.clickAddAddress();
        Assert.assertTrue(result,"add address selected");
        Reporter.log("add address selected");
        editProfilePage.addNewAddress("","","");
        Reporter.log("new address added");
        editProfilePage.verifyNewAddress("","","");
        Assert.assertTrue(result,"new address registered");
    }

    @AfterMethod
    public void stopApp() {
        ((AndroidDriver) driver).closeApp();
    }
}
