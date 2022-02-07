# **[StuDocu] QA Engineer - Technical Assignment**

---
The written part of the Technical Assignment is available [HERE](https://docs.google.com/document/d/1qqHFKcX_IJblHih9Rg4qQCNVAKdgVXveZ3Ag8quNPgA/edit?usp=sharing).

The coding part is described below.

## Technical Stack

* **Project**: *Maven*
* **Programming Language**: *Java*
* **IDE**: *IntelliJ Community*
* **To specify scenarios adopting BDD approach**: *Cucumber + Gherkin*
* **To run tests and perform Assertions**: *JUnit*

* **Libraries**:
  * *Selenium*
  * *JUnit*
  * *Gherkin*
  * *Cucumber*

---

## Environment Setup

In order to be able to run this project you have to install:

* **JRE**
* **Maven**

---

## Running Tests

After the environment setup described above, run the test scenarios following this procedure:

* **Clone the project**: in the Terminal, run the command ```git clone https://github.com/danieldecasttro/studocu-technical-assignment.git```
* **Run the tests**: in the root folder of the project run the command  ```mvn test -Dtest=CucumberRunner```
* **Verify the test run report**: navigate to the folder ```reports``` and open the file ```test-report.html``` in the browser

---
