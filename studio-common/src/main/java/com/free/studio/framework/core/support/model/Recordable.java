package com.free.studio.framework.core.support.model;

import java.util.Date;

/**
 * @Title: Recordable.java
 * @Package com.free.studio.framework.core.support.model
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:56:47
 * @version V1.0
 */
public abstract interface Recordable {

	public abstract String getCreator();

	public abstract void setCreator(String paramString);

	public abstract Date getCreateTime();

	public abstract void setCreateTime(Date paramDate);

	public abstract String getModifier();

	public abstract void setModifier(String paramString);

	public abstract Date getModifyTime();

	public abstract void setModifyTime(Date paramDate);
}
