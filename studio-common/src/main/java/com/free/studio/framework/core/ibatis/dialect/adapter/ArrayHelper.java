package com.free.studio.framework.core.ibatis.dialect.adapter;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @Title: ArrayHelper.java
 * @Package com.free.studio.framework.core.ibatis.dialect.adapter
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:39:28
 * @version V1.0
 */
public final class ArrayHelper {
	public static int indexOf(Object[] array, Object object) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(object)) {
				return i;
			}
		}
		return -1;
	}

	public static String[] toStringArray(Object[] objects) {
		int length = objects.length;
		String[] result = new String[length];
		for (int i = 0; i < length; i++) {
			result[i] = objects[i].toString();
		}
		return result;
	}

	public static String[] fillArray(String value, int length) {
		String[] result = new String[length];
		Arrays.fill(result, value);
		return result;
	}

	public static int[] fillArray(int value, int length) {
		int[] result = new int[length];
		Arrays.fill(result, value);
		return result;
	}

	public static String[] toStringArray(Collection<String> coll) {
		return (String[]) coll.toArray(new String[coll.size()]);
	}

	public static String[][] to2DStringArray(Collection<String[]> coll) {
		return (String[][]) coll.toArray(new String[coll.size()][]);
	}

	public static int[][] to2DIntArray(Collection<int[]> coll) {
		return (int[][]) coll.toArray(new int[coll.size()][]);
	}

	public static int[] toIntArray(Collection<Integer> coll) {
		Iterator<Integer> iter = coll.iterator();
		int[] arr = new int[coll.size()];
		int i = 0;
		while (iter.hasNext()) {
			arr[(i++)] = ((Integer) iter.next()).intValue();
		}
		return arr;
	}

	public static boolean[] toBooleanArray(Collection<Boolean> coll) {
		Iterator<Boolean> iter = coll.iterator();
		boolean[] arr = new boolean[coll.size()];
		int i = 0;
		while (iter.hasNext()) {
			arr[(i++)] = ((Boolean) iter.next()).booleanValue();
		}
		return arr;
	}

	public static Object[] typecast(Object[] array, Object[] to) {
		return Arrays.asList(array).toArray(to);
	}

	public static List toList(Object array) {
		if ((array instanceof Object[])) {
			return Arrays.asList((Object[]) array);
		}
		int size = Array.getLength(array);
		ArrayList list = new ArrayList(size);
		for (int i = 0; i < size; i++) {
			list.add(Array.get(array, i));
		}
		return list;
	}

	public static String[] slice(String[] strings, int begin, int length) {
		String[] result = new String[length];
		System.arraycopy(strings, begin, result, 0, length);
		return result;
	}

	public static Object[] slice(Object[] objects, int begin, int length) {
		Object[] result = new Object[length];
		System.arraycopy(objects, begin, result, 0, length);
		return result;
	}

	public static List toList(Iterator iter) {
		List list = new ArrayList();
		while (iter.hasNext()) {
			list.add(iter.next());
		}
		return list;
	}

	public static String[] join(String[] x, String[] y) {
		String[] result = new String[x.length + y.length];
		System.arraycopy(x, 0, result, 0, x.length);
		System.arraycopy(y, 0, result, x.length, y.length);
		return result;
	}

	public static String[] join(String[] x, String[] y, int[] use) {
		String[] result = new String[x.length + countTrue(use)];
		System.arraycopy(x, 0, result, 0, x.length);
		int k = x.length;
		for (int i = 0; i < y.length; i++) {
			if (use[i] != 0) {
				result[(k++)] = y[i];
			}
		}
		return result;
	}

	public static int[] join(int[] x, int[] y) {
		int[] result = new int[x.length + y.length];
		System.arraycopy(x, 0, result, 0, x.length);
		System.arraycopy(y, 0, result, x.length, y.length);
		return result;
	}

	public static <T> T[] join(T[] x, T[] y) {
		T[] result = (T[]) Array.newInstance(x.getClass().getComponentType(), x.length + y.length);
		System.arraycopy(x, 0, result, 0, x.length);
		System.arraycopy(y, 0, result, x.length, y.length);
		return result;
	}

	public static final boolean[] TRUE = { true };
	public static final boolean[] FALSE = { false };

	public static String toString(Object[] array) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if (i < array.length - 1) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public static boolean isAllNegative(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAllTrue(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				return false;
			}
		}
		return true;
	}

	public static int countTrue(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				result++;
			}
		}
		return result;
	}

	public static boolean isAllFalse(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void addAll(Collection collection, Object[] array) {
		collection.addAll(Arrays.asList(array));
	}

	public static final String[] EMPTY_STRING_ARRAY = new String[0];
	public static final int[] EMPTY_INT_ARRAY = new int[0];
	public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
	public static final Class[] EMPTY_CLASS_ARRAY = new Class[0];
	public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
	public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

	public static int[] getBatchSizes(int maxBatchSize) {
		int batchSize = maxBatchSize;
		int n = 1;
		while (batchSize > 1) {
			batchSize = getNextBatchSize(batchSize);
			n++;
		}
		int[] result = new int[n];
		batchSize = maxBatchSize;
		for (int i = 0; i < n; i++) {
			result[i] = batchSize;
			batchSize = getNextBatchSize(batchSize);
		}
		return result;
	}

	private static int getNextBatchSize(int batchSize) {
		if (batchSize <= 10) {
			return batchSize - 1;
		}
		if (batchSize / 2 < 10) {
			return 10;
		}
		return batchSize / 2;
	}

	private static int SEED = 23;
	private static int PRIME_NUMER = 37;

	public static int hash(Object[] array) {
		int length = array.length;
		int seed = SEED;
		for (int index = 0; index < length; index++) {
			seed = hash(seed, array[index] == null ? 0 : array[index].hashCode());
		}
		return seed;
	}

	public static int hash(char[] array) {
		int length = array.length;
		int seed = SEED;
		for (int index = 0; index < length; index++) {
			seed = hash(seed, array[index]);
		}
		return seed;
	}

	public static int hash(byte[] bytes) {
		int length = bytes.length;
		int seed = SEED;
		for (int index = 0; index < length; index++) {
			seed = hash(seed, bytes[index]);
		}
		return seed;
	}

	private static int hash(int seed, int i) {
		return PRIME_NUMER * seed + i;
	}

	public static boolean isEquals(Object[] o1, Object[] o2) {
		if (o1 == o2) {
			return true;
		}
		if ((o1 == null) || (o2 == null)) {
			return false;
		}
		int length = o1.length;
		if (length != o2.length) {
			return false;
		}
		for (int index = 0; index < length; index++) {
			if (!o1[index].equals(o2[index])) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEquals(char[] o1, char[] o2) {
		if (o1 == o2) {
			return true;
		}
		if ((o1 == null) || (o2 == null)) {
			return false;
		}
		int length = o1.length;
		if (length != o2.length) {
			return false;
		}
		for (int index = 0; index < length; index++) {
			if (o1[index] != o2[index]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEquals(byte[] b1, byte[] b2) {
		if (b1 == b2) {
			return true;
		}
		if ((b1 == null) || (b2 == null)) {
			return false;
		}
		int length = b1.length;
		if (length != b2.length) {
			return false;
		}
		for (int index = 0; index < length; index++) {
			if (b1[index] != b2[index]) {
				return false;
			}
		}
		return true;
	}

	public static int countNonNull(Serializable[] array) {
		int i = 0;
		for (Serializable element : array) {
			if (element != null) {
				i++;
			}
		}
		return i;
	}

	public static void main(String... args) {
		int[] batchSizes = getBatchSizes(32);

		System.out.println("Forward ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < batchSizes.length; i++) {
			System.out.println("[" + i + "] -> " + batchSizes[i]);
		}
		System.out.println("Backward ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = batchSizes.length - 1; i >= 0; i--) {
			System.out.println("[" + i + "] -> " + batchSizes[i]);
		}
	}
}
