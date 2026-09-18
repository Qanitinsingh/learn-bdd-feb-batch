package steps;

import com.alphabeta.methods.FormMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class FormSteps {

    public static WebDriver driver;
    public FormSteps   () {
        driver = Hooks.driver;
    }

    @When("the user navigates to the {string} page")
    public void the_user_navigates_to_the_page(String formPageUrl) {
        FormMethods.verifyFormPAge(driver, formPageUrl);
    }
    @And("the user fills out the form with valid data")
    public void the_user_fills_out_the_form_with_valid_data() {
FormMethods.fillform(driver);
    }
    @And("the user submits the form")
    public void the_user_submits_the_form() {
FormMethods.submitForm(driver);
    }
    @Then("the user verifies that a success message is displayed")
    public void the_user_verifies_that_a_success_message_is_displayed() {
FormMethods.verifySuccessFormSubmit(driver);
    }
}
