package org.wso2.carbon.apimgt.rest.api.admin.v1;

import org.wso2.carbon.apimgt.rest.api.admin.v1.dto.ErrorDTO;
import org.wso2.carbon.apimgt.rest.api.admin.v1.SelfSignUpConfigApiService;
import org.wso2.carbon.apimgt.rest.api.admin.v1.impl.SelfSignUpConfigApiServiceImpl;
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
@Path("/self-sign-up-config")

@Api(description = "the self-sign-up-config API")




public class SelfSignUpConfigApi  {

  @Context MessageContext securityContext;

SelfSignUpConfigApiService delegate = new SelfSignUpConfigApiServiceImpl();


    @GET
    
    
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Export a self-sign-up-Config.", notes = "This operation can be used to export a self-sign-up-config.xml used in deployment. ", response = String.class, authorizations = {
        @Authorization(value = "OAuth2Security", scopes = {
            @AuthorizationScope(scope = "apim:admin", description = "Manage all admin operations")
        })
    }, tags={ "Self Sign Up Config",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK. Self Sign up config Exported Successfully. ", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden. The request must be conditional but no condition has been specified.", response = ErrorDTO.class),
        @ApiResponse(code = 404, message = "Not Found. The specified resource does not exist.", response = ErrorDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error.", response = ErrorDTO.class) })
    public Response exportSelfSignUpConfig() throws APIManagementException{
        return delegate.exportSelfSignUpConfig(securityContext);
    }

    @PUT
    
    @Consumes({ "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Update a self-sign-up-config.", notes = "This operation can be used to update self-sign-up-config. ", response = Object.class, authorizations = {
        @Authorization(value = "OAuth2Security", scopes = {
            @AuthorizationScope(scope = "apim:admin", description = "Manage all admin operations")
        })
    }, tags={ "Self Sign Up Config" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK. Self Sign up config Edited Successfully. ", response = Object.class),
        @ApiResponse(code = 403, message = "Forbidden. The request must be conditional but no condition has been specified.", response = ErrorDTO.class),
        @ApiResponse(code = 413, message = "Payload Too Large. Request entity is larger than limits defined by server.", response = ErrorDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error.", response = ErrorDTO.class) })
    public Response updateSelfSignUpConfig(@ApiParam(value = "self-sign-up-config" ,required=true) String body) throws APIManagementException{
        return delegate.updateSelfSignUpConfig(body, securityContext);
    }
}
