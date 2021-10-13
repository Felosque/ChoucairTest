package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import starter.navigation.NavigateTo;
import starter.questions.account.AccountQuestions;
import starter.questions.shoppingcart.CheckoutQuestions;
import starter.task.login.Login;
import starter.task.shoppingcart.AddItemToCart;
import starter.ui.product.ProductForm;
import starter.ui.shoppingcart.ResumeCheckoutForm;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ShoppingCartStepDefinitions {


    String name;
    int numberOfProducts;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{word} is logged into the application")
    public void is_logged_into_the_application(String name) {
        this.name = name;
        theActorCalled(this.name).attemptsTo(
                NavigateTo.theLoginPage(),
                Login
                        .with()
                        .userEmail("felosque@gmail.com")
                        .password("123felosque")
                        .build()
        );
    }

    @Given("he wants to add products to his shopping cart")
    public void wants_to_add_products_to_his_shopping_cart() {
        theActorCalled(this.name).attemptsTo(
                NavigateTo.theProductPage(),
                Wait.until(WebElementQuestion.the(ProductForm.SUMMIT_BUTTON), WebElementStateMatchers.isEnabled())
                        .forNoLongerThan(30).seconds()
        );
    }

    @When("he adds {int} products of the same brand")
    public void adds_products_of_the_same_brand(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
        theActorCalled(this.name).attemptsTo(
                AddItemToCart.addToCart("" + numberOfProducts, "L")
        );
    }

    @When("he's going to check his shopping cart")
    public void going_to_check_his_shopping_cart() {
        theActorCalled(this.name).attemptsTo(
                NavigateTo.theCheckoutPage()
        );
    }

    @Then("he should find the three selected products")
    public void should_find_the_three_selected_products() {
        System.out.println(CheckoutQuestions.productPrice().answeredBy(theActorInTheSpotlight()));
        System.out.println(CheckoutQuestions.productTotal().answeredBy(theActorInTheSpotlight()));

        double price = Double.valueOf(CheckoutQuestions.productPrice().answeredBy(theActorInTheSpotlight()));
        double total = price * this.numberOfProducts;
        String shouldTotal = String.format("%.2f", total);

        theActorInTheSpotlight().should(
                seeThat("The total price ", CheckoutQuestions.productTotal(), equalTo(shouldTotal))
        );
    }

}
