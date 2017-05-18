package com.free.studio.framework.core.enhanced;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.free.studio.framework.core.exception.ExceptionHolder;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @Title: ActionInterceptor.java
 * @Package com.free.studio.framework.core.enhanced
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:23:16
 * @version V1.0
 */
public class ActionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -1045763669197027695L;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public String intercept(ActionInvocation ai) throws Exception {
		ServletActionContext.getRequest().setAttribute("this", ai.getAction());

		ActionProxy proxy = ai.getProxy();

		this.logger.debug("Begin Action.Namespace:{},ActionName:{};Method:{};",
				new Object[] { proxy.getNamespace(), proxy.getActionName(), proxy.getMethod() });

		String result = "success";
		try {
			result = ai.invoke();
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);

			ExceptionHolder.addException(e);
			throw e;
		}
		this.logger.debug("Finish Action.Namespace:{},ActionName:{};Method:{};",
				new Object[] { proxy.getNamespace(), proxy.getActionName(), proxy.getMethod() });

		return result;
	}
}
