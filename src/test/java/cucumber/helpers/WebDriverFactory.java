package cucumber.helpers;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;


public class WebDriverFactory {
    private List<String> switches;
    WebDriver driver;

    public WebDriverFactory(){
        this.switches = new ArrayList<String>();
        this.switches.add("--ignore-certificate-errors");
        // this.switches.add("--user-agent=iPhone");
        this.switches.add("--disable-logging");
        // this.switches.add("--kiosk");


    }

    public WebDriver getWebDriver(){
        String chromeDriverPath = System.getProperty("chrome");
        String saucelabsDriver = System.getProperty("sauceLabsDriver");
        String IEDriver = System.getProperty("IEDriver");
        String firefoxDriverPath = System.getProperty("firefoxDriver");
        String androidDriverPath = System.getProperty("androidDriver") ;

        WebDriver newDriver;

         /*   if (firefoxDriverPath != null) {
                newDriver = (FirefoxDriver) createFirefoxDriver(firefoxDriverPath);
                 //drivers.add(newDriver);
             } else if (androidDriverPath != null) {
                newDriver = (WebDriver) createAndroidDriver();
                 //drivers.add(newDriver);
             } else */
        if(IEDriver!=null){
            newDriver = createIEDriver();
        }
        else {
            newDriver = createChromeDriver(chromeDriverPath);
            //   newDriver = createIEDriver();

            //drivers.add(newDriver);
        }

        return newDriver;
    }

    private InternetExplorerDriver createIEDriver(){


        DesiredCapabilities caps = new DesiredCapabilities();
        //    caps = DesiredCapabilities.internetExplorer();
        //caps.se
        caps.setCapability("version",8);
        //caps.setCapability("acceptSslCerts", true);
        caps.setCapability("ignoreProtectedModeSettings", true);
        //InternetExplorerDriver x = new InternetExplorerDriver(caps);
        //System.out.println("Before" + x.getCapabilities());

        return new InternetExplorerDriver(caps);
    }

    private ChromeDriver createChromeDriver(String chromeDriverPath) {
        if (StringUtils.isEmpty(chromeDriverPath)) {
            String os = System.getProperty("os.name").toLowerCase();
            boolean isMacOS = os.contains("mac");
            boolean isWinOS = os.contains("win");
            boolean isLinuxOS = os.contains("linux");
            String userDir = System.getProperty("user.dir");

            if (isMacOS) {
                chromeDriverPath = userDir + "/tools/chromeDriver/mac/chromedriver";
            } else if (isWinOS) {
                chromeDriverPath = userDir + "/tools/chromeDriver/win/chromedriver.exe";
            } else if (isLinuxOS) {
                chromeDriverPath = userDir + "/tools/chromeDriver/linux64/chromedriver";
            }
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        // To change chrome version to say 41 :
        //  options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");

        // To use ipad as an agent
        //options.addArguments("--user-agent=Mozilla/5.0 (iPad; CPU OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3");
        return new ChromeDriver(options);
    }


    public WebDriver createDriverWithBrowser(String browser){
                String userAgentString = "--user-agent=Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1312.60 Safari/537.17";
                return setChromeDriver(userAgentString);
    }

    private WebDriver setChromeDriver(String userAgentString){
        String os = System.getProperty("os.name").toLowerCase();
        boolean isMacOS = os.contains("mac");
        boolean isWinOS = os.contains("win");
        boolean isLinuxOS = os.contains("linux");
        String userDir = System.getProperty("user.dir");
        String  chromeDriverPath = null;
        if (isMacOS) {
            chromeDriverPath = userDir + "/tools/chromeDriver/mac/chromedriver";
        } else if (isWinOS) {
            chromeDriverPath = userDir + "/tools/chromeDriver/win/chromedriver.exe";
        } else if (isLinuxOS) {
            chromeDriverPath = userDir + "/tools/chromeDriver/linux64/chromedriver";
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");




        // To change chrome version to say 41 :
        options.addArguments(userAgentString);
        return new ChromeDriver(options);
        // return WebDriver driver;
    }

    private WebDriver createFirefoxDriver(String userAg) {
        //  String proxy = "example:80";
        // String userAgent = userAg;
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("general.useragent.override", userAg);
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setCapability(FirefoxDriver.PROFILE, profile);
        WebDriver driver = new FirefoxDriver(cap);

        return driver;
    }

    public void tearDown() {
        //  for (WebDriver driver : drivers) {
        driver.quit();
        //  }
    }
}
