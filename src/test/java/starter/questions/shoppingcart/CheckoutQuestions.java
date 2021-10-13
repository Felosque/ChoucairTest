package starter.questions.shoppingcart;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.ui.register.RegisterForm;
import starter.ui.shoppingcart.ResumeCheckoutForm;

public class CheckoutQuestions {

    public static Question<String> productPrice(){
        return actor -> TextContent.of(ResumeCheckoutForm.PRODUCT_PRICE).viewedBy(actor).asString().trim().replace("$", "");
    }

    public static Question<String> productQuantity(){
        return actor -> TextContent.of(ResumeCheckoutForm.PRODUCT_QUANTITY).viewedBy(actor).asString().trim();
    }

    public static Question<String> productTotal(){
        return actor -> TextContent.of(ResumeCheckoutForm.PRODUCT_TOTAL).viewedBy(actor).asString().trim().replace("$", "");
    }
}
