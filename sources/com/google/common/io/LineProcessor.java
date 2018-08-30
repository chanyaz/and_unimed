package com.google.common.io;

import com.google.common.annotations.Beta;

@Beta
public interface LineProcessor<T> {
    T getResult();

    boolean processLine(String str);
}
