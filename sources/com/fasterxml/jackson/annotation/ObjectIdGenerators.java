package com.fasterxml.jackson.annotation;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import java.util.UUID;

public class ObjectIdGenerators {

    abstract class Base<T> extends ObjectIdGenerator<T> {
        protected final Class<?> _scope;

        protected Base(Class<?> cls) {
            this._scope = cls;
        }

        public boolean canUseFor(ObjectIdGenerator<?> objectIdGenerator) {
            return objectIdGenerator.getClass() == getClass() && objectIdGenerator.getScope() == this._scope;
        }

        public final Class<?> getScope() {
            return this._scope;
        }
    }

    public final class IntSequenceGenerator extends Base<Integer> {
        private static final long serialVersionUID = 1;
        protected transient int _nextValue;

        public IntSequenceGenerator() {
            this(Object.class, -1);
        }

        public IntSequenceGenerator(Class<?> cls, int i) {
            super(cls);
            this._nextValue = i;
        }

        public ObjectIdGenerator<Integer> forScope(Class<?> cls) {
            return this._scope == cls ? this : new IntSequenceGenerator(cls, this._nextValue);
        }

        public Integer generateId(Object obj) {
            if (obj == null) {
                return null;
            }
            int i = this._nextValue;
            this._nextValue++;
            return Integer.valueOf(i);
        }

        protected int initialValue() {
            return 1;
        }

        public IdKey key(Object obj) {
            return obj == null ? null : new IdKey(getClass(), this._scope, obj);
        }

        public ObjectIdGenerator<Integer> newForSerialization(Object obj) {
            return new IntSequenceGenerator(this._scope, initialValue());
        }
    }

    public abstract class None extends ObjectIdGenerator<Object> {
    }

    public abstract class PropertyGenerator extends Base<Object> {
        private static final long serialVersionUID = 1;

        protected PropertyGenerator(Class<?> cls) {
            super(cls);
        }
    }

    public final class StringIdGenerator extends Base<String> {
        private static final long serialVersionUID = 1;

        public StringIdGenerator() {
            this(Object.class);
        }

        private StringIdGenerator(Class<?> cls) {
            super(Object.class);
        }

        public boolean canUseFor(ObjectIdGenerator<?> objectIdGenerator) {
            return objectIdGenerator instanceof StringIdGenerator;
        }

        public ObjectIdGenerator<String> forScope(Class<?> cls) {
            return this;
        }

        public String generateId(Object obj) {
            return UUID.randomUUID().toString();
        }

        public IdKey key(Object obj) {
            return obj == null ? null : new IdKey(getClass(), null, obj);
        }

        public ObjectIdGenerator<String> newForSerialization(Object obj) {
            return this;
        }
    }

    public final class UUIDGenerator extends Base<UUID> {
        private static final long serialVersionUID = 1;

        public UUIDGenerator() {
            this(Object.class);
        }

        private UUIDGenerator(Class<?> cls) {
            super(Object.class);
        }

        public boolean canUseFor(ObjectIdGenerator<?> objectIdGenerator) {
            return objectIdGenerator.getClass() == getClass();
        }

        public ObjectIdGenerator<UUID> forScope(Class<?> cls) {
            return this;
        }

        public UUID generateId(Object obj) {
            return UUID.randomUUID();
        }

        public IdKey key(Object obj) {
            return obj == null ? null : new IdKey(getClass(), null, obj);
        }

        public ObjectIdGenerator<UUID> newForSerialization(Object obj) {
            return this;
        }
    }
}
