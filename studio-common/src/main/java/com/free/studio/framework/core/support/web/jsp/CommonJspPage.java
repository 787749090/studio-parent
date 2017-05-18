package com.free.studio.framework.core.support.web.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @Title: CommonJspPage.java
 * @Package com.free.studio.framework.core.support.web.jsp
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:58:49
 * @version V1.0
 */
public abstract class CommonJspPage extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(CommonJspPage.class);

	protected final void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			logger.debug("CommonJSPPage.service starts");

			response.setContentType("text/html;charset=utf-8");
			response.setHeader("Pragma", "no-cache");

			response.setDateHeader("Expires", 0L);

			_jspService(request, response);

			logger.debug("CommonJSPPage.service ends");
		} catch (Exception ex) {
			logger.error("CommonJSPPage.service has exception", ex);
			throw new ServletException(ex);
		}
	}

	public abstract void _jspService(HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse) throws ServletException, IOException;

	public String formatTextBox(String str) {
		str = StringUtils.replace(str, "&", "&amp;");
		str = StringUtils.replace(str, "\"", "&quot;");

		return str;
	}

	public String formatTableContent(String str) {
		str = StringUtils.replace(str, "&", "&amp;");
		str = StringUtils.replace(str, "<", "&lt;");
		str = StringUtils.replace(str, ">", "&gt;");
		str = StringUtils.replace(str, "\"", "&quot;");

		return str;
	}

	public String changeNewlineToBr(String str) {
		str = StringUtils.replace(str, System.getProperty("line.separator"), "<BR>");

		return str;
	}
}
