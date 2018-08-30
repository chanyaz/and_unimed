package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ObjectNode extends ContainerNode<ObjectNode> {
    protected final Map<String, JsonNode> _children = new LinkedHashMap();

    public ObjectNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
    }

    protected JsonNode _at(JsonPointer jsonPointer) {
        return get(jsonPointer.getMatchingProperty());
    }

    protected boolean _childrenEqual(ObjectNode objectNode) {
        return this._children.equals(objectNode._children);
    }

    protected ObjectNode _put(String str, JsonNode jsonNode) {
        this._children.put(str, jsonNode);
        return this;
    }

    public JsonToken asToken() {
        return JsonToken.START_OBJECT;
    }

    public Iterator<JsonNode> elements() {
        return this._children.values().iterator();
    }

    public boolean equals(Object obj) {
        return obj == this ? true : (obj == null || !(obj instanceof ObjectNode)) ? false : _childrenEqual((ObjectNode) obj);
    }

    public Iterator<String> fieldNames() {
        return this._children.keySet().iterator();
    }

    public Iterator<Entry<String, JsonNode>> fields() {
        return this._children.entrySet().iterator();
    }

    public JsonNode get(int i) {
        return null;
    }

    public JsonNode get(String str) {
        return (JsonNode) this._children.get(str);
    }

    public JsonNodeType getNodeType() {
        return JsonNodeType.OBJECT;
    }

    public int hashCode() {
        return this._children.hashCode();
    }

    public boolean isEmpty(SerializerProvider serializerProvider) {
        return this._children.isEmpty();
    }

    public JsonNode path(int i) {
        return MissingNode.getInstance();
    }

    public JsonNode path(String str) {
        JsonNode jsonNode = (JsonNode) this._children.get(str);
        return jsonNode != null ? jsonNode : MissingNode.getInstance();
    }

    public ObjectNode put(String str, String str2) {
        return _put(str, str2 == null ? nullNode() : textNode(str2));
    }

    public ObjectNode put(String str, boolean z) {
        return _put(str, booleanNode(z));
    }

    public ArrayNode putArray(String str) {
        JsonNode arrayNode = arrayNode();
        _put(str, arrayNode);
        return arrayNode;
    }

    public JsonNode replace(String str, JsonNode jsonNode) {
        Object jsonNode2;
        if (jsonNode2 == null) {
            jsonNode2 = nullNode();
        }
        return (JsonNode) this._children.put(str, jsonNode2);
    }

    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeStartObject();
        for (Entry entry : this._children.entrySet()) {
            jsonGenerator.writeFieldName((String) entry.getKey());
            ((BaseJsonNode) entry.getValue()).serialize(jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndObject();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.writeTypePrefixForObject(this, jsonGenerator);
        for (Entry entry : this._children.entrySet()) {
            jsonGenerator.writeFieldName((String) entry.getKey());
            ((BaseJsonNode) entry.getValue()).serialize(jsonGenerator, serializerProvider);
        }
        typeSerializer.writeTypeSuffixForObject(this, jsonGenerator);
    }

    public JsonNode set(String str, JsonNode jsonNode) {
        Object jsonNode2;
        if (jsonNode2 == null) {
            jsonNode2 = nullNode();
        }
        this._children.put(str, jsonNode2);
        return this;
    }

    public int size() {
        return this._children.size();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder((size() << 4) + 32);
        stringBuilder.append("{");
        int i = 0;
        for (Entry entry : this._children.entrySet()) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            int i2 = i + 1;
            TextNode.appendQuoted(stringBuilder, (String) entry.getKey());
            stringBuilder.append(':');
            stringBuilder.append(((JsonNode) entry.getValue()).toString());
            i = i2;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
