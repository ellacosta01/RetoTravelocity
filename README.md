# Reto Travelocity

## Descripción

En este proyecto se desarrolló la automatización de la funcionalidad de búsqueda de hotel. Se buscó parametrizar la mayor cantidad de funciones y localizadores posibles para poder expandir la automatización a diferentes funcionalidades. Con los avances realizados para automatizar la funcionalida de Consultar Hotel, se impacta positivamente en la búsqueda de Vuelos, Carros, Paquetes, Cosas por hacer y Cruceros.

## Ejecución

Para ejecutar este proyecto, se recomienda reemplazar el chromedriver.exe por uno compatible con la versión de su navegador Chrome. Configure el archivo serenity.properties como considere necesario en caso de querer usar otro navegador, ubicación de driver, etc. Los comandos usados para generar el reporte fueron:

`gradle clean test aggregate`

Recuerde que el comando clean limpia el reporte ya presente en el proyecto. Tenga esto presente antes de ejecutar.