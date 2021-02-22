package dk.dbc.openapi;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = ErrorResp.NAME)
public class ErrorResp {

    @Schema
    public String message;

    @Schema(ref = ErrorCode.NAME)
    public ErrorCode errorCode;

    public ErrorResp() {
    }

    public ErrorResp(String message, ErrorCode errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public static final String NAME = "resp";
}
