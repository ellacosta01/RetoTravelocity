# Reto Travelocity - Automatización de Búsqueda de Hoteles

Proyecto de automatización de pruebas para el portal **Travelocity**, desarrollado utilizando **Serenity BDD**, **Screenplay Pattern**, **Cucumber** y **Gradle**.

El objetivo del proyecto es validar funcionalidades relacionadas con la **búsqueda de hoteles**, manejo de **habitaciones y viajeros**, así como la **validación de mensajes de error en formularios**.

---

# Tecnologías utilizadas

- Java
- Serenity BDD
- Cucumber
- Screenplay Pattern
- Gradle
- Selenium WebDriver

---

# Estructura del Proyecto

El proyecto sigue la arquitectura **Screenplay**, que separa responsabilidades para mantener el código limpio, reutilizable y fácil de mantener.
src
├── main
│ └── java
│ └── com.travelocity
│ ├── models
│ │ ├── CiudadDeEstadia.java
│ │ └── HabitacionesEstadia.java
│ │
│ ├── pageobjects
│ │ └── HomeConsultaHotelPageObject.java
│ │
│ ├── questions
│ │ ├── HayUnError.java
│ │ └── LaUbicacionDelHotel.java
│ │
│ ├── tasks
│ │ ├── SeleccionarDestino.java
│ │ ├── SeleccionarFecha.java
│ │ ├── AgregarHabitacionYViajeros.java
│ │ └── AjustarHabitacionesYViajeros.java
│ │
│ └── utils
│ └── UtilidadesFechas.java
│
└── test
└── java
└── com.travelocity
├── runners
│ └── BuscarHotelRunner.java
│
└── stepdefinitions
├── BuscarHotelStepDefinitions.java
└── Hook.java

resources
└── features
├── BuscarHotel.feature
├── InicioSesion.feature
└── Registro.feature


---

# Descripción de cada módulo

## models
Contiene las clases que representan los **datos utilizados en los escenarios de prueba**.

- **CiudadDeEstadia**
  Representa la información necesaria para realizar la búsqueda de un hotel:
  - destino
  - fecha de check-in
  - fecha de check-out

- **HabitacionesEstadia**
  Representa la configuración de habitaciones y viajeros:
  - número de habitación
  - adultos
  - jóvenes

Estas clases permiten que Cucumber convierta las tablas de los escenarios en objetos Java.

---

## pageobjects

Contiene los **locators de los elementos del sitio web** utilizando `Target` de Serenity.

Clase principal:

**HomeConsultaHotelPageObject**

Define todos los elementos interactuables del portal de búsqueda de hoteles:

- campo destino
- calendario de fechas
- selección de viajeros
- botones de agregar habitaciones
- botones de búsqueda
- mensajes de error

Esto permite centralizar los locators y facilitar su mantenimiento.

---

## tasks

Las **Tasks** representan las acciones que un usuario realiza en el sistema.

Principales tareas implementadas:

**SeleccionarDestino**

Permite ingresar un destino en el buscador de hoteles.

**SeleccionarFecha**

Permite seleccionar fechas de check-in y check-out dentro del calendario.

**AgregarHabitacionYViajeros**

Agrega habitaciones y configura el número de viajeros por habitación.

**AjustarHabitacionesYViajeros**

Modifica la configuración de habitaciones y viajeros si ya existe una configuración previa.

Estas tareas implementan el patrón Screenplay utilizando:

---

## questions

Las **Questions** permiten validar resultados dentro de la interfaz.

**HayUnError**

Valida si existen mensajes de error en los formularios.

**LaUbicacionDelHotel**

Verifica si dentro de los resultados aparece al menos un hotel ubicado en el destino buscado.

---

## utils

Contiene utilidades auxiliares utilizadas por las tareas.

**UtilidadesFechas**

Método que valida si el mes y año esperado están visibles en el calendario antes de seleccionar el día.

---

## stepdefinitions

Implementa la conexión entre **Cucumber y Screenplay**.

**BuscarHotelStepDefinitions**

Contiene la implementación de los pasos definidos en los escenarios:

- ingreso de destino
- selección de fechas
- configuración de viajeros
- ejecución de búsqueda
- validación de resultados

---

## runners

Clase encargada de ejecutar los escenarios de prueba.

**BuscarHotelRunner**

Define:

- ubicación de los archivos feature
- ubicación de los step definitions
- integración con Serenity BDD

---

## features

Contiene los **escenarios escritos en Gherkin**.

Principales funcionalidades cubiertas:

### BuscarHotel.feature

Valida escenarios como:

- búsqueda básica de hoteles
- búsqueda con fechas
- validación de mensajes de error
- configuración de habitaciones y viajeros

### InicioSesion.feature

Define escenarios de inicio de sesión:

- login exitoso
- login fallido
- validación de mensajes de error

Actualmente estos escenarios están marcados como **manuales**.

### Registro.feature

Define escenarios de registro de usuario:

- registro exitoso
- correo existente
- claves no coincidentes
- datos obligatorios vacíos

También definidos como **pruebas manuales**.

---

# Ejecución del proyecto

El proyecto utiliza **Gradle** como sistema de construcción.

Para ejecutar las pruebas:
./gradlew test

Después de ejecutar las pruebas, Serenity genera un reporte en:
target/site/serenity/index.html

---

# Notas importantes

Este proyecto fue desarrollado con versiones anteriores de Serenity y Gradle.

Si se clona el repositorio, es recomendable validar:

- versión de Java
- versión de Gradle
- compatibilidad de dependencias
- posibles cambios en el DOM del portal Travelocity

La lógica de automatización y la arquitectura del proyecto se mantienen, pero pueden requerirse ajustes de entorno para su correcta ejecución.

---

# Autor

Proyecto desarrollado como ejercicio de automatización utilizando Serenity BDD y Screenplay Pattern.