package com.free.studio.framework.core.enhanced.spring;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: ParamPrefix.java
 * @Package com.free.studio.framework.core.enhanced.spring
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:25:13
 * @version V1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.PARAMETER })
@Documented
public @interface ParamPrefix {
	String value() default "";
}
