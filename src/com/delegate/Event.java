package com.delegate;

import java.lang.reflect.Method;

/**
 * 
 * @author 王劲文
 * 事件委托，事件类
 */
public class Event {

	private Object object;
	
	private String methodName;
	
	private Object[] params;
	
	private Class[] paramsType;
	
	public Event() {
		super();
	}

	public Event(Object object, String methodName, Object...params) {
		super();
		this.object = object;
		this.methodName = methodName;
		this.params = params;
		contractParamType(params);
	}
	
	public void contractParamType(Object[] params){
		this.paramsType=new Class[params.length];
		for(int i=0;i<params.length;i++){
			paramsType[i]=params[i].getClass();
		}
	}
	
	public void invoke() throws Exception{
		Method method=object.getClass().getMethod(this.getMethodName(), this.getParamsType());
		if(method==null){
			return;
		}
		method.invoke(this.getObject(), this.getParams());
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public Class[] getParamsType() {
		return paramsType;
	}

	public void setParamsType(Class[] paramsType) {
		this.paramsType = paramsType;
	}
	
	
	
}
