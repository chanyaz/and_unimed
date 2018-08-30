package android.support.multidex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

final class b {
    private b() {
    }

    private static Object[] a(Object obj, ArrayList<File> arrayList, File file) {
        return (Object[]) a.b(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file});
    }

    private static void b(ClassLoader classLoader, List<File> list, File file) {
        Object obj = a.b(classLoader, "pathList").get(classLoader);
        a.b(obj, "dexElements", a(obj, new ArrayList(list), file));
    }
}
