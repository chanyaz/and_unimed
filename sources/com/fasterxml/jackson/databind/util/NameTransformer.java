package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public abstract class NameTransformer {
    public static final NameTransformer NOP = new NopTransformer();

    public class Chained extends NameTransformer implements Serializable {
        private static final long serialVersionUID = 1;
        protected final NameTransformer _t1;
        protected final NameTransformer _t2;

        public Chained(NameTransformer nameTransformer, NameTransformer nameTransformer2) {
            this._t1 = nameTransformer;
            this._t2 = nameTransformer2;
        }

        public String toString() {
            return "[ChainedTransformer(" + this._t1 + ", " + this._t2 + ")]";
        }

        public String transform(String str) {
            return this._t1.transform(this._t2.transform(str));
        }
    }

    public final class NopTransformer extends NameTransformer implements Serializable {
        private static final long serialVersionUID = 1;

        protected NopTransformer() {
        }

        public String transform(String str) {
            return str;
        }
    }

    protected NameTransformer() {
    }

    public static NameTransformer chainedTransformer(NameTransformer nameTransformer, NameTransformer nameTransformer2) {
        return new Chained(nameTransformer, nameTransformer2);
    }

    public static NameTransformer simpleTransformer(final String str, final String str2) {
        Object obj = 1;
        Object obj2 = (str == null || str.length() <= 0) ? null : 1;
        if (str2 == null || str2.length() <= 0) {
            obj = null;
        }
        return obj2 != null ? obj != null ? new NameTransformer() {
            public String toString() {
                return "[PreAndSuffixTransformer('" + str + "','" + str2 + "')]";
            }

            public String transform(String str) {
                return str + str + str2;
            }
        } : new NameTransformer() {
            public String toString() {
                return "[PrefixTransformer('" + str + "')]";
            }

            public String transform(String str) {
                return str + str;
            }
        } : obj != null ? new NameTransformer() {
            public String toString() {
                return "[SuffixTransformer('" + str2 + "')]";
            }

            public String transform(String str) {
                return str + str2;
            }
        } : NOP;
    }

    public abstract String transform(String str);
}
