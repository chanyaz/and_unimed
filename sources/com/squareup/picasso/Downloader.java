package com.squareup.picasso;

import android.net.Uri;
import java.io.IOException;

public interface Downloader {

    public class ResponseException extends IOException {
        final boolean a;
        final int b;

        public ResponseException(String str, int i, int i2) {
            super(str);
            this.a = NetworkPolicy.c(i);
            this.b = i2;
        }
    }

    m load(Uri uri, int i);

    void shutdown();
}
