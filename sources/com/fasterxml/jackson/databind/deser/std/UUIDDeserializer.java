package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.util.Arrays;
import java.util.UUID;

public class UUIDDeserializer extends FromStringDeserializer<UUID> {
    static final int[] HEX_DIGITS = new int[127];
    private static final long serialVersionUID = 1;

    static {
        int i = 0;
        Arrays.fill(HEX_DIGITS, -1);
        for (int i2 = 0; i2 < 10; i2++) {
            HEX_DIGITS[i2 + 48] = i2;
        }
        while (i < 6) {
            HEX_DIGITS[i + 97] = i + 10;
            HEX_DIGITS[i + 65] = i + 10;
            i++;
        }
    }

    public UUIDDeserializer() {
        super(UUID.class);
    }

    static int _badChar(String str, int i, DeserializationContext deserializationContext, char c) {
        throw InvalidFormatException.from(deserializationContext.getParser(), String.format("Non-hex character '%c' (value 0x%s), not valid for UUID String: input String '%s'", new Object[]{Character.valueOf(c), Integer.toHexString(c), str}), str, UUID.class);
    }

    private void _badFormat(String str, DeserializationContext deserializationContext) {
        throw InvalidFormatException.from(deserializationContext.getParser(), String.format("UUID has to be represented by standard 36-char representation: input String '%s'", new Object[]{str}), str, handledType());
    }

    private UUID _fromBytes(byte[] bArr, DeserializationContext deserializationContext) {
        if (bArr.length == 16) {
            return new UUID(_long(bArr, 0), _long(bArr, 8));
        }
        throw InvalidFormatException.from(deserializationContext.getParser(), "Can only construct UUIDs from byte[16]; got " + bArr.length + " bytes", bArr, handledType());
    }

    private static int _int(byte[] bArr, int i) {
        return (((bArr[i] << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)) | (bArr[i + 3] & 255);
    }

    private static long _long(byte[] bArr, int i) {
        return (((long) _int(bArr, i)) << 32) | ((((long) _int(bArr, i + 4)) << 32) >>> 32);
    }

    static int byteFromChars(String str, int i, DeserializationContext deserializationContext) {
        char charAt = str.charAt(i);
        char charAt2 = str.charAt(i + 1);
        if (charAt <= 127 && charAt2 <= 127) {
            int i2 = (HEX_DIGITS[charAt] << 4) | HEX_DIGITS[charAt2];
            if (i2 >= 0) {
                return i2;
            }
        }
        return (charAt > 127 || HEX_DIGITS[charAt] < 0) ? _badChar(str, i, deserializationContext, charAt) : _badChar(str, i + 1, deserializationContext, charAt2);
    }

    static int intFromChars(String str, int i, DeserializationContext deserializationContext) {
        return (((byteFromChars(str, i, deserializationContext) << 24) + (byteFromChars(str, i + 2, deserializationContext) << 16)) + (byteFromChars(str, i + 4, deserializationContext) << 8)) + byteFromChars(str, i + 6, deserializationContext);
    }

    static int shortFromChars(String str, int i, DeserializationContext deserializationContext) {
        return (byteFromChars(str, i, deserializationContext) << 8) + byteFromChars(str, i + 2, deserializationContext);
    }

    protected UUID _deserialize(String str, DeserializationContext deserializationContext) {
        if (str.length() != 36) {
            if (str.length() == 24) {
                return _fromBytes(Base64Variants.getDefaultVariant().decode(str), deserializationContext);
            }
            _badFormat(str, deserializationContext);
        }
        if (!(str.charAt(8) == '-' && str.charAt(13) == '-' && str.charAt(18) == '-' && str.charAt(23) == '-')) {
            _badFormat(str, deserializationContext);
        }
        return new UUID(((((long) shortFromChars(str, 9, deserializationContext)) << 16) | ((long) shortFromChars(str, 14, deserializationContext))) + (((long) intFromChars(str, 0, deserializationContext)) << 32), ((((long) intFromChars(str, 28, deserializationContext)) << 32) >>> 32) | (((long) ((shortFromChars(str, 19, deserializationContext) << 16) | shortFromChars(str, 24, deserializationContext))) << 32));
    }

    protected UUID _deserializeEmbedded(Object obj, DeserializationContext deserializationContext) {
        if (obj instanceof byte[]) {
            return _fromBytes((byte[]) obj, deserializationContext);
        }
        super._deserializeEmbedded(obj, deserializationContext);
        return null;
    }
}
