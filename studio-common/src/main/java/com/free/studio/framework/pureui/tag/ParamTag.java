package com.free.studio.framework.pureui.tag;

import javax.servlet.jsp.JspTagException;

/**   
 * @Title: ParamTag.java 
 * @Package com.free.studio.framework.pureui.web.tag 
 * @Description: TODO
 * @author yewp   
 * @date 2017年5月8日 下午5:33:39 
 * @version V1.0   
 */
public class ParamTag extends ParamSupport{

	 private static final long serialVersionUID = -6205808451445326400L;
	  
	  public void setName(String name)
	    throws JspTagException
	  {
	    this.name = name;
	  }
	  
	  public void setValue(String value)
	    throws JspTagException
	  {
	    this.value = value;
	  }
}
