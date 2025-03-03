package com.assignment;

import com.microsoft.playwright.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            
            // Navigate to Royal Brothers
            page.navigate("https://www.royalbrothers.com/");

            // Select City (Make dynamic)
            String cityName = "Agra";  // Change this to test other cities
            page.fill("input[placeholder='Search City']", cityName);
            page.keyboard().press("Enter");

            // Enter time interval (Example values)
            page.fill("input[name='pickup-time']", "10:00 AM");
            page.fill("input[name='drop-time']", "6:00 PM");

            // Click search
            page.click("button:has-text('Search')");

            // Validate filters
            assert page.isVisible("text=" + cityName);

            // Apply dynamic location filter (Example: Indiranagar)
            String location = "Indiranagar";
            page.fill("input[placeholder='Search Location']", location);
            page.keyboard().press("Enter");

            // Collect data: Bike Model & Available At
            List<ElementHandle> bikeList = page.querySelectorAll(".bike-card");
            for (ElementHandle bike : bikeList) {
                String model = bike.querySelector(".bike-title").innerText();
                String availableAt = bike.querySelector(".location").innerText();
                assert availableAt.contains(location) : "Location mismatch!";
                System.out.println("Bike: " + model + " | Available at: " + availableAt);
            }

            browser.close();
        }
    }
}
