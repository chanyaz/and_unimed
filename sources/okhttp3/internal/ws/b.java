package okhttp3.internal.ws;

final class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void run() {
        this.a.cancel();
    }
}
