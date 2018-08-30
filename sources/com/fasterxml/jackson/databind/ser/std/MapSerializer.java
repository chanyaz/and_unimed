package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonMapFormatVisitor;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

@JacksonStdImpl
public class MapSerializer extends ContainerSerializer<Map<?, ?>> implements ContextualSerializer {
    protected static final JavaType UNSPECIFIED_TYPE = TypeFactory.unknownType();
    private static final long serialVersionUID = 1;
    protected PropertySerializerMap _dynamicValueSerializers;
    protected final Object _filterId;
    protected final HashSet<String> _ignoredEntries;
    protected JsonSerializer<Object> _keySerializer;
    protected final JavaType _keyType;
    protected final BeanProperty _property;
    protected final boolean _sortKeys;
    protected final Object _suppressableValue;
    protected JsonSerializer<Object> _valueSerializer;
    protected final JavaType _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final TypeSerializer _valueTypeSerializer;

    protected MapSerializer(MapSerializer mapSerializer, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, HashSet<String> hashSet) {
        super(Map.class, false);
        this._ignoredEntries = hashSet;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = beanProperty;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        this._suppressableValue = mapSerializer._suppressableValue;
    }

    protected MapSerializer(MapSerializer mapSerializer, TypeSerializer typeSerializer, Object obj) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        Object obj2 = obj == Include.NON_ABSENT ? this._valueType.isReferenceType() ? Include.NON_EMPTY : Include.NON_NULL : obj;
        this._suppressableValue = obj2;
    }

    protected MapSerializer(MapSerializer mapSerializer, Object obj, boolean z) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = obj;
        this._sortKeys = z;
        this._suppressableValue = mapSerializer._suppressableValue;
    }

    protected MapSerializer(HashSet<String> hashSet, JavaType javaType, JavaType javaType2, boolean z, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2) {
        super(Map.class, false);
        this._ignoredEntries = hashSet;
        this._keyType = javaType;
        this._valueType = javaType2;
        this._valueTypeIsStatic = z;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = PropertySerializerMap.emptyForProperties();
        this._property = null;
        this._filterId = null;
        this._sortKeys = false;
        this._suppressableValue = null;
    }

    public static MapSerializer construct(String[] strArr, JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer, JsonSerializer<Object> jsonSerializer2, Object obj) {
        JavaType javaType2;
        JavaType javaType3;
        boolean z2;
        boolean z3 = false;
        HashSet arrayToSet = (strArr == null || strArr.length == 0) ? null : ArrayBuilders.arrayToSet(strArr);
        if (javaType == null) {
            javaType2 = UNSPECIFIED_TYPE;
            javaType3 = javaType2;
        } else {
            javaType3 = javaType.getKeyType();
            javaType2 = javaType.getContentType();
        }
        if (z) {
            z2 = javaType2.getRawClass() == Object.class ? false : z;
        } else {
            if (javaType2 != null && javaType2.isFinal()) {
                z3 = true;
            }
            z2 = z3;
        }
        MapSerializer mapSerializer = new MapSerializer(arrayToSet, javaType3, javaType2, z2, typeSerializer, jsonSerializer, jsonSerializer2);
        return obj != null ? mapSerializer.withFilterId(obj) : mapSerializer;
    }

    protected void _ensureOverride() {
        if (getClass() != MapSerializer.class) {
            throw new IllegalStateException("Missing override in class " + getClass().getName());
        }
    }

    protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) {
        SerializerAndMapResult findAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(javaType, serializerProvider, this._property);
        if (propertySerializerMap != findAndAddSecondarySerializer.map) {
            this._dynamicValueSerializers = findAndAddSecondarySerializer.map;
        }
        return findAndAddSecondarySerializer.serializer;
    }

    protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) {
        SerializerAndMapResult findAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer((Class) cls, serializerProvider, this._property);
        if (propertySerializerMap != findAndAddSecondarySerializer.map) {
            this._dynamicValueSerializers = findAndAddSecondarySerializer.map;
        }
        return findAndAddSecondarySerializer.serializer;
    }

    protected Map<?, ?> _orderEntries(Map<?, ?> map) {
        return map instanceof SortedMap ? map : new TreeMap(map);
    }

    public MapSerializer _withValueTypeSerializer(TypeSerializer typeSerializer) {
        if (this._valueTypeSerializer == typeSerializer) {
            return this;
        }
        _ensureOverride();
        return new MapSerializer(this, typeSerializer, null);
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
        JsonMapFormatVisitor expectMapFormat = jsonFormatVisitorWrapper == null ? null : jsonFormatVisitorWrapper.expectMapFormat(javaType);
        if (expectMapFormat != null) {
            expectMapFormat.keyFormat(this._keySerializer, this._keyType);
            JsonFormatVisitable jsonFormatVisitable = this._valueSerializer;
            if (jsonFormatVisitable == null) {
                jsonFormatVisitable = _findAndAddDynamic(this._dynamicValueSerializers, this._valueType, jsonFormatVisitorWrapper.getProvider());
            }
            expectMapFormat.valueFormat(jsonFormatVisitable, this._valueType);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b7  */
    public com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(com.fasterxml.jackson.databind.SerializerProvider r13, com.fasterxml.jackson.databind.BeanProperty r14) {
        /*
        r12 = this;
        r5 = 1;
        r1 = 0;
        r6 = 0;
        r8 = r13.getAnnotationIntrospector();
        if (r14 != 0) goto L_0x0082;
    L_0x0009:
        r0 = r1;
    L_0x000a:
        r4 = r12._suppressableValue;
        if (r0 == 0) goto L_0x00d4;
    L_0x000e:
        if (r8 == 0) goto L_0x00d4;
    L_0x0010:
        r2 = r8.findKeySerializer(r0);
        if (r2 == 0) goto L_0x00d1;
    L_0x0016:
        r2 = r13.serializerInstance(r0, r2);
    L_0x001a:
        r3 = r8.findContentSerializer(r0);
        if (r3 == 0) goto L_0x0024;
    L_0x0020:
        r1 = r13.serializerInstance(r0, r3);
    L_0x0024:
        if (r14 == 0) goto L_0x00ce;
    L_0x0026:
        r3 = r13.getConfig();
        r7 = java.util.Map.class;
        r3 = r14.findPropertyInclusion(r3, r7);
        r3 = r3.getContentInclusion();
        if (r3 == 0) goto L_0x00ce;
    L_0x0036:
        r7 = com.fasterxml.jackson.annotation.JsonInclude.Include.USE_DEFAULTS;
        if (r3 == r7) goto L_0x00ce;
    L_0x003a:
        r7 = r3;
    L_0x003b:
        if (r1 != 0) goto L_0x003f;
    L_0x003d:
        r1 = r12._valueSerializer;
    L_0x003f:
        r3 = r12.findConvertingContentSerializer(r13, r14, r1);
        if (r3 != 0) goto L_0x0087;
    L_0x0045:
        r1 = r12._valueTypeIsStatic;
        if (r1 == 0) goto L_0x0057;
    L_0x0049:
        r1 = r12._valueType;
        r1 = r1.isJavaLangObject();
        if (r1 != 0) goto L_0x0057;
    L_0x0051:
        r1 = r12._valueType;
        r3 = r13.findValueSerializer(r1, r14);
    L_0x0057:
        if (r2 != 0) goto L_0x00cc;
    L_0x0059:
        r1 = r12._keySerializer;
    L_0x005b:
        if (r1 != 0) goto L_0x008c;
    L_0x005d:
        r1 = r12._keyType;
        r2 = r13.findKeySerializer(r1, r14);
    L_0x0063:
        r4 = r12._ignoredEntries;
        if (r8 == 0) goto L_0x00ca;
    L_0x0067:
        if (r0 == 0) goto L_0x00ca;
    L_0x0069:
        r9 = r8.findPropertiesToIgnore(r0, r5);
        if (r9 == 0) goto L_0x0097;
    L_0x006f:
        if (r4 != 0) goto L_0x0091;
    L_0x0071:
        r1 = new java.util.HashSet;
        r1.<init>();
    L_0x0076:
        r10 = r9.length;
        r4 = r6;
    L_0x0078:
        if (r4 >= r10) goto L_0x0098;
    L_0x007a:
        r11 = r9[r4];
        r1.add(r11);
        r4 = r4 + 1;
        goto L_0x0078;
    L_0x0082:
        r0 = r14.getMember();
        goto L_0x000a;
    L_0x0087:
        r3 = r13.handleSecondaryContextualization(r3, r14);
        goto L_0x0057;
    L_0x008c:
        r2 = r13.handleSecondaryContextualization(r1, r14);
        goto L_0x0063;
    L_0x0091:
        r1 = new java.util.HashSet;
        r1.<init>(r4);
        goto L_0x0076;
    L_0x0097:
        r1 = r4;
    L_0x0098:
        r0 = r8.findSerializationSortAlphabetically(r0);
        if (r0 == 0) goto L_0x00c8;
    L_0x009e:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x00c8;
    L_0x00a4:
        r0 = r5;
    L_0x00a5:
        r5 = r0;
        r4 = r1;
    L_0x00a7:
        r0 = r12;
        r1 = r14;
        r0 = r0.withResolved(r1, r2, r3, r4, r5);
        r1 = r12._suppressableValue;
        if (r7 == r1) goto L_0x00b5;
    L_0x00b1:
        r0 = r0.withContentInclusion(r7);
    L_0x00b5:
        if (r14 == 0) goto L_0x00c7;
    L_0x00b7:
        r1 = r14.getMember();
        if (r1 == 0) goto L_0x00c7;
    L_0x00bd:
        r1 = r8.findFilterId(r1);
        if (r1 == 0) goto L_0x00c7;
    L_0x00c3:
        r0 = r0.withFilterId(r1);
    L_0x00c7:
        return r0;
    L_0x00c8:
        r0 = r6;
        goto L_0x00a5;
    L_0x00ca:
        r5 = r6;
        goto L_0x00a7;
    L_0x00cc:
        r1 = r2;
        goto L_0x005b;
    L_0x00ce:
        r7 = r4;
        goto L_0x003b;
    L_0x00d1:
        r2 = r1;
        goto L_0x001a;
    L_0x00d4:
        r2 = r1;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer<?>");
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return createSchemaNode("object", true);
    }

    public boolean hasSingleElement(Map<?, ?> map) {
        return map.size() == 1;
    }

    public boolean isEmpty(SerializerProvider serializerProvider, Map<?, ?> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        Include include = this._suppressableValue;
        if (include == null || include == Include.ALWAYS) {
            return false;
        }
        JsonSerializer jsonSerializer = this._valueSerializer;
        if (jsonSerializer != null) {
            for (Object next : map.values()) {
                if (next != null && !jsonSerializer.isEmpty(serializerProvider, next)) {
                    return false;
                }
            }
            return true;
        }
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        for (Object next2 : map.values()) {
            if (next2 != null) {
                Class cls = next2.getClass();
                JsonSerializer serializerFor = propertySerializerMap.serializerFor(cls);
                if (serializerFor == null) {
                    try {
                        serializerFor = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                        propertySerializerMap = this._dynamicValueSerializers;
                    } catch (JsonMappingException e) {
                        return false;
                    }
                }
                if (!serializerFor.isEmpty(serializerProvider, next2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void serialize(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeStartObject();
        jsonGenerator.setCurrentValue(map);
        if (!map.isEmpty()) {
            Map _orderEntries;
            Object obj = this._suppressableValue;
            if (obj == Include.ALWAYS) {
                obj = null;
            } else if (obj == null && !serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
                obj = Include.NON_NULL;
            }
            if (this._sortKeys || serializerProvider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                _orderEntries = _orderEntries(map);
            } else {
                Map<?, ?> _orderEntries2 = map;
            }
            if (this._filterId != null) {
                serializeFilteredFields(_orderEntries2, jsonGenerator, serializerProvider, findPropertyFilter(serializerProvider, this._filterId, _orderEntries2), obj);
            } else if (obj != null) {
                serializeOptionalFields(_orderEntries2, jsonGenerator, serializerProvider, obj);
            } else if (this._valueSerializer != null) {
                serializeFieldsUsing(_orderEntries2, jsonGenerator, serializerProvider, this._valueSerializer);
            } else {
                serializeFields(_orderEntries2, jsonGenerator, serializerProvider);
            }
        }
        jsonGenerator.writeEndObject();
    }

    public void serializeFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, serializerProvider, null);
            return;
        }
        JsonSerializer jsonSerializer = this._keySerializer;
        HashSet hashSet = this._ignoredEntries;
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        PropertySerializerMap propertySerializerMap2 = propertySerializerMap;
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            if (key == null) {
                serializerProvider.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, serializerProvider);
            } else if (hashSet == null || !hashSet.contains(key)) {
                jsonSerializer.serialize(key, jsonGenerator, serializerProvider);
            }
            if (value == null) {
                serializerProvider.defaultSerializeNull(jsonGenerator);
            } else {
                JsonSerializer _findAndAddDynamic;
                JsonSerializer jsonSerializer2;
                JsonSerializer jsonSerializer3 = this._valueSerializer;
                if (jsonSerializer3 == null) {
                    Class cls = value.getClass();
                    jsonSerializer3 = propertySerializerMap2.serializerFor(cls);
                    if (jsonSerializer3 == null) {
                        _findAndAddDynamic = this._valueType.hasGenericTypes() ? _findAndAddDynamic(propertySerializerMap2, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider) : _findAndAddDynamic(propertySerializerMap2, cls, serializerProvider);
                        propertySerializerMap = this._dynamicValueSerializers;
                        jsonSerializer2 = _findAndAddDynamic;
                        jsonSerializer2.serialize(value, jsonGenerator, serializerProvider);
                        propertySerializerMap2 = propertySerializerMap;
                    }
                }
                _findAndAddDynamic = jsonSerializer3;
                propertySerializerMap = propertySerializerMap2;
                jsonSerializer2 = _findAndAddDynamic;
                try {
                    jsonSerializer2.serialize(value, jsonGenerator, serializerProvider);
                } catch (Throwable e) {
                    wrapAndThrow(serializerProvider, e, (Object) map, "" + key);
                }
                propertySerializerMap2 = propertySerializerMap;
            }
        }
    }

    public void serializeFieldsUsing(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) {
        JsonSerializer jsonSerializer2 = this._keySerializer;
        HashSet hashSet = this._ignoredEntries;
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (hashSet == null || !hashSet.contains(key)) {
                if (key == null) {
                    serializerProvider.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer2.serialize(key, jsonGenerator, serializerProvider);
                }
                Object value = entry.getValue();
                if (value == null) {
                    serializerProvider.defaultSerializeNull(jsonGenerator);
                } else if (typeSerializer == null) {
                    try {
                        jsonSerializer.serialize(value, jsonGenerator, serializerProvider);
                    } catch (Throwable e) {
                        wrapAndThrow(serializerProvider, e, (Object) map, "" + key);
                    }
                } else {
                    jsonSerializer.serializeWithType(value, jsonGenerator, serializerProvider, typeSerializer);
                }
            }
        }
    }

    public void serializeFilteredFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, PropertyFilter propertyFilter, Object obj) {
        HashSet hashSet = this._ignoredEntries;
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        PropertyWriter mapProperty = new MapProperty(this._valueTypeSerializer, this._property);
        PropertySerializerMap propertySerializerMap2 = propertySerializerMap;
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (hashSet == null || !hashSet.contains(key)) {
                JsonSerializer jsonSerializer;
                JsonSerializer findNullKeySerializer = key == null ? serializerProvider.findNullKeySerializer(this._keyType, this._property) : this._keySerializer;
                Object value = entry.getValue();
                if (value != null) {
                    JsonSerializer _findAndAddDynamic;
                    JsonSerializer jsonSerializer2 = this._valueSerializer;
                    if (jsonSerializer2 == null) {
                        Class cls = value.getClass();
                        jsonSerializer2 = propertySerializerMap2.serializerFor(cls);
                        if (jsonSerializer2 == null) {
                            _findAndAddDynamic = this._valueType.hasGenericTypes() ? _findAndAddDynamic(propertySerializerMap2, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider) : _findAndAddDynamic(propertySerializerMap2, cls, serializerProvider);
                            propertySerializerMap = this._dynamicValueSerializers;
                            jsonSerializer = _findAndAddDynamic;
                            if (obj == Include.NON_EMPTY && jsonSerializer.isEmpty(serializerProvider, value)) {
                                propertySerializerMap2 = propertySerializerMap;
                            }
                        }
                    }
                    _findAndAddDynamic = jsonSerializer2;
                    propertySerializerMap = propertySerializerMap2;
                    jsonSerializer = _findAndAddDynamic;
                    propertySerializerMap2 = propertySerializerMap;
                } else if (obj == null) {
                    propertySerializerMap = propertySerializerMap2;
                    jsonSerializer = serializerProvider.getDefaultNullValueSerializer();
                }
                mapProperty.reset(key, findNullKeySerializer, jsonSerializer);
                try {
                    propertyFilter.serializeAsField(value, jsonGenerator, serializerProvider, mapProperty);
                } catch (Throwable e) {
                    wrapAndThrow(serializerProvider, e, (Object) map, "" + key);
                }
                propertySerializerMap2 = propertySerializerMap;
            }
        }
    }

    public void serializeOptionalFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) {
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, serializerProvider, obj);
            return;
        }
        HashSet hashSet = this._ignoredEntries;
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        PropertySerializerMap propertySerializerMap2 = propertySerializerMap;
        for (Entry entry : map.entrySet()) {
            JsonSerializer findNullKeySerializer;
            JsonSerializer jsonSerializer;
            Object key = entry.getKey();
            if (key == null) {
                findNullKeySerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
            } else if (hashSet == null || !hashSet.contains(key)) {
                findNullKeySerializer = this._keySerializer;
            }
            Object value = entry.getValue();
            if (value != null) {
                JsonSerializer _findAndAddDynamic;
                JsonSerializer jsonSerializer2 = this._valueSerializer;
                if (jsonSerializer2 == null) {
                    Class cls = value.getClass();
                    jsonSerializer2 = propertySerializerMap2.serializerFor(cls);
                    if (jsonSerializer2 == null) {
                        _findAndAddDynamic = this._valueType.hasGenericTypes() ? _findAndAddDynamic(propertySerializerMap2, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider) : _findAndAddDynamic(propertySerializerMap2, cls, serializerProvider);
                        propertySerializerMap = this._dynamicValueSerializers;
                        jsonSerializer = _findAndAddDynamic;
                        if (obj == Include.NON_EMPTY && jsonSerializer.isEmpty(serializerProvider, value)) {
                            propertySerializerMap2 = propertySerializerMap;
                        }
                    }
                }
                _findAndAddDynamic = jsonSerializer2;
                propertySerializerMap = propertySerializerMap2;
                jsonSerializer = _findAndAddDynamic;
                propertySerializerMap2 = propertySerializerMap;
            } else if (obj == null) {
                propertySerializerMap = propertySerializerMap2;
                jsonSerializer = serializerProvider.getDefaultNullValueSerializer();
            }
            try {
                findNullKeySerializer.serialize(key, jsonGenerator, serializerProvider);
                jsonSerializer.serialize(value, jsonGenerator, serializerProvider);
            } catch (Throwable e) {
                wrapAndThrow(serializerProvider, e, (Object) map, "" + key);
            }
            propertySerializerMap2 = propertySerializerMap;
        }
    }

    public void serializeTypedFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) {
        HashSet hashSet = this._ignoredEntries;
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        PropertySerializerMap propertySerializerMap2 = propertySerializerMap;
        for (Entry entry : map.entrySet()) {
            JsonSerializer findNullKeySerializer;
            JsonSerializer jsonSerializer;
            Object key = entry.getKey();
            if (key == null) {
                findNullKeySerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
            } else if (hashSet == null || !hashSet.contains(key)) {
                findNullKeySerializer = this._keySerializer;
            }
            Object value = entry.getValue();
            if (value != null) {
                JsonSerializer jsonSerializer2 = this._valueSerializer;
                Class cls = value.getClass();
                jsonSerializer2 = propertySerializerMap2.serializerFor(cls);
                JsonSerializer _findAndAddDynamic;
                if (jsonSerializer2 == null) {
                    _findAndAddDynamic = this._valueType.hasGenericTypes() ? _findAndAddDynamic(propertySerializerMap2, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider) : _findAndAddDynamic(propertySerializerMap2, cls, serializerProvider);
                    propertySerializerMap = this._dynamicValueSerializers;
                    jsonSerializer = _findAndAddDynamic;
                } else {
                    _findAndAddDynamic = jsonSerializer2;
                    propertySerializerMap = propertySerializerMap2;
                    jsonSerializer = _findAndAddDynamic;
                }
                if (obj == Include.NON_EMPTY && jsonSerializer.isEmpty(serializerProvider, value)) {
                    propertySerializerMap2 = propertySerializerMap;
                }
            } else if (obj == null) {
                propertySerializerMap = propertySerializerMap2;
                jsonSerializer = serializerProvider.getDefaultNullValueSerializer();
            }
            findNullKeySerializer.serialize(key, jsonGenerator, serializerProvider);
            try {
                jsonSerializer.serializeWithType(value, jsonGenerator, serializerProvider, this._valueTypeSerializer);
            } catch (Throwable e) {
                wrapAndThrow(serializerProvider, e, (Object) map, "" + key);
            }
            propertySerializerMap2 = propertySerializerMap;
        }
    }

    public void serializeWithType(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        Object _orderEntries;
        typeSerializer.writeTypePrefixForObject(map, jsonGenerator);
        jsonGenerator.setCurrentValue(map);
        Map<?, ?> map2;
        if (map.isEmpty()) {
            map2 = map;
        } else {
            Object obj = this._suppressableValue;
            if (obj == Include.ALWAYS) {
                obj = null;
            } else if (obj == null && !serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
                obj = Include.NON_NULL;
            }
            if (this._sortKeys || serializerProvider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                _orderEntries = _orderEntries(map);
            } else {
                map2 = map;
            }
            if (this._filterId != null) {
                serializeFilteredFields(_orderEntries, jsonGenerator, serializerProvider, findPropertyFilter(serializerProvider, this._filterId, _orderEntries), obj);
            } else if (obj != null) {
                serializeOptionalFields(_orderEntries, jsonGenerator, serializerProvider, obj);
            } else if (this._valueSerializer != null) {
                serializeFieldsUsing(_orderEntries, jsonGenerator, serializerProvider, this._valueSerializer);
            } else {
                serializeFields(_orderEntries, jsonGenerator, serializerProvider);
            }
        }
        typeSerializer.writeTypeSuffixForObject(_orderEntries, jsonGenerator);
    }

    public MapSerializer withContentInclusion(Object obj) {
        if (obj == this._suppressableValue) {
            return this;
        }
        _ensureOverride();
        return new MapSerializer(this, this._valueTypeSerializer, obj);
    }

    public MapSerializer withFilterId(Object obj) {
        if (this._filterId == obj) {
            return this;
        }
        _ensureOverride();
        return new MapSerializer(this, obj, this._sortKeys);
    }

    public MapSerializer withResolved(BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, HashSet<String> hashSet, boolean z) {
        _ensureOverride();
        MapSerializer mapSerializer = new MapSerializer(this, beanProperty, jsonSerializer, jsonSerializer2, hashSet);
        return z != mapSerializer._sortKeys ? new MapSerializer(mapSerializer, this._filterId, z) : mapSerializer;
    }
}
