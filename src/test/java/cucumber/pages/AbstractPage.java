package cucumber.pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;


public abstract class AbstractPage {

    public static final String HOME_PAGE = "http://www.acumenci.com/";
    protected WebDriver webDriver;

    @Autowired
    public AbstractPage(WebDriver driver){
        this.webDriver = driver;
    }

    public void go(String s){
        webDriver.get(HOME_PAGE);
        // waitForLoad();
    }

    public void addToUrl(String flag){
        webDriver.get(webDriver.getCurrentUrl() + flag);
    }

    public void setWebDriver(WebDriver d){
        webDriver=d;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
