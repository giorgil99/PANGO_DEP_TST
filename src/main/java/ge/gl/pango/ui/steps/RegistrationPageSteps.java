package ge.gl.pango.ui.steps;

import ge.gl.pango.ui.elements.RegistrationPageElements;

import static com.codeborne.selenide.Condition.visible;

public class RegistrationPageSteps extends RegistrationPageElements {
    public RegistrationPageSteps SetName(String txt) {
        getFirstName().shouldBe(visible).sendKeys(txt);
        return this;
    }

    public RegistrationPageSteps setLastName(String txt) {
        getLastName().shouldBe(visible).sendKeys(txt);
        return this;
    }


    public RegistrationPageSteps setMail(String txt) {
        getEmail().shouldBe(visible).sendKeys(txt);
        return this;
    }

    public RegistrationPageSteps setTelephone(String txt) {
        getTelephone().shouldBe(visible).sendKeys(txt);
        return this;
    }

    public RegistrationPageSteps setPassword(String txt) {
        getPassword().shouldBe(visible).sendKeys(txt);
        return this;
    }

    public RegistrationPageSteps confirmPassword(String txt) {
        getPasswordConfirmation().shouldBe(visible).sendKeys(txt);
        return this;
    }


    public RegistrationPageSteps clickOnNewsletter() {
        getNewsletter().shouldBe().click();
        return this;
    }


    public RegistrationPageSteps clickOnPrivacyPolicy() {
        getPrivacyPolicy().shouldBe(visible).click();
        return this;
    }


    public RegistrationPageSteps clickOnSubmit() {
        getSubmit().shouldBe(visible).click();
        return this;
    }
}
