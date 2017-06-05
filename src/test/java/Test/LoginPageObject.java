package Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("passwd");
    By loginButtonLocator = By.id("login");

    private final WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;

        if (!"Login".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPageObject typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPageObject typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public LoginPageObject submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new LoginPageObject(driver);
    }

    public LoginPageObject submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).submit();
        return new LoginPageObject(driver);
    }

    public LoginPageObject loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}
