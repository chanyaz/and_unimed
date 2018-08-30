package com.google.android.exoplayer.text;

import java.io.InputStream;

public interface SubtitleParser {
    boolean canParse(String str);

    Subtitle parse(InputStream inputStream, String str, long j);
}
