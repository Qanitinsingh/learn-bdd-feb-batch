package steps;

import com.alphabeta.methods.HomePageMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class HomeSteps {
    public static WebDriver driver;
    public HomeSteps   () {
        driver = Hooks.driver;
    }
    @Given("User is on the {string} in Chrome")
    public void user_is_on_the_in_chrome(String url) {
        HomePageMethods.launchBrowser(driver, url);
    }

    @When("User clicks on the Novice Link")
    public void user_clicks_on_the_Novice() {
        HomePageMethods.clickNoviceLink(driver);
    }
    @And("I click on Basic form present under Practice Form Option")
    public void Practice_form() {
        HomePageMethods.clickPracticeForm(driver);
        HomePageMethods.clickBasicForm(driver);
    }

    @And("I Switch to Iframe")
    public void swicth_Iframe() throws InterruptedException {

        HomePageMethods.SwicthIframe(driver);
    }


    @And("User fills the form with following details")
    public void user_fills_the_form_with_following_details(DataTable dataTable) {

        Map<String, String> formData = dataTable.asMap(String.class, String.class);

        String username = formData.get("Username");
        String password = formData.get("Password");
        String comments = formData.get("Comments");
        String gender = formData.get("Gender");
        String skills = formData.get("Skills");
        String experience = formData.get("Experience");
        String automationTools = formData.get("AutomationTools");
        String resumePath = formData.get("ResumePath");
HomePageMethods.enterUsername(driver, username);
HomePageMethods.enterPassword(driver, password);
HomePageMethods.enterComments(driver, comments);
HomePageMethods.selectGender(driver, gender);
HomePageMethods.selectSkills(driver, skills);
HomePageMethods.selectExperience(driver, experience);
HomePageMethods.selectAutomationTools(driver, automationTools);
HomePageMethods.uploadResume(driver, resumePath);


    }

    @And("I click on submit button")
    public void form_should_be_submit() {
HomePageMethods.clickSubmit(driver);
    }
    @Then("Form should be submitted successfully")
    public void form_should_be_submitted_successfully() {
System.out.println("Form has been submitted successfully");
    }
}
