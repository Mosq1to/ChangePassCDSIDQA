import org.apache.commons.lang3.SystemUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebBrowser {

    public WebBrowser browser;
   public WebDriver driver;

    public void run(){

        try {
            browser = new WebBrowser ( );
            browser.StartBrowser();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            browser.ChangePwd ();

    }

    String chromeDriverPath = Constants.CHROMEPATH_WINDOWS;

    private void StartBrowser () throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1024,768", "--no-sandbox");
        ChromeDriver driver  = new ChromeDriver(options);
        driver.get(Constants.URL);
    }

    private void ChangePwd() {



        try {
            WebElement username = driver.findElement(By.id ("name"));
            username.clear ( );
            username.sendKeys (Constants.userTest);

            WebElement pwd = driver.findElement (By.id ("pwd"));
            pwd.clear ( );
            pwd.sendKeys (Constants.userPwd);

            //WebElement loginBtn = driver.findElement ();

        }
        catch(NullPointerException e) {
            System.out.println ("Webelement not found");
        }

    }











}


