package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import java.io.Serializable;

public abstract class MapperConfigBase<CFG extends ConfigFeature, T extends MapperConfigBase<CFG, T>> extends MapperConfig<T> implements Serializable {
    private static final int DEFAULT_MAPPER_FEATURES = MapperConfig.collectFeatureDefaults(MapperFeature.class);
    protected final ContextAttributes _attributes;
    protected final SimpleMixInResolver _mixIns;
    protected final PropertyName _rootName;
    protected final RootNameLookup _rootNames;
    protected final SubtypeResolver _subtypeResolver;
    protected final Class<?> _view;

    protected MapperConfigBase(BaseSettings baseSettings, SubtypeResolver subtypeResolver, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup) {
        super(baseSettings, DEFAULT_MAPPER_FEATURES);
        this._mixIns = simpleMixInResolver;
        this._subtypeResolver = subtypeResolver;
        this._rootNames = rootNameLookup;
        this._rootName = null;
        this._view = null;
        this._attributes = ContextAttributes.getEmpty();
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, int i) {
        super((MapperConfig) mapperConfigBase, i);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
    }

    public MixInResolver copy() {
        throw new UnsupportedOperationException();
    }

    public final Class<?> findMixInClassFor(Class<?> cls) {
        return this._mixIns.findMixInClassFor(cls);
    }

    public PropertyName findRootName(JavaType javaType) {
        return this._rootName != null ? this._rootName : this._rootNames.findRootName(javaType, (MapperConfig) this);
    }

    public PropertyName findRootName(Class<?> cls) {
        return this._rootName != null ? this._rootName : this._rootNames.findRootName((Class) cls, (MapperConfig) this);
    }

    public final Class<?> getActiveView() {
        return this._view;
    }

    public final ContextAttributes getAttributes() {
        return this._attributes;
    }

    public final PropertyName getFullRootName() {
        return this._rootName;
    }

    public final SubtypeResolver getSubtypeResolver() {
        return this._subtypeResolver;
    }
}
