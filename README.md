
# Travelocity Web Automation Framework

Automated testing framework for validating **hotel search functionality on Travelocity** using **Serenity BDD**, **Cucumber**, and the **Screenplay Pattern**.

This project demonstrates a maintainable automation architecture with reusable components such as tasks, questions, models, and page objects.

---

# Overview

The framework automates the hotel search workflow on Travelocity and validates both successful and error scenarios.

Main validations include:

* Successful hotel search
* Validation of traveler form errors
* Validation of search form errors
* Verification that hotel results match the selected destination

The automation follows the **Screenplay Pattern**, which improves readability, reuse, and maintainability of automated tests.

---

# Technologies Used

| Technology         | Purpose                            |
| ------------------ | ---------------------------------- |
| Java               | Programming language               |
| Serenity BDD       | Automation framework and reporting |
| Cucumber           | BDD test scenarios                 |
| Selenium WebDriver | Browser automation                 |
| Screenplay Pattern | Test architecture                  |
| Gradle             | Dependency management and build    |

---

## Project Structure

```text
src
 ├── main
 │   └── java
 │       └── com.travelocity
 │           ├── models
 │           │   ├── CiudadDeEstadia.java
 │           │   └── HabitacionesEstadia.java
 │           │
 │           ├── pageobjects
 │           │   └── HomeConsultaHotelPageObject.java
 │           │
 │           ├── questions
 │           │   ├── HayUnError.java
 │           │   └── LaUbicacionDelHotel.java
 │           │
 │           ├── tasks
 │           │   ├── SeleccionarDestino.java
 │           │   ├── SeleccionarFecha.java
 │           │   ├── AgregarHabitacionYViajeros.java
 │           │   └── AjustarHabitacionesYViajeros.java
 │           │
 │           └── utils
 │               └── UtilidadesFechas.java
 │
 └── test
     └── java
         └── com.travelocity
             ├── runners
             │   └── BuscarHotelRunner.java
             │
             └── stepdefinitions
                 ├── BuscarHotelStepDefinitions.java
                 └── Hooks.java

src/test/resources
 └── features
     ├── BuscarHotel.feature
     ├── InicioSesion.feature
     └── Registro.feature
```
---

# Test Architecture

This project implements the **Screenplay Pattern**.

### Actor

Represents the user interacting with the application.

### Tasks

Encapsulate business actions performed by the actor, such as:

* Selecting destination
* Choosing check-in and check-out dates
* Adding travelers and rooms
* Executing hotel search

### Questions

Used to verify the state of the application.

Examples include:

* Checking if an error message appears
* Validating hotel location in results

### Page Objects

Contain the UI locators used across tasks and questions.

### Models

Represent structured data used in Cucumber scenarios.

---

# Example Test Flow

A typical automated scenario performs the following steps:

1. Open Travelocity website
2. Select destination
3. Choose check-in and check-out dates
4. Add rooms and travelers
5. Execute the search
6. Validate results or error messages

---

# Running the Tests

Clone the repository:

```
git clone https://github.com/ellacosta01/travelocity-web-automation.git
```

Navigate to the project folder:

```
cd travelocity-web-automation
```

Run the tests using Gradle:

```
gradlew clean test
```

---

# Serenity Reports

Serenity automatically generates detailed HTML reports including:

* Execution results
* Step-by-step screenshots
* Scenario outcomes
* Test evidence

Reports are generated at:

```
target/site/serenity/index.html
```

Open this file in your browser after executing the tests.

---

# Configuration

The project configuration is defined in:

```
serenity.properties
```

Example configuration:

```
webdriver.driver=chrome
chrome.switches=--start-maximized,--incognito

serenity.project.name=Travelocity Automation Framework
serenity.take.screenshots=FOR_EACH_ACTION

serenity.timeout=10000
webdriver.wait.for.timeout=10000
webdriver.timeouts.implicitlywait=10000
```

---

# Example Feature Scenario

```
Scenario: Search hotel successfully
  Given que ingreso al portal travelocity.com
  When ingreso los datos basicos para buscar un hotel
  And ingreso las habitaciones que necesito y viajeros que van conmigo
  And ejecuto la busqueda
  Then deberia ver al menos un hotel de resultado
```

---

# Key Design Principles

This framework follows these automation principles:

* Clean architecture
* Reusable test components
* Readable test scenarios
* Separation of responsibilities
* Maintainable test automation code

---

# Future Improvements

Possible enhancements for this project:

* CI/CD integration
* Parallel test execution
* Cross-browser testing
* API validation
* External test data management

---

# Author

Automation framework created as part of QA automation practice.

Author: **Ella Acosta**

---

# License

This repository is intended for educational and demonstration purposes.




