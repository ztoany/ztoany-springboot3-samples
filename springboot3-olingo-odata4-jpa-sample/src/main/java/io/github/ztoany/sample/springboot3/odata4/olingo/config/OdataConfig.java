package io.github.ztoany.sample.springboot3.odata4.olingo.config;

import com.sap.olingo.jpa.processor.core.api.JPAODataRequestContext;
import com.sap.olingo.jpa.processor.core.api.JPAODataServiceContext;
import com.sap.olingo.jpa.processor.core.api.JPAODataSessionContextAccess;
import com.sap.olingo.jpa.processor.core.api.example.JPAExampleCUDRequestHandler;
import io.github.ztoany.sample.springboot3.odata4.olingo.odata.JPACustomEdmNameBuilder;
import jakarta.persistence.EntityManagerFactory;
import org.apache.olingo.commons.api.ex.ODataException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;

@Configuration
public class OdataConfig {
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public JPAODataSessionContextAccess sessionContext(EntityManagerFactory emf)
            throws ODataException {
        return JPAODataServiceContext.with()
                .setPUnit("default")
                .setEntityManagerFactory(emf)
                .setTypePackage("io.github.ztoany.sample.springboot3.odata4.olingo.dao.jpa.entity")
                .setRequestMappingPath("api/odata")
                .setEdmNameBuilder(new JPACustomEdmNameBuilder("default"))
                .build();
    }

    @Bean
    @Scope(scopeName = SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public JPAODataRequestContext requestContext() {
        return JPAODataRequestContext.with()
                .setCUDRequestHandler(new JPAExampleCUDRequestHandler())
                //.setDebugSupport(new DefaultDebugSupport())
                .build();
    }
}
