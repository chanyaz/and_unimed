package com.google.common.collect;

import com.google.common.collect.Table.Cell;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

class as extends AbstractSet<Cell<R, C, V>> {
    final /* synthetic */ ar a;

    as(ar arVar) {
        this.a = arVar;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) obj;
        Map map = (Map) Maps.a(this.a.rowMap(), cell.getRowKey());
        return map != null && bb.a(map.entrySet(), Maps.a(cell.getColumnKey(), cell.getValue()));
    }

    public Iterator<Cell<R, C, V>> iterator() {
        return this.a.b();
    }

    public boolean remove(@Nullable Object obj) {
        if (!(obj instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) obj;
        Map map = (Map) Maps.a(this.a.rowMap(), cell.getRowKey());
        return map != null && bb.b(map.entrySet(), Maps.a(cell.getColumnKey(), cell.getValue()));
    }

    public int size() {
        return this.a.size();
    }
}
