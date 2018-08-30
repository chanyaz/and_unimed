package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer;
import com.fasterxml.jackson.databind.deser.std.AtomicReferenceDeserializer;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasicDeserializerFactory extends DeserializerFactory implements Serializable {
    private static final Class<?> CLASS_CHAR_BUFFER = CharSequence.class;
    private static final Class<?> CLASS_ITERABLE = Iterable.class;
    private static final Class<?> CLASS_MAP_ENTRY = Entry.class;
    private static final Class<?> CLASS_OBJECT = Object.class;
    private static final Class<?> CLASS_STRING = String.class;
    protected static final PropertyName UNWRAPPED_CREATOR_PARAM_NAME = new PropertyName("@JsonUnwrapped");
    static final HashMap<String, Class<? extends Collection>> _collectionFallbacks = new HashMap();
    static final HashMap<String, Class<? extends Map>> _mapFallbacks = new HashMap();
    protected final DeserializerFactoryConfig _factoryConfig;

    static {
        _mapFallbacks.put(Map.class.getName(), LinkedHashMap.class);
        _mapFallbacks.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
        _mapFallbacks.put(SortedMap.class.getName(), TreeMap.class);
        _mapFallbacks.put(NavigableMap.class.getName(), TreeMap.class);
        _mapFallbacks.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
        _collectionFallbacks.put(Collection.class.getName(), ArrayList.class);
        _collectionFallbacks.put(List.class.getName(), ArrayList.class);
        _collectionFallbacks.put(Set.class.getName(), HashSet.class);
        _collectionFallbacks.put(SortedSet.class.getName(), TreeSet.class);
        _collectionFallbacks.put(Queue.class.getName(), LinkedList.class);
        _collectionFallbacks.put("java.util.Deque", LinkedList.class);
        _collectionFallbacks.put("java.util.NavigableSet", TreeSet.class);
    }

    protected BasicDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        this._factoryConfig = deserializerFactoryConfig;
    }

    private KeyDeserializer _createEnumKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) {
        DeserializationConfig config = deserializationContext.getConfig();
        Class rawClass = javaType.getRawClass();
        BeanDescription introspect = config.introspect(javaType);
        KeyDeserializer findKeyDeserializerFromAnnotation = findKeyDeserializerFromAnnotation(deserializationContext, introspect.getClassInfo());
        if (findKeyDeserializerFromAnnotation != null) {
            return findKeyDeserializerFromAnnotation;
        }
        JsonDeserializer _findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, config, introspect);
        if (_findCustomEnumDeserializer != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, _findCustomEnumDeserializer);
        }
        _findCustomEnumDeserializer = findDeserializerFromAnnotation(deserializationContext, introspect.getClassInfo());
        if (_findCustomEnumDeserializer != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, _findCustomEnumDeserializer);
        }
        EnumResolver constructEnumResolver = constructEnumResolver(rawClass, config, introspect.findJsonValueMethod());
        AnnotationIntrospector annotationIntrospector = config.getAnnotationIntrospector();
        for (AnnotatedMethod annotatedMethod : introspect.getFactoryMethods()) {
            if (annotationIntrospector.hasCreatorAnnotation(annotatedMethod)) {
                if (annotatedMethod.getParameterCount() != 1 || !annotatedMethod.getRawReturnType().isAssignableFrom(rawClass)) {
                    throw new IllegalArgumentException("Unsuitable method (" + annotatedMethod + ") decorated with @JsonCreator (for Enum type " + rawClass.getName() + ")");
                } else if (annotatedMethod.getRawParameterType(0) != String.class) {
                    throw new IllegalArgumentException("Parameter #0 type for factory method (" + annotatedMethod + ") not suitable, must be java.lang.String");
                } else {
                    if (config.canOverrideAccessModifiers()) {
                        ClassUtil.checkAndFixAccess(annotatedMethod.getMember(), deserializationContext.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    return StdKeyDeserializers.constructEnumKeyDeserializer(constructEnumResolver, annotatedMethod);
                }
            }
        }
        return StdKeyDeserializers.constructEnumKeyDeserializer(constructEnumResolver);
    }

    private ValueInstantiator _findStdValueInstantiator(DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        return beanDescription.getBeanClass() == JsonLocation.class ? new JsonLocationInstantiator() : null;
    }

    private JavaType _mapAbstractType2(DeserializationConfig deserializationConfig, JavaType javaType) {
        Class rawClass = javaType.getRawClass();
        if (this._factoryConfig.hasAbstractTypeResolvers()) {
            for (AbstractTypeResolver findTypeMapping : this._factoryConfig.abstractTypeResolvers()) {
                JavaType findTypeMapping2 = findTypeMapping.findTypeMapping(deserializationConfig, javaType);
                if (findTypeMapping2 != null && findTypeMapping2.getRawClass() != rawClass) {
                    return findTypeMapping2;
                }
            }
        }
        return null;
    }

    protected void _addDeserializerConstructors(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, Map<AnnotatedWithParams, BeanPropertyDefinition[]> map) {
        Annotated findDefaultConstructor = beanDescription.findDefaultConstructor();
        if (findDefaultConstructor != null && (!creatorCollector.hasDefaultCreator() || annotationIntrospector.hasCreatorAnnotation(findDefaultConstructor))) {
            creatorCollector.setDefaultCreator(findDefaultConstructor);
        }
        List list = null;
        for (AnnotatedMember annotatedMember : beanDescription.getConstructors()) {
            boolean hasCreatorAnnotation = annotationIntrospector.hasCreatorAnnotation(annotatedMember);
            BeanPropertyDefinition[] beanPropertyDefinitionArr = (BeanPropertyDefinition[]) map.get(annotatedMember);
            int parameterCount = annotatedMember.getParameterCount();
            PropertyName fullName;
            AnnotatedMember parameter;
            if (parameterCount == 1) {
                BeanPropertyDefinition beanPropertyDefinition = beanPropertyDefinitionArr == null ? null : beanPropertyDefinitionArr[0];
                if (_checkIfCreatorPropertyBased(annotationIntrospector, annotatedMember, beanPropertyDefinition)) {
                    SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[1];
                    fullName = beanPropertyDefinition == null ? null : beanPropertyDefinition.getFullName();
                    parameter = annotatedMember.getParameter(0);
                    settableBeanPropertyArr[0] = constructCreatorProperty(deserializationContext, beanDescription, fullName, 0, parameter, annotationIntrospector.findInjectableValueId(parameter));
                    creatorCollector.addPropertyCreator(annotatedMember, hasCreatorAnnotation, settableBeanPropertyArr);
                } else {
                    _handleSingleArgumentConstructor(deserializationContext, beanDescription, visibilityChecker, annotationIntrospector, creatorCollector, annotatedMember, hasCreatorAnnotation, visibilityChecker.isCreatorVisible(annotatedMember));
                    if (beanPropertyDefinition != null) {
                        ((POJOPropertyBuilder) beanPropertyDefinition).removeConstructors();
                    }
                }
            } else {
                int i;
                List list2;
                AnnotatedMember annotatedMember2 = null;
                SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[parameterCount];
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i5 < parameterCount) {
                    int i6;
                    int i7;
                    parameter = annotatedMember.getParameter(i5);
                    BeanPropertyDefinition beanPropertyDefinition2 = beanPropertyDefinitionArr == null ? null : beanPropertyDefinitionArr[i5];
                    Object findInjectableValueId = annotationIntrospector.findInjectableValueId(parameter);
                    fullName = beanPropertyDefinition2 == null ? null : beanPropertyDefinition2.getFullName();
                    if (beanPropertyDefinition2 != null && beanPropertyDefinition2.isExplicitlyNamed()) {
                        i2++;
                        settableBeanPropertyArr2[i5] = constructCreatorProperty(deserializationContext, beanDescription, fullName, i5, parameter, findInjectableValueId);
                        i = i4;
                        i6 = i3;
                        i7 = i2;
                        parameter = annotatedMember2;
                    } else if (findInjectableValueId != null) {
                        i4++;
                        settableBeanPropertyArr2[i5] = constructCreatorProperty(deserializationContext, beanDescription, fullName, i5, parameter, findInjectableValueId);
                        i = i4;
                        i6 = i3;
                        i7 = i2;
                        parameter = annotatedMember2;
                    } else if (annotationIntrospector.findUnwrappingNameTransformer(parameter) != null) {
                        settableBeanPropertyArr2[i5] = constructCreatorProperty(deserializationContext, beanDescription, UNWRAPPED_CREATOR_PARAM_NAME, i5, parameter, null);
                        i6 = i3;
                        i7 = i2 + 1;
                        parameter = annotatedMember2;
                        i = i4;
                    } else if (hasCreatorAnnotation && fullName != null && !fullName.isEmpty()) {
                        i3++;
                        settableBeanPropertyArr2[i5] = constructCreatorProperty(deserializationContext, beanDescription, fullName, i5, parameter, findInjectableValueId);
                        i = i4;
                        i6 = i3;
                        i7 = i2;
                        parameter = annotatedMember2;
                    } else if (annotatedMember2 == null) {
                        i = i4;
                        i6 = i3;
                        i7 = i2;
                    } else {
                        i = i4;
                        i6 = i3;
                        i7 = i2;
                        parameter = annotatedMember2;
                    }
                    i5++;
                    i4 = i;
                    i3 = i6;
                    i2 = i7;
                    annotatedMember2 = parameter;
                }
                i = i2 + i3;
                if (hasCreatorAnnotation || i2 > 0 || i4 > 0) {
                    if (i + i4 == parameterCount) {
                        creatorCollector.addPropertyCreator(annotatedMember, hasCreatorAnnotation, settableBeanPropertyArr2);
                    } else if (i2 == 0 && i4 + 1 == parameterCount) {
                        creatorCollector.addDelegatingCreator(annotatedMember, hasCreatorAnnotation, settableBeanPropertyArr2);
                    } else {
                        PropertyName _findImplicitParamName = _findImplicitParamName(annotatedMember2, annotationIntrospector);
                        if (_findImplicitParamName == null || _findImplicitParamName.isEmpty()) {
                            i = annotatedMember2.getIndex();
                            if (i == 0 && ClassUtil.isNonStaticInnerClass(annotatedMember.getDeclaringClass())) {
                                throw new IllegalArgumentException("Non-static inner classes like " + annotatedMember.getDeclaringClass().getName() + " can not use @JsonCreator for constructors");
                            }
                            throw new IllegalArgumentException("Argument #" + i + " of constructor " + annotatedMember + " has no property name annotation; must have name when multiple-parameter constructor annotated as Creator");
                        }
                    }
                }
                if (creatorCollector.hasDefaultCreator()) {
                    list2 = list;
                } else {
                    list2 = list == null ? new LinkedList() : list;
                    list2.add(annotatedMember);
                }
                list = list2;
            }
        }
        if (list != null && !creatorCollector.hasDelegatingCreator() && !creatorCollector.hasPropertyBasedCreator()) {
            _checkImplicitlyNamedConstructors(deserializationContext, beanDescription, visibilityChecker, annotationIntrospector, creatorCollector, list);
        }
    }

    protected void _addDeserializerFactoryMethods(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, Map<AnnotatedWithParams, BeanPropertyDefinition[]> map) {
        DeserializationConfig config = deserializationContext.getConfig();
        for (AnnotatedMethod annotatedMethod : beanDescription.getFactoryMethods()) {
            boolean hasCreatorAnnotation = annotationIntrospector.hasCreatorAnnotation(annotatedMethod);
            int parameterCount = annotatedMethod.getParameterCount();
            if (parameterCount != 0) {
                BeanPropertyDefinition[] beanPropertyDefinitionArr = (BeanPropertyDefinition[]) map.get(annotatedMethod);
                if (parameterCount == 1) {
                    if (!_checkIfCreatorPropertyBased(annotationIntrospector, annotatedMethod, beanPropertyDefinitionArr == null ? null : beanPropertyDefinitionArr[0])) {
                        _handleSingleArgumentFactory(config, beanDescription, visibilityChecker, annotationIntrospector, creatorCollector, annotatedMethod, hasCreatorAnnotation);
                    }
                } else if (!hasCreatorAnnotation) {
                    continue;
                }
                AnnotatedMember annotatedMember = null;
                SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[parameterCount];
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i4 < parameterCount) {
                    AnnotatedMember parameter = annotatedMethod.getParameter(i4);
                    BeanPropertyDefinition beanPropertyDefinition = beanPropertyDefinitionArr == null ? null : beanPropertyDefinitionArr[i4];
                    Object findInjectableValueId = annotationIntrospector.findInjectableValueId(parameter);
                    PropertyName fullName = beanPropertyDefinition == null ? null : beanPropertyDefinition.getFullName();
                    if (beanPropertyDefinition != null && beanPropertyDefinition.isExplicitlyNamed()) {
                        i2++;
                        settableBeanPropertyArr[i4] = constructCreatorProperty(deserializationContext, beanDescription, fullName, i4, parameter, findInjectableValueId);
                        parameter = annotatedMember;
                    } else if (findInjectableValueId != null) {
                        i3++;
                        settableBeanPropertyArr[i4] = constructCreatorProperty(deserializationContext, beanDescription, fullName, i4, parameter, findInjectableValueId);
                        parameter = annotatedMember;
                    } else if (annotationIntrospector.findUnwrappingNameTransformer(parameter) != null) {
                        settableBeanPropertyArr[i4] = constructCreatorProperty(deserializationContext, beanDescription, UNWRAPPED_CREATOR_PARAM_NAME, i4, parameter, null);
                        i++;
                        parameter = annotatedMember;
                    } else if (hasCreatorAnnotation && fullName != null && !fullName.isEmpty()) {
                        i++;
                        settableBeanPropertyArr[i4] = constructCreatorProperty(deserializationContext, beanDescription, fullName, i4, parameter, findInjectableValueId);
                        parameter = annotatedMember;
                    } else if (annotatedMember != null) {
                        parameter = annotatedMember;
                    }
                    i4++;
                    annotatedMember = parameter;
                }
                int i5 = i2 + i;
                if (hasCreatorAnnotation || i2 > 0 || i3 > 0) {
                    if (i5 + i3 == parameterCount) {
                        creatorCollector.addPropertyCreator(annotatedMethod, hasCreatorAnnotation, settableBeanPropertyArr);
                    } else if (i2 == 0 && i3 + 1 == parameterCount) {
                        creatorCollector.addDelegatingCreator(annotatedMethod, hasCreatorAnnotation, settableBeanPropertyArr);
                    } else {
                        throw new IllegalArgumentException("Argument #" + annotatedMember.getIndex() + " of factory method " + annotatedMethod + " has no property name annotation; must have name when multiple-parameter constructor annotated as Creator");
                    }
                }
            } else if (hasCreatorAnnotation) {
                creatorCollector.setDefaultCreator(annotatedMethod);
            }
        }
    }

    protected boolean _checkIfCreatorPropertyBased(AnnotationIntrospector annotationIntrospector, AnnotatedWithParams annotatedWithParams, BeanPropertyDefinition beanPropertyDefinition) {
        Mode findCreatorBinding = annotationIntrospector.findCreatorBinding(annotatedWithParams);
        if (findCreatorBinding == Mode.PROPERTIES) {
            return true;
        }
        if (findCreatorBinding == Mode.DELEGATING) {
            return false;
        }
        if ((beanPropertyDefinition != null && beanPropertyDefinition.isExplicitlyNamed()) || annotationIntrospector.findInjectableValueId(annotatedWithParams.getParameter(0)) != null) {
            return true;
        }
        if (beanPropertyDefinition != null) {
            String name = beanPropertyDefinition.getName();
            if (!(name == null || name.isEmpty() || !beanPropertyDefinition.couldSerialize())) {
                return true;
            }
        }
        return false;
    }

    protected void _checkImplicitlyNamedConstructors(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, List<AnnotatedConstructor> list) {
        PropertyName _findParamName;
        SettableBeanProperty[] settableBeanPropertyArr = null;
        AnnotatedWithParams annotatedWithParams = null;
        for (AnnotatedMember annotatedMember : list) {
            if (visibilityChecker.isCreatorVisible(annotatedMember)) {
                int parameterCount = annotatedMember.getParameterCount();
                SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[parameterCount];
                for (int i = 0; i < parameterCount; i++) {
                    AnnotatedParameter parameter = annotatedMember.getParameter(i);
                    _findParamName = _findParamName(parameter, annotationIntrospector);
                    if (_findParamName == null || _findParamName.isEmpty()) {
                        break;
                    }
                    settableBeanPropertyArr2[i] = constructCreatorProperty(deserializationContext, beanDescription, _findParamName, parameter.getIndex(), parameter, null);
                }
                if (annotatedWithParams != null) {
                    annotatedWithParams = null;
                    break;
                } else {
                    settableBeanPropertyArr = settableBeanPropertyArr2;
                    annotatedWithParams = annotatedMember;
                }
            }
        }
        if (annotatedWithParams != null) {
            creatorCollector.addPropertyCreator(annotatedWithParams, false, settableBeanPropertyArr);
            BasicBeanDescription basicBeanDescription = (BasicBeanDescription) beanDescription;
            for (SettableBeanProperty settableBeanProperty : settableBeanPropertyArr) {
                _findParamName = settableBeanProperty.getFullName();
                if (!basicBeanDescription.hasProperty(_findParamName)) {
                    basicBeanDescription.addProperty(SimpleBeanPropertyDefinition.construct(deserializationContext.getConfig(), settableBeanProperty.getMember(), _findParamName));
                }
            }
        }
    }

    protected ValueInstantiator _constructDefaultValueInstantiator(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        CreatorCollector creatorCollector = new CreatorCollector(beanDescription, deserializationContext.getConfig());
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        DeserializationConfig config = deserializationContext.getConfig();
        VisibilityChecker findAutoDetectVisibility = annotationIntrospector.findAutoDetectVisibility(beanDescription.getClassInfo(), config.getDefaultVisibilityChecker());
        Map _findCreatorsFromProperties = _findCreatorsFromProperties(deserializationContext, beanDescription);
        _addDeserializerFactoryMethods(deserializationContext, beanDescription, findAutoDetectVisibility, annotationIntrospector, creatorCollector, _findCreatorsFromProperties);
        if (beanDescription.getType().isConcrete()) {
            _addDeserializerConstructors(deserializationContext, beanDescription, findAutoDetectVisibility, annotationIntrospector, creatorCollector, _findCreatorsFromProperties);
        }
        return creatorCollector.constructValueInstantiator(config);
    }

    protected Map<AnnotatedWithParams, BeanPropertyDefinition[]> _findCreatorsFromProperties(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        Map<AnnotatedWithParams, BeanPropertyDefinition[]> emptyMap = Collections.emptyMap();
        for (BeanPropertyDefinition beanPropertyDefinition : beanDescription.findProperties()) {
            Iterator constructorParameters = beanPropertyDefinition.getConstructorParameters();
            while (constructorParameters.hasNext()) {
                Map<AnnotatedWithParams, BeanPropertyDefinition[]> linkedHashMap;
                AnnotatedParameter annotatedParameter = (AnnotatedParameter) constructorParameters.next();
                AnnotatedWithParams owner = annotatedParameter.getOwner();
                Object obj = (BeanPropertyDefinition[]) emptyMap.get(owner);
                int index = annotatedParameter.getIndex();
                if (obj == null) {
                    linkedHashMap = emptyMap.isEmpty() ? new LinkedHashMap() : emptyMap;
                    obj = new BeanPropertyDefinition[owner.getParameterCount()];
                    linkedHashMap.put(owner, obj);
                } else if (obj[index] != null) {
                    throw new IllegalStateException("Conflict: parameter #" + index + " of " + owner + " bound to more than one property; " + obj[index] + " vs " + beanPropertyDefinition);
                } else {
                    linkedHashMap = emptyMap;
                }
                obj[index] = beanPropertyDefinition;
                emptyMap = linkedHashMap;
            }
        }
        return emptyMap;
    }

    protected JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType arrayType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers findArrayDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findArrayDeserializer2 = findArrayDeserializer.findArrayDeserializer(arrayType, deserializationConfig, beanDescription, typeDeserializer, jsonDeserializer);
            if (findArrayDeserializer2 != null) {
                return findArrayDeserializer2;
            }
        }
        return null;
    }

    protected JsonDeserializer<Object> _findCustomBeanDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        for (Deserializers findBeanDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<Object> findBeanDeserializer2 = findBeanDeserializer.findBeanDeserializer(javaType, deserializationConfig, beanDescription);
            if (findBeanDeserializer2 != null) {
                return findBeanDeserializer2;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType collectionType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers findCollectionDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findCollectionDeserializer2 = findCollectionDeserializer.findCollectionDeserializer(collectionType, deserializationConfig, beanDescription, typeDeserializer, jsonDeserializer);
            if (findCollectionDeserializer2 != null) {
                return findCollectionDeserializer2;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers findCollectionLikeDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findCollectionLikeDeserializer2 = findCollectionLikeDeserializer.findCollectionLikeDeserializer(collectionLikeType, deserializationConfig, beanDescription, typeDeserializer, jsonDeserializer);
            if (findCollectionLikeDeserializer2 != null) {
                return findCollectionLikeDeserializer2;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        for (Deserializers findEnumDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findEnumDeserializer2 = findEnumDeserializer.findEnumDeserializer(cls, deserializationConfig, beanDescription);
            if (findEnumDeserializer2 != null) {
                return findEnumDeserializer2;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomMapDeserializer(MapType mapType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers findMapDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findMapDeserializer2 = findMapDeserializer.findMapDeserializer(mapType, deserializationConfig, beanDescription, keyDeserializer, typeDeserializer, jsonDeserializer);
            if (findMapDeserializer2 != null) {
                return findMapDeserializer2;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers findMapLikeDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findMapLikeDeserializer2 = findMapLikeDeserializer.findMapLikeDeserializer(mapLikeType, deserializationConfig, beanDescription, keyDeserializer, typeDeserializer, jsonDeserializer);
            if (findMapLikeDeserializer2 != null) {
                return findMapLikeDeserializer2;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomReferenceDeserializer(ReferenceType referenceType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers findReferenceDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findReferenceDeserializer2 = findReferenceDeserializer.findReferenceDeserializer(referenceType, deserializationConfig, beanDescription, typeDeserializer, jsonDeserializer);
            if (findReferenceDeserializer2 != null) {
                return findReferenceDeserializer2;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        for (Deserializers findTreeNodeDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findTreeNodeDeserializer2 = findTreeNodeDeserializer.findTreeNodeDeserializer(cls, deserializationConfig, beanDescription);
            if (findTreeNodeDeserializer2 != null) {
                return findTreeNodeDeserializer2;
            }
        }
        return null;
    }

    protected PropertyName _findImplicitParamName(AnnotatedParameter annotatedParameter, AnnotationIntrospector annotationIntrospector) {
        String findImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(annotatedParameter);
        return (findImplicitPropertyName == null || findImplicitPropertyName.isEmpty()) ? null : PropertyName.construct(findImplicitPropertyName);
    }

    protected PropertyName _findParamName(AnnotatedParameter annotatedParameter, AnnotationIntrospector annotationIntrospector) {
        if (!(annotatedParameter == null || annotationIntrospector == null)) {
            PropertyName findNameForDeserialization = annotationIntrospector.findNameForDeserialization(annotatedParameter);
            if (findNameForDeserialization != null) {
                return findNameForDeserialization;
            }
            String findImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(annotatedParameter);
            if (!(findImplicitPropertyName == null || findImplicitPropertyName.isEmpty())) {
                return PropertyName.construct(findImplicitPropertyName);
            }
        }
        return null;
    }

    protected JavaType _findRemappedType(DeserializationConfig deserializationConfig, Class<?> cls) {
        JavaType mapAbstractType = mapAbstractType(deserializationConfig, deserializationConfig.constructType(cls));
        return (mapAbstractType == null || mapAbstractType.hasRawClass(cls)) ? null : mapAbstractType;
    }

    protected boolean _handleSingleArgumentConstructor(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, AnnotatedConstructor annotatedConstructor, boolean z, boolean z2) {
        Class rawParameterType = annotatedConstructor.getRawParameterType(0);
        if (rawParameterType == String.class || rawParameterType == CharSequence.class) {
            if (!z && !z2) {
                return true;
            }
            creatorCollector.addStringCreator(annotatedConstructor, z);
            return true;
        } else if (rawParameterType == Integer.TYPE || rawParameterType == Integer.class) {
            if (!z && !z2) {
                return true;
            }
            creatorCollector.addIntCreator(annotatedConstructor, z);
            return true;
        } else if (rawParameterType == Long.TYPE || rawParameterType == Long.class) {
            if (!z && !z2) {
                return true;
            }
            creatorCollector.addLongCreator(annotatedConstructor, z);
            return true;
        } else if (rawParameterType == Double.TYPE || rawParameterType == Double.class) {
            if (!z && !z2) {
                return true;
            }
            creatorCollector.addDoubleCreator(annotatedConstructor, z);
            return true;
        } else if (rawParameterType == Boolean.TYPE || rawParameterType == Boolean.class) {
            if (!z && !z2) {
                return true;
            }
            creatorCollector.addBooleanCreator(annotatedConstructor, z);
            return true;
        } else if (!z) {
            return false;
        } else {
            creatorCollector.addDelegatingCreator(annotatedConstructor, z, null);
            return true;
        }
    }

    protected boolean _handleSingleArgumentFactory(DeserializationConfig deserializationConfig, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, AnnotatedMethod annotatedMethod, boolean z) {
        Class rawParameterType = annotatedMethod.getRawParameterType(0);
        if (rawParameterType == String.class || rawParameterType == CharSequence.class) {
            if (!z && !visibilityChecker.isCreatorVisible((AnnotatedMember) annotatedMethod)) {
                return true;
            }
            creatorCollector.addStringCreator(annotatedMethod, z);
            return true;
        } else if (rawParameterType == Integer.TYPE || rawParameterType == Integer.class) {
            if (!z && !visibilityChecker.isCreatorVisible((AnnotatedMember) annotatedMethod)) {
                return true;
            }
            creatorCollector.addIntCreator(annotatedMethod, z);
            return true;
        } else if (rawParameterType == Long.TYPE || rawParameterType == Long.class) {
            if (!z && !visibilityChecker.isCreatorVisible((AnnotatedMember) annotatedMethod)) {
                return true;
            }
            creatorCollector.addLongCreator(annotatedMethod, z);
            return true;
        } else if (rawParameterType == Double.TYPE || rawParameterType == Double.class) {
            if (!z && !visibilityChecker.isCreatorVisible((AnnotatedMember) annotatedMethod)) {
                return true;
            }
            creatorCollector.addDoubleCreator(annotatedMethod, z);
            return true;
        } else if (rawParameterType == Boolean.TYPE || rawParameterType == Boolean.class) {
            if (!z && !visibilityChecker.isCreatorVisible((AnnotatedMember) annotatedMethod)) {
                return true;
            }
            creatorCollector.addBooleanCreator(annotatedMethod, z);
            return true;
        } else if (!z) {
            return false;
        } else {
            creatorCollector.addDelegatingCreator(annotatedMethod, z, null);
            return true;
        }
    }

    protected CollectionType _mapAbstractCollectionType(JavaType javaType, DeserializationConfig deserializationConfig) {
        Class cls = (Class) _collectionFallbacks.get(javaType.getRawClass().getName());
        return cls == null ? null : (CollectionType) deserializationConfig.constructSpecializedType(javaType, cls);
    }

    public ValueInstantiator _valueInstantiatorInstance(DeserializationConfig deserializationConfig, Annotated annotated, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof ValueInstantiator) {
            return (ValueInstantiator) obj;
        }
        if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (ClassUtil.isBogusClass(cls)) {
                return null;
            }
            if (ValueInstantiator.class.isAssignableFrom(cls)) {
                HandlerInstantiator handlerInstantiator = deserializationConfig.getHandlerInstantiator();
                if (handlerInstantiator != null) {
                    ValueInstantiator valueInstantiatorInstance = handlerInstantiator.valueInstantiatorInstance(deserializationConfig, annotated, cls);
                    if (valueInstantiatorInstance != null) {
                        return valueInstantiatorInstance;
                    }
                }
                return (ValueInstantiator) ClassUtil.createInstance(cls, deserializationConfig.canOverrideAccessModifiers());
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<ValueInstantiator>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
    }

    protected SettableBeanProperty constructCreatorProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, PropertyName propertyName, int i, AnnotatedParameter annotatedParameter, Object obj) {
        PropertyMetadata propertyMetadata;
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            propertyMetadata = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
        } else {
            Boolean hasRequiredMarker = annotationIntrospector.hasRequiredMarker(annotatedParameter);
            boolean z = hasRequiredMarker != null && hasRequiredMarker.booleanValue();
            propertyMetadata = PropertyMetadata.construct(z, annotationIntrospector.findPropertyDescription(annotatedParameter), annotationIntrospector.findPropertyIndex(annotatedParameter), annotationIntrospector.findPropertyDefaultValue(annotatedParameter));
        }
        JavaType resolveType = beanDescription.resolveType(annotatedParameter.getParameterType());
        Std std = new Std(propertyName, resolveType, annotationIntrospector.findWrapperName(annotatedParameter), beanDescription.getClassAnnotations(), annotatedParameter, propertyMetadata);
        JavaType resolveType2 = resolveType(deserializationContext, beanDescription, resolveType, annotatedParameter);
        Std withType = resolveType2 != resolveType ? std.withType(resolveType2) : std;
        JsonDeserializer findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, annotatedParameter);
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(deserializationContext, annotatedParameter, resolveType2);
        TypeDeserializer typeDeserializer = (TypeDeserializer) modifyTypeByAnnotation.getTypeHandler();
        SettableBeanProperty creatorProperty = new CreatorProperty(propertyName, modifyTypeByAnnotation, withType.getWrapperName(), typeDeserializer == null ? findTypeDeserializer(config, modifyTypeByAnnotation) : typeDeserializer, beanDescription.getClassAnnotations(), annotatedParameter, i, obj, propertyMetadata);
        return findDeserializerFromAnnotation != null ? creatorProperty.withValueDeserializer(deserializationContext.handlePrimaryContextualization(findDeserializerFromAnnotation, creatorProperty, modifyTypeByAnnotation)) : creatorProperty;
    }

    protected EnumResolver constructEnumResolver(Class<?> cls, DeserializationConfig deserializationConfig, AnnotatedMethod annotatedMethod) {
        if (annotatedMethod == null) {
            return deserializationConfig.isEnabled(DeserializationFeature.READ_ENUMS_USING_TO_STRING) ? EnumResolver.constructUnsafeUsingToString(cls) : EnumResolver.constructUnsafe(cls, deserializationConfig.getAnnotationIntrospector());
        } else {
            Object annotated = annotatedMethod.getAnnotated();
            if (deserializationConfig.canOverrideAccessModifiers()) {
                ClassUtil.checkAndFixAccess(annotated, deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            return EnumResolver.constructUnsafeUsingMethod(cls, annotated);
        }
    }

    public JsonDeserializer<?> createArrayDeserializer(DeserializationContext deserializationContext, ArrayType arrayType, BeanDescription beanDescription) {
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType contentType = arrayType.getContentType();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        TypeDeserializer findTypeDeserializer = typeDeserializer == null ? findTypeDeserializer(config, contentType) : typeDeserializer;
        JsonDeserializer<?> _findCustomArrayDeserializer = _findCustomArrayDeserializer(arrayType, config, beanDescription, findTypeDeserializer, jsonDeserializer);
        if (_findCustomArrayDeserializer == null) {
            if (jsonDeserializer == null) {
                Class rawClass = contentType.getRawClass();
                if (contentType.isPrimitive()) {
                    return PrimitiveArrayDeserializers.forType(rawClass);
                }
                if (rawClass == String.class) {
                    return StringArrayDeserializer.instance;
                }
            }
            _findCustomArrayDeserializer = new ObjectArrayDeserializer(arrayType, jsonDeserializer, findTypeDeserializer);
        }
        if (!this._factoryConfig.hasDeserializerModifiers()) {
            return _findCustomArrayDeserializer;
        }
        Iterator it = this._factoryConfig.deserializerModifiers().iterator();
        while (true) {
            JsonDeserializer<?> jsonDeserializer2 = _findCustomArrayDeserializer;
            if (!it.hasNext()) {
                return jsonDeserializer2;
            }
            _findCustomArrayDeserializer = ((BeanDeserializerModifier) it.next()).modifyArrayDeserializer(config, arrayType, beanDescription, jsonDeserializer2);
        }
    }

    public JsonDeserializer<?> createCollectionDeserializer(DeserializationContext deserializationContext, CollectionType collectionType, BeanDescription beanDescription) {
        JavaType contentType = collectionType.getContentType();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        TypeDeserializer findTypeDeserializer = typeDeserializer == null ? findTypeDeserializer(config, contentType) : typeDeserializer;
        JsonDeserializer<?> _findCustomCollectionDeserializer = _findCustomCollectionDeserializer(collectionType, config, beanDescription, findTypeDeserializer, jsonDeserializer);
        if (_findCustomCollectionDeserializer == null) {
            Class rawClass = collectionType.getRawClass();
            if (jsonDeserializer == null && EnumSet.class.isAssignableFrom(rawClass)) {
                _findCustomCollectionDeserializer = new EnumSetDeserializer(contentType, null);
            }
        }
        if (_findCustomCollectionDeserializer == null) {
            if (collectionType.isInterface() || collectionType.isAbstract()) {
                JavaType _mapAbstractCollectionType = _mapAbstractCollectionType(collectionType, config);
                if (_mapAbstractCollectionType != null) {
                    beanDescription = config.introspectForCreation(_mapAbstractCollectionType);
                    JavaType javaType = _mapAbstractCollectionType;
                } else if (collectionType.getTypeHandler() == null) {
                    throw new IllegalArgumentException("Can not find a deserializer for non-concrete Collection type " + collectionType);
                } else {
                    _findCustomCollectionDeserializer = AbstractDeserializer.constructForNonPOJO(beanDescription);
                }
            }
            if (_findCustomCollectionDeserializer == null) {
                ValueInstantiator findValueInstantiator = findValueInstantiator(deserializationContext, beanDescription);
                if (!findValueInstantiator.canCreateUsingDefault() && collectionType.getRawClass() == ArrayBlockingQueue.class) {
                    return new ArrayBlockingQueueDeserializer(collectionType, jsonDeserializer, findTypeDeserializer, findValueInstantiator);
                }
                _findCustomCollectionDeserializer = contentType.getRawClass() == String.class ? new StringCollectionDeserializer(collectionType, jsonDeserializer, findValueInstantiator) : new CollectionDeserializer(collectionType, jsonDeserializer, findTypeDeserializer, findValueInstantiator);
            }
        }
        if (!this._factoryConfig.hasDeserializerModifiers()) {
            return _findCustomCollectionDeserializer;
        }
        Iterator it = this._factoryConfig.deserializerModifiers().iterator();
        while (true) {
            JsonDeserializer<?> jsonDeserializer2 = _findCustomCollectionDeserializer;
            if (!it.hasNext()) {
                return jsonDeserializer2;
            }
            _findCustomCollectionDeserializer = ((BeanDeserializerModifier) it.next()).modifyCollectionDeserializer(config, collectionType, beanDescription, jsonDeserializer2);
        }
    }

    public JsonDeserializer<?> createCollectionLikeDeserializer(DeserializationContext deserializationContext, CollectionLikeType collectionLikeType, BeanDescription beanDescription) {
        JavaType contentType = collectionLikeType.getContentType();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        JsonDeserializer<?> _findCustomCollectionLikeDeserializer = _findCustomCollectionLikeDeserializer(collectionLikeType, config, beanDescription, typeDeserializer == null ? findTypeDeserializer(config, contentType) : typeDeserializer, jsonDeserializer);
        if (_findCustomCollectionLikeDeserializer == null || !this._factoryConfig.hasDeserializerModifiers()) {
            return _findCustomCollectionLikeDeserializer;
        }
        Iterator it = this._factoryConfig.deserializerModifiers().iterator();
        while (true) {
            JsonDeserializer<?> jsonDeserializer2 = _findCustomCollectionLikeDeserializer;
            if (!it.hasNext()) {
                return jsonDeserializer2;
            }
            _findCustomCollectionLikeDeserializer = ((BeanDeserializerModifier) it.next()).modifyCollectionLikeDeserializer(config, collectionLikeType, beanDescription, jsonDeserializer2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
    public com.fasterxml.jackson.databind.JsonDeserializer<?> createEnumDeserializer(com.fasterxml.jackson.databind.DeserializationContext r7, com.fasterxml.jackson.databind.JavaType r8, com.fasterxml.jackson.databind.BeanDescription r9) {
        /*
        r6 = this;
        r2 = r7.getConfig();
        r3 = r8.getRawClass();
        r1 = r6._findCustomEnumDeserializer(r3, r2, r9);
        if (r1 != 0) goto L_0x00a6;
    L_0x000e:
        r0 = r9.getFactoryMethods();
        r4 = r0.iterator();
    L_0x0016:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x00a4;
    L_0x001c:
        r0 = r4.next();
        r0 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r0;
        r5 = r7.getAnnotationIntrospector();
        r5 = r5.hasCreatorAnnotation(r0);
        if (r5 == 0) goto L_0x0016;
    L_0x002c:
        r1 = r0.getParameterCount();
        r4 = 1;
        if (r1 != r4) goto L_0x0075;
    L_0x0033:
        r1 = r0.getRawReturnType();
        r1 = r1.isAssignableFrom(r3);
        if (r1 == 0) goto L_0x0075;
    L_0x003d:
        r0 = com.fasterxml.jackson.databind.deser.std.EnumDeserializer.deserializerForCreator(r2, r3, r0);
    L_0x0041:
        if (r0 != 0) goto L_0x0050;
    L_0x0043:
        r0 = new com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
        r1 = r9.findJsonValueMethod();
        r1 = r6.constructEnumResolver(r3, r2, r1);
        r0.<init>(r1);
    L_0x0050:
        r1 = r6._factoryConfig;
        r1 = r1.hasDeserializerModifiers();
        if (r1 == 0) goto L_0x00a2;
    L_0x0058:
        r1 = r6._factoryConfig;
        r1 = r1.deserializerModifiers();
        r3 = r1.iterator();
        r1 = r0;
    L_0x0063:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x00a3;
    L_0x0069:
        r0 = r3.next();
        r0 = (com.fasterxml.jackson.databind.deser.BeanDeserializerModifier) r0;
        r0 = r0.modifyEnumDeserializer(r2, r8, r9, r1);
        r1 = r0;
        goto L_0x0063;
    L_0x0075:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "Unsuitable method (";
        r2 = r2.append(r4);
        r0 = r2.append(r0);
        r2 = ") decorated with @JsonCreator (for Enum type ";
        r0 = r0.append(r2);
        r2 = r3.getName();
        r0 = r0.append(r2);
        r2 = ")";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x00a2:
        r1 = r0;
    L_0x00a3:
        return r1;
    L_0x00a4:
        r0 = r1;
        goto L_0x0041;
    L_0x00a6:
        r0 = r1;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory.createEnumDeserializer(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.BeanDescription):com.fasterxml.jackson.databind.JsonDeserializer<?>");
    }

    public KeyDeserializer createKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) {
        Iterator it;
        DeserializationConfig config = deserializationContext.getConfig();
        KeyDeserializer keyDeserializer = null;
        if (this._factoryConfig.hasKeyDeserializers()) {
            BeanDescription introspectClassAnnotations = config.introspectClassAnnotations(javaType.getRawClass());
            for (KeyDeserializers findKeyDeserializer : this._factoryConfig.keyDeserializers()) {
                keyDeserializer = findKeyDeserializer.findKeyDeserializer(javaType, config, introspectClassAnnotations);
                if (keyDeserializer != null) {
                    break;
                }
            }
        }
        if (keyDeserializer == null) {
            if (javaType.isEnumType()) {
                return _createEnumKeyDeserializer(deserializationContext, javaType);
            }
            keyDeserializer = StdKeyDeserializers.findStringBasedKeyDeserializer(config, javaType);
        }
        if (keyDeserializer == null || !this._factoryConfig.hasDeserializerModifiers()) {
            return keyDeserializer;
        }
        it = this._factoryConfig.deserializerModifiers().iterator();
        while (true) {
            KeyDeserializer keyDeserializer2 = keyDeserializer;
            if (!it.hasNext()) {
                return keyDeserializer2;
            }
            keyDeserializer = ((BeanDeserializerModifier) it.next()).modifyKeyDeserializer(config, javaType, keyDeserializer2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a8  */
    public com.fasterxml.jackson.databind.JsonDeserializer<?> createMapDeserializer(com.fasterxml.jackson.databind.DeserializationContext r15, com.fasterxml.jackson.databind.type.MapType r16, com.fasterxml.jackson.databind.BeanDescription r17) {
        /*
        r14 = this;
        r3 = r15.getConfig();
        r9 = r16.getKeyType();
        r2 = r16.getContentType();
        r7 = r2.getValueHandler();
        r7 = (com.fasterxml.jackson.databind.JsonDeserializer) r7;
        r5 = r9.getValueHandler();
        r5 = (com.fasterxml.jackson.databind.KeyDeserializer) r5;
        r1 = r2.getTypeHandler();
        r1 = (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) r1;
        if (r1 != 0) goto L_0x00f4;
    L_0x0020:
        r6 = r14.findTypeDeserializer(r3, r2);
    L_0x0024:
        r1 = r14;
        r2 = r16;
        r4 = r17;
        r8 = r1._findCustomMapDeserializer(r2, r3, r4, r5, r6, r7);
        if (r8 != 0) goto L_0x00f1;
    L_0x002f:
        r1 = r16.getRawClass();
        r2 = java.util.EnumMap.class;
        r2 = r2.isAssignableFrom(r1);
        if (r2 == 0) goto L_0x0057;
    L_0x003b:
        r2 = r9.getRawClass();
        if (r2 == 0) goto L_0x0047;
    L_0x0041:
        r2 = r2.isEnum();
        if (r2 != 0) goto L_0x004f;
    L_0x0047:
        r1 = new java.lang.IllegalArgumentException;
        r2 = "Can not construct EnumMap; generic (key) type not available";
        r1.<init>(r2);
        throw r1;
    L_0x004f:
        r8 = new com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer;
        r2 = 0;
        r0 = r16;
        r8.<init>(r0, r2, r7, r6);
    L_0x0057:
        if (r8 != 0) goto L_0x00f1;
    L_0x0059:
        r2 = r16.isInterface();
        if (r2 != 0) goto L_0x0065;
    L_0x005f:
        r2 = r16.isAbstract();
        if (r2 == 0) goto L_0x00ee;
    L_0x0065:
        r2 = _mapFallbacks;
        r1 = r1.getName();
        r1 = r2.get(r1);
        r1 = (java.lang.Class) r1;
        if (r1 == 0) goto L_0x00c5;
    L_0x0073:
        r0 = r16;
        r1 = r3.constructSpecializedType(r0, r1);
        r1 = (com.fasterxml.jackson.databind.type.MapType) r1;
        r17 = r3.introspectForCreation(r1);
        r9 = r1;
    L_0x0080:
        if (r8 != 0) goto L_0x00a0;
    L_0x0082:
        r0 = r17;
        r10 = r14.findValueInstantiator(r15, r0);
        r8 = new com.fasterxml.jackson.databind.deser.std.MapDeserializer;
        r11 = r5;
        r12 = r7;
        r13 = r6;
        r8.<init>(r9, r10, r11, r12, r13);
        r1 = r3.getAnnotationIntrospector();
        r2 = r17.getClassInfo();
        r4 = 0;
        r1 = r1.findPropertiesToIgnore(r2, r4);
        r8.setIgnorableProperties(r1);
    L_0x00a0:
        r1 = r14._factoryConfig;
        r1 = r1.hasDeserializerModifiers();
        if (r1 == 0) goto L_0x00ed;
    L_0x00a8:
        r1 = r14._factoryConfig;
        r1 = r1.deserializerModifiers();
        r2 = r1.iterator();
    L_0x00b2:
        r1 = r2.hasNext();
        if (r1 == 0) goto L_0x00ed;
    L_0x00b8:
        r1 = r2.next();
        r1 = (com.fasterxml.jackson.databind.deser.BeanDeserializerModifier) r1;
        r0 = r17;
        r8 = r1.modifyMapDeserializer(r3, r9, r0, r8);
        goto L_0x00b2;
    L_0x00c5:
        r1 = r16.getTypeHandler();
        if (r1 != 0) goto L_0x00e6;
    L_0x00cb:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Can not find a deserializer for non-concrete Map type ";
        r2 = r2.append(r3);
        r0 = r16;
        r2 = r2.append(r0);
        r2 = r2.toString();
        r1.<init>(r2);
        throw r1;
    L_0x00e6:
        r8 = com.fasterxml.jackson.databind.deser.AbstractDeserializer.constructForNonPOJO(r17);
        r9 = r16;
        goto L_0x0080;
    L_0x00ed:
        return r8;
    L_0x00ee:
        r9 = r16;
        goto L_0x0080;
    L_0x00f1:
        r9 = r16;
        goto L_0x00a0;
    L_0x00f4:
        r6 = r1;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory.createMapDeserializer(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.type.MapType, com.fasterxml.jackson.databind.BeanDescription):com.fasterxml.jackson.databind.JsonDeserializer<?>");
    }

    public JsonDeserializer<?> createMapLikeDeserializer(DeserializationContext deserializationContext, MapLikeType mapLikeType, BeanDescription beanDescription) {
        JavaType keyType = mapLikeType.getKeyType();
        JavaType contentType = mapLikeType.getContentType();
        DeserializationConfig config = deserializationContext.getConfig();
        KeyDeserializer keyDeserializer = (KeyDeserializer) keyType.getValueHandler();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        JsonDeserializer<?> _findCustomMapLikeDeserializer = _findCustomMapLikeDeserializer(mapLikeType, config, beanDescription, keyDeserializer, typeDeserializer == null ? findTypeDeserializer(config, contentType) : typeDeserializer, (JsonDeserializer) contentType.getValueHandler());
        if (_findCustomMapLikeDeserializer == null || !this._factoryConfig.hasDeserializerModifiers()) {
            return _findCustomMapLikeDeserializer;
        }
        Iterator it = this._factoryConfig.deserializerModifiers().iterator();
        while (true) {
            JsonDeserializer<?> jsonDeserializer = _findCustomMapLikeDeserializer;
            if (!it.hasNext()) {
                return jsonDeserializer;
            }
            _findCustomMapLikeDeserializer = ((BeanDeserializerModifier) it.next()).modifyMapLikeDeserializer(config, mapLikeType, beanDescription, jsonDeserializer);
        }
    }

    public JsonDeserializer<?> createReferenceDeserializer(DeserializationContext deserializationContext, ReferenceType referenceType, BeanDescription beanDescription) {
        JavaType contentType = referenceType.getContentType();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        TypeDeserializer findTypeDeserializer = typeDeserializer == null ? findTypeDeserializer(config, contentType) : typeDeserializer;
        JsonDeserializer<?> _findCustomReferenceDeserializer = _findCustomReferenceDeserializer(referenceType, config, beanDescription, findTypeDeserializer, jsonDeserializer);
        if (_findCustomReferenceDeserializer == null && AtomicReference.class.isAssignableFrom(referenceType.getRawClass())) {
            return new AtomicReferenceDeserializer(referenceType.getReferencedType(), findTypeDeserializer, _findCustomReferenceDeserializer);
        }
        if (_findCustomReferenceDeserializer == null || !this._factoryConfig.hasDeserializerModifiers()) {
            return _findCustomReferenceDeserializer;
        }
        Iterator it = this._factoryConfig.deserializerModifiers().iterator();
        while (true) {
            JsonDeserializer<?> jsonDeserializer2 = _findCustomReferenceDeserializer;
            if (!it.hasNext()) {
                return jsonDeserializer2;
            }
            _findCustomReferenceDeserializer = ((BeanDeserializerModifier) it.next()).modifyReferenceDeserializer(config, referenceType, beanDescription, jsonDeserializer2);
        }
    }

    public JsonDeserializer<?> createTreeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanDescription beanDescription) {
        Class rawClass = javaType.getRawClass();
        JsonDeserializer<?> _findCustomTreeNodeDeserializer = _findCustomTreeNodeDeserializer(rawClass, deserializationConfig, beanDescription);
        return _findCustomTreeNodeDeserializer != null ? _findCustomTreeNodeDeserializer : JsonNodeDeserializer.getDeserializer(rawClass);
    }

    public JsonDeserializer<?> findDefaultDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        Class rawClass = javaType.getRawClass();
        JavaType _findRemappedType;
        JavaType _findRemappedType2;
        if (rawClass == CLASS_OBJECT) {
            DeserializationConfig config = deserializationContext.getConfig();
            if (this._factoryConfig.hasAbstractTypeResolvers()) {
                _findRemappedType = _findRemappedType(config, List.class);
                _findRemappedType2 = _findRemappedType(config, Map.class);
            } else {
                _findRemappedType2 = null;
                _findRemappedType = null;
            }
            return new UntypedObjectDeserializer(_findRemappedType, _findRemappedType2);
        } else if (rawClass == CLASS_STRING || rawClass == CLASS_CHAR_BUFFER) {
            return StringDeserializer.instance;
        } else {
            if (rawClass == CLASS_ITERABLE) {
                TypeFactory typeFactory = deserializationContext.getTypeFactory();
                JavaType[] findTypeParameters = typeFactory.findTypeParameters(javaType, CLASS_ITERABLE);
                _findRemappedType2 = (findTypeParameters == null || findTypeParameters.length != 1) ? TypeFactory.unknownType() : findTypeParameters[0];
                return createCollectionDeserializer(deserializationContext, typeFactory.constructCollectionType(Collection.class, _findRemappedType2), beanDescription);
            } else if (rawClass == CLASS_MAP_ENTRY) {
                _findRemappedType2 = javaType.containedType(0);
                _findRemappedType = _findRemappedType2 == null ? TypeFactory.unknownType() : _findRemappedType2;
                _findRemappedType2 = javaType.containedType(1);
                JavaType unknownType = _findRemappedType2 == null ? TypeFactory.unknownType() : _findRemappedType2;
                TypeDeserializer typeDeserializer = (TypeDeserializer) unknownType.getTypeHandler();
                return new MapEntryDeserializer(javaType, (KeyDeserializer) _findRemappedType.getValueHandler(), (JsonDeserializer) unknownType.getValueHandler(), typeDeserializer == null ? findTypeDeserializer(deserializationContext.getConfig(), unknownType) : typeDeserializer);
            } else {
                JsonDeserializer<?> find;
                String name = rawClass.getName();
                if (rawClass.isPrimitive() || name.startsWith("java.")) {
                    find = NumberDeserializers.find(rawClass, name);
                    if (find == null) {
                        find = DateDeserializers.find(rawClass, name);
                    }
                    if (find != null) {
                        return find;
                    }
                }
                if (rawClass == TokenBuffer.class) {
                    return new TokenBufferDeserializer();
                }
                find = findOptionalStdDeserializer(deserializationContext, javaType, beanDescription);
                return find == null ? JdkDeserializers.find(rawClass, name) : find;
            }
        }
    }

    protected JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext deserializationContext, Annotated annotated) {
        Object findDeserializer = deserializationContext.getAnnotationIntrospector().findDeserializer(annotated);
        return findDeserializer == null ? null : deserializationContext.deserializerInstance(annotated, findDeserializer);
    }

    protected KeyDeserializer findKeyDeserializerFromAnnotation(DeserializationContext deserializationContext, Annotated annotated) {
        Object findKeyDeserializer = deserializationContext.getAnnotationIntrospector().findKeyDeserializer(annotated);
        return findKeyDeserializer == null ? null : deserializationContext.keyDeserializerInstance(annotated, findKeyDeserializer);
    }

    protected JsonDeserializer<?> findOptionalStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        return OptionalHandlerFactory.instance.findDeserializer(javaType, deserializationContext.getConfig(), beanDescription);
    }

    public TypeDeserializer findPropertyContentTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) {
        TypeResolverBuilder findPropertyContentTypeResolver = deserializationConfig.getAnnotationIntrospector().findPropertyContentTypeResolver(deserializationConfig, annotatedMember, javaType);
        JavaType contentType = javaType.getContentType();
        return findPropertyContentTypeResolver == null ? findTypeDeserializer(deserializationConfig, contentType) : findPropertyContentTypeResolver.buildTypeDeserializer(deserializationConfig, contentType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, annotatedMember, contentType));
    }

    public TypeDeserializer findPropertyTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) {
        TypeResolverBuilder findPropertyTypeResolver = deserializationConfig.getAnnotationIntrospector().findPropertyTypeResolver(deserializationConfig, annotatedMember, javaType);
        return findPropertyTypeResolver == null ? findTypeDeserializer(deserializationConfig, javaType) : findPropertyTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, annotatedMember, javaType));
    }

    public TypeDeserializer findTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) {
        Collection collection = null;
        AnnotatedClass classInfo = deserializationConfig.introspectClassAnnotations(javaType.getRawClass()).getClassInfo();
        TypeResolverBuilder findTypeResolver = deserializationConfig.getAnnotationIntrospector().findTypeResolver(deserializationConfig, classInfo, javaType);
        if (findTypeResolver == null) {
            findTypeResolver = deserializationConfig.getDefaultTyper(javaType);
            if (findTypeResolver == null) {
                return null;
            }
        }
        collection = deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, classInfo);
        if (findTypeResolver.getDefaultImpl() == null && javaType.isAbstract()) {
            JavaType mapAbstractType = mapAbstractType(deserializationConfig, javaType);
            if (!(mapAbstractType == null || mapAbstractType.getRawClass() == javaType.getRawClass())) {
                findTypeResolver = findTypeResolver.defaultImpl(mapAbstractType.getRawClass());
            }
        }
        return findTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, collection);
    }

    public ValueInstantiator findValueInstantiator(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        ValueInstantiator valueInstantiator;
        DeserializationConfig config = deserializationContext.getConfig();
        ValueInstantiator valueInstantiator2 = null;
        Annotated classInfo = beanDescription.getClassInfo();
        Object findValueInstantiator = deserializationContext.getAnnotationIntrospector().findValueInstantiator(classInfo);
        if (findValueInstantiator != null) {
            valueInstantiator2 = _valueInstantiatorInstance(config, classInfo, findValueInstantiator);
        }
        if (valueInstantiator2 == null) {
            valueInstantiator2 = _findStdValueInstantiator(config, beanDescription);
            if (valueInstantiator2 == null) {
                valueInstantiator2 = _constructDefaultValueInstantiator(deserializationContext, beanDescription);
            }
        }
        if (this._factoryConfig.hasValueInstantiators()) {
            valueInstantiator = valueInstantiator2;
            for (ValueInstantiators valueInstantiators : this._factoryConfig.valueInstantiators()) {
                valueInstantiator = valueInstantiators.findValueInstantiator(config, beanDescription, valueInstantiator);
                if (valueInstantiator == null) {
                    throw JsonMappingException.from(deserializationContext.getParser(), "Broken registered ValueInstantiators (of type " + valueInstantiators.getClass().getName() + "): returned null ValueInstantiator");
                }
            }
        }
        valueInstantiator = valueInstantiator2;
        if (valueInstantiator.getIncompleteParameter() == null) {
            return valueInstantiator;
        }
        AnnotatedParameter incompleteParameter = valueInstantiator.getIncompleteParameter();
        throw new IllegalArgumentException("Argument #" + incompleteParameter.getIndex() + " of constructor " + incompleteParameter.getOwner() + " has no property name annotation; must have name when multiple-parameter constructor annotated as Creator");
    }

    public JavaType mapAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) {
        JavaType _mapAbstractType2;
        while (true) {
            _mapAbstractType2 = _mapAbstractType2(deserializationConfig, javaType);
            if (_mapAbstractType2 == null) {
                return javaType;
            }
            Class rawClass = javaType.getRawClass();
            Class rawClass2 = _mapAbstractType2.getRawClass();
            if (rawClass != rawClass2 && rawClass.isAssignableFrom(rawClass2)) {
                javaType = _mapAbstractType2;
            }
        }
        throw new IllegalArgumentException("Invalid abstract type resolution from " + javaType + " to " + _mapAbstractType2 + ": latter is not a subtype of former");
    }

    protected <T extends JavaType> T modifyTypeByAnnotation(DeserializationContext deserializationContext, Annotated annotated, T t) {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            return t;
        }
        JavaType keyType;
        JavaType t2;
        if (t2.isMapLikeType()) {
            keyType = t2.getKeyType();
            if (keyType != null && keyType.getValueHandler() == null) {
                KeyDeserializer keyDeserializerInstance = deserializationContext.keyDeserializerInstance(annotated, annotationIntrospector.findKeyDeserializer(annotated));
                if (keyDeserializerInstance != null) {
                    t2 = ((MapLikeType) t2).withKeyValueHandler(keyDeserializerInstance);
                    t2.getKeyType();
                }
            }
        }
        keyType = t2.getContentType();
        if (keyType != null && keyType.getValueHandler() == null) {
            JsonDeserializer deserializerInstance = deserializationContext.deserializerInstance(annotated, annotationIntrospector.findContentDeserializer(annotated));
            if (deserializerInstance != null) {
                t2 = t2.withContentValueHandler(deserializerInstance);
            }
        }
        return annotationIntrospector.refineDeserializationType(deserializationContext.getConfig(), annotated, t2);
    }

    protected JavaType resolveType(DeserializationContext deserializationContext, BeanDescription beanDescription, JavaType javaType, AnnotatedMember annotatedMember) {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            return javaType;
        }
        if (javaType.isMapLikeType() && javaType.getKeyType() != null) {
            KeyDeserializer keyDeserializerInstance = deserializationContext.keyDeserializerInstance(annotatedMember, annotationIntrospector.findKeyDeserializer(annotatedMember));
            if (keyDeserializerInstance != null) {
                javaType = ((MapLikeType) javaType).withKeyValueHandler(keyDeserializerInstance);
                javaType.getKeyType();
            }
        }
        if (javaType.getContentType() != null) {
            JsonDeserializer deserializerInstance = deserializationContext.deserializerInstance(annotatedMember, annotationIntrospector.findContentDeserializer(annotatedMember));
            if (deserializerInstance != null) {
                javaType = javaType.withContentValueHandler(deserializerInstance);
            }
            if (annotatedMember instanceof AnnotatedMember) {
                TypeDeserializer findPropertyContentTypeDeserializer = findPropertyContentTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember);
                if (findPropertyContentTypeDeserializer != null) {
                    javaType = javaType.withContentTypeHandler(findPropertyContentTypeDeserializer);
                }
            }
        }
        Object findPropertyTypeDeserializer = annotatedMember instanceof AnnotatedMember ? findPropertyTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember) : findTypeDeserializer(deserializationContext.getConfig(), javaType);
        return findPropertyTypeDeserializer != null ? javaType.withTypeHandler(findPropertyTypeDeserializer) : javaType;
    }
}
