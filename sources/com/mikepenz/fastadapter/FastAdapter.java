package com.mikepenz.fastadapter;

import android.os.Bundle;
import android.support.v4.util.a;
import android.support.v7.widget.bo;
import android.support.v7.widget.ce;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class FastAdapter<Item extends IItem> extends bo<ce> {
    private final a<Integer, IAdapter<Item>> a = new a();
    private final a<Integer, Item> b = new a();
    private final NavigableMap<Integer, IAdapter<Item>> c = new TreeMap();
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = true;
    private boolean i = false;
    private boolean j = false;
    private boolean k = true;
    private SortedSet<Integer> l = new TreeSet();
    private SparseIntArray m = new SparseIntArray();
    private OnClickListener<Item> n;
    private OnClickListener<Item> o;
    private OnLongClickListener<Item> p;
    private OnLongClickListener<Item> q;
    private OnTouchListener<Item> r;
    private OnCreateViewHolderListener s = new c(this);
    private OnBindViewHolderListener t = new b(this);

    public interface OnBindViewHolderListener {
        void onBindViewHolder(ce ceVar, int i);
    }

    public interface OnClickListener<Item extends IItem> {
        boolean onClick(View view, IAdapter<Item> iAdapter, Item item, int i);
    }

    public interface OnCreateViewHolderListener {
        ce onPostCreateViewHolder(ce ceVar);

        ce onPreCreateViewHolder(ViewGroup viewGroup, int i);
    }

    public interface OnLongClickListener<Item extends IItem> {
        boolean onLongClick(View view, IAdapter<Item> iAdapter, Item item, int i);
    }

    public interface OnTouchListener<Item extends IItem> {
        boolean onTouch(View view, MotionEvent motionEvent, IAdapter<Item> iAdapter, Item item, int i);
    }

    public FastAdapter() {
        setHasStableIds(true);
    }

    private void a(int i, Iterator<Integer> it) {
        IItem b = b(i);
        if (b != null) {
            b.withSetSelected(false);
        }
        if (it != null) {
            it.remove();
        } else if (this.k && this.l.contains(Integer.valueOf(i))) {
            this.l.remove(Integer.valueOf(i));
        }
        notifyItemChanged(i);
    }

    private void a(View view, Item item, int i) {
        boolean z = true;
        if (!item.isSelectable()) {
            return;
        }
        if (!item.isSelected() || this.h) {
            boolean contains = this.k ? this.l.contains(Integer.valueOf(i)) : item.isSelected();
            if (this.e || view == null) {
                if (!this.f) {
                    c();
                }
                if (contains) {
                    h(i);
                    return;
                } else {
                    g(i);
                    return;
                }
            }
            if (!this.f) {
                Iterator it;
                Integer num;
                if (this.k) {
                    it = this.l.iterator();
                    while (it.hasNext()) {
                        num = (Integer) it.next();
                        if (num.intValue() != i) {
                            a(num.intValue(), it);
                        }
                    }
                } else {
                    for (Integer num2 : b()) {
                        int intValue = num2.intValue();
                        if (intValue != i) {
                            h(intValue);
                        }
                    }
                }
            }
            item.withSetSelected(!contains);
            if (contains) {
                z = false;
            }
            view.setSelected(z);
            if (!this.k) {
                return;
            }
            if (!contains) {
                this.l.add(Integer.valueOf(i));
            } else if (this.l.contains(Integer.valueOf(i))) {
                this.l.remove(Integer.valueOf(i));
            }
        }
    }

    private void a(IExpandable iExpandable, int i, boolean z) {
        IAdapter d = d(i);
        if (d != null && (d instanceof IItemAdapter)) {
            ((IItemAdapter) d).removeRange(i + 1, iExpandable.getSubItems().size());
        }
        iExpandable.withIsExpanded(false);
        if (this.k) {
            int indexOfKey = this.m.indexOfKey(i);
            if (indexOfKey >= 0) {
                this.m.removeAt(indexOfKey);
            }
        }
        if (z) {
            notifyItemChanged(i);
        }
    }

    private void d(int i, boolean z) {
        IItem b = b(i);
        if (b != null && (b instanceof IExpandable)) {
            IExpandable iExpandable = (IExpandable) b;
            if (iExpandable.isExpanded() && iExpandable.getSubItems() != null && iExpandable.getSubItems().size() > 0) {
                a(iExpandable, i, z);
            }
        }
    }

    private void g() {
        int i = 0;
        this.c.clear();
        if (this.a.size() > 0) {
            this.c.put(Integer.valueOf(0), this.a.c(0));
        }
        Iterator it = this.a.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                IAdapter iAdapter = (IAdapter) it.next();
                if (iAdapter.getAdapterItemCount() > 0) {
                    this.c.put(Integer.valueOf(i2), iAdapter);
                    i = iAdapter.getAdapterItemCount() + i2;
                } else {
                    i = i2;
                }
            } else {
                this.d = i2;
                return;
            }
        }
    }

    public int a(ce ceVar) {
        return ceVar.getAdapterPosition();
    }

    public FastAdapter<Item> a(Bundle bundle) {
        return a(bundle, "");
    }

    public FastAdapter<Item> a(Bundle bundle, String str) {
        int i = 0;
        if (bundle != null) {
            c();
            if (this.k) {
                int[] intArray = bundle.getIntArray("bundle_expanded" + str);
                if (intArray != null) {
                    for (int valueOf : intArray) {
                        k(Integer.valueOf(valueOf).intValue());
                    }
                }
                int[] intArray2 = bundle.getIntArray("bundle_selections" + str);
                if (intArray2 != null) {
                    int length = intArray2.length;
                    while (i < length) {
                        g(Integer.valueOf(intArray2[i]).intValue());
                        i++;
                    }
                }
            } else {
                ArrayList stringArrayList = bundle.getStringArrayList("bundle_expanded" + str);
                List stringArrayList2 = bundle.getStringArrayList("bundle_selections" + str);
                while (i < getItemCount()) {
                    IItem b = b(i);
                    String valueOf2 = String.valueOf(b.getIdentifier());
                    if (stringArrayList != null && stringArrayList.contains(valueOf2)) {
                        k(i);
                    }
                    if (stringArrayList2 != null && stringArrayList2.contains(valueOf2)) {
                        g(i);
                    }
                    com.mikepenz.fastadapter.utils.a.a(b, stringArrayList2);
                    i++;
                }
            }
        }
        return this;
    }

    public FastAdapter<Item> a(OnClickListener<Item> onClickListener) {
        this.o = onClickListener;
        return this;
    }

    public FastAdapter<Item> a(OnLongClickListener<Item> onLongClickListener) {
        this.q = onLongClickListener;
        return this;
    }

    public FastAdapter<Item> a(boolean z) {
        this.f = z;
        return this;
    }

    public Item a(int i) {
        return (IItem) this.b.get(Integer.valueOf(i));
    }

    public void a(int i, int i2) {
        if (this.k) {
            this.l = com.mikepenz.fastadapter.utils.a.a(this.l, i, (int) MoPubClientPositioning.NO_REPEAT, i2);
            this.m = com.mikepenz.fastadapter.utils.a.a(this.m, i, (int) MoPubClientPositioning.NO_REPEAT, i2);
        }
        g();
        notifyItemRangeInserted(i, i2);
        if (this.k) {
            com.mikepenz.fastadapter.utils.a.a(this, i, (i + i2) - 1);
        }
    }

    public void a(int i, int i2, Object obj) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (!this.k) {
                IItem b = b(i);
                if ((b instanceof IExpandable) && ((IExpandable) b).isExpanded()) {
                    j(i);
                }
            } else if (this.m.indexOfKey(i3) >= 0) {
                j(i3);
            }
        }
        if (obj == null) {
            notifyItemRangeChanged(i, i2);
        } else {
            notifyItemRangeChanged(i, i2, obj);
        }
        if (this.k) {
            com.mikepenz.fastadapter.utils.a.a(this, i, (i + i2) - 1);
        }
    }

    public void a(int i, Object obj) {
        a(i, 1, obj);
    }

    public void a(int i, boolean z) {
        a(i, z, false);
    }

    public void a(int i, boolean z, boolean z2) {
        IItem b = b(i);
        if (b != null) {
            if (!z2 || b.isSelectable()) {
                b.withSetSelected(true);
                if (this.k) {
                    this.l.add(Integer.valueOf(i));
                }
                notifyItemChanged(i);
                if (this.o != null && z) {
                    this.o.onClick(null, d(i), b, i);
                }
            }
        }
    }

    public void a(Item item) {
        if (!this.b.containsKey(Integer.valueOf(item.getType()))) {
            this.b.put(Integer.valueOf(item.getType()), item);
        }
    }

    public <A extends a<Item>> void a(A a) {
        if (!this.a.containsKey(Integer.valueOf(a.getOrder()))) {
            this.a.put(Integer.valueOf(a.getOrder()), a);
            g();
        }
    }

    public void a(Iterable<Integer> iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            a(((Integer) it.next()).intValue(), it);
        }
    }

    public boolean a() {
        return this.k;
    }

    public Bundle b(Bundle bundle) {
        return b(bundle, "");
    }

    public Bundle b(Bundle bundle, String str) {
        int i = 0;
        if (bundle != null) {
            if (this.k) {
                int[] iArr = new int[this.l.size()];
                Iterator it = this.l.iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    iArr[i2] = ((Integer) it.next()).intValue();
                    i = i2 + 1;
                }
                bundle.putIntArray("bundle_selections" + str, iArr);
                bundle.putIntArray("bundle_expanded" + str, e());
            } else {
                Object arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int itemCount = getItemCount();
                for (int i3 = 0; i3 < itemCount; i3++) {
                    IItem b = b(i3);
                    if ((b instanceof IExpandable) && ((IExpandable) b).isExpanded()) {
                        arrayList2.add(String.valueOf(b.getIdentifier()));
                    }
                    if (b.isSelected()) {
                        arrayList.add(String.valueOf(b.getIdentifier()));
                    }
                    com.mikepenz.fastadapter.utils.a.b(b, arrayList);
                }
                bundle.putStringArrayList("bundle_selections" + str, arrayList);
                bundle.putStringArrayList("bundle_expanded" + str, arrayList2);
            }
        }
        return bundle;
    }

    public FastAdapter<Item> b(boolean z) {
        this.g = z;
        return this;
    }

    public Item b(int i) {
        if (i < 0 || i >= this.d) {
            return null;
        }
        Entry floorEntry = this.c.floorEntry(Integer.valueOf(i));
        return ((IAdapter) floorEntry.getValue()).getAdapterItem(i - ((Integer) floorEntry.getKey()).intValue());
    }

    public Set<Integer> b() {
        if (this.k) {
            return this.l;
        }
        Set<Integer> hashSet = new HashSet();
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (b(i).isSelected()) {
                hashSet.add(Integer.valueOf(i));
            }
        }
        return hashSet;
    }

    public void b(int i, int i2) {
        if (this.k) {
            this.l = com.mikepenz.fastadapter.utils.a.a(this.l, i, (int) MoPubClientPositioning.NO_REPEAT, i2 * -1);
            this.m = com.mikepenz.fastadapter.utils.a.a(this.m, i, (int) MoPubClientPositioning.NO_REPEAT, i2 * -1);
        }
        g();
        notifyItemRangeRemoved(i, i2);
    }

    public void b(int i, boolean z) {
        IItem b = b(i);
        if (b != null && (b instanceof IExpandable)) {
            IExpandable iExpandable = (IExpandable) b;
            if (iExpandable.isExpanded() && iExpandable.getSubItems() != null && iExpandable.getSubItems().size() > 0) {
                int size;
                int i2;
                int i3;
                if (this.k) {
                    size = iExpandable.getSubItems().size();
                    int size2 = this.m.size();
                    i2 = 0;
                    while (i2 < size2) {
                        i3 = (this.m.keyAt(i2) <= i || this.m.keyAt(i2) > i + size) ? size : this.m.get(this.m.keyAt(i2)) + size;
                        i2++;
                        size = i3;
                    }
                    Iterator it = this.l.iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        if (num.intValue() > i && num.intValue() <= i + size) {
                            a(num.intValue(), it);
                        }
                    }
                    i3 = size;
                    size = size2 - 1;
                    while (size >= 0) {
                        if (this.m.keyAt(size) > i && this.m.keyAt(size) <= i + i3) {
                            i3 -= this.m.get(this.m.keyAt(size));
                            d(this.m.keyAt(size), z);
                        }
                        size--;
                    }
                    a(iExpandable, i, z);
                    return;
                }
                IItem b2;
                IExpandable iExpandable2;
                size = iExpandable.getSubItems().size();
                i3 = i + 1;
                while (true) {
                    i2 = i3;
                    if (i2 >= i + size) {
                        break;
                    }
                    b2 = b(i2);
                    if (b2 instanceof IExpandable) {
                        iExpandable2 = (IExpandable) b2;
                        if (iExpandable2.getSubItems() != null && iExpandable2.isExpanded()) {
                            i3 = iExpandable2.getSubItems().size() + size;
                            size = i2 + 1;
                            i2 = size;
                        }
                    }
                    i3 = size;
                    size = i2 + 1;
                    i2 = size;
                }
                size = (i + size) - 1;
                while (size > i) {
                    b2 = b(size);
                    if (b2 instanceof IExpandable) {
                        iExpandable2 = (IExpandable) b2;
                        if (iExpandable2.isExpanded()) {
                            j(size);
                            if (iExpandable2.getSubItems() != null) {
                                i3 = size - iExpandable2.getSubItems().size();
                                size = i3 - 1;
                            }
                        }
                    }
                    i3 = size;
                    size = i3 - 1;
                }
                a(iExpandable, i, z);
            }
        }
    }

    public FastAdapter<Item> c(boolean z) {
        this.h = z;
        return this;
    }

    public d<Item> c(int i) {
        if (i < 0) {
            return new d();
        }
        d<Item> dVar = new d();
        Entry floorEntry = this.c.floorEntry(Integer.valueOf(i));
        if (floorEntry != null) {
            dVar.b = ((IAdapter) floorEntry.getValue()).getAdapterItem(i - ((Integer) floorEntry.getKey()).intValue());
            dVar.a = (IAdapter) floorEntry.getValue();
            dVar.c = i;
        }
        return dVar;
    }

    public void c() {
        if (this.k) {
            a(this.l);
            return;
        }
        for (IItem withSetSelected : com.mikepenz.fastadapter.utils.a.a(this)) {
            withSetSelected.withSetSelected(false);
        }
        notifyDataSetChanged();
    }

    public void c(int i, int i2) {
        a(i, i2, null);
    }

    public void c(int i, boolean z) {
        IItem b = b(i);
        if (b != null && (b instanceof IExpandable)) {
            IExpandable iExpandable = (IExpandable) b;
            IAdapter d;
            if (this.k) {
                if (this.m.indexOfKey(i) < 0 && iExpandable.getSubItems() != null && iExpandable.getSubItems().size() > 0) {
                    d = d(i);
                    if (d != null && (d instanceof IItemAdapter)) {
                        ((IItemAdapter) d).add(i + 1, iExpandable.getSubItems());
                    }
                    iExpandable.withIsExpanded(true);
                    if (z) {
                        notifyItemChanged(i);
                    }
                    this.m.put(i, iExpandable.getSubItems() != null ? iExpandable.getSubItems().size() : 0);
                }
            } else if (!iExpandable.isExpanded() && iExpandable.getSubItems() != null && iExpandable.getSubItems().size() > 0) {
                d = d(i);
                if (d != null && (d instanceof IItemAdapter)) {
                    ((IItemAdapter) d).add(i + 1, iExpandable.getSubItems());
                }
                iExpandable.withIsExpanded(true);
                if (z) {
                    notifyItemChanged(i);
                }
            }
        }
    }

    public SparseIntArray d() {
        if (this.k) {
            return this.m;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            IItem b = b(i);
            if ((b instanceof IExpandable) && ((IExpandable) b).isExpanded()) {
                sparseIntArray.put(i, ((IExpandable) b).getSubItems().size());
            }
        }
        return sparseIntArray;
    }

    public FastAdapter<Item> d(boolean z) {
        this.i = z;
        return this;
    }

    public IAdapter<Item> d(int i) {
        return (i < 0 || i >= this.d) ? null : (IAdapter) this.c.floorEntry(Integer.valueOf(i)).getValue();
    }

    public int e(int i) {
        int i2 = 0;
        if (this.d == 0) {
            return 0;
        }
        Iterator it = this.a.values().iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return i3;
            }
            IAdapter iAdapter = (IAdapter) it.next();
            if (iAdapter.getOrder() == i) {
                return i3;
            }
            i2 = iAdapter.getAdapterItemCount() + i3;
        }
    }

    public FastAdapter<Item> e(boolean z) {
        this.k = z;
        return this;
    }

    public int[] e() {
        int i = 0;
        int size;
        if (this.k) {
            size = this.m.size();
            int[] iArr = new int[size];
            while (i < size) {
                iArr[i] = this.m.keyAt(i);
                i++;
            }
            return iArr;
        }
        ArrayList arrayList = new ArrayList();
        int itemCount = getItemCount();
        for (size = 0; size < itemCount; size++) {
            IItem b = b(size);
            if ((b instanceof IExpandable) && ((IExpandable) b).isExpanded()) {
                arrayList.add(Integer.valueOf(size));
            }
        }
        itemCount = arrayList.size();
        int[] iArr2 = new int[itemCount];
        while (i < itemCount) {
            iArr2[i] = ((Integer) arrayList.get(i)).intValue();
            i++;
        }
        return iArr2;
    }

    public int f(int i) {
        return this.d == 0 ? 0 : ((Integer) this.c.floorKey(Integer.valueOf(i))).intValue();
    }

    public void f() {
        if (this.k) {
            this.l.clear();
            this.m.clear();
        }
        g();
        notifyDataSetChanged();
        if (this.k) {
            com.mikepenz.fastadapter.utils.a.a(this, 0, getItemCount() - 1);
        }
    }

    public void f(boolean z) {
        int[] e = e();
        for (int length = e.length - 1; length >= 0; length--) {
            b(e[length], z);
        }
    }

    public void g(int i) {
        a(i, false);
    }

    public int getItemCount() {
        return this.d;
    }

    public long getItemId(int i) {
        return b(i).getIdentifier();
    }

    public int getItemViewType(int i) {
        return b(i).getType();
    }

    public void h(int i) {
        a(i, null);
    }

    public void i(int i) {
        if (!this.k) {
            IItem b = b(i);
            if ((b instanceof IExpandable) && ((IExpandable) b).isExpanded()) {
                j(i);
            } else {
                k(i);
            }
        } else if (this.m.indexOfKey(i) >= 0) {
            j(i);
        } else {
            k(i);
        }
    }

    public void j(int i) {
        b(i, false);
    }

    public void k(int i) {
        c(i, false);
    }

    public void l(int i) {
        b(i, 1);
    }

    public void m(int i) {
        a(i, null);
    }

    public void onBindViewHolder(ce ceVar, int i) {
        this.t.onBindViewHolder(ceVar, i);
    }

    public ce onCreateViewHolder(ViewGroup viewGroup, int i) {
        final ce onPreCreateViewHolder = this.s.onPreCreateViewHolder(viewGroup, i);
        onPreCreateViewHolder.itemView.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View view) {
                int a = FastAdapter.this.a(onPreCreateViewHolder);
                if (a != -1) {
                    boolean z = false;
                    d c = FastAdapter.this.c(a);
                    IItem iItem = c.b;
                    if (iItem != null && iItem.isEnabled()) {
                        if ((iItem instanceof IClickable) && ((IClickable) iItem).getOnPreItemClickListener() != null) {
                            z = ((IClickable) iItem).getOnPreItemClickListener().onClick(view, c.a, iItem, a);
                        }
                        if (!(z || FastAdapter.this.n == null)) {
                            z = FastAdapter.this.n.onClick(view, c.a, iItem, a);
                        }
                        if (!z && (iItem instanceof IExpandable) && ((IExpandable) iItem).isAutoExpanding() && ((IExpandable) iItem).getSubItems() != null) {
                            FastAdapter.this.i(a);
                        }
                        if (FastAdapter.this.j) {
                            int[] e = FastAdapter.this.e();
                            for (int length = e.length - 1; length >= 0; length--) {
                                if (e[length] != a) {
                                    FastAdapter.this.b(e[length], true);
                                }
                            }
                        }
                        if (!(z || FastAdapter.this.g || !FastAdapter.this.i)) {
                            FastAdapter.this.a(view, iItem, a);
                        }
                        boolean onClick = (!(iItem instanceof IClickable) || ((IClickable) iItem).getOnItemClickListener() == null) ? z : ((IClickable) iItem).getOnItemClickListener().onClick(view, c.a, iItem, a);
                        if (!onClick && FastAdapter.this.o != null) {
                            FastAdapter.this.o.onClick(view, c.a, iItem, a);
                        }
                    }
                }
            }
        });
        onPreCreateViewHolder.itemView.setOnLongClickListener(new android.view.View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                boolean z = false;
                int a = FastAdapter.this.a(onPreCreateViewHolder);
                if (a == -1) {
                    return false;
                }
                d c = FastAdapter.this.c(a);
                if (c.b == null || !c.b.isEnabled()) {
                    return false;
                }
                if (FastAdapter.this.p != null) {
                    z = FastAdapter.this.p.onLongClick(view, c.a, c.b, a);
                }
                if (!z && FastAdapter.this.g && FastAdapter.this.i) {
                    FastAdapter.this.a(view, c.b, a);
                }
                return FastAdapter.this.q != null ? FastAdapter.this.q.onLongClick(view, c.a, c.b, a) : z;
            }
        });
        onPreCreateViewHolder.itemView.setOnTouchListener(new android.view.View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FastAdapter.this.r != null) {
                    int a = FastAdapter.this.a(onPreCreateViewHolder);
                    if (a != -1) {
                        d c = FastAdapter.this.c(a);
                        return FastAdapter.this.r.onTouch(view, motionEvent, c.a, c.b, a);
                    }
                }
                return false;
            }
        });
        return this.s.onPostCreateViewHolder(onPreCreateViewHolder);
    }
}
