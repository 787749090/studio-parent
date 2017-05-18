package com.free.studio.framework.core.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * @Title: BeanUtils.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:17:46
 * @version V1.0
 */
public class BeanUtils {
	public static void copyProperties(Object dest, Object orig) throws RuntimeException {
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(dest, orig);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static Object cloneBean(Object bean) throws RuntimeException {
		try {
			return org.apache.commons.beanutils.BeanUtils.cloneBean(bean);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static Object getProperty(Object bean, String name) throws RuntimeException {
		try {
			return PropertyUtils.getProperty(bean, name);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void setProperty(Object bean, String name, Object value) throws RuntimeException {
		try {
			if ((value != null) && ("java.util.Date".equals(value.getClass().getName()))) {
				SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				value = dateTimeFormat.format(value);
			}
			org.apache.commons.beanutils.BeanUtils.setProperty(bean, name, value);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static Collection copyCollection(Collection coll) throws RuntimeException {
		Collection to = null;
		try {
			to = (Collection) coll.getClass().newInstance();
			Iterator iter = coll.iterator();
			while (iter.hasNext()) {
				Object obj = iter.next();
				Object tmp = cloneBean(obj);
				to.add(tmp);
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return to;
	}

	public static <T> Collection<T> convertCollection(Collection origList, Class<T> itemClass) {
		if (origList == null) {
			return null;
		}
		Collection destList = (Collection) instance(origList.getClass());
		for (Iterator iter = origList.iterator(); iter.hasNext();) {
			Object orig = iter.next();
			Object dest = instance(itemClass);
			copyProperties(dest, orig);
			destList.add(dest);
		}
		return destList;
	}

	public static <T> T convertBean(Object bean, Class<T> targetType) {
		if (bean == null) {
			return null;
		}
		T target = (T) instance(targetType);
		copyProperties(target, bean);
		return target;
	}

	public static Object instance(Class clazz) {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static boolean registered = false;

	public static void register() {
		if (!registered) {
			ConvertUtils.register(new MySqlTimestampConverter(), Timestamp.class);
			ConvertUtils.register(new MyIntegerConverter(), Integer.class);
			ConvertUtils.register(new MyLongConverter(), Long.class);
			ConvertUtils.register(new MyDoubleConverter(), Double.class);

			ConvertUtils.register(new UtilDateConverter(), Date.class);
			registered = true;
		}
	}

	static {
		register();
	}
}
