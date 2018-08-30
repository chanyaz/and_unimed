package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.google.android.gms.dynamic.c;

public final class av extends RemoteCreator<ISignInButtonCreator> {
    private static final av a = new av();

    private av() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View a(Context context, int i, int i2) {
        return a.b(context, i, i2);
    }

    private final View b(Context context, int i, int i2) {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2, null);
            return (View) c.a(((ISignInButtonCreator) a(context)).newSignInButtonFromConfig(c.a((Object) context), signInButtonConfig));
        } catch (Throwable e) {
            throw new RemoteCreatorException("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    /* renamed from: a */
    public final ISignInButtonCreator b(IBinder iBinder) {
        return am.a(iBinder);
    }
}
