package com.google.android.exoplayer.smoothstreaming;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.upstream.UriLoadable.Parser;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class SmoothStreamingManifestParser implements Parser<a> {
    private final XmlPullParserFactory a;

    public class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super("Missing required field: " + str);
        }
    }

    public SmoothStreamingManifestParser() {
        try {
            this.a = XmlPullParserFactory.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* renamed from: a */
    public a parse(String str, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.a.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (a) new g(null, str).a(newPullParser);
        } catch (Throwable e) {
            throw new ParserException(e);
        }
    }
}
