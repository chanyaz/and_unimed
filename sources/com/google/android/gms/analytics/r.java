package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

@VisibleForTesting
public abstract class r<T extends r> {
    public static String a(Object obj) {
        return a(obj, 0);
    }

    private static String a(Object obj, int i) {
        if (i > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj) ? "" : obj.toString();
        } else {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue() == 0 ? "" : obj.toString();
            } else {
                if (obj instanceof Long) {
                    return ((Long) obj).longValue() == 0 ? "" : obj.toString();
                } else {
                    if (obj instanceof Double) {
                        return ((Double) obj).doubleValue() == 0.0d ? "" : obj.toString();
                    } else {
                        if (obj instanceof Boolean) {
                            return !((Boolean) obj).booleanValue() ? "" : obj.toString();
                        } else {
                            int length;
                            if (obj instanceof List) {
                                StringBuilder stringBuilder = new StringBuilder();
                                if (i > 0) {
                                    stringBuilder.append("[");
                                }
                                List list = (List) obj;
                                length = stringBuilder.length();
                                for (Object next : list) {
                                    if (stringBuilder.length() > length) {
                                        stringBuilder.append(", ");
                                    }
                                    stringBuilder.append(a(next, i + 1));
                                }
                                if (i > 0) {
                                    stringBuilder.append("]");
                                }
                                return stringBuilder.toString();
                            } else if (!(obj instanceof Map)) {
                                return obj.toString();
                            } else {
                                StringBuilder stringBuilder2 = new StringBuilder();
                                length = 0;
                                Object obj2 = null;
                                for (Entry entry : new TreeMap((Map) obj).entrySet()) {
                                    Object a = a(entry.getValue(), i + 1);
                                    if (!TextUtils.isEmpty(a)) {
                                        if (i > 0 && obj2 == null) {
                                            stringBuilder2.append("{");
                                            obj2 = 1;
                                            length = stringBuilder2.length();
                                        }
                                        if (stringBuilder2.length() > length) {
                                            stringBuilder2.append(", ");
                                        }
                                        stringBuilder2.append((String) entry.getKey());
                                        stringBuilder2.append('=');
                                        stringBuilder2.append(a);
                                    }
                                }
                                if (obj2 != null) {
                                    stringBuilder2.append("}");
                                }
                                return stringBuilder2.toString();
                            }
                        }
                    }
                }
            }
        }
    }

    public static String a(Map map) {
        return a(map, 1);
    }

    public abstract void a(T t);
}
