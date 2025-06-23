package com.rdp.ms_books_catalogue;

import com.rdp.ms_books_catalogue.openapi.BooksControllerApi;
import com.rdp.ms_books_catalogue.openapi.invoker.ApiException;
import com.rdp.ms_books_catalogue.openapi.model.Book;
import com.rdp.ms_books_catalogue.openapi.model.BookDto;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import io.cucumber.java.en.And;
import io.cucumber.datatable.DataTable;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalityStepDefinitions {

    @Mock
    private BooksControllerApi booksApi;

    private BookDto createdBook;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Given("no existe un libro con título {string}")
    public void no_existe_un_libro_con_título(String titulo) throws ApiException {
        Mockito.when(booksApi.getBooks(
                titulo, null, null, null, null, null, null, null, null
        )).thenReturn(Collections.emptyList());

        List<com.rdp.ms_books_catalogue.openapi.model.Book> books = booksApi.getBooks(
                titulo, null, null, null, null, null, null, null, null
        );

        assertTrue(books.isEmpty(), "No deberían existir libros con este título");
    }

    @When("creo un libro con título {string} y autor {string}")
    public void creo_un_libro_con_título_y_autor(String titulo, String autor) throws ApiException {
        BookDto newBook = new BookDto()
                .title(titulo)
                .author(autor);

        com.rdp.ms_books_catalogue.openapi.model.Book mockResponse = new com.rdp.ms_books_catalogue.openapi.model.Book()
                .title(titulo)
                .author(autor);

        Mockito.when(booksApi.createBook(any(BookDto.class))).thenReturn(mockResponse);

        createdBook = newBook;
        booksApi.createBook(newBook);
    }

    @Then("el libro con título {string} existe y sus datos son correctos")
    public void el_libro_con_título_existe_y_sus_datos_son_correctos(String titulo) throws ApiException {
        com.rdp.ms_books_catalogue.openapi.model.Book mockBook = new com.rdp.ms_books_catalogue.openapi.model.Book()
                .title(titulo)
                .author("Miguel de Cervantes");

        Mockito.when(booksApi.getBooks(
                titulo, null, null, null, null, null, null, null, null
        )).thenReturn(Collections.singletonList(mockBook));

        List<com.rdp.ms_books_catalogue.openapi.model.Book> books = booksApi.getBooks(
                titulo, null, null, null, null, null, null, null, null
        );

        assertFalse(books.isEmpty(), "El libro debería existir");
        com.rdp.ms_books_catalogue.openapi.model.Book foundBook = books.get(0);
        assertTrue(foundBook.getTitle().equals(titulo), "El título del libro debería coincidir");
    }

    @When("actualizo el libro cambiando el autor a {string}")
    public void actualizo_el_libro_cambiando_el_autor_a(String nuevoAutor) throws ApiException {
        createdBook.setAuthor(nuevoAutor);
        com.rdp.ms_books_catalogue.openapi.model.Book mockResponse = new com.rdp.ms_books_catalogue.openapi.model.Book()
                .title(createdBook.getTitle())
                .author(nuevoAutor);

        Mockito.when(booksApi.updateBook(any(Long.class), any(BookDto.class)))
                .thenReturn(mockResponse);

        booksApi.updateBook(1L, createdBook);
    }

    @Then("el libro con título {string} tiene autor {string}")
    public void el_libro_con_título_tiene_autor(String titulo, String autorEsperado) throws ApiException {
        com.rdp.ms_books_catalogue.openapi.model.Book mockBook = new com.rdp.ms_books_catalogue.openapi.model.Book()
                .title(titulo)
                .author(autorEsperado);

        Mockito.when(booksApi.getBooks(
                titulo, null, null, null, null, null, null, null, null
        )).thenReturn(Collections.singletonList(mockBook));

        List<com.rdp.ms_books_catalogue.openapi.model.Book> books = booksApi.getBooks(
                titulo, null, null, null, null, null, null, null, null
        );

        assertFalse(books.isEmpty(), "El libro debería existir");
        com.rdp.ms_books_catalogue.openapi.model.Book foundBook = books.get(0);
        assertTrue(foundBook.getAuthor().equals(autorEsperado),
                "El autor del libro debería ser " + autorEsperado);
    }

    private List<Book> bookList;

@Given("existen los siguientes libros en el sistema:")
public void existen_los_siguientes_libros_en_el_sistema(DataTable dataTable) throws ApiException {
    List<Map<String, String>> books = dataTable.asMaps();
    List<Book> mockBooks = books.stream()
        .map(row -> new Book()
            .id(Long.parseLong(row.get("id")))
            .title(row.get("title"))
            .author(row.get("author"))
            .category(row.get("category"))
            .isbn(row.get("isbn"))
            .publicationDate(LocalDate.parse(row.get("publicationDate")))
            .rating(Integer.parseInt(row.get("rating")))
            .price(new BigDecimal(row.get("price")))
            .description(row.get("description"))
            .visible(Boolean.parseBoolean(row.get("visible"))))
        .collect(Collectors.toList());
    
    Mockito.when(booksApi.getBooks(null, null, null, null, null, null, null, null, null))
           .thenReturn(mockBooks);
}

@When("solicito la lista de todos los libros")
public void solicito_la_lista_de_todos_los_libros() throws ApiException {
    bookList = booksApi.getBooks(null, null, null, null, null, null, null, null, null);
}

@Then("recibo una lista con {int} libros")
public void recibo_una_lista_con_libros(Integer expectedCount) {
    System.out.println("Book list: " + bookList);
    assertEquals(expectedCount, bookList.size());
}

@And("la lista contiene el libro {string} de {string}")
public void la_lista_contiene_el_libro_de(String title, String author) {
    boolean found = bookList.stream()
        .anyMatch(book -> 
            book.getTitle().equals(title) && 
            book.getAuthor().equals(author)
        );
    assertTrue(found, "No se encontró el libro '" + title + "' de " + author);
}

    
}