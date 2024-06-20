package com.github.abdullahprasetio.helpers.response;

public class ResponseSuccess extends CustomResponse {

    public ResponseSuccess(String message, Object data) {
        super(200, message, data);
    }

    public ResponseSuccess(Object data) {
        super(200, "success", data);
    }

}
