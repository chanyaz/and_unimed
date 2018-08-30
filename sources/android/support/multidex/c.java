package android.support.multidex;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class c {
    private c() {
    }

    private static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
        return (Object[]) a.b(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
    }

    private static void b(ClassLoader classLoader, List<File> list, File file) {
        Object obj = a.b(classLoader, "pathList").get(classLoader);
        ArrayList arrayList = new ArrayList();
        a.b(obj, "dexElements", a(obj, new ArrayList(list), file, arrayList));
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
            }
            Field a = a.b(classLoader, "dexElementsSuppressedExceptions");
            IOException[] iOExceptionArr = (IOException[]) a.get(classLoader);
            if (iOExceptionArr == null) {
                obj = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
            } else {
                Object obj2 = new IOException[(arrayList.size() + iOExceptionArr.length)];
                arrayList.toArray(obj2);
                System.arraycopy(iOExceptionArr, 0, obj2, arrayList.size(), iOExceptionArr.length);
                obj = obj2;
            }
            a.set(classLoader, obj);
        }
    }
}
