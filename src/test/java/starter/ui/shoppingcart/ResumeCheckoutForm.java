package starter.ui.shoppingcart;

import org.openqa.selenium.By;

public class ResumeCheckoutForm {

    public static By PRODUCT_PRICE = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[4]/span/span");
    public static By PRODUCT_QUANTITY = By.name("quantity_1_1_0_582280");
    public static By PRODUCT_TOTAL = By.id("total_product");
    public static By PROCEED_TO_CHECKOUT = By.xpath("//a[@title='Proceed to checkout']");
}
