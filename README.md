# Login Automation Project

## Project Description

This project automates the testing of a login form using Selenium WebDriver in Java.

Website used:
https://the-internet.herokuapp.com/login

## Tools and Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Google Chrome

## Test Cases Implemented

### Test Case 1: Valid Login

Username: tomsmith  
Password: SuperSecretPassword!

Expected Result:
User should login successfully and redirect to Secure Area page.

---

### Test Case 2: Invalid Login

Username: wrongusername  
Password: wrongpassword

Expected Result:
Error message "Your username is invalid!" should be displayed.

---

### Test Case 3: Empty Fields

Username: Empty  
Password: Empty

Expected Result:
Error message should be displayed.

---

## How to Run the Project

1. Open the project in Eclipse.
2. Right click the project.
3. Select Maven → Update Project.
4. Open LoginTest.java.
5. Right click LoginTest.java.
6. Select Run As → TestNG Test.

---

## Project Structure

LoginAutomationProject
│
├── pom.xml
├── README.md
└── src
    └── test
        └── java
            └── LoginApp
                └── LoginTest.java

---

## Author

Suruthi R