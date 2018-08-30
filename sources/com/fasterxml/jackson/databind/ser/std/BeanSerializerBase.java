package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class BeanSerializerBase extends StdSerializer<Object> implements JsonFormatVisitable, SchemaAware, ContextualSerializer, ResolvableSerializer {
    protected static final PropertyName NAME_FOR_OBJECT_REF = new PropertyName("#object-ref");
    protected static final BeanPropertyWriter[] NO_PROPS = new BeanPropertyWriter[0];
    protected final AnyGetterWriter _anyGetterWriter;
    protected final BeanPropertyWriter[] _filteredProps;
    protected final ObjectIdWriter _objectIdWriter;
    protected final Object _propertyFilterId;
    protected final BeanPropertyWriter[] _props;
    protected final Shape _serializationShape;
    protected final AnnotatedMember _typeId;

    protected BeanSerializerBase(JavaType javaType, BeanSerializerBuilder beanSerializerBuilder, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        Shape shape = null;
        super(javaType);
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        if (beanSerializerBuilder == null) {
            this._typeId = null;
            this._anyGetterWriter = null;
            this._propertyFilterId = null;
            this._objectIdWriter = null;
            this._serializationShape = null;
            return;
        }
        this._typeId = beanSerializerBuilder.getTypeId();
        this._anyGetterWriter = beanSerializerBuilder.getAnyGetter();
        this._propertyFilterId = beanSerializerBuilder.getFilterId();
        this._objectIdWriter = beanSerializerBuilder.getObjectIdWriter();
        Value findExpectedFormat = beanSerializerBuilder.getBeanDescription().findExpectedFormat(null);
        if (findExpectedFormat != null) {
            shape = findExpectedFormat.getShape();
        }
        this._serializationShape = shape;
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter) {
        this(beanSerializerBase, objectIdWriter, beanSerializerBase._propertyFilterId);
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter, Object obj) {
        super(beanSerializerBase._handledType);
        this._props = beanSerializerBase._props;
        this._filteredProps = beanSerializerBase._filteredProps;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = objectIdWriter;
        this._propertyFilterId = obj;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, NameTransformer nameTransformer) {
        this(beanSerializerBase, rename(beanSerializerBase._props, nameTransformer), rename(beanSerializerBase._filteredProps, nameTransformer));
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(beanSerializerBase._handledType);
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, String[] strArr) {
        BeanPropertyWriter[] beanPropertyWriterArr = null;
        super(beanSerializerBase._handledType);
        HashSet arrayToSet = ArrayBuilders.arrayToSet(strArr);
        BeanPropertyWriter[] beanPropertyWriterArr2 = beanSerializerBase._props;
        BeanPropertyWriter[] beanPropertyWriterArr3 = beanSerializerBase._filteredProps;
        int length = beanPropertyWriterArr2.length;
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = beanPropertyWriterArr3 == null ? null : new ArrayList(length);
        for (int i = 0; i < length; i++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr2[i];
            if (!arrayToSet.contains(beanPropertyWriter.getName())) {
                arrayList.add(beanPropertyWriter);
                if (beanPropertyWriterArr3 != null) {
                    arrayList2.add(beanPropertyWriterArr3[i]);
                }
            }
        }
        this._props = (BeanPropertyWriter[]) arrayList.toArray(new BeanPropertyWriter[arrayList.size()]);
        if (arrayList2 != null) {
            beanPropertyWriterArr = (BeanPropertyWriter[]) arrayList2.toArray(new BeanPropertyWriter[arrayList2.size()]);
        }
        this._filteredProps = beanPropertyWriterArr;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    private static final BeanPropertyWriter[] rename(BeanPropertyWriter[] beanPropertyWriterArr, NameTransformer nameTransformer) {
        if (beanPropertyWriterArr == null || beanPropertyWriterArr.length == 0 || nameTransformer == null || nameTransformer == NameTransformer.NOP) {
            return beanPropertyWriterArr;
        }
        int length = beanPropertyWriterArr.length;
        BeanPropertyWriter[] beanPropertyWriterArr2 = new BeanPropertyWriter[length];
        for (int i = 0; i < length; i++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
            if (beanPropertyWriter != null) {
                beanPropertyWriterArr2[i] = beanPropertyWriter.rename(nameTransformer);
            }
        }
        return beanPropertyWriterArr2;
    }

    protected final String _customTypeId(Object obj) {
        Object value = this._typeId.getValue(obj);
        return value == null ? "" : value instanceof String ? (String) value : value.toString();
    }

    protected void _serializeObjectId(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer, WritableObjectId writableObjectId) {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        String _customTypeId = this._typeId == null ? null : _customTypeId(obj);
        if (_customTypeId == null) {
            typeSerializer.writeTypePrefixForObject(obj, jsonGenerator);
        } else {
            typeSerializer.writeCustomTypePrefixForObject(obj, jsonGenerator, _customTypeId);
        }
        writableObjectId.writeAsField(jsonGenerator, serializerProvider, objectIdWriter);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, serializerProvider);
        } else {
            serializeFields(obj, jsonGenerator, serializerProvider);
        }
        if (_customTypeId == null) {
            typeSerializer.writeTypeSuffixForObject(obj, jsonGenerator);
        } else {
            typeSerializer.writeCustomTypeSuffixForObject(obj, jsonGenerator, _customTypeId);
        }
    }

    protected final void _serializeWithObjectId(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        WritableObjectId findObjectId = serializerProvider.findObjectId(obj, objectIdWriter.generator);
        if (!findObjectId.writeAsId(jsonGenerator, serializerProvider, objectIdWriter)) {
            Object generateId = findObjectId.generateId(obj);
            if (objectIdWriter.alwaysAsId) {
                objectIdWriter.serializer.serialize(generateId, jsonGenerator, serializerProvider);
            } else {
                _serializeObjectId(obj, jsonGenerator, serializerProvider, typeSerializer, findObjectId);
            }
        }
    }

    protected final void _serializeWithObjectId(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, boolean z) {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        WritableObjectId findObjectId = serializerProvider.findObjectId(obj, objectIdWriter.generator);
        if (!findObjectId.writeAsId(jsonGenerator, serializerProvider, objectIdWriter)) {
            Object generateId = findObjectId.generateId(obj);
            if (objectIdWriter.alwaysAsId) {
                objectIdWriter.serializer.serialize(generateId, jsonGenerator, serializerProvider);
                return;
            }
            if (z) {
                jsonGenerator.writeStartObject();
            }
            findObjectId.writeAsField(jsonGenerator, serializerProvider, objectIdWriter);
            if (this._propertyFilterId != null) {
                serializeFieldsFiltered(obj, jsonGenerator, serializerProvider);
            } else {
                serializeFields(obj, jsonGenerator, serializerProvider);
            }
            if (z) {
                jsonGenerator.writeEndObject();
            }
        }
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
        Object obj = null;
        int i = 0;
        if (jsonFormatVisitorWrapper != null) {
            JsonObjectFormatVisitor expectObjectFormat = jsonFormatVisitorWrapper.expectObjectFormat(javaType);
            if (expectObjectFormat != null) {
                SerializerProvider provider = jsonFormatVisitorWrapper.getProvider();
                int length;
                if (this._propertyFilterId != null) {
                    PropertyFilter findPropertyFilter = findPropertyFilter(jsonFormatVisitorWrapper.getProvider(), this._propertyFilterId, null);
                    length = this._props.length;
                    while (i < length) {
                        findPropertyFilter.depositSchemaProperty(this._props[i], expectObjectFormat, provider);
                        i++;
                    }
                    return;
                }
                if (!(this._filteredProps == null || provider == null)) {
                    obj = provider.getActiveView();
                }
                BeanPropertyWriter[] beanPropertyWriterArr = obj != null ? this._filteredProps : this._props;
                length = beanPropertyWriterArr.length;
                while (i < length) {
                    BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                    if (beanPropertyWriter != null) {
                        beanPropertyWriter.depositSchemaProperty(expectObjectFormat, provider);
                    }
                    i++;
                }
            }
        }
    }

    protected abstract BeanSerializerBase asArraySerializer();

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A:{SYNTHETIC, RETURN} */
    public com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(com.fasterxml.jackson.databind.SerializerProvider r14, com.fasterxml.jackson.databind.BeanProperty r15) {
        /*
        r13 = this;
        r12 = 1;
        r5 = 0;
        r1 = 0;
        r6 = r14.getAnnotationIntrospector();
        if (r15 == 0) goto L_0x000b;
    L_0x0009:
        if (r6 != 0) goto L_0x009d;
    L_0x000b:
        r2 = r1;
    L_0x000c:
        r3 = r14.getConfig();
        if (r2 == 0) goto L_0x0174;
    L_0x0012:
        r4 = r6.findFormat(r2);
        if (r4 == 0) goto L_0x0174;
    L_0x0018:
        r0 = r4.getShape();
        r7 = r13._serializationShape;
        if (r0 == r7) goto L_0x0033;
    L_0x0020:
        r7 = r13._handledType;
        r7 = r7.isEnum();
        if (r7 == 0) goto L_0x0033;
    L_0x0028:
        r7 = com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.AnonymousClass1.$SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape;
        r8 = r0.ordinal();
        r7 = r7[r8];
        switch(r7) {
            case 1: goto L_0x00a4;
            case 2: goto L_0x00a4;
            case 3: goto L_0x00a4;
            default: goto L_0x0033;
        };
    L_0x0033:
        r3 = r0;
    L_0x0034:
        r0 = r13._objectIdWriter;
        if (r2 == 0) goto L_0x0171;
    L_0x0038:
        r4 = r6.findPropertiesToIgnore(r2, r12);
        r7 = r6.findObjectIdInfo(r2);
        if (r7 != 0) goto L_0x00b9;
    L_0x0042:
        if (r0 == 0) goto L_0x0059;
    L_0x0044:
        r0 = new com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
        r5 = NAME_FOR_OBJECT_REF;
        r0.<init>(r5, r1, r1, r1);
        r0 = r6.findObjectReferenceInfo(r2, r0);
        r5 = r13._objectIdWriter;
        r0 = r0.getAlwaysAsId();
        r0 = r5.withAlwaysAsId(r0);
    L_0x0059:
        r2 = r6.findFilterId(r2);
        if (r2 == 0) goto L_0x016e;
    L_0x005f:
        r5 = r13._propertyFilterId;
        if (r5 == 0) goto L_0x006b;
    L_0x0063:
        r5 = r13._propertyFilterId;
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x016e;
    L_0x006b:
        r1 = r2;
        r2 = r4;
    L_0x006d:
        if (r0 == 0) goto L_0x016b;
    L_0x006f:
        r4 = r0.idType;
        r4 = r14.findValueSerializer(r4, r15);
        r0 = r0.withSerializer(r4);
        r4 = r13._objectIdWriter;
        if (r0 == r4) goto L_0x016b;
    L_0x007d:
        r0 = r13.withObjectIdWriter(r0);
    L_0x0081:
        if (r2 == 0) goto L_0x008a;
    L_0x0083:
        r4 = r2.length;
        if (r4 == 0) goto L_0x008a;
    L_0x0086:
        r0 = r0.withIgnorals(r2);
    L_0x008a:
        if (r1 == 0) goto L_0x0090;
    L_0x008c:
        r0 = r0.withFilterId(r1);
    L_0x0090:
        if (r3 != 0) goto L_0x0094;
    L_0x0092:
        r3 = r13._serializationShape;
    L_0x0094:
        r1 = com.fasterxml.jackson.annotation.JsonFormat.Shape.ARRAY;
        if (r3 != r1) goto L_0x009c;
    L_0x0098:
        r0 = r0.asArraySerializer();
    L_0x009c:
        return r0;
    L_0x009d:
        r0 = r15.getMember();
        r2 = r0;
        goto L_0x000c;
    L_0x00a4:
        r0 = r13._handledType;
        r0 = r3.introspectClassAnnotations(r0);
        r1 = r13._handledType;
        r2 = r14.getConfig();
        r0 = com.fasterxml.jackson.databind.ser.std.EnumSerializer.construct(r1, r2, r0, r4);
        r0 = r14.handlePrimaryContextualization(r0, r15);
        goto L_0x009c;
    L_0x00b9:
        r7 = r6.findObjectReferenceInfo(r2, r7);
        r0 = r7.getGeneratorType();
        r8 = r14.constructType(r0);
        r9 = r14.getTypeFactory();
        r10 = com.fasterxml.jackson.annotation.ObjectIdGenerator.class;
        r8 = r9.findTypeParameters(r8, r10);
        r8 = r8[r5];
        r9 = com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator.class;
        if (r0 != r9) goto L_0x0159;
    L_0x00d5:
        r0 = r7.getPropertyName();
        r8 = r0.getSimpleName();
        r0 = r13._props;
        r9 = r0.length;
        r0 = r5;
    L_0x00e1:
        if (r0 != r9) goto L_0x0112;
    L_0x00e3:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Invalid Object Id definition for ";
        r1 = r1.append(r2);
        r2 = r13._handledType;
        r2 = r2.getName();
        r1 = r1.append(r2);
        r2 = ": can not find property with name '";
        r1 = r1.append(r2);
        r1 = r1.append(r8);
        r2 = "'";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0112:
        r10 = r13._props;
        r10 = r10[r0];
        r11 = r10.getName();
        r11 = r8.equals(r11);
        if (r11 == 0) goto L_0x0156;
    L_0x0120:
        if (r0 <= 0) goto L_0x0140;
    L_0x0122:
        r8 = r13._props;
        r9 = r13._props;
        java.lang.System.arraycopy(r8, r5, r9, r12, r0);
        r8 = r13._props;
        r8[r5] = r10;
        r8 = r13._filteredProps;
        if (r8 == 0) goto L_0x0140;
    L_0x0131:
        r8 = r13._filteredProps;
        r8 = r8[r0];
        r9 = r13._filteredProps;
        r11 = r13._filteredProps;
        java.lang.System.arraycopy(r9, r5, r11, r12, r0);
        r0 = r13._filteredProps;
        r0[r5] = r8;
    L_0x0140:
        r5 = r10.getType();
        r8 = new com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
        r8.<init>(r7, r10);
        r0 = r1;
        r0 = (com.fasterxml.jackson.databind.PropertyName) r0;
        r7 = r7.getAlwaysAsId();
        r0 = com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter.construct(r5, r0, r8, r7);
        goto L_0x0059;
    L_0x0156:
        r0 = r0 + 1;
        goto L_0x00e1;
    L_0x0159:
        r0 = r14.objectIdGeneratorInstance(r2, r7);
        r5 = r7.getPropertyName();
        r7 = r7.getAlwaysAsId();
        r0 = com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter.construct(r8, r5, r0, r7);
        goto L_0x0059;
    L_0x016b:
        r0 = r13;
        goto L_0x0081;
    L_0x016e:
        r2 = r4;
        goto L_0x006d;
    L_0x0171:
        r2 = r1;
        goto L_0x006d;
    L_0x0174:
        r3 = r1;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer<?>");
    }

    protected JsonSerializer<Object> findConvertingSerializer(SerializerProvider serializerProvider, BeanPropertyWriter beanPropertyWriter) {
        JsonSerializer jsonSerializer = null;
        AnnotationIntrospector annotationIntrospector = serializerProvider.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            return null;
        }
        Annotated member = beanPropertyWriter.getMember();
        if (member == null) {
            return null;
        }
        Object findSerializationConverter = annotationIntrospector.findSerializationConverter(member);
        if (findSerializationConverter == null) {
            return null;
        }
        Converter converterInstance = serializerProvider.converterInstance(beanPropertyWriter.getMember(), findSerializationConverter);
        JavaType outputType = converterInstance.getOutputType(serializerProvider.getTypeFactory());
        if (!outputType.isJavaLangObject()) {
            jsonSerializer = serializerProvider.findValueSerializer(outputType, (BeanProperty) beanPropertyWriter);
        }
        return new StdDelegatingSerializer(converterInstance, outputType, jsonSerializer);
    }

    @Deprecated
    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        JsonNode createSchemaNode = createSchemaNode("object", true);
        JsonSerializableSchema jsonSerializableSchema = (JsonSerializableSchema) this._handledType.getAnnotation(JsonSerializableSchema.class);
        if (jsonSerializableSchema != null) {
            String id = jsonSerializableSchema.id();
            if (id != null && id.length() > 0) {
                createSchemaNode.put("id", id);
            }
        }
        ObjectNode objectNode = createSchemaNode.objectNode();
        PropertyFilter findPropertyFilter = this._propertyFilterId != null ? findPropertyFilter(serializerProvider, this._propertyFilterId, null) : null;
        for (PropertyWriter propertyWriter : this._props) {
            if (findPropertyFilter == null) {
                propertyWriter.depositSchemaProperty(objectNode, serializerProvider);
            } else {
                findPropertyFilter.depositSchemaProperty(propertyWriter, objectNode, serializerProvider);
            }
        }
        createSchemaNode.set("properties", objectNode);
        return createSchemaNode;
    }

    public void resolve(SerializerProvider serializerProvider) {
        int length = this._filteredProps == null ? 0 : this._filteredProps.length;
        int length2 = this._props.length;
        for (int i = 0; i < length2; i++) {
            BeanProperty beanProperty = this._props[i];
            if (!(beanProperty.willSuppressNulls() || beanProperty.hasNullSerializer())) {
                JsonSerializer findNullValueSerializer = serializerProvider.findNullValueSerializer(beanProperty);
                if (findNullValueSerializer != null) {
                    beanProperty.assignNullSerializer(findNullValueSerializer);
                    if (i < length) {
                        BeanPropertyWriter beanPropertyWriter = this._filteredProps[i];
                        if (beanPropertyWriter != null) {
                            beanPropertyWriter.assignNullSerializer(findNullValueSerializer);
                        }
                    }
                }
            }
            if (!beanProperty.hasSerializer()) {
                JsonSerializer findConvertingSerializer = findConvertingSerializer(serializerProvider, beanProperty);
                if (findConvertingSerializer == null) {
                    JavaType serializationType = beanProperty.getSerializationType();
                    if (serializationType == null) {
                        serializationType = beanProperty.getType();
                        if (!serializationType.isFinal()) {
                            if (serializationType.isContainerType() || serializationType.containedTypeCount() > 0) {
                                beanProperty.setNonTrivialBaseType(serializationType);
                            }
                        }
                    }
                    findConvertingSerializer = serializerProvider.findValueSerializer(serializationType, beanProperty);
                    if (serializationType.isContainerType()) {
                        TypeSerializer typeSerializer = (TypeSerializer) serializationType.getContentType().getTypeHandler();
                        if (typeSerializer != null && (findConvertingSerializer instanceof ContainerSerializer)) {
                            findConvertingSerializer = ((ContainerSerializer) findConvertingSerializer).withValueTypeSerializer(typeSerializer);
                        }
                    }
                }
                beanProperty.assignSerializer(findConvertingSerializer);
                if (i < length) {
                    BeanPropertyWriter beanPropertyWriter2 = this._filteredProps[i];
                    if (beanPropertyWriter2 != null) {
                        beanPropertyWriter2.assignSerializer(findConvertingSerializer);
                    }
                }
            }
        }
        if (this._anyGetterWriter != null) {
            this._anyGetterWriter.resolve(serializerProvider);
        }
    }

    protected void serializeFields(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        BeanPropertyWriter[] beanPropertyWriterArr = (this._filteredProps == null || serializerProvider.getActiveView() == null) ? this._props : this._filteredProps;
        int i = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                if (beanPropertyWriter != null) {
                    beanPropertyWriter.serializeAsField(obj, jsonGenerator, serializerProvider);
                }
                i++;
            }
            if (this._anyGetterWriter != null) {
                this._anyGetterWriter.getAndSerialize(obj, jsonGenerator, serializerProvider);
            }
        } catch (Throwable e) {
            wrapAndThrow(serializerProvider, e, obj, i == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[i].getName());
        } catch (Throwable e2) {
            JsonMappingException jsonMappingException = new JsonMappingException((Closeable) jsonGenerator, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.prependPath(new Reference(obj, i == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[i].getName()));
            throw jsonMappingException;
        }
    }

    protected void serializeFieldsFiltered(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        BeanPropertyWriter[] beanPropertyWriterArr = (this._filteredProps == null || serializerProvider.getActiveView() == null) ? this._props : this._filteredProps;
        PropertyFilter findPropertyFilter = findPropertyFilter(serializerProvider, this._propertyFilterId, obj);
        if (findPropertyFilter == null) {
            serializeFields(obj, jsonGenerator, serializerProvider);
            return;
        }
        int i = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i < length) {
                PropertyWriter propertyWriter = beanPropertyWriterArr[i];
                if (propertyWriter != null) {
                    findPropertyFilter.serializeAsField(obj, jsonGenerator, serializerProvider, propertyWriter);
                }
                i++;
            }
            if (this._anyGetterWriter != null) {
                this._anyGetterWriter.getAndFilter(obj, jsonGenerator, serializerProvider, findPropertyFilter);
            }
        } catch (Throwable e) {
            wrapAndThrow(serializerProvider, e, obj, 0 == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[0].getName());
        } catch (Throwable e2) {
            JsonMappingException jsonMappingException = new JsonMappingException((Closeable) jsonGenerator, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.prependPath(new Reference(obj, 0 == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[0].getName()));
            throw jsonMappingException;
        }
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        if (this._objectIdWriter != null) {
            jsonGenerator.setCurrentValue(obj);
            _serializeWithObjectId(obj, jsonGenerator, serializerProvider, typeSerializer);
            return;
        }
        String _customTypeId = this._typeId == null ? null : _customTypeId(obj);
        if (_customTypeId == null) {
            typeSerializer.writeTypePrefixForObject(obj, jsonGenerator);
        } else {
            typeSerializer.writeCustomTypePrefixForObject(obj, jsonGenerator, _customTypeId);
        }
        jsonGenerator.setCurrentValue(obj);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, serializerProvider);
        } else {
            serializeFields(obj, jsonGenerator, serializerProvider);
        }
        if (_customTypeId == null) {
            typeSerializer.writeTypeSuffixForObject(obj, jsonGenerator);
        } else {
            typeSerializer.writeCustomTypeSuffixForObject(obj, jsonGenerator, _customTypeId);
        }
    }

    public boolean usesObjectId() {
        return this._objectIdWriter != null;
    }

    public abstract BeanSerializerBase withFilterId(Object obj);

    protected abstract BeanSerializerBase withIgnorals(String[] strArr);

    public abstract BeanSerializerBase withObjectIdWriter(ObjectIdWriter objectIdWriter);
}
