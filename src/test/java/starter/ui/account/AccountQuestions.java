package starter.ui.account;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class AccountQuestions {

    public static Question<String> nameOfAccount(){
        return actor -> TextContent.of(AccountForm.ACCOUNT_NAME).viewedBy(actor).asString().trim();
    }
}
