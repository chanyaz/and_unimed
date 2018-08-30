package com.mopub.common;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.util.AsyncTasks;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@VisibleForTesting
public class UrlResolutionTask extends AsyncTask<String, Void, String> {
    @NonNull
    private final UrlResolutionListener a;

    interface UrlResolutionListener {
        void onFailure(@NonNull String str, @Nullable Throwable th);

        void onSuccess(@NonNull String str);
    }

    UrlResolutionTask(@NonNull UrlResolutionListener urlResolutionListener) {
        this.a = urlResolutionListener;
    }

    @Nullable
    @VisibleForTesting
    static String a(@NonNull String str, @NonNull HttpURLConnection httpURLConnection) {
        URI uri = new URI(str);
        int responseCode = httpURLConnection.getResponseCode();
        String headerField = httpURLConnection.getHeaderField("Location");
        if (responseCode < 300 || responseCode >= 400) {
            return null;
        }
        try {
            return uri.resolve(headerField).toString();
        } catch (IllegalArgumentException e) {
            throw new URISyntaxException(headerField, "Unable to parse invalid URL");
        }
    }

    @Nullable
    private String b(@NonNull String str) {
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                String a = a(str, httpURLConnection2);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return a;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                httpURLConnection = httpURLConnection2;
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static void getResolvedUrl(@NonNull String str, @NonNull UrlResolutionListener urlResolutionListener) {
        try {
            AsyncTasks.safeExecuteOnExecutor(new UrlResolutionTask(urlResolutionListener), str);
        } catch (Throwable e) {
            urlResolutionListener.onFailure("Failed to resolve url", e);
        }
    }

    @Nullable
    /* renamed from: a */
    protected String doInBackground(@Nullable String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        try {
            int i = 0;
            String str = strArr[0];
            String str2 = null;
            while (str != null && i < 10) {
                if (!UrlAction.OPEN_IN_APP_BROWSER.shouldTryHandlingUrl(Uri.parse(str))) {
                    return str;
                }
                i++;
                str2 = str;
                str = b(str);
            }
            return str2;
        } catch (IOException e) {
            return null;
        } catch (URISyntaxException e2) {
            return null;
        }
    }

    /* renamed from: a */
    protected void onPostExecute(@Nullable String str) {
        super.onPostExecute(str);
        if (isCancelled() || str == null) {
            onCancelled();
        } else {
            this.a.onSuccess(str);
        }
    }

    protected void onCancelled() {
        super.onCancelled();
        this.a.onFailure("Task for resolving url was cancelled", null);
    }
}
