package com.free.studio.controller.login.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title: IndexController.java
 * @Package com.free.studio.controller.login.common
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午3:07:13
 * @version V1.0
 */
@Controller
public class IndexController {

	/**
	 * 
	 * @Title: index 
	 * @Description: 访问首页 
	 * @param 
	 * @return String 
	 * @throws
	 */

	@RequestMapping("/")
	public String index() {
		return "login/common/index";
	}

	/**
	 * 
	 * @Title: welcome 
	 * @Description: 显示欢迎页
	 * @param   
	 * @return String  
	 * @throws
	 */
	@RequestMapping("/login/common/welcome.html")
	public String welcome(){
		return "/login/common/welcome";
	}
	
	/**
	 * 
	 * @Title: getMenu 
	 * @Description: 获取菜单
	 * @param   
	 * @return ModelAndView  
	 * @throws
	 */
	@RequestMapping("/login/common/menu.html")
	public ModelAndView getMenu() {
		return new ModelAndView("login/common/menu.jsp");
	}
}
