package com.google.ads.consent;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings.Secure;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.Log;
import com.appnext.base.b.c;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class ConsentInformation {
    private static final String CONSENT_DATA_KEY = "consent_string";
    private static final String MOBILE_ADS_SERVER_URL = "https://adservice.google.com/getconfig/pubvendors";
    private static final String PREFERENCES_FILE_KEY = "mobileads_consent";
    private static final String TAG = "ConsentInformation";
    private static ConsentInformation instance;
    private final Context context;
    private DebugGeography debugGeography = DebugGeography.DEBUG_GEOGRAPHY_DISABLED;
    private String hashedDeviceId = f();
    private List<String> testDevices = new ArrayList();

    class AdNetworkLookupResponse {
        @SerializedName("company_ids")
        private List<String> companyIds;
        @SerializedName("ad_network_id")
        private String id;
        @SerializedName("is_npa")
        private boolean isNPA;
        @SerializedName("lookup_failed")
        private boolean lookupFailed;
        @SerializedName("not_found")
        private boolean notFound;

        private AdNetworkLookupResponse() {
        }
    }

    class ConsentInfoUpdateResponse {
        String responseInfo;
        boolean success;

        ConsentInfoUpdateResponse(boolean z, String str) {
            this.success = z;
            this.responseInfo = str;
        }
    }

    class ConsentInfoUpdateTask extends AsyncTask<Void, Void, ConsentInfoUpdateResponse> {
        private static final String UPDATE_SUCCESS = "Consent update successful.";
        private final ConsentInformation consentInformation;
        private final ConsentInfoUpdateListener listener;
        private final List<String> publisherIds;
        private final String url;

        private ConsentInfoUpdateResponse a(String str) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                if (httpURLConnection.getResponseCode() != 200) {
                    return new ConsentInfoUpdateResponse(false, httpURLConnection.getResponseMessage());
                }
                String a = a(httpURLConnection.getInputStream());
                httpURLConnection.disconnect();
                this.consentInformation.a(a, this.publisherIds);
                return new ConsentInfoUpdateResponse(true, UPDATE_SUCCESS);
            } catch (Exception e) {
                return new ConsentInfoUpdateResponse(false, e.getLocalizedMessage());
            }
        }

        private String a(InputStream inputStream) {
            byte[] bArr = new byte[c.jk];
            StringBuilder stringBuilder = new StringBuilder();
            InputStream bufferedInputStream = new BufferedInputStream(inputStream);
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        stringBuilder.append(new String(bArr, 0, read));
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            Log.e(ConsentInformation.TAG, e.getLocalizedMessage());
                        }
                    }
                } catch (IOException e2) {
                    Log.e(ConsentInformation.TAG, e2.getLocalizedMessage());
                    try {
                        bufferedInputStream.close();
                        return null;
                    } catch (IOException e3) {
                        Log.e(ConsentInformation.TAG, e3.getLocalizedMessage());
                        return null;
                    }
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e32) {
                        Log.e(ConsentInformation.TAG, e32.getLocalizedMessage());
                    }
                    throw th;
                }
            }
            bufferedInputStream.close();
            return stringBuilder.toString();
        }

        /* renamed from: a */
        public ConsentInfoUpdateResponse doInBackground(Void... voidArr) {
            String join = TextUtils.join(",", this.publisherIds);
            ConsentData c = this.consentInformation.c();
            Builder appendQueryParameter = Uri.parse(this.url).buildUpon().appendQueryParameter("pubs", join).appendQueryParameter("es", "2").appendQueryParameter("plat", c.g()).appendQueryParameter("v", c.f());
            if (this.consentInformation.a() && this.consentInformation.b() != DebugGeography.DEBUG_GEOGRAPHY_DISABLED) {
                appendQueryParameter = appendQueryParameter.appendQueryParameter("debug_geo", this.consentInformation.b().a().toString());
            }
            return a(appendQueryParameter.build().toString());
        }

        /* renamed from: a */
        protected void onPostExecute(ConsentInfoUpdateResponse consentInfoUpdateResponse) {
            if (consentInfoUpdateResponse.success) {
                this.listener.onConsentInfoUpdated(this.consentInformation.e());
            } else {
                this.listener.onFailedToUpdateConsentInfo(consentInfoUpdateResponse.responseInfo);
            }
        }
    }

    @VisibleForTesting
    public class ServerResponse {
        @SerializedName("ad_network_ids")
        List<AdNetworkLookupResponse> adNetworkLookupResponses;
        List<AdProvider> companies;
        @SerializedName("is_request_in_eea_or_unknown")
        Boolean isRequestLocationInEeaOrUnknown;

        protected ServerResponse() {
        }
    }

    private ConsentInformation(Context context) {
        this.context = context.getApplicationContext();
    }

    public static synchronized ConsentInformation a(Context context) {
        ConsentInformation consentInformation;
        synchronized (ConsentInformation.class) {
            if (instance == null) {
                instance = new ConsentInformation(context);
            }
            consentInformation = instance;
        }
        return consentInformation;
    }

    private String a(String str) {
        String str2 = null;
        int i = 0;
        while (i < 3) {
            try {
                MessageDigest.getInstance("MD5").update(str.getBytes());
                str2 = String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r2.digest())});
                break;
            } catch (NoSuchAlgorithmException e) {
                i++;
            } catch (ArithmeticException e2) {
            }
        }
        return str2;
    }

    private HashSet<AdProvider> a(List<AdProvider> list, HashSet<String> hashSet) {
        Collection arrayList = new ArrayList();
        for (AdProvider adProvider : list) {
            if (hashSet.contains(adProvider.a())) {
                arrayList.add(adProvider);
            }
        }
        return new HashSet(arrayList);
    }

    private void a(ConsentData consentData) {
        Editor edit = this.context.getSharedPreferences(PREFERENCES_FILE_KEY, 0).edit();
        edit.putString(CONSENT_DATA_KEY, new Gson().toJson((Object) consentData));
        edit.apply();
    }

    private void a(ServerResponse serverResponse) {
        if (serverResponse.isRequestLocationInEeaOrUnknown == null) {
            throw new Exception("Could not parse Event FE preflight response.");
        } else if (serverResponse.companies == null && serverResponse.isRequestLocationInEeaOrUnknown.booleanValue()) {
            throw new Exception("Could not parse Event FE preflight response.");
        } else if (serverResponse.isRequestLocationInEeaOrUnknown.booleanValue()) {
            Iterable hashSet = new HashSet();
            Iterable hashSet2 = new HashSet();
            for (AdNetworkLookupResponse adNetworkLookupResponse : serverResponse.adNetworkLookupResponses) {
                if (adNetworkLookupResponse.lookupFailed) {
                    hashSet.add(adNetworkLookupResponse.id);
                }
                if (adNetworkLookupResponse.notFound) {
                    hashSet2.add(adNetworkLookupResponse.id);
                }
            }
            if (!hashSet.isEmpty() || !hashSet2.isEmpty()) {
                String join;
                StringBuilder stringBuilder = new StringBuilder("Response error.");
                if (!hashSet.isEmpty()) {
                    join = TextUtils.join(",", hashSet);
                    stringBuilder.append(String.format(" Lookup failure for: %s.", new Object[]{join}));
                }
                if (!hashSet2.isEmpty()) {
                    join = TextUtils.join(",", hashSet2);
                    stringBuilder.append(String.format(" Publisher Ids not found: %s", new Object[]{join}));
                }
                throw new Exception(stringBuilder.toString());
            }
        }
    }

    private synchronized void a(String str, List<String> list) {
        boolean z;
        ServerResponse serverResponse = (ServerResponse) new Gson().fromJson(str, ServerResponse.class);
        a(serverResponse);
        HashSet hashSet = new HashSet();
        if (serverResponse.adNetworkLookupResponses != null) {
            boolean z2 = false;
            for (AdNetworkLookupResponse adNetworkLookupResponse : serverResponse.adNetworkLookupResponses) {
                if (adNetworkLookupResponse.isNPA) {
                    Collection e = adNetworkLookupResponse.companyIds;
                    if (e != null) {
                        hashSet.addAll(e);
                    }
                    z2 = true;
                }
            }
            z = z2;
        } else {
            z = false;
        }
        HashSet hashSet2 = serverResponse.companies == null ? new HashSet() : z ? a(serverResponse.companies, hashSet) : new HashSet(serverResponse.companies);
        ConsentData c = c();
        Object obj = c.e() != z ? 1 : null;
        c.b(z);
        c.b(str);
        c.b(new HashSet(list));
        c.a(hashSet2);
        c.a(serverResponse.isRequestLocationInEeaOrUnknown.booleanValue());
        if (serverResponse.isRequestLocationInEeaOrUnknown.booleanValue()) {
            if (!(c.a().equals(c.d()) && obj == null)) {
                c.a("sdk");
                c.a(ConsentStatus.UNKNOWN);
                c.c(new HashSet());
            }
            a(c);
        } else {
            a(c);
        }
    }

    private String f() {
        ContentResolver contentResolver = this.context.getContentResolver();
        String string = contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
        if (string == null || g()) {
            string = "emulator";
        }
        return a(string);
    }

    private boolean g() {
        return Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || ((Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT));
    }

    protected synchronized void a(ConsentStatus consentStatus, String str) {
        ConsentData c = c();
        if (consentStatus == ConsentStatus.UNKNOWN) {
            c.c(new HashSet());
        } else {
            c.c(c.a());
        }
        c.a(str);
        c.a(consentStatus);
        a(c);
    }

    public boolean a() {
        return g() || this.testDevices.contains(this.hashedDeviceId);
    }

    public DebugGeography b() {
        return this.debugGeography;
    }

    protected ConsentData c() {
        String string = this.context.getSharedPreferences(PREFERENCES_FILE_KEY, 0).getString(CONSENT_DATA_KEY, "");
        return TextUtils.isEmpty(string) ? new ConsentData() : (ConsentData) new Gson().fromJson(string, ConsentData.class);
    }

    public boolean d() {
        return c().c();
    }

    public synchronized ConsentStatus e() {
        return c().b();
    }
}
