package org.polarsys.reqcycle.operations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReqCycleOperation implements Comparable<ReqCycleOperation> {
	private String name;
	private String description;
	private Object caller ;
	private Method method ;
	
	public ReqCycleOperation(String name, String description, Object caller, Method method) {
		this.setName(name);
		this.setDescription(description);
		this.method = method;
		this.caller = caller;
	}
	
	public Object execute (Object[] args){
		try {
			boolean accessible = method.isAccessible();
			if (!accessible){
				method.setAccessible(true);
			}
			Object result = method.invoke(caller, args);
			if (!accessible){
				method.setAccessible(false);
			}
			return result;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Method getMethod() {
		return method;
	}
	
	public void setMethod(Method method) {
		this.method = method;
	}
	
	@Override
	public int compareTo(ReqCycleOperation arg0) {
		return this.getName().compareTo(arg0.getName());
	}
}
