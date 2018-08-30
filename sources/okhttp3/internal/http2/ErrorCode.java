package okhttp3.internal.http2;

public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    
    public final int g;

    private ErrorCode(int i) {
        this.g = i;
    }

    public static ErrorCode a(int i) {
        for (ErrorCode errorCode : values()) {
            if (errorCode.g == i) {
                return errorCode;
            }
        }
        return null;
    }
}
