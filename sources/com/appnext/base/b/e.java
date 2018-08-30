package com.appnext.base.b;

import com.appnext.base.a.a;
import com.appnext.base.a.b.c;
import java.util.List;

public class e {
    private static volatile e jR;

    private e() {
    }

    public static e cy() {
        if (jR == null) {
            synchronized (e.class) {
                if (jR == null) {
                    jR = new e();
                }
            }
        }
        return jR;
    }

    public c av(String str) {
        return a.aM().aR().ac(str);
    }

    public List<c> cz() {
        return a.aM().aR().bm();
    }
}
