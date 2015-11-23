package cucumber.StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.pages.ContactUsPage;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@ContextConfiguration("classpath:cucumber.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ContactUsStepDefinition{

    public ContactUsPage contactUsPage = new ContactUsPage(new FirefoxDriver());

    @Given("^I am on the Acumen home page$")
    public void I_am_on_the_Acumen_home_page() throws Throwable {
        contactUsPage.getWebDriver().get("http://www.acumenci.com/");
    }

    @When("^I navigate to the Contact Us page$")
    public void I_navigate_to_the_Contact_Us_page() throws Throwable {
        try{
            Thread.sleep(4020);
        } catch (Exception e){}
        contactUsPage.clickOnContactUsLink();
    }

    @Then("^I should see an accurate postcode \"([^\"]*)\"$")
    public void I_should_see_an_accurate_postcode(String postcode) throws Throwable {
        assertTrue(contactUsPage.checkText(postcode));
    }

    @Given("^I am on the Acumen Contact Us page$")
    public void I_am_on_the_Acumen_Contact_Us_page() throws Throwable {
        WebDriver driver = contactUsPage.getWebDriver();
        driver.get("http://www.acumenci.com/contact-us/");
    }

    @When("^I submit an e-mail address \"([^\"]*)\"$")
    public void I_submit_just_an_e_mail_address_and_message_text(String email) throws Throwable {
        contactUsPage.enterEmailAddress(email);
    }

    @And("^I submit a message text \"([^\"]*)\"$")
    public void I_submit_a_message_text(String message) throws Throwable {
        contactUsPage.enterMessageText(message);
    }

    @And("^all other input fields are blank$")
    public void all_other_input_fields_are_blank() throws Throwable {
        contactUsPage.clickOnSendButton();
    }

    @When("^I submit a name \"([^\"]*)\"$")
    public void I_submit_a_name(String name) throws Throwable {
        contactUsPage.enterName(name);
    }

    @And("^I submit a company \"([^\"]*)\"$")
    public void I_submit_a_company(String company) throws Throwable {
        contactUsPage.enterCompany(company);
    }

    @And("^I submit a location \"([^\"]*)\"$")
    public void I_submit_a_location(String location) throws Throwable {
        contactUsPage.enterLocation(location);
    }

    @When("^I submit a subject \"([^\"]*)\"$")
    public void I_submit_a_subject(String subject) throws Throwable {
        contactUsPage.enterSubject(subject);
    }

    @And("^I submit a telephone \"([^\"]*)\"$")
    public void I_submit_a_telephone(String phone) throws Throwable {
        contactUsPage.enterTelephone(phone);
    }

    @Then("^I should see an error validation for name$")
    public void I_should_see_an_error_validation_for_name() throws Throwable {
        contactUsPage.assertNameRequired();
    }


    @And("^I should see an error validation for company$")
    public void I_should_see_an_error_validation_for_company() throws Throwable {
        contactUsPage.assertCompanyRequired();
    }

    @And("^I should see an error validation for location$")
    public void I_should_see_an_error_validation_for_location() throws Throwable {
        contactUsPage.assertLocationRequired();
    }

    @Then("^I should see an error validation for email address$")
    public void I_should_see_an_error_validation_for_email_address() throws Throwable {
        contactUsPage.assertEmailRequired();
    }

    @Then("^I should see errors about the other required fields$")
    public void I_should_see_errors_about_the_other_required_fields() throws Throwable {
        contactUsPage.assertGeneralValidationErrors();
        contactUsPage.getWebDriver().close();
    }

    @Then("^I should see correct email \"([^\"]*)\" for Client Enquiries$")
    public void I_should_see_correct_email_for_Client_Enquiries(String email) throws Throwable {
        contactUsPage.assertEmailIsPresentClientEnquiries(email);
    }

    @And("^I should see correct email \"([^\"]*)\" for Support Enquiries$")
    public void I_should_see_correct_email_for_Support_Enquiries(String email) throws Throwable {
        contactUsPage.assertEmailIsPresentSuppportEnquiries(email);
    }


    @And("^I click on send button$")
    public void I_click_on_send_button() throws Throwable {
        contactUsPage.clickOnSendButton();
    }

    @Then("^I should see an error validation format for email address$")
    public void I_should_see_an_error_validation_format_for_email_address() throws Throwable {
        contactUsPage.assertEmailValidationFormat();
    }

    @Then("^the submission should be successful$")
    public void the_submission_should_be_successful() throws Throwable {
        contactUsPage.assertEmailWasSentSuccessfully();
    }
}
