package eme.utils;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;

public class Request {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private Request() {}

    public static <T> T sendPostRequest(String url, Object json, Class<T> responseClass) {
        String response = sendPostRequest(url, json);

        try {
            return OBJECT_MAPPER.readValue(response, responseClass);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to convert response to object", e);
        }
    }

    public static String sendPostRequest(String url, Object json) {

        String jsonInputString;
        try {
            jsonInputString = OBJECT_MAPPER.writeValueAsString(json);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to convert object to json", e);
        }
        

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                .build();

        return sendRequest(request);
    }

    public static String sendPostRequest(String url, Object json, String token) {

        String jsonInputString;
        try {
            jsonInputString = OBJECT_MAPPER.writeValueAsString(json);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to convert object to json", e);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", token)
                .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                .build();

        return sendRequest(request);
    }

    private static String sendRequest(HttpRequest request) {
        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to send request", e);
        }
        
        checkStatusCodes(response);

        return response.body();
    }

    private static void checkStatusCodes(HttpResponse<String> response) {
        switch (response.statusCode()) {
            case 200:
                break;
            case 400:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
            case 401:
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
            case 403:
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Forbidden");
            case 404:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
            case 500:
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
            default:
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error");
        }
    }
}
