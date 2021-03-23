package com.hand13.constant;

import com.hand13.enums.ConstantTag;

public class ConstantStringInfo extends ConstantInfo {
    private short stringIndex;

    public ConstantStringInfo() {
        super(ConstantTag.STRING);
    }

    public short getStringIndex() {
        return stringIndex;
    }

    public void setStringIndex(short stringIndex) {
        this.stringIndex = stringIndex;
    }
}
