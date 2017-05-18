package com.free.studio.framework.core.modular.endpoint.remote;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.remoting.caucho.HessianExporter;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;

import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.exception.FrameworkException;
import com.free.studio.framework.core.modular.InterfacePublisher;
import com.free.studio.framework.core.utils.EmptyUtils;
import com.free.studio.framework.core.web.dispatches.simple.ActionContext;
import com.free.studio.framework.core.web.dispatches.simple.ActionResult;
import com.free.studio.framework.core.web.dispatches.simple.RequestAction;

/**
 * @Title: RemoteServerAction.java
 * @Package com.free.studio.framework.core.modular.endpoint.remote
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:48:27
 * @version V1.0
 */
@Controller("/rpcServer")
@Scope("prototype")
public class RemoteServerAction implements RequestAction {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public String invoke() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		resolveRPCRequest(request, response);
		return "success";
	}

	private void resolveRPCRequest(HttpServletRequest request, HttpServletResponse response) {
		String module = request.getParameter("module");
		String interfaceName = request.getParameter("interfaceName");
		if (EmptyUtils.isEmpty(module)) {
			throw new FrameworkException("module is required.");
		}
		if (EmptyUtils.isEmpty(interfaceName)) {
			throw new FrameworkException("interfaceName is required.");
		}
		ApplicationContext ctx = ContextManager.getModuleContext(module);
		InterfacePublisher ip = (InterfacePublisher) ctx.getBean(InterfacePublisher.class);
		if (ip != null) {
			try {
				response.setContentType("application/x-hessian");
				ApplicationContext root = ContextManager.getRootContext();
				ApplicationContext moduleCtx = ContextManager.getModuleContext(module);
				Class interfaceType = ClassUtils.forName(interfaceName, root.getClassLoader());
				Object service = moduleCtx.getBean(interfaceType);

				HessianExporter exporter = new HessianExporter();
				exporter.setServiceInterface(interfaceType);
				exporter.setService(service);
				exporter.prepare();
				OutputStream out = response.getOutputStream();
				exporter.invoke(request.getInputStream(), out);
				out.flush();
				response.flushBuffer();
			} catch (IOException e) {
				this.logger.error(e.getMessage(), e);
			} catch (Throwable e) {
				this.logger.error(e.getMessage(), e);
			}
		}
	}

	public ActionResult handle(ActionContext context) throws IOException {
		resolveRPCRequest(context.getRequest(), context.getResponse());
		return new ActionResult();
	}
}
