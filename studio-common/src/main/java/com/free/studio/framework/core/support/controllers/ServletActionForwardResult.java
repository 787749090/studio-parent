package com.free.studio.framework.core.support.controllers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.views.util.UrlHelper;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.config.entities.ResultConfig;

/**
 * @Title: ServletActionForwardResult.java
 * @Package com.free.studio.framework.core.support.controllers
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:49:55
 * @version V1.0
 */
public class ServletActionForwardResult extends ServletRedirectResult {

	private static final Log log = LogFactory.getLog(ServletActionForwardResult.class);
	private static final long serialVersionUID = -9042425229314584066L;
	public static final String DEFAULT_PARAM = "actionName";
	protected String actionName;
	protected String namespace;
	protected String method;
	private Map<String, String> requestParameters = new LinkedHashMap();

	public ServletActionForwardResult() {
	}

	public ServletActionForwardResult(String actionName) {
		this(null, actionName, null);
	}

	public ServletActionForwardResult(String actionName, String method) {
		this(null, actionName, method);
	}

	public ServletActionForwardResult(String namespace, String actionName, String method) {
		super(null);
		this.namespace = namespace;
		this.actionName = actionName;
		this.method = method;
	}

	protected List<String> prohibitedResultParam = Arrays.asList(new String[] { "actionName", "namespace", "method",
			"encode", "parse", "location", "prependServletContext" });

	public void execute(ActionInvocation invocation) throws Exception {
		this.actionName = conditionalParse(this.actionName, invocation);
		if (this.namespace == null) {
			this.namespace = invocation.getProxy().getNamespace();
		} else {
			this.namespace = conditionalParse(this.namespace, invocation);
		}
		this.method = null;
		if (this.method == null) {
			this.method = "";
		} else {
			this.method = conditionalParse(this.method, invocation);
		}
		String resultCode = invocation.getResultCode();
		Iterator i;
		if (resultCode != null) {
			ResultConfig resultConfig = (ResultConfig) invocation.getProxy().getConfig().getResults().get(resultCode);

			Map resultConfigParams = resultConfig.getParams();
			for (i = resultConfigParams.entrySet().iterator(); i.hasNext();) {
				Map.Entry e = (Map.Entry) i.next();
				if (!this.prohibitedResultParam.contains(e.getKey())) {
					this.requestParameters.put(e.getKey().toString(),
							e.getValue() == null ? "" : conditionalParse(e.getValue().toString(), invocation));
				}
			}
		}
		StringBuilder tmpLocation = new StringBuilder(this.actionMapper
				.getUriFromActionMapping(new ActionMapping(this.actionName, this.namespace, this.method, null)));
		UrlHelper.buildParametersString(this.requestParameters, tmpLocation, "&");

		setLocation(tmpLocation.toString());

		executeForward(tmpLocation.toString(), invocation);
	}

	public void executeForward(String finalLocation, ActionInvocation invocation) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Forwarding to location " + finalLocation);
		}
		PageContext pageContext = ServletActionContext.getPageContext();
		if (pageContext != null) {
			pageContext.include(finalLocation);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		RequestDispatcher dispatcher = request.getRequestDispatcher(finalLocation);
		if (dispatcher == null) {
			response.sendError(404, "result '" + finalLocation + "' not found");

			return;
		}
		if ((!response.isCommitted()) && (request.getAttribute("javax.servlet.include.servlet_path") == null)) {
			request.setAttribute("struts.view_uri", finalLocation);
			request.setAttribute("struts.request_uri", request.getRequestURI());

			dispatcher.forward(request, response);
		} else {
			dispatcher.include(request, response);
		}
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public ServletActionForwardResult addParameter(String key, Object value) {
		this.requestParameters.put(key, String.valueOf(value));
		return this;
	}
}
