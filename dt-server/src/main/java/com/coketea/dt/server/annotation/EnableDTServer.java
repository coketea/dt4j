package com.coketea.dt.server.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DTServerImportSelector.class})
public @interface EnableDTServer {

    DTServerType type() default DTServerType.BIO_SOCKET_SERVER;
}
