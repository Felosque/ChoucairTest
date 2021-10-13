package starter.task.shoppingcart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import starter.task.login.Login;
import starter.ui.product.ProductForm;
import starter.ui.register.RegisterFieldsForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddItemToCart implements Task {

    private final String quantity;
    private final String size;

    public AddItemToCart(String quantity, String size) {
        this.quantity = quantity;
        this.size = size;
    }

    public static Performable addToCart(String quantity, String size){
        return instrumented(AddItemToCart.class, quantity, size);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(ProductForm.PRODUCT_QUANTITY),
                Enter.theValue(quantity).into(ProductForm.PRODUCT_QUANTITY),
                SelectFromOptions.byVisibleText(size).from(ProductForm.PRODUCT_SIZE),
                Click.on(ProductForm.SUMMIT_BUTTON)
        );
    }
}
