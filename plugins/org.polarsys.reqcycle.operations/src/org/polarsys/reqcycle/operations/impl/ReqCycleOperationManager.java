package org.polarsys.reqcycle.operations.impl;

import java.lang.reflect.Method;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.polarsys.reqcycle.operations.Activator;
import org.polarsys.reqcycle.operations.IOperation;
import org.polarsys.reqcycle.operations.IReqCycleOperationManager;
import org.polarsys.reqcycle.operations.ReqCycleOperation;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;

@Singleton
public class ReqCycleOperationManager implements IReqCycleOperationManager {

	private static final String EXT_ID = "operation";

	private Collection<ReqCycleOperation> allOperations;

	@PostConstruct
	protected void init() {
		allOperations = doGetAllOperations();
	}

	@Override
	public Collection<ReqCycleOperation> getAllOperations() {
		return allOperations;
	}
	
	public Collection<ReqCycleOperation> doGetAllOperations() {
		Collection<ReqCycleOperation> result = Lists.newArrayList();
		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(Activator.PLUGIN_ID, EXT_ID);
		Class c = null;
		Object instance = null;
		
		for (IConfigurationElement e : elements) {
			try {
				c = Platform.getBundle(e.getContributor().getName()).loadClass(
						e.getAttribute("path"));

				instance = c.newInstance();
				ZigguratInject.inject(instance);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InvalidRegistryObjectException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if (c != null) {
				Method[] method = c.getDeclaredMethods();
				for (Method m : method) {
					if (m.isAnnotationPresent(IOperation.class)) {
						IOperation op = m.getAnnotation(IOperation.class);
						ReqCycleOperation reqCycleOp = new ReqCycleOperation(
								m.getName(), op.value(), instance, m);
						result.add(reqCycleOp);
					}
				}
			}
		}

		return result;
	}

	@Override
	public ReqCycleOperation getOperation(String name, Class<?>[] listClass) {
		for (ReqCycleOperation op : allOperations) {
			if (op.getMethod().getName().equals(name)) {
				Class<?>[] paramList = op.getMethod().getParameterTypes();
				if (listClass.length == paramList.length) {
					for (int i = 0; i < paramList.length; i++) {
						Class<?> paramClass = paramList[i];
						if (!(paramClass.isAssignableFrom(listClass[i]))) {
							return null;
						}
					}
				}
				return op;
			}
		}
		return null;
	}
	
	@Override
	public ReqCycleOperation getOperationForEditingAttributes(String name, Class<?>[] listClass) {
		for (ReqCycleOperation op : allOperations) {
			if (op.getMethod().getName().equals(name)) {
				Class<?>[] paramList = op.getMethod().getParameterTypes();
				if ((listClass.length > 0) && (listClass.length == paramList.length - 1)) {
					for (int i = 0; i < listClass.length; i++) {
						Class<?> paramClass = paramList[i + 1];
						if (!(paramClass.isAssignableFrom(listClass[i]))) {
							return null;
						}
					}
				}
				return op;
			}
		}
		return null;
	}
	

}
