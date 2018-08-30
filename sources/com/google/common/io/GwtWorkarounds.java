package com.google.common.io;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class GwtWorkarounds {

    interface ByteInput {
        void close();

        int read();
    }

    interface ByteOutput {
        void close();

        void flush();

        void write(byte b);
    }

    interface CharInput {
        void close();

        int read();
    }

    interface CharOutput {
        void close();

        void flush();

        void write(char c);
    }

    private GwtWorkarounds() {
    }
}
