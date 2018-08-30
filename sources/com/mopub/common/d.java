package com.mopub.common;

final class d implements Runnable {
    final /* synthetic */ CloseableLayout a;

    private d(CloseableLayout closeableLayout) {
        this.a = closeableLayout;
    }

    public void run() {
        this.a.setClosePressed(false);
    }
}
