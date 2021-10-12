package starter.ui.register;

import org.openqa.selenium.By;

public class RegisterForm {

    public static By REGISTER_BUTTON = By.id("SubmitCreate");
    public static By REGISTER_EMAIL = By.id("email_create");
    public static RegisterFieldsForm registerFieldsForm;
    public static By CREATE_ACCOUNT_ERROR = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]/ol/li");

}
