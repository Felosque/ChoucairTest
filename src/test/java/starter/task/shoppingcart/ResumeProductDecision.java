package starter.task.shoppingcart;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.ui.product.ProductForm;

public class ResumeProductDecision implements Task {

    private final boolean proceedCheckout;

    public ResumeProductDecision(boolean proceedCheckout) {
        this.proceedCheckout = proceedCheckout;
    }

    public static ProductDecisionBuilder decision(){
        return new ProductDecisionBuilder();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (proceedCheckout){
            actor.attemptsTo(
                    Click.on(ProductForm.PROCEED_TO_CHECKOUT)
            );
        }else
        {
            actor.attemptsTo(
                    Click.on(ProductForm.CONTINUE_SHOPPING)
            );
        }
    }

    public static class ProductDecisionBuilder{
        private boolean proceedCheckout;

        public ProductDecisionBuilder proceedCheckout() {
            this.proceedCheckout = true;
            return this;
        }

        public ProductDecisionBuilder continueShopping() {
            this.proceedCheckout = false;
            return this;
        }

        public ResumeProductDecision go(){
            return new ResumeProductDecision(proceedCheckout);
        }
    }
}
