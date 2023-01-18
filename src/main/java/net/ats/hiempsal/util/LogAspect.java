/////////////////////////////////////////////////
//
// net.ats.hiempsal.util.LogAspect.java is an
// Aspect class to advise some Log input, output
// & processing time.
//
/////////////////////////////////////////////////
package net.ats.hiempsal.util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

/**
 * The <code>LogAspect</code> class represents Aspect to advise some
 * Log operation.
 * <p>
 * <code>LogAspect</code> use AspectJ AOP for advising
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@Slf4j
@Aspect
@Component
public class LogAspect {
	
	@Pointcut("execution(public * net.ats.hiempsal.user.*.*(..))")
	public void methodCall() {}
	
	@Before("methodCall()")
	public void beforeCall(JoinPoint jp) {
		log.info("Before Call "+jp.toShortString()+" with "+ jp.getArgs().length+ " args");
		Arrays.asList(jp.getArgs()).forEach(o-> log.info("arg: "+o));
	}
	@AfterReturning(pointcut="methodCall()", returning="res")
	public void afterCall(JoinPoint jp, Object res) {
		log.info("After Call "+jp.toShortString());
		log.info("return: "+res);
	}
	@Around("methodCall()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		Object obj=null;
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		obj=jp.proceed();
		stopWatch.stop();
		log.info("*** processing time *** "+stopWatch.getTotalTimeSeconds()+" sec ***");
		return obj;
	}
}
