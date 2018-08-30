package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.appnext.base.b.c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class ActivityChooserModel extends DataSetObservable {
    static final String a = ActivityChooserModel.class.getSimpleName();
    private static final Object e = new Object();
    private static final Map<String, ActivityChooserModel> f = new HashMap();
    final Context b;
    final String c;
    boolean d = true;
    private final Object g = new Object();
    private final List<m> h = new ArrayList();
    private final List<o> i = new ArrayList();
    private Intent j;
    private ActivitySorter k = new n();
    private int l = 50;
    private boolean m = false;
    private boolean n = true;
    private boolean o = false;
    private OnChooseActivityListener p;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public interface ActivitySorter {
        void sort(Intent intent, List<m> list, List<o> list2);
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    private ActivityChooserModel(Context context, String str) {
        this.b = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.c = str;
        } else {
            this.c = str + ".xml";
        }
    }

    public static ActivityChooserModel a(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (e) {
            activityChooserModel = (ActivityChooserModel) f.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                f.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    private boolean a(o oVar) {
        boolean add = this.i.add(oVar);
        if (add) {
            this.n = true;
            i();
            d();
            f();
            notifyChanged();
        }
        return add;
    }

    private void d() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.n) {
            this.n = false;
            if (!TextUtils.isEmpty(this.c)) {
                new p(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.i), this.c});
            }
        }
    }

    private void e() {
        int g = g() | h();
        i();
        if (g != 0) {
            f();
            notifyChanged();
        }
    }

    private boolean f() {
        if (this.k == null || this.j == null || this.h.isEmpty() || this.i.isEmpty()) {
            return false;
        }
        this.k.sort(this.j, this.h, Collections.unmodifiableList(this.i));
        return true;
    }

    private boolean g() {
        if (!this.o || this.j == null) {
            return false;
        }
        this.o = false;
        this.h.clear();
        List queryIntentActivities = this.b.getPackageManager().queryIntentActivities(this.j, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.h.add(new m((ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean h() {
        if (!this.d || !this.n || TextUtils.isEmpty(this.c)) {
            return false;
        }
        this.d = false;
        this.m = true;
        j();
        return true;
    }

    private void i() {
        int size = this.i.size() - this.l;
        if (size > 0) {
            this.n = true;
            for (int i = 0; i < size; i++) {
                o oVar = (o) this.i.remove(0);
            }
        }
    }

    private void j() {
        try {
            InputStream openFileInput = this.b.openFileInput(this.c);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.i;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput != null) {
                                try {
                                    openFileInput.close();
                                    return;
                                } catch (IOException e) {
                                    return;
                                }
                            }
                            return;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new o(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, c.ju)), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(a, "Error reading historical recrod file: " + this.c, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(a, "Error reading historical recrod file: " + this.c, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }

    public int a() {
        int size;
        synchronized (this.g) {
            e();
            size = this.h.size();
        }
        return size;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.g) {
            e();
            List list = this.h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((m) list.get(i)).a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.g) {
            e();
            resolveInfo = ((m) this.h.get(i)).a;
        }
        return resolveInfo;
    }

    public Intent b(int i) {
        synchronized (this.g) {
            if (this.j == null) {
                return null;
            }
            e();
            m mVar = (m) this.h.get(i);
            ComponentName componentName = new ComponentName(mVar.a.activityInfo.packageName, mVar.a.activityInfo.name);
            Intent intent = new Intent(this.j);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new o(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.g) {
            e();
            if (this.h.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((m) this.h.get(0)).a;
            return resolveInfo;
        }
    }

    public int c() {
        int size;
        synchronized (this.g) {
            e();
            size = this.i.size();
        }
        return size;
    }

    public void c(int i) {
        synchronized (this.g) {
            e();
            m mVar = (m) this.h.get(i);
            m mVar2 = (m) this.h.get(0);
            a(new o(new ComponentName(mVar.a.activityInfo.packageName, mVar.a.activityInfo.name), System.currentTimeMillis(), mVar2 != null ? (mVar2.b - mVar.b) + 5.0f : 1.0f));
        }
    }
}
