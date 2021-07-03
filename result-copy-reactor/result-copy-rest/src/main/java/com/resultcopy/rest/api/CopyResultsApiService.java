package com.resultcopy.rest.api;

import com.resultcopy.rest.model.BabyResult;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * This is an abstract class where the methods of class CopyResultApi is defined.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-21T13:02:06.679Z[GMT]")
public abstract class CopyResultsApiService {

    /**
     * This is an abstract method declared for CopyResultApi Class.
     * @param body {@link BabyResult} This is the baby result body that is sent for post request.
     * @param securityContext {@link SecurityContext} This the security context set.
     * @throws NotFoundException throws NotFoundException when the BabyResult class is not found.
     * @return The method returns the response generated from the copy result method.
     */
    public abstract Response copyResultsPost(BabyResult body, SecurityContext securityContext) throws NotFoundException;
}
