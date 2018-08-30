package com.google.common.util.concurrent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray a;

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        this.a = new AtomicLongArray(readInt);
        for (int i = 0; i < readInt; i++) {
            a(i, objectInputStream.readDouble());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        int a = a();
        objectOutputStream.writeInt(a);
        for (int i = 0; i < a; i++) {
            objectOutputStream.writeDouble(a(i));
        }
    }

    public final double a(int i) {
        return Double.longBitsToDouble(this.a.get(i));
    }

    public final int a() {
        return this.a.length();
    }

    public final void a(int i, double d) {
        this.a.set(i, Double.doubleToRawLongBits(d));
    }

    public String toString() {
        int a = a() - 1;
        if (a == -1) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder((a + 1) * 19);
        stringBuilder.append('[');
        int i = 0;
        while (true) {
            stringBuilder.append(Double.longBitsToDouble(this.a.get(i)));
            if (i == a) {
                return stringBuilder.append(']').toString();
            }
            stringBuilder.append(',').append(' ');
            i++;
        }
    }
}
