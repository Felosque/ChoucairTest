package starter.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoLogin implements Task {

    private final String userEmail;
    private final String password;

    public DoLogin(String username, String password) {
        this.userEmail = username;
        this.password = password;
    }

    public static Performable withCredentials(String username, String password){
        return instrumented(DoLogin.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userEmail).into(LoginForm.USER_EMAIL),
                Enter.theValue(password).into(LoginForm.USER_PASSWORD),
                Click.on(LoginForm.LOGIN_BUTTON)
        );
    }
}
