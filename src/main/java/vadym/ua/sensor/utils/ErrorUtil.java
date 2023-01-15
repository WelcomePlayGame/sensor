package vadym.ua.sensor.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;


public class ErrorUtil {
    public  static void returnErrorsToClient(BindingResult bindingResult) {

        StringBuilder errorMSG =new StringBuilder();

        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            errorMSG.append(error.getField())
                    .append("-").append(error.getDefaultMessage()==null? error.getCode() : error.getDefaultMessage())
                    .append(";");
        }

        throw new MeasureException(errorMSG.toString());
    }
}
