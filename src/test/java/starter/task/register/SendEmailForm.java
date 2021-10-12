package starter.task.register;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.task.login.Login;
import starter.ui.login.LoginForm;
import starter.ui.register.RegisterForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SendEmailForm implements Task {

    private final String email;

    public SendEmailForm(String email) {
        this.email = email;
    }

    public static Performable withEmail(String email){
        return instrumented(SendEmailForm.class, email);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(RegisterForm.REGISTER_EMAIL),
                Click.on(RegisterForm.REGISTER_BUTTON)
        );
    }
}
