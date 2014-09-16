package org.polarsys.reqcycle.operations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IOperation {

	String value();

	public static interface Result<T> {
		Collection<Object> getObjectsToListen();

		T getResult();

		Class<T> getResultType();
	}

}
