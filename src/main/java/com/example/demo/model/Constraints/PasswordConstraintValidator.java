package com.example.demo.model.Constraints;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.*;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String>{
	 @Override
	    public void initialize(ValidPassword arg0) {
	    }
	 
	    @Override
		public boolean isValid(String value, ConstraintValidatorContext context) {
			 PasswordValidator validator = new PasswordValidator(Arrays.asList(
			           new LengthRule(8, 15), 
			           new UppercaseCharacterRule(1), 
			           new DigitCharacterRule(1), 
			           new LowercaseCharacterRule(1)
			           ));
			 
			        RuleResult result = validator.validate(new PasswordData(value));
			        if (result.isValid()) {
			            return true;
			        }
			        
			        return false;
		}

}
