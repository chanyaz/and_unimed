package com.fasterxml.jackson.databind.jsonschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Deprecated
public class JsonSchema {
    private final ObjectNode schema;

    public static JsonNode getDefaultSchemaNode() {
        JsonNode objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.put("type", "any");
        return objectNode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof JsonSchema)) {
            return false;
        }
        JsonSchema jsonSchema = (JsonSchema) obj;
        return this.schema == null ? jsonSchema.schema == null : this.schema.equals(jsonSchema.schema);
    }

    public int hashCode() {
        return this.schema.hashCode();
    }

    public String toString() {
        return this.schema.toString();
    }
}
