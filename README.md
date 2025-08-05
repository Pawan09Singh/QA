✅ Project Title: Selenium-TestNG Automation Framework for Web Application Testing
Project Overview:
Developed a robust and scalable automation testing framework for web applications using Java, Selenium WebDriver, and TestNG, implementing Page Object Model (POM) design to enhance maintainability and reusability of test scripts.

Key Features & Tools Used:
Language: Java

Automation Tools: Selenium WebDriver, TestNG

Design Pattern: Page Object Model (POM)

Reporting: ExtentReports for HTML reports, Log4j for logging, SimpleJavaMail for email reporting

CI/CD Integration: Jenkins – for continuous execution and report sharing

Version Control & Collaboration: Git, GitHub

Other Tools: Jira (bug tracking & project management), TestLink (test case management), Postman (API testing), PuTTY (server access and logs analysis)

Responsibilities & Contributions:
Designed and developed a modular automation framework from scratch using POM, TestNG, and Maven.

Implemented custom BasePage and BaseTest classes to manage browser sessions and abstract WebDriver logic.

Used @FindBy annotations and PageFactory design for element identification and encapsulation.

Built reusable page classes and implemented test classes with validations using TestNG assertions.

Integrated ExtentReports to generate detailed HTML test execution reports.

Configured Log4j to maintain execution logs for easy debugging and traceability.

Enabled email reporting using SimpleJavaMail to auto-send reports post-execution.

Managed test execution through TestNG suites and parallel execution for performance optimization.

Automated test execution in Jenkins CI pipeline, triggering jobs on every code push or scheduled interval.

Logged and tracked bugs via Jira and linked them with test cases in TestLink.

Conducted API validations using Postman and integrated server-level checks via PuTTY.

Collaborated with QA and DevOps teams to ensure smooth test execution and environment stability.

CI/CD Integration (Jenkins):
Set up Jenkins pipelines to trigger automation test runs post every deployment.

Configured Maven commands (mvn clean test) as Jenkins build steps.

Integrated test result publishing via ExtentReports and HTML Publisher plugin.

Sent automated test summary reports to stakeholders via email.

Challenges Faced & Solutions:
Challenge: Managing WebDriver instances in parallel executions.
Solution: Implemented WebDriverContext to manage thread-safe driver instances, ensuring isolated execution.

Challenge: Dynamic element handling and wait issues.
Solution: Used explicit waits and utility methods for reliable element interaction.

✅ Outcome:
Achieved 80% regression test automation coverage.

Reduced manual testing effort by over 60% across releases.

Improved test execution efficiency with parallel test execution and CI integration.

Enabled quicker feedback to developers via automated reporting and notifications.




--ALL files are in the RoyalBrothersTest.zip--


 #to run ->
 mvn exec:java -Dexec.mainClass="com.assignment.App"

 
Pawan Singh 12203926 pawan9621036553@gmail.com
