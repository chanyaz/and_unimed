package com.google.firebase.components;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class g {
    private final Context a;
    private final zzf b;

    public g(Context context) {
        this(context, new i());
    }

    @VisibleForTesting
    private g(Context context, zzf zzf) {
        this.a = context;
        this.b = zzf;
    }

    private static List<ComponentRegistrar> a(List<String> list) {
        List<ComponentRegistrar> arrayList = new ArrayList();
        for (String cls : list) {
            try {
                Class cls2 = Class.forName(cls);
                if (ComponentRegistrar.class.isAssignableFrom(cls2)) {
                    arrayList.add((ComponentRegistrar) cls2.newInstance());
                } else {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", new Object[]{cls, "com.google.firebase.components.ComponentRegistrar"}));
                }
            } catch (Throwable e) {
                Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[]{cls}), e);
            } catch (Throwable e2) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{cls}), e2);
            } catch (Throwable e22) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{cls}), e22);
            }
        }
        return arrayList;
    }

    public final List<ComponentRegistrar> a() {
        return a(this.b.zzc(this.a));
    }
}
