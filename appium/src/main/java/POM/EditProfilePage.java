package POM;

import Utilities.DriverUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;

public class EditProfilePage extends DriverUtilities {

    AppiumDriver driver;
    public EditProfilePage() throws MalformedURLException {
        driver = getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), EditProfilePage.class);
    }

    @AndroidFindBy(id = "profileIcon")
    private AndroidElement profileIcon;

    @AndroidFindBy(id = "userName")
    private AndroidElement profileName;

    @AndroidFindBy(id = "editIcon")
    private AndroidElement editPencilIcon;

    @AndroidFindBy(id = "addAddressIcon")
    private AndroidElement addAddressIcon;

    @AndroidFindBy(id = "streetAddress")
    private AndroidElement streetAddress;

    @AndroidFindBy(id = "cityName")
    private AndroidElement cityName;

    @AndroidFindBy(id = "phoneNumber")
    private AndroidElement phoneNumber;

    @AndroidFindBy(id = "phoneNumberType")
    private AndroidElement phoneNumberType;

    @AndroidFindBy(id = "pageTitle")
    private AndroidElement pageTitle;

    public boolean selectUserProfile(String userName) throws InterruptedException {
        profileIcon.click();
        return profileName.getText().equals(userName);
    }
    public void editUserProfile() throws InterruptedException {
        editPencilIcon.click();
    }
    public boolean clickAddAddress() throws InterruptedException {
        addAddressIcon.click();
        return pageTitle.getText().equals("Address Details");
    }
    public void addNewAddress(String street,String city,String type) throws InterruptedException {
        streetAddress.sendKeys(street);
        cityName.sendKeys(city);
        Select select = new Select(phoneNumberType);
        select.selectByVisibleText(type);
        phoneNumber.sendKeys("1234567890");
    }

    public void verifyNewAddress(String street,String city,String type) throws InterruptedException {
        streetAddress.getText().equals(street);
        cityName.getText().equals(city);
        phoneNumber.getText().equals("1234567890");
    }
}
