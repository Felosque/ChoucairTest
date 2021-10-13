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

    public static Performable theRegisterPage() {
        return Task.where("{0} opens the register of my store",
                Open.browserOn().the(MyStoreLoginPage.class)
        );
    }

    public static Performable theProductPage() {
        return Task.where("{0} opens the product id:1 of my store",
                Open.browserOn().the(MyStoreProductPage.class)
        );
    }

    public static Performable theCheckoutPage() {
        return Task.where("{0} open chekout page",
                Open.browserOn().the(MyStoreShoppingCartPage.class)
        );
    }
}