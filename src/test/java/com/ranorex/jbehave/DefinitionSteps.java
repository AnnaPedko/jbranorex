package com.ranorex.jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.ranorex.steps.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the ranorex home page")
    public void givenTheUserIsOnTheHomePage() {
        endUser.is_the_Home_Page();
    }

    @When("the user looks up the definition of firstName '$firstName' and lastName '$lastName'")
    public void theUserLooksUpTheDefinitionOfFirstnameAndLastName(String firstName,String lastName) {
        endUser.looks_for(firstName, lastName);
    }
    @When("the user looks up the definition of firstName '$firstName',lastName '$lastName',category '$category'")
    public void theUserLooksUpTheDefinitionOfFirstnameAndLastNameAndCategoryAndGender(String firstName,String lastName,String category) {
        endUser.looks_for(firstName,lastName,category);
    }
    @Then("they should see the definition firstName '$firstName',lastName '$lastName',category '$category',gender '$gender'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String firstName,String lastName,String category,String gender) {
        endUser.should_see_definition(firstName,lastName,category,gender);
    }

    @When("the user looks up the removing of firstName '$firstName',lastName '$lastName',category '$category',gender '$gender'")
    public void theUserLooksUpTheRemovingOfFirstnameAndLastNameAndCategoryAndGender(String firstName,String lastName,String category,String gender){
    endUser.looks_for();

    }

    @Then("they should see the deleted firstName '$firstName',lastName '$lastName',category '$category',gender '$gender'")
    public void thenTheyShouldSeeDeletedContainingTheWords(String firstName, String lastName,String category, String gender){
        endUser.should_see_removing_last_raw(firstName, lastName,category, gender);
    }

}
