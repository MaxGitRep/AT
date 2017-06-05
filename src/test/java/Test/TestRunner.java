package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static Test.PrepareTest.driver;
import static org.testng.Assert.assertEquals;

public class TestRunner {
    @DataProvider
    public Object[][] testLoginData() {
        return new Object[][]{
                new Object[]{"admin", "admin", "11111", "NoLevel"},
                new Object[]{"seller", "seller123", "00111", "HighLevel"},
                new Object[]{"user", "user456", "00001", "NormalLevel"},
                new Object[]{"guest", "guest789", "00000", "LowLevel"},
        };
    }


    @Test
    @Parameters("browser")
    public void SearchJobAndCheck(String browserName) throws Exception {
        System.out.println("Start");
        PrepareTest prepare_test = new PrepareTest();
        WebDriver startBrowser = prepare_test.startBrowser(browserName);

        SearchTest checkSearchFunctionality = new SearchTest(startBrowser)
                .openMainPage("http://indeed.co.uk")
                .addSearchData("Selenium", "London");

        SearchTest.ExpWaitExpectedCondition(startBrowser, By.id("prime-popover-close-button"));
        checkSearchFunctionality.closePopup();

        Assert.assertEquals(checkSearchFunctionality.getCheckSearchCount(), "Jobs 1 to 10 of 800");
        Assert.assertEquals(checkSearchFunctionality.getCheckSearchTitle(), "Selenium Jobs, vacancies in London | Indeed.co.uk");
        System.out.println("Finish");
    }


    @Test(dataProvider = "testLoginData")
    public void checkLoginFunc(String username, String password) {
        LoginPageObject login = new LoginPageObject(driver);
        login.loginAs(username, password);
        //check success message
        //get data and check level of user access!
    }


    public void hoverMouse(WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }


    public void hoverMouseAndClick(WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).click().build().perform();
    }


    public void clickNotHidden(List<WebElement> elements, String elementName) {
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            int X = element.getLocation().getX();
            String text = element.getAttribute("innerHTML");
            if (text.equalsIgnoreCase(elementName) && X != 0) {
                element.click();
                break;
            }
        }
    }


    public void clickDropDownList(List<WebElement> elements, String elementName) {
        List<WebElement> list = elements;
        for (int i = 0; i < list.size(); i++) {
            WebElement element = list.get(i);
            String text = element.getAttribute("innerHTML");
            if (text.equalsIgnoreCase(elementName) && element.isEnabled()) {
                element.click();
                break;
            }
        }
    }


    public void scrollPageJS(int X, int Y) {
        String scrollJS = "scroll(" + X + "," + Y + ")"; //"scroll(0,400)"
        ((JavascriptExecutor) driver).executeScript(scrollJS);

    }


    public void scrollViewJS(By elementSelector) {
        WebElement element = driver.findElement(elementSelector);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public WebElement getJQueryElement(String elementSelector) {
        String selectorJQ = "return jQuery.find('" + elementSelector + "');"; //#hplogo
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript(selectorJQ);
    }


    public void waitLoadPageByTitle(final String titleName) {
        (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<Boolean>() {
                           public Boolean apply(WebDriver d) {
                               return d.getTitle().toLowerCase().startsWith(titleName);
                           }
                       }
                );
    }

    public WebElement waitLoadElement(final By elementSelector) {
        WebElement element = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<WebElement>() {
                           public WebElement apply(WebDriver d) {
                               return d.findElement(elementSelector);
                           }
                       }
                );
        return element;
    }


    public void softAssert(int value1, int value2, String comment) {
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(value1, value2, comment);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            //take screenshot
            //PrepareTest.driver
            new PrepareTest().quitBrowser();
        }
    }
}
