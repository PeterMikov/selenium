package section05;

import org.config.BaseTest;
import org.openqa.selenium.WebElement;
import org.pages.ContactForm;
import org.testng.Assert;
import org.testng.annotations.*;

public class ContactFormTest extends BaseTest {

    @BeforeTest
    private void beforeTest() {
        setUp();
        driver.get("https://www.automationtesting.co.uk/contactForm.html");
    }

    @Test(description = "click the button")
    void fillInTheContactFormTestAndSubmit() throws InterruptedException {
        var contactForm = new ContactForm(driver);
        contactForm.enterFirstName("Petar");
        contactForm.enterLastName("Mikov");
        contactForm.enterEmail("pmikov@yahoo.com");
        contactForm.enterMessage("Hello Dudes!");
        contactForm.clickSubmitButton();
        Thread.sleep(2000);
        WebElement thankYouMessage = driver.findElement(contactForm.thankYouMessage);
        String message = thankYouMessage.getText();
        Assert.assertEquals(message, "Thank you for your mail!", "Messages do not match!");
    }

    @Test(description = "click the button")
    void fillInTheContactFormTestAndReset() throws InterruptedException {
        var contactForm = new ContactForm(driver);
        contactForm.enterFirstName("Petar");
        contactForm.enterLastName("Mikov");
        contactForm.enterEmail("pmikov@yahoo.com");
        contactForm.enterMessage("Hello Dudes!");
        contactForm.clickResetButton();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(contactForm.firstNameField).getAttribute("placeholder").equals("First Name"));
    }

    @AfterTest
    private void tearDown() {
        driver.quit();
    }

}
