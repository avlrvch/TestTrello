
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.azhytnytskyi.testtrello.pages.TrelloLogInPage;
import org.azhytnytskyi.testtrello.pages.TrelloSignUpPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestTrelloLogInPage extends BaseTest {

    private TrelloLogInPage trelloLogInPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://trello.com/login");
        trelloLogInPage = new TrelloLogInPage(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testIfHeadingH1HasAppropriateText() {
        Assert.assertEquals("Log in to Trello", trelloLogInPage.getLoginPageH1Text());
    }

    @Test
    public void testCreateAnAccountButtonFunctionality() {
        TrelloSignUpPage trelloSignUpPage = trelloLogInPage.clickOnCreateAnAccountButton();
        Assert.assertEquals("Create a Trello Account", trelloSignUpPage.getSignUpH1Text());
    }

    @Test
    public void testThatAllFieldsLabelsHaveAppropriateName() {
        Assert.assertEquals("Email (or username)", trelloLogInPage.getEmailOrUserLabelText());
        Assert.assertEquals("Password", trelloLogInPage.getPasswordLabelText());
    }

    @Test
    public void testThatEmailFieldCanBeEditted() {
        trelloLogInPage.enterTextInEmailOrUsernameField("user@test.com");
        Assert.assertEquals("user@test.com", trelloLogInPage.getTextFromEmailOrUserField());
        trelloLogInPage.enterTextInEmailOrUsernameField("");
        Assert.assertEquals("", trelloLogInPage.getTextFromEmailOrUserField());
    }

    @Test
    public void testThatPasswordFieldCanBeEditted() {
        trelloLogInPage.enterTextInPasswordField("12345678");
        Assert.assertEquals("12345678", trelloLogInPage.getTextFromPasswordField());
        trelloLogInPage.enterTextInPasswordField("");
        Assert.assertEquals("", trelloLogInPage.getTextFromPasswordField());
    }

    @Test
    public void testThatMissingEmailWarningAppears() {
        trelloLogInPage.clickLoginButton();
        System.out.println(trelloLogInPage.getErrorMessageText());
        Assert.assertEquals("Missing email", trelloLogInPage.getErrorMessageText());
    }

    @Test
    public void testThatThereIsNoSuchAccountWarningAppears() {
        trelloLogInPage.enterTextInEmailOrUsernameField("username@test.com");
        trelloLogInPage.clickLoginButton();
        Assert.assertEquals("There isn't an account for this email", trelloLogInPage.getErrorMessageText());
    }

    // using personal email for this case    
    @Test
    public void testThatInvalidPasswordWarningAppears() {
        trelloLogInPage.enterTextInEmailOrUsernameField("avalerievich91@gmail.com");
        trelloLogInPage.clickLoginButton();
        Assert.assertEquals("Invalid password", trelloLogInPage.getErrorMessageText());
    }

}
