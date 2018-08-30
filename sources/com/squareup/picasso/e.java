package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import com.squareup.picasso.Picasso.LoadedFrom;
import java.io.InputStream;

class e extends af {
    private static final UriMatcher a = new UriMatcher(-1);
    private final Context b;

    static {
        a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        a.addURI("com.android.contacts", "contacts/#/photo", 2);
        a.addURI("com.android.contacts", "contacts/#", 3);
        a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    e(Context context) {
        this.b = context;
    }

    private InputStream b(ac acVar) {
        ContentResolver contentResolver = this.b.getContentResolver();
        Uri uri = acVar.d;
        switch (a.match(uri)) {
            case 1:
                uri = Contacts.lookupContact(contentResolver, uri);
                if (uri == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
                return contentResolver.openInputStream(uri);
            case 3:
                break;
            default:
                throw new IllegalStateException("Invalid uri: " + uri);
        }
        return VERSION.SDK_INT < 14 ? Contacts.openContactPhotoInputStream(contentResolver, uri) : f.a(contentResolver, uri);
    }

    public ag a(ac acVar, int i) {
        InputStream b = b(acVar);
        return b != null ? new ag(b, LoadedFrom.DISK) : null;
    }

    public boolean a(ac acVar) {
        Uri uri = acVar.d;
        return "content".equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && a.match(acVar.d) != -1;
    }
}
