package com.flashcards.classdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//import com.revature.pojo.Person;

@Aspect
@Component
public class FlashCardAspect {
	/*
	 *  AOP - Not specific to Spring, spring just uses it too
	 *  
	 *  	Aspect Oriented Programming
	 *  
	 *   "Highjack" methods to build a module with it (aspect)
	 *   	Aspect is the module you are building like:
	 *   		-logging module
	 *   		-transactions module
	 *   		-security module
	 *   		(bread crumb system)
	 *   	Above is Cross Cutting Concerns: multiple layers of the application
	 *   
	 *   Aspect -Class used for an AOP feature
	 *   Advice -types of interceptions
	 *   PointCut -The expression of the methods you want to intercept
	 *   JoinPoint - a point in the code that can be intercepted
	 *   				e.g. method/exception thrown
	 *   
	 *   https://blog.espenberntsen.net/2010/03/20/aspectj-cheat-sheet/
	 */
	/*
	 *  Log to the console when certain methods are called
	 * 		
	 * 		Advice @s
	 * 		@Before
	 * 		@After
	 * 		@Around
	 * 		@AfterThrowing
	 * 		What is the most powerful Advice? - @Around allows stopping and starting
	 * 
	 *   	PointCut Expression: execution(* com.revature.service.AppService.play*(..))
	 *   		Is used to decide what to intercept/hijack
	 *   
	 */
	
	
//	@Before("execution(* com.revature.service.AppService.play*(..))")
//	public void highjackPlays(JoinPoint jp){
//		System.out.println("Highjacking the 2 play* methods");
//		for( Object e : jp.getArgs()) {
//					e = 100;
//		}
//	}
//	
//	@Around("execution(* com.revature.service.AppService.run*(..))")
//	public void testAroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
//		System.out.println("set up rides");
//		Person p = (Person) pjp.getArgs()[0];
//		p.setId(100);
//		System.out.println(pjp.getSignature());
//		pjp.proceed();
//		
//		System.out.println("clean up rides");
//		
//		
//	}
	
}
