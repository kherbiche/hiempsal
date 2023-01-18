//////////////////////////////////////////////
//
// net.ats.hiempsal.util.ValidAge.java is a
// custom annotation
// 
/////////////////////////////////////////////
package net.ats.hiempsal.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
@Documented
public @interface ValidAge {
	String message() default "{Age < 18}";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default {};
}
