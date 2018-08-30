package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter;

public class DefaultIndenter extends NopIndenter {
    public static final DefaultIndenter SYSTEM_LINEFEED_INSTANCE = new DefaultIndenter("  ", SYS_LF);
    public static final String SYS_LF;
    private static final long serialVersionUID = 1;
    private final int charsPerLevel;
    private final String eol;
    private final char[] indents;

    static {
        String property;
        try {
            property = System.getProperty("line.separator");
        } catch (Throwable th) {
            property = "\n";
        }
        SYS_LF = property;
    }

    public DefaultIndenter() {
        this("  ", SYS_LF);
    }

    public DefaultIndenter(String str, String str2) {
        this.charsPerLevel = str.length();
        this.indents = new char[(str.length() * 16)];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            str.getChars(0, str.length(), this.indents, i);
            i += str.length();
        }
        this.eol = str2;
    }

    public boolean isInline() {
        return false;
    }

    public void writeIndentation(JsonGenerator jsonGenerator, int i) {
        jsonGenerator.writeRaw(this.eol);
        if (i > 0) {
            int i2 = this.charsPerLevel * i;
            while (i2 > this.indents.length) {
                jsonGenerator.writeRaw(this.indents, 0, this.indents.length);
                i2 -= this.indents.length;
            }
            jsonGenerator.writeRaw(this.indents, 0, i2);
        }
    }
}
