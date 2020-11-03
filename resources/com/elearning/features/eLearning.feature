@eLearning
Feature: Registration on eLearning

  Background: 
    Given Launch webbrowser and eLearning website

  @signup
  Scenario Outline: Signup
    When Select language as "<language>"
    And Click SignUp for registration in order to "<purpose>"
    And Enter user fname & lname as "<fname>" "<lname>"
    And Enter user emailId as "<email>"
    And Enter username & password details "<username>" "<pass>"
    And Validate strength of password
    And Enter user phone "<phone>"
    And Verify language dropdown has "<language>"
    And Enter code Skype and linkedin details "<code>" "<skypeid>" "<linkedinUrl>"
    And Click on register
    Then User user redirected to success page
    And Verify success page message
    And Validate email on success page

    Examples: 
      | language | purpose       | fname  | lname | email                 | username   | pass       | phone      | code | skypeid  | linkedinUrl                           |
      | English  | Teach courses | Satish | Wadde | satwadde101@us.ibm.com | satwadde101 | satwadde101 | 2018397218 | 1234 | satishwadde | https://www.linkedin.com/in/satishwadde/ |

  @signinEmailVal
  Scenario Outline: SignIn & Email validation
    When Enter username and pass "<username>" "<pass>"
    And Click on Login button
    And Validate logged in user "<expected_email>"

    Examples: 
      | expected_email  | username | pass      |
      | balub@gmail.com | balub124 | rutvik123 |

  @compose_email
  Scenario Outline: Compose message & send
    When Enter username and pass "<username>" "<pass>"
    And Click on Login button
    And Validate logged in user "<email>"
    And Choose Compose option to send message
    And Enter receiver details "<sendTo>"
    And Enter subject "<subject>"
    And Type message to sent
    And Upload file "<file_path>" as attachment
    And Send message
    Then Message is sent successfully and acknowledgement shown

    Examples: 
      | email           | username | pass      | sendTo | subject      | file_path                                           |
      | balub@gmail.com | balub124 | rutvik123 | satish | Test subject | C://Users//SatishWadde//Desktop//SDET//TestFile.txt |
