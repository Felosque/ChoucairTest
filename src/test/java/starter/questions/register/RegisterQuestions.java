package starter.questions.register;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.ui.account.AccountForm;

public class RegisterQuestions {
    public static Question<String> errorMesaggeInvalidEmail(){
        return actor -> TextContent.of(AccountForm.ACCOUNT_NAME).viewedBy(actor).asString().trim();
    }
}
