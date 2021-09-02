# Selenium-test-browserfactory
Selenium advanced project using Browser factory

# System Requirements and How to execute
- Install Maven
- Prefer to use Java 11 but tests can run on Java 8 as well.
- Configure testNg.xml
- Use 'mvn clean test' in command line to run the tests.

# Webdriver manager
- Libraries used for WebDriver manager - https://github.com/bonigarcia/webdrivermanager

# Owner 
http://owner.aeonbits.org/docs/usage/

# Junit5
- Sample tests has the examples of JUNIT5 annotations that's gonna be used, preference is to use testNg. 
- To run tests using Junit extend your test class with BaseJunitClass. Parallel testing has not been configured yet.

# TestNg
- To run tests using TestNg, extend your test class with BaseClass.
- TestNg handles the parallel execution threading automatically. Use each thread for different classes rather than
 methods in testNg.xml.
- Do not configure to run tests parallel at method level with current base class setup. Need change to the way driver 
is invoked in base class and probably moving it to each method/test level would solve it.
- Maven command line execution picks the testNg.xml and run the tests. So configure testNg file to your needs.

# How the driver instance has been managed across the test?
Driver instance is fetched from base class and then send across the test via constructor.
Refer to Sample Test and Sample Page to understand the construction.

# NEXT TO BE DONE
3. Use Allure reporting or extent reports or see inbuilt Jenkins reproting options
4. Extend the framework to Grid
5. Usage of docker libraries extension
2. Extend its support to Junit 5 parallel execution if possible