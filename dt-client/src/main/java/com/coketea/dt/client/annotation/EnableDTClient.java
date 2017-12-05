package com.coketea.dt.client.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DTClientImportSelector.class})
public @interface EnableDTClient {

    DTClientType type() default DTClientType.BIO_SOCKET_CLIENT;
}