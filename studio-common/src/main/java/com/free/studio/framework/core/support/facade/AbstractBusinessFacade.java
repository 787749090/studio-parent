package com.free.studio.framework.core.support.facade;

import java.util.Collection;

import com.free.studio.framework.core.utils.BeanUtils;

/**
 * @Title: AbstractBusinessFacade.java
 * @Package com.free.studio.framework.core.support.facade
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:52:30
 * @version V1.0
 */
public abstract class AbstractBusinessFacade implements BusinessFacade {
	public static <T> T convertBean(Object bean, Class<T> targetType) {
		return BeanUtils.convertBean(bean, targetType);
	}

	public <T> Collection<T> convertCollection(Collection origList, Class<T> itemClass) {
		return BeanUtils.convertCollection(origList, itemClass);
	}
}
