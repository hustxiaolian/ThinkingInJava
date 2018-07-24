package com.xiaolianhust.thinkinginjava.chapter20;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)//难怪可以这么写，原来是使用了静态导入
@Target(METHOD)
public @interface TestProperty {
	
}
