package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.k;

public abstract class RemoteCreator<T> {
    private final String a;
    private T b;

    public class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    protected RemoteCreator(String str) {
        this.a = str;
    }

    protected final T a(Context context) {
        if (this.b == null) {
            ar.a((Object) context);
            Context remoteContext = k.getRemoteContext(context);
            if (remoteContext == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.b = b((IBinder) remoteContext.getClassLoader().loadClass(this.a).newInstance());
            } catch (Throwable e) {
                throw new RemoteCreatorException("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new RemoteCreatorException("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new RemoteCreatorException("Could not access creator.", e22);
            }
        }
        return this.b;
    }

    protected abstract T b(IBinder iBinder);
}
