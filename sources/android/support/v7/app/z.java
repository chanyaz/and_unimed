package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Method;

class z implements OnClickListener {
    private final View a;
    private final String b;
    private Method c;
    private Context d;

    public z(@NonNull View view, @NonNull String str) {
        this.a = view;
        this.b = str;
    }

    @NonNull
    private void a(@Nullable Context context, @NonNull String str) {
        for (Context context2 = context; context2 != null; context2 = context2 instanceof ContextWrapper ? ((ContextWrapper) context2).getBaseContext() : null) {
            try {
                if (!context2.isRestricted()) {
                    Method method = context2.getClass().getMethod(this.b, new Class[]{View.class});
                    if (method != null) {
                        this.c = method;
                        this.d = context2;
                        return;
                    }
                }
            } catch (NoSuchMethodException e) {
            }
        }
        int id = this.a.getId();
        throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.a.getClass() + (id == -1 ? "" : " with id '" + this.a.getContext().getResources().getResourceEntryName(id) + "'"));
    }

    public void onClick(@NonNull View view) {
        if (this.c == null) {
            a(this.a.getContext(), this.b);
        }
        try {
            this.c.invoke(this.d, new Object[]{view});
        } catch (Throwable e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (Throwable e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
