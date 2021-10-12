package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.questions.account.AccountQuestions;
import starter.questions.login.LoginQuestions;
import starter.task.login.Login;
import starter.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDefinitions {

    String name;
    String lastName;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{word} {word} has an activity account")
    public void has_an_activity_account(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @When("he sends their valid credentials")
    public void he_sends_their_valid_credentials() {
        theActorCalled(name).attemptsTo(
                NavigateTo.theLoginPage(),
                Login
                        .with()
                        .userEmail("felosque@gmail.com")
                        .password("123felosque")
                        .build()
        );
    }

    @When("he sends their wrong email")
    public void he_sends_their_wrong_email() {
        theActorCalled(name).attemptsTo(
                NavigateTo.theLoginPage(),
                Login
                        .with()
                        .userEmail("emaildoesnotexist@gmail.com")
                        .password("anypass")
                        .build()
        );
    }

    @When("he sends their wrong password")
    public void he_sends_their_wrong_password() {
        theActorCalled(name).attemptsTo(
                NavigateTo.theLoginPage(),
                Login
                        .with()
                        .userEmail("felosque@gmail.com")
                        .password("123456789")
                        .build()
        );
    }

    @Then("he should see an error on the screen")
    public void he_should_see_an_error_on_the_screen() {
        System.out.println(LoginQuestions.errorMesaggeInvalidCredentials().answeredBy(theActorInTheSpotlight()));
        theActorInTheSpotlight().should(
                seeThat("The displayed error ", LoginQuestions.errorMesaggeInvalidCredentials(), equalTo("Authentication failed."))
        );
    }


    @Then("he should have access to manage his account")
    public void he_should_have_access_to_manage_his_account() {
        System.out.println(AccountQuestions.nameOfAccount().answeredBy(theActorInTheSpotlight()));
        theActorInTheSpotlight().should(
                seeThat("The displayed name ", AccountQuestions.nameOfAccount(), equalTo("Felosque Felosque"))
        );
    }

}
