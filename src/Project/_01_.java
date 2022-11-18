package Project;

import Utils.BaseDriver;
import Utils.Elements;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class _01_ extends BaseDriver {

    @Test(priority = 1)
    void Register(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        Elements e=new Elements();
        e.firstNameBox.sendKeys("group6");
        e.lastNameBox.sendKeys("TestNG");
        Select selectBrightDay=new Select(e.BrightDay);
        selectBrightDay.selectByVisibleText("16");
        Select selectBrightMount=new Select(e.BrightMonth);
        selectBrightMount.selectByVisibleText("March");
        Select selectBrightYear=new Select(e.BrightYear);
        selectBrightYear.selectByVisibleText("1923");
        e.email.sendKeys("group6@gmail.com");
        e.password.sendKeys("123456789asdf");
        e.confirmPassword.sendKeys("123456789asdf");
        e.registerButton.click();
        Assert.assertTrue(e.onay.getText().contains("exists"),"İşlem hatalı");
    }
    @Test(enabled = false)
    void Login(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        Elements e=new Elements();
        e.loginButton.click();
        e.email.sendKeys("group6@gmail.com");
        e.password.sendKeys("123456789asdf");
        e.getLoginButton.click();
        Assert.assertTrue(e.logout.getText().contains("Log out"),"login olunamadı");
    }
    @Test(dataProvider = "login")
    void Login2(String email,String password){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        Elements e=new Elements();
        e.loginButton.click();
            e.email.sendKeys(email);
            e.password.sendKeys(password);
            e.getLoginButton.click();
            Tools.Bekle(2);
            SoftAssert _soft=new SoftAssert();
            //_soft.assertTrue(e.logout.getText().contains("Log out"),"login olunamadı");
            e.email.clear();
           e.password.clear();
            //robot.keyPress(KeyEvent.VK_F5);
            //robot.keyRelease(KeyEvent.VK_F5);

    }
    @DataProvider(name = "login")
    public Object[][]getData(){
        Object[][] logins={
                {"Ali@email.com","123546sadfa"},
                {"Hasan@email.com","sadtgdsfj"},
                {"group6@gmail.com","123456789asdf"}
        };
        return logins;
    }
    @Test
    void tabMenuTest(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        List<WebElement>tapMenu=driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
        ArrayList<String>menu=new ArrayList<>();
        for (WebElement e:tapMenu){
            System.out.println("e.getText() = " + e.getText());
            menu.add(e.getText());
        }
        for(int i=0; i< menu.size();i++){
            Assert.assertEquals(tapMenu.get(i).getText(), menu.get(i),"Menu beklenen gibi değil");
    }

    }
    @Test
    void orderGiftsTest(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        Elements e=new Elements();
        e.giftCard.click();
        List<WebElement>tapMenu=driver.findElements(By.xpath("//h2[@class='product-title']/a"));
        ArrayList<String>menu=new ArrayList<>();
        for (WebElement w:tapMenu){
            System.out.println("e.getText() = " + w.getText());
            menu.add(w.getText());
        }
        WebElement gifts=driver.findElement(By.linkText(menu.get(Tools.randomNumber())));
        if (gifts.getText().contains("$25")){
            gifts.click();
            e.RecipientsName.sendKeys("Hasan");
            e.RecipientsEmail.sendKeys("hasan@mail.com");
            e.YourName.sendKeys("Ali");
            e.YourEmail.sendKeys("ali@mail.com");
            e.message.sendKeys("Hello");
            e.addtoCard.click();
        }else if (gifts.getText().contains("$50")){gifts.click();
        e.RecipientsName4.sendKeys("Kamala");
        e.YourName4.sendKeys("Eylül");
        e.message4.sendKeys("Hello");
            e.addtoCard4.click();
        }else {
            e.RecipientsName5.sendKeys("Kamala");
            e.YourName5.sendKeys("Eylül");
            e.message5.sendKeys("Hello");
            e.addtoCard5.click();
        }
Assert.assertTrue(e.getOnay.getText().contains("The product has been added to your "),"Eklenemedi");
    }
    @Test
    void orderComputerTest(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        Elements e=new Elements();
        actions.moveToElement(e.computer).perform();
        actions.moveToElement(e.desktop).click().perform();
        e.buildComputer.click();
        Select selectRam=new Select(e.RamSelect);
        selectRam.selectByVisibleText("8GB [+$60.00]");
        e.HDD.click();
        e.Addtocart.click();
        Assert.assertTrue(e.getOnay.getText().contains("The product has been added to your "),"Eklenemedi");
    }
    @Test
    @Parameters("mesaj")
    void parametreliSearchTest(String gelenmesaj){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        Elements e=new Elements();
        e.search.sendKeys(gelenmesaj);
        e.searchBtton.click();
        Assert.assertTrue(e.urun.getText().contains(gelenmesaj));
    }

}
