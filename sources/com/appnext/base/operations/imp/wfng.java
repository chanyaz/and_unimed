package com.appnext.base.operations.imp;

import android.net.wifi.ScanResult;
import android.os.Bundle;
import com.appnext.base.a.b.c;

public class wfng extends wfpx {
    public wfng(c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    protected String a(ScanResult scanResult) {
        return scanResult.BSSID;
    }

    protected Object al(String str) {
        return str;
    }

    protected boolean bv() {
        return true;
    }

    protected Boolean e(int i) {
        int i2 = 6;
        c bw = bw();
        if (bw != null) {
            i2 = bw.b("level", 6);
        }
        return Boolean.valueOf(i >= i2);
    }
}
