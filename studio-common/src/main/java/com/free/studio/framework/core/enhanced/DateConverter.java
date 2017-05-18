package com.free.studio.framework.core.enhanced;

import org.apache.commons.beanutils.ConvertUtils;

import com.free.studio.framework.core.utils.BeanUtils;
import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

/**
 * @Title: DateConverter.java
 * @Package com.free.studio.framework.core.enhanced
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:23:48
 * @version V1.0
 */
public class DateConverter extends DefaultTypeConverter {
	public Object convertValue(Object value, Class toType) {
		if (value == null) {
			return null;
		}
		if ((value.getClass().equals(toType)) || (toType.isAssignableFrom(value.getClass()))) {
			return value;
		}
		if (((value instanceof Long)) || ((value instanceof Integer))) {
			BeanUtils.register();
			return ConvertUtils.convert(value.toString(), toType);
		}
		if ((value instanceof String)) {
			BeanUtils.register();
			return ConvertUtils.convert((String) value, toType);
		}
		return super.convertValue(value, toType);
	}
}
