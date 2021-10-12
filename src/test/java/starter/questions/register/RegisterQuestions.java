package starter.questions.register;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.ui.account.AccountForm;
import starter.ui.register.RegisterForm;

public class RegisterQuestions {
    public static Question<String> errorMesaggeInvalidEmail(){
        return actor -> TextContent.of(RegisterForm.CREATE_ACCOUNT_ERROR).viewedBy(actor).asString().trim();
    }
}
