//////////////////////////////////////////////
//
// net.ats.hiempsal.util.ValidCountry.java
// is a custom annotation
// 
/////////////////////////////////////////////
package net.ats.hiempsal.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CountryValidator.class)
@Documented
public @interface ValidCountry {
	String message() default "{Country != France}";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default {};
}
