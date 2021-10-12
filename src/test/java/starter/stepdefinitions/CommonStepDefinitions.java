package starter.stepdefinitions;

import io.cucumber.java.en.Given;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class CommonStepDefinitions {

    @Given("{word} wants to remember something")
    public void setActorName(String name){
        theActorCalled(name);
    }

}
