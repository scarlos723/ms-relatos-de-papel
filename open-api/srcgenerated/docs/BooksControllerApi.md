# BooksControllerApi

All URIs are relative to *http://localhost:8081*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createBook**](BooksControllerApi.md#createBook) | **POST** /books |  |
| [**deleteBook**](BooksControllerApi.md#deleteBook) | **DELETE** /books/{id} |  |
| [**getBook**](BooksControllerApi.md#getBook) | **GET** /books/{id} |  |
| [**getBooks**](BooksControllerApi.md#getBooks) | **GET** /books |  |
| [**patchBook**](BooksControllerApi.md#patchBook) | **PATCH** /books/{id} |  |
| [**updateBook**](BooksControllerApi.md#updateBook) | **PUT** /books/{id} |  |



## createBook

> Book createBook(bookDto)



### Example

```java
// Import classes:
import com.rdp.ms_books_catalogue.openapi.invoker.ApiClient;
import com.rdp.ms_books_catalogue.openapi.invoker.ApiException;
import com.rdp.ms_books_catalogue.openapi.invoker.Configuration;
import com.rdp.ms_books_catalogue.openapi.invoker.models.*;
import com.rdp.ms_books_catalogue.openapi.BooksControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        BooksControllerApi apiInstance = new BooksControllerApi(defaultClient);
        BookDto bookDto = new BookDto(); // BookDto | 
        try {
            Book result = apiInstance.createBook(bookDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BooksControllerApi#createBook");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **bookDto** | [**BookDto**](BookDto.md)|  | |

### Return type

[**Book**](Book.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## deleteBook

> String deleteBook(id)



### Example

```java
// Import classes:
import com.rdp.ms_books_catalogue.openapi.invoker.ApiClient;
import com.rdp.ms_books_catalogue.openapi.invoker.ApiException;
import com.rdp.ms_books_catalogue.openapi.invoker.Configuration;
import com.rdp.ms_books_catalogue.openapi.invoker.models.*;
import com.rdp.ms_books_catalogue.openapi.BooksControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        BooksControllerApi apiInstance = new BooksControllerApi(defaultClient);
        Long id = 56L; // Long | 
        try {
            String result = apiInstance.deleteBook(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BooksControllerApi#deleteBook");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getBook

> Book getBook(id)



### Example

```java
// Import classes:
import com.rdp.ms_books_catalogue.openapi.invoker.ApiClient;
import com.rdp.ms_books_catalogue.openapi.invoker.ApiException;
import com.rdp.ms_books_catalogue.openapi.invoker.Configuration;
import com.rdp.ms_books_catalogue.openapi.invoker.models.*;
import com.rdp.ms_books_catalogue.openapi.BooksControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        BooksControllerApi apiInstance = new BooksControllerApi(defaultClient);
        String id = "id_example"; // String | 
        try {
            Book result = apiInstance.getBook(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BooksControllerApi#getBook");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |

### Return type

[**Book**](Book.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getBooks

> List&lt;Book&gt; getBooks(title, author, category, isbn, publicationDate, rating, price, description, visible)



### Example

```java
// Import classes:
import com.rdp.ms_books_catalogue.openapi.invoker.ApiClient;
import com.rdp.ms_books_catalogue.openapi.invoker.ApiException;
import com.rdp.ms_books_catalogue.openapi.invoker.Configuration;
import com.rdp.ms_books_catalogue.openapi.invoker.models.*;
import com.rdp.ms_books_catalogue.openapi.BooksControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        BooksControllerApi apiInstance = new BooksControllerApi(defaultClient);
        String title = "title_example"; // String | 
        String author = "author_example"; // String | 
        String category = "category_example"; // String | 
        String isbn = "isbn_example"; // String | 
        LocalDate publicationDate = LocalDate.now(); // LocalDate | 
        Integer rating = 56; // Integer | 
        BigDecimal price = new BigDecimal(78); // BigDecimal | 
        String description = "description_example"; // String | 
        Boolean visible = true; // Boolean | 
        try {
            List<Book> result = apiInstance.getBooks(title, author, category, isbn, publicationDate, rating, price, description, visible);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BooksControllerApi#getBooks");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **title** | **String**|  | [optional] |
| **author** | **String**|  | [optional] |
| **category** | **String**|  | [optional] |
| **isbn** | **String**|  | [optional] |
| **publicationDate** | **LocalDate**|  | [optional] |
| **rating** | **Integer**|  | [optional] |
| **price** | **BigDecimal**|  | [optional] |
| **description** | **String**|  | [optional] |
| **visible** | **Boolean**|  | [optional] |

### Return type

[**List&lt;Book&gt;**](Book.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## patchBook

> Book patchBook(id, requestBody)



### Example

```java
// Import classes:
import com.rdp.ms_books_catalogue.openapi.invoker.ApiClient;
import com.rdp.ms_books_catalogue.openapi.invoker.ApiException;
import com.rdp.ms_books_catalogue.openapi.invoker.Configuration;
import com.rdp.ms_books_catalogue.openapi.invoker.models.*;
import com.rdp.ms_books_catalogue.openapi.BooksControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        BooksControllerApi apiInstance = new BooksControllerApi(defaultClient);
        Long id = 56L; // Long | 
        Map<String, Object> requestBody = null; // Map<String, Object> | 
        try {
            Book result = apiInstance.patchBook(id, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BooksControllerApi#patchBook");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | |
| **requestBody** | [**Map&lt;String, Object&gt;**](Object.md)|  | |

### Return type

[**Book**](Book.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## updateBook

> Book updateBook(id, bookDto)



### Example

```java
// Import classes:
import com.rdp.ms_books_catalogue.openapi.invoker.ApiClient;
import com.rdp.ms_books_catalogue.openapi.invoker.ApiException;
import com.rdp.ms_books_catalogue.openapi.invoker.Configuration;
import com.rdp.ms_books_catalogue.openapi.invoker.models.*;
import com.rdp.ms_books_catalogue.openapi.BooksControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        BooksControllerApi apiInstance = new BooksControllerApi(defaultClient);
        Long id = 56L; // Long | 
        BookDto bookDto = new BookDto(); // BookDto | 
        try {
            Book result = apiInstance.updateBook(id, bookDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BooksControllerApi#updateBook");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | |
| **bookDto** | [**BookDto**](BookDto.md)|  | |

### Return type

[**Book**](Book.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

