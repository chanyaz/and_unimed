package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import java.util.List;

public interface ICustomTabsService extends IInterface {
    Bundle extraCommand(String str, Bundle bundle);

    boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list);

    boolean newSession(ICustomTabsCallback iCustomTabsCallback);

    int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle);

    boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri);

    boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle);

    boolean warmup(long j);
}
