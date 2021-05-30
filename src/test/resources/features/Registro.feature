#language: es
Característica:Registro

  Antecedentes:
    Dado que ingreso al portal travelocity.com
    Cuando deseo registrarme como un usuario nuevo

  @manual
  @manual-result:passed
  Esquema del escenario: Registro exitoso
    Cuando diligencio el formulario de registro con todos los datos correctamente
      | <nombre> | <apellido> | <email> | <clave> | <confirmar clave> |
    Entonces deberia ver mi nombre en el banner principal
      | <nombreUsuario> |

    Ejemplos:
      | nombre | apellido | email                 | clave     | confirmar clave | nombreUsuario |
      | Ella   | Acosta   | ella0102.ea@gmail.com | Ella_0102 | Ella_0102       | Ella          |

  @manual
  @manual-result:passed
  Esquema del escenario: Registro con clave comun
    Cuando diligencio el formulario de registro con todos los datos correctamente y una clave comun
      | <nombre> | <apellido> | <email> | <clave> | <confirmar clave> |
    Entonces deberia ver un mensaje de error asociado a la clave comun
      | <errorClaveComun> |

    Ejemplos:
      | nombre | apellido | email                 | clave  | confirmar clave | errorClaveComun                                                           |
      | Ella   | Acosta   | ella0102.ea@gmail.com | 123456 | 123456          | Password is a commonly used password. Please choose a different password. |

  @manual
  @manual-result:passed
  Esquema del escenario: Usuario existente
    Cuando diligencio el formulario  de registro de cuenta con un correo registrado previamente
      | <nombre> | <apellido> | <email> | <clave> | <confirmar clave> |
    Entonces deberia ver un mensaje de error asociado a un registro previo
      | <errorCorreRegistrado> |

    Ejemplos:
      | nombre | apellido | email                 | clave      | confirmar clave | errorCorreRegistrado    |
      | Ella   | Acosta   | ella0102.ea@gmail.com | Ella_0102* | Ella_0102*      | Account already exists. |

  @manual
  @manual-result:passed
  Esquema del escenario: Claves sin coincidencia
    Cuando diligencio el formulario  de registro de cuenta con dos claves diferentes
      | <nombre> | <apellido> | <email> | <clave> | <confirmar clave> |
    Entonces deberia ver un mensaje de error asociado a claves diferentes
      | <errorClavesDiferentes> |

    Ejemplos:
      | nombre | apellido | email                 | clave     | confirmar clave | errorClavesDiferentes   |
      | Ella   | Acosta   | ella0102.ea@gmail.com | ClaveMala | ClaveBuena      | Passwords do not match. |

  @manual
  @manual-result:passed
  Esquema del escenario: Sin nombre de usuario
    Cuando diligencio el formulario  de registro sin nombre de usuario
      | <nombre> | <apellido> | <email> | <clave> | <confirmar clave> |
    Entonces deberia ver un mensaje de error asociado al nombre
      | <errorNombre> |

    Ejemplos:
      | nombre | apellido | email                 | clave      | confirmar clave | errorNombre                                 |
      |        | Acosta   | ella0102.ea@gmail.com | Ella_0102* | Ella_0102*      | Please enter first name using letters only. |

  @manual
  @manual-result:passed
  Esquema del escenario: Correo Inexistente
    Cuando diligencio el formulario  de registro con un correo falso
      | <nombre> | <apellido> | <email> | <clave> | <confirmar clave> |
    Entonces deberia ver un mensaje de error asociado al correo inexistente
      | <errorCorreo> |

    Ejemplos:
      | nombre | apellido | email                        | clave      | confirmar clave | errorCorreo                  |
      | Ella   | Acosta   | CorreoFalsoXXX1213@gmail.com | Ella_0102* | Ella_0102*      | Enter a valid email address. |

  @manual
  @manual-result:passed
  Esquema del escenario: Todos los datos vacios del formulario
    Cuando diligencio el formulario  de registro sin informacion
      | <nombre> | <apellido> | <email> | <clave> | <confirmar clave> |
    Entonces deberia ver un mensaje de error asociado a los datos vacios
      | <errorDatos> |

    Ejemplos:
      | nombre | apellido | email | clave | confirmar clave | errorDatos                 |
      |        |          |       |       |                 | Please complete all fields |

  @manual
  @manual-result:passed
  Esquema del escenario: No aceptar los terminos de uso y politica de privacidad
    Cuando diligencio el formulario  de registro sin aceptar los terminos de uso
      | <nombre> | <apellido> | <email> | <clave> | <confirmar clave> |
    Entonces deberia ver un mensaje de error asociado a los datos vacios
      | <errorCheck> |

    Ejemplos:
      | nombre | apellido | email                 | clave     | confirmar clave | errorCheck                                                         |
      | Ella   | Acosta   | ella0102.ea@gmail.com | Ella_0102 | Ella_0102       | Please check that you agree to the Terms of Use and Privacy Policy |

