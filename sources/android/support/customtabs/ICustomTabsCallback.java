package android.support.customtabs;

import android.os.Bundle;
import android.os.IInterface;

public interface ICustomTabsCallback extends IInterface {
    void extraCallback(String str, Bundle bundle);

    void onMessageChannelReady(Bundle bundle);

    void onNavigationEvent(int i, Bundle bundle);

    void onPostMessage(String str, Bundle bundle);
}
