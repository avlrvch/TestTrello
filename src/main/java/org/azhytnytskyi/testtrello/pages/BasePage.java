package org.azhytnytskyi.testtrello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    
    private WebElement explicitWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    
    protected void clickButton(By query){
        WebElement element = driver.findElement(query);
        element.click();
    }
    
    protected boolean isElementDisplayed(By query){
        WebElement element = driver.findElement(query);
        return element.isDisplayed();
    }
    
    protected boolean isElementPresent(By query){
        WebElement element = driver.findElement(query);
        return element.isDisplayed() && element.isEnabled();
    }
    
    protected void inputText(By query, String text){
        WebElement element = driver.findElement(query);
        element.clear();
        element.sendKeys(text);
    }
    
    protected String getElementText(By query){
        WebElement element = driver.findElement(query);
        explicitWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(element));
        
        if (element.getAttribute("value") != null) {
            return element.getAttribute("value");
        } else{
            return element.getText();
        }
    }

    

}
