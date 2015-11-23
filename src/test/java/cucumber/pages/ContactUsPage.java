package cucumber.pages;

import cucumber.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cucumber.helpers.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@Component
public class ContactUsPage extends AbstractPage {

    //@Autowired
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    ElementsHelper elementsHelper = new ElementsHelper();

    public static final String FIELD_REQUIRED = "Please fill the required field.";
    public static final String GENERAL_VALIDATION_ERROR = "Validation errors occurred. Please confirm the fields and submit it again.";
    public static final String EMAIL_VALIDATION_FORMAT_ERROR="Email address seems invalid.";
    public static final String EMAIL_SENT_SUCCESSFULLY = "Your message was sent successfully. Thank you and someone will be in contact with you shortly.";

    private By byContactUsLink = By.cssSelector("#menu-item-497");
    private By byPostCode = By.cssSelector("#content-wrapper > div > div.eight.column > div:nth-child(4) > div > div.nine.column > p");
    private By byEmail = By.cssSelector("#wpcf7-f682-p495-o1 > form > p:nth-child(6) > span > input");
    private By byMessageText = By.cssSelector("#wpcf7-f682-p495-o1 > form > p:nth-child(8) > span > textarea");
    private By byName = By.cssSelector("#wpcf7-f682-p495-o1 > form > p:nth-child(2) > span > input");
    private By byCompany = By.cssSelector("#wpcf7-f682-p495-o1 > form > p:nth-child(3) > span > input");
    private By byLocation = By.cssSelector("#wpcf7-f682-p495-o1 > form > p:nth-child(4) > span > input");
    private By byTelephone = By.cssSelector("#wpcf7-f682-p495-o1 > form > p:nth-child(5) > span > input");
    private By bySubject = By.cssSelector("#wpcf7-f682-p495-o1 > form > p:nth-child(7) > span > input");
    private By bySendButton = By.cssSelector("#wpcf7-f682-p495-o1 > form > p:nth-child(9) > input");
    private By byNameRequiredField = By.cssSelector("#wpcf7-f682-p495-o1 > form > p:nth-child(2) > span > span");
    private By byCompanyRequiredField = By.cssSelector("#wpcf7-f682-p495-o1 > form > p:nth-child(3) > span > span");
    private By byLocationRequiredField = By.cssSelector("#wpcf7-f682-p495-o1 > form > p:nth-child(4) > span > span");
    private By byValidationErrorsField = By.cssSelector("#wpcf7-f682-p495-o1 > form > div.wpcf7-response-output.wpcf7-display-none.wpcf7-validation-errors");
    private By byEmailRequiredField = By.cssSelector("#wpcf7-f682-p495-o1 > form > p:nth-child(6) > span > span");
    private By byEmailClientEnquiries = By.cssSelector("#content-wrapper > div > div.eight.column > div:nth-child(5) > div > div.nine.column > p:nth-child(1) > a");
    private By byEmailSupportEnquiries = By.cssSelector("#content-wrapper > div > div.eight.column > div:nth-child(5) > div > div.nine.column > p:nth-child(2) > a");
    private By byEmailSentSuccessfully = By.cssSelector("#wpcf7-f682-p495-o1 > form > div.wpcf7-response-output.wpcf7-display-none.wpcf7-mail-sent-ok");


    public void clickOnContactUsLink(){
        elementsHelper.clickOnElement(byContactUsLink, webDriver);
    }

    public boolean checkText(String postcode) {
        return  elementsHelper.containsText(byPostCode,postcode,webDriver);
    }

    public void enterEmailAddress(String email) {
        elementsHelper.enterText(byEmail,email,webDriver);
    }

    public void enterMessageText(String message) {
        elementsHelper.enterText(byMessageText, message, webDriver);
    }

    public void enterName(String name) {
        elementsHelper.enterText(byName, name, webDriver);
    }

    public void enterCompany(String company) {
        elementsHelper.enterText(byCompany,company,webDriver);
    }

    public void enterLocation(String location) {
        elementsHelper.enterText(byLocation,location,webDriver);
    }

    public void enterSubject(String subject) {
        elementsHelper.enterText(bySubject, subject, webDriver);
    }

    public void enterTelephone(String phone) {
        elementsHelper.enterText(byTelephone,phone,webDriver);
    }

    public void clickOnSendButton() {
        elementsHelper.clickOnElement(bySendButton, webDriver);
    }

    public void assertNameRequired() {
        assertThat("Assertion message for name required", elementsHelper.containsText(byNameRequiredField, FIELD_REQUIRED, webDriver), is(true));
    }

    public void assertCompanyRequired() {
        assertThat("Assertion message for company required", elementsHelper.containsText(byCompanyRequiredField, FIELD_REQUIRED, webDriver), is(true));
    }

    public void assertLocationRequired() {
        assertThat("Assertion message for Location required", elementsHelper.containsText(byLocationRequiredField, FIELD_REQUIRED, webDriver), is(true));
    }

    public void assertEmailRequired() {
        assertThat("Assertion message for email required", elementsHelper.containsText(byEmailRequiredField, FIELD_REQUIRED, webDriver), is(true));
    }

    public void assertGeneralValidationErrors() {
        assertThat("Validation error not correct",elementsHelper.containsText(byValidationErrorsField,GENERAL_VALIDATION_ERROR,webDriver),is(true));
    }

    public void assertEmailIsPresentClientEnquiries(String email) {
        assertThat("Email not present for Client Enquiries",elementsHelper.containsText(byEmailClientEnquiries,email, webDriver),is(true));
    }


    public void assertEmailIsPresentSuppportEnquiries(String email) {
        assertThat("Email not present for Support Enquiries",elementsHelper.containsText(byEmailSupportEnquiries,email, webDriver),is(true));
    }


    public void assertEmailValidationFormat() {
        assertThat("Email format error missing",elementsHelper.containsText(byEmailRequiredField,EMAIL_VALIDATION_FORMAT_ERROR,webDriver),is(true));
    }

    public void assertEmailWasSentSuccessfully() {
        assertThat("Email not sent successfully", elementsHelper.containsText(byEmailSentSuccessfully,EMAIL_SENT_SUCCESSFULLY,webDriver),is(true));
    }
}
