package vn.smartdev.user.dao.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by levuhuy on 12/22/16.
 */
public class PhoneValidator implements ConstraintValidator<Phone,String>{
    @Override
    public void initialize(Phone paramA) {

    }

    @Override
    public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
        if (phoneNo == null){
            return false;
        }

        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
            //validating phone number with -, . or spaces
        else return false;
    }
}
