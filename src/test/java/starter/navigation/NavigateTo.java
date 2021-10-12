package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo  {

    public static Performable theLoginPage() {
        return Task.where("{0} opens the login of my store",
                Open.browserOn().the(MyStoreLoginPage.class)
        );
    }

}