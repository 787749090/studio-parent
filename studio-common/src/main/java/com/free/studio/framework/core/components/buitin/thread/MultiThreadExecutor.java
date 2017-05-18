package com.free.studio.framework.core.components.buitin.thread;

import java.util.List;

/**
 * @Title: MultiThreadExecutor.java
 * @Package com.free.studio.framework.core.components.buitin.thread
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:13:06
 * @version V1.0
 */
public interface MultiThreadExecutor {

	public abstract void start();

	public abstract void start(List<Object[]> paramList);
}
