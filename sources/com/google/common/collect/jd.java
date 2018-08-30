package com.google.common.collect;

import com.google.common.base.o;
import com.google.common.collect.Table.Cell;

abstract class jd<R, C, V> implements Cell<R, C, V> {
    jd() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) obj;
        return o.a(getRowKey(), cell.getRowKey()) && o.a(getColumnKey(), cell.getColumnKey()) && o.a(getValue(), cell.getValue());
    }

    public int hashCode() {
        return o.a(getRowKey(), getColumnKey(), getValue());
    }

    public String toString() {
        return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
    }
}
