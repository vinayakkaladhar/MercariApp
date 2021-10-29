import POM.EditProfilePage;
import POM.ItemDetailsPage;
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
public class ItemDetails extends ItemDetailsPage {

    public AppiumDriver driver;
    public ItemDetailsPage itemDetailsPage;
    public LoginPage loginPage;
    public boolean result;

    public ItemDetails() throws MalformedURLException {
        driver = DriverUtilities.driver;
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        itemDetailsPage = new ItemDetailsPage();
        loginPage = new LoginPage();
    }

    @BeforeMethod
    public void startApp() throws InterruptedException {
        Activity activity = new Activity("com.android2.calculator3","com.xlythe.calculator.material.Theme.Orange");
        ((AndroidDriver) driver).startActivity(activity);
        loginPage.userLogin("vinayak","password@123");
    }

    @Test(priority = 0, description = "Verify item detail title is displayed as expected")
    public void verifyItemDetails() throws InterruptedException {
        result = itemDetailsPage.searchItem("MacBook");
        Assert.assertTrue(result,"Items are listed");
        Reporter.log("Items are listed");
        itemDetailsPage.selectItem("MacBook",3);
        Assert.assertTrue(result,"MacBook item selected");
        Reporter.log("MacBook item selected");
        itemDetailsPage.verifyItemTitle("MacBook");
        Reporter.log("Item title has been verified");
        Assert.assertTrue(result,"Item title verified");
    }

    @AfterMethod
    public void stopApp() {
        ((AndroidDriver) driver).closeApp();
    }
}
