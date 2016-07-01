package com.test.java.spring.beaninit;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBean implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof PersonService) {
			Field[] fields = bean.getClass().getDeclaredFields();
			Object newProxyInstance = Proxy.newProxyInstance(this.getClass().getClassLoader(),
					new Class[]{CommonService.class}, new InvocationHandler() {
						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							return 1;
//							return method.invoke(proxy, args);
						}
					});
			for (Field each : fields) {
				if (each.getName().equals("commonService")) {
					try {
						each.setAccessible(true);
						each.set(bean, newProxyInstance);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(bean + "-------postProcessBeforeInitialization");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(bean + "-------postProcessAfterInitialization");
		return bean;
	}
}
