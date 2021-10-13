package starter.task.shoppingcart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.shoppingcart.ResumeCheckoutForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FinishCheckout implements Task {

    private final String comment;

    public FinishCheckout(String comment) {
        this.comment = comment;
    }

    public static Performable finishCheckout(String comment){
        return instrumented(FinishCheckout.class, comment);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ResumeCheckoutForm.PROCEED_TO_CHECKOUT),
                Enter.theValue(comment).into(ResumeCheckoutForm.COMMENT_FIELD),
                Click.on(ResumeCheckoutForm.AGREE_TERMS),
                Click.on(ResumeCheckoutForm.PAY_WITH_WIRE),
                Click.on(ResumeCheckoutForm.PAY_CONFIRM_ORDER)
        );
    }

}
