package section04;

import org.config.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.pages.MainPage.ACTIONS;

public class L04_LocatingByLinkText extends BaseTest {

    @BeforeMethod
    private void beforeMethod() {
        setUp();
        driver.get("https://www.automationtesting.co.uk");
    }

    @Test(description = "click the button")
    void verifyTheActionsLinkTest() throws InterruptedException {
        driver.findElement(ACTIONS).click();
        assert driver.getCurrentUrl().equals("https://www.automationtesting.co.uk/actions.html");
        Thread.sleep(3000);
    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }
}
