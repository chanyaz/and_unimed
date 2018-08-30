package com.google.android.gms.internal.measurement;

import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

class bc<T extends zzbr> extends ae {
    private zzbt<T> a;

    public bc(ah ahVar, zzbt<T> zzbt) {
        super(ahVar);
        this.a = zzbt;
    }

    private final T a(XmlResourceParser xmlResourceParser) {
        Object attributeValue;
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    String trim;
                    Object trim2;
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            this.a.zzb(toLowerCase, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || trim == null)) {
                            this.a.zzc(attributeValue, trim);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim2 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(trim2))) {
                            try {
                                this.a.zza(attributeValue, Boolean.parseBoolean(trim2));
                            } catch (NumberFormatException e) {
                                c("Error parsing bool configuration value", trim2, e);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim2 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim2))) {
                            try {
                                this.a.zzb(toLowerCase, Integer.parseInt(trim2));
                            } catch (NumberFormatException e2) {
                                c("Error parsing int configuration value", trim2, e2);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            attributeValue = e3;
        } catch (IOException e4) {
            attributeValue = e4;
        }
        return this.a.zzdr();
        e("Error parsing tracker configuration file", attributeValue);
        return this.a.zzdr();
    }

    public final T a(int i) {
        try {
            return a(h().b().getResources().getXml(i));
        } catch (NotFoundException e) {
            d("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
