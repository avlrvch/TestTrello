


import java.util.concurrent.TimeUnit;
import org.azhytnytskyi.testtrello.pages.TrelloHomePage;
import org.azhytnytskyi.testtrello.pages.TrelloLogInPage;
import org.azhytnytskyi.testtrello.pages.TrelloSignUpPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestTrelloHomePage extends BaseTest {
    
    private TrelloHomePage trelloHomePage;
    
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://trello.com/home");
        trelloHomePage = new TrelloHomePage(driver);
    }
    
    @After
    public void tearDown() {
        driver.close();
    }
    
    @Test
    public void checkIfHeaderLoginPageIsPresent(){
        Assert.assertTrue(trelloHomePage.isHeaderLoginButtonPresent());
    }
    
    @Test
    public void checkIfHeaderSignUpPageIsPresent(){
        Assert.assertTrue(trelloHomePage.isHeaderSignUpButtonPresent());
    }
    
    @Test
    public void checkIfBodyLoginButtonIsPresent(){
        Assert.assertTrue(trelloHomePage.isBodyLoginButtonPresent());
    }
    
    @Test
    public void checkIfBodySignUpButtonIsPresent(){
        Assert.assertTrue(trelloHomePage.isBodySignUpButtonPresent());
    }
    
    @Test
    public void testThatHeaderLoginButtonFunctionality(){
        TrelloLogInPage trelloLoginPage = trelloHomePage.clickOnHeaderLoginButton();
        Assert.assertEquals("Log in to Trello", trelloLoginPage.getLoginPageH1Text());
    }
    
    @Test
    public void testThatBodyLoginButtonFunctionality(){
        TrelloLogInPage trelloLoginPage = trelloHomePage.clickOnBodyLoginButton();
        Assert.assertEquals("Log in to Trello", trelloLoginPage.getLoginPageH1Text());
    }
    
    @Test
    public void testThatHeaderSignUpButtonFunctionality(){
        TrelloSignUpPage trelloSignUpPage = trelloHomePage.clickOnHeaderSignUpButton();
        Assert.assertEquals("Create a Trello Account", trelloSignUpPage.getSignUpH1Text());
    }
    
    @Test
    public void testThatBodySignUpButtonFunctionality(){
        TrelloSignUpPage trelloSignUpPage = trelloHomePage.clickOnBodySignUpButton();
        Assert.assertEquals("Create a Trello Account", trelloSignUpPage.getSignUpH1Text());
    }
    
}
