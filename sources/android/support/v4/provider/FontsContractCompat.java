package android.support.v4.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.GuardedBy;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.graphics.h;
import android.support.v4.provider.SelfDestructiveThread.ReplyCallback;
import android.support.v4.util.g;
import android.support.v4.util.s;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FontsContractCompat {
    private static final g<String, Typeface> a = new g(16);
    private static final SelfDestructiveThread b = new SelfDestructiveThread("fonts", 10, 10000);
    private static final Object c = new Object();
    @GuardedBy("sLock")
    private static final s<String, ArrayList<ReplyCallback<c>>> d = new s();
    private static final Comparator<byte[]> e = new Comparator<byte[]>() {
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    };

    public class FontFamilyResult {
        private final int a;
        private final b[] b;

        @RestrictTo({Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        @interface FontResultStatus {
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public FontFamilyResult(int i, @Nullable b[] bVarArr) {
            this.a = i;
            this.b = bVarArr;
        }

        public int a() {
            return this.a;
        }

        public b[] b() {
            return this.b;
        }
    }

    public class FontRequestCallback {

        @RestrictTo({Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface FontRequestFailReason {
        }
    }

    private FontsContractCompat() {
    }

    @Nullable
    @VisibleForTesting
    @RestrictTo({Scope.LIBRARY_GROUP})
    public static ProviderInfo a(@NonNull PackageManager packageManager, @NonNull a aVar, @Nullable Resources resources) {
        int i = 0;
        String a = aVar.a();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a, 0);
        if (resolveContentProvider == null) {
            throw new NameNotFoundException("No package found for authority: " + a);
        } else if (resolveContentProvider.packageName.equals(aVar.b())) {
            List a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a2, e);
            List a3 = a(aVar, resources);
            while (true) {
                int i2 = i;
                if (i2 >= a3.size()) {
                    return null;
                }
                List arrayList = new ArrayList((Collection) a3.get(i2));
                Collections.sort(arrayList, e);
                if (a(a2, arrayList)) {
                    return resolveContentProvider;
                }
                i = i2 + 1;
            }
        } else {
            throw new NameNotFoundException("Found content provider " + a + ", but package was not " + aVar.b());
        }
    }

    /* JADX WARNING: Missing block: B:37:0x0093, code:
            b.a(r4, new android.support.v4.provider.FontsContractCompat.AnonymousClass3());
     */
    /* JADX WARNING: Missing block: B:41:?, code:
            return r2;
     */
    /* JADX WARNING: Missing block: B:43:?, code:
            return r2;
     */
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static android.graphics.Typeface a(final android.content.Context r6, final android.support.v4.provider.a r7, @android.support.annotation.Nullable final android.support.v4.content.res.e r8, @android.support.annotation.Nullable final android.os.Handler r9, boolean r10, int r11, final int r12) {
        /*
        r2 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r7.f();
        r0 = r0.append(r1);
        r1 = "-";
        r0 = r0.append(r1);
        r0 = r0.append(r12);
        r3 = r0.toString();
        r0 = a;
        r0 = r0.get(r3);
        r0 = (android.graphics.Typeface) r0;
        if (r0 == 0) goto L_0x002d;
    L_0x0026:
        if (r8 == 0) goto L_0x002b;
    L_0x0028:
        r8.a(r0);
    L_0x002b:
        r2 = r0;
    L_0x002c:
        return r2;
    L_0x002d:
        if (r10 == 0) goto L_0x004a;
    L_0x002f:
        r0 = -1;
        if (r11 != r0) goto L_0x004a;
    L_0x0032:
        r0 = b(r6, r7, r12);
        if (r8 == 0) goto L_0x0041;
    L_0x0038:
        r1 = r0.b;
        if (r1 != 0) goto L_0x0044;
    L_0x003c:
        r1 = r0.a;
        r8.a(r1, r9);
    L_0x0041:
        r2 = r0.a;
        goto L_0x002c;
    L_0x0044:
        r1 = r0.b;
        r8.a(r1, r9);
        goto L_0x0041;
    L_0x004a:
        r4 = new android.support.v4.provider.FontsContractCompat$1;
        r4.<init>(r6, r7, r12, r3);
        if (r10 == 0) goto L_0x005c;
    L_0x0051:
        r0 = b;	 Catch:{ InterruptedException -> 0x009e }
        r0 = r0.a(r4, r11);	 Catch:{ InterruptedException -> 0x009e }
        r0 = (android.support.v4.provider.c) r0;	 Catch:{ InterruptedException -> 0x009e }
        r2 = r0.a;	 Catch:{ InterruptedException -> 0x009e }
        goto L_0x002c;
    L_0x005c:
        if (r8 != 0) goto L_0x007c;
    L_0x005e:
        r1 = r2;
    L_0x005f:
        r5 = c;
        monitor-enter(r5);
        r0 = d;	 Catch:{ all -> 0x0079 }
        r0 = r0.containsKey(r3);	 Catch:{ all -> 0x0079 }
        if (r0 == 0) goto L_0x0083;
    L_0x006a:
        if (r1 == 0) goto L_0x0077;
    L_0x006c:
        r0 = d;	 Catch:{ all -> 0x0079 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0079 }
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x0079 }
        r0.add(r1);	 Catch:{ all -> 0x0079 }
    L_0x0077:
        monitor-exit(r5);	 Catch:{ all -> 0x0079 }
        goto L_0x002c;
    L_0x0079:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0079 }
        throw r0;
    L_0x007c:
        r0 = new android.support.v4.provider.FontsContractCompat$2;
        r0.<init>(r8, r9);
        r1 = r0;
        goto L_0x005f;
    L_0x0083:
        if (r1 == 0) goto L_0x0092;
    L_0x0085:
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0079 }
        r0.<init>();	 Catch:{ all -> 0x0079 }
        r0.add(r1);	 Catch:{ all -> 0x0079 }
        r1 = d;	 Catch:{ all -> 0x0079 }
        r1.put(r3, r0);	 Catch:{ all -> 0x0079 }
    L_0x0092:
        monitor-exit(r5);	 Catch:{ all -> 0x0079 }
        r0 = b;
        r1 = new android.support.v4.provider.FontsContractCompat$3;
        r1.<init>(r3);
        r0.a(r4, r1);
        goto L_0x002c;
    L_0x009e:
        r0 = move-exception;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.FontsContractCompat.a(android.content.Context, android.support.v4.provider.a, android.support.v4.content.res.e, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    @NonNull
    public static FontFamilyResult a(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull a aVar) {
        ProviderInfo a = a(context.getPackageManager(), aVar, context.getResources());
        return a == null ? new FontFamilyResult(1, null) : new FontFamilyResult(0, a(context, aVar, a.authority, cancellationSignal));
    }

    private static List<List<byte[]>> a(a aVar, Resources resources) {
        return aVar.d() != null ? aVar.d() : FontResourcesParserCompat.a(resources, aVar.e());
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        List<byte[]> arrayList = new ArrayList();
        for (Signature toByteArray : signatureArr) {
            arrayList.add(toByteArray.toByteArray());
        }
        return arrayList;
    }

    @RequiresApi(19)
    @RestrictTo({Scope.LIBRARY_GROUP})
    public static Map<Uri, ByteBuffer> a(Context context, b[] bVarArr, CancellationSignal cancellationSignal) {
        Map hashMap = new HashMap();
        for (b bVar : bVarArr) {
            if (bVar.e() == 0) {
                Uri a = bVar.a();
                if (!hashMap.containsKey(a)) {
                    hashMap.put(a, h.a(context, cancellationSignal, a));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0146  */
    @android.support.annotation.VisibleForTesting
    @android.support.annotation.NonNull
    static android.support.v4.provider.b[] a(android.content.Context r18, android.support.v4.provider.a r19, java.lang.String r20, android.os.CancellationSignal r21) {
        /*
        r11 = new java.util.ArrayList;
        r11.<init>();
        r2 = new android.net.Uri$Builder;
        r2.<init>();
        r3 = "content";
        r2 = r2.scheme(r3);
        r0 = r20;
        r2 = r2.authority(r0);
        r3 = r2.build();
        r2 = new android.net.Uri$Builder;
        r2.<init>();
        r4 = "content";
        r2 = r2.scheme(r4);
        r0 = r20;
        r2 = r2.authority(r0);
        r4 = "file";
        r2 = r2.appendPath(r4);
        r12 = r2.build();
        r9 = 0;
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0153 }
        r4 = 16;
        if (r2 <= r4) goto L_0x00f4;
    L_0x003c:
        r2 = r18.getContentResolver();	 Catch:{ all -> 0x0153 }
        r4 = 7;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0153 }
        r5 = 0;
        r6 = "_id";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = 1;
        r6 = "file_id";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = 2;
        r6 = "font_ttc_index";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = 3;
        r6 = "font_variation_settings";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = 4;
        r6 = "font_weight";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = 5;
        r6 = "font_italic";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = 6;
        r6 = "result_code";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = "query = ?";
        r6 = 1;
        r6 = new java.lang.String[r6];	 Catch:{ all -> 0x0153 }
        r7 = 0;
        r8 = r19.c();	 Catch:{ all -> 0x0153 }
        r6[r7] = r8;	 Catch:{ all -> 0x0153 }
        r7 = 0;
        r8 = r21;
        r10 = r2.query(r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0153 }
    L_0x0079:
        if (r10 == 0) goto L_0x0143;
    L_0x007b:
        r2 = r10.getCount();	 Catch:{ all -> 0x00ec }
        if (r2 <= 0) goto L_0x0143;
    L_0x0081:
        r2 = "result_code";
        r11 = r10.getColumnIndex(r2);	 Catch:{ all -> 0x00ec }
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x00ec }
        r2.<init>();	 Catch:{ all -> 0x00ec }
        r4 = "_id";
        r13 = r10.getColumnIndex(r4);	 Catch:{ all -> 0x00ec }
        r4 = "file_id";
        r14 = r10.getColumnIndex(r4);	 Catch:{ all -> 0x00ec }
        r4 = "font_ttc_index";
        r15 = r10.getColumnIndex(r4);	 Catch:{ all -> 0x00ec }
        r4 = "font_weight";
        r16 = r10.getColumnIndex(r4);	 Catch:{ all -> 0x00ec }
        r4 = "font_italic";
        r17 = r10.getColumnIndex(r4);	 Catch:{ all -> 0x00ec }
    L_0x00aa:
        r4 = r10.moveToNext();	 Catch:{ all -> 0x00ec }
        if (r4 == 0) goto L_0x0144;
    L_0x00b0:
        r4 = -1;
        if (r11 == r4) goto L_0x0131;
    L_0x00b3:
        r9 = r10.getInt(r11);	 Catch:{ all -> 0x00ec }
    L_0x00b7:
        r4 = -1;
        if (r15 == r4) goto L_0x0133;
    L_0x00ba:
        r6 = r10.getInt(r15);	 Catch:{ all -> 0x00ec }
    L_0x00be:
        r4 = -1;
        if (r14 != r4) goto L_0x0135;
    L_0x00c1:
        r4 = r10.getLong(r13);	 Catch:{ all -> 0x00ec }
        r5 = android.content.ContentUris.withAppendedId(r3, r4);	 Catch:{ all -> 0x00ec }
    L_0x00c9:
        r4 = -1;
        r0 = r16;
        if (r0 == r4) goto L_0x013e;
    L_0x00ce:
        r0 = r16;
        r7 = r10.getInt(r0);	 Catch:{ all -> 0x00ec }
    L_0x00d4:
        r4 = -1;
        r0 = r17;
        if (r0 == r4) goto L_0x0141;
    L_0x00d9:
        r0 = r17;
        r4 = r10.getInt(r0);	 Catch:{ all -> 0x00ec }
        r8 = 1;
        if (r4 != r8) goto L_0x0141;
    L_0x00e2:
        r8 = 1;
    L_0x00e3:
        r4 = new android.support.v4.provider.b;	 Catch:{ all -> 0x00ec }
        r4.<init>(r5, r6, r7, r8, r9);	 Catch:{ all -> 0x00ec }
        r2.add(r4);	 Catch:{ all -> 0x00ec }
        goto L_0x00aa;
    L_0x00ec:
        r2 = move-exception;
        r3 = r10;
    L_0x00ee:
        if (r3 == 0) goto L_0x00f3;
    L_0x00f0:
        r3.close();
    L_0x00f3:
        throw r2;
    L_0x00f4:
        r2 = r18.getContentResolver();	 Catch:{ all -> 0x0153 }
        r4 = 7;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0153 }
        r5 = 0;
        r6 = "_id";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = 1;
        r6 = "file_id";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = 2;
        r6 = "font_ttc_index";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = 3;
        r6 = "font_variation_settings";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = 4;
        r6 = "font_weight";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = 5;
        r6 = "font_italic";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = 6;
        r6 = "result_code";
        r4[r5] = r6;	 Catch:{ all -> 0x0153 }
        r5 = "query = ?";
        r6 = 1;
        r6 = new java.lang.String[r6];	 Catch:{ all -> 0x0153 }
        r7 = 0;
        r8 = r19.c();	 Catch:{ all -> 0x0153 }
        r6[r7] = r8;	 Catch:{ all -> 0x0153 }
        r7 = 0;
        r10 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0153 }
        goto L_0x0079;
    L_0x0131:
        r9 = 0;
        goto L_0x00b7;
    L_0x0133:
        r6 = 0;
        goto L_0x00be;
    L_0x0135:
        r4 = r10.getLong(r14);	 Catch:{ all -> 0x00ec }
        r5 = android.content.ContentUris.withAppendedId(r12, r4);	 Catch:{ all -> 0x00ec }
        goto L_0x00c9;
    L_0x013e:
        r7 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        goto L_0x00d4;
    L_0x0141:
        r8 = 0;
        goto L_0x00e3;
    L_0x0143:
        r2 = r11;
    L_0x0144:
        if (r10 == 0) goto L_0x0149;
    L_0x0146:
        r10.close();
    L_0x0149:
        r3 = 0;
        r3 = new android.support.v4.provider.b[r3];
        r2 = r2.toArray(r3);
        r2 = (android.support.v4.provider.b[]) r2;
        return r2;
    L_0x0153:
        r2 = move-exception;
        r3 = r9;
        goto L_0x00ee;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.FontsContractCompat.a(android.content.Context, android.support.v4.provider.a, java.lang.String, android.os.CancellationSignal):android.support.v4.provider.b[]");
    }

    @NonNull
    private static c b(Context context, a aVar, int i) {
        int i2 = -3;
        try {
            FontFamilyResult a = a(context, null, aVar);
            if (a.a() == 0) {
                Typeface a2 = TypefaceCompat.a(context, null, a.b(), i);
                if (a2 != null) {
                    i2 = 0;
                }
                return new c(a2, i2);
            }
            if (a.a() == 1) {
                i2 = -2;
            }
            return new c(null, i2);
        } catch (NameNotFoundException e) {
            return new c(null, -1);
        }
    }
}
