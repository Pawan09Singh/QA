"--src/test/java/steps/RoyalBrothersSteps.java"


  package steps;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class RoyalBrothersSteps {
    Playwright playwright;
    Browser browser;
    Page page;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Given("User is on Royal Brothers homepage")
    public void openHomePage() {
        System.out.println("Opening Royal Brothers website...");
        page.navigate("https://www.royalbrothers.com/");
        page.waitForTimeout(5000);
    }

    @When("User selects city {string}")
    public void selectCity(String cityName) {
        System.out.println("Selecting city: " + cityName);
        page.fill("#autocomplete-input", cityName);
        page.waitForTimeout(3000);
        Locator cityOption = page.locator("a[data-city*='Bangalore']");
        cityOption.first().scrollIntoViewIfNeeded();
        cityOption.first().click(new Locator.ClickOptions().setForce(true));
        page.waitForTimeout(5000);
    }

    @When("User selects pickup date {string} and time {string}")
    public void selectPickupDateAndTime(String date, String time) {
        System.out.println("Selecting Pickup Date...");
        page.evaluate("document.getElementById('pickup-date-desk').click();");
        page.waitForTimeout(2000);
        page.evaluate("document.querySelector('div#pickup-date-desk_root table.picker__table td div[aria-label=\"" + date + "\"]').click();");
        page.waitForTimeout(2000);
        System.out.println("Selecting Pickup Time...");
        page.evaluate("document.querySelector('ul[aria-controls=\"pickup-time-desk\"] li[aria-label=\"" + time + "\"]').click();");
        page.waitForTimeout(2000);
    }

    @When("User selects dropoff date {string} and time {string}")
    public void selectDropoffDateAndTime(String date, String time) {
        System.out.println("Selecting Dropoff Date...");
        page.evaluate("document.getElementById('dropoff-date-desk').click();");
        page.waitForTimeout(2000);
        page.evaluate("document.querySelector('div#dropoff-date-desk_root table.picker__table td div[aria-label=\"" + date + "\"]').click();");
        page.waitForTimeout(2000);
        System.out.println("Selecting Dropoff Time...");
        page.evaluate("document.querySelector('ul[aria-controls=\"dropoff-time-desk\"] li[aria-label=\"" + time + "\"]').click();");
        page.waitForTimeout(2000);
    }

    @Then("User clicks on {string}")
    public void clickSearch(String buttonText) {
        System.out.println("Clicking Search button...");
        page.locator("button.buttonLarge").click();
        page.waitForTimeout(5000);
    }

    @Then("Search results should be displayed")
    public void validateResults() {
        System.out.println("Checking if results are loaded...");
        assertTrue(page.locator(".bike-listing").count() > 0, "No search results found!");
    }

    @After
    public void tearDown() {
        System.out.println("Test completed. Closing browser...");
        browser.close();
        playwright.close();
    }
}
