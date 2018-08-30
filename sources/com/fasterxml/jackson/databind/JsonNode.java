package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class JsonNode extends Base implements TreeNode, Iterable<JsonNode> {
    protected JsonNode() {
    }

    protected abstract JsonNode _at(JsonPointer jsonPointer);

    public abstract String asText();

    public final JsonNode at(JsonPointer jsonPointer) {
        if (jsonPointer.matches()) {
            return this;
        }
        JsonNode _at = _at(jsonPointer);
        return _at == null ? MissingNode.getInstance() : _at.at(jsonPointer.tail());
    }

    public final JsonNode at(String str) {
        return at(JsonPointer.compile(str));
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.ZERO;
    }

    public byte[] binaryValue() {
        return null;
    }

    public BigDecimal decimalValue() {
        return BigDecimal.ZERO;
    }

    public double doubleValue() {
        return 0.0d;
    }

    public Iterator<JsonNode> elements() {
        return ClassUtil.emptyIterator();
    }

    public Iterator<String> fieldNames() {
        return ClassUtil.emptyIterator();
    }

    public Iterator<Entry<String, JsonNode>> fields() {
        return ClassUtil.emptyIterator();
    }

    public abstract JsonNode get(int i);

    public JsonNode get(String str) {
        return null;
    }

    public abstract JsonNodeType getNodeType();

    public int intValue() {
        return 0;
    }

    public final boolean isArray() {
        return getNodeType() == JsonNodeType.ARRAY;
    }

    public final boolean isBinary() {
        return getNodeType() == JsonNodeType.BINARY;
    }

    public final boolean isContainerNode() {
        JsonNodeType nodeType = getNodeType();
        return nodeType == JsonNodeType.OBJECT || nodeType == JsonNodeType.ARRAY;
    }

    public final boolean isMissingNode() {
        return getNodeType() == JsonNodeType.MISSING;
    }

    public final boolean isNumber() {
        return getNodeType() == JsonNodeType.NUMBER;
    }

    public final boolean isObject() {
        return getNodeType() == JsonNodeType.OBJECT;
    }

    public final boolean isPojo() {
        return getNodeType() == JsonNodeType.POJO;
    }

    public final boolean isValueNode() {
        switch (getNodeType()) {
            case ARRAY:
            case OBJECT:
            case MISSING:
                return false;
            default:
                return true;
        }
    }

    public final Iterator<JsonNode> iterator() {
        return elements();
    }

    public long longValue() {
        return 0;
    }

    public Number numberValue() {
        return null;
    }

    public abstract JsonNode path(int i);

    public abstract JsonNode path(String str);

    public int size() {
        return 0;
    }

    public String textValue() {
        return null;
    }

    public abstract String toString();
}
