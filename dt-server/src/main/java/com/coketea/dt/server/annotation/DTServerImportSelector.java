package com.coketea.dt.server.annotation;

import com.coketea.dt.Constants;
import com.coketea.dt.server.bio.BIOSocketServer;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class DTServerImportSelector implements ImportSelector {

    public static final String DEFAULT_DT_SERVER_TYPE_ATTRIBUTE_NAME = "type";

    private String[] selectImports(DTServerType serverType) {
        switch(serverType) {
            case BIO_SOCKET_SERVER:
                return new String[]{
                        BIOSocketServer.class.getName()
                };
            default:
                return null;
        }
    }

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Class<?> annotationType = EnableDTServer.class;
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(
                annotationMetadata.getAnnotationAttributes(
                        annotationType.getName(), false));
        if (attributes == null) {
            throw new IllegalArgumentException(
                    String.format("@%s is not present on importing class '%s' as expected",
                            annotationType.getSimpleName(), annotationMetadata.getClassName()));
        } else {
            DTServerType serverType = (DTServerType)attributes.getEnum(
                    DEFAULT_DT_SERVER_TYPE_ATTRIBUTE_NAME);
            String[] imports = this.selectImports(serverType);
            if (imports == null) {
                throw new IllegalArgumentException(String.format("Unknown DTServerType: '%s'", serverType));
            } else {
                return imports;
            }
        }
    }
}
