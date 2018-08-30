package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNumberFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public abstract class StdSerializer<T> extends JsonSerializer<T> implements JsonFormatVisitable, SchemaAware, Serializable {
    private static final Object CONVERTING_CONTENT_CONVERTER_LOCK = new Object();
    private static final long serialVersionUID = 1;
    protected final Class<T> _handledType;

    protected StdSerializer(JavaType javaType) {
        this._handledType = javaType.getRawClass();
    }

    protected StdSerializer(StdSerializer<?> stdSerializer) {
        this._handledType = stdSerializer._handledType;
    }

    protected StdSerializer(Class<T> cls) {
        this._handledType = cls;
    }

    protected StdSerializer(Class<?> cls, boolean z) {
        this._handledType = cls;
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
        jsonFormatVisitorWrapper.expectAnyFormat(javaType);
    }

    protected ObjectNode createObjectNode() {
        return JsonNodeFactory.instance.objectNode();
    }

    protected ObjectNode createSchemaNode(String str) {
        ObjectNode createObjectNode = createObjectNode();
        createObjectNode.put("type", str);
        return createObjectNode;
    }

    protected ObjectNode createSchemaNode(String str, boolean z) {
        ObjectNode createSchemaNode = createSchemaNode(str);
        if (!z) {
            createSchemaNode.put("required", !z);
        }
        return createSchemaNode;
    }

    protected JsonSerializer<?> findConvertingContentSerializer(SerializerProvider serializerProvider, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer) {
        if (serializerProvider.getAttribute(CONVERTING_CONTENT_CONVERTER_LOCK) != null) {
            return jsonSerializer;
        }
        AnnotationIntrospector annotationIntrospector = serializerProvider.getAnnotationIntrospector();
        if (annotationIntrospector == null || beanProperty == null) {
            return jsonSerializer;
        }
        AnnotatedMember member = beanProperty.getMember();
        if (member == null) {
            return jsonSerializer;
        }
        serializerProvider.setAttribute(CONVERTING_CONTENT_CONVERTER_LOCK, Boolean.TRUE);
        try {
            Object findSerializationContentConverter = annotationIntrospector.findSerializationContentConverter(member);
            if (findSerializationContentConverter == null) {
                return jsonSerializer;
            }
            JsonSerializer jsonSerializer2;
            Converter converterInstance = serializerProvider.converterInstance(beanProperty.getMember(), findSerializationContentConverter);
            JavaType outputType = converterInstance.getOutputType(serializerProvider.getTypeFactory());
            if (jsonSerializer2 == null && !outputType.isJavaLangObject()) {
                jsonSerializer2 = serializerProvider.findValueSerializer(outputType);
            }
            return new StdDelegatingSerializer(converterInstance, outputType, jsonSerializer2);
        } finally {
            serializerProvider.setAttribute(CONVERTING_CONTENT_CONVERTER_LOCK, null);
        }
    }

    protected Boolean findFormatFeature(SerializerProvider serializerProvider, BeanProperty beanProperty, Class<?> cls, Feature feature) {
        Value findFormatOverrides = findFormatOverrides(serializerProvider, beanProperty, cls);
        return findFormatOverrides != null ? findFormatOverrides.getFeature(feature) : null;
    }

    protected Value findFormatOverrides(SerializerProvider serializerProvider, BeanProperty beanProperty, Class<?> cls) {
        return beanProperty != null ? beanProperty.findPropertyFormat(serializerProvider.getConfig(), cls) : serializerProvider.getDefaultPropertyFormat(cls);
    }

    protected PropertyFilter findPropertyFilter(SerializerProvider serializerProvider, Object obj, Object obj2) {
        FilterProvider filterProvider = serializerProvider.getFilterProvider();
        if (filterProvider != null) {
            return filterProvider.findPropertyFilter(obj, obj2);
        }
        throw JsonMappingException.from(serializerProvider, "Can not resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured");
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return createSchemaNode("string");
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type, boolean z) {
        ObjectNode objectNode = (ObjectNode) getSchema(serializerProvider, type);
        if (!z) {
            objectNode.put("required", !z);
        }
        return objectNode;
    }

    public Class<T> handledType() {
        return this._handledType;
    }

    protected boolean isDefaultSerializer(JsonSerializer<?> jsonSerializer) {
        return ClassUtil.isJacksonStdImpl((Object) jsonSerializer);
    }

    public abstract void serialize(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider);

    protected void visitArrayFormat(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType, JsonSerializer<?> jsonSerializer, JavaType javaType2) {
        if (jsonFormatVisitorWrapper != null) {
            JsonArrayFormatVisitor expectArrayFormat = jsonFormatVisitorWrapper.expectArrayFormat(javaType);
            if (expectArrayFormat != null && jsonSerializer != null) {
                expectArrayFormat.itemsFormat(jsonSerializer, javaType2);
            }
        }
    }

    protected void visitArrayFormat(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType, JsonFormatTypes jsonFormatTypes) {
        if (jsonFormatVisitorWrapper != null) {
            JsonArrayFormatVisitor expectArrayFormat = jsonFormatVisitorWrapper.expectArrayFormat(javaType);
            if (expectArrayFormat != null) {
                expectArrayFormat.itemsFormat(jsonFormatTypes);
            }
        }
    }

    protected void visitFloatFormat(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType, NumberType numberType) {
        if (jsonFormatVisitorWrapper != null) {
            JsonNumberFormatVisitor expectNumberFormat = jsonFormatVisitorWrapper.expectNumberFormat(javaType);
            if (expectNumberFormat != null) {
                expectNumberFormat.numberType(numberType);
            }
        }
    }

    protected void visitIntFormat(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType, NumberType numberType) {
        if (jsonFormatVisitorWrapper != null) {
            JsonIntegerFormatVisitor expectIntegerFormat = jsonFormatVisitorWrapper.expectIntegerFormat(javaType);
            if (expectIntegerFormat != null && numberType != null) {
                expectIntegerFormat.numberType(numberType);
            }
        }
    }

    protected void visitIntFormat(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType, NumberType numberType, JsonValueFormat jsonValueFormat) {
        if (jsonFormatVisitorWrapper != null) {
            JsonIntegerFormatVisitor expectIntegerFormat = jsonFormatVisitorWrapper.expectIntegerFormat(javaType);
            if (expectIntegerFormat != null) {
                if (numberType != null) {
                    expectIntegerFormat.numberType(numberType);
                }
                if (jsonValueFormat != null) {
                    expectIntegerFormat.format(jsonValueFormat);
                }
            }
        }
    }

    protected void visitStringFormat(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
        if (jsonFormatVisitorWrapper != null) {
            jsonFormatVisitorWrapper.expectStringFormat(javaType);
        }
    }

    protected void visitStringFormat(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType, JsonValueFormat jsonValueFormat) {
        if (jsonFormatVisitorWrapper != null) {
            JsonStringFormatVisitor expectStringFormat = jsonFormatVisitorWrapper.expectStringFormat(javaType);
            if (expectStringFormat != null) {
                expectStringFormat.format(jsonValueFormat);
            }
        }
    }

    public void wrapAndThrow(SerializerProvider serializerProvider, Throwable th, Object obj, int i) {
        Throwable th2 = th;
        while ((th2 instanceof InvocationTargetException) && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        Object obj2 = (serializerProvider == null || serializerProvider.isEnabled(SerializationFeature.WRAP_EXCEPTIONS)) ? 1 : null;
        if (th2 instanceof IOException) {
            if (obj2 == null || !(th2 instanceof JsonMappingException)) {
                throw ((IOException) th2);
            }
        } else if (obj2 == null && (th2 instanceof RuntimeException)) {
            throw ((RuntimeException) th2);
        }
        throw JsonMappingException.wrapWithPath(th2, obj, i);
    }

    public void wrapAndThrow(SerializerProvider serializerProvider, Throwable th, Object obj, String str) {
        Throwable th2 = th;
        while ((th2 instanceof InvocationTargetException) && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        Object obj2 = (serializerProvider == null || serializerProvider.isEnabled(SerializationFeature.WRAP_EXCEPTIONS)) ? 1 : null;
        if (th2 instanceof IOException) {
            if (obj2 == null || !(th2 instanceof JsonMappingException)) {
                throw ((IOException) th2);
            }
        } else if (obj2 == null && (th2 instanceof RuntimeException)) {
            throw ((RuntimeException) th2);
        }
        throw JsonMappingException.wrapWithPath(th2, obj, str);
    }
}
