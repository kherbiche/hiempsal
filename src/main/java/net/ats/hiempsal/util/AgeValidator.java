////////////////////////////////////////////////
//
// net.ats.hiempsal.util.AgeValidator.java is
// 
// 
///////////////////////////////////////////////
package net.ats.hiempsal.util;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class AgeValidator implements ConstraintValidator<ValidAge, LocalDate> {

	@Override
	public boolean isValid(LocalDate birth, ConstraintValidatorContext context) {
		if(LocalDate.now().getYear()-birth.getYear()>=18) {
			return true;
		}
		return false;
	}
}
