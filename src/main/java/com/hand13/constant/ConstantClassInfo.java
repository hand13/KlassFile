package com.hand13.constant;

import com.hand13.enums.ConstantTag;

public class ConstantClassInfo extends ConstantInfo {

    private short nameIndex;

    public ConstantClassInfo() {
        super(ConstantTag.CLASS);
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }
}
