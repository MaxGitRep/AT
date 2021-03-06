package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SearchTest {
    private final WebDriver driver;

    public SearchTest (WebDriver driver){
        this.driver = driver;
    }

    @FindBy (id = "what")
    public WebElement searchField;

    @FindBy (id = "where")
    public WebElement searchLocation;

    @FindBy (id = "fj")
    public WebElement buttonFindJob;

    @FindBy (id = "prime-popover-close-button")
    public WebElement popupPrime;


    public SearchTest openMainPage(String urlOpenPage){
        driver.get(urlOpenPage);
        initElements(driver, this);
        return this;
    }

    public SearchTest addSearchData(String what, String where) throws Exception {
        searchField.sendKeys(what);
        searchLocation.sendKeys(where);
        buttonFindJob.click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return this;
    }

    public static void ExpWaitExpectedCondition(WebDriver driver, By xpathElement){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(xpathElement));
    }

    public static void ImpWaitExpectedCondition(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public SearchTest closePopup(){
        popupPrime.click();
        return this;
    }

    public String getCheckSearchTitle() {
        return driver.getTitle();
    }

    public String getCheckSearchCount() {
        driver.findElement(By.className(""));
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        return driver.findElement(By.id("searchCount")).getText();

    }
}
