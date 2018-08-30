package com.google.android.gms.internal.ads;

public class ye<MessageType extends yd<MessageType, BuilderType>, BuilderType extends ye<MessageType, BuilderType>> extends wq<MessageType, BuilderType> {
    protected MessageType a;
    private final MessageType b;
    private boolean c = false;

    protected ye(MessageType messageType) {
        this.b = messageType;
        this.a = (yd) messageType.a(yi.d, null, null);
    }

    private static void a(MessageType messageType, MessageType messageType2) {
        zl.a().a((Object) messageType).zzc(messageType, messageType2);
    }

    public final /* synthetic */ wq a() {
        return (ye) clone();
    }

    public final BuilderType a(MessageType messageType) {
        b();
        a(this.a, messageType);
        return this;
    }

    protected final void b() {
        if (this.c) {
            yd ydVar = (yd) this.a.a(yi.d, null, null);
            a(ydVar, this.a);
            this.a = ydVar;
            this.c = false;
        }
    }

    public final MessageType c() {
        yd ydVar;
        Object obj;
        boolean z;
        if (this.c) {
            ydVar = this.a;
        } else {
            obj = this.a;
            zl.a().a(obj).zzo(obj);
            this.c = true;
            ydVar = this.a;
        }
        obj = ydVar;
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) obj.a(yi.a, null, null)).byteValue();
        if (byteValue == (byte) 1) {
            z = true;
        } else if (byteValue == (byte) 0) {
            z = false;
        } else {
            boolean zzaa = zl.a().a(obj).zzaa(obj);
            if (booleanValue) {
                obj.a(yi.b, zzaa ? obj : null, null);
            }
            z = zzaa;
        }
        if (z) {
            return obj;
        }
        throw new zzbed(obj);
    }

    public /* synthetic */ Object clone() {
        yd ydVar;
        ye yeVar = (ye) this.b.a(yi.e, null, null);
        if (this.c) {
            ydVar = this.a;
        } else {
            Object obj = this.a;
            zl.a().a(obj).zzo(obj);
            this.c = true;
            ydVar = this.a;
        }
        yeVar.a(ydVar);
        return yeVar;
    }

    public final boolean isInitialized() {
        return yd.a(this.a, false);
    }

    public final /* synthetic */ zzbcu zzadg() {
        return this.b;
    }

    public final /* synthetic */ zzbcu zzadj() {
        if (this.c) {
            return this.a;
        }
        Object obj = this.a;
        zl.a().a(obj).zzo(obj);
        this.c = true;
        return this.a;
    }

    public final /* synthetic */ zzbcu zzadk() {
        yd ydVar;
        Object obj;
        boolean z;
        if (this.c) {
            ydVar = this.a;
        } else {
            obj = this.a;
            zl.a().a(obj).zzo(obj);
            this.c = true;
            ydVar = this.a;
        }
        obj = ydVar;
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) obj.a(yi.a, null, null)).byteValue();
        if (byteValue == (byte) 1) {
            z = true;
        } else if (byteValue == (byte) 0) {
            z = false;
        } else {
            boolean zzaa = zl.a().a(obj).zzaa(obj);
            if (booleanValue) {
                obj.a(yi.b, zzaa ? obj : null, null);
            }
            z = zzaa;
        }
        if (z) {
            return obj;
        }
        throw new zzbed(obj);
    }
}
