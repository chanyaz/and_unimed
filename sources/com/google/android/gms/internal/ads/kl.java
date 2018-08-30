package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzadh
public final class kl implements zzamx {
    @Nullable
    private final String a;

    public kl() {
        this(null);
    }

    public kl(@Nullable String str) {
        this.a = str;
    }

    @WorkerThread
    public final void zzcz(String str) {
        String valueOf;
        HttpURLConnection httpURLConnection;
        try {
            String str2 = "Pinging URL: ";
            valueOf = String.valueOf(str);
            kk.b(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            akc.a();
            kb.a(true, httpURLConnection, this.a);
            ke keVar = new ke();
            keVar.a(httpURLConnection, null);
            int responseCode = httpURLConnection.getResponseCode();
            keVar.a(httpURLConnection, responseCode);
            if (responseCode < 200 || responseCode >= 300) {
                kk.e(new StringBuilder(String.valueOf(str).length() + 65).append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(str).toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            valueOf = e.getMessage();
            kk.e(new StringBuilder((String.valueOf(str).length() + 32) + String.valueOf(valueOf).length()).append("Error while parsing ping URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (IOException e2) {
            valueOf = e2.getMessage();
            kk.e(new StringBuilder((String.valueOf(str).length() + 27) + String.valueOf(valueOf).length()).append("Error while pinging URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (RuntimeException e3) {
            valueOf = e3.getMessage();
            kk.e(new StringBuilder((String.valueOf(str).length() + 27) + String.valueOf(valueOf).length()).append("Error while pinging URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
