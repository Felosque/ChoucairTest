package starter.ui.login;

import org.openqa.selenium.By;

public class LoginForm {
    public static By USER_EMAIL = By.id("email");
    public static By USER_PASSWORD = By.id("passwd");
    public static By LOGIN_BUTTON = By.id("SubmitLogin");
    public static By MESSAGE_ERROR = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[1]/ol/li");

}
