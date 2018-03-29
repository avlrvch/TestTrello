


import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.azhytnytskyi.testtrello.pages.TrelloSignUpPage;
import org.azhytnytskyi.testtrello.util.RandomUserDataGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestTrelloSignUpPage extends BaseTest {
    
    private TrelloSignUpPage trelloSignUpPage;
    
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://trello.com/signup");
        trelloSignUpPage = new TrelloSignUpPage(driver);
    }
    
    @After
    public void tearDown(){
        driver.close();
    }
    
    @Test
    public void testThatAllFieldsLabelsHaveAppropriateName(){
        Assert.assertEquals(trelloSignUpPage.getNameLabelText(), "Name");
        Assert.assertEquals(trelloSignUpPage.getEmailLabelText(), "Email");    
        Assert.assertEquals(trelloSignUpPage.getPasswordLabelText(), "Password");        
    }
           
    @Test
    public void testThatNameFieldCanBeEditted(){
        trelloSignUpPage.enterTextInNameField("new user");
        Assert.assertEquals("new user", trelloSignUpPage.getTextFromNameField());
        trelloSignUpPage.enterTextInNameField("");
        Assert.assertEquals("", trelloSignUpPage.getTextFromNameField());
    }
    
    @Test
    public void testThatEmailFieldCanBeEditted(){
        trelloSignUpPage.enterTextInEmailField("newuser@testmail.com");
        Assert.assertEquals("newuser@testmail.com", trelloSignUpPage.getTextFromEmailField());
        trelloSignUpPage.enterTextInEmailField("");
        Assert.assertEquals("", trelloSignUpPage.getTextFromEmailField());
    }
    
    @Test
    public void testThatPasswordFieldCanBeEditted(){
        trelloSignUpPage.enterTextInPasswordField("12345678");
        Assert.assertEquals("12345678", trelloSignUpPage.getTextFromPasswordField());
        trelloSignUpPage.enterTextInPasswordField("");
        Assert.assertEquals("", trelloSignUpPage.getTextFromPasswordField());
    }
    
    @Test
    public void testThatCreateNewAccountButtonBecomesAvailableAfterFillingAllField(){
        trelloSignUpPage.clearAllFields();
        Assert.assertFalse(trelloSignUpPage.isSignUpButtonPresent());
        
        trelloSignUpPage.enterTextInNameField("test user");
        trelloSignUpPage.enterTextInEmailField("testUser@test.com");
        trelloSignUpPage.enterTextInPasswordField("12345678");
        Assert.assertTrue(trelloSignUpPage.isSignUpButtonPresent());
    }
    
    @Test
    public void testTheWarningMessageWhenTypingInvalidEmail(){
        trelloSignUpPage.enterTextInEmailField("invalidEmail");
        trelloSignUpPage.clickBlankArea();
        Assert.assertEquals("That doesn't look like an email address…", trelloSignUpPage.getWrongEmailErrorMessageText());
    }
    
    @Test
    public void testTheWarningMessageWhenTypingPasswordLessThan8Characters(){
        trelloSignUpPage.enterTextInNameField("testuser");
        trelloSignUpPage.enterTextInEmailField("testuser@test.com");
        trelloSignUpPage.enterTextInPasswordField("1234567");
        trelloSignUpPage.clickSignUpButton();
        Assert.assertEquals("Password must be at least 8 characters.", trelloSignUpPage.getCreateNewAccountWarningMessageText());
    }
    
    // using personal email for this case
    @Test
    public void testTheWarningMessageWhenCreatingNewAccountWithAlreadyExistingUnconfirmedEmail(){
        trelloSignUpPage.enterTextInNameField("testuser");
        trelloSignUpPage.enterTextInEmailField("avalerievich91@gmail.com");
        trelloSignUpPage.enterTextInPasswordField("12345678");
        trelloSignUpPage.clickSignUpButton();
        Assert.assertEquals("Email already in use by an unconfirmed account. You can use log in or use the forgot password page to reset your password.", 
                trelloSignUpPage.getCreateNewAccountWarningMessageText());
    }
    
    // using personal email for this case
    @Test
    public void testTheWarningMessageWhenCreatingNewAccountWithAlreadyExistingdEmail(){
        trelloSignUpPage.enterTextInNameField("testuser");
        trelloSignUpPage.enterTextInEmailField("a.zhytnytskyy@gmail.com");
        trelloSignUpPage.enterTextInPasswordField("12345678");
        trelloSignUpPage.clickSignUpButton();
        Assert.assertEquals("Email already in use by another account. You can use log in or use the forgot password page to reset your password.", 
                trelloSignUpPage.getCreateNewAccountWarningMessageText());
    }
    
    @Test
    public void testThatSignUpWithGoogleButtonDisappearsWhenNameAndEmailFieldsAreNotEmpty(){
        Assert.assertTrue(trelloSignUpPage.isSignUpWithGoogleButtonPresent());
        trelloSignUpPage.enterTextInNameField("testuser");
        trelloSignUpPage.enterTextInEmailField("testuser@test.com");
        Assert.assertFalse(trelloSignUpPage.isSignUpWithGoogleButtonPresent());
    }    

   //ignoring this test not to spam into Trello DB  
    @Ignore
    @Test
    public void testTheCreateNewAccountFlow(){
        trelloSignUpPage.enterTextInNameField(RandomUserDataGenerator.generateRandomName(10));
        trelloSignUpPage.enterTextInEmailField(RandomUserDataGenerator.generateRandomEmail());
        trelloSignUpPage.enterTextInPasswordField(RandomUserDataGenerator.generateRandomPassword(12));
        trelloSignUpPage.clickSignUpButton();
    }
}
