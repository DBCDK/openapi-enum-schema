package dk.dbc.openapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("res")
public class Resource {

    @Path("now")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "test-operation", summary = "Test if OpenApi is working")
    @APIResponses({
        @APIResponse(name = "Success",
                     responseCode = "200",
                     description = "Success",
                     content = @Content(
                             mediaType = MediaType.APPLICATION_JSON,
                             schema = @Schema(ref = ErrorResp.NAME))),
        @APIResponse(name = "Bad Request",
                     responseCode = "400",
                     description = "If a request is somehow invalid",
                     content = @Content(
                             mediaType = MediaType.APPLICATION_JSON,
                             schema = @Schema(ref = ErrorCode.NAME)
                     ))
    })
    public Response now() {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResp("Bad request", ErrorCode.BAD))
                .build();
    }
}
