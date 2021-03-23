package com.hand13.enums;

public enum MethodAccFlag {

    ACC_PUBLIC(0x0001),
    ACC_PRIVATE(0x0002),
    ACC_PROTECTED(0x0004),
    ACC_STATIC(0x0008),
    ACC_FINAL(0x0010),
    ACC_SYNCHRONIZED(0x0020),
    ACC_BRIDGE(0x0040),
    ACC_VARARGS(0x0080),
    ACC_NATIVE(0x0100),
    ACC_ABSTRACT(0x0400),
    ACC_STRICT(0x0800),
    ACC_SYNTHETIC(0x1000);

    private short value;

    MethodAccFlag(int i) {
        value = (short) i;
    }

    public short value() {
        return value;
    }

    public static MethodAccFlag fromU2(short u2) {
        for (MethodAccFlag tag : MethodAccFlag.values()) {
            if (tag.value == u2) {
                return tag;
            }
        }
        throw new RuntimeException();
    }
}
