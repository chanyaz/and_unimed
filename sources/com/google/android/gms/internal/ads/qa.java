package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class qa<P> {
    private static final Charset a = Charset.forName("UTF-8");
    private ConcurrentMap<String, List<qb<P>>> b = new ConcurrentHashMap();
    private qb<P> c;

    public final qb<P> a() {
        return this.c;
    }

    protected final qb<P> a(P p, uc ucVar) {
        byte[] array;
        switch (ucVar.e()) {
            case LEGACY:
            case CRUNCHY:
                array = ByteBuffer.allocate(5).put((byte) 0).putInt(ucVar.d()).array();
                break;
            case TINK:
                array = ByteBuffer.allocate(5).put((byte) 1).putInt(ucVar.d()).array();
                break;
            case RAW:
                array = pv.a;
                break;
            default:
                throw new GeneralSecurityException("unknown output prefix type");
        }
        qb<P> qbVar = new qb(p, array, ucVar.c(), ucVar.e());
        List arrayList = new ArrayList();
        arrayList.add(qbVar);
        String str = new String(qbVar.b(), a);
        arrayList = (List) this.b.put(str, Collections.unmodifiableList(arrayList));
        if (arrayList != null) {
            List arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            arrayList2.add(qbVar);
            this.b.put(str, Collections.unmodifiableList(arrayList2));
        }
        return qbVar;
    }

    protected final void a(qb<P> qbVar) {
        this.c = qbVar;
    }
}
