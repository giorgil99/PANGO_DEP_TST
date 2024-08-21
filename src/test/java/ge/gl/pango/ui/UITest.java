package ge.gl.pango.ui;

import com.codeborne.selenide.Condition;
import ge.gl.pango.ui.cfg.GetWebConnection;
import ge.gl.pango.ui.steps.MainPageSteps;
import ge.gl.pango.ui.steps.RegistrationPageSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class UITest {

    @BeforeTest
    public void startBrowser() {
        GetWebConnection connection = new GetWebConnection();
        connection.ConnectToPage();
    }


    @Test(priority = 0, description = "opening registration page")
    public void openRegisterPageTest() {
        MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.clickOnMyAccountButton()
                .clickOnRegisterButton();
        RegistrationPageSteps regPageSteps = new RegistrationPageSteps();

        regPageSteps.getPrivacyPolicy().shouldBe(Condition.visible).shouldNotBe(Condition.disabled);
        regPageSteps.getNewsletter().shouldBe(Condition.visible).shouldNotBe(Condition.disabled);
        regPageSteps.getSubmit().shouldBe(Condition.visible).shouldNotBe(Condition.disabled);

    }

    @Test(priority = 1, dependsOnMethods = "openRegisterPageTest", description = "registering new customer")
    public void registerAndLoginTest() {
        RegistrationPageSteps regPageSteps = new RegistrationPageSteps();
        String changingMale = "giolemo@gmail.com";
        Random random = new Random();
        changingMale = random.nextInt(5000, 9000) + changingMale;
        regPageSteps.SetName("gio")
                .setLastName("lemo")
                .setMail(changingMale)
                .setTelephone("590232323")
                .setPassword("passMeAword")
                .confirmPassword("passMeAword")
                .clickOnNewsletter()
                .clickOnPrivacyPolicy()
                .clickOnSubmit();
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertEquals(regPageSteps.getSuccessValidationMessage().shouldBe(Condition.visible).getText(), expectedMessage);

    }
}
