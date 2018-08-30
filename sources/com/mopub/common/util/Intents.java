package com.mopub.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.UrlAction;
import com.mopub.common.logging.MoPubLog;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;

public class Intents {
    private Intents() {
    }

    public static boolean canHandleApplicationUrl(Context context, Uri uri) {
        return canHandleApplicationUrl(context, uri, true);
    }

    public static boolean canHandleApplicationUrl(Context context, Uri uri, boolean z) {
        if (deviceCanHandleIntent(context, new Intent("android.intent.action.VIEW", uri))) {
            return true;
        }
        if (z) {
            MoPubLog.w("Could not handle application specific action: " + uri + ". " + "You may be running in the emulator or another device which does not " + "have the required application.");
        }
        return false;
    }

    public static boolean deviceCanHandleIntent(@NonNull Context context, @NonNull Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static Intent getStartActivityIntent(@NonNull Context context, @NonNull Class cls, @Nullable Bundle bundle) {
        Intent intent = new Intent(context, cls);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    public static Intent intentForNativeBrowserScheme(@NonNull Uri uri) {
        Preconditions.checkNotNull(uri);
        if (!UrlAction.OPEN_NATIVE_BROWSER.shouldTryHandlingUrl(uri)) {
            throw new UrlParseException("URL does not have mopubnativebrowser:// scheme.");
        } else if ("navigate".equals(uri.getHost())) {
            try {
                String queryParameter = uri.getQueryParameter("url");
                if (queryParameter == null) {
                    throw new UrlParseException("URL missing 'url' query parameter.");
                }
                return new Intent("android.intent.action.VIEW", Uri.parse(queryParameter));
            } catch (UnsupportedOperationException e) {
                MoPubLog.w("Could not handle url: " + uri);
                throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
            }
        } else {
            throw new UrlParseException("URL missing 'navigate' host parameter.");
        }
    }

    public static Intent intentForShareTweet(@NonNull Uri uri) {
        if (UrlAction.HANDLE_SHARE_TWEET.shouldTryHandlingUrl(uri)) {
            try {
                CharSequence queryParameter = uri.getQueryParameter("screen_name");
                CharSequence queryParameter2 = uri.getQueryParameter("tweet_id");
                if (TextUtils.isEmpty(queryParameter)) {
                    throw new UrlParseException("URL missing non-empty 'screen_name' query parameter.");
                } else if (TextUtils.isEmpty(queryParameter2)) {
                    throw new UrlParseException("URL missing non-empty 'tweet_id' query parameter.");
                } else {
                    String format = String.format("https://twitter.com/%s/status/%s", new Object[]{queryParameter, queryParameter2});
                    String format2 = String.format("Check out @%s's Tweet: %s", new Object[]{queryParameter, format});
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.SUBJECT", format2);
                    intent.putExtra("android.intent.extra.TEXT", format2);
                    return intent;
                }
            } catch (UnsupportedOperationException e) {
                MoPubLog.w("Could not handle url: " + uri);
                throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
            }
        }
        throw new UrlParseException("URL does not have mopubshare://tweet? format.");
    }

    public static void launchActionViewIntent(Context context, @NonNull Uri uri, @NonNull String str) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        launchIntentForUserClick(context, intent, str);
    }

    public static void launchApplicationUrl(@NonNull Context context, @NonNull Uri uri) {
        if (canHandleApplicationUrl(context, uri)) {
            launchActionViewIntent(context, uri, "Unable to open intent for: " + uri);
            return;
        }
        throw new IntentNotResolvableException("Could not handle application specific action: " + uri + "\n\tYou may be running in the emulator or another " + "device which does not have the required application.");
    }

    public static void launchIntentForUserClick(@NonNull Context context, @NonNull Intent intent, @Nullable String str) {
        NoThrow.checkNotNull(context);
        NoThrow.checkNotNull(intent);
        try {
            startActivity(context, intent);
        } catch (IntentNotResolvableException e) {
            throw new IntentNotResolvableException(str + "\n" + e.getMessage());
        }
    }

    public static void showMoPubBrowserForUrl(@NonNull Context context, @NonNull Uri uri, @Nullable String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        MoPubLog.d("Final URI to show in browser: " + uri);
        Bundle bundle = new Bundle();
        bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, uri.toString());
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, str);
        }
        launchIntentForUserClick(context, getStartActivityIntent(context, MoPubBrowser.class, bundle), "Could not show MoPubBrowser for url: " + uri + "\n\tPerhaps you " + "forgot to declare com.mopub.common.MoPubBrowser in your Android manifest file.");
    }

    public static void startActivity(@NonNull Context context, @NonNull Intent intent) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(intent);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (Throwable e) {
            throw new IntentNotResolvableException(e);
        }
    }
}
