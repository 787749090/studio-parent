package com.free.studio.framework.core.components.buitin.thread;

import java.util.Iterator;
import java.util.List;

/**
 * @Title: DefaultTask.java
 * @Package com.free.studio.framework.core.components.buitin.thread
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:12:33
 * @version V1.0
 */
public class DefaultTask extends Thread {
	private List<Object[]> methodArgs;
	private ThreadHandler handler = null;

	public DefaultTask(ThreadHandler handler, List<Object[]> methodArgs) {
		this.methodArgs = methodArgs;
		this.handler = handler;
		this.methodArgs = methodArgs;
	}

	public void run() {
		if (this.methodArgs == null) {
			return;
		}
		for (Iterator iter = this.methodArgs.iterator(); iter.hasNext();) {
			Object[] args = (Object[]) iter.next();
			this.handler.handle(args);
		}
	}
}
