package com.free.studio.framework.core.components.buitin.thread.impl;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.free.studio.framework.core.components.buitin.thread.DefaultTask;
import com.free.studio.framework.core.components.buitin.thread.MultiThreadExecutor;
import com.free.studio.framework.core.components.buitin.thread.ThreadHandler;

/**
 * @Title: MultiThreadExecutorImpl.java
 * @Package com.free.studio.framework.core.components.buitin.thread.impl
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:13:56
 * @version V1.0
 */
public abstract class MultiThreadExecutorImpl implements MultiThreadExecutor {
	private int threadCount = 5;
	private List<Object[]> methodArgs;
	private ThreadHandler handler = null;
	private Class taskClass = null;

	public MultiThreadExecutorImpl() {
	}

	public MultiThreadExecutorImpl(int threadCount, ThreadHandler handler, List<Object[]> methodArgs) {
		this.threadCount = threadCount;
		this.handler = handler;

		this.methodArgs = (methodArgs == null ? new ArrayList() : methodArgs);
	}

	public void start(List<Object[]> methodArgs) {
		this.methodArgs = (methodArgs == null ? new ArrayList() : methodArgs);
		start();
	}

	public void start() {
		List<Thread> list = new ArrayList();
		for (int i = 0; i < this.threadCount; i++) {
			List<Object[]> subList = getSubArgs(i);

			Thread thread = null;
			if (this.taskClass == null) {
				thread = new DefaultTask(this.handler, subList);
			} else {
				try {
					Constructor constructor = this.taskClass
							.getConstructor(new Class[] { ThreadHandler.class, List.class });
					thread = (Thread) constructor.newInstance(new Object[] { this.handler, subList });
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage(), e);
				}
			}
			list.add(thread);
			thread.start();
		}
		for (Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
	}

	private List<Object[]> getSubArgs(int index) {
		int argsSize = this.methodArgs.size();
		if (index >= argsSize) {
			return null;
		}
		if (argsSize < this.threadCount) {
			return this.methodArgs.subList(index, Math.max(index + 1, argsSize));
		}
		int block = argsSize / this.threadCount;
		int start = block * index;
		int to = block * (index + 1);
		return this.methodArgs.subList(start, Math.min(to, argsSize));
	}

	public int getThreadCount() {
		return this.threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	public ThreadHandler getHandler() {
		return this.handler;
	}

	public void setHandler(ThreadHandler handler) {
		this.handler = handler;
	}

	public Class getTaskClass() {
		return this.taskClass;
	}

	public void setTaskClass(Class taskClass) {
		this.taskClass = taskClass;
	}
}
