package com.training.metering.web.exceptionhandler;

import lombok.Getter;
import lombok.Setter;

/**
 * {@link Exception} DTO class.
 *
 * @author Yury Zmushko
 * @version 1.0
 */
@Getter
@Setter
public class ExceptionDTO {
    private String errorMessage;
    private int errorCode;

    /**
     * Default constructor.
     */
    public ExceptionDTO() {
        // Default constructor for Model mapper purposes.
    }

    /**
     * Constructor.
     *
     * @param e         {@link Exception} to wrap.
     * @param errorCode Error code.
     */
    public ExceptionDTO(Exception e, int errorCode) {
        this.errorMessage = e.getMessage();
        this.errorCode = errorCode;
    }

    public ExceptionDTO(Exception e) {
        this.errorMessage = e.getMessage();
    }

    /**
     * Constructor.
     *
     * @param errorMessage Error message.
     * @param errorCode    Error code.
     */
    public ExceptionDTO(String errorMessage, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
