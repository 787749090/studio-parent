package com.free.studio.framework.core.web.dispatches.simple;
/**   
 * @Title: ActionResult.java 
 * @Package com.free.studio.framework.core.web.dispatches.simple 
 * @Description: TODO
 * @author yewp   
 * @date 2017年5月9日 下午2:31:22 
 * @version V1.0   
 */
public class ActionResult {
	public static ActionResult DEFAULT = new ActionResult();
	  
	  public static class ForwardResult
	    extends ActionResult
	  {
	    private String url;
	    
	    public ForwardResult(String url)
	    {
	      this.url = url;
	    }
	    
	    public String getUrl()
	    {
	      return this.url;
	    }
	  }
	  
	  public static class RedirectResult
	    extends ActionResult
	  {
	    private String url;
	    
	    public RedirectResult(String url)
	    {
	      this.url = url;
	    }
	    
	    public String getUrl()
	    {
	      return this.url;
	    }
	  }
	  
	  public static class JSONResult
	    extends ActionResult
	  {
	    private boolean success = true;
	    private Object data;
	    
	    public JSONResult(Object data)
	    {
	      this.data = data;
	    }
	    
	    public JSONResult(boolean success, Object data)
	    {
	      this.success = success;
	      this.data = data;
	    }
	    
	    public boolean isSuccess()
	    {
	      return this.success;
	    }
	    
	    public Object getData()
	    {
	      return this.data;
	    }
	  }
}
