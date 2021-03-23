package com.hand13.constant;

import com.hand13.enums.ConstantTag;

public class ConstantNameAndTypeInfo extends ConstantInfo{
    private short nameIndex;
    private short descriptorIndex;

    public ConstantNameAndTypeInfo() {
        super(ConstantTag.NAME_AND_TYPE);
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }
}
