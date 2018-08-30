package android.support.v7.widget;

class aq implements Runnable {
    final /* synthetic */ ao a;

    private aq(ao aoVar) {
        this.a = aoVar;
    }

    public void a() {
        this.a.n = null;
        this.a.removeCallbacks(this);
    }

    public void b() {
        this.a.post(this);
    }

    public void run() {
        this.a.n = null;
        this.a.drawableStateChanged();
    }
}
