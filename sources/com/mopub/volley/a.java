package com.mopub.volley;

class a implements Runnable {
    final /* synthetic */ ExecutorDelivery a;
    private final Request b;
    private final Response c;
    private final Runnable d;

    public a(ExecutorDelivery executorDelivery, Request request, Response response, Runnable runnable) {
        this.a = executorDelivery;
        this.b = request;
        this.c = response;
        this.d = runnable;
    }

    public void run() {
        if (this.b.isCanceled()) {
            this.b.b("canceled-at-delivery");
            return;
        }
        if (this.c.isSuccess()) {
            this.b.deliverResponse(this.c.result);
        } else {
            this.b.deliverError(this.c.error);
        }
        if (this.c.intermediate) {
            this.b.addMarker("intermediate-response");
        } else {
            this.b.b("done");
        }
        if (this.d != null) {
            this.d.run();
        }
    }
}
