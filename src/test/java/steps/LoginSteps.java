package steps;

import pages.Login;
import pages.Products;

import org.junit.Assert;
import io.cucumber.java.en.*;

public class LoginSteps {

    Login login = new Login();
    Products products = new Products();

    // Scenario 1
    @Given("the user navigates to Swag Labs login page")
    public void navigatoToSwagLabs(){
        login.navigateToLoginPage(); 
        Assert.assertTrue("Some element is missing", login.elementsDisplayed(new String[] {
            login.loginLogo,
            login.usernameInput,
            login.passwordInput,
            login.loginButton
        }));
    }

    @When("he enters username {word} and password {word}")
    public void enterCredentials(String username, String password){
        login.enterCredentials(username, password);
    }

    @And("clicks the login button")
    public void clickLoginButton(){
        login.clickLoginButton();
    }

    @Then("the user should have access to the Products Page")
    public void successLogin(){
        Assert.assertTrue("Some element is missing",products.elementsDisplayed(new String[] {
            products.appLogo,
            products.title,
            products.inventory
        }));
        Assert.assertEquals("The text doesn't match","Swag Labs",products.logoText());
        Assert.assertEquals("The text doesn't match","Products",products.titleText());
    }

    // Scenario 2
    @Then("an error message should be displayed")
    public void errorMessage(){
        Assert.assertEquals("The message is not displayed", "Epic sadface: Username and password do not match any user in this service",login.errorMessage());
    }

    @And("the user should not have access to the website")
    public void notAccess(){
        Assert.assertTrue("The Login logo is not displayed",login.elementDisplayed(login.loginLogo));
        Assert.assertFalse("The inventory is displayed",products.isNowDisplayed(products.inventory));
    }

    // Scenario 3
    @Then("an informative message should be displayed")
    public void lockedMessage(){
        Assert.assertEquals("The message is not displayed", "Intentional failure test",login.errorMessage());
    }

    // Scenario Background
    @Given("the user has successfully logged in to Swag Labs")
    public void userLoggedIn(){
        login.navigateToLoginPage();
        login.enterCredentials("standard_user", "secret_sauce");
        login.clickLoginButton();
        Assert.assertTrue("Some element is missing", products.elementsDisplayed(new String[] {
            products.appLogo,
            products.title,
            products.inventory
        }));
    }

    @And("is on the Products Page")
    public void userOnProductsPage() {
        Assert.assertEquals("The text doesn't match", "Swag Labs", products.logoText());
        Assert.assertEquals("The text doesn't match", "Products", products.titleText());
    }
    
}