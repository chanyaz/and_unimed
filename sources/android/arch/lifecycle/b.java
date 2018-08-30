package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class b {
    final Map<Event, List<c>> a = new HashMap();
    final Map<c, Event> b;

    b(Map<c, Event> map) {
        this.b = map;
        for (Entry entry : map.entrySet()) {
            Event event = (Event) entry.getValue();
            List list = (List) this.a.get(event);
            if (list == null) {
                list = new ArrayList();
                this.a.put(event, list);
            }
            list.add(entry.getKey());
        }
    }

    private static void a(List<c> list, LifecycleOwner lifecycleOwner, Event event, Object obj) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((c) list.get(size)).a(lifecycleOwner, event, obj);
            }
        }
    }

    void a(LifecycleOwner lifecycleOwner, Event event, Object obj) {
        a((List) this.a.get(event), lifecycleOwner, event, obj);
        a((List) this.a.get(Event.ON_ANY), lifecycleOwner, event, obj);
    }
}
