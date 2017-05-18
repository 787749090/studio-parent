package com.free.studio.framework.core.components.buitin.template;

import java.io.Writer;
import java.util.Map;

import com.free.studio.framework.core.components.ComponentService;

/**
 * @Title: TemplateService.java
 * @Package com.free.studio.framework.core.components.buitin.template
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:11:41
 * @version V1.0
 */
public interface TemplateService extends ComponentService {
	public abstract String compile(String paramString, Map<String, Object> paramMap);

	public abstract void compile(Writer paramWriter, String paramString, Map<String, Object> paramMap);
}
