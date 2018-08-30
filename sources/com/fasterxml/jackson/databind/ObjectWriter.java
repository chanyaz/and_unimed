package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

public class ObjectWriter implements Versioned, Serializable {
    protected static final PrettyPrinter NULL_PRETTY_PRINTER = new MinimalPrettyPrinter();
    private static final long serialVersionUID = 1;
    protected final SerializationConfig _config;
    protected final JsonFactory _generatorFactory;
    protected final GeneratorSettings _generatorSettings;
    protected final Prefetch _prefetch;
    protected final SerializerFactory _serializerFactory;
    protected final DefaultSerializerProvider _serializerProvider;

    public final class GeneratorSettings implements Serializable {
        public static final GeneratorSettings empty = new GeneratorSettings(null, null, null, null);
        private static final long serialVersionUID = 1;
        public final CharacterEscapes characterEscapes;
        public final PrettyPrinter prettyPrinter;
        public final SerializableString rootValueSeparator;
        public final FormatSchema schema;

        public GeneratorSettings(PrettyPrinter prettyPrinter, FormatSchema formatSchema, CharacterEscapes characterEscapes, SerializableString serializableString) {
            this.prettyPrinter = prettyPrinter;
            this.schema = formatSchema;
            this.characterEscapes = characterEscapes;
            this.rootValueSeparator = serializableString;
        }

        public void initialize(JsonGenerator jsonGenerator) {
            PrettyPrinter prettyPrinter = this.prettyPrinter;
            if (this.prettyPrinter != null) {
                if (prettyPrinter == ObjectWriter.NULL_PRETTY_PRINTER) {
                    jsonGenerator.setPrettyPrinter(null);
                } else {
                    if (prettyPrinter instanceof Instantiatable) {
                        prettyPrinter = (PrettyPrinter) ((Instantiatable) prettyPrinter).createInstance();
                    }
                    jsonGenerator.setPrettyPrinter(prettyPrinter);
                }
            }
            if (this.characterEscapes != null) {
                jsonGenerator.setCharacterEscapes(this.characterEscapes);
            }
            if (this.schema != null) {
                jsonGenerator.setSchema(this.schema);
            }
            if (this.rootValueSeparator != null) {
                jsonGenerator.setRootValueSeparator(this.rootValueSeparator);
            }
        }
    }

    public final class Prefetch implements Serializable {
        public static final Prefetch empty = new Prefetch(null, null, null);
        private static final long serialVersionUID = 1;
        private final JavaType rootType;
        private final TypeSerializer typeSerializer;
        private final JsonSerializer<Object> valueSerializer;

        private Prefetch(JavaType javaType, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer) {
            this.rootType = javaType;
            this.valueSerializer = jsonSerializer;
            this.typeSerializer = typeSerializer;
        }

        public Prefetch forRootType(ObjectWriter objectWriter, JavaType javaType) {
            Object obj = 1;
            if (!(javaType == null || javaType.isJavaLangObject())) {
                obj = null;
            }
            if (obj != null) {
                return (this.rootType == null || this.valueSerializer == null) ? this : new Prefetch(null, null, this.typeSerializer);
            } else {
                if (javaType.equals(this.rootType)) {
                    return this;
                }
                if (objectWriter.isEnabled(SerializationFeature.EAGER_SERIALIZER_FETCH)) {
                    try {
                        JsonSerializer findTypedValueSerializer = objectWriter._serializerProvider().findTypedValueSerializer(javaType, true, null);
                        return findTypedValueSerializer instanceof TypeWrappedSerializer ? new Prefetch(javaType, null, ((TypeWrappedSerializer) findTypedValueSerializer).typeSerializer()) : new Prefetch(javaType, findTypedValueSerializer, null);
                    } catch (JsonProcessingException e) {
                    }
                }
                return new Prefetch(null, null, this.typeSerializer);
            }
        }

        public void serialize(JsonGenerator jsonGenerator, Object obj, DefaultSerializerProvider defaultSerializerProvider) {
            if (this.typeSerializer != null) {
                defaultSerializerProvider.serializePolymorphic(jsonGenerator, obj, this.rootType, this.valueSerializer, this.typeSerializer);
            } else if (this.valueSerializer != null) {
                defaultSerializerProvider.serializeValue(jsonGenerator, obj, this.rootType, this.valueSerializer);
            } else {
                defaultSerializerProvider.serializeValue(jsonGenerator, obj);
            }
        }
    }

