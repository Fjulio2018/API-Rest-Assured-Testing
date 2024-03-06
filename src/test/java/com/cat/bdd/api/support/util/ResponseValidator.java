package com.cat.bdd.api.support.util;

import io.restassured.path.json.JsonPath;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.List;


public class ResponseValidator {
    private JsonPath jsonPath;

    public void fromJson(String json) {

        this.jsonPath = new JsonPath(json);
    }

    public void assertSize(int expectedSize) {
        List<Object> jsonResponse = jsonPath.getList("$");
        int actualSize = jsonResponse.size();
        if (actualSize != expectedSize) {
            throw new AssertionError("Expected size: " + expectedSize + ", Actual size: " + actualSize);
        }
    }

    public void assertItemValue(int index, String expectedField, Object expectedValue) {
        Object actualValue = jsonPath.get("[" + index + "]." + expectedField);
        if (!actualValue.equals(expectedValue)) {
            throw new AssertionError("Expected value for field '" + expectedField + "' at index " + index +
                    ": " + expectedValue + ", Actual value: " + actualValue);
        }
    }

    public void assertJsonSchema(String schemaFilePath) {
        try {
            InputStream schemaStream = getClass().getResourceAsStream(schemaFilePath);

            if (schemaStream == null) {
                throw new IllegalArgumentException("Arquivo de schema não encontrado : " + schemaFilePath);
            }

            JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaStream));
            SchemaLoader.load(jsonSchema).validate(new JSONObject(jsonPath.prettify()));
        } catch (ValidationException e) {
            throw new AssertionError("Response mão bate com schema: " + e.getMessage());
        }
    }



}
