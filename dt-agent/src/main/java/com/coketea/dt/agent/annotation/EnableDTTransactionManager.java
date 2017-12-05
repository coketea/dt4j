package com.coketea.dt.agent.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DTTransactionManagerImportSelector.class})
public @interface EnableDTTransactionManager {

    DTTransactionManagerType type() default DTTransactionManagerType.DUBBO;
}
