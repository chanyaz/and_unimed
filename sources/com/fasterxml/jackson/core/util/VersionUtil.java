package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import java.util.regex.Pattern;

public class VersionUtil {
    private static final Pattern V_SEP = Pattern.compile("[-_./;:]");
    private final Version _v;

    protected VersionUtil() {
        Version version = null;
        try {
            version = versionFor(getClass());
        } catch (Exception e) {
            System.err.println("ERROR: Failed to load Version information from " + getClass());
        }
        if (version == null) {
            version = Version.unknownVersion();
        }
        this._v = version;
    }

    public static Version packageVersionFor(Class<?> cls) {
        Version version;
        Class cls2;
        try {
            cls2 = Class.forName(cls.getPackage().getName() + ".PackageVersion", true, cls.getClassLoader());
            version = ((Versioned) cls2.newInstance()).version();
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to get Versioned out of " + cls2);
        } catch (Exception e2) {
            version = null;
        }
        return version == null ? Version.unknownVersion() : version;
    }

    public static Version parseVersion(String str, String str2, String str3) {
        int i = 0;
        if (str != null) {
            CharSequence trim = str.trim();
            if (trim.length() > 0) {
                String[] split = V_SEP.split(trim);
                int parseVersionPart = parseVersionPart(split[0]);
                int parseVersionPart2 = split.length > 1 ? parseVersionPart(split[1]) : 0;
                if (split.length > 2) {
                    i = parseVersionPart(split[2]);
                }
                return new Version(parseVersionPart, parseVersionPart2, i, split.length > 3 ? split[3] : null, str2, str3);
            }
        }
        return Version.unknownVersion();
    }

    protected static int parseVersionPart(String str) {
        int i = 0;
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt > '9' || charAt < '0') {
                break;
            }
            i2 = (i2 * 10) + (charAt - 48);
            i++;
        }
        return i2;
    }

    public static final void throwInternal() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }

    public static Version versionFor(Class<?> cls) {
        Version packageVersionFor = packageVersionFor(cls);
        return packageVersionFor == null ? Version.unknownVersion() : packageVersionFor;
    }
}
