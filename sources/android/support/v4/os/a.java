package android.support.v4.os;

import android.os.Build.VERSION;

public class a {
    private a() {
    }

    @Deprecated
    public static boolean a() {
        return VERSION.SDK_INT >= 27;
    }

    public static boolean b() {
        return VERSION.CODENAME.equals("P");
    }
}
