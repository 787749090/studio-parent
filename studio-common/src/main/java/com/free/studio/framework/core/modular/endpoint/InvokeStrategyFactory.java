package com.free.studio.framework.core.modular.endpoint;

import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.modular.ModularInterface;

/**
 * @Title: InvokeStrategyFactory.java
 * @Package com.free.studio.framework.core.modular.endpoint
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:47:11
 * @version V1.0
 */
public class InvokeStrategyFactory {
	private static String DEBUG_ENDPOINT = "debug";
	private static String AUTO_ENDPOINT = "auto";
	private static String LOCALE_ENDPOINT = "locale";

	public static InvokeStrategy getStrategy(ModularInterface mi) {
		String module = mi.getModule();
		String endpoint = mi.getEndpoint();
		InvokeStrategy strategy = null;
		if ((endpoint == null) || (endpoint.length() < 1) || (AUTO_ENDPOINT.equals(endpoint))) {
			if (ContextManager.hasModule(module)) {
				strategy = new LocalInvokeStrategy();
			} else {
				strategy = new DebugInvokeStrategy();
			}
		} else if (LOCALE_ENDPOINT.equals(endpoint)) {
			strategy = new LocalInvokeStrategy();
		} else if (DEBUG_ENDPOINT.equals(endpoint)) {
			strategy = new DebugInvokeStrategy();
		} else {
			strategy = new RemoteInvokeStrategy();
		}
		return strategy;
	}
}
