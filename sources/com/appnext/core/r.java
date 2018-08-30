package com.appnext.core;

import android.os.AsyncTask;
import java.net.HttpRetryException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public abstract class r {
    protected static final String mp = "https://cdn.appnext.com/tools/sdk/config/2.3.0";
    protected HashMap<String, Object> mq = null;
    private ArrayList<a> mr;
    private int state = 0;

    public interface a {
        void a(HashMap<String, Object> hashMap);

        void error(String str);
    }

    class b extends AsyncTask<Object, Void, String> {
        private b() {
        }

        /* renamed from: a */
        protected String doInBackground(Object... objArr) {
            try {
                return g.a((String) objArr[0], (HashMap) objArr[1]);
            } catch (HttpRetryException e) {
                return "error: " + e.getReason();
            } catch (Throwable e2) {
                g.c(e2);
                return "error: network problem";
            } catch (Throwable th) {
                return "error: Internal error";
            }
        }

        /* renamed from: aU */
        protected void onPostExecute(String str) {
            super.onPostExecute(str);
            if (str == null) {
                r.this.state = 0;
                r.this.aT("unknown error");
            } else if (str.startsWith("error:")) {
                r.this.state = 0;
                r.this.aT(str.substring("error: ".length()));
            } else {
                try {
                    Map o = r.this.o(str);
                    if (r.this.mq == null) {
                        r.this.mq = o;
                    } else {
                        r.this.mq.putAll(o);
                    }
                    r.this.state = 2;
                    r.this.d(r.this.mq);
                } catch (Throwable th) {
                    g.X(str);
                    g.X("error " + th.getMessage());
                    r.this.state = 0;
                    r.this.aT("parsing error");
                }
                g.X("finished loading config");
            }
        }
    }

    private void aT(String str) {
        synchronized ("https://cdn.appnext.com/tools/sdk/config/2.3.0") {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mr);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.error(str);
                }
            }
            this.mr.clear();
        }
    }

    private void d(HashMap<String, Object> hashMap) {
        synchronized ("https://cdn.appnext.com/tools/sdk/config/2.3.0") {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mr);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(hashMap);
            }
            this.mr.clear();
        }
    }

    protected abstract HashMap<String, String> D();

    protected abstract HashMap<String, String> E();

    public synchronized void a(a aVar) {
        if (this.mr == null) {
            this.mr = new ArrayList();
        }
        if (this.state != 2) {
            if (this.state == 0) {
                this.state = 1;
                g.X("start loading config from " + getUrl());
                new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{getUrl(), D()});
            }
            if (aVar != null) {
                this.mr.add(aVar);
            }
        } else if (aVar != null) {
            aVar.a(this.mq);
        }
    }

    public void b(String str, String str2) {
        if (this.mq == null) {
            this.mq = new HashMap();
        }
        this.mq.put(str, str2);
    }

    public HashMap<String, Object> dj() {
        return this.mq;
    }

    public String get(String str) {
        return dj() != null ? E().containsKey(str) ? get(str, (String) E().get(str)) : getValue(str) : E().containsKey(str) ? (String) E().get(str) : null;
    }

    public String get(String str, String str2) {
        return getValue(str) == null ? str2 : getValue(str);
    }

    protected abstract String getUrl();

    public String getValue(String str) {
        return (dj() != null && dj().containsKey(str)) ? (String) dj().get(str) : null;
    }

    public boolean isLoaded() {
        return this.state == 2;
    }

    protected HashMap<String, Object> o(String str) {
        HashMap<String, Object> hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            String string = jSONObject.getString(str2);
            try {
                JSONObject jSONObject2 = new JSONObject(string);
                Iterator keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String str3 = (String) keys2.next();
                    hashMap.put(str2 + "_" + str3, jSONObject2.getString(str3));
                }
            } catch (Throwable th) {
                hashMap.put(str2, string);
            }
        }
        return hashMap;
    }
}
