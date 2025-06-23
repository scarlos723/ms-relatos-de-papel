
@tagbooks
Feature: Gestión de libros

#  @tagunitarycreate
#  Scenario: Crear un nuevo libro
#    Given no existe un libro con título "El Quijote"
#    When creo un libro con título "El Quijote" y autor "Miguel de Cervantes"
#    Then el libro con título "El Quijote" existe y sus datos son correctos
#
#  @tagunitarycreate
#  Scenario: Actualizar un libro
#    Given no existe un libro con título "El Quijote"
#    When creo un libro con título "El Quijote" y autor "Miguel de Cervantes"
#    And actualizo el libro cambiando el autor a "Cervantes"
#    Then el libro con título "El Quijote" tiene autor "Cervantes"
#
#  @tagunitarygetbooks
#  Scenario: Obtener lista de libros
#    Given existen los siguientes libros en el sistema:
#      | id | title                           | author                | category         | isbn            | publicationDate | rating | price  | description                                     | visible |
#      | 1  | El Señor de los Anillos        | J.R.R. Tolkien       | Fantasía        | 978-0618640157  | 1954-07-29     | 5      | 29.99  | Una épica historia de fantasía de J.R.R. Tolkien| true    |
#      | 2  | Cien años de soledad           | Gabriel García Márquez| Realismo mágico | 978-0307474728  | 1967-05-30     | 5      | 24.99  | Obra maestra de Gabriel García Márquez          | false   |
#      | 3  | 1984                           | George Orwell         | Distopía        | 978-0451524935  | 1949-06-08     | 4      | 19.99  | Novela distópica de George Orwell              | true    |
#      | 4  | Don Quijote de la Mancha       | Miguel de Cervantes  | Clásico         | 978-8491050297  | 1605-01-16     | 5      | 34.99  | La obra más importante de la literatura española | false   |
#      | 5  | Harry Potter y la Piedra Filosofal | J.K. Rowling      | Fantasía        | 978-8478884452  | 1997-06-26     | 4      | 22.99  | El primer libro de la saga de J.K. Rowling      | true    |
#    When solicito la lista de todos los libros
#    Then recibo una lista con 5 libros
#    And la lista contiene el libro "El Señor de los Anillos" de "J.R.R. Tolkien"
#    And la lista contiene el libro "Cien años de soledad" de "Gabriel García Márquez"
#    And la lista contiene el libro "1984" de "George Orwell"
#    And la lista contiene el libro "Don Quijote de la Mancha" de "Miguel de Cervantes"
#    And la lista contiene el libro "Harry Potter y la Piedra Filosofal" de "J.K. Rowling"
  
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

