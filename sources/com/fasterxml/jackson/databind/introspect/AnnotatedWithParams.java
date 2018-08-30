package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.annotation.Annotation;

public abstract class AnnotatedWithParams extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    protected final AnnotationMap[] _paramAnnotations;

    protected AnnotatedWithParams(TypeResolutionContext typeResolutionContext, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(typeResolutionContext, annotationMap);
        this._paramAnnotations = annotationMapArr;
    }

    public final void addOrOverrideParam(int i, Annotation annotation) {
        AnnotationMap annotationMap = this._paramAnnotations[i];
        if (annotationMap == null) {
            annotationMap = new AnnotationMap();
            this._paramAnnotations[i] = annotationMap;
        }
        annotationMap.add(annotation);
    }

    public abstract Object call();

    public abstract Object call(Object[] objArr);

    public abstract Object call1(Object obj);

    public final AnnotatedParameter getParameter(int i) {
        return new AnnotatedParameter(this, getParameterType(i), getParameterAnnotations(i), i);
    }

    public final AnnotationMap getParameterAnnotations(int i) {
        return (this._paramAnnotations == null || i < 0 || i >= this._paramAnnotations.length) ? null : this._paramAnnotations[i];
    }

    public abstract int getParameterCount();

    public abstract JavaType getParameterType(int i);

    public abstract Class<?> getRawParameterType(int i);

    protected AnnotatedParameter replaceParameterAnnotations(int i, AnnotationMap annotationMap) {
        this._paramAnnotations[i] = annotationMap;
        return getParameter(i);
    }
}
