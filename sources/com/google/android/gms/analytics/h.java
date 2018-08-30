package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@VisibleForTesting
public class h implements ExceptionParser {
    private final TreeSet<String> a = new TreeSet();

    public h(Context context, Collection<String> collection) {
        a(context, collection);
    }

    protected String a(Throwable th, StackTraceElement stackTraceElement, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(th.getClass().getSimpleName());
        if (stackTraceElement != null) {
            String[] split = stackTraceElement.getClassName().split("\\.");
            String str2 = "unknown";
            if (split != null && split.length > 0) {
                str2 = split[split.length - 1];
            }
            stringBuilder.append(String.format(" (@%s:%s:%s)", new Object[]{str2, stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())}));
        }
        if (str != null) {
            stringBuilder.append(String.format(" {%s}", new Object[]{str}));
        }
        return stringBuilder.toString();
    }

    protected Throwable a(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public void a(Context context, Collection<String> collection) {
        this.a.clear();
        Set<String> hashSet = new HashSet();
        if (collection != null) {
            hashSet.addAll(collection);
        }
        if (context != null) {
            hashSet.add(context.getApplicationContext().getPackageName());
        }
        for (String str : hashSet) {
            Object obj;
            Object obj2 = 1;
            Iterator it = this.a.iterator();
            while (true) {
                obj = obj2;
                if (!it.hasNext()) {
                    break;
                }
                String str2 = (String) it.next();
                if (str.startsWith(str2)) {
                    obj2 = null;
                } else if (str2.startsWith(str)) {
                    this.a.remove(str2);
                }
            }
            if (obj != null) {
                this.a.add(str);
            }
        }
    }

    protected StackTraceElement b(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                if (className.startsWith((String) it.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }

    public String getDescription(String str, Throwable th) {
        return a(a(th), b(a(th)), str);
    }
}
