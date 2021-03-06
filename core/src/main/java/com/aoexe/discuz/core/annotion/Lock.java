package com.aoexe.discuz.core.annotion;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 分布式锁
 *
 * @author chenyuxian
 * @date 2021-09-10 23:24:38
 */
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface Lock {

	String type();
}
