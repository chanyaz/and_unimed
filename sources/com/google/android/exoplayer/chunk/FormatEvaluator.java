package com.google.android.exoplayer.chunk;

import java.util.List;

public interface FormatEvaluator {
    void disable();

    void enable();

    void evaluate(List<? extends i> list, long j, f[] fVarArr, g gVar);
}
