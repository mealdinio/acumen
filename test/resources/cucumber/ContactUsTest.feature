Feature: Contact Us page
  As an end user
  I want a contact us page
  So that I can find contact details for Acumen
  And get in touch to find out more

#  To improve the tests I would just go directly to the contact us page
#  Adding assertion for email client enquiries and telephone and email for support enquiries.
  Scenario: Accurate Address
    Given I am on the Acumen home page
    When I navigate to the Contact Us page
    Then I should see an accurate postcode "TW9 1HY"
    And I should see correct email "info@acumenci.com" for Client Enquiries
    And I should see correct email "support@acumenci.com" for Support Enquiries


#    Improvements: Separating the submission so I can test all the possible combinations separately in different scenarios
#  Separating also the errors
#  Making all the inputs variable
#  Switching And all other input fields are blank to click on send button
  Scenario: Submission Validation sending email address and message text
    Given I am on the Acumen Contact Us page
    When I submit an e-mail address "testuser@gmail.com"
    And I submit a message text "test message"
#    And all other input fields are blank
    And I click on send button
    Then I should see an error validation for name
    And I should see an error validation for company
    And I should see an error validation for location
    And I should see errors about the other required fields

  Scenario: Submission Validation sending just email address
    Given I am on the Acumen Contact Us page
    When I submit an e-mail address "testuser@gmail.com"
    And I click on send button
    Then I should see an error validation for name
    And I should see an error validation for company
    And I should see an error validation for location
    And I should see errors about the other required fields

  Scenario: Submission Validation sending Name, company, location and not email address
    Given I am on the Acumen Contact Us page
    When I submit a name "Maria"
    And I submit a company "Apple"
    And I submit a location "London"
    And I click on send button
    Then I should see an error validation for email address
    And I should see errors about the other required fields

  Scenario: Submission Validation sending only a non required field such as subject
    Given I am on the Acumen Contact Us page
    When I submit a subject "Test subject"
    And I click on send button
    Then I should see errors about the other required fields
    Then I should see an error validation for name
    And I should see an error validation for company
    And I should see an error validation for location
    And I should see an error validation for email address
    And I should see errors about the other required fields

  Scenario: Try to send invalid email address and check that the format is being validated successfully
    Given I am on the Acumen Contact Us page
    When I submit a name "Test Name"
    And I submit a company "Test Company"
    And I submit a location "Test Location"
    And I submit an e-mail address "test"
    And I click on send button
    Then I should see an error validation format for email address

  Scenario: Fill in the required fields and check that the email is being sent successfully
    Given I am on the Acumen Contact Us page
    When I submit a name "Test Name"
    And I submit a company "Test Company"
    And I submit a location "Test Location"
    And I submit an e-mail address "testuser@gmail.com"
    And I click on send button
    Then the submission should be successful