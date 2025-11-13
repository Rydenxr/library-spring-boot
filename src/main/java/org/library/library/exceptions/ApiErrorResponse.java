package org.library.library.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorResponse {
    private String errorMessage;
    private String errorDetail;

    public ApiErrorResponse(String errorMessage, String errorDetail) {
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

}
