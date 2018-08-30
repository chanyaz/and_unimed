package com.google.firebase.iid;

import android.support.annotation.WorkerThread;
import android.support.v4.util.a;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.b;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.annotation.concurrent.GuardedBy;

final class i {
    @GuardedBy("this")
    private final Map<Pair<String, String>, b<String>> a = new a();

    i() {
    }

    private static String a(zzak zzak, b<String> bVar) {
        Exception e;
        try {
            Object zzp = zzak.zzp();
            bVar.a(zzp);
            return zzp;
        } catch (IOException e2) {
            e = e2;
            bVar.a(e);
            throw e;
        } catch (RuntimeException e3) {
            e = e3;
            bVar.a(e);
            throw e;
        }
    }

    private final synchronized zzak b(String str, String str2, zzak zzak) {
        zzak jVar;
        Pair pair = new Pair(str, str2);
        b bVar = (b) this.a.get(pair);
        if (bVar != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Joining ongoing request for: ").append(valueOf).toString());
            }
            jVar = new j(bVar);
        } else {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf2 = String.valueOf(pair);
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf2).length() + 24).append("Making new request for: ").append(valueOf2).toString());
            }
            b bVar2 = new b();
            this.a.put(pair, bVar2);
            jVar = new k(this, zzak, bVar2, pair);
        }
        return jVar;
    }

    private static String b(b<String> bVar) {
        Throwable cause;
        try {
            return (String) Tasks.a(bVar.a());
        } catch (ExecutionException e) {
            cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(cause);
            }
        } catch (Throwable cause2) {
            throw new IOException(cause2);
        }
    }

    @WorkerThread
    final String a(String str, String str2, zzak zzak) {
        return b(str, str2, zzak).zzp();
    }
}
