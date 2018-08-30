package com.mopub.network;

import android.support.annotation.Nullable;
import com.mopub.common.util.ResponseHeader;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class HeaderUtils {
    private static Integer a(String str) {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        instance.setParseIntegerOnly(true);
        try {
            return Integer.valueOf(instance.parse(str.trim()).intValue());
        } catch (Exception e) {
            return null;
        }
    }

    private static boolean a(@Nullable String str, boolean z) {
        return str == null ? z : str.equals("1");
    }

    @Nullable
    private static Integer b(@Nullable String str) {
        if (str == null) {
            return null;
        }
        Integer a = a(str.replace("%", ""));
        return (a == null || a.intValue() < 0 || a.intValue() > 100) ? null : a;
    }

    public static boolean extractBooleanHeader(Map<String, String> map, ResponseHeader responseHeader, boolean z) {
        return a(extractHeader((Map) map, responseHeader), z);
    }

    public static boolean extractBooleanHeader(HttpResponse httpResponse, ResponseHeader responseHeader, boolean z) {
        return a(extractHeader(httpResponse, responseHeader), z);
    }

    @Nullable
    public static String extractHeader(Map<String, String> map, ResponseHeader responseHeader) {
        return (String) map.get(responseHeader.getKey());
    }

    public static String extractHeader(HttpResponse httpResponse, ResponseHeader responseHeader) {
        Header firstHeader = httpResponse.getFirstHeader(responseHeader.getKey());
        return firstHeader != null ? firstHeader.getValue() : null;
    }

    public static int extractIntHeader(HttpResponse httpResponse, ResponseHeader responseHeader, int i) {
        Integer extractIntegerHeader = extractIntegerHeader(httpResponse, responseHeader);
        return extractIntegerHeader == null ? i : extractIntegerHeader.intValue();
    }

    public static Integer extractIntegerHeader(Map<String, String> map, ResponseHeader responseHeader) {
        return a(extractHeader((Map) map, responseHeader));
    }

    public static Integer extractIntegerHeader(HttpResponse httpResponse, ResponseHeader responseHeader) {
        return a(extractHeader(httpResponse, responseHeader));
    }

    public static Integer extractPercentHeader(Map<String, String> map, ResponseHeader responseHeader) {
        return b(extractHeader((Map) map, responseHeader));
    }

    @Nullable
    public static String extractPercentHeaderString(Map<String, String> map, ResponseHeader responseHeader) {
        Integer extractPercentHeader = extractPercentHeader(map, responseHeader);
        return extractPercentHeader != null ? extractPercentHeader.toString() : null;
    }
}
