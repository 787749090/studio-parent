package com.free.studio.framework.core.modular;

/**
 * @Title: InterfaceService.java
 * @Package com.free.studio.framework.core.modular
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:44:50
 * @version V1.0
 */
public interface InterfaceService {
	public abstract <T extends ModularFacade> T getFacade(Class<T> paramClass);
}
