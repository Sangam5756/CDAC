package com.healthcare.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	public void startLogging(JoinPoint joinPoint)
	{
		//add logging message here.....
	}

}
