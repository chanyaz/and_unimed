package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class SimpleModule extends Module implements Serializable {
    private static final long serialVersionUID = 1;
    protected SimpleAbstractTypeResolver _abstractTypes = null;
    protected BeanDeserializerModifier _deserializerModifier = null;
    protected SimpleDeserializers _deserializers = null;
    protected SimpleKeyDeserializers _keyDeserializers = null;
    protected SimpleSerializers _keySerializers = null;
    protected HashMap<Class<?>, Class<?>> _mixins = null;
    protected final String _name;
    protected PropertyNamingStrategy _namingStrategy = null;
    protected BeanSerializerModifier _serializerModifier = null;
    protected SimpleSerializers _serializers = null;
    protected LinkedHashSet<NamedType> _subtypes = null;
    protected SimpleValueInstantiators _valueInstantiators = null;
    protected final Version _version;

    public SimpleModule() {
        this._name = getClass() == SimpleModule.class ? "SimpleModule-" + System.identityHashCode(this) : getClass().getName();
        this._version = Version.unknownVersion();
    }

    public Version version() {
        return this._version;
    }
}
