/*
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.rdp.ms_books_catalogue.openapi.invoker;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.databind.module.SimpleModule;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-19T20:14:11.823620-05:00[America/Bogota]", comments = "Generator version: 7.13.0")
public class RFC3339JavaTimeModule extends SimpleModule {

    public RFC3339JavaTimeModule() {
        super("RFC3339JavaTimeModule");

        addDeserializer(Instant.class, RFC3339InstantDeserializer.INSTANT);
        addDeserializer(OffsetDateTime.class, RFC3339InstantDeserializer.OFFSET_DATE_TIME);
        addDeserializer(ZonedDateTime.class, RFC3339InstantDeserializer.ZONED_DATE_TIME);
    }
}
