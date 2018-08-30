package com.fasterxml.jackson.core.format;

public interface InputAccessor {
    boolean hasMoreBytes();

    byte nextByte();

    void reset();
}
