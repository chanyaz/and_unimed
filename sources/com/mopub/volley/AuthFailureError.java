package com.mopub.volley;

import android.content.Intent;

public class AuthFailureError extends VolleyError {
    private Intent a;

    public AuthFailureError(Intent intent) {
        this.a = intent;
    }

    public AuthFailureError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public AuthFailureError(String str) {
        super(str);
    }

    public AuthFailureError(String str, Exception exception) {
        super(str, exception);
    }

    public String getMessage() {
        return this.a != null ? "User needs to (re)enter credentials." : super.getMessage();
    }

    public Intent getResolutionIntent() {
        return this.a;
    }
}
