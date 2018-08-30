package com.puzzlersworld.android.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import java.util.List;

public class f {
    public static void a(FragmentManager fragmentManager) {
        while (fragmentManager.e() > 0) {
            fragmentManager.d();
        }
    }

    public static Fragment b(FragmentManager fragmentManager) {
        if (fragmentManager.e() > 0) {
            if (fragmentManager.f().size() > fragmentManager.e() - 1) {
                return (Fragment) fragmentManager.f().get(fragmentManager.e() - 1);
            }
            if (fragmentManager.f().size() > 0) {
                return (Fragment) fragmentManager.f().get(fragmentManager.f().size() - 1);
            }
        }
        return null;
    }

    public static Fragment c(FragmentManager fragmentManager) {
        List f = fragmentManager.f();
        if (f != null) {
            for (int size = f.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) f.get(size);
                if (fragment != null) {
                    return fragment;
                }
            }
        }
        return null;
    }
}
