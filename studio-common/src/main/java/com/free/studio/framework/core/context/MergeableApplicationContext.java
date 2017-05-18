package com.free.studio.framework.core.context;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.Resource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.free.studio.framework.core.context.resource.FrameworkResourceManager;
import com.free.studio.framework.core.context.resource.XmlBuilder;
import com.free.studio.framework.core.web.servlet.ServletHandler;

/**
 * @Title: MergeableApplicationContext.java
 * @Package com.free.studio.framework.core.context
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:17:29
 * @version V1.0
 */
public class MergeableApplicationContext extends XmlWebApplicationContext {
	private String moduleName = null;
	private String version = null;

	public MergeableApplicationContext(String moduleName, String version, WebApplicationContext rootContext,
			URL location) {
		this.moduleName = moduleName;
		this.version = version;
		setId(moduleName);
		setParent(rootContext);
		setDisplayName(moduleName + " Container");
		setServletContext(rootContext.getServletContext());
		addBeanFactoryPostProcessor(new EnvironmentPostProcessor(moduleName, version));
		addApplicationListener(new ApplicationListener() {
			public void onApplicationEvent(ContextClosedEvent event) {
				Map<String, ServletHandler> handlers = event.getApplicationContext()
						.getBeansOfType(ServletHandler.class);
				for (Iterator iter = handlers.values().iterator(); iter.hasNext();) {
					ServletHandler handler = (ServletHandler) iter.next();
					handler.destory();
					MergeableApplicationContext.this.logger.debug("destory ServletHandler:" + handler.getClass());
				}
			}

			@Override
			public void onApplicationEvent(ApplicationEvent event) {

			}
		});
		setConfigLocations(new String[] { buildBuildin(moduleName, version), location.toString() });
	}

	private String buildBuildin(String moduleName, String version) {
		StringBuilder props = new StringBuilder();
		props.append("module-name=").append(moduleName).append("\r\n");
		props.append("module-version=").append(version).append("\r\n");
		props.append("module-package=").append("com.sinoservices." + moduleName).append("\r\n");
		String propsKey = FrameworkResourceManager.INSTANCE.registerResource(props.toString());
		XmlBuilder builder = new XmlBuilder();

		builder.addBean("<bean name=\"Environment\" class=\"com.sinoservices.xframework.core.Environment\">");
		builder.addBean("<constructor-arg index=\"0\" value=\"" + moduleName + "\"></constructor-arg>");
		builder.addBean("<constructor-arg index=\"1\" value=\"" + version + "\"></constructor-arg>");
		builder.addBean("</bean>");

		builder.addBean("<bean class=\"org.springframework.context.support.PropertySourcesPlaceholderConfigurer\"> ");
		builder.addBean("\t<property name=\"locations\"> <array>");
		builder.addBean("\t\t<value>classpath*:framework-default.properties</value>   ");
		builder.addBean("\t\t<value>" + propsKey + "</value>   ");
		builder.addBean("\t\t<value>classpath*:" + moduleName + "/module.properties</value>   ");
		builder.addBean("\t\t<value>classpath*:integration-dev.properties</value>   ");
		builder.addBean("\t\t<value>classpath*:integration.properties</value>   ");
		builder.addBean("\t</array></property> ");
		builder.addBean("</bean> ");
		return FrameworkResourceManager.INSTANCE.registerResource(builder.toXml());
	}

	public Resource getResource(String location) {
		if (this.logger.isInfoEnabled()) {
			this.logger.info("location:" + location);
		}
		if (FrameworkResourceManager.isFrameworkResource(location)) {
			return FrameworkResourceManager.INSTANCE.get(location);
		}
		return super.getResource(location);
	}

	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
		super.customizeBeanFactory(beanFactory);
	}

	protected ConfigurableEnvironment createEnvironment() {
		return new SpringEnvironment() {
			protected void customizePropertySources(MutablePropertySources propertySources) {
				Map<String, Object> envMap = new HashMap();
				envMap.put("module-name", MergeableApplicationContext.this.moduleName);
				envMap.put("module-version", MergeableApplicationContext.this.version);
				propertySources.addLast(new MapPropertySource("framework-env-propertysource", envMap));
				super.customizePropertySources(propertySources);
			}
		};
	}

	protected DefaultListableBeanFactory createBeanFactory() {
		DefaultListableBeanFactory factory = new InheritableListableBeanFactory(getInternalParentBeanFactory());
		return factory;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public String getModuleVersion() {
		return this.version;
	}
}
