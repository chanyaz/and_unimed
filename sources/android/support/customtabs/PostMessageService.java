package android.support.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class PostMessageService extends Service {
    private l a = new l() {
        public void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            iCustomTabsCallback.onMessageChannelReady(bundle);
        }

        public void onPostMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            iCustomTabsCallback.onPostMessage(str, bundle);
        }
    };

    public IBinder onBind(Intent intent) {
        return this.a;
    }
}
