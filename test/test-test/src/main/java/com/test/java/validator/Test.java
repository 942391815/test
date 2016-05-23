package com.test.java.validator;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;


public class Test {
	public static void main(String args[]) throws Exception{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		   ExecutableValidator executableValidator = factory.getValidator().forExecutables();
		   Car object = new Car( "Morris" );
		   Method method = Car.class.getMethod("valid", Date.class,Date.class);
		   Object[] parameterValues = {new Date(), new Date()};
		   Set<ConstraintViolation<Car>> violations = executableValidator.validateParameters(
		   		object,
		   		method,
		   		parameterValues
		   );
		   Iterator<ConstraintViolation<Car>> result = violations.iterator();
		   ConstraintViolation<Car> each = result.next();
		   System.out.println(each.getMessage());
	}
}
