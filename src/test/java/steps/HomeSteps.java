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
    @Given("the user opens the {string} page")
    public void the_user_opens_the_page(String url) {
        HomePageMethods.launchBrowserAndNavigateToHomePage(driver, url);
    }

    @Then("the user verifies all left-sidebar menu items one by one")
    public void the_user_verifies_all_left_sidebar_menu_items_one_by_one() {
        HomePageMethods.verifyLeftSidebarMenuItemsOneByOne(driver);
    }
    @Then("the browser is closed")
    public void the_browser_is_closed() {
        HomePageMethods.closeBrowser(driver);
    }
}
