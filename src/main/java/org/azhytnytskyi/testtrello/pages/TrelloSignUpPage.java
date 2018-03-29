
package org.azhytnytskyi.testtrello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrelloSignUpPage extends BasePage {
    
    public TrelloSignUpPage(WebDriver driver) {
        super(driver);
    }
    
    private By signUpH1Text = By.xpath("//div[@id='signup-password']//h1");
    private By signUpButton = By.xpath("//div[@class='sign-up-container']/input[@id='signup']");
    private By signUpWithGoogleButton = By.xpath("//div[@id='google']/span[@class='label']");
    private By wrongEmailErrorMessage = By.xpath("//div[@id='email-error']");
    
    // error messages itself may be different, but always has the same locator
    private By createNewAccountWarningMessage = By.xpath("//p[@class='error-message']");
    
    private By nameLabel = By.xpath("//div[@class='sign-up-container']/label[@for='name']");
    private By passwordLabel = By.xpath("//div[@class='sign-up-container']/label[@for='password']");
    private By emailLabel = By.xpath("//div[@class='sign-up-container']/label[@for='email']");
    private By nameField = By.xpath("//div[@class='sign-up-container']/input[@name='name']");
    private By passwordField = By.xpath("//div[@class='sign-up-container']/input[@name='password']");
    private By emailField = By.xpath("//div[@class='sign-up-container']/input[@name='email']");
    

    public String getSignUpH1Text(){
        return super.getElementText(signUpH1Text);
    }
    
    public boolean isSignUpWithGoogleButtonPresent(){
        return super.isElementPresent(signUpWithGoogleButton);
    }
    
    public boolean isSignUpButtonPresent(){
        return super.isElementPresent(signUpButton);        
    }
    
    public String getNameLabelText(){
        return super.getElementText(nameLabel);
    }
    
    public String getPasswordLabelText(){
        return super.getElementText(passwordLabel);
    }
    
    public String getEmailLabelText(){
        return super.getElementText(emailLabel);
    }
    
    public void enterTextInNameField(String text){
        super.inputText(nameField, text);
    }
    
    public void enterTextInPasswordField(String text){
        super.inputText(passwordField, text);
    }
    
    public void enterTextInEmailField(String text){
        super.inputText(emailField, text);
    }
    
    public String getWrongEmailErrorMessageText(){
        return super.getElementText(wrongEmailErrorMessage);
    }
    
    public String getCreateNewAccountWarningMessageText(){
        return super.getElementText(createNewAccountWarningMessage);
    }

    public String getTextFromNameField(){
        return super.getElementText(nameField);
    }
    
    public String getTextFromEmailField(){
        return super.getElementText(emailField);
    }
    
    public String getTextFromPasswordField(){
        return super.getElementText(passwordField);
    }
    
    public void clearAllFields(){
        super.inputText(nameField, "");
        super.inputText(emailField, "");
        super.inputText(passwordField, "");
    }
       
    //This should return project page which is not covered in this project, so it returns nothing
    public void clickSignUpButton(){
        super.clickButton(signUpButton);
    }
    
    public void clickBlankArea(){
        driver.findElement(signUpH1Text).click();
    }
}
