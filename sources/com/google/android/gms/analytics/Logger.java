package com.google.android.gms.analytics;

import com.google.android.gms.common.util.VisibleForTesting;

@Deprecated
@VisibleForTesting
public interface Logger {
    @Deprecated
    void error(Exception exception);

    @Deprecated
    void error(String str);

    @Deprecated
    int getLogLevel();

    @Deprecated
    void info(String str);

    @Deprecated
    void setLogLevel(int i);

    @Deprecated
    void verbose(String str);

    @Deprecated
    void warn(String str);
}
