package com.api.exception;

import net.bytebuddy.implementation.bind.annotation.Super;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
