package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

public enum zzbbj {
    DOUBLE(0, ya.SCALAR, zzbbw.DOUBLE),
    FLOAT(1, ya.SCALAR, zzbbw.FLOAT),
    INT64(2, ya.SCALAR, zzbbw.LONG),
    UINT64(3, ya.SCALAR, zzbbw.LONG),
    INT32(4, ya.SCALAR, zzbbw.INT),
    FIXED64(5, ya.SCALAR, zzbbw.LONG),
    FIXED32(6, ya.SCALAR, zzbbw.INT),
    BOOL(7, ya.SCALAR, zzbbw.BOOLEAN),
    STRING(8, ya.SCALAR, zzbbw.STRING),
    MESSAGE(9, ya.SCALAR, zzbbw.MESSAGE),
    BYTES(10, ya.SCALAR, zzbbw.BYTE_STRING),
    UINT32(11, ya.SCALAR, zzbbw.INT),
    ENUM(12, ya.SCALAR, zzbbw.ENUM),
    SFIXED32(13, ya.SCALAR, zzbbw.INT),
    SFIXED64(14, ya.SCALAR, zzbbw.LONG),
    SINT32(15, ya.SCALAR, zzbbw.INT),
    SINT64(16, ya.SCALAR, zzbbw.LONG),
    GROUP(17, ya.SCALAR, zzbbw.MESSAGE),
    DOUBLE_LIST(18, ya.VECTOR, zzbbw.DOUBLE),
    FLOAT_LIST(19, ya.VECTOR, zzbbw.FLOAT),
    INT64_LIST(20, ya.VECTOR, zzbbw.LONG),
    UINT64_LIST(21, ya.VECTOR, zzbbw.LONG),
    INT32_LIST(22, ya.VECTOR, zzbbw.INT),
    FIXED64_LIST(23, ya.VECTOR, zzbbw.LONG),
    FIXED32_LIST(24, ya.VECTOR, zzbbw.INT),
    BOOL_LIST(25, ya.VECTOR, zzbbw.BOOLEAN),
    STRING_LIST(26, ya.VECTOR, zzbbw.STRING),
    MESSAGE_LIST(27, ya.VECTOR, zzbbw.MESSAGE),
    BYTES_LIST(28, ya.VECTOR, zzbbw.BYTE_STRING),
    UINT32_LIST(29, ya.VECTOR, zzbbw.INT),
    ENUM_LIST(30, ya.VECTOR, zzbbw.ENUM),
    SFIXED32_LIST(31, ya.VECTOR, zzbbw.INT),
    SFIXED64_LIST(32, ya.VECTOR, zzbbw.LONG),
    SINT32_LIST(33, ya.VECTOR, zzbbw.INT),
    SINT64_LIST(34, ya.VECTOR, zzbbw.LONG),
    DOUBLE_LIST_PACKED(35, ya.PACKED_VECTOR, zzbbw.DOUBLE),
    FLOAT_LIST_PACKED(36, ya.PACKED_VECTOR, zzbbw.FLOAT),
    INT64_LIST_PACKED(37, ya.PACKED_VECTOR, zzbbw.LONG),
    UINT64_LIST_PACKED(38, ya.PACKED_VECTOR, zzbbw.LONG),
    INT32_LIST_PACKED(39, ya.PACKED_VECTOR, zzbbw.INT),
    FIXED64_LIST_PACKED(40, ya.PACKED_VECTOR, zzbbw.LONG),
    FIXED32_LIST_PACKED(41, ya.PACKED_VECTOR, zzbbw.INT),
    BOOL_LIST_PACKED(42, ya.PACKED_VECTOR, zzbbw.BOOLEAN),
    UINT32_LIST_PACKED(43, ya.PACKED_VECTOR, zzbbw.INT),
    ENUM_LIST_PACKED(44, ya.PACKED_VECTOR, zzbbw.ENUM),
    SFIXED32_LIST_PACKED(45, ya.PACKED_VECTOR, zzbbw.INT),
    SFIXED64_LIST_PACKED(46, ya.PACKED_VECTOR, zzbbw.LONG),
    SINT32_LIST_PACKED(47, ya.PACKED_VECTOR, zzbbw.INT),
    SINT64_LIST_PACKED(48, ya.PACKED_VECTOR, zzbbw.LONG),
    GROUP_LIST(49, ya.VECTOR, zzbbw.MESSAGE),
    MAP(50, ya.MAP, zzbbw.VOID);
    
    private static final zzbbj[] ae = null;
    private static final Type[] af = null;
    private final zzbbw Z;
    private final int aa;
    private final ya ab;
    private final Class<?> ac;
    private final boolean ad;

    static {
        af = new Type[0];
        zzbbj[] values = values();
        ae = new zzbbj[values.length];
        int length = values.length;
        int i;
        while (i < length) {
            zzbbj zzbbj = values[i];
            ae[zzbbj.aa] = zzbbj;
            i++;
        }
    }

    private zzbbj(int i, ya yaVar, zzbbw zzbbw) {
        this.aa = i;
        this.ab = yaVar;
        this.Z = zzbbw;
        switch (yaVar) {
            case MAP:
                this.ac = zzbbw.a();
                break;
            case VECTOR:
                this.ac = zzbbw.a();
                break;
            default:
                this.ac = null;
                break;
        }
        boolean z = false;
        if (yaVar == ya.SCALAR) {
            switch (zzbbw) {
                case BYTE_STRING:
                case MESSAGE:
                case STRING:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.ad = z;
    }

    public final int a() {
        return this.aa;
    }
}
