package com.squareup.otto;

import java.lang.reflect.Method;

class c {
    private final Object a;
    private final Method b;
    private final int c;
    private boolean d = true;

    c(Object obj, Method method) {
        if (obj == null) {
            throw new NullPointerException("EventHandler target cannot be null.");
        } else if (method == null) {
            throw new NullPointerException("EventHandler method cannot be null.");
        } else {
            this.a = obj;
            this.b = method;
            method.setAccessible(true);
            this.c = ((method.hashCode() + 31) * 31) + obj.hashCode();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.b.equals(cVar.b) && this.a == cVar.a;
    }

    public int hashCode() {
        return this.c;
    }

    public String toString() {
        return "[EventHandler " + this.b + "]";
    }
}
