package dk.dbc.openapi;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = ErrorCode.NAME)
public enum ErrorCode {
    NOT_GOOD,
    BAD,
    REALLY_BAD;
    
    public static final String NAME = "errorcode";
}
