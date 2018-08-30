package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class c {
    final int a;
    final Method b;

    c(int i, Method method) {
        this.a = i;
        this.b = method;
        this.b.setAccessible(true);
    }

    void a(LifecycleOwner lifecycleOwner, Event event, Object obj) {
        try {
            switch (this.a) {
                case 0:
                    this.b.invoke(obj, new Object[0]);
                    return;
                case 1:
                    this.b.invoke(obj, new Object[]{lifecycleOwner});
                    return;
                case 2:
                    this.b.invoke(obj, new Object[]{lifecycleOwner, event});
                    return;
                default:
                    return;
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Failed to call observer method", e.getCause());
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.b.getName().equals(cVar.b.getName());
    }

    public int hashCode() {
        return (this.a * 31) + this.b.getName().hashCode();
    }
}
