package com.mikepenz.fastadapter.utils;

import android.util.SparseIntArray;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class a {
    public static SparseIntArray a(SparseIntArray sparseIntArray, int i, int i2, int i3) {
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        int size = sparseIntArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            int keyAt = sparseIntArray.keyAt(i4);
            if (keyAt < i || keyAt > i2) {
                sparseIntArray2.put(keyAt, sparseIntArray.valueAt(i4));
            } else if (i3 > 0) {
                sparseIntArray2.put(keyAt + i3, sparseIntArray.valueAt(i4));
            } else if (i3 < 0 && (keyAt <= i + i3 || keyAt > i)) {
                sparseIntArray2.put(keyAt + i3, sparseIntArray.valueAt(i4));
            }
        }
        return sparseIntArray2;
    }

    public static List<IItem> a(FastAdapter fastAdapter) {
        List<IItem> arrayList = new ArrayList();
        int itemCount = fastAdapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            IItem b = fastAdapter.b(i);
            arrayList.add(b);
            c(b, arrayList);
        }
        return arrayList;
    }

    public static SortedSet<Integer> a(Set<Integer> set, int i, int i2, int i3) {
        SortedSet<Integer> treeSet = new TreeSet();
        for (Integer intValue : set) {
            int intValue2 = intValue.intValue();
            if (intValue2 < i || intValue2 > i2) {
                treeSet.add(Integer.valueOf(intValue2));
            } else if (i3 > 0) {
                treeSet.add(Integer.valueOf(intValue2 + i3));
            } else if (i3 < 0 && (intValue2 <= i + i3 || intValue2 > i)) {
                treeSet.add(Integer.valueOf(intValue2 + i3));
            }
        }
        return treeSet;
    }

    public static void a(FastAdapter fastAdapter, int i, int i2) {
        while (i2 >= i) {
            IItem b = fastAdapter.b(i2);
            if (b.isSelected()) {
                fastAdapter.b().add(Integer.valueOf(i2));
            } else if (fastAdapter.b().contains(Integer.valueOf(i2))) {
                fastAdapter.b().remove(Integer.valueOf(i2));
            }
            if ((b instanceof IExpandable) && ((IExpandable) b).isExpanded() && fastAdapter.d().indexOfKey(i2) < 0) {
                fastAdapter.k(i2);
            }
            i2--;
        }
    }

    public static void a(IItem iItem, List<String> list) {
        if ((iItem instanceof IExpandable) && !((IExpandable) iItem).isExpanded() && ((IExpandable) iItem).getSubItems() != null) {
            for (IItem iItem2 : ((IExpandable) iItem).getSubItems()) {
                String valueOf = String.valueOf(iItem2.getIdentifier());
                if (list != null && list.contains(valueOf)) {
                    iItem2.withSetSelected(true);
                }
                a(iItem2, list);
            }
        }
    }

    public static void b(IItem iItem, List<String> list) {
        if ((iItem instanceof IExpandable) && !((IExpandable) iItem).isExpanded() && ((IExpandable) iItem).getSubItems() != null) {
            for (IItem iItem2 : ((IExpandable) iItem).getSubItems()) {
                String valueOf = String.valueOf(iItem2.getIdentifier());
                if (iItem2.isSelected()) {
                    list.add(valueOf);
                }
                b(iItem2, list);
            }
        }
    }

    public static void c(IItem iItem, List<IItem> list) {
        if ((iItem instanceof IExpandable) && !((IExpandable) iItem).isExpanded() && ((IExpandable) iItem).getSubItems() != null) {
            for (IItem iItem2 : ((IExpandable) iItem).getSubItems()) {
                list.add(iItem2);
                c(iItem2, list);
            }
        }
    }
}
