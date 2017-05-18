package com.free.studio.framework.core.web.dispatches.simple;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   
 * @Title: ActionContext.java 
 * @Package com.free.studio.framework.core.web.dispatches.simple 
 * @Description: TODO
 * @author yewp   
 * @date 2017年5月9日 下午2:31:03 
 * @version V1.0   
 */
public class ActionContext {
	private HttpServletRequest request;
	  private HttpServletResponse response;
	  
	  public ActionContext(HttpServletRequest request, HttpServletResponse response)
	  {
	    this.request = request;
	    this.response = response;
	  }
	  
	  public HttpServletRequest getRequest()
	  {
	    return this.request;
	  }
	  
	  public HttpServletResponse getResponse()
	  {
	    return this.response;
	  }
	  
	  public String getParam(String name)
	  {
	    return this.request.getParameter(name);
	  }
}
