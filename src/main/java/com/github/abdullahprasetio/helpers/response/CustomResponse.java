package com.github.abdullahprasetio.helpers.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponse {
    private int status = 200;
    private String message;
    private Object data;
    @JsonIgnore
    private HttpHeaders headers;

    public CustomResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Getters and Setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public CustomResponse setHeaders(HttpHeaders headers) {
        this.headers = headers;
        return this;
    }

    public ResponseEntity<CustomResponse> send() {
        return ResponseEntity.status(this.status).headers(this.headers).body(this);
    }
}
