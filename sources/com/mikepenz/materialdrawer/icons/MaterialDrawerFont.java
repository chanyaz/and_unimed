package com.mikepenz.materialdrawer.icons;

import android.content.Context;
import android.graphics.Typeface;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class MaterialDrawerFont implements ITypeface {
    private static Typeface a = null;
    private static HashMap<String, Character> b;

    public enum Icon implements IIcon {
        mdf_arrow_drop_down(58821),
        mdf_arrow_drop_up(58823),
        mdf_expand_less(58830),
        mdf_expand_more(58831),
        mdf_person(59389);
        
        private static ITypeface g;
        char f;

        private Icon(char c) {
            this.f = c;
        }

        public char getCharacter() {
            return this.f;
        }

        public String getFormattedName() {
            return "{" + name() + "}";
        }

        public String getName() {
            return name();
        }

        public ITypeface getTypeface() {
            if (g == null) {
                g = new MaterialDrawerFont();
            }
            return g;
        }
    }

    public String getAuthor() {
        return "";
    }

    public HashMap<String, Character> getCharacters() {
        if (b == null) {
            HashMap hashMap = new HashMap();
            for (Icon icon : Icon.values()) {
                hashMap.put(icon.name(), Character.valueOf(icon.f));
            }
            b = hashMap;
        }
        return b;
    }

    public String getDescription() {
        return "";
    }

    public String getFontName() {
        return "MaterialDrawerFont";
    }

    public IIcon getIcon(String str) {
        return Icon.valueOf(str);
    }

    public int getIconCount() {
        return b.size();
    }

    public Collection<String> getIcons() {
        Collection<String> linkedList = new LinkedList();
        for (Icon name : Icon.values()) {
            linkedList.add(name.name());
        }
        return linkedList;
    }

    public String getLicense() {
        return "";
    }

    public String getLicenseUrl() {
        return "";
    }

    public String getMappingPrefix() {
        return "mdf";
    }

    public Typeface getTypeface(Context context) {
        if (a == null) {
            try {
                a = Typeface.createFromAsset(context.getAssets(), "fonts/materialdrawerfont-font-v5.0.0.ttf");
            } catch (Exception e) {
                return null;
            }
        }
        return a;
    }

    public String getUrl() {
        return "";
    }

    public String getVersion() {
        return "5.0.0";
    }
}
