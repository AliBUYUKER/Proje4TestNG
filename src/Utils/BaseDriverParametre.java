package Utils;

import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParametre {
    public  WebDriver driver;
    public static JavascriptExecutor js;
    public static Actions actions;
    public static Robot robot;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browser")
    public void baslangicIslemleri(String browser) throws AWTException {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        if (browser.equalsIgnoreCase("chorome")){
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();}
        else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            System.setProperty("webdriver.edge.driver", "Driver/msedgedriver.exe");
            driver = new EdgeDriver();
        }


        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        robot = new Robot();

        driver.manage().window().setPosition(new Point(2000, 0));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Duration dr = Duration.ofSeconds(30);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(dr);

        driver.manage().timeouts().implicitlyWait(dr);

        loginTest();
    }

    void loginTest() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        System.out.println("login test");
        WebElement inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("alivali@hotmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("123456789");

        WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        loginBtn.click();

        Assert.assertEquals(driver.getTitle(), "My Account", "Login başarısız");
    }

    @AfterClass
    public void bitisIslemleri() {
        System.out.println("bitiş işlemleri");
        Tools.Bekle(3);
        driver.quit();
    }

}
