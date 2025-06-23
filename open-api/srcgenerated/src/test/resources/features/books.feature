@tagapigetbook
  Scenario: Consultar un libro existente por id
    When hago una petición GET al libro con id 1
    Then la respuesta debe ser un libro con el id 1 y el titulo "El Señor de los Anillos"

  @tagapigetbookbytitle
  Scenario: Buscar un libro por titulo
    When hago una petición GET con la query titulo igual a "El Señor de los Anillos"
    Then la respuesta debe ser una lista con almenos un libro con el titulo "El Señor de los Anillos"

  @tagapicreatebook
  Scenario: Crear un libro
    When hago una petición POST a con el cuerpo:
      | campo           | valor                                         |
      | title           | Testing Modern Java                           |
      | author          | Nicolai Parlog                                |
      | category        | Tecnología                                    |
      | isbn            | 978-0134685991                                |
      | publicationDate | 2018-03-01                                    |
      | rating          | 4                                             |
      | price           | 34.99                                         |
      | description     | Un libro sobre pruebas modernas en Java.      |
      | visible         | true                                          |
    Then la respuesta debe contener un id numérico
    And la respuesta debe tener el título "Testing Modern Java"
    And la respuesta debe tener el autor "Nicolai Parlog"

    When actualizo parcialmente el libro creado cambiando el título a "Clean Code (2ª Edición)"
    Then la respuesta debe tener el título "Clean Code (2ª Edición)"

    When actualizo completamente el libro creado con los datos:
      | campo           | valor                                         |
      | title           | Clean Architecture                            |
      | author          | Robert C. Martin                              |
      | category        | Arquitectura                                  |
      | isbn            | 978-0134494166                                |
      | publicationDate | 2017-09-20                                    |
      | rating          | 5                                             |
      | price           | 44.99                                         |
      | description     | Principios y patrones para software limpio.   |
      | visible         | false                                         |
    Then la respuesta debe tener el título "Clean Architecture"
    And la respuesta debe tener el autor "Robert C. Martin"
    And la respuesta debe tener la categoría "Arquitectura"
    And la respuesta debe tener el isbn "978-0134494166"
    And la respuesta debe tener la fecha de publicación "2017-09-20"
    And la respuesta debe tener el rating 5
    And la respuesta debe tener el precio 44.99
    And la respuesta debe tener la descripción "Principios y patrones para software limpio."
    And la respuesta debe tener visible false
    And elimino el libro creado
