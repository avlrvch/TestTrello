
package org.azhytnytskyi.testtrello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class TrelloHomePage extends BasePage {
    
    public TrelloHomePage(WebDriver driver) {
        super(driver);
    }
    
    private By headerLoginButton = By.xpath("//div[@class='global-header-section mod-right']/a[1]");
    private By headerSignUpButton = By.xpath("//div[@class='global-header-section mod-right']/a[2]");
    private By signUpBodyButton = By.xpath("//div[@class='layout-centered-content']//a[@data-track='Sign Up']");
    private By logInBodyButton = By.xpath("//div[@class='layout-centered-content']//a[@data-track='Login']");    
    private By trelloH1 = By.xpath("//div[@class='layout-centered']//h1");
    private By trelloImage = By.xpath("//div[@class='layout-centered']//img");
    private By trelloP = By.xpath("//div[@class='layout-centered']//p[1]");
    
    public TrelloLogInPage clickOnHeaderLoginButton(){
        super.clickButton(headerLoginButton);
        return new TrelloLogInPage(this.driver);
    }
    
    public TrelloSignUpPage clickOnHeaderSignUpButton(){
        super.clickButton(headerSignUpButton);
        return new TrelloSignUpPage(this.driver);
    }
        
    public TrelloLogInPage clickOnBodyLoginButton(){
        super.clickButton(logInBodyButton);
        return new TrelloLogInPage(this.driver);
    }
    
    public TrelloSignUpPage clickOnBodySignUpButton(){
        super.clickButton(signUpBodyButton);
        return new TrelloSignUpPage(this.driver);
    }
    
    public String getPText(){
        return super.getElementText(trelloP);
    }
    
    public String getH1Text(){
        return super.getElementText(trelloH1);
    }
    
    public boolean isHeaderLoginButtonPresent(){
        return super.isElementDisplayed(headerLoginButton);
    }
    
    public boolean isHeaderSignUpButtonPresent(){
        return super.isElementDisplayed(headerSignUpButton);
    }
    
    public boolean isBodyLoginButtonPresent(){
        return super.isElementDisplayed(logInBodyButton);
    }
    
    public boolean isBodySignUpButtonPresent(){
        return super.isElementDisplayed(signUpBodyButton);       
    }
    
    private WebElement getElementBy(By by){
        return driver.findElement(by);
    }
    
}
