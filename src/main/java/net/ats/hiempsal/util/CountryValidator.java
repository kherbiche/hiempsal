/////////////////////////////////////////////////
//
// net.ats.hiempsal.util.CountryValidator.java
// is
// 
/////////////////////////////////////////////////
package net.ats.hiempsal.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class CountryValidator implements ConstraintValidator<ValidCountry, String>{

	@Override
	public boolean isValid(String country, ConstraintValidatorContext context) {
		if(country.equalsIgnoreCase("france"))
			return true;
		return false;
	}

}
