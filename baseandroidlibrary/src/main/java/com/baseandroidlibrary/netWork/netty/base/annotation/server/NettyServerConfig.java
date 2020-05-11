package com.baseandroidlibrary.netWork.netty.base.annotation.server;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NettyServerConfig {

    int port() default 8020;

    String bindIp() default "0.0.0.0";

    String name() default "";

}
