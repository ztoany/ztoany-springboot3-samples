package io.github.ztoany.sample.springboot3.odata4.olingo.api.http;

import com.sap.olingo.jpa.processor.core.api.JPAODataRequestContext;
import com.sap.olingo.jpa.processor.core.api.JPAODataRequestHandler;
import com.sap.olingo.jpa.processor.core.api.JPAODataSessionContextAccess;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.olingo.commons.api.ex.ODataException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OdataResource {
    private final JPAODataSessionContextAccess serviceContext;
    private final JPAODataRequestContext requestContext;

    public OdataResource(JPAODataSessionContextAccess serviceContext, JPAODataRequestContext requestContext) {
        this.serviceContext = serviceContext;
        this.requestContext = requestContext;
    }

    @RequestMapping(value = "/api/odata/**", method = { RequestMethod.GET, RequestMethod.PATCH,
            RequestMethod.POST, RequestMethod.DELETE })
    public void crud(final HttpServletRequest req, final HttpServletResponse resp) throws ODataException {
        new JPAODataRequestHandler(serviceContext, requestContext).process(req, resp);
    }
}
