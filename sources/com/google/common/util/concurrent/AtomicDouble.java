package com.google.common.util.concurrent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class AtomicDouble extends Number implements Serializable {
    private static final AtomicLongFieldUpdater<AtomicDouble> b = AtomicLongFieldUpdater.newUpdater(AtomicDouble.class, "a");
    private static final long serialVersionUID = 0;
    private volatile transient long a;

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        a(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(a());
    }

    public final double a() {
        return Double.longBitsToDouble(this.a);
    }

    public final void a(double d) {
        this.a = Double.doubleToRawLongBits(d);
    }

    public double doubleValue() {
        return a();
    }

    public float floatValue() {
        return (float) a();
    }

    public int intValue() {
        return (int) a();
    }

    public long longValue() {
        return (long) a();
    }

    public String toString() {
        return Double.toString(a());
    }
}
