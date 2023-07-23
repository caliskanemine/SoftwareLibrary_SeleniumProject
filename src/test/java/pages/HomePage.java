package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Shop']")
    public WebElement shopMenu;

    @FindBy(xpath = "//a[.='Home']")
    public WebElement homeMenu;

    @FindBy(xpath = "//div[@data-slide-duration='0']")
    public List<WebElement> sliders;

    @FindBy(xpath = "//div[.='Ad']")
    public WebElement ad;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']")
    public List<WebElement> arrivals;

    @FindBy(xpath = "//img[@title='Selenium Ruby']")
    public List<WebElement> image1;

    @FindBy(xpath = "//img[@title='Selenium Ruby']")
    public List<WebElement> imagesInArrivals;

    @FindBy(xpath = "//button[.='Add to basket']")
    public WebElement addToBasket;

    @FindBy(xpath = "//a[.='Description']")
    public WebElement description;

    @FindBy(xpath = "//div[@id='tab-description']")
    public WebElement descriptionMore;

    @FindBy(xpath = "//li[@class='reviews_tab']")
    public WebElement reviews;

    @FindBy(xpath = "//div[@class='woocommerce-Reviews']")
    public WebElement reviewsPart;

    @FindBy(xpath = "//span[@class='amount']")
    public WebElement amountOnMenu;

    @FindBy(xpath = "//div[@class='quantity']//input")
    public WebElement quantityInput;

    @FindBy(xpath = "//input[@name='update_cart']")
    public WebElement uptadeBasketButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']")
    public WebElement messageAfterUpdate;

    @FindBy(xpath = "//span[@class='cartcontents']")
    public WebElement itemLink;

    @FindBy(xpath = "//input[@id='coupon_code']")
    public WebElement couponInput;

    @FindBy(xpath = "//input[@name='apply_coupon']")
    public WebElement applyCouponButton;

    @FindBy(xpath = "//div[@class='cart_totals']//td[@data-title='Coupon: krishnasakinala']//span[@class='woocommerce-Price-currencySymbol']")
    public WebElement sale50rps;

    @FindBy(xpath = "//ul[@class='woocommerce-error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@title='Remove this item']")
    public WebElement removeButton;

    @FindBy(xpath = "//p[@class='cart-empty']")
    public WebElement emptyMessage;

    @FindBy(xpath = "//tr[@class='order-total']//td")
    public WebElement totalPrice;

    @FindBy(xpath = "//div[@class='cart_totals calculated_shipping']//td[@data-title='Subtotal']")
    public WebElement subTotal;

    @FindBy(xpath = "//a[normalize-space()='Proceed to Checkout']")
    public WebElement checkOutButton;

    @FindBy(xpath = "//h3[.='Billing Details']")
    public WebElement billingDetailsText;

    @FindBy(xpath = "//h3[.='Additional Information']")
    public WebElement additionalInfoText;

    @FindBy(xpath = "//h3[.='Your order']")
    public WebElement yourOrderText;

    @FindBy(xpath = "//div[@id='payment']")
    public WebElement paymentMethods;







}
