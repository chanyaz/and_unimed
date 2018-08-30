package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.widget.ActivityChooserModel.ActivitySorter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class n implements ActivitySorter {
    private final Map<ComponentName, m> a = new HashMap();

    n() {
    }

    public void sort(Intent intent, List<m> list, List<o> list2) {
        Map map = this.a;
        map.clear();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m mVar = (m) list.get(i);
            mVar.b = 0.0f;
            map.put(new ComponentName(mVar.a.activityInfo.packageName, mVar.a.activityInfo.name), mVar);
        }
        float f = 1.0f;
        int size2 = list2.size() - 1;
        while (size2 >= 0) {
            float f2;
            o oVar = (o) list2.get(size2);
            m mVar2 = (m) map.get(oVar.a);
            if (mVar2 != null) {
                mVar2.b = (oVar.c * f) + mVar2.b;
                f2 = 0.95f * f;
            } else {
                f2 = f;
            }
            size2--;
            f = f2;
        }
        Collections.sort(list);
    }
}
