#language: es

Característica: Buscar hotel
  Como usuario dentro del portal travelocity,
  quiero poder buscar hoteles,
  para recibir sugerencias de donde quedarme

  Antecedentes:
    Dado que ingreso al portal travelocity.com

    # Se valida a traves de la busqueda que el error fue retirado exitosamente
  Escenario: Validacion de borrado de mensaje de error en formulario de viajeros al retirar un joven viajero
    Cuando ingreso las habitaciones que necesito y viajeros que van conmigo
      | Habitacion | Adultos | Jovenes |
      | 1          | 3       | 1       |
    Entonces deberia ver un mensaje de error en el formulario de viajeros
    Y el mensaje de error deberia tener el siguiente texto:
      | Please provide the ages of children. |
    Cuando ajusto el formulario de viajeros
      | Habitacion | Adultos | Jovenes |
      | 1          | 3       | 0       |
    E ingreso el destino "Bogotá"
    Y ejecuto la busqueda
    Entonces deberia ver al menos un hotel de resultado en "Bogotá"

  Escenario: Busqueda de hotel sin destino
    Cuando ingreso el destino ""
    Y ejecuto la busqueda
    Entonces deberia ver un mensaje de error en el formulario de busqueda de Hotel
    Y el mensaje de error deberia tener el siguiente texto:
      | To continue, please correct the error below. |

  # Este escenario valida que al presionar el Boton Done no se cierre el formulario
  # Adicionalmente, tambien valida la presencia del mensaje de error y su contenido
  Escenario: Validacion de mensaje de error cuando hay jovenes viajeros
    Cuando ingreso las habitaciones que necesito y viajeros que van conmigo
      | Habitacion | Adultos | Jovenes |
      | 1          | 3       | 1       |
    Entonces deberia ver un mensaje de error en el formulario de viajeros
    Y el mensaje de error deberia tener el siguiente texto:
      | Please provide the ages of children. |

  Esquema del escenario: Busqueda de hotel con check-in, check-out y viajeros
    Cuando ingreso los datos basicos para buscar un hotel
      | Destino   | CheckInDia   | CheckInMes   | CheckInYear   | CheckOutDia   | CheckOutMes   | CheckOutYear   |
      | <Destino> | <CheckInDia> | <CheckInMes> | <CheckInYear> | <CheckOutDia> | <CheckOutMes> | <CheckOutYear> |
    E ingreso las habitaciones que necesito y viajeros que van conmigo
      | Habitacion | Adultos | Jovenes |
      | 1          | 3       | 0       |
      | 2          | 1       | 0       |
      | 3          | 2       | 0       |
    Y ejecuto la busqueda
    Entonces deberia ver al menos un hotel de resultado en "<Destino>"

    Ejemplos:
      | Destino | CheckInDia | CheckInMes | CheckInYear | CheckOutDia | CheckOutMes | CheckOutYear |
      | Bogotá  | 22         | August     | 2021        | 25          | August      | 2021         |

  Esquema del escenario: Busqueda de hotel basica
    Cuando ingreso el destino "<Destino>"
    Y ejecuto la busqueda
    Entonces deberia ver al menos un hotel de resultado en "<Destino>"

    Ejemplos:
      | Destino |
      | Bogotá  |



