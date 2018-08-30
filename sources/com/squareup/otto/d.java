package com.squareup.otto;

import java.lang.reflect.Method;

class d {
    final Object a;
    private final Method b;
    private final int c;
    private boolean d = true;

    d(Object obj, Method method) {
        if (obj == null) {
            throw new NullPointerException("EventProducer target cannot be null.");
        } else if (method == null) {
            throw new NullPointerException("EventProducer method cannot be null.");
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
        d dVar = (d) obj;
        return this.b.equals(dVar.b) && this.a == dVar.a;
    }

    public int hashCode() {
        return this.c;
    }

    public String toString() {
        return "[EventProducer " + this.b + "]";
    }
}
