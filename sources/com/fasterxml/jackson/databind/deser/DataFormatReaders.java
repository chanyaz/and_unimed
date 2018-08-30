package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectReader;

public class DataFormatReaders {
    protected final int _maxInputLookahead;
    protected final MatchStrength _minimalMatch;
    protected final MatchStrength _optimalMatch;
    protected final ObjectReader[] _readers;

    private DataFormatReaders(ObjectReader[] objectReaderArr, MatchStrength matchStrength, MatchStrength matchStrength2, int i) {
        this._readers = objectReaderArr;
        this._optimalMatch = matchStrength;
        this._minimalMatch = matchStrength2;
        this._maxInputLookahead = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        int length = this._readers.length;
        if (length > 0) {
            stringBuilder.append(this._readers[0].getFactory().getFormatName());
            for (int i = 1; i < length; i++) {
                stringBuilder.append(", ");
                stringBuilder.append(this._readers[i].getFactory().getFormatName());
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public DataFormatReaders withType(JavaType javaType) {
        int length = this._readers.length;
        ObjectReader[] objectReaderArr = new ObjectReader[length];
        for (int i = 0; i < length; i++) {
            objectReaderArr[i] = this._readers[i].forType(javaType);
        }
        return new DataFormatReaders(objectReaderArr, this._optimalMatch, this._minimalMatch, this._maxInputLookahead);
    }
}
