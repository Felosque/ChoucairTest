package starter.ui.shoppingcart;

import org.openqa.selenium.By;

public class ResumeCheckoutForm {

    public static By PRODUCT_PRICE = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[4]/span/span");
    public static By PRODUCT_QUANTITY = By.name("quantity_1_1_0_582280");
    public static By PRODUCT_TOTAL = By.id("total_product");
    public static By PROCEED_TO_CHECKOUT = By.cssSelector(".cart_navigation .button-medium span");
    public static By COMMENT_FIELD = By.xpath("//a[@title='message']");
    public static By AGREE_TERMS = By.id("cgv");
    public static By PAY_WITH_WIRE = By.xpath("//a[@title='Pay by bank wire']");
    public static By PAY_WITH_CHECK = By.xpath("//a[@title='Pay by check.']");
    public static By PAY_CONFIRM_ORDER = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span");
    public static By FINISH_MESSAGE = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div");

}
