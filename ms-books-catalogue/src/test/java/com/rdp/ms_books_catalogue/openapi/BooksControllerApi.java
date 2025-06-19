package com.rdp.ms_books_catalogue.openapi;

import com.rdp.ms_books_catalogue.openapi.invoker.ApiException;
import com.rdp.ms_books_catalogue.openapi.invoker.ApiClient;
import com.rdp.ms_books_catalogue.openapi.invoker.Configuration;
import com.rdp.ms_books_catalogue.openapi.invoker.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import com.rdp.ms_books_catalogue.openapi.model.Book;
import com.rdp.ms_books_catalogue.openapi.model.BookDto;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-18T00:37:42.844715-05:00[America/Bogota]", comments = "Generator version: 7.13.0")
public class BooksControllerApi {
  private ApiClient apiClient;

  public BooksControllerApi() {
    this(Configuration.getDefaultApiClient());
  }

  public BooksControllerApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * 
   * 
   * @param bookDto  (required)
   * @return a {@code Book}
   * @throws ApiException if fails to make API call
   */
  public Book createBook(@javax.annotation.Nonnull BookDto bookDto) throws ApiException {
    Object localVarPostBody = bookDto;
    
    // verify the required parameter 'bookDto' is set
    if (bookDto == null) {
      throw new ApiException(400, "Missing the required parameter 'bookDto' when calling createBook");
    }
    
    // create path and map variables
    String localVarPath = "/books".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Book> localVarReturnType = new GenericType<Book>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @param id  (required)
   * @return a {@code String}
   * @throws ApiException if fails to make API call
   */
  public String deleteBook(@javax.annotation.Nonnull Long id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteBook");
    }
    
    // create path and map variables
    String localVarPath = "/books/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @param id  (required)
   * @return a {@code Book}
   * @throws ApiException if fails to make API call
   */
  public Book getBook(@javax.annotation.Nonnull String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getBook");
    }
    
    // create path and map variables
    String localVarPath = "/books/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Book> localVarReturnType = new GenericType<Book>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @param title  (optional)
   * @param author  (optional)
   * @param category  (optional)
   * @param isbn  (optional)
   * @param publicationDate  (optional)
   * @param rating  (optional)
   * @param price  (optional)
   * @param description  (optional)
   * @param visible  (optional)
   * @return a {@code List<Book>}
   * @throws ApiException if fails to make API call
   */
  public List<Book> getBooks(@javax.annotation.Nullable String title, @javax.annotation.Nullable String author, @javax.annotation.Nullable String category, @javax.annotation.Nullable String isbn, @javax.annotation.Nullable LocalDate publicationDate, @javax.annotation.Nullable Integer rating, @javax.annotation.Nullable BigDecimal price, @javax.annotation.Nullable String description, @javax.annotation.Nullable Boolean visible) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/books".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "title", title));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "author", author));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "category", category));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "isbn", isbn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "publicationDate", publicationDate));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rating", rating));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "price", price));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "description", description));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "visible", visible));

    
    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<Book>> localVarReturnType = new GenericType<List<Book>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @param id  (required)
   * @param requestBody  (required)
   * @return a {@code Book}
   * @throws ApiException if fails to make API call
   */
  public Book patchBook(@javax.annotation.Nonnull Long id, @javax.annotation.Nonnull Map<String, Object> requestBody) throws ApiException {
    Object localVarPostBody = requestBody;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling patchBook");
    }
    
    // verify the required parameter 'requestBody' is set
    if (requestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'requestBody' when calling patchBook");
    }
    
    // create path and map variables
    String localVarPath = "/books/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Book> localVarReturnType = new GenericType<Book>() {};
    return apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @param id  (required)
   * @param bookDto  (required)
   * @return a {@code Book}
   * @throws ApiException if fails to make API call
   */
  public Book updateBook(@javax.annotation.Nonnull Long id, @javax.annotation.Nonnull BookDto bookDto) throws ApiException {
    Object localVarPostBody = bookDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateBook");
    }
    
    // verify the required parameter 'bookDto' is set
    if (bookDto == null) {
      throw new ApiException(400, "Missing the required parameter 'bookDto' when calling updateBook");
    }
    
    // create path and map variables
    String localVarPath = "/books/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Book> localVarReturnType = new GenericType<Book>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
