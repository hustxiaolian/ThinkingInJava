package com.xiaolianhust.thinkinginjava.chapter20;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)//�ѹֿ�����ôд��ԭ����ʹ���˾�̬����
@Target(METHOD)
public @interface TestProperty {
	
}
