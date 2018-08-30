package com.google.firebase.messaging;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.regex.Pattern;

public class a {
    private static final Pattern a = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private static a b;
    private final FirebaseInstanceId c;

    private a(FirebaseInstanceId firebaseInstanceId) {
        this.c = firebaseInstanceId;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a(FirebaseInstanceId.a());
            }
            aVar = b;
        }
        return aVar;
    }

    public void a(String str) {
        Object str2;
        if (str2 != null && str2.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in subscribeToTopic.");
            str2 = str2.substring(8);
        }
        if (str2 == null || !a.matcher(str2).matches()) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str2).length() + 78).append("Invalid topic name: ").append(str2).append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}").toString());
        }
        FirebaseInstanceId firebaseInstanceId = this.c;
        String valueOf = String.valueOf("S!");
        String valueOf2 = String.valueOf(str2);
        firebaseInstanceId.a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }
}
