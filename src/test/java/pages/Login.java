package pages;

public class Login extends BasePage {

    // Constructor
    public Login(){
        super();
    }

    // Locators    
    public String loginLogo = "//div[@class='login_logo']";
    public String usernameInput = "//input[@id='user-name']"; 
    public String passwordInput = "//input[@id='password']";
    public String loginButton = "//input[@id='login-button']";
    private String url = "https://www.saucedemo.com/";

    // Methods
    public void navigateToLoginPage() {
        navigateTo(url);
    }

    public void enterCredentials(String username, String password){
        write(usernameInput, username);
        write(passwordInput, password);
    }

    public void clickLoginButton(){
        clickElement(loginButton);
    }

    public String logoText(){
        return textFromElement(loginLogo);
    }

    public String errorMessage(){
        return textFromMessage("Epic sadface");
    }

}