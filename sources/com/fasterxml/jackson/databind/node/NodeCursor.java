package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class NodeCursor extends JsonStreamContext {
    protected String _currentName;
    protected Object _currentValue;
    protected final NodeCursor _parent;

    public final class ArrayCursor extends NodeCursor {
        protected Iterator<JsonNode> _contents;
        protected JsonNode _currentNode;

        public ArrayCursor(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(1, nodeCursor);
            this._contents = jsonNode.elements();
        }

        public boolean currentHasChildren() {
            return ((ContainerNode) currentNode()).size() > 0;
        }

        public JsonNode currentNode() {
            return this._currentNode;
        }

        public JsonToken endToken() {
            return JsonToken.END_ARRAY;
        }

        public JsonToken nextToken() {
            if (this._contents.hasNext()) {
                this._currentNode = (JsonNode) this._contents.next();
                return this._currentNode.asToken();
            }
            this._currentNode = null;
            return null;
        }
    }

    public final class ObjectCursor extends NodeCursor {
        protected Iterator<Entry<String, JsonNode>> _contents;
        protected Entry<String, JsonNode> _current;
        protected boolean _needEntry = true;

        public ObjectCursor(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(2, nodeCursor);
            this._contents = ((ObjectNode) jsonNode).fields();
        }

        public boolean currentHasChildren() {
            return ((ContainerNode) currentNode()).size() > 0;
        }

        public JsonNode currentNode() {
            return this._current == null ? null : (JsonNode) this._current.getValue();
        }

        public JsonToken endToken() {
            return JsonToken.END_OBJECT;
        }

        public JsonToken nextToken() {
            if (!this._needEntry) {
                this._needEntry = true;
                return ((JsonNode) this._current.getValue()).asToken();
            } else if (this._contents.hasNext()) {
                this._needEntry = false;
                this._current = (Entry) this._contents.next();
                this._currentName = this._current == null ? null : (String) this._current.getKey();
                return JsonToken.FIELD_NAME;
            } else {
                this._currentName = null;
                this._current = null;
                return null;
            }
        }
    }

    public final class RootCursor extends NodeCursor {
        protected boolean _done = false;
        protected JsonNode _node;

        public RootCursor(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(0, nodeCursor);
            this._node = jsonNode;
        }

        public boolean currentHasChildren() {
            return false;
        }

        public JsonNode currentNode() {
            return this._node;
        }

        public JsonToken endToken() {
            return null;
        }

        public JsonToken nextToken() {
            if (this._done) {
                this._node = null;
                return null;
            }
            this._done = true;
            return this._node.asToken();
        }
    }

    public NodeCursor(int i, NodeCursor nodeCursor) {
        this._type = i;
        this._index = -1;
        this._parent = nodeCursor;
    }

    public abstract boolean currentHasChildren();

    public abstract JsonNode currentNode();

    public abstract JsonToken endToken();

    public final String getCurrentName() {
        return this._currentName;
    }

    public final NodeCursor getParent() {
        return this._parent;
    }

    public final NodeCursor iterateChildren() {
        JsonNode currentNode = currentNode();
        if (currentNode == null) {
            throw new IllegalStateException("No current node");
        } else if (currentNode.isArray()) {
            return new ArrayCursor(currentNode, this);
        } else {
            if (currentNode.isObject()) {
                return new ObjectCursor(currentNode, this);
            }
            throw new IllegalStateException("Current node of type " + currentNode.getClass().getName());
        }
    }

    public abstract JsonToken nextToken();

    public void setCurrentValue(Object obj) {
        this._currentValue = obj;
    }
}
