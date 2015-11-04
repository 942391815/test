package com.test.java.spring;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class IsNullInterceptor {
	@Pointcut("@annotation(cn.bidlink.qualifications.core.annonation.NeedInspector)")
	public void isNull() {

	}

	@Around("isNull()")
	public Object checkIsNull(ProceedingJoinPoint proceed) throws Throwable {
		Method method = getMethod(proceed);
		Annotation[] annotations = method.getAnnotations();
		for (Annotation ann : annotations) {
			if (ann instanceof NeedInspector) {
				NeedInspector needInspector = (NeedInspector) ann;
				int[] inspectorArgs = needInspector.inspector();
				for (int i : inspectorArgs) {
					Object object = proceed.getArgs()[i];
					isConform(object);
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

	private void isConform(Object object) throws IllegalArgumentException,
			IllegalAccessException {
		// 获取javabean中的各个属性
		if (object == null) {
			throw new RuntimeException("传入的对象为空");
		}
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			Annotation[] fieldsAnnotations = field.getAnnotations();
			for (Annotation fieldAnnotation : fieldsAnnotations) {
				if (fieldAnnotation instanceof QueryCondition) {
					QueryCondition condition = (QueryCondition) fieldAnnotation;
					if (!condition.isNull()) {
						field.setAccessible(true);
						if (field.get(object) == null) {
							throw new RuntimeException(object.getClass()
									.getName()
									+ " 属性 "
									+ field.getName()
									+ " 为空!");
						}
					}
				}
			}
		}
	}
}
