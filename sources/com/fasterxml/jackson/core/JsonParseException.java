package com.fasterxml.jackson.core;

public class JsonParseException extends JsonProcessingException {
    private static final long serialVersionUID = 2;
    protected JsonParser _processor;

    public JsonParseException(JsonParser jsonParser, String str) {
        super(str, jsonParser == null ? null : jsonParser.getCurrentLocation());
        this._processor = jsonParser;
    }

    public JsonParseException(JsonParser jsonParser, String str, JsonLocation jsonLocation) {
        super(str, jsonLocation);
        this._processor = jsonParser;
    }

    public JsonParseException(JsonParser jsonParser, String str, Throwable th) {
        super(str, jsonParser == null ? null : jsonParser.getCurrentLocation(), th);
        this._processor = jsonParser;
    }

    public JsonParser getProcessor() {
        return this._processor;
    }
}
