package com.free.studio.framework.core.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @Title: ArrayUtils.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:17:29
 * @version V1.0
 */
public class ArrayUtils {
	public static String join(String[] values, String flag) {
		if ((EmptyUtils.isNotEmpty(values)) && (!EmptyUtils.isEmpty(flag))) {
			StringBuilder result = new StringBuilder();
			result.append(values[0]);
			for (int i = 1; i < values.length; i++) {
				result.append(flag).append(values[i]);
			}
			return result.toString();
		}
		return null;
	}

	public static String join(Collection values, String flag) {
		if ((EmptyUtils.isNotEmpty(values)) && (!EmptyUtils.isEmpty(flag))) {
			StringBuilder result = new StringBuilder();
			int index = 0;
			for (Iterator iterator = values.iterator(); iterator.hasNext();) {
				Object object = iterator.next();
				if (index++ != values.size() - 1) {
					result.append(object.toString()).append(flag);
				} else {
					result.append(object.toString());
				}
			}
			return result.toString();
		}
		return null;
	}

	public static List getFieldItems(List rows, String field, Boolean removeNull, Boolean returnArray) {
		if (rows == null) {
			return returnArray.booleanValue() == true ? new ArrayList() : null;
		}
		List fields = new ArrayList();
		for (Iterator iterator = rows.iterator(); iterator.hasNext();) {
			Object obj = iterator.next();
			Object value = BeanUtils.getProperty(obj, field);
			if ((removeNull.booleanValue() != true) || (value != null)) {
				fields.add(value);
			}
		}
		return fields;
	}

	public static List getRandomArray(List rows, int length) {
		if ((length < 1) || (EmptyUtils.isEmpty(rows))) {
			return new ArrayList();
		}
		List randomList = new ArrayList();

		Set<Integer> set = new HashSet();

		Random rand = new Random();
		if (length >= rows.size()) {
			return rows;
		}
		for (int i = 0; i < length;) {
			int index = new Integer(rand.nextInt(rows.size())).intValue();
			if (set.add(Integer.valueOf(index))) {
				randomList.add(rows.get(index));

				i++;
			}
		}
		return randomList;
	}

	public static <T> Collection<T> convert(Collection origList, Class<T> itemClass) {
		return BeanUtils.convertCollection(origList, itemClass);
	}
}
