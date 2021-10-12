package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ShoppingCartStepDefinitions {


    String name;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{word} is logged into the application")
    public void is_logged_into_the_application(String name) {
        this.name = name;
    }

    @Given("he wants to add products to his shopping cart")
    public void he_wants_to_add_products_to_his_shopping_cart() {
    }

    @When("he adds {int} products of the same brand")
    public void he_adds_products_of_the_same_brand(Integer numberOfProducts) {
    }

    @When("he's going to check his shopping cart")
    public void he_s_going_to_check_his_shopping_cart() {
    }

    @Then("He should find the three selected products")
    public void he_should_find_the_three_selected_products() {
    }

}
