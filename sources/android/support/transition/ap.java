package android.support.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ap {
    public final Map<String, Object> a = new HashMap();
    public View b;
    final ArrayList<Transition> c = new ArrayList();

    public boolean equals(Object obj) {
        return (obj instanceof ap) && this.b == ((ap) obj).b && this.a.equals(((ap) obj).a);
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.b + "\n") + "    values:";
        Iterator it = this.a.keySet().iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            str = (String) it.next();
            str = str2 + "    " + str + ": " + this.a.get(str) + "\n";
        }
    }
}
