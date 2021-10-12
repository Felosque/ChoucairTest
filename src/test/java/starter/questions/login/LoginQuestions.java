package starter.questions.login;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.ui.login.LoginForm;

public class LoginQuestions {
    public static Question<String> errorMesaggeInvalidCredentials(){
        return actor -> TextContent.of(LoginForm.MESSAGE_ERROR).viewedBy(actor).asString().trim();
    }

}
