package com.hand13.enums;

public enum ClassAccFlag {

    ACC_PUBLIC(0x0001),
    ACC_FINAL(0x0010),
    ACC_SUPER(0x0020),
    ACC_INTERFACE(0x0200),
    ACC_ABSTRACT(0x0400),
    ACC_SYNTHETIC(0x1000),
    ACC_ANNOTATION(0x2000),
    ACC_ENUM(0x4000);

    private short value;

    ClassAccFlag(int i) {
        value = (short) i;
    }

    public short value() {
        return value;
    }

    public static ClassAccFlag fromU2(short u2) {
        for (ClassAccFlag tag : ClassAccFlag.values()) {
            if (tag.value == u2) {
                return tag;
            }
        }
        throw new RuntimeException();
    }
}
