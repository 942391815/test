package com.test.java.validator;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.internal.engine.groups.DefaultValidationOrder;
import org.junit.BeforeClass;
import org.junit.Test;

public class CarTest {

private static Validator validator;

   @BeforeClass
   public static void setUp() {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      validator = factory.getValidator();
   }
   public static void main(String[] args) throws NoSuchMethodException, SecurityException {
	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   ExecutableValidator executableValidator = factory.getValidator().forExecutables();
	   Car object = new Car( "Morris" );
	   Method method = Car.class.getMethod("drive", Car.class );
	   Object[] parameterValues = {null};
	   Set<ConstraintViolation<Car>> violations = executableValidator.validateParameters(
	   		object,
	   		method,
	   		parameterValues
	   );
	   Iterator<ConstraintViolation<Car>> result = violations.iterator();
	   ConstraintViolation<Car> each = result.next();
	   System.out.println(each.getMessage());
   }
   @Test
   public void manufacturerIsNull() {
      Car car = new Car( null, "DD-AB-123", 4 );

      Set<ConstraintViolation<Car>> constraintViolations =
      validator.validate( car );

      assertEquals( 1, constraintViolations.size() );
      assertEquals(
         "may not be null",
         constraintViolations.iterator().next().getMessage()
      );
   }

   @Test
   public void licensePlateTooShort() {
      Car car = new Car( "Morris", "D", 4 );

      Set<ConstraintViolation<Car>> constraintViolations =
      validator.validate( car );

      assertEquals( 1, constraintViolations.size() );
      assertEquals(
         "size must be between 2 and 14",
         constraintViolations.iterator().next().getMessage()
      );
   }

   @Test
   public void seatCountTooLow() {
      Car car = new Car( "Morris", "DD-AB-123", 1 );

      Set<ConstraintViolation<Car>> constraintViolations =
      validator.validate( car );

      assertEquals( 1, constraintViolations.size() );
      assertEquals(
         "must be greater than or equal to 2",
         constraintViolations.iterator().next().getMessage()
      );
   }

   @Test
   public void carIsValid() {
      Car car = new Car( "Morris", "DD-AB-123", 2 );

      Set<ConstraintViolation<Car>> constraintViolations =
      validator.validate( car );

      assertEquals( 0, constraintViolations.size() );
   }
}