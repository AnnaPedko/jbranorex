package com.ranorex.steps;

import com.ranorex.pages.MainPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;

public class EndUserSteps extends ScenarioSteps {

    MainPage mainPage;

    @Step
    public void user_fills_person_fields(String firstName, String lastName) {
        mainPage.fillFields(firstName, lastName);
    }


    @Step
    public void user_fills_person_fields(String firstName, String lastName, String category) {
        mainPage.fillFields(firstName, lastName, category);
    }

    @Step
    public void is_the_Home_Page() {
        mainPage.open();

    }

    @Step
    public void user_add_person() {
        mainPage.addtoBase();
    }
    @Step
    public void user_delete_People(){

        mainPage.deleteLastRaw();
    }
    @Step
    public void should_see_definition(String firstName, String lastName,String Category,String Gender) {
        assertThat(mainPage.getRaw(), hasItems(firstName, lastName,Category,Gender));

    }
    @Step
    public void should_see_removing_last_raw(String firstName, String lastName,String Category,String Gender){

        assertThat(mainPage.getRaw(),not(hasItems(firstName, lastName, Category, Gender)));
    }

    @Step
    public void looks_for(String firstName, String lastName) {
        user_fills_person_fields(firstName, lastName);
        user_add_person();
    }

    @Step
    public void looks_for(String firstName, String lastName,String category) {
       user_fills_person_fields(firstName, lastName,category);
       user_add_person();
    }

   @Step
    public void looks_for(){

       user_delete_People();
   }
}
