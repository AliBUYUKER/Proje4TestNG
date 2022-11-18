package Utils;

import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static Actions actions;
    public static Robot robot;
    public static WebDriverWait wait;
    @BeforeClass(groups = "SmokeTest")
    public void baslangicIslemleri() throws AWTException {
        Logger logger= Logger.getLogger(""); // sisteme ait bütün logları üreten objeye/servise ulaştım ""
        logger.setLevel(Level.SEVERE); // Sadece errorları göster

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");  // ChromeServici sessiz modda çalıştır
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();   // web sayfasını kontrol eden görevli
        actions=new Actions(driver);
        js=(JavascriptExecutor)driver;
        robot=new Robot();

        driver.manage().window().setPosition(new Point(2000,0));
        driver.manage().window().maximize();  // Ekranı max yapıyor.
        driver.manage().deleteAllCookies();  // sitenin senin bilgisayarında yaptığı ayarlar siliniyor, sayfa başlangıç ayarlarına dönüyor

        Duration dr=Duration.ofSeconds(30);
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(dr); // Sadece tüm sayfanın kodlarının bilgisyarınıza inmesi süresiyle ilgili
        //bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.: 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
        // eğer 2 sn yüklerse 30 sn. beklemez.

        driver.manage().timeouts().implicitlyWait(dr);

       // loginTest();
    }
    void loginTest()
    {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        System.out.println("login test");
        WebElement inputEmail= driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("alivali@hotmail.com");

        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("123456789");

        WebElement loginBtn= driver.findElement(By.cssSelector("input[type='submit']"));
        loginBtn.click();

        Assert.assertEquals(driver.getTitle(),"My Account","Login başarısız");
    }
    @AfterClass(enabled = false,
            groups = "SmokeTest")
    public void bitisIslemleri()
    {
        System.out.println("bitiş işlemleri");
        Tools.Bekle(3);
        driver.quit();
    }

    }
