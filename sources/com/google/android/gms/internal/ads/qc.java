package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class qc {
    private static final Logger a = Logger.getLogger(qc.class.getName());
    private static final ConcurrentMap<String, zzaug> b = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> c = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzaua> d = new ConcurrentHashMap();

    public static <P> qa<P> a(px pxVar, zzaug<P> zzaug) {
        qd.b(pxVar.a());
        qa<P> qaVar = new qa();
        for (uc ucVar : pxVar.a().b()) {
            if (ucVar.c() == zzaxl.ENABLED) {
                qb a = qaVar.a(a(ucVar.b().a(), ucVar.b().b()), ucVar);
                if (ucVar.d() == pxVar.a().a()) {
                    qaVar.a(a);
                }
            }
        }
        return qaVar;
    }

    public static <P> zzaua<P> a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        zzaua<P> zzaua = (zzaua) d.get(str.toLowerCase());
        if (zzaua != null) {
            return zzaua;
        }
        String format = String.format("no catalogue found for %s. ", new Object[]{str});
        if (str.toLowerCase().startsWith("tinkaead")) {
            format = String.valueOf(format).concat("Maybe call AeadConfig.init().");
        }
        if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
            format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.init().");
        } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
            format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.init().");
        } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
            format = String.valueOf(format).concat("Maybe call HybridConfig.init().");
        } else if (str.toLowerCase().startsWith("tinkmac")) {
            format = String.valueOf(format).concat("Maybe call MacConfig.init().");
        } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
            format = String.valueOf(format).concat("Maybe call SignatureConfig.init().");
        } else if (str.toLowerCase().startsWith("tink")) {
            format = String.valueOf(format).concat("Maybe call TinkConfig.init().");
        }
        throw new GeneralSecurityException(format);
    }

    public static <P> zzaxi a(tu tuVar) {
        zzaug b = b(tuVar.a());
        if (((Boolean) c.get(tuVar.a())).booleanValue()) {
            return b.zzc(tuVar.b());
        }
        String str = "newKey-operation not permitted for key type ";
        String valueOf = String.valueOf(tuVar.a());
        throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public static <P> zzbcu a(String str, zzbcu zzbcu) {
        zzaug b = b(str);
        if (((Boolean) c.get(str)).booleanValue()) {
            return b.zzb(zzbcu);
        }
        String str2 = "newKey-operation not permitted for key type ";
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    private static <P> P a(String str, zzbah zzbah) {
        return b(str).zza(zzbah);
    }

    public static <P> P a(String str, byte[] bArr) {
        return a(str, zzbah.a(bArr));
    }

    public static synchronized <P> void a(String str, zzaua<P> zzaua) {
        synchronized (qc.class) {
            if (d.containsKey(str.toLowerCase())) {
                if (!zzaua.getClass().equals(((zzaua) d.get(str.toLowerCase())).getClass())) {
                    Logger logger = a;
                    Level level = Level.WARNING;
                    String str2 = "com.google.crypto.tink.Registry";
                    String str3 = "addCatalogue";
                    String str4 = "Attempted overwrite of a catalogueName catalogue for name ";
                    String valueOf = String.valueOf(str);
                    logger.logp(level, str2, str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                    throw new GeneralSecurityException(new StringBuilder(String.valueOf(str).length() + 47).append("catalogue for name ").append(str).append(" has been already registered").toString());
                }
            }
            d.put(str.toLowerCase(), zzaua);
        }
    }

    public static <P> void a(String str, zzaug<P> zzaug) {
        a(str, zzaug, true);
    }

    public static synchronized <P> void a(String str, zzaug<P> zzaug, boolean z) {
        synchronized (qc.class) {
            if (zzaug == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            if (b.containsKey(str)) {
                zzaug b = b(str);
                boolean booleanValue = ((Boolean) c.get(str)).booleanValue();
                if (!zzaug.getClass().equals(b.getClass()) || (!booleanValue && z)) {
                    Logger logger = a;
                    Level level = Level.WARNING;
                    String str2 = "com.google.crypto.tink.Registry";
                    String str3 = "registerKeyManager";
                    String str4 = "Attempted overwrite of a registered key manager for key type ";
                    String valueOf = String.valueOf(str);
                    logger.logp(level, str2, str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{str, b.getClass().getName(), zzaug.getClass().getName()}));
                }
            }
            b.put(str, zzaug);
            c.put(str, Boolean.valueOf(z));
        }
    }

    private static <P> zzaug<P> b(String str) {
        zzaug<P> zzaug = (zzaug) b.get(str);
        if (zzaug != null) {
            return zzaug;
        }
        throw new GeneralSecurityException(new StringBuilder(String.valueOf(str).length() + 78).append("No key manager found for key type: ").append(str).append(".  Check the configuration of the registry.").toString());
    }

    public static <P> zzbcu b(tu tuVar) {
        zzaug b = b(tuVar.a());
        if (((Boolean) c.get(tuVar.a())).booleanValue()) {
            return b.zzb(tuVar.b());
        }
        String str = "newKey-operation not permitted for key type ";
        String valueOf = String.valueOf(tuVar.a());
        throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public static <P> P b(String str, zzbcu zzbcu) {
        return b(str).zza(zzbcu);
    }
}
