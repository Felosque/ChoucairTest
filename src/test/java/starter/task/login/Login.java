package starter.task.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.login.LoginForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String userEmail;
    private final String password;

    public Login(String username, String password) {
        this.userEmail = username;
        this.password = password;
    }

    public static UserBuilder with(){
        return new UserBuilder();
    }

    public static Performable withCredentials(String username, String password){
        return instrumented(Login.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userEmail).into(LoginForm.USER_EMAIL),
                Enter.theValue(password).into(LoginForm.USER_PASSWORD),
                Click.on(LoginForm.LOGIN_BUTTON)
        );
    }

    public static class UserBuilder{
        private String userEmail;
        private String password;

        public UserBuilder and() {
            return this;
        }

        public UserBuilder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Performable build(){
            return new Login(userEmail, password);
        }
    }

}
