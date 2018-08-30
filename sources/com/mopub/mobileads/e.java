package com.mopub.mobileads;

enum e {
    WEB_VIEW_DID_APPEAR("webviewDidAppear();"),
    WEB_VIEW_DID_CLOSE("webviewDidClose();");
    
    private String a;

    private e(String str) {
        this.a = str;
    }

    protected String a() {
        return this.a;
    }

    protected String b() {
        return "javascript:" + this.a;
    }
}
