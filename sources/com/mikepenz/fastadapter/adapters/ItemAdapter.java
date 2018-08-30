package com.mikepenz.fastadapter.adapters;

import android.widget.Filter;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IIdentifyable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.IItemAdapter.Predicate;
import com.mikepenz.fastadapter.a;
import com.mikepenz.fastadapter.utils.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ItemAdapter<Item extends IItem> extends a<Item> implements IItemAdapter<Item> {
    protected ItemFilterListener a;
    protected Comparator<Item> b;
    private List<Item> c = new ArrayList();
    private boolean d = true;
    private Filter e = new d(this);
    private Predicate<Item> f;

    public interface ItemFilterListener {
        void itemsFiltered();
    }

    /* renamed from: a */
    public ItemAdapter<Item> clear() {
        int size = this.c.size();
        this.c.clear();
        getFastAdapter().b(getFastAdapter().e(getOrder()), size);
        return this;
    }

    /* renamed from: a */
    public ItemAdapter<Item> remove(int i) {
        this.c.remove(i - getFastAdapter().f(i));
        getFastAdapter().l(i);
        return this;
    }

    /* renamed from: a */
    public ItemAdapter<Item> removeRange(int i, int i2) {
        int size = this.c.size();
        int f = getFastAdapter().f(i);
        int min = Math.min(i2, (size - i) + f);
        for (size = 0; size < min; size++) {
            this.c.remove(i - f);
        }
        getFastAdapter().b(i, min);
        return this;
    }

    /* renamed from: a */
    public ItemAdapter<Item> set(int i, Item item) {
        if (this.d) {
            b.a((IIdentifyable) item);
        }
        this.c.set(i - getFastAdapter().f(i), item);
        a((IItem) item);
        getFastAdapter().m(i);
        return this;
    }

    /* renamed from: a */
    public ItemAdapter<Item> add(int i, List<Item> list) {
        if (this.d) {
            b.a((List) list);
        }
        if (list != null) {
            this.c.addAll(i - getFastAdapter().e(getOrder()), list);
            a((Iterable) list);
            getFastAdapter().a(i, list.size());
        }
        return this;
    }

    @SafeVarargs
    /* renamed from: a */
    public final ItemAdapter<Item> add(int i, Item... itemArr) {
        return add(i, Arrays.asList(itemArr));
    }

    /* renamed from: a */
    public ItemAdapter<Item> set(List<Item> list) {
        if (this.d) {
            b.a((List) list);
        }
        getFastAdapter().f(false);
        int size = list.size();
        int size2 = this.c.size();
        int e = getFastAdapter().e(getOrder());
        if (list != this.c) {
            if (!this.c.isEmpty()) {
                this.c.clear();
            }
            this.c.addAll(list);
        }
        a((Iterable) list);
        if (this.b != null) {
            Collections.sort(this.c, this.b);
        }
        if (size > size2) {
            if (size2 > 0) {
                getFastAdapter().c(e, size2);
            }
            getFastAdapter().a(e + size2, size - size2);
        } else if (size > 0 && size < size2) {
            getFastAdapter().c(e, size);
            getFastAdapter().b(e + size, size2 - size);
        } else if (size == 0) {
            getFastAdapter().b(e, size2);
        } else {
            getFastAdapter().f();
        }
        return this;
    }

    @SafeVarargs
    /* renamed from: a */
    public final ItemAdapter<Item> add(Item... itemArr) {
        return add(Arrays.asList(itemArr));
    }

    /* renamed from: b */
    public ItemAdapter<Item> setNewList(List<Item> list) {
        if (this.d) {
            b.a((List) list);
        }
        this.c = new ArrayList(list);
        a(this.c);
        if (this.b != null) {
            Collections.sort(this.c, this.b);
        }
        getFastAdapter().f();
        return this;
    }

    /* renamed from: c */
    public ItemAdapter<Item> add(List<Item> list) {
        if (this.d) {
            b.a((List) list);
        }
        int size = this.c.size();
        this.c.addAll(list);
        a((Iterable) list);
        if (this.b == null) {
            getFastAdapter().a(size + getFastAdapter().e(getOrder()), list.size());
        } else {
            Collections.sort(this.c, this.b);
            getFastAdapter().f();
        }
        return this;
    }

    public Item getAdapterItem(int i) {
        return (IItem) this.c.get(i);
    }

    public int getAdapterItemCount() {
        return this.c.size();
    }

    public List<Item> getAdapterItems() {
        return this.c;
    }

    public int getAdapterPosition(Item item) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            if (((IItem) this.c.get(i)).getIdentifier() == item.getIdentifier()) {
                return i;
            }
        }
        return -1;
    }

    public int getGlobalPosition(int i) {
        return getFastAdapter().e(getOrder()) + i;
    }

    public int getOrder() {
        return 500;
    }

    public <T> T setSubItems(IExpandable<T, Item> iExpandable, List<Item> list) {
        if (this.d) {
            b.a((List) list);
        }
        return iExpandable.withSubItems(list);
    }
}
