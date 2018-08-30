package com.puzzlersworld.android.exception;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class a {
    private UiErrorHandler a;

    public a(UiErrorHandler uiErrorHandler) {
        this.a = uiErrorHandler;
    }

    public void a(Exception exception) {
        if ((exception instanceof SocketTimeoutException) || (exception instanceof ServerConnectionTimeoutException)) {
            this.a.onConnectionTimeout();
        } else if ((exception instanceof IOException) || (exception instanceof NoConnectionException)) {
            this.a.onNoNetwork();
        } else {
            this.a.onError(exception);
        }
    }
}
