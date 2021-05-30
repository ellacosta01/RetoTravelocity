#language: es
Antecedentes:
Característica:Inicio de sesion
Dado que ingreso al portal travelocity.com
  @manual
  @manual-result:passed
  Esquema del escenario: Inicio de sesion exitoso
    Cuando ingreso mis credenciales
      | <correo> | <clave> |
    Y selecciono iniciar sesion
    Entonces deberia ver mi nombre en el banner principal
      | <nombre> |
    Ejemplos:
      | correo                | clave     | nombre |
      | ella0102.ea@gmail.com | Ella_0102 | Ella   |

  @manual
  @manual-result:passed
  Esquema del escenario: Inicio de sesion fallido con correo correcto y clave incorrecta
    Cuando ingreso mis credenciales
      | <correo> | <clave> |
    Y selecciono iniciar sesion
    Entonces deberia ver un mensaje de error asociado a la clave incorrecta
      | <mensaje> |
    Ejemplos:
      | correo                | clave     | mensaje                                                                |
      | ella0102.ea@gmail.com | ClaveMala | You may have entered an unknown email address or an incorrect password |

  @manual
  @manual-result:passed
  Esquema del escenario: Inicio de sesion fallido con correo incorrecto y clave correcta
    Cuando ingreso mis credenciales
      | <correo> | <clave> |
    Y selecciono iniciar sesion
    Entonces deberia ver un mensaje de error asociado al correo incorrecto
      | <mensaje> |
    Ejemplos:
      | correo               | clave     | mensaje                                                                |
      | correomalo@gmail.com | Ella_0102 | You may have entered an unknown email address or an incorrect password |

  @manual
  @manual-result:passed
  Esquema del escenario: Inicio de sesion fallido con correo incorrecto y clave incorrecta
    Cuando ingreso mis credenciales
      | <correo> | <clave> |
    Y selecciono iniciar sesion
    Entonces deberia ver un mensaje de error asociado al correo incorrecto y clave incorrecta
      | <mensaje> |
    Ejemplos:
      | correo               | clave     | mensaje                                                                |
      | correomalo@gmail.com | ClaveMala | You may have entered an unknown email address or an incorrect password |
  @manual
  @manual-result:passed
  Esquema del escenario: Inicio de sesion fallido con correo correcto y clave vacia
    Cuando ingreso mis credenciales
      | <correo> | <clave> |
    Y selecciono iniciar sesion
    Entonces deberia ver un mensaje de error asociado a la clave vacia
      | <mensaje> |
    Ejemplos:
      | correo                | clave | mensaje                     |
      | ella0102.ea@gmail.com |       | Please enter your password. |

  @manual
  @manual-result:passed
  Esquema del escenario: Inicio de sesion fallido con correo vacio y clave correcta
    Cuando ingreso mis credenciales
      | <correo> | <clave> |
    Y selecciono iniciar sesion
    Entonces deberia ver un mensaje de error asociado al correo vacio
      | <mensaje> |
    Ejemplos:
      | correo | clave     | mensaje                          |
      |        | Ella_0102 | Please enter your email address. |
  @manual
  @manual-result:passed
  Esquema del escenario: Inicio de sesion fallido con correo vacio y clave vacia
    Cuando ingreso mis credenciales
      | <correo> | <clave> |
    Y selecciono iniciar sesion
    Entonces deberia ver un mensaje de error sobre la clave vacia
      | <mensajeClave> |
    Entonces deberia ver un mensaje de error sobre al correo vacio
      | <MensajeCorreo> |
    Ejemplos:
      | correo | clave | mensajeClave                | MensajeCorreo                    |
      |        |       | Please enter your password. | Please enter your email address. |




