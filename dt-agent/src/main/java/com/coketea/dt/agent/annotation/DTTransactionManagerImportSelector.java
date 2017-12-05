package com.coketea.dt.agent.annotation;

import com.coketea.dt.Constants;
import com.coketea.dt.agent.aop.service.impl.*;
import com.coketea.dt.agent.interceptor.dubbo.DTTransactionManagerInterceptor;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class DTTransactionManagerImportSelector implements ImportSelector {

    public static final String DEFAULT_DT_TRANSACTION_MANAGER_TYPE_ATTRIBUTE_NAME = "type";

    private String[] selectImports(DTTransactionManagerType transactionManagerType) {
        switch (transactionManagerType) {
            case DUBBO:
                return new String[]{
                        AspectBeforeServiceImpl.class.getName(),
                        DefaultTransactionServerImpl.class.getName(),
                        StartTransactionServerImpl.class.getName(),
                        WithTransactionServerImpl.class.getName(),
                        WithoutTransactionServerImpl.class.getName(),
                        TransactionServerFactoryServiceImpl.class.getName(),
                        DTTransactionManagerInterceptor.class.getName()
                };
            default:
                return null;
        }
    }

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Class<?> annotationType = EnableDTTransactionManager.class;
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(
                annotationMetadata.getAnnotationAttributes(
                        annotationType.getName(), false));
        if (attributes == null) {
            throw new IllegalArgumentException(
                    String.format("@%s is not present on importing class '%s' as expected",
                            annotationType.getSimpleName(), annotationMetadata.getClassName()));
        } else {
            DTTransactionManagerType transactionManagerType = (DTTransactionManagerType) attributes.getEnum(
                    DEFAULT_DT_TRANSACTION_MANAGER_TYPE_ATTRIBUTE_NAME);
            String[] imports = this.selectImports(transactionManagerType);
            if (imports == null) {
                throw new IllegalArgumentException(String.format("Unknown DTTransactionManagerType: '%s'", transactionManagerType));
            } else {
                return imports;
            }
        }
    }
}
