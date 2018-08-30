package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.upstream.UriLoadable.Parser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

public final class j implements Parser<i> {
    private static final Pattern a = Pattern.compile("BANDWIDTH=(\\d+)\\b");
    private static final Pattern b = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern c = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern d = Pattern.compile("#EXTINF:([\\d.]+)\\b");
    private static final Pattern e = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern f = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern g = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern h = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern i = Pattern.compile("METHOD=(NONE|AES-128)");
    private static final Pattern j = Pattern.compile("URI=\"(.+)\"");
    private static final Pattern k = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern l = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern m = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern n = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern o = h.a("AUTOSELECT");
    private static final Pattern p = h.a("DEFAULT");

    private static e a(k kVar, String str) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int i = -1;
        Object obj = null;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (kVar.a()) {
            String b = kVar.b();
            if (b.startsWith("#EXT-X-MEDIA")) {
                if ("SUBTITLES".equals(h.a(b, l, "TYPE"))) {
                    arrayList2.add(new l(h.a(b, n, "NAME"), h.a(b, j, "URI"), h.a(b, m), h.b(b, p), h.b(b, o)));
                }
            } else if (b.startsWith("#EXT-X-STREAM-INF")) {
                int parseInt;
                int parseInt2;
                int b2 = h.b(b, a, "BANDWIDTH");
                String a = h.a(b, b);
                String a2 = h.a(b, c);
                if (a2 != null) {
                    String[] split = a2.split("x");
                    parseInt = Integer.parseInt(split[0]);
                    if (parseInt <= 0) {
                        parseInt = -1;
                    }
                    parseInt2 = Integer.parseInt(split[1]);
                    if (parseInt2 <= 0) {
                        parseInt2 = -1;
                    }
                } else {
                    parseInt = -1;
                    parseInt2 = -1;
                }
                obj = 1;
                i = parseInt2;
                i2 = parseInt;
                str2 = a;
                i3 = b2;
            } else if (!(b.startsWith("#") || obj == null)) {
                arrayList.add(new n(arrayList.size(), b, i3, str2, i2, i));
                i = -1;
                obj = null;
                i2 = -1;
                str2 = null;
                i3 = 0;
            }
        }
        return new e(str, Collections.unmodifiableList(arrayList), Collections.unmodifiableList(arrayList2));
    }

    private static f b(k kVar, String str) {
        boolean z;
        List arrayList = new ArrayList();
        boolean z2 = false;
        long j = 0;
        int i = -1;
        boolean z3 = false;
        String str2 = null;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        double d = 0.0d;
        String str3 = null;
        while (kVar.a()) {
            String b = kVar.b();
            int b2;
            if (b.startsWith("#EXT-X-TARGETDURATION")) {
                i4 = h.b(b, f, "#EXT-X-TARGETDURATION");
            } else if (b.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                b2 = h.b(b, e, "#EXT-X-MEDIA-SEQUENCE");
                i6 = b2;
                i5 = b2;
            } else if (b.startsWith("#EXT-X-VERSION")) {
                i3 = h.b(b, g, "#EXT-X-VERSION");
            } else if (b.startsWith("#EXTINF")) {
                d = h.c(b, d, "#EXTINF");
            } else if (b.startsWith("#EXT-X-KEY")) {
                String a;
                boolean equals = "AES-128".equals(h.a(b, i, "METHOD"));
                if (equals) {
                    String a2 = h.a(b, j, "URI");
                    a = h.a(b, k);
                    b = a2;
                } else {
                    b = null;
                    a = null;
                }
                str3 = a;
                z3 = equals;
                str2 = b;
            } else if (b.startsWith("#EXT-X-BYTERANGE")) {
                String[] split = h.a(b, h, "#EXT-X-BYTERANGE").split("@");
                i = Integer.parseInt(split[0]);
                i2 = split.length > 1 ? Integer.parseInt(split[1]) : i2;
            } else if (b.equals("#EXT-X-DISCONTINUITY")) {
                z2 = true;
            } else if (!b.startsWith("#")) {
                String toHexString = !z3 ? null : str3 != null ? str3 : Integer.toHexString(i6);
                int i7 = i6 + 1;
                i6 = i == -1 ? 0 : i2;
                arrayList.add(new g(b, d, z2, j, z3, str2, toHexString, i6, i));
                j += (long) (1000000.0d * d);
                z2 = false;
                d = 0.0d;
                b2 = i != -1 ? i6 + i : i6;
                i = -1;
                i6 = i7;
                i2 = b2;
            } else if (b.equals("#EXT-X-ENDLIST")) {
                z = false;
                break;
            }
        }
        z = true;
        return new f(str, i5, i4, i3, z, Collections.unmodifiableList(arrayList));
    }

    /* renamed from: a */
    public i parse(String str, InputStream inputStream) {
        String readLine;
        i a;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        Queue linkedList = new LinkedList();
        loop0:
        while (true) {
            try {
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    readLine = readLine.trim();
                    if (!readLine.isEmpty()) {
                        if (readLine.startsWith("#EXT-X-STREAM-INF")) {
                            linkedList.add(readLine);
                            a = a(new k(linkedList, bufferedReader), str);
                            bufferedReader.close();
                            break loop0;
                        } else if (readLine.startsWith("#EXT-X-TARGETDURATION") || readLine.startsWith("#EXT-X-MEDIA-SEQUENCE") || readLine.startsWith("#EXTINF") || readLine.startsWith("#EXT-X-KEY") || readLine.startsWith("#EXT-X-BYTERANGE") || readLine.equals("#EXT-X-DISCONTINUITY") || readLine.equals("#EXT-X-ENDLIST")) {
                            linkedList.add(readLine);
                            a = b(new k(linkedList, bufferedReader), str);
                        } else {
                            linkedList.add(readLine);
                        }
                    }
                } else {
                    bufferedReader.close();
                    throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                }
            } finally {
                bufferedReader.close();
            }
        }
        linkedList.add(readLine);
        a = b(new k(linkedList, bufferedReader), str);
        return a;
    }
}
