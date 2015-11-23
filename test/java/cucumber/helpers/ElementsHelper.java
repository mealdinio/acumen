package cucumber.helpers;

import cucumber.runtime.Env;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
public class ElementsHelper {

    public boolean clickOnElement(By byId, WebDriver webDriver) {
        try{
            WebElement element = (new WebDriverWait(webDriver, 10))
                    .until(ExpectedConditions.visibilityOfElementLocated(byId));
            if(element!=null){
                element.click();
            }

        } catch(Exception e) {
            System.out.print("element to click not found");
            return false;
        }
        return false;
    }

    public boolean containsText(By byId, String text, WebDriver webDriver) {
        try{
            WebElement ele = (new WebDriverWait(webDriver, 10))
                    .until(ExpectedConditions.visibilityOfElementLocated(byId));
            if(ele!=null){
                System.out.println(ele.getText());

                if(ele.getText().contains(text)){
                    return true;
                }
            }

        } catch(Exception e) {
            System.out.print( "\n" + text + " not found");
            return false;
        }
        return false;
    }

    public boolean enterText(By byId, String name, WebDriver webDriver) {
        try{
            WebElement ele = (new WebDriverWait(webDriver, 10))
                    .until(ExpectedConditions.visibilityOfElementLocated(byId));
            if(ele!=null){
                ele.clear();
                ele.sendKeys(name);
                return true;
            }
        } catch(Exception e) {
            System.out.print("Element info not found");
            return false;
        }
        return false;
    }

}
