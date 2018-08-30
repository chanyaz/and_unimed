package com.google.android.gms.internal.ads;

public abstract class wq<MessageType extends wp<MessageType, BuilderType>, BuilderType extends wq<MessageType, BuilderType>> implements zzbcv {
    /* renamed from: a */
    public abstract BuilderType clone();

    protected abstract BuilderType a(MessageType messageType);

    public final /* synthetic */ zzbcv zzd(zzbcu zzbcu) {
        if (zzadg().getClass().isInstance(zzbcu)) {
            return a((wp) zzbcu);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
