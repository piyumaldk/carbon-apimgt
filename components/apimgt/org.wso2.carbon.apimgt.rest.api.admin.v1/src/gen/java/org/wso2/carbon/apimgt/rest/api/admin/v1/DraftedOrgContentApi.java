package org.wso2.carbon.apimgt.rest.api.admin.v1;

import org.wso2.carbon.apimgt.rest.api.admin.v1.dto.ErrorDTO;
import java.io.File;
import org.wso2.carbon.apimgt.rest.api.admin.v1.DraftedOrgContentApiService;
import org.wso2.carbon.apimgt.rest.api.admin.v1.impl.DraftedOrgContentApiServiceImpl;
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
@Path("/drafted-org-content")

@Api(description = "the drafted-org-content API")




public class DraftedOrgContentApi  {

  @Context MessageContext securityContext;

DraftedOrgContentApiService delegate = new DraftedOrgContentApiServiceImpl();


    @DELETE
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Delete a drafted Org Theme", notes = "This operation deletes the currently drafted Organization Theme. ", response = Void.class, authorizations = {
        @Authorization(value = "OAuth2Security", scopes = {
            @AuthorizationScope(scope = "apim:admin", description = "Manage all admin operations"),
            @AuthorizationScope(scope = "apim:tenant_theme_manage", description = "Manage tenant themes")
        })
    }, tags={ "Organization Theme",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok. Drafted Theme Deleted Successfully. ", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden. The request must be conditional but no condition has been specified.", response = ErrorDTO.class),
        @ApiResponse(code = 404, message = "Not Found. The specified resource does not exist.", response = ErrorDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error.", response = ErrorDTO.class) })
    public Response deleteDraftedOrgContent() throws APIManagementException{
        return delegate.deleteDraftedOrgContent(securityContext);
    }

    @GET
    
    
    @Produces({ "application/zip", "application/json" })
    @ApiOperation(value = "Export a drafted zip of Org Theme", notes = "This operation can be used to export a drafted new DevPortal organization theme as a zip file. ", response = File.class, authorizations = {
        @Authorization(value = "OAuth2Security", scopes = {
            @AuthorizationScope(scope = "apim:admin", description = "Manage all admin operations"),
            @AuthorizationScope(scope = "apim:tenant_theme_manage", description = "Manage tenant themes")
        })
    }, tags={ "Organization Theme",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK. Theme exported Successfully. ", response = File.class),
        @ApiResponse(code = 403, message = "Forbidden. The request must be conditional but no condition has been specified.", response = ErrorDTO.class),
        @ApiResponse(code = 404, message = "Not Found. The specified resource does not exist.", response = ErrorDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error.", response = ErrorDTO.class) })
    public Response getDraftedOrgContent() throws APIManagementException{
        return delegate.getDraftedOrgContent(securityContext);
    }

    @PUT
    
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Import a drafted zip of Org Theme", notes = "This operation can be used to update a drafted zip of Organization Theme ", response = Void.class, authorizations = {
        @Authorization(value = "OAuth2Security", scopes = {
            @AuthorizationScope(scope = "apim:admin", description = "Manage all admin operations"),
            @AuthorizationScope(scope = "apim:tenant_theme_manage", description = "Manage tenant themes")
        })
    }, tags={ "Organization Theme" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok. Theme Imported Successfully. ", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden. The request must be conditional but no condition has been specified.", response = ErrorDTO.class),
        @ApiResponse(code = 413, message = "Payload Too Large. Request entity is larger than limits defined by server.", response = ErrorDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error.", response = ErrorDTO.class) })
    public Response updateDraftedOrgContent( @Multipart(value = "file") InputStream fileInputStream, @Multipart(value = "file" ) Attachment fileDetail) throws APIManagementException{
        return delegate.updateDraftedOrgContent(fileInputStream, fileDetail, securityContext);
    }
}
