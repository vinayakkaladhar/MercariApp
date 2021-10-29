package POM;

import Utilities.DriverUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.List;

public class ItemDetailsPage extends DriverUtilities {

    AppiumDriver driver;
    public ItemDetailsPage() throws MalformedURLException {
        driver = getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), ItemDetailsPage.class);
    }

    @AndroidFindBy(id = "searchBox")
    private AndroidElement searchBox;

    @AndroidFindBy(id = "itemTitle")
    private AndroidElement itemTitle;

    public boolean searchItem(String itemName) throws InterruptedException {
        searchBox.sendKeys(itemName);
        int size = driver.findElementsById("itemsListed").size();
        return size > 1;
    }

    public void selectItem(String itemName, int itemNumber) throws InterruptedException {
        List<AndroidElement> e = driver.findElementsById("itemsListed");
        e.get(itemNumber).click();
    }

    public boolean verifyItemTitle(String itemName) throws InterruptedException {
        return itemTitle.getText().equals(itemName);
    }
}
