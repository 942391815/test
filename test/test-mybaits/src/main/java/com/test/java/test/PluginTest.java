package com.test.java.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

public class PluginTest {
	  public static void main(String args[]){
		  mapPluginShouldInterceptGet();
	  }
	  public static void mapPluginShouldInterceptGet() {
	    Map map = new HashMap();
	    map = (Map) new AlwaysMapPlugin().plugin(map);
	    System.out.println(map.get("Anything"));
	  }

	  public static void shouldNotInterceptToString() {
	    Map map = new HashMap();
	    map = (Map) new AlwaysMapPlugin().plugin(map);
	    System.out.println(map.toString());
	  }

	  @Intercepts({
	      @Signature(type = Map.class, method = "get", args = {Object.class})})
	  public static class AlwaysMapPlugin implements Interceptor {
	    public Object intercept(Invocation invocation) throws Throwable {
	      return "Always";
	    }

	    public Object plugin(Object target) {
	      return Plugin.wrap(target, this);
	    }

	    public void setProperties(Properties properties) {
	    	
	    }
	  }
	}