package Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Elements {
    public Elements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(id = "FirstName")
    public WebElement firstNameBox;
    @FindBy(id = "LastName")
    public WebElement lastNameBox;
    @FindBy(name = "DateOfBirthDay")
    public WebElement BrightDay;
    @FindBy(name = "DateOfBirthMonth")
    public WebElement BrightMonth;
    @FindBy(name = "DateOfBirthYear")
    public WebElement BrightYear;
    @FindBy(id = "Email")
    public WebElement email;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;
    @FindBy(id = "register-button")
    public WebElement registerButton;
    @FindBy(xpath = "//div[@class=\"message-error validation-summary-errors\"]/ul/li")
    public WebElement onay;
    @FindBy(linkText = "Log in")
    public WebElement loginButton;
    @FindBy(xpath = "//button[@class=\"button-1 login-button\"]")
    public WebElement getLoginButton;
    @FindBy(linkText = "Log out")
    public WebElement logout;
    @FindBy(linkText = "Gift Cards")
    public WebElement giftCard;
    @FindBy(id = "giftcard_43_RecipientName")
    public WebElement RecipientsName;
    @FindBy(id = "giftcard_43_RecipientEmail")
    public WebElement RecipientsEmail;
    @FindBy(id = "giftcard_43_SenderName")
    public WebElement YourName;
    @FindBy(id = "giftcard_43_SenderEmail")
    public WebElement YourEmail;
    @FindBy(id = "giftcard_43_Message")
    public WebElement message;
    @FindBy(id = "add-to-cart-button-43")
    public WebElement addtoCard;
    @FindBy(id = "giftcard_44_RecipientName")
    public WebElement RecipientsName4;
    @FindBy(id = "giftcard_44_SenderName")
    public WebElement YourName4;
    @FindBy(id = "giftcard_44_Message")
    public WebElement message4;
    @FindBy(id = "add-to-cart-button-44")
    public WebElement addtoCard4;
    @FindBy(id = "giftcard_45_RecipientName")
    public WebElement RecipientsName5;
    @FindBy(id = "giftcard_45_SenderName")
    public WebElement YourName5;
    @FindBy(id = "giftcard_45_Message")
    public WebElement message5;
    @FindBy(id = "add-to-cart-button-45")
    public WebElement addtoCard5;
@FindBy(xpath = "//p[@class='content']")
    public WebElement getOnay;
@FindBy(linkText = "Computers")
    public WebElement computer;
@FindBy(linkText = "Desktops")
    public WebElement desktop;
@FindBy(linkText = "Build your own computer")
    public WebElement buildComputer;
@FindBy(id = "product_attribute_2")
    public WebElement RamSelect;
@FindBy(name = "product_attribute_3")
    public WebElement HDD;
@FindBy(id = "add-to-cart-button-1")
    public WebElement Addtocart;
@FindBy(id = "small-searchterms")
    public WebElement search;
@FindBy(xpath = "//button[@class='button-1 search-box-button']")
    public WebElement searchBtton;

@FindBy(xpath = "//h2[@class='product-title']/a")
    public WebElement urun;



}
