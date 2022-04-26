package com.acamus.disney.exception;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
public class ParamBadRequest extends RuntimeException{

    public ParamBadRequest(String message){
        super(message);
    }
}
