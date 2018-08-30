package dagger.internal;

import dagger.MembersInjector;
import javax.inject.Provider;

public abstract class Binding<T> implements MembersInjector<T>, Provider<T> {
    public static final Binding<Object> a = new Binding<Object>(null, null, false, null) {
        public Object get() {
            throw new AssertionError("Unresolved binding should never be called to inject.");
        }

        public void injectMembers(Object obj) {
            throw new AssertionError("Unresolved binding should never be called to inject.");
        }
    };
    public final String b;
    public final String c;
    public final Object d;
    private int e;

    public class InvalidBindingException extends RuntimeException {
        public final String a;

        public InvalidBindingException(String str, String str2) {
            super(str2);
            this.a = str;
        }
    }

    protected Binding(String str, String str2, boolean z, Object obj) {
        if (z && str == null) {
            throw new InvalidBindingException(c.d(str2), "is exclusively members injected and therefore cannot be scoped");
        }
        this.b = str;
        this.c = str2;
        this.d = obj;
        this.e = z ? 1 : 0;
    }

    public void a(Linker linker) {
    }

    public void a(boolean z) {
        this.e = z ? this.e | 32 : this.e & -33;
    }

    void b() {
        this.e |= 2;
    }

    public void b(boolean z) {
        this.e = z ? this.e | 16 : this.e & -17;
    }

    public boolean c() {
        return (this.e & 2) != 0;
    }

    boolean d() {
        return (this.e & 1) != 0;
    }

    public boolean e() {
        return (this.e & 32) != 0;
    }

    public boolean f() {
        return (this.e & 16) != 0;
    }

    public T get() {
        throw new UnsupportedOperationException("No injectable constructor on " + getClass().getName());
    }

    public void injectMembers(T t) {
    }

    public String toString() {
        return getClass().getSimpleName() + "[provideKey=\"" + this.b + "\", memberskey=\"" + this.c + "\"]";
    }
}
