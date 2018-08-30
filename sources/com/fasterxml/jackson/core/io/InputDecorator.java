package com.fasterxml.jackson.core.io;

import java.io.Reader;
import java.io.Serializable;

public abstract class InputDecorator implements Serializable {
    private static final long serialVersionUID = 1;

    public abstract Reader decorate(IOContext iOContext, Reader reader);
}
