package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Iterator;

@GwtCompatible
public abstract class bw<E> extends cc implements Collection<E> {
    protected bw() {
    }

    protected boolean a(Collection<?> collection) {
        return bb.a((Collection) this, (Collection) collection);
    }

    protected <T> T[] a(T[] tArr) {
        return hc.a((Collection) this, (Object[]) tArr);
    }

    public boolean add(E e) {
        return b().add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return b().addAll(collection);
    }

    protected boolean b(Collection<? extends E> collection) {
        return er.a((Collection) this, collection.iterator());
    }

    /* renamed from: c */
    protected abstract Collection<E> b();

    protected boolean c(Collection<?> collection) {
        return er.a(iterator(), (Collection) collection);
    }

    public void clear() {
        b().clear();
    }

    public boolean contains(Object obj) {
        return b().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return b().containsAll(collection);
    }

    protected boolean d(Collection<?> collection) {
        return er.b(iterator(), (Collection) collection);
    }

    protected String g() {
        return bb.a((Collection) this);
    }

    protected Object[] h() {
        return toArray(new Object[size()]);
    }

    public boolean isEmpty() {
        return b().isEmpty();
    }

    public Iterator<E> iterator() {
        return b().iterator();
    }

    public boolean remove(Object obj) {
        return b().remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return b().removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return b().retainAll(collection);
    }

    public int size() {
        return b().size();
    }

    public Object[] toArray() {
        return b().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return b().toArray(tArr);
    }
}
