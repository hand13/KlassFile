package com.hand13.constant;

import com.hand13.enums.ConstantTag;

import java.nio.charset.StandardCharsets;

public class ConstantUtf8Info extends ConstantInfo {

    private short length;
    private byte[] bytes;

    public ConstantUtf8Info() {
        super(ConstantTag.UTF8);
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        String str = null;
        str = new String(bytes, 0, length, StandardCharsets.UTF_8);
        return str;
    }
}
