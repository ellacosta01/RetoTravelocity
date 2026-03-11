# Travelocity Hotel Search Automation Framework

Automated test framework built using **Serenity BDD**, **Cucumber**, and the **Screenplay Pattern** to validate the hotel search functionality on **Travelocity**.

This project demonstrates a clean automation architecture with reusable tasks, questions, models, and page objects, following best practices for maintainable UI automation testing.

---

# Overview

This framework automates the process of searching for hotels on the Travelocity website.
It validates different scenarios such as:

* Successful hotel search
* Traveler form validation
* Hotel search form errors
* Verification of hotel location in results

The automation is implemented using the **Screenplay Pattern**, which improves readability, maintainability, and separation of concerns.

---

# Technologies Used

<<<<<<< HEAD
El proyecto sigue la arquitectura **Screenplay**, que separa responsabilidades para mantener el código limpio, reutilizable y fácil de mantener.

## Estructura del Proyecto

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
                └── Hook.java
=======
| Technology         | Purpose                                  |
| ------------------ | ---------------------------------------- |
| Java               | Main programming language                |
| Serenity BDD       | Test reporting and framework integration |
| Cucumber           | BDD test scenarios                       |
| Screenplay Pattern | Test architecture                        |
| Selenium WebDriver | Browser automation                       |
| Gradle             | Dependency management and build tool     |

---

# Project Structure

```
src
 └─ test
    ├─ java
    │  └─ com.travelocity
    │      ├─ models
    │      │     HabitacionesEstadia.java
    │      │     CiudadDeEstadia.java
    │      │
    │      ├─ pageobjects
    │      │     HomeConsultaHotelPageObject.java
    │      │
    │      ├─ questions
    │      │     HayUnError.java
    │      │     LaUbicacionDelHotel.java
    │      │
    │      ├─ runners
    │      │     BuscarHotelRunner.java
    │      │
    │      ├─ stepdefinitions
    │      │     BuscarHotelStepDefinitions.java
    │      │     Hooks.java
    │      │
    │      ├─ tasks
    │      │     SeleccionarDestino.java
    │      │     SeleccionarFecha.java
    │      │     AgregarHabitacionYViajeros.java
    │      │     AjustarHabitacionesYViajeros.java
    │      │
    │      └─ utils
    │            UtilidadesFechas.java
    │
    └─ resources
        └─ features
              BuscarHotel.feature
```
>>>>>>> 705e4df (Add readme y mejora de la estructura)

src
└── test
    └── resources
        └── features
            ├── BuscarHotel.feature
            ├── InicioSesion.feature
            └── Registro.feature
```
---

# Test Architecture

This project follows the **Screenplay Pattern**, which models user interactions as actors performing tasks and asking questions.

### Actor

Represents the user interacting with the application.

### Tasks

Encapsulate user actions such as:

* Selecting destination
* Choosing check-in and check-out dates
* Adding rooms and travelers
* Executing hotel search

### Questions

Used to validate application state such as:

* Presence of error messages
* Verification of hotel location in results

### PageObjects

Contain UI locators used across tasks and questions.

### Models

Represent structured test data used in Cucumber scenarios.

---

# Example Test Flow

A typical automated scenario performs the following steps:

1. User opens the Travelocity website
2. Selects a destination city
3. Chooses check-in and check-out dates
4. Adds travelers and rooms
5. Executes the hotel search
6. Validates the results or error messages

---

# Running the Tests

Clone the repository:

```
git clone https://github.com/ellacosta01/RetoFinal.git
```

Navigate to the project directory:

```
cd RetoFinal
```

Run the tests using Gradle:

```
gradlew clean test
```

After execution, Serenity will automatically generate the test reports.

---

# Serenity Reports

Serenity automatically generates detailed reports that include:

* Test execution results
* Step-by-step screenshots
* Test evidence
* Scenario outcomes

Reports are generated in:

```
target/site/serenity/index.html
```

Open the report in your browser to review test results.

---

# Configuration

The project uses the following configuration file:

```
serenity.properties
```

Example configuration:

```
webdriver.driver=chrome
chrome.switches=--start-maximized,--incognito

serenity.project.name=Travelocity Automation Framework
serenity.take.screenshots=FOR_EACH_ACTION
serenity.report.encoding=UTF-8

serenity.timeout=10000
webdriver.wait.for.timeout=10000
webdriver.timeouts.implicitlywait=10000
```

---

# Example Feature Scenario

<<<<<<< HEAD

Proyecto desarrollado como ejercicio de automatización utilizando Serenity BDD y Screenplay Pattern.
=======
```
Scenario: Search for hotels successfully
  Given that I enter the travelocity portal
  When I enter the basic information to search for a hotel
  And I add rooms and travelers
  And I execute the search
  Then I should see at least one hotel result
```

---

# Key Design Principles

The framework follows these automation principles:

* **Separation of responsibilities**
* **Reusable test components**
* **Readable test scenarios**
* **Maintainable architecture**
* **Clear test reporting**

---

# Future Improvements

Potential enhancements for the framework:

* CI/CD integration
* Parallel test execution
* Cross-browser testing
* API validation for backend services
* Test data externalization

---

# Author

Automation framework created as part of a QA automation practice project.

Author: **Ella Acosta**

---

# License

This project is intended for educational and demonstration purposes.
>>>>>>> 705e4df (Add readme y mejora de la estructura)
