package org.library.library.dto;

import lombok.Getter;
import lombok.Setter;
import org.library.library.exceptions.ApiErrorResponse;


@Getter
@Setter
public class ApiResponse<T> {
    private int status;
    private boolean respuestaExitosa;
    private String mensaje;
    private T data;
    private ApiErrorResponse error;

    public ApiResponse(int status, boolean respuestaExitosa, String mensaje, T data, ApiErrorResponse error) {
        this.status = status;
        this.respuestaExitosa = respuestaExitosa;
        this.mensaje = mensaje;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponse<T> success(int status, boolean respuestaExitosa, String mensaje, T data) {
        return new ApiResponse<>(status, true, mensaje, data, null);
    }

    public static <T> ApiResponse<T> error(int status, String errorMessage, String errorDetail) {
        return new ApiResponse<>(status, false, null, null, new ApiErrorResponse(errorMessage, errorDetail));
    }
}
