package com.free.studio.framework.core.validation;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: ConstraintRepository.java
 * @Package com.free.studio.framework.core.validation
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:23:37
 * @version V1.0
 */
public class ConstraintRepository {
	private Map<String, Constraint> constraints = new HashMap();

	public void register(String alias, Constraint constraint) {
		this.constraints.put(alias, constraint);
	}
}
