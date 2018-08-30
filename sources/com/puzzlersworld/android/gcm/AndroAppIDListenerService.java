package com.puzzlersworld.android.gcm;

import android.preference.PreferenceManager;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class AndroAppIDListenerService extends FirebaseInstanceIdService {
    public void a() {
        new b(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(this)).a();
    }
}
