package com.fh.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//该注解用于什么地方
@Retention(RetentionPolicy.RUNTIME)//什么时候使用该注解
public @interface customAnnottation {


}
