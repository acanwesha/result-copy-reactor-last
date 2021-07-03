package com.resultcopy.rest.api.impl;

import com.resultcopy.BabyRequest;
import com.resultcopy.CategoryRequest;
import com.resultcopy.ResultRequest;
import com.resultcopy.rest.model.BabyResult;
import com.resultcopy.rest.model.CategoryPost;
import com.resultcopy.rest.model.CategoryPostResult;
import com.resultcopy.service.dao.BabyResultDAO;
import com.resultcopy.service.impl.BabyResultDAOImpl;
import com.resultcopy.rest.api.*;
import com.resultcopy.rest.api.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

/**
 * It is an API service class to copy the result details to baby.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-21T13:02:06.679Z[GMT]")
public class CopyResultsApiServiceImpl extends CopyResultsApiService {

    /**
     * This method copies the result details to baby.
     * @param body Baby Result class body.
     * @param securityContext {@link SecurityContext} this is the security context parameter which is swagger generated.
     * @return {@link Response} This is the response returned on the server.
     * @throws NotFoundException if the response is not found then it returns a NotFoundException.
     */
    @Override
    public Response copyResultsPost(BabyResult body, SecurityContext securityContext) throws NotFoundException {
        BabyResultDAO babyResultDAO=new BabyResultDAOImpl();
        boolean isCopied = false;
        BabyRequest babyRequest = new BabyRequest();
        babyRequest.setChildId(body.getChildId());

        List<CategoryRequest> categoryRequestsList = new ArrayList<>();
        List<ResultRequest> resultList = new ArrayList<>();
        for( CategoryPost categoryPost : body.getCategory()) {

            List<CategoryPostResult> result = categoryPost.getResult();

            for (CategoryPostResult categoryPostResult : result) {
                CategoryRequest categoryRequest = new CategoryRequest();
                categoryRequest.setDisplayName(categoryPost.getDisplayName());

                ResultRequest resultRequest = new ResultRequest();
                resultRequest.setDisplayName(categoryPostResult.getDisplayName());
                resultRequest.setValue(categoryPostResult.getValue());

                resultList.add(resultRequest);
                categoryRequest.setResult(resultList);

                categoryRequestsList.add(categoryRequest);
                babyRequest.setCategory(categoryRequestsList);
                isCopied = babyResultDAO.createBabyResult(babyRequest);

            }
        }
            return Response.ok().entity(isCopied).build();

    }
}
