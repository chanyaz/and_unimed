package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.TimeZone;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonFormat {

    public enum Feature {
        ACCEPT_SINGLE_VALUE_AS_ARRAY,
        WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,
        WRITE_DATES_WITH_ZONE_ID,
        WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED,
        WRITE_SORTED_MAP_ENTRIES
    }

    public class Features {
        private static final Features EMPTY = new Features(0, 0);
        private final int _disabled;
        private final int _enabled;

        private Features(int i, int i2) {
            this._enabled = i;
            this._disabled = i2;
        }

        public static Features construct(JsonFormat jsonFormat) {
            return construct(jsonFormat.with(), jsonFormat.without());
        }

        public static Features construct(Feature[] featureArr, Feature[] featureArr2) {
            int i = 0;
            int i2 = 0;
            for (Feature ordinal : featureArr) {
                i2 |= 1 << ordinal.ordinal();
            }
            int i3 = 0;
            while (i < featureArr2.length) {
                i3 |= 1 << featureArr2[i].ordinal();
                i++;
            }
            return new Features(i2, i3);
        }

        public static Features empty() {
            return EMPTY;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (obj.getClass() != getClass()) {
                return false;
            }
            Features features = (Features) obj;
            return features._enabled == this._enabled && features._disabled == this._disabled;
        }

        public Boolean get(Feature feature) {
            int ordinal = 1 << feature.ordinal();
            return (this._disabled & ordinal) != 0 ? Boolean.FALSE : (ordinal & this._enabled) != 0 ? Boolean.TRUE : null;
        }

        public int hashCode() {
            return this._disabled + this._enabled;
        }

        public Features withOverrides(Features features) {
            if (features == null) {
                return this;
            }
            int i = features._disabled;
            int i2 = features._enabled;
            if (i == 0 && i2 == 0) {
                return this;
            }
            if (this._enabled == 0 && this._disabled == 0) {
                return features;
            }
            int i3 = (this._enabled & (i ^ -1)) | i2;
            i |= (i2 ^ -1) & this._disabled;
            return (i3 == this._enabled && i == this._disabled) ? this : new Features(i3, i);
        }
    }

    public enum Shape {
        ANY,
        SCALAR,
        ARRAY,
        OBJECT,
        NUMBER,
        NUMBER_FLOAT,
        NUMBER_INT,
        STRING,
        BOOLEAN;

        public boolean isNumeric() {
            return this == NUMBER || this == NUMBER_INT || this == NUMBER_FLOAT;
        }
    }

    public class Value implements JacksonAnnotationValue<JsonFormat>, Serializable {
        private static final Value EMPTY = new Value();
        private static final long serialVersionUID = 1;
        private final Features _features;
        private final Locale _locale;
        private final String _pattern;
        private final Shape _shape;
        private transient TimeZone _timezone;
        private final String _timezoneStr;

        public Value() {
            this("", Shape.ANY, "", "", Features.empty());
        }

        public Value(JsonFormat jsonFormat) {
            this(jsonFormat.pattern(), jsonFormat.shape(), jsonFormat.locale(), jsonFormat.timezone(), Features.construct(jsonFormat));
        }

        public Value(String str, Shape shape, String str2, String str3, Features features) {
            Locale locale = (str2 == null || str2.length() == 0 || "##default".equals(str2)) ? null : new Locale(str2);
            String str4 = (str3 == null || str3.length() == 0 || "##default".equals(str3)) ? null : str3;
            this(str, shape, locale, str4, null, features);
        }

        public Value(String str, Shape shape, Locale locale, String str2, TimeZone timeZone, Features features) {
            this._pattern = str;
            if (shape == null) {
                shape = Shape.ANY;
            }
            this._shape = shape;
            this._locale = locale;
            this._timezone = timeZone;
            this._timezoneStr = str2;
            if (features == null) {
                features = Features.empty();
            }
            this._features = features;
        }

        private static <T> boolean _equal(T t, T t2) {
            return t == null ? t2 == null : t2 != null ? t.equals(t2) : false;
        }

        public static final Value empty() {
            return EMPTY;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Value value = (Value) obj;
            if (this._shape != value._shape || !this._features.equals(value._features)) {
                return false;
            }
            if (!(_equal(this._timezoneStr, value._timezoneStr) && _equal(this._pattern, value._pattern) && _equal(this._timezone, value._timezone) && _equal(this._locale, value._locale))) {
                z = false;
            }
            return z;
        }

        public Boolean getFeature(Feature feature) {
            return this._features.get(feature);
        }

        public Locale getLocale() {
            return this._locale;
        }

        public String getPattern() {
            return this._pattern;
        }

        public Shape getShape() {
            return this._shape;
        }

        public TimeZone getTimeZone() {
            TimeZone timeZone = this._timezone;
            if (timeZone != null) {
                return timeZone;
            }
            if (this._timezoneStr == null) {
                return null;
            }
            timeZone = TimeZone.getTimeZone(this._timezoneStr);
            this._timezone = timeZone;
            return timeZone;
        }

        public boolean hasLocale() {
            return this._locale != null;
        }

        public boolean hasPattern() {
            return this._pattern != null && this._pattern.length() > 0;
        }

        public int hashCode() {
            int hashCode = this._timezoneStr == null ? 1 : this._timezoneStr.hashCode();
            if (this._pattern != null) {
                hashCode ^= this._pattern.hashCode();
            }
            hashCode += this._shape.hashCode();
            if (this._locale != null) {
                hashCode ^= this._locale.hashCode();
            }
            return hashCode + this._features.hashCode();
        }

        public String toString() {
            return String.format("[pattern=%s,shape=%s,locale=%s,timezone=%s]", new Object[]{this._pattern, this._shape, this._locale, this._timezoneStr});
        }

        public Class<JsonFormat> valueFor() {
            return JsonFormat.class;
        }

        public final Value withOverrides(Value value) {
            if (value == null || value == EMPTY) {
                return this;
            }
            if (this == EMPTY) {
                return value;
            }
            TimeZone timeZone;
            String str = value._pattern;
            if (str == null || str.isEmpty()) {
                str = this._pattern;
            }
            Shape shape = value._shape;
            if (shape == Shape.ANY) {
                shape = this._shape;
            }
            Locale locale = value._locale;
            if (locale == null) {
                locale = this._locale;
            }
            Features features = this._features;
            Features withOverrides = features == null ? value._features : features.withOverrides(value._features);
            String str2 = value._timezoneStr;
            if (str2 == null || str2.isEmpty()) {
                str2 = this._timezoneStr;
                timeZone = this._timezone;
            } else {
                timeZone = value._timezone;
            }
            return new Value(str, shape, locale, str2, timeZone, withOverrides);
        }
    }

    String locale() default "##default";

    String pattern() default "";

    Shape shape() default Shape.ANY;

    String timezone() default "##default";

    Feature[] with() default {};

    Feature[] without() default {};
}
