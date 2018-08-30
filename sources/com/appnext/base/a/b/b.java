package com.appnext.base.a.b;

import java.util.Date;

public class b extends d {
    private String gb;
    private String gc;
    private String gd;
    private Date ge;
    private String mDataType;

    public b(String str, String str2, String str3) {
        this(str, str, str2, null, str3);
    }

    public b(String str, String str2, String str3, String str4) {
        this(str, str2, str3, null, str4);
    }

    public b(String str, String str2, String str3, Date date, String str4) {
        this.gb = str;
        this.gc = str2;
        this.gd = str3;
        this.ge = date;
        this.mDataType = str4;
    }

    public String aX() {
        return this.gb;
    }

    public String aY() {
        return this.gd;
    }

    public Date aZ() {
        return this.ge;
    }

    public String getDataType() {
        return this.mDataType;
    }

    public String getType() {
        return this.gc;
    }
}
