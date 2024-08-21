# PANGO_DEP_TST

Full automation tests for PANGO

### Test framework setup

* This project uses TestNG and Selenide for UI web application
  test automation.

### Integration Tests

* Tests are in ge.gl.pango.ui directory
* UITest class runs 2 tests : openRegisterPageTest,registerAndLoginTest and validates results.
  Each test uses predefined webdriver and using step operations navigates, sets data, executes and validates.

### End-to-End Tests

* Tests are in ge.gl.pango.e2e directory
* E2ETest class runs 3 tests : createUserTest, updateUserTest, getUserTest and validates results.
  Each test uses predefined step operations which execute requests to the api of https://reqres.in/api and validates
  data;

### Database Connection

* Tests are in ge.gl.pango.db directory
* In order to run this project independently I had to include H2 in-memory database.
* DBTest class runs 3 tests : addUserDBTest, updateDBTest, deleteUserDBTest with validations provided in each;
* Had to implement DataFromSQL class to initialize user table. Also add, update and delete user records and cleanup user table after all operations done.

# Execution

### With maven installed
* Run mvn test

### With intellij
* Run testng.xml file directly