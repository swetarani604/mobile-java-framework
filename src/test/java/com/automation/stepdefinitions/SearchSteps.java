package com.automation.stepdefinitions;

import com.automation.driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

// Import Page Classes
import com.automation.pages.HomePage;
import com.automation.pages.ProductResultPage;
import com.automation.pages.ProductDetailsPage;
import com.automation.pages.CartPage;
import com.automation.pages.SubstitutePage;
import com.automation.pages.CheckoutPage;

public class SearchSteps {

    HomePage homePage;
    ProductResultPage productResultPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;
    SubstitutePage substitutePage;
    CheckoutPage checkoutPage;


//    @Before
//    public void initPages(){
//
//        homePage = new HomePage(DriverManager.getDriver());
//        productResultPage = new ProductResultPage(DriverManager.getDriver());
//        productDetailsPage = new ProductDetailsPage(DriverManager.getDriver());
//        cartPage = new CartPage(DriverManager.getDriver());
//        substitutePage = new SubstitutePage(DriverManager.getDriver());
//        checkoutPage = new CheckoutPage(DriverManager.getDriver());
//
//    }
    public SearchSteps() {

        homePage = new HomePage(DriverManager.getDriver());
        productResultPage = new ProductResultPage(DriverManager.getDriver());
        productDetailsPage = new ProductDetailsPage(DriverManager.getDriver());
        cartPage = new CartPage(DriverManager.getDriver());
        substitutePage = new SubstitutePage(DriverManager.getDriver());
        checkoutPage = new CheckoutPage(DriverManager.getDriver());
    }


    // -------------------- Background Steps -------------------- //

    @Given("the user lands on the home screen with search functionality available")
    public void verifyHomeScreen() {

        homePage.verifyHomeScreen();
    }


    // -------------------- Scenario Steps -------------------- //

    @When("the user searches for {string} from the home screen")
    public void searchProduct(String product) {

        homePage.searchProduct(product);

    }

    @When("the user selects {string} from the search suggestions")
    public void selectSearchSuggestion(String product) {
        homePage.selectSearchSuggestion(product);
    }

    @Then("the results page should display text containing {string}")
    public void verifyResultsText(String resultText) {

        productResultPage.verifyResultsText(resultText);
    }

    @Then("list of products displayed with product name and price information")
    public void verifyProductList() {
        productResultPage.verifyProductList();
    }

    @When("the user opens a product from the search results")
    public void openProductFromResults() {
        productResultPage.openFirstProduct();
    }

    @Then("the product details screen should display the product name and price")
    public void verifyProductDetails() {
        productDetailsPage.verifyProductDetails();
    }

    @Then("the user scrolls through the product details screen to view details sections displaying")
    public void scrollThroughProductDetails() {
        productDetailsPage.scrollThroughDetails();
    }

    @When("the user adds the product to the cart")
    public void addProductToCart() {
        productDetailsPage.addToCart();
    }

    @When("the user navigates to the cart screen")
    public void navigateToCart() {
        cartPage.openCart();
    }

    @Then("the cart should display the added product")
    public void verifyProductInCart() {
        cartPage.verifyProductInCart();
    }

    @When("the user adds a substitution for the selected product")
    public void addSubstitution() {
        substitutePage.addSubstitution();
    }

    @When("the user proceeds to the checkout flow")
    public void proceedToCheckout() {
        cartPage.proceedToCheckout();
    }

    @Then("the application should display available delivery time slots")
    public void verifyDeliverySlots() {
        checkoutPage.verifyDeliverySlots();
    }

    @Then("the FreshPass promotional banner should be visible")
    public void verifyFreshPassBanner() {
        checkoutPage.verifyFreshPassBanner();
    }

    @Then("the place order button should remain disabled until required details are completed")
    public void verifyPlaceOrderDisabled() {
        checkoutPage.verifyPlaceOrderButtonDisabled();
    }

    @When("the user navigates back to the cart")
    public void navigateBackToCart() {
        cartPage.navigateBackToCart();
    }

    @When("the user removes the product from the cart")
    public void removeProductFromCart() {
        cartPage.removeProductFromCart();
    }

    @Then("the cart should display an empty cart message {string}")
    public void verifyEmptyCartMessage(String emptyCartMessage) {
        cartPage.verifyEmptyCartMessage(emptyCartMessage);
    }
}