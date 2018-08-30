package android.support.v7.widget;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import com.appnext.base.b.c;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class p extends AsyncTask<Object, Void, Void> {
    final /* synthetic */ ActivityChooserModel a;

    p(ActivityChooserModel activityChooserModel) {
        this.a = activityChooserModel;
    }

    /* renamed from: a */
    public Void doInBackground(Object... objArr) {
        int i = 0;
        List list = (List) objArr[0];
        String str = (String) objArr[1];
        try {
            OutputStream openFileOutput = this.a.b.openFileOutput(str, 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                newSerializer.setOutput(openFileOutput, null);
                newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                newSerializer.startTag(null, "historical-records");
                int size = list.size();
                while (i < size) {
                    o oVar = (o) list.remove(0);
                    newSerializer.startTag(null, "historical-record");
                    newSerializer.attribute(null, "activity", oVar.a.flattenToString());
                    newSerializer.attribute(null, c.ju, String.valueOf(oVar.b));
                    newSerializer.attribute(null, "weight", String.valueOf(oVar.c));
                    newSerializer.endTag(null, "historical-record");
                    i++;
                }
                newSerializer.endTag(null, "historical-records");
                newSerializer.endDocument();
                this.a.d = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable e2) {
                Log.e(ActivityChooserModel.a, "Error writing historical record file: " + this.a.c, e2);
                this.a.d = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(ActivityChooserModel.a, "Error writing historical record file: " + this.a.c, e22);
                this.a.d = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable e222) {
                Log.e(ActivityChooserModel.a, "Error writing historical record file: " + this.a.c, e222);
                this.a.d = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                this.a.d = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e6) {
                    }
                }
            }
        } catch (Throwable e2222) {
            Log.e(ActivityChooserModel.a, "Error writing historical record file: " + str, e2222);
        }
        return null;
    }
}
