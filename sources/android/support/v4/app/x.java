package android.support.v4.app;

class x implements OnStartEnterTransitionListener {
    private final boolean a;
    private final d b;
    private int c;

    x(d dVar, boolean z) {
        this.a = z;
        this.b = dVar;
    }

    public boolean a() {
        return this.c == 0;
    }

    public void b() {
        boolean z = false;
        boolean z2 = this.c > 0;
        FragmentManagerImpl fragmentManagerImpl = this.b.a;
        int size = fragmentManagerImpl.e.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) fragmentManagerImpl.e.get(i);
            fragment.a(null);
            if (z2 && fragment.aa()) {
                fragment.G();
            }
        }
        FragmentManagerImpl fragmentManagerImpl2 = this.b.a;
        d dVar = this.b;
        boolean z3 = this.a;
        if (!z2) {
            z = true;
        }
        fragmentManagerImpl2.a(dVar, z3, z, true);
    }

    public void c() {
        this.b.a.a(this.b, this.a, false, false);
    }

    public void onStartEnterTransition() {
        this.c--;
        if (this.c == 0) {
            this.b.a.C();
        }
    }

    public void startListening() {
        this.c++;
    }
}
