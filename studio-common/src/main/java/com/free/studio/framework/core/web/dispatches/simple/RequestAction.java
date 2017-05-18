package com.free.studio.framework.core.web.dispatches.simple;

import java.io.IOException;

/**   
 * @Title: RequestAction.java 
 * @Package com.free.studio.framework.core.web.dispatches.simple 
 * @Description: TODO
 * @author yewp   
 * @date 2017年5月9日 下午2:31:36 
 * @version V1.0   
 */
public abstract interface RequestAction {
	 public abstract ActionResult handle(ActionContext paramActionContext) throws IOException;
}
