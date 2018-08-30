package com.squareup.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.InputStream;

@TargetApi(14)
class f {
    private f() {
    }

    static InputStream a(ContentResolver contentResolver, Uri uri) {
        return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }
}