    protected ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig, JavaType javaType, PrettyPrinter prettyPrinter) {
        this._config = serializationConfig;
        this._serializerProvider = objectMapper._serializerProvider;
        this._serializerFactory = objectMapper._serializerFactory;
        this._generatorFactory = objectMapper._jsonFactory;
        this._generatorSettings = prettyPrinter == null ? GeneratorSettings.empty : new GeneratorSettings(prettyPrinter, null, null, null);
        if (javaType == null || javaType.hasRawClass(Object.class)) {
            this._prefetch = Prefetch.empty;
        } else {
            this._prefetch = Prefetch.empty.forRootType(this, javaType.withStaticTyping());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0035 A:{SYNTHETIC, Splitter: B:23:0x0035} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0035 A:{SYNTHETIC, Splitter: B:23:0x0035} */
    private final void _writeCloseable(com.fasterxml.jackson.core.JsonGenerator r6, java.lang.Object r7) {
        /*
        r5 = this;
        r2 = 0;
        r0 = r7;
        r0 = (java.io.Closeable) r0;
        r1 = r5._prefetch;	 Catch:{ all -> 0x0025 }
        r3 = r5._serializerProvider();	 Catch:{ all -> 0x0025 }
        r1.serialize(r6, r7, r3);	 Catch:{ all -> 0x0025 }
        r1 = 0;
        r6.close();	 Catch:{ all -> 0x0041 }
        r3 = 0;
        r0.close();	 Catch:{ all -> 0x0047 }
        if (r2 == 0) goto L_0x001f;
    L_0x0017:
        r0 = com.fasterxml.jackson.core.JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT;
        r2.disable(r0);
        r1.close();	 Catch:{ IOException -> 0x0039 }
    L_0x001f:
        if (r2 == 0) goto L_0x0024;
    L_0x0021:
        r3.close();	 Catch:{ IOException -> 0x003b }
    L_0x0024:
        return;
    L_0x0025:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0029:
        if (r6 == 0) goto L_0x0033;
    L_0x002b:
        r2 = com.fasterxml.jackson.core.JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT;
        r6.disable(r2);
        r6.close();	 Catch:{ IOException -> 0x003d }
    L_0x0033:
        if (r1 == 0) goto L_0x0038;
    L_0x0035:
        r1.close();	 Catch:{ IOException -> 0x003f }
    L_0x0038:
        throw r0;
    L_0x0039:
        r0 = move-exception;
        goto L_0x001f;
    L_0x003b:
        r0 = move-exception;
        goto L_0x0024;
    L_0x003d:
        r2 = move-exception;
        goto L_0x0033;
    L_0x003f:
        r1 = move-exception;
        goto L_0x0038;
    L_0x0041:
        r1 = move-exception;
        r6 = r2;
        r4 = r0;
        r0 = r1;
        r1 = r4;
        goto L_0x0029;
    L_0x0047:
        r0 = move-exception;
        r1 = r2;
        r6 = r2;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ObjectWriter._writeCloseable(com.fasterxml.jackson.core.JsonGenerator, java.lang.Object):void");
    }

    protected final void _configAndWriteValue(JsonGenerator jsonGenerator, Object obj) {
        _configureGenerator(jsonGenerator);
        if (this._config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            _writeCloseable(jsonGenerator, obj);
            return;
        }
        Object obj2 = null;
        try {
            this._prefetch.serialize(jsonGenerator, obj, _serializerProvider());
            obj2 = 1;
            jsonGenerator.close();
        } catch (Throwable th) {
            if (obj2 == null) {
                jsonGenerator.disable(Feature.AUTO_CLOSE_JSON_CONTENT);
                try {
                    jsonGenerator.close();
                } catch (IOException e) {
                }
            }
        }
    }

    protected final void _configureGenerator(JsonGenerator jsonGenerator) {
        this._config.initialize(jsonGenerator);
        this._generatorSettings.initialize(jsonGenerator);
    }

    protected DefaultSerializerProvider _serializerProvider() {
        return this._serializerProvider.createInstance(this._config, this._serializerFactory);
    }

    public boolean isEnabled(SerializationFeature serializationFeature) {
        return this._config.isEnabled(serializationFeature);
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    public byte[] writeValueAsBytes(Object obj) {
        OutputStream byteArrayBuilder = new ByteArrayBuilder(this._generatorFactory._getBufferRecycler());
        try {
            _configAndWriteValue(this._generatorFactory.createGenerator(byteArrayBuilder, JsonEncoding.UTF8), obj);
            byte[] toByteArray = byteArrayBuilder.toByteArray();
            byteArrayBuilder.release();
            return toByteArray;
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }
}
