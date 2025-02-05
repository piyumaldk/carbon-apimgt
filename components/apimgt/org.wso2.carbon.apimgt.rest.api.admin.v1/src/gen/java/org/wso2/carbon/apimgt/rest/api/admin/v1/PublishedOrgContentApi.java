package org.wso2.carbon.apimgt.rest.api.admin.v1;

import org.wso2.carbon.apimgt.rest.api.admin.v1.dto.ErrorDTO;
import java.io.File;
import org.wso2.carbon.apimgt.rest.api.admin.v1.PublishedOrgContentApiService;
import org.wso2.carbon.apimgt.rest.api.admin.v1.impl.PublishedOrgContentApiServiceImpl;
import org.wso2.carbon.apimgt.api.APIManagementException;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.inject.Inject;

import io.swagger.annotations.*;
import java.io.InputStream;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
@Path("/published-org-content")

@Api(description = "the published-org-content API")




public class PublishedOrgContentApi  {

  @Context MessageContext securityContext;

PublishedOrgContentApiService delegate = new PublishedOrgContentApiServiceImpl();


    @POST
    
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Publish an Org Theme", notes = "This operation can be used to publish a new DevPortal organization theme by uploading a zip file. ", response = Void.class, authorizations = {
        @Authorization(value = "OAuth2Security", scopes = {
            @AuthorizationScope(scope = "apim:admin", description = "Manage all admin operations"),
            @AuthorizationScope(scope = "apim:tenant_theme_manage", description = "Manage tenant themes")
        })
    }, tags={ "Organization Theme",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok. Theme Published Successfully. ", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden. The request must be conditional but no condition has been specified.", response = ErrorDTO.class),
        @ApiResponse(code = 413, message = "Payload Too Large. Request entity is larger than limits defined by server.", response = ErrorDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error.", response = ErrorDTO.class) })
    public Response publishOrgContent( @Multipart(value = "file") InputStream fileInputStream, @Multipart(value = "file" ) Attachment fileDetail) throws APIManagementException{
        return delegate.publishOrgContent(fileInputStream, fileDetail, securityContext);
    }

    @DELETE
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Un-publish an Org Theme", notes = "This operation removes the currently published organization theme from the DevPortal. ", response = Void.class, authorizations = {
        @Authorization(value = "OAuth2Security", scopes = {
            @AuthorizationScope(scope = "apim:admin", description = "Manage all admin operations"),
            @AuthorizationScope(scope = "apim:tenant_theme_manage", description = "Manage tenant themes")
        })
    }, tags={ "Organization Theme" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok. Published Theme Unpublished Successfully. ", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden. The request must be conditional but no condition has been specified.", response = ErrorDTO.class),
        @ApiResponse(code = 404, message = "Not Found. The specified resource does not exist.", response = ErrorDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error.", response = ErrorDTO.class) })
    public Response unPublishOrgContent() throws APIManagementException{
        return delegate.unPublishOrgContent(securityContext);
    }
}
