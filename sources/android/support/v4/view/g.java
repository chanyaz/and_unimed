package android.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;

class g {
    g() {
    }

    public void a(LayoutInflater layoutInflater, Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            e.a(layoutInflater, (Factory2) factory);
        } else {
            e.a(layoutInflater, factory2);
        }
    }
}
