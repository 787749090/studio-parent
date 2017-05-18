package com.free.studio.framework.core.web.servlet;

import java.util.Map;

import org.apache.ibatis.ognl.MethodAccessor;
import org.apache.ibatis.ognl.MethodFailedException;

import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: SecurityMethodAccessor.java
 * @Package com.free.studio.framework.core.web.servlet
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:37:08
 * @version V1.0
 */
public class SecurityMethodAccessor implements MethodAccessor {
	public Object callMethod(Map map, Object obj, String s, Object[] aobj) throws MethodFailedException {
		throw new FrameworkException("This function call is prohibited.obj:" + obj + ";method:" + s);
	}

	public Object callStaticMethod(Map map, Class class1, String s, Object[] aobj) throws MethodFailedException {
		throw new FrameworkException("This function call is prohibited.class:" + class1 + ";method:" + s);
	}
}
