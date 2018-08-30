package android.support.customtabs;

import android.os.Bundle;
import android.os.IInterface;

public interface IPostMessageService extends IInterface {
    void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback, Bundle bundle);

    void onPostMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle);
}
