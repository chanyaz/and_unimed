package com.puzzlersworld.android.exception;

public interface UiErrorHandler {
    void onConnectionTimeout();

    void onError(Exception exception);

    void onNoNetwork();
}
