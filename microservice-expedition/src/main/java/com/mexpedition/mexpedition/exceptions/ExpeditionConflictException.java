package com.mexpedition.mexpedition.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExpeditionConflictException extends RuntimeException {
	public ExpeditionConflictException (String message) {
        super(message);
    }
}
