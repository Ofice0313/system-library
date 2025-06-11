package com.caleb.library.erros;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant timeStamp, Integer status, String error, String path) {
        super(timeStamp, status, error, path);
    }

    public List<FieldMessage> getErrors(){
        return erros;
    }

    public void addErrors(String fieldName, String message){
        erros.add(new FieldMessage(fieldName, message));
    }
}
