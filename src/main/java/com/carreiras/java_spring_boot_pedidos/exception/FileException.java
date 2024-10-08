package com.carreiras.java_spring_boot_pedidos.exception;

public class FileException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}
