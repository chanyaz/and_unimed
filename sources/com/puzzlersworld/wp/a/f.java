package com.puzzlersworld.wp.a;

import android.net.Uri;
import com.google.common.base.ab;
import com.puzzlersworld.wp.dto.Menu;
import com.puzzlersworld.wp.dto.MenuItemType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

public class f {
    public static Menu a(String str, String str2, Set<String> set) {
        for (String str3 : set) {
            String a = a(str, str2, str3 + "/", str3 + "=");
            if (!ab.a(a)) {
                Menu menu = new Menu();
                menu.setMenuItemType(MenuItemType.custom_taxonomy);
                menu.setSlug(a);
                menu.setTaxonomy_name(str3);
                menu.setName("");
                menu.setID(Long.valueOf(-1));
                return menu;
            }
        }
        return null;
    }

    public static String a(String str, String str2) {
        try {
            return new URI(str).getQuery() != null ? str + "&" + str2 : str + "?" + str2;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String a(String str, String str2, String str3, String str4) {
        try {
            URI uri = new URI(str);
            URI uri2 = new URI(str2);
            if (uri2.getHost().equals(uri.getHost())) {
                String path = uri2.getPath();
                String substring;
                if (uri.getPath().startsWith(path + "/" + str3)) {
                    substring = uri.getPath().substring((path.length() + str3.length()) + 1);
                    if (substring.endsWith("/")) {
                        substring = substring.substring(0, substring.length() - 1);
                    }
                    return substring.indexOf("/") != -1 ? substring.substring(substring.indexOf("/") + 1) : substring;
                } else if (uri.getQuery() != null && uri.getQuery().startsWith(str4 + "=")) {
                    substring = uri.getQuery().substring(str4.length() + 1);
                    if (substring.endsWith("/")) {
                        substring = substring.substring(0, substring.length() - 1);
                    }
                    return substring.indexOf("/") != -1 ? substring.substring(substring.indexOf("/") + 1) : substring;
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean a(Uri uri, String str) {
        return uri.getHost().equals(str);
    }

    public static boolean b(Uri uri, String str) {
        return uri.getHost().equals(str) && uri.getPath().length() <= 1 && uri.getQuery() == null;
    }
}
