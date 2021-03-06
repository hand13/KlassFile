package com.hand13.enums;

public enum ConstantTag {
    CLASS(7),
    FIELD_REF(9),
    METHOD_REF(10),
    INTERFACE_METHOD_REF(11),
    STRING(8),
    INTEGER(3),
    FLOAT(4),
    LONG(5),
    DOUBLE(6),
    NAME_AND_TYPE(12),
    UTF8(1),
    METHOD_HANDLE(15),
    METHOD_TYPE(16),
    INVOKE_DYNAMIC(18);

    private byte value;

    ConstantTag(int i) {
        value = (byte) i;
    }

    public byte value() {
        return value;
    }

    public static ConstantTag fromU1(byte u1) {
        for (ConstantTag tag : ConstantTag.values()) {
            if (tag.value == u1) {
                return tag;
            }
        }
        throw new RuntimeException();
    }
}
