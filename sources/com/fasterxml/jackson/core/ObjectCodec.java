package com.fasterxml.jackson.core;

public abstract class ObjectCodec extends TreeCodec implements Versioned {
    protected ObjectCodec() {
    }

    public JsonFactory getFactory() {
        return getJsonFactory();
    }

    @Deprecated
    public JsonFactory getJsonFactory() {
        return getFactory();
    }

    public abstract <T extends TreeNode> T readTree(JsonParser jsonParser);

    public abstract <T> T treeToValue(TreeNode treeNode, Class<T> cls);

    public Version version() {
        return Version.unknownVersion();
    }

    public abstract void writeValue(JsonGenerator jsonGenerator, Object obj);
}
