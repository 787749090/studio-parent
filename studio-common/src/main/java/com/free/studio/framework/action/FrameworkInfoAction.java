package com.free.studio.framework.action;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.free.studio.framework.core.Environment;
import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.web.dispatches.simple.ActionContext;
import com.free.studio.framework.core.web.dispatches.simple.ActionResult;
import com.free.studio.framework.core.web.dispatches.simple.RequestAction;

/**
 * @Title: FrameworkInfoAction.java
 * @Package com.free.studio.framework.root.action
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:39:17
 * @version V1.0
 */
@Controller("/framework")
public class FrameworkInfoAction implements RequestAction {
	public ActionResult handle(ActionContext context) throws IOException {
		context.getResponse().setCharacterEncoding("UTF-8");
		context.getResponse().setContentType("text/html;charset=UTF-8");
		Writer writer = context.getResponse().getWriter();
		String module = context.getParam("module");
		if ((module == null) || (module.length() < 1)) {
			ApplicationContext ctx = ContextManager.getRootContext();
			Environment environment = (Environment) ctx.getBean(Environment.class);
			drawFrameworkInfo(writer, environment);
			drawEnvironmentInfo(writer, environment);
			drawJavaInfo(writer);
		} else {
			ApplicationContext ctx = ContextManager.getModuleContext(module);
			Environment env = (Environment) ctx.getBean(Environment.class);
			drawEnvironmentInfo(writer, env);
		}
		return new ActionResult();
	}

	private void drawJavaInfo(Writer writer) throws IOException {
		writer.append("<fieldset>");
		writer.append("<legend>java system information</legend>");
		writer.append("<pre>");
		System.getProperties().store(writer, "System Properties");
		writer.append("</pre>");
		writer.append("</fieldset>");
	}

	private void drawEnvironmentInfo(Writer writer, Environment environment) throws IOException {
		writer.append("<fieldset>");
		writer.append("<legend>environment information</legend>");
		writer.append("ModuleName:").append(environment.getModuleName()).append("<br>");
		writer.append("Version:").append(environment.getVersion()).append("<br>");
		writer.append("ServletProvider:").append(environment.getServletProvider()).append("<br>");
		writer.append("RequestExtension:").append(environment.getRequestExtension()).append("<br>");
		writer.append("HomePage:").append(environment.getHomePage()).append("<br>");
		writer.append("LoginPage").append(environment.getLoginPage()).append("<br>");
		writer.append("</fieldset>");
	}

	private void drawFrameworkInfo(Writer writer, Environment environment) throws IOException {
		writer.append("<fieldset>");
		writer.append("<legend>framework information</legend>");
		writer.append("version:" + environment.getVersion());
		writer.append("<br/>");
		writer.append("modules:");
		Set<String> names = ContextManager.getModuleNames();
		for (String name : names) {
			writer.append("<a href='./framework.shtml?module=" + name + "'>");
			writer.append(name);
			writer.append("</a>&nbsp;&nbsp;&nbsp;");
		}
		writer.append("</fieldset>");
	}
}
