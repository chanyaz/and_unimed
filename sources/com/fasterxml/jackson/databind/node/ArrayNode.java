package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayNode extends ContainerNode<ArrayNode> {
    private final List<JsonNode> _children = new ArrayList();

    public ArrayNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
    }

    protected ArrayNode _add(JsonNode jsonNode) {
        this._children.add(jsonNode);
        return this;
    }

    protected JsonNode _at(JsonPointer jsonPointer) {
        return get(jsonPointer.getMatchingIndex());
    }

    public ArrayNode add(JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        _add(jsonNode);
        return this;
    }

    public ArrayNode add(String str) {
        return str == null ? addNull() : _add(textNode(str));
    }

    public ArrayNode addNull() {
        _add(nullNode());
        return this;
    }

    public JsonToken asToken() {
        return JsonToken.START_ARRAY;
    }

    public Iterator<JsonNode> elements() {
        return this._children.iterator();
    }

    public boolean equals(Object obj) {
        return obj == this ? true : (obj == null || !(obj instanceof ArrayNode)) ? false : this._children.equals(((ArrayNode) obj)._children);
    }

    public JsonNode get(int i) {
        return (i < 0 || i >= this._children.size()) ? null : (JsonNode) this._children.get(i);
    }

    public JsonNode get(String str) {
        return null;
    }

    public JsonNodeType getNodeType() {
        return JsonNodeType.ARRAY;
    }

    public int hashCode() {
        return this._children.hashCode();
    }

    public boolean isEmpty(SerializerProvider serializerProvider) {
        return this._children.isEmpty();
    }

    public JsonNode path(int i) {
        return (i < 0 || i >= this._children.size()) ? MissingNode.getInstance() : (JsonNode) this._children.get(i);
    }

    public JsonNode path(String str) {
        return MissingNode.getInstance();
    }

    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        List list = this._children;
        int size = list.size();
        jsonGenerator.writeStartArray(size);
        for (int i = 0; i < size; i++) {
            JsonNode jsonNode = (JsonNode) list.get(i);
            if (jsonNode instanceof BaseJsonNode) {
                ((BaseJsonNode) jsonNode).serialize(jsonGenerator, serializerProvider);
            } else {
                jsonNode.serialize(jsonGenerator, serializerProvider);
            }
        }
        jsonGenerator.writeEndArray();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.writeTypePrefixForArray(this, jsonGenerator);
        for (JsonNode jsonNode : this._children) {
            ((BaseJsonNode) jsonNode).serialize(jsonGenerator, serializerProvider);
        }
        typeSerializer.writeTypeSuffixForArray(this, jsonGenerator);
    }

    public int size() {
        return this._children.size();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder((size() << 4) + 16);
        stringBuilder.append('[');
        int size = this._children.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(((JsonNode) this._children.get(i)).toString());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
