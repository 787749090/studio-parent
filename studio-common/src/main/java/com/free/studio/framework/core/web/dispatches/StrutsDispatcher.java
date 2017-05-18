package com.free.studio.framework.core.web.dispatches;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.ognl.MethodAccessor;
import org.apache.ibatis.ognl.OgnlRuntime;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import com.free.studio.framework.core.web.WebConfig;
import com.free.studio.framework.core.web.WebDispatcher;

/**
 * @Title: StrutsDispatcher.java
 * @Package com.free.studio.framework.core.web.dispatches
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:30:26
 * @version V1.0
 */
public class StrutsDispatcher implements WebDispatcher {
	private StrutsPrepareAndExecuteFilter strutsFilter = null;

	public void init(WebConfig config) throws ServletException {
		handleStrutsSecurity();
		this.strutsFilter = new StrutsPrepareAndExecuteFilter();
		this.strutsFilter.init(config.getFilterConfig());
	}

	private void handleStrutsSecurity() {
		MethodAccessor deny = new SecurityMethodAccessor();
		OgnlRuntime.setMethodAccessor(Runtime.class, deny);
		OgnlRuntime.setMethodAccessor(ProcessBuilder.class, deny);
		OgnlRuntime.setMethodAccessor(OgnlRuntime.class, deny);
	}

	public void destroy() {
		this.strutsFilter.destroy();
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		this.strutsFilter.doFilter(request, response, filterChain);
	}
}
