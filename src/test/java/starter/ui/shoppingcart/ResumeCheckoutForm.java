package starter.ui.shoppingcart;

import org.openqa.selenium.By;

public class ResumeCheckoutForm {

    public static By PRODUCT_PRICE = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[4]/span/span");
    public static By PRODUCT_QUANTITY = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/input[2]");
    public static By PRODUCT_TOTAL = By.id("total_product_price_1_1_582280");
    public static By PROCEED_TO_CHECKOUT = By.xpath("//a[@title='Proceed to checkout']");
}
