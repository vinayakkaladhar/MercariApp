package POM;

import Utilities.DriverUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LoginPage extends DriverUtilities {

    AppiumDriver driver;
    public LoginPage() throws MalformedURLException {
        driver = getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), LoginPage.class);
    }

    @AndroidFindBy(id = "username")
    private AndroidElement userName;

    @AndroidFindBy(id = "password")
    private AndroidElement password;

    @AndroidFindBy(id = "Login_button")
    private AndroidElement loginButton;

    public void userLogin(String email, String userPassword) throws InterruptedException {
        userName.sendKeys(email);
        password.sendKeys(userPassword);
        loginButton.click();
    }
}
