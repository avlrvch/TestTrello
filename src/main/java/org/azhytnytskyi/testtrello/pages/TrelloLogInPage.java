package org.azhytnytskyi.testtrello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrelloLogInPage extends BasePage {

    public TrelloLogInPage(WebDriver driver) {
        super(driver);
    }
    
    private By loginTextH1 = By.xpath("//div[@class='layout-twothirds-center']//h1");
    private By loginButton = By.xpath("//div[@class='layout-twothirds-center']//input[@id='login']");
    private By createAnAccountButton = By.xpath("//div[@class='layout-twothirds-center']//a[@id='signup']");
    private By errorMessage = By.xpath("//div[@id='error']/p");

    private By emailOrUsernameField = By.xpath("//div[@class='layout-twothirds-center']//input[@id='user']");
    private By passwordField = By.xpath("//div[@class='layout-twothirds-center']//input[@id='password']");
    private By emailOrUsernameLabel = By.xpath("//div[@class='layout-twothirds-center']//label[@for='user']");
    private By passwordLabel = By.xpath("//div[@class='layout-twothirds-center']//label[@for='password']");

    public String getLoginPageH1Text() {
        return super.getElementText(loginTextH1);
    }

    public void enterTextInEmailOrUsernameField(String text) {
        super.inputText(emailOrUsernameField, text);
    }

    public void enterTextInPasswordField(String text) {
        super.inputText(passwordField, text);
    }

    public String getTextFromEmailOrUserField() {
        return super.getElementText(emailOrUsernameField);
    }

    public String getTextFromPasswordField() {
        return super.getElementText(passwordField);
    }

    //This should return project page which is not covered in this project, so it returns nothing
    public void clickLoginButton() {
        super.clickButton(loginButton);
    }

    public String getEmailOrUserLabelText() {
        return super.getElementText(emailOrUsernameLabel);
        
    }

    public String getPasswordLabelText() {
        return super.getElementText(passwordLabel);
    }

    public TrelloSignUpPage clickOnCreateAnAccountButton() {
        super.clickButton(createAnAccountButton);
        return new TrelloSignUpPage(this.driver);
    }

    public String getErrorMessageText() {
        return super.getElementText(errorMessage);
    }
}
