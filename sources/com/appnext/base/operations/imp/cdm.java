package com.appnext.base.operations.imp;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.appnext.base.a.a;
import com.appnext.base.a.b.b;
import com.appnext.base.a.b.c;
import com.appnext.base.b.d;
import com.appnext.base.b.i;
import com.appnext.base.b.k;
import com.appnext.base.b.l;
import com.appnext.base.operations.e;
import com.appnext.core.g;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class cdm extends e {
    private final String TAG = "cdm";
    private final String gW = "[ { \"status\": \"on\", \"sample\":\"1\", \"sample_type\":\"hour\", \"cycle\":\"1\", \"cycle_type\":\"interval\", \"exact\":\"false\", \"key\":\"cdm\" } ]";

    public cdm(c cVar, Bundle bundle) {
        super(cVar, bundle);
        i.cE().init(d.getContext());
    }

    private void ak(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString(com.appnext.base.a.c.c.gv);
                l.k(" *** new *** ", optString);
                jSONObject.put(com.appnext.base.b.c.jG, optString);
            }
            a.aM().aR().delete();
            a.aM().aR().b(jSONArray);
        } catch (Throwable th) {
            l.n("cdm", th.getMessage());
        }
    }

    protected boolean bz() {
        return false;
    }

    protected List<b> getData() {
        if (!k.q(d.getContext())) {
            String a;
            try {
                a = g.a("http://cdn.appnext.com/tools/services/4.6.9/config.json?packageId=" + d.getContext().getPackageName() + "&dosv=" + VERSION.SDK_INT + "&lvid=" + "4.6.9", null);
            } catch (Throwable e) {
                int responseCode = e.responseCode();
                if (responseCode == 400 || responseCode == 401 || responseCode == 402 || responseCode == 403 || responseCode == 404 || responseCode == 405 || responseCode == 500 || responseCode == 501 || responseCode == 503) {
                    com.appnext.base.b.a(e);
                }
                a = "[ { \"status\": \"on\", \"sample\":\"1\", \"sample_type\":\"hour\", \"cycle\":\"1\", \"cycle_type\":\"interval\", \"exact\":\"false\", \"key\":\"cdm\" } ]";
            } catch (Throwable e2) {
                l.n("cdm", e2.toString());
                a = "[ { \"status\": \"on\", \"sample\":\"1\", \"sample_type\":\"hour\", \"cycle\":\"1\", \"cycle_type\":\"interval\", \"exact\":\"false\", \"key\":\"cdm\" } ]";
            }
            try {
                List bm = a.aM().aR().bm();
                if (bm != null) {
                    com.appnext.base.a.aI().a(bm);
                }
                ak(a);
                com.appnext.base.a.aI().aJ();
            } catch (Throwable e22) {
                com.appnext.base.b.a(e22);
            }
        }
        return null;
    }

    public boolean hasPermission() {
        return true;
    }
}
