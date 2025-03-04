package com.assignment;

import com.microsoft.playwright.*;

public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false) // Run in visible mode
            );

            Page page = browser.newPage();

            // **Step 1: Open Website**
            System.out.println("Opening Royal Brothers website...");
            page.navigate("https://www.royalbrothers.com/");
            page.waitForTimeout(5000); // Ensure full page load

            // **Step 2: Select City**
            String cityName = "Bangalore";
            System.out.println("Selecting city: " + cityName);

            Locator cityInput = page.locator("#autocomplete-input");
            cityInput.waitFor();
            cityInput.click();
            cityInput.fill(cityName);
            page.waitForTimeout(2000);

            // **Step 3: Click on Bangalore City**
            Locator cityOption = page.locator("a[data-city='Bangalore bengaluru']");
            cityOption.waitFor();
            cityOption.click();
            page.waitForTimeout(5000);

            // **Step 4: Enter Booking Date & Time (Using Correct Selectors)**
            System.out.println("Entering booking date & time...");
            Locator pickupDate = page.locator("#pickup-date-desk");
            Locator pickupTime = page.locator("#pickup-time-desk");

            pickupDate.click();  // Open date picker
            pickupDate.fill("12 Mar, 2025");  // Correct format

            pickupTime.click();  // Open time picker
            pickupTime.fill("8:30 AM");

            page.waitForTimeout(2000);

            // **Step 5: Click Search Button**
            System.out.println("Clicking Search button...");
            Locator searchButton = page.locator("button:has-text('Search')");
            searchButton.waitFor();
            searchButton.click();
            page.waitForTimeout(5000);

            // **Step 6: Validate Date Selection**
            System.out.println("Validating selected date and filters...");
            if (page.isVisible("text=12 Mar, 2025") && page.isVisible("text=15 Mar, 2025")) {
                System.out.println("✅ Date selection validated.");
            } else {
                System.out.println("❌ Date validation failed!");
                browser.close();
                return;
            }

            // **Step 7: Close Browser**
            System.out.println("Test completed. Closing browser...");
            browser.close();
        }
    }
}
