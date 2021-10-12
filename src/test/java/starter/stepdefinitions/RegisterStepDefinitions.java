package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import starter.navigation.NavigateTo;
import starter.questions.account.AccountQuestions;
import starter.questions.register.RegisterQuestions;
import starter.task.register.FillDataRegisterForm;
import starter.task.register.SendEmailForm;
import starter.ui.register.RegisterFieldsForm;
import starter.ui.register.RegisterForm;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterStepDefinitions {


    String name = "";
    String lastName = "";
    String uniqueEmail = System.currentTimeMillis() + "@gmail.com";

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{word} {word} is on the registration page")
    public void is_on_the_registration_page(String name, String lastname) {
        this.name = name;
        this.lastName = lastname;
        theActorCalled(this.name).attemptsTo(
                NavigateTo.theLoginPage()
        );
    }

    @Given("he sends a valid email for register")
    public void he_sends_a_valid_email_for_register() {
        theActorCalled(this.name).attemptsTo(
                SendEmailForm.withEmail(uniqueEmail)
        );
    }

    @When("he sends valid registration data")
    public void he_send_valid_registration_data() {
        theActorCalled(this.name).attemptsTo(
                FillDataRegisterForm.with()
                        .isMale(true)
                        .setCustomerFirstName(name)
                        .setCustomerLastName(lastName)
                        .setCustomerEmail(uniqueEmail)
                        .setCustomerPassword("123456789")
                        .birthday("8  ")
                        .birthdayMonth("July ")
                        .birthdayYear("1999  ")
                        .suscribeToNewsLetter(true)
                        .suscribeToSpecialOffers(true)
                        .setAddressCompany("My Company")
                        .setAddressOne("In my house #01")
                        .setAddressTwo("In my house #02")
                        .setAddressCity("Ibagué")
                        .setAddressState("Alabama")
                        .setAddressPostCode("00000")
                        .setAddressCountry("United States")
                        .setAddressInformation("Is a beautiful house.")
                        .setAddressHomePhone("2000000000")
                        .setAddressMobilePhone("300000000")
                        .setAddressAlias("My Home")
                        .build()
        );
    }

    @Given("she sends a wrong email for register")
    public void she_sends_a_wrong_email_for_register() {
        theActorCalled(this.name).attemptsTo(
                SendEmailForm.withEmail("emailerror.com")
        );
    }

    @Then("she should see an error on the screen")
    public void she_should_see_an_error_on_the_screen() {
        System.out.println(RegisterQuestions.errorMesaggeInvalidEmail().answeredBy(theActorInTheSpotlight()));
        theActorCalled(this.name).attemptsTo(Wait.until(
                        WebElementQuestion.the(RegisterForm.CREATE_ACCOUNT_ERROR), WebElementStateMatchers.isEnabled())
                .forNoLongerThan(30).seconds());
        theActorInTheSpotlight().should(
                seeThat("The displayed error ", RegisterQuestions.errorMesaggeInvalidEmail(), equalTo("Invalid email address."))
        );
    }

    @Then("he should see the account management screen")
    public void he_should_have_access_to_manage_his_account() {
        System.out.println(AccountQuestions.nameOfAccount().answeredBy(theActorInTheSpotlight()));
        theActorInTheSpotlight().should(
                seeThat("The displayed name ", AccountQuestions.nameOfAccount(), equalTo(name + " " + lastName))
        );
    }

}
