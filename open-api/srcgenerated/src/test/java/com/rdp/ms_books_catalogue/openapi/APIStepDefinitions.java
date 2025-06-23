package com.rdp.ms_books_catalogue.openapi;

import com.rdp.ms_books_catalogue.openapi.invoker.ApiException;
import com.rdp.ms_books_catalogue.openapi.model.Book;
import com.rdp.ms_books_catalogue.openapi.model.BookDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class APIStepDefinitions {
    private BooksControllerApi api = new BooksControllerApi();
    private Book lastBookResponse;
    private ApiException lastException;
    private List<Book> lastBookListResponse;
    @When("hago una petición GET al libro con id {long}")
    public void hago_una_peticion_get_al_libro_con_id(Long id)  {
        try {
            lastBookResponse = api.getBook(id.toString());
        } catch (ApiException e) {
            lastException = e;
        }
    }
    @Then("la respuesta debe ser un libro con el id {long} y el titulo {string}")
    public void la_respuesta_debe_ser_un_libro_con_el_id_y_el_titulo(Long id, String titulo) {
        assertEquals(id, lastBookResponse.getId());
        assertEquals(titulo, lastBookResponse.getTitle());
    }

    @When("hago una petición GET con la query titulo igual a {string}")
    public void hago_una_peticion_get_con_la_query_igual_a( String valor) {
        try {
            lastBookListResponse = api.getBooks(valor, null, null, null, null, null, null, null, null);
        } catch (ApiException e) {
            lastException = e;
        }
        assertNotNull(lastBookListResponse, "La respuesta de la búsqueda es null.");
    }

    @Then("la respuesta debe ser una lista con almenos un libro con el titulo {string}")
    public void la_respuesta_debe_ser_una_lista_con_al_menos_un_libro_con_el_titulo(String titulo) {
        assertNotNull(lastBookListResponse, "No hay respuesta de libros.");
        boolean encontrado = lastBookListResponse.stream().anyMatch(book -> titulo.equals(book.getTitle()));
        assertTrue(encontrado, "No se encontró ningún libro con el título: " + titulo);
    }


    @When("hago una petición POST a con el cuerpo:")
    public void hago_una_peticion_post_a_con_el_cuerpo(DataTable dataTable) throws ApiException {
        try {
            Map<String, String> data = dataTable.asMap(String.class, String.class);
            BookDto bookDto = new BookDto();
            bookDto.setTitle(data.get("title"));
            bookDto.setAuthor(data.get("author"));
            bookDto.setCategory(data.get("category"));
            bookDto.setIsbn(data.get("isbn"));
            bookDto.setPublicationDate(data.get("publicationDate") != null ? LocalDate.parse(data.get("publicationDate")) : null);
            bookDto.setRating(Integer.parseInt(data.get("rating")));
            bookDto.setPrice(new BigDecimal(data.get("price")));
            bookDto.setDescription(data.get("description"));
            bookDto.setVisible(Boolean.parseBoolean(data.get("visible")));
            lastBookResponse = api.createBook(bookDto);
            System.out.println("Respuesta de createBook: " + lastBookResponse);
        } catch (ApiException e) {
            System.err.println("ApiException code: " + e.getCode());
            System.err.println("ApiException response body: " + e.getResponseBody());
            System.err.println("ApiException message: " + e.getMessage());
            lastException = e;
        }
        if (lastException != null) throw lastException;
        assertNotNull(lastBookResponse, "La respuesta del libro es null. Puede que la creación haya fallado.");
    }

    @Then("la respuesta debe contener un id numérico")
    public void la_respuesta_debe_contener_un_id_numerico() {
        assertNotNull(lastBookResponse.getId());
        assertTrue(lastBookResponse.getId() != null || lastBookResponse.getId() != null);
    }

    @Then("la respuesta debe tener el título {string}")
    public void la_respuesta_debe_tener_el_titulo(String titulo) {
        assertEquals(titulo, lastBookResponse.getTitle());
    }

    @Then("la respuesta debe tener el autor {string}")
    public void la_respuesta_debe_tener_el_autor(String autor) {
        assertEquals(autor, lastBookResponse.getAuthor());
    }

    @Then("elimino el libro creado")
    public void elimino_el_libro_creado() throws Exception {
        assertNotNull(lastBookResponse.getId(), "El id del libro creado no puede ser null");
        api.deleteBook(lastBookResponse.getId());
    }


    // Para edición parcial del título
    @When("actualizo parcialmente el libro creado cambiando el título a {string}")
    public void actualizo_parcialmente_el_libro_creado_cambiando_el_titulo_a(String nuevoTitulo) throws Exception {
        assertNotNull(lastBookResponse, "No hay libro creado para actualizar.");
        assertNotNull(lastBookResponse.getId(), "El id del libro creado es null.");

        Map<String, Object> updates = new java.util.HashMap<>();
        updates.put("title", nuevoTitulo);

        try {
            lastBookResponse = api.patchBook(lastBookResponse.getId(), updates);
        } catch (ApiException e) {
            System.err.println("ApiException code: " + e.getCode());
            System.err.println("ApiException response body: " + e.getResponseBody());
            System.err.println("ApiException message: " + e.getMessage());
            throw e;
        }
    }

    // Para edición completa del libro
    @When("actualizo completamente el libro creado con los datos:")
    public void actualizo_completamente_el_libro_creado_con_los_datos(DataTable dataTable) throws Exception {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        BookDto bookDto = new BookDto();
        bookDto.setTitle(data.get("title"));
        bookDto.setAuthor(data.get("author"));
        bookDto.setCategory(data.get("category"));
        bookDto.setIsbn(data.get("isbn"));
        bookDto.setPublicationDate(data.get("publicationDate") != null ? LocalDate.parse(data.get("publicationDate")) : null);
        bookDto.setRating(Integer.parseInt(data.get("rating")));
        bookDto.setPrice(new BigDecimal(data.get("price")));
        bookDto.setDescription(data.get("description"));
        bookDto.setVisible(Boolean.parseBoolean(data.get("visible")));
        lastBookResponse = api.updateBook(lastBookResponse.getId(), bookDto);
    }

    // Validaciones adicionales para los nuevos campos
    @Then("la respuesta debe tener la categoría {string}")
    public void la_respuesta_debe_tener_la_categoria(String categoria) {
        assertEquals(categoria, lastBookResponse.getCategory());
    }

    @Then("la respuesta debe tener el isbn {string}")
    public void la_respuesta_debe_tener_el_isbn(String isbn) {
        assertEquals(isbn, lastBookResponse.getIsbn());
    }

    @Then("la respuesta debe tener la fecha de publicación {string}")
    public void la_respuesta_debe_tener_la_fecha_de_publicacion(String fecha) {
        assertEquals(fecha, lastBookResponse.getPublicationDate().toString());
    }

    @Then("la respuesta debe tener el rating {int}")
    public void la_respuesta_debe_tener_el_rating(int rating) {
        assertEquals(rating, lastBookResponse.getRating());
    }

    @Then("la respuesta debe tener el precio {double}")
    public void la_respuesta_debe_tener_el_precio(double precio) {
        assertEquals(BigDecimal.valueOf(precio), lastBookResponse.getPrice());
    }

    @Then("la respuesta debe tener la descripción {string}")
    public void la_respuesta_debe_tener_la_descripcion(String descripcion) {
        assertEquals(descripcion, lastBookResponse.getDescription());
    }

    @Then("la respuesta debe tener visible {word}")
    public void la_respuesta_debe_tener_visible(String visible) {
        assertEquals(Boolean.parseBoolean(visible), lastBookResponse.getVisible());
    }
}
