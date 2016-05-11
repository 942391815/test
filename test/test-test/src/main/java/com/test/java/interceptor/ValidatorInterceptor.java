package com.test.java.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


@Aspect
public class ValidatorInterceptor implements ApplicationContextAware{
	private ApplicationContext applicationContext;
	@Pointcut("@annotation(com.test.java.interceptor.Validator)")
	public void validator() {

	}
	@Around("validator()")
	public Object validator(ProceedingJoinPoint proceed) throws Throwable {
		Method method = getMethod(proceed);
		Object[] args = proceed.getArgs();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		if(args!=null){
			for(int i=0;i<args.length;i++){
				if(parameterAnnotations[i]!=null){
					for(int j=0;j<parameterAnnotations[i].length;j++){
						Annotation each = parameterAnnotations[i][j];
						if(each instanceof NotNull){
							if(!validatorNotNull(args[i], (NotNull)each)){
								throw new ValidationException("验证无法通过");
//								System.out.println("验证无法通过");
							}
						}else if(each instanceof CustomValidator){
							if(!customValidator(args[i], (CustomValidator)each)){
								throw new ValidationException("验证无法通过");
							}
						} 
					}
				}
			}
		}
		return proceed.proceed();
	}
	private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
		Signature sig = jp.getSignature();
		MethodSignature msig = (MethodSignature) sig;
		return getClass(jp).getMethod(msig.getName(), msig.getParameterTypes());
	}

	private Class<? extends Object> getClass(JoinPoint jp)
			throws NoSuchMethodException {
		return jp.getTarget().getClass();
	}
	private boolean validatorNotNull(Object obj,NotNull rules){
		String[] properties = rules.properties();
		if(properties!=null&&properties.length>0){
			for(String each :properties){
				ExpressionParser parser = new SpelExpressionParser();
		          StandardEvaluationContext teslaContext = new StandardEvaluationContext();
		          teslaContext.setVariable("p", obj);
		          if(parser.parseExpression(each).getValue(teslaContext)==null){
		        	  return false;
		          }
			}
		}else{
			return obj==null?false:true;
		}
		return true;
	}
	private boolean customValidator(Object obj,CustomValidator rules){
		Class[] clazz = rules.clazz();
		if(clazz!=null){
			for(Class each:clazz){
				Validation validation = (Validation)applicationContext.getBean(each);
				if(!validation.execute(obj)){
					return false;
				}
			}
		}
		return true;
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}