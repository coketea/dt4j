package com.coketea.dt.client.annotation;

import com.coketea.dt.Constants;
import com.coketea.dt.client.bio.BIOSocketClient;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class DTClientImportSelector implements ImportSelector {

    public static final String DEFAULT_DT_CLIENT_TYPE_ATTRIBUTE_NAME = "type";

    private String[] selectImports(DTClientType clientType) {
        switch (clientType) {
            case BIO_SOCKET_CLIENT:
                return new String[]{
                        BIOSocketClient.class.getName()
                };
            default:
                return null;
        }
    }

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Class<?> annotationType = EnableDTClient.class;
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(
                annotationMetadata.getAnnotationAttributes(
                        annotationType.getName(), false));
        if (attributes == null) {
            throw new IllegalArgumentException(
                    String.format("@%s is not present on importing class '%s' as expected",
                            annotationType.getSimpleName(), annotationMetadata.getClassName()));
        } else {
            DTClientType clientType = (DTClientType) attributes.getEnum(
                    DEFAULT_DT_CLIENT_TYPE_ATTRIBUTE_NAME);
            String[] imports = this.selectImports(clientType);
            if (imports == null) {
                throw new IllegalArgumentException(String.format("Unknown DTClientType: '%s'", clientType));
            } else {
                return imports;
            }
        }
    }
}
