package okhttp3.internal;

import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.Call;
import okhttp3.ad;
import okhttp3.ah;
import okhttp3.ak;
import okhttp3.i;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.f;
import okhttp3.j;
import okhttp3.r;
import okhttp3.z;

public abstract class a {
    public static a a;

    public abstract int a(ah ahVar);

    public abstract Socket a(i iVar, okhttp3.a aVar, f fVar);

    public abstract Call a(z zVar, ad adVar);

    public abstract c a(i iVar, okhttp3.a aVar, f fVar, ak akVar);

    public abstract d a(i iVar);

    public abstract f a(Call call);

    public abstract void a(j jVar, SSLSocket sSLSocket, boolean z);

    public abstract void a(r rVar, String str);

    public abstract void a(r rVar, String str, String str2);

    public abstract boolean a(okhttp3.a aVar, okhttp3.a aVar2);

    public abstract boolean a(i iVar, c cVar);

    public abstract void b(i iVar, c cVar);
}
